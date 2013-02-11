/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cfa.vo.sed.builder.science;

import cfa.vo.interop.SAMPController;
import cfa.vo.interop.SAMPFactory;
import cfa.vo.interop.SAMPMessage;
import cfa.vo.iris.gui.NarrowOptionPane;
import cfa.vo.iris.sed.ExtSed;
import cfa.vo.iris.sed.SedlibSedManager;
import cfa.vo.sedlib.Segment;
import cfa.vo.sedlib.common.SedNoDataException;
import cfa.vo.sherpa.SherpaClient;
import org.astrogrid.samp.Response;
import spv.util.UnitsException;
import spv.util.XUnits;
import spv.util.YUnits;

/**
 *
 * @author olaurino
 */
public class SherpaInterpolator {

    private SherpaClient client;
    private SedlibSedManager manager;
    private SAMPController controller;
    private static String INTERPOLATE_MTYPE = "spectrum.interpolate";

    public SherpaInterpolator(SAMPController controller, SedlibSedManager manager) {
        this.client = new SherpaClient(controller);
        this.manager = manager;
        this.controller = controller;
    }

    public ExtSed interpolate(ExtSed sed, InterpolationConfig interpConf) throws Exception {
        client.findSherpa();

        if (sed.getNumberOfSegments() == 0) {
            throw new SedNoDataException();
        }

        String sherpaId = client.getSherpaId();

        if (sherpaId == null) {
            NarrowOptionPane.showMessageDialog(null,
                    "Iris could not find the Sherpa process running in the background. Please check the Troubleshooting section in the Iris documentation.",
                    "Cannot connect to Sherpa",
                    NarrowOptionPane.ERROR_MESSAGE);
            throw new Exception("Sherpa not found");
        }

        double xvalues[]={};
        double yvalues[]={};

        for (int i = 0; i < sed.getNumberOfSegments(); i++) {
            Segment oldSegment = sed.getSegment(i);
            double[] xoldvalues = oldSegment.getSpectralAxisValues();
            double[] yoldvalues = oldSegment.getFluxAxisValues();
            String xoldunits = oldSegment.getSpectralAxisUnits();
            String yoldunits = oldSegment.getFluxAxisUnits();
            double [] ynewvalues = convertYValues(yoldvalues, xoldvalues, yoldunits, xoldunits, "Jy");
            yvalues = concat(yvalues, ynewvalues);
            double [] xnewvalues = getSpectralValues(oldSegment);
            xvalues = concat(xvalues, xnewvalues);
        }
        
        String intervUnits = interpConf.getUnits();
        Double xmin = interpConf.getXMin();
        Double xmax = interpConf.getXMax();
        
        if(xmin>Double.NEGATIVE_INFINITY)
            interpConf.setXMin(convertXValues(new double[]{xmin}, intervUnits, "Angstrom")[0]);
        
        if(xmax<Double.POSITIVE_INFINITY)
            interpConf.setXMax(convertXValues(new double[]{xmax}, intervUnits, "Angstrom")[0]);

        interpConf.setX(xvalues);
        interpConf.setY(yvalues);
        SAMPMessage message = SAMPFactory.createMessage(INTERPOLATE_MTYPE, interpConf, InterpolationPayload.class);
        Response rspns = controller.callAndWait(sherpaId, message.get(), 10);
        if (client.isException(rspns)) {
            Exception ex = client.getException(rspns);
            throw ex;
        }

        InterpolationPayload response = (InterpolationPayload) SAMPFactory.get(rspns.getResult(), InterpolationPayload.class);

        Segment segment = new Segment();
        segment.setSpectralAxisValues(response.getX());
        segment.setFluxAxisValues(response.getY());
        segment.setTarget(sed.getSegment(0).getTarget());
        segment.setSpectralAxisUnits("Angstrom");
        segment.setFluxAxisUnits("Jy");
        segment.createChar().createSpectralAxis().setUcd("em.wl");
        segment.createChar().createFluxAxis().setUcd("phot.flux.density;em.wl");
        
        ExtSed newSed = manager.newSed(sed.getId() + "_" + interpConf.getMethod().replaceAll(" ", ""));
        newSed.addSegment(segment);
        newSed.checkChar();

        return newSed;

    }

    private double[] concat(double[] a, double[] b) {
        int aLen = a.length;
        int bLen = b.length;
        double[] c = new double[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    private double[] getSpectralValues(Segment segment) throws SedNoDataException, UnitsException {
        double[] values = segment.getSpectralAxisValues();
        return convertXValues(values, segment.getSpectralAxisUnits(), "Angstrom");
    }

    private double[] convertXValues(double[] values, String fromUnits, String toUnits) throws UnitsException {
        return XUnits.convert(values, new XUnits(fromUnits), new XUnits(toUnits));
    }

    private double[] convertYValues(double[] yvalues, double[] xvalues, String fromYUnits, String fromXUnits, String toUnits) throws UnitsException {
        return YUnits.convert(yvalues, xvalues, new YUnits(fromYUnits), new XUnits(fromXUnits), new YUnits(toUnits), true);
    }
}

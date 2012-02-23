/*
 * This software is distributed under a BSD license,
 * as described in the LICENSE file at the top source directory.
 */

package spv.components;

/**
 * Created by IntelliJ IDEA.
 * User: busko
 * Date: 2/13/12
 * Time: 3:03 PM
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import org.astrogrid.samp.client.MessageHandler;

import cfa.vo.iris.*;
import cfa.vo.iris.events.*;
import cfa.vo.iris.sed.SedlibSedManager;
import cfa.vo.sedlib.Segment;

import spv.controller.ManagedSpectrum2;
import spv.controller.SherpaModelManager;
import spv.fit.FittedSpectrum;


public class ModelManagerComponent implements IrisComponent {

    private IWorkspace ws;
    private IrisApplication app;
    private SherpaModelManager modelManager;
    private SedlibSedManager.ExtSed displayedSed;

    @Override
    public void init(IrisApplication app, IWorkspace workspace) {

        this.app = app;
        this.ws = workspace;

        SedEvent.getInstance().add(new SedListener() {
            public void process(final SedlibSedManager.ExtSed source, final SedCommand payload) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {

                        // Retrieve model manager from the attachment.

                        ManagedSpectrum2 managedSpectrum = (ManagedSpectrum2) source.getAttachment(IrisDisplayManager.FIT_MODEL);

                        if (managedSpectrum != null) {

                            SherpaModelManager smm = (SherpaModelManager) managedSpectrum.getModelManager();

                            // Make the component button responsive only
                            // in case this model manager is inactive.

                            if (!smm.isActive()) {
                                modelManager = smm;
                                displayedSed = source;
                            }
                        }
                    }
                });
            }
        });

        SegmentEvent.getInstance().add(new SegmentListener() {
            public void process(Segment source, final SegmentEvent.SegmentPayload payload) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    }
                });
            }
        });
    }

    @Override
    public String getName() {
        return "Model manager";
    }

    @Override
    public String getDescription() {
        return "Iris model manager";
    }

    @Override
    public ICommandLineInterface getCli() {
        return new NullCommandLineInterface("fit");
    }

    @Override
    public java.util.List<IMenuItem> getMenus() {
        VisualizerMenus visualizerMenus = new VisualizerMenus();
        return visualizerMenus;
    }

    @Override
    public java.util.List<MessageHandler> getSampHandlers() {
        return new ArrayList();
    }

    @Override
    public void shutdown() {
        if (modelManager != null) {
            modelManager.resetFitManagerReference();
            modelManager.setVisible(false);
            modelManager.setActive(false);
        }
    }

    private class VisualizerMenus extends ArrayList<IMenuItem> {

        public VisualizerMenus() {
            add(new AbstractDesktopItem("Fitting", "Sherpa model fitting", "/scratch.png", "/scratch_tiny.png") {

                public void onClick() {

                    if (modelManager != null) {

                        // Activate model manager. This will, under the hood,
                        // replace the Sed instance associated to the model
                        // manager with an instance of SEDFittedSpectrum.
                        // That will in turn trigger the visualizer to plot
                        // the data with model and residuals.

                        modelManager.execute(null);

                        // Display the model manager frame.

                        JInternalFrame frame = modelManager.getInternalFrame();
                        if (frame != null) {
                            frame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
                            ws.addFrame(frame);
                            frame.setVisible(true);
                            try {
                                frame.setSelected(true);
                            } catch (java.beans.PropertyVetoException e) {
                            }
                        }

                        // Get the fitted spectrum from the model manager.

                        FittedSpectrum fsp = modelManager.getSEDFittedSpectrum();
                        fsp.enableNotifications(true);

                        // Before attaching the new model to the Sed being displayed,
                        // we must make sure that any existing attachment with an
                        // old model gets removed first. This assumes that a Sed
                        // instance supposedly can be associated with only one
                        // model at a time, although this can change in the future.

                        if (displayedSed.getAttachment(IrisDisplayManager.FIT_MODEL) != null) {
                            displayedSed.removeAttachment(IrisDisplayManager.FIT_MODEL);
                        }

                        // Now, attach existing model and new FittedSpectrum instance to the Sed.

                        ManagedSpectrum2 msp = new ManagedSpectrum2(fsp, modelManager);
                        displayedSed.addAttachment(IrisDisplayManager.FIT_MODEL, msp);

                        // And display it.

                        SedEvent.getInstance().fire(displayedSed, SedCommand.CHANGED);
                    }
                }
            });
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ScienceFrame.java
 *
 * Created on Feb 5, 2013, 12:07:03 PM
 */
package cfa.vo.sed.builder.science;

import cfa.vo.iris.IWorkspace;
import cfa.vo.iris.IrisApplication;
import cfa.vo.iris.events.SedCommand;
import cfa.vo.iris.events.SedListener;
import cfa.vo.iris.gui.NarrowOptionPane;
import cfa.vo.iris.gui.widgets.SedList;
import cfa.vo.iris.logging.LogEntry;
import cfa.vo.iris.logging.LogEvent;
import cfa.vo.iris.sed.ExtSed;
import cfa.vo.iris.sed.SedlibSedManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;

/**
 *
 * @author olaurino
 */
public class ScienceFrame extends javax.swing.JInternalFrame implements SedListener {
    private IrisApplication app;
    private SedlibSedManager manager;
    private static String ZCONF_ATTACH = "science:z";
    private static String ICONF_ATTACH = "science:interpolation";
    
    private ExtSed sed;
    public static final String PROP_SED = "sed";

    /**
     * Get the value of sed
     *
     * @return the value of sed
     */
    public ExtSed getSed() {
        return sed;
    }

    /**
     * Set the value of sed
     *
     * @param sed new value of sed
     */
    private void setSed(ExtSed sed) {
        ExtSed oldSed = this.sed;

        if(sed==null) {
            NarrowOptionPane.showMessageDialog(null, "No SEDs open. Please start building SEDs using the SED builder", "Error", NarrowOptionPane.ERROR_MESSAGE);
            return;
        }
            
        this.sed = sed;
        ZConfig zconf = (ZConfig) sed.getAttachment(ZCONF_ATTACH);
        if(zconf==null) {
            zconf = new ZConfig();
            sed.addAttachment(ZCONF_ATTACH, zconf);
        }
        
        InterpolationConfig iconf = (InterpolationConfig) sed.getAttachment(ICONF_ATTACH);
        if(iconf==null) {
            iconf = new InterpolationConfig();
            sed.addAttachment(ICONF_ATTACH, iconf);
        }
        
        firePropertyChange(PROP_SED, oldSed, sed);
        
        setZconfig(zconf);
        setInterpConf(iconf);
    }

    
    private ZConfig zconfig;
    public static final String PROP_ZCONFIG = "zconfig";

    /**
     * Get the value of zconfig
     *
     * @return the value of zconfig
     */
    public ZConfig getZconfig() {
        return zconfig;
    }

    /**
     * Set the value of zconfig
     *
     * @param zconfig new value of zconfig
     */
    public void setZconfig(ZConfig zconfig) {
        ZConfig oldZconfig = this.zconfig;
        this.zconfig = zconfig;
        firePropertyChange(PROP_ZCONFIG, oldZconfig, zconfig);
    }

    
    /** Creates new form ScienceFrame */
    public ScienceFrame(IrisApplication app, IWorkspace ws) {
        this.app = app;
        this.manager = (SedlibSedManager) ws.getSedManager();
        initComponents();
        sedPanel.setViewportView(new SedList(ws.getSedManager()));
        setSed((ExtSed)ws.getSedManager().getSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        zField = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        sedPanel = new javax.swing.JScrollPane();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Science");

        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Redshift"));
        jPanel6.setName("jPanel6"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        zField.setName("zField"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${zconfig.redshift}"), zField, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(0.0);
        binding.setSourceUnreadableValue(0.0);
        bindingGroup.addBinding(binding);

        jLabel1.setText("Initial redshift:");
        jLabel1.setName("jLabel1"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(3, 3, 3)
                        .add(zField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(zField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setName("jPanel5"); // NOI18N

        jFormattedTextField1.setName("jFormattedTextField1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${newz}"), jFormattedTextField1, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Move to redshift:");
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(ScienceFrame.class, this);
        jButton1.setAction(actionMap.get("shiftSed")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(jFormattedTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jButton1)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jFormattedTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(36, 36, 36))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Interpolation"));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabel3.setText("Method:");
        jLabel3.setName("jLabel3"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Linear", "Nearest Neighbor", "Neville" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.method}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jLabel5.setText("X Min:");
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText("X Max:");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText("Units:");
        jLabel7.setName("jLabel7"); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Angstrom", "Hz", "keV" }));
        jComboBox2.setName("jComboBox2"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.units}"), jComboBox2, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jButton2.setAction(actionMap.get("interpolateSed")); // NOI18N
        jButton2.setText("Create new SED");
        jButton2.setName("jButton2"); // NOI18N

        jLabel4.setText("Number of Bins:");
        jLabel4.setName("jLabel4"); // NOI18N

        jFormattedTextField2.setName("jFormattedTextField2"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.NBins}"), jFormattedTextField2, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jFormattedTextField3.setName("jFormattedTextField3"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.XMin}"), jFormattedTextField3, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jFormattedTextField4.setName("jFormattedTextField4"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.XMax}"), jFormattedTextField4, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jCheckBox1.setText("Normalize after interpolation");
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${interpConf.normalize}"), jCheckBox1, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(146, 146, 146))
                    .add(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jFormattedTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(jLabel6)
                                .add(3, 3, 3)
                                .add(jFormattedTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(jLabel7))
                            .add(jFormattedTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jComboBox2, 0, 146, Short.MAX_VALUE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                                .add(24, 24, 24)
                                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jCheckBox1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jLabel6)
                    .add(jLabel7)
                    .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jFormattedTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jFormattedTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jButton2)
                    .add(jFormattedTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                .add(jCheckBox1)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Redshift and Interpolation", jPanel1);

        jSplitPane1.setRightComponent(jTabbedPane1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Open SEDs"));
        jPanel4.setName("jPanel4"); // NOI18N

        sedPanel.setBorder(null);
        sedPanel.setName("sedPanel"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 166, Short.MAX_VALUE)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, sedPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 375, Short.MAX_VALUE)
            .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(sedPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane sedPanel;
    private javax.swing.JFormattedTextField zField;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private Double newz = 0.0;
    public static final String PROP_NEWZ = "newz";

    /**
     * Get the value of newz
     *
     * @return the value of newz
     */
    public Double getNewz() {
        return newz;
    }

    /**
     * Set the value of newz
     *
     * @param newz new value of newz
     */
    public void setNewz(Double newz) {
        Double oldNewz = this.newz;
        this.newz = newz;
        firePropertyChange(PROP_NEWZ, oldNewz, newz);
    }

    

    @Override
    public void process(ExtSed source, SedCommand payload) {
        if(payload.equals(SedCommand.SELECTED) || payload.equals(SedCommand.ADDED))
            setSed(source);
    }

    private SherpaRedshifter redshifter;
    
    @Action
    public void shiftSed() {
        if(redshifter==null)
            redshifter = new SherpaRedshifter(app.getSAMPController(), manager);
        try {
            if(sed.getNumberOfSegments()==0) {
                NarrowOptionPane.showMessageDialog(null, "SED is emtpy.", "WARNING", NarrowOptionPane.WARNING_MESSAGE);
                return;
            }
            redshifter.shift(sed, zconfig.getRedshift(), newz);
            LogEvent.getInstance().fire(sed, new LogEntry("SED: "+sed+", "+zconfig+" to Redshift: "+newz+" SUCCESS", this));
        } catch (Exception ex) {
            NarrowOptionPane.showMessageDialog(null, "Error while redshifting the SED: "+ex.getMessage(), "Error", NarrowOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ScienceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private SherpaInterpolator interpolator;

    @Action
    public void interpolateSed() {
        if(interpolator==null)
            interpolator = new SherpaInterpolator(app.getSAMPController(), manager);
        try {
            if(sed.getNumberOfSegments()==0) {
                NarrowOptionPane.showMessageDialog(null, "SED is emtpy.", "WARNING", NarrowOptionPane.WARNING_MESSAGE);
                return;
            }
            interpolator.interpolate(sed, interpConf);
            LogEvent.getInstance().fire(sed, new LogEntry("SED: "+sed+", "+interpConf+" SUCCESS", this));
        } catch (Exception ex) {
            LogEvent.getInstance().fire(sed, new LogEntry("SED: "+sed+", "+interpConf+" FAILURE: "+ex.getMessage(), this));
            NarrowOptionPane.showMessageDialog(null, "Error while interpolating the SED: "+ex.getMessage(), "Error", NarrowOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ScienceFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private InterpolationConfig interpConf;
    public static final String PROP_INTERPCONF = "interpConf";

    /**
     * Get the value of interpConf
     *
     * @return the value of interpConf
     */
    public InterpolationConfig getInterpConf() {
        return interpConf;
    }

    /**
     * Set the value of interpConf
     *
     * @param interpConf new value of interpConf
     */
    public void setInterpConf(InterpolationConfig interpConf) {
        InterpolationConfig oldInterpConf = this.interpConf;
        this.interpConf = interpConf;
        firePropertyChange(PROP_INTERPCONF, oldInterpConf, interpConf);
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SampChooser.java
 *
 * Created on Apr 10, 2012, 4:34:32 PM
 */
package cfa.vo.sed.gui;

import cfa.vo.iris.IWorkspace;
import cfa.vo.iris.gui.NarrowOptionPane;
import cfa.vo.iris.sed.ExtSed;
import cfa.vo.iris.sed.SedlibSedManager;
import cfa.vo.sed.builder.SedBuilder;
import cfa.vo.sed.filters.AbstractSingleStarTableFilter;
import cfa.vo.sed.filters.NativeFileFormat;
import cfa.vo.sed.setup.PhotometryCatalogBuilder;
import cfa.vo.sed.setup.SetupBean;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jdesktop.application.Action;

/**
 *
 * @author olaurino
 */
public class SampChooser extends javax.swing.JInternalFrame {

    private IWorkspace workspace;
    private String formatName;
    private URL url;
    private SedlibSedManager sedManager;
    private ExtSed sed;

    /** Creates new form SampChooser */
    public SampChooser(String tableId, String senderId, URL url, String formatName, ExtSed sed, IWorkspace ws) {
        this.workspace = ws;
        this.formatName = formatName.equals("VOT") ? "VOTABLE" : formatName;
        this.sedManager = (SedlibSedManager) ws.getSedManager();
        this.url = url;
        this.sed = sed;
        initComponents();
        senderField.setText(senderId);
        tableField.setText(tableId);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        senderField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tableField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Incoming SAMP Message");

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(SampChooser.class, this);
        jButton1.setAction(actionMap.get("importCatalog")); // NOI18N
        jButton1.setIcon(new ImageIcon(getClass().getResource("/photometry.png")));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton2.setAction(actionMap.get("importSpectrum")); // NOI18N
        jButton2.setIcon(new ImageIcon(getClass().getResource("/spectrum.png")));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jButton3.setAction(actionMap.get("ignore")); // NOI18N
        jButton3.setIcon(new ImageIcon(getClass().getResource("/ignore.png")));
        jButton3.setBorderPainted(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setName("jButton3"); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setText("Sender");
        jLabel1.setName("jLabel1"); // NOI18N

        senderField.setEditable(false);
        senderField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senderField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        senderField.setName("senderField"); // NOI18N

        jLabel2.setText("Table Name");
        jLabel2.setName("jLabel2"); // NOI18N

        tableField.setEditable(false);
        tableField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tableField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tableField.setName("tableField"); // NOI18N

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/importing.png")));
        jLabel3.setName("jLabel3"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(senderField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 302, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(jButton3)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2))
                    .add(jLabel2)
                    .add(tableField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 302, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .add(6, 6, 6)
                .add(senderField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tableField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(41, 41, 41)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jButton2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void importCatalog() {
        try {
            AbstractSingleStarTableFilter filter = (AbstractSingleStarTableFilter) NativeFileFormat.valueOf(formatName).getFilter(url);
            PhotometryCatalogFrame catFrame = new PhotometryCatalogFrame(new PhotometryCatalogBuilder(filter, sed, 0));
            workspace.addFrame(catFrame);
            catFrame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(SampChooser.class.getName()).log(Level.SEVERE, null, ex);

            String msg;

            if (ex.getMessage().contains("Index: 0, Size: 0")) {
                msg = "Please check the input file";
            } else {
                msg = ex.getMessage();
            }

            NarrowOptionPane.showMessageDialog(workspace.getRootFrame(),
                    msg,
                    "Import Error",
                    NarrowOptionPane.ERROR_MESSAGE);
        }

        this.dispose();
    }

    @Action
    public void importSpectrum() {
        try {
            SetupBean c = new SetupBean();
            c.setPositionInFile(0);
            c.setFileLocation(url.toString());
            c.setFormatName(formatName);
            SetupFrame sf = new SetupFrame(sedManager, c, sed);
            workspace.addFrame(sf);
            sf.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(SampChooser.class.getName()).log(Level.SEVERE, null, ex);

            String msg;

            if (ex.getMessage().contains("Error reading StarTable format")) {
                msg = "Please check the input file";
            } else {
                msg = ex.getMessage();
            }

            NarrowOptionPane.showMessageDialog(workspace.getRootFrame(),
                    msg,
                    "Import Error",
                    NarrowOptionPane.ERROR_MESSAGE);
        }
        this.dispose();
    }

    @Action
    public void ignore() {
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField senderField;
    private javax.swing.JTextField tableField;
    // End of variables declaration//GEN-END:variables
}

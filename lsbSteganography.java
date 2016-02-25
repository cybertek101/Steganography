/*
 * lsbSteganography.java
 *
 * Created on October 16, 2007, 1:21 PM
 */

package my.steganography;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.omg.SendingContext.RunTime;
import javax.swing.JFrame;

/**
 *
 * @author  asmel
 */
public class lsbSteganography extends javax.swing.JFrame {
    private hideSecretMessage hsm = new hideSecretMessage();
    private extractSecretMessage esm = new extractSecretMessage();
    
    private String file1;
    private String file2;
    /** Creates new form lsbSteganography */
    public lsbSteganography() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        tbdpnHS = new javax.swing.JTabbedPane();
        pnlHS = new javax.swing.JPanel();
        btnLoadCoverImage = new javax.swing.JButton();
        scrlpnCoverImage = new javax.swing.JScrollPane();
        lblCoverImage = new javax.swing.JLabel();
        btnLoadSecretMessage = new javax.swing.JButton();
        scrlpnSecretMessage = new javax.swing.JScrollPane();
        txtareaSecretMessage = new javax.swing.JTextArea();
        pnlSaveStegoImage = new javax.swing.JPanel();
        lblSaveStegoImage = new javax.swing.JLabel();
        btnHideSecretMesssage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cmbHidingMethod = new javax.swing.JComboBox();
        pnlES = new javax.swing.JPanel();
        btnLoadStegoImage = new javax.swing.JButton();
        scrlpnStegoImageES = new javax.swing.JScrollPane();
        lblStegoImageES = new javax.swing.JLabel();
        btnExtractSecretMessage = new javax.swing.JButton();
        scrlpnSecretMessageES = new javax.swing.JScrollPane();
        txtareaSecretMessageES = new javax.swing.JTextArea();
        pnlSaveSecretMessage = new javax.swing.JPanel();
        btnSaveSecretMessage = new javax.swing.JButton();
        lblsaveSecretMessage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cmbExtractionMethod = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImage1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblImage2 = new javax.swing.JLabel();
        btnLoadImage1 = new javax.swing.JButton();
        btnLoadImage2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCompare = new javax.swing.JButton();
        lblComparisonResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("txtStego");
        btnLoadCoverImage.setText("Step 1-Load cover image");
        btnLoadCoverImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCoverImageActionPerformed(evt);
            }
        });

        lblCoverImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoverImage.setText("Cover image will be displayed here");
        lblCoverImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        scrlpnCoverImage.setViewportView(lblCoverImage);

        btnLoadSecretMessage.setText("Step 2-Load secret message");
        btnLoadSecretMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadSecretMessageActionPerformed(evt);
            }
        });

        txtareaSecretMessage.setColumns(20);
        txtareaSecretMessage.setRows(5);
        scrlpnSecretMessage.setViewportView(txtareaSecretMessage);

        lblSaveStegoImage.setText("Stego image saved in:");

        btnHideSecretMesssage.setText("Step 3-Hide secret message");
        btnHideSecretMesssage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideSecretMesssageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSaveStegoImageLayout = new javax.swing.GroupLayout(pnlSaveStegoImage);
        pnlSaveStegoImage.setLayout(pnlSaveStegoImageLayout);
        pnlSaveStegoImageLayout.setHorizontalGroup(
            pnlSaveStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaveStegoImageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaveStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHideSecretMesssage)
                    .addComponent(lblSaveStegoImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSaveStegoImageLayout.setVerticalGroup(
            pnlSaveStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaveStegoImageLayout.createSequentialGroup()
                .addComponent(btnHideSecretMesssage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaveStegoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose Hiding method"));
        cmbHidingMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Use 1 bit of 8 bits", "Use 2 bits of 8 bits", "Use 4 bits of 8 bits", "Use 6 bits of 8 bits" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbHidingMethod, 0, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cmbHidingMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHSLayout = new javax.swing.GroupLayout(pnlHS);
        pnlHS.setLayout(pnlHSLayout);
        pnlHSLayout.setHorizontalGroup(
            pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSaveStegoImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLoadCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrlpnCoverImage, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHSLayout.createSequentialGroup()
                        .addComponent(btnLoadSecretMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                    .addComponent(scrlpnSecretMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlHSLayout.setVerticalGroup(
            pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadSecretMessage)
                    .addComponent(btnLoadCoverImage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlpnSecretMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addComponent(scrlpnCoverImage, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(pnlHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSaveStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tbdpnHS.addTab("Hide", pnlHS);

        btnLoadStegoImage.setText("Step 1-Load stego image");
        btnLoadStegoImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStegoImageActionPerformed(evt);
            }
        });

        lblStegoImageES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStegoImageES.setText("Stego image will be displayed here");
        scrlpnStegoImageES.setViewportView(lblStegoImageES);

        btnExtractSecretMessage.setText("Step 2-Extract secret message");
        btnExtractSecretMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractSecretMessageActionPerformed(evt);
            }
        });

        txtareaSecretMessageES.setColumns(20);
        txtareaSecretMessageES.setRows(5);
        scrlpnSecretMessageES.setViewportView(txtareaSecretMessageES);

        btnSaveSecretMessage.setText("Step 3-Save secret message");
        btnSaveSecretMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSecretMessageActionPerformed(evt);
            }
        });

        lblsaveSecretMessage.setText("Secret message saved in:");

        javax.swing.GroupLayout pnlSaveSecretMessageLayout = new javax.swing.GroupLayout(pnlSaveSecretMessage);
        pnlSaveSecretMessage.setLayout(pnlSaveSecretMessageLayout);
        pnlSaveSecretMessageLayout.setHorizontalGroup(
            pnlSaveSecretMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaveSecretMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaveSecretMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblsaveSecretMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addGroup(pnlSaveSecretMessageLayout.createSequentialGroup()
                        .addComponent(btnSaveSecretMessage)
                        .addContainerGap(138, Short.MAX_VALUE))))
        );
        pnlSaveSecretMessageLayout.setVerticalGroup(
            pnlSaveSecretMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaveSecretMessageLayout.createSequentialGroup()
                .addComponent(btnSaveSecretMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblsaveSecretMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Choose extraction method"));
        cmbExtractionMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Use 1 bit of 8 bits", "Use 2 bits of 8 bits", "Use 4 bits of 8 bits", "Use 6 bits of 8 bits" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbExtractionMethod, 0, 250, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cmbExtractionMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlESLayout = new javax.swing.GroupLayout(pnlES);
        pnlES.setLayout(pnlESLayout);
        pnlESLayout.setHorizontalGroup(
            pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlESLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlpnStegoImageES, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(btnLoadStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSaveSecretMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrlpnSecretMessageES, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addGroup(pnlESLayout.createSequentialGroup()
                        .addComponent(btnExtractSecretMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlESLayout.setVerticalGroup(
            pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlESLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadStegoImage)
                    .addComponent(btnExtractSecretMessage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrlpnSecretMessageES, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                    .addComponent(scrlpnStegoImageES, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(pnlESLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlSaveSecretMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tbdpnHS.addTab("Extract", pnlES);

        lblImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage1.setText("Image 1");
        jScrollPane1.setViewportView(lblImage1);

        lblImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImage2.setText("Image 2");
        jScrollPane2.setViewportView(lblImage2);

        btnLoadImage1.setText("Load image 1");
        btnLoadImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImage1ActionPerformed(evt);
            }
        });

        btnLoadImage2.setText("Load image 2");
        btnLoadImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadImage2ActionPerformed(evt);
            }
        });

        btnCompare.setText("Compare Images");
        btnCompare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompareActionPerformed(evt);
            }
        });

        lblComparisonResult.setText("comparison result");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComparisonResult, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addComponent(btnCompare))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCompare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblComparisonResult, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                            .addComponent(btnLoadImage1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadImage2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadImage1)
                    .addComponent(btnLoadImage2))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tbdpnHS.addTab("Compare Images", jPanel1);

        tbdpnHS.getAccessibleContext().setAccessibleName("Hide secret message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdpnHS, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbdpnHS, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompareActionPerformed
        try {
// TODO add your handling code here:
            String cmd = "diff " + this.file1 + " " + this.file2;
            Process p = Runtime.getRuntime().exec(cmd);
            int i = 0;
            try {
                i = p.waitFor();                
                //if (i == 0){
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = br.readLine();
                    this.lblComparisonResult.setText(line);
                //}
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }                        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCompareActionPerformed

    private void btnLoadImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImage2ActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Open file");
        fc.setApproveButtonText("Open");
        
        int result = fc.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            this.file2 = file.getPath();
            try {
                BufferedImage bi = ImageIO.read(file);
                this.lblImage2.setText("");
                this.lblImage2.setIcon(new ImageIcon(bi));
            } catch (IOException ex) {
                ex.printStackTrace();
                this.lblImage2.setText("Couldn't load");
                this.lblImage2.setIcon(null);
            }            
        }
    }//GEN-LAST:event_btnLoadImage2ActionPerformed

    private void btnLoadImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadImage1ActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Open file.");
        fc.setApproveButtonText("Open");
        
        int result = fc.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            this.file1 = file.getPath();
            try {
                BufferedImage bi = ImageIO.read(file);
                this.lblImage1.setText("");
                this.lblImage1.setIcon(new ImageIcon(bi));
            } catch (IOException ex) {
                ex.printStackTrace();
                this.lblImage1.setText("Couldn't load");
                this.lblImage1.setIcon(null);
            }            
        }
    }//GEN-LAST:event_btnLoadImage1ActionPerformed

    private void btnSaveSecretMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSecretMessageActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Provide a file name to save the secrte file.");
        fc.setApproveButtonText("Save");
        
        int result = fc.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            FileWriter fw = null;
            try {
                fw = new FileWriter(file);
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw, true);
            pw.println(this.txtareaSecretMessageES.getText());
            
            this.lblsaveSecretMessage.setText("Secret message saved in:\n" + file.getPath());
        }
    }//GEN-LAST:event_btnSaveSecretMessageActionPerformed

    private void btnExtractSecretMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractSecretMessageActionPerformed
// TODO add your handling code here:       
        //check if stego image is loaded
        if (this.esm.getStegoImage() == null){
            JOptionPane.showMessageDialog(this, "Please load the stego image!", "Stego image", JOptionPane.ERROR_MESSAGE);
            return;
        }
                
        long key = Long.parseLong(JOptionPane.showInputDialog(this, "Enter the key:", "Key needed", JOptionPane.INFORMATION_MESSAGE));
        
        boolean status = this.esm.extractSecretMessage(key, this.cmbExtractionMethod.getSelectedIndex());
        if (status){
            this.txtareaSecretMessageES.setText("");
            this.txtareaSecretMessageES.setText(this.esm.getSecretMessage());
        }
        else{
            this.txtareaSecretMessageES.setText("");
            this.txtareaSecretMessageES.setText("Couldn't extract secret message. Make sure stego image is loaded");
        }
    }//GEN-LAST:event_btnExtractSecretMessageActionPerformed

    private void btnLoadStegoImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStegoImageActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            boolean status = this.esm.setStegoImage(file);
            
            if (status){
                this.lblStegoImageES.setText("");
                this.lblStegoImageES.setIcon(new ImageIcon(this.esm.getStegoImage()));
            }else{
                this.lblStegoImageES.setText("Couldn't load stego image");
                this.lblStegoImageES.setIcon(null);
            }
        }
    }//GEN-LAST:event_btnLoadStegoImageActionPerformed

    private void btnHideSecretMesssageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideSecretMesssageActionPerformed
// TODO add your handling code here:
        if (this.hsm.getCoverImage() == null){
            JOptionPane.showMessageDialog(this, "Please, load the cover image", "Cover image", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.hsm.setSecretMessage(this.txtareaSecretMessage.getText());
        //JOptionPane.showMessageDialog(this, "+" + this.hsm.getsecretMessage() + "+" + this.hsm.getsecretMessage().length(), "", JOptionPane.INFORMATION_MESSAGE);
        
        if (this.hsm.getsecretMessage().length() == 0){
            int resp = JOptionPane.showConfirmDialog(this, "You have not specified a secret message, continue?", "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resp != JOptionPane.OK_OPTION)
                return;
        }
                
        
        long key = Long.parseLong(JOptionPane.showInputDialog(this,"Enter a key:", "Key", JOptionPane.INFORMATION_MESSAGE));
        
        JFileChooser fc = new JFileChooser("");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Provide a file name to save the stego image file.");
        fc.setApproveButtonText("Save");
        
        this.lblSaveStegoImage.setText("Hiding secret message....");
        
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            boolean status = this.hsm.hideMessage(key, fc.getSelectedFile(), this.cmbHidingMethod.getSelectedIndex());
            if(status)
                this.lblSaveStegoImage.setText("Stego Image Saved in:\n" + fc.getSelectedFile().getPath());
            else{
                this.lblSaveStegoImage.setText("Couldn't save stego image");
            }
        }else{            
            boolean status = this.hsm.hideMessage(key, new File("/home/asmel/Desktop/images/newimage.png"), this.cmbHidingMethod.getSelectedIndex());
            if (status)
                this.lblSaveStegoImage.setText("Stego Image Saved in:\n" + "/home/asmel/Desktop/images/newimage.png");
            else{
                this.lblSaveStegoImage.setText("Couldn't save stego image");
            }
        }                            
    }//GEN-LAST:event_btnHideSecretMesssageActionPerformed

    private void btnLoadSecretMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadSecretMessageActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            boolean status = this.hsm.setSecretMessage(file);
            
            if (status){
                this.txtareaSecretMessage.setText("");
                this.txtareaSecretMessage.setText(this.hsm.getsecretMessage());                
            }else{
                this.txtareaSecretMessage.setText("Error loading the secret message");                
            }
        }
    }//GEN-LAST:event_btnLoadSecretMessageActionPerformed

    private void btnLoadCoverImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCoverImageActionPerformed
// TODO add your handling code here:
        JFileChooser fc = new JFileChooser("");
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            boolean status = this.hsm.setCoverImage(file);
            
            if (status){
                this.lblCoverImage.setText("");
                this.lblCoverImage.setIcon(new ImageIcon(hsm.getCoverImage()));
            }else{
                this.lblCoverImage.setText("Couldn't load cover image");
                this.lblCoverImage.setIcon(null);
            }
        }
    }//GEN-LAST:event_btnLoadCoverImageActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                lsbSteganography x = new lsbSteganography();//.setVisible(true);
                x.setExtendedState(JFrame.MAXIMIZED_BOTH);
                x.setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompare;
    private javax.swing.JButton btnExtractSecretMessage;
    private javax.swing.JButton btnHideSecretMesssage;
    private javax.swing.JButton btnLoadCoverImage;
    private javax.swing.JButton btnLoadImage1;
    private javax.swing.JButton btnLoadImage2;
    private javax.swing.JButton btnLoadSecretMessage;
    private javax.swing.JButton btnLoadStegoImage;
    private javax.swing.JButton btnSaveSecretMessage;
    private javax.swing.JComboBox cmbExtractionMethod;
    private javax.swing.JComboBox cmbHidingMethod;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblComparisonResult;
    private javax.swing.JLabel lblCoverImage;
    private javax.swing.JLabel lblImage1;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JLabel lblSaveStegoImage;
    private javax.swing.JLabel lblStegoImageES;
    private javax.swing.JLabel lblsaveSecretMessage;
    private javax.swing.JPanel pnlES;
    private javax.swing.JPanel pnlHS;
    private javax.swing.JPanel pnlSaveSecretMessage;
    private javax.swing.JPanel pnlSaveStegoImage;
    private javax.swing.JScrollPane scrlpnCoverImage;
    private javax.swing.JScrollPane scrlpnSecretMessage;
    private javax.swing.JScrollPane scrlpnSecretMessageES;
    private javax.swing.JScrollPane scrlpnStegoImageES;
    private javax.swing.JTabbedPane tbdpnHS;
    private javax.swing.JTextArea txtareaSecretMessage;
    private javax.swing.JTextArea txtareaSecretMessageES;
    // End of variables declaration//GEN-END:variables
    
}
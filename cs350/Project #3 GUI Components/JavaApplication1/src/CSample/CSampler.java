/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csampler;

import CSample.Survey;
import CSample.idGenerator;
import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.AbstractButton;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.ListModel;

/**
 *
 * @author danearing
 */
public class CSampler extends javax.swing.JFrame {
    private HashMap<Integer, Survey> surveyObjectsBuffer;

    /**
     * Creates new form CSample
     */
    public CSampler() {
        surveyList = new DefaultListModel();
        surveyObjects = new HashMap<>();
        initComponents();
        keyGen = new idGenerator();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddASurvey = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        isFed = new javax.swing.JRadioButton();
        isState = new javax.swing.JRadioButton();
        isPrivate = new javax.swing.JRadioButton();
        isSelf = new javax.swing.JRadioButton();
        isUnemployed = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        affectYes = new javax.swing.JRadioButton();
        affectNo = new javax.swing.JRadioButton();
        affectUnknown = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        submitAddASurvey = new javax.swing.JButton();
        cancelAddASurvey = new javax.swing.JButton();
        zipCode = new javax.swing.JTextField();
        blameR = new javax.swing.JCheckBox();
        blameD = new javax.swing.JCheckBox();
        blameO = new javax.swing.JCheckBox();
        blameC = new javax.swing.JCheckBox();
        participantNo = new javax.swing.JTextField();
        ModifyASurvey = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        modZipCode = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        modIsFed = new javax.swing.JRadioButton();
        modIsState = new javax.swing.JRadioButton();
        modIsPrivate = new javax.swing.JRadioButton();
        modIsSelf = new javax.swing.JRadioButton();
        modIsUnemployed = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        modImpactYes = new javax.swing.JRadioButton();
        modImpactNo = new javax.swing.JRadioButton();
        modImpactUnknown = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        modBlameR = new javax.swing.JCheckBox();
        modBlameD = new javax.swing.JCheckBox();
        modBlameO = new javax.swing.JCheckBox();
        modBlameC = new javax.swing.JCheckBox();
        modSubmit = new javax.swing.JButton();
        modCancel = new javax.swing.JButton();
        modParticipantNo = new javax.swing.JTextField();
        employmentType = new javax.swing.ButtonGroup();
        affectType = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addASurvey = new javax.swing.JButton();
        modifyASurvey = new javax.swing.JButton();
        removeASurvey = new javax.swing.JButton();
        removeAllSurveys = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        surveyListOut = new javax.swing.JList();

        AddASurvey.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        AddASurvey.setTitle("Add A Survey");
        AddASurvey.setMinimumSize(new java.awt.Dimension(552, 250));
        AddASurvey.setPreferredSize(new java.awt.Dimension(552, 250));

        jLabel6.setText("Participant No.");

        jLabel7.setText("Zip Code");

        jLabel8.setText("Employment Type");

        employmentType.add(isFed);
        isFed.setText("Federal");

        employmentType.add(isState);
        isState.setText("State/Local");

        employmentType.add(isPrivate);
        isPrivate.setText("Private");

        employmentType.add(isSelf);
        isSelf.setText("Self-Employed");

        employmentType.add(isUnemployed);
        isUnemployed.setText("Unemployed");

        jLabel9.setText("Does the government shutown affect you?");

        affectType.add(affectYes);
        affectYes.setText("Yes");

        affectType.add(affectNo);
        affectNo.setText("No");

        affectType.add(affectUnknown);
        affectUnknown.setText("Unknown");

        jLabel10.setText("Who/what is to blame for the government shutdown?");

        submitAddASurvey.setText("Submit");
        submitAddASurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitAddASurveyActionPerformed(evt);
            }
        });

        cancelAddASurvey.setText("Cancel");
        cancelAddASurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddASurveyActionPerformed(evt);
            }
        });

        blameR.setText("Republicans(R)");

        blameD.setText("Democrats(D)");

        blameO.setText("Obamacare(O)");

        blameC.setText("The Debt Ceiling(C)");

        participantNo.setEditable(false);

        javax.swing.GroupLayout AddASurveyLayout = new javax.swing.GroupLayout(AddASurvey.getContentPane());
        AddASurvey.getContentPane().setLayout(AddASurveyLayout);
        AddASurveyLayout.setHorizontalGroup(
            AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddASurveyLayout.createSequentialGroup()
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddASurveyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddASurveyLayout.createSequentialGroup()
                                .addComponent(isFed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isState)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isPrivate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isSelf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isUnemployed))
                            .addGroup(AddASurveyLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(participantNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddASurveyLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addGroup(AddASurveyLayout.createSequentialGroup()
                                .addComponent(affectYes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(affectNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(affectUnknown))
                            .addComponent(jLabel10)))
                    .addGroup(AddASurveyLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(submitAddASurvey)
                        .addGap(133, 133, 133)
                        .addComponent(cancelAddASurvey))
                    .addGroup(AddASurveyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(blameR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blameD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blameO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(blameC)))
                .addContainerGap())
        );
        AddASurveyLayout.setVerticalGroup(
            AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddASurveyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(participantNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(zipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isFed)
                    .addComponent(isState)
                    .addComponent(isPrivate)
                    .addComponent(isSelf)
                    .addComponent(isUnemployed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(affectYes)
                    .addComponent(affectNo)
                    .addComponent(affectUnknown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blameR)
                    .addComponent(blameD)
                    .addComponent(blameO)
                    .addComponent(blameC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitAddASurvey)
                    .addComponent(cancelAddASurvey)))
        );

        AddASurvey.getAccessibleContext().setAccessibleParent(null);
        pack();

        ModifyASurvey.setTitle("Modify A Survey");
        ModifyASurvey.setMinimumSize(new java.awt.Dimension(552, 250));

        jLabel12.setText("Participant No.");

        jLabel14.setText("Zip Code");

        jLabel15.setText("Employment Type");

        employmentType.add(modIsFed);
        modIsFed.setText("Federal");
        modIsFed.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        employmentType.add(modIsState);
        modIsState.setText("State/Local");

        employmentType.add(modIsPrivate);
        modIsPrivate.setText("Private");

        employmentType.add(modIsSelf);
        modIsSelf.setText("Self-Employed");

        employmentType.add(modIsUnemployed);
        modIsUnemployed.setText("Unemployed");

        jLabel16.setText("Does the government shutdown impact you?");

        affectType.add(modImpactYes);
        modImpactYes.setText("Yes");

        affectType.add(modImpactNo);
        modImpactNo.setText("No");

        affectType.add(modImpactUnknown);
        modImpactUnknown.setText("Unknown");

        jLabel17.setText("Who/what is to blame for the government shutdown?");

        modBlameR.setText("Republicans(R)");

        modBlameD.setText("Democrats(D)");

        modBlameO.setText("ObamaCare(O)");

        modBlameC.setText("The Debt Ceiling (C)");

        modSubmit.setText("Submit");
        modSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modSubmitActionPerformed(evt);
            }
        });

        modCancel.setText("Cancel");
        modCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modCancelActionPerformed(evt);
            }
        });

        modParticipantNo.setEditable(false);

        javax.swing.GroupLayout ModifyASurveyLayout = new javax.swing.GroupLayout(ModifyASurvey.getContentPane());
        ModifyASurvey.getContentPane().setLayout(ModifyASurveyLayout);
        ModifyASurveyLayout.setHorizontalGroup(
            ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModifyASurveyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ModifyASurveyLayout.createSequentialGroup()
                        .addComponent(modIsFed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modIsState)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modIsPrivate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modIsSelf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modIsUnemployed))
                    .addGroup(ModifyASurveyLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modParticipantNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ModifyASurveyLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(modZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addGroup(ModifyASurveyLayout.createSequentialGroup()
                        .addComponent(modImpactYes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modImpactNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modImpactUnknown))
                    .addComponent(jLabel17)
                    .addGroup(ModifyASurveyLayout.createSequentialGroup()
                        .addComponent(modBlameR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modBlameD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modBlameO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modBlameC)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ModifyASurveyLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(modSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modCancel)
                .addGap(121, 121, 121))
        );
        ModifyASurveyLayout.setVerticalGroup(
            ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModifyASurveyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(modParticipantNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(modZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modIsFed)
                    .addComponent(modIsState)
                    .addComponent(modIsPrivate)
                    .addComponent(modIsSelf)
                    .addComponent(modIsUnemployed))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modImpactYes)
                    .addComponent(modImpactNo)
                    .addComponent(modImpactUnknown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modBlameR)
                    .addComponent(modBlameD)
                    .addComponent(modBlameO)
                    .addComponent(modBlameC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ModifyASurveyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modSubmit)
                    .addComponent(modCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Survey On The Government Shutdown");

        jLabel1.setText("Participant No.");

        jLabel2.setText("Zip Code");

        jLabel3.setText("Employment");

        jLabel4.setText("Impact");

        jLabel5.setText("Cause");

        addASurvey.setText("Add");
        addASurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CSampleAddASurveyClicked(evt);
            }
        });

        modifyASurvey.setText("Modify");
        modifyASurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyASurveyActionPerformed(evt);
            }
        });

        removeASurvey.setText("Remove");
        removeASurvey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeASurveyActionPerformed(evt);
            }
        });

        removeAllSurveys.setText("Remove All");
        removeAllSurveys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllSurveysActionPerformed(evt);
            }
        });

        surveyListOut.setModel(surveyList);
        surveyListOut.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        surveyListOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        surveyListOut.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                surveyListOutValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(surveyListOut);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addASurvey, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifyASurvey, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(removeASurvey, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeAllSurveys, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addASurvey)
                    .addComponent(removeASurvey)
                    .addComponent(modifyASurvey)
                    .addComponent(removeAllSurveys))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Handler Code
    private void CSampleAddASurveyClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CSampleAddASurveyClicked
        participantNo.setText(keyGen.generateId());
        AddASurvey.setVisible(true);
    }//GEN-LAST:event_CSampleAddASurveyClicked

    private void modifyASurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyASurveyActionPerformed
        //System.out.println(selectedItem); 
        modSurvey = surveyObjects.get(selectedItem);
        modParticipantNo.setText(modSurvey.getMi().getText());
        modZipCode.setText(modSurvey.getMz().getText());
        //employmentType = modSurvey.getMe();
        //affectType = modSurvey.getMim();
        //modBlameD = modSurvey.getMd();
        //modBlameO = modSurvey.getMo();
        //modBlameC = modSurvey.getMc();
        //ModifyASurvey.repaint();
        ModifyASurvey.setVisible(true);
    }//GEN-LAST:event_modifyASurveyActionPerformed

    private void submitAddASurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitAddASurveyActionPerformed
        nuSurvey = new Survey(participantNo,zipCode,employmentType,affectType,blameR,blameD,blameO,blameC);
        surveyList.add(nuSurvey.getID()-1,nuSurvey.getSurvey());
        //debugging
        //System.out.println(surveyListOut);
        //System.out.println(surveyListOut.getModel());
        surveyObjects.put(nuSurvey.getID()-1, nuSurvey);
        AddASurvey.dispose();
        //because Java's garbage collection logic is absolute fucking shit.  
        initComponents();
    }//GEN-LAST:event_submitAddASurveyActionPerformed

    private void cancelAddASurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddASurveyActionPerformed
        AddASurvey.dispose();
        keyGen.decrementID();
        initComponents();
    }//GEN-LAST:event_cancelAddASurveyActionPerformed

    private void surveyListOutValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_surveyListOutValueChanged
        selectedItem = ((JList) evt.getSource()).getSelectedIndex();
        //System.out.println(surveyListOut.getModel());
        //System.out.println(selected);
    }//GEN-LAST:event_surveyListOutValueChanged

    private void removeAllSurveysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllSurveysActionPerformed
        surveyList.clear();
        surveyListOut.clearSelection();
        surveyListOut.repaint();
        initComponents();
    }//GEN-LAST:event_removeAllSurveysActionPerformed

    private void removeASurveyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeASurveyActionPerformed
        surveyObjects.remove(selectedItem);
        surveyList.remove(selectedItem);
    }//GEN-LAST:event_removeASurveyActionPerformed

    private void modCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modCancelActionPerformed
        ModifyASurvey.dispose();
        initComponents();
    }//GEN-LAST:event_modCancelActionPerformed

    private void modSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modSubmitActionPerformed
        nuSurvey = new Survey(participantNo,zipCode,employmentType,affectType,blameR,blameD,blameO,blameC);
        surveyList.remove(nuSurvey.getID()-1);
        surveyList.add(nuSurvey.getID()-1,nuSurvey.getSurvey());
        //debugging
        //System.out.println(surveyListOut);
        //System.out.println(surveyListOut.getModel());
        //surveyObjects.put(nuSurvey.getID()-1, nuSurvey);
        AddASurvey.dispose();
        //because Java's garbage collection logic is absolute fucking shit.  
        initComponents();
    }//GEN-LAST:event_modSubmitActionPerformed

    //Utility Methods
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CSampler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CSampler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CSampler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CSampler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CSampler().setVisible(true);
            }
        });
    }
    protected Survey nuSurvey;
    protected Survey modSurvey;
    protected DefaultListModel surveyList;
    private final HashMap<Integer,Survey> surveyObjects;
    private int selectedItem;
    final idGenerator keyGen;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog AddASurvey;
    public javax.swing.JDialog ModifyASurvey;
    private javax.swing.JButton addASurvey;
    private javax.swing.JRadioButton affectNo;
    private javax.swing.ButtonGroup affectType;
    private javax.swing.JRadioButton affectUnknown;
    private javax.swing.JRadioButton affectYes;
    private javax.swing.JCheckBox blameC;
    private javax.swing.JCheckBox blameD;
    private javax.swing.JCheckBox blameO;
    private javax.swing.JCheckBox blameR;
    private javax.swing.JButton cancelAddASurvey;
    private javax.swing.ButtonGroup employmentType;
    private javax.swing.JRadioButton isFed;
    private javax.swing.JRadioButton isPrivate;
    private javax.swing.JRadioButton isSelf;
    private javax.swing.JRadioButton isState;
    private javax.swing.JRadioButton isUnemployed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox modBlameC;
    private javax.swing.JCheckBox modBlameD;
    private javax.swing.JCheckBox modBlameO;
    private javax.swing.JCheckBox modBlameR;
    private javax.swing.JButton modCancel;
    private javax.swing.JRadioButton modImpactNo;
    private javax.swing.JRadioButton modImpactUnknown;
    private javax.swing.JRadioButton modImpactYes;
    private javax.swing.JRadioButton modIsFed;
    private javax.swing.JRadioButton modIsPrivate;
    private javax.swing.JRadioButton modIsSelf;
    public javax.swing.JRadioButton modIsState;
    private javax.swing.JRadioButton modIsUnemployed;
    public javax.swing.JTextField modParticipantNo;
    private javax.swing.JButton modSubmit;
    private javax.swing.JTextField modZipCode;
    private javax.swing.JButton modifyASurvey;
    private javax.swing.JTextField participantNo;
    private javax.swing.JButton removeASurvey;
    private javax.swing.JButton removeAllSurveys;
    private javax.swing.JButton submitAddASurvey;
    private javax.swing.JList surveyListOut;
    private javax.swing.JTextField zipCode;
    // End of variables declaration//GEN-END:variables
}

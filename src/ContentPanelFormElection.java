
import javax.swing.*;


public class ContentPanelFormElection extends javax.swing.JPanel {

    public ContentPanelFormElection() {
        initComponents();
    }
    
    
//    public ContentPanelFormElection(JTextField txtfldSearch, JButton btnAdd, JButton btnUpdate, JButton btnRemove, JTable tblData, JLabel lblTitle) {
//        this.txtfldSearch = txtfldSearch;
//        this.btnAdd = btnAdd;
//        this.btnUpdate = btnUpdate;
//        this.btnRemove = btnRemove;
//        this.tblData = tblData;
//        this.lblTitle = lblTitle;
//        initComponents();
//    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public void setBtnRemove(JButton btnRemove) {
        this.btnRemove = btnRemove;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

//    public void setTxtfldSearch(JTextField txtfldSearch) {
//        this.txtfldSearch = txtfldSearch;
//    }

    public void setTblData(JTable tblData) {
        this.tblData = tblData;
    }

    public void setCbSelectAll(JCheckBox cbSelectAll) {
        this.cbSelectAll = cbSelectAll;
    }
    
    
    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JButton getBtnRemove() {
        return btnRemove;
    }

    public JButton getBtnAddCandidate() {
        return btnAddCandidate;
    }

    public JButton getBtnRemoveCandidate() {
        return btnRemoveCandidate;
    }

    public JButton getBtnSetElection() {
        return btnSetElection;
    }

//    public JTextField getTxtfldSearch() {
//        return txtfldSearch;
//    }

    public JTable getTblData() {
        return tblData;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public JCheckBox getCbSelectAll() {
        return cbSelectAll;
    }

    public JButton getBtnRun() {
        return btnRun;
    }

    public JButton getBtnStop() {
        return btnStop;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrudPanel = new javax.swing.JPanel();
        CrudPanel_CRUD = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        cbSelectAll = new javax.swing.JCheckBox();
        btnAddCandidate = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnRemoveCandidate = new javax.swing.JButton();
        btnSetElection = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnRun = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        CrudPanel_Title = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        DataPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        CrudPanel.setMaximumSize(new java.awt.Dimension(100, 140));
        CrudPanel.setPreferredSize(new java.awt.Dimension(100, 125));

        CrudPanel_CRUD.setPreferredSize(new java.awt.Dimension(701, 80));

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/remove_24px.png"))); // NOI18N

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update_24px.png"))); // NOI18N

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add_24px.png"))); // NOI18N

        cbSelectAll.setText("Select All");

        btnAddCandidate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/popular_man_24px.png"))); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnRemoveCandidate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/writer_male_24px.png"))); // NOI18N

        btnSetElection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multiple_choice_24px.png"))); // NOI18N

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circled_play_24px.png"))); // NOI18N

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stop_circled_24px.png"))); // NOI18N

        javax.swing.GroupLayout CrudPanel_CRUDLayout = new javax.swing.GroupLayout(CrudPanel_CRUD);
        CrudPanel_CRUD.setLayout(CrudPanel_CRUDLayout);
        CrudPanel_CRUDLayout.setHorizontalGroup(
            CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudPanel_CRUDLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrudPanel_CRUDLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnAddCandidate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveCandidate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSetElection, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSelectAll))
                .addContainerGap(523, Short.MAX_VALUE))
        );
        CrudPanel_CRUDLayout.setVerticalGroup(
            CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudPanel_CRUDLayout.createSequentialGroup()
                .addComponent(cbSelectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(btnAddCandidate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveCandidate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSetElection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStop, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CrudPanel_Title.setPreferredSize(new java.awt.Dimension(261, 40));
        CrudPanel_Title.setLayout(new java.awt.BorderLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Title");
        lblTitle.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTitle.setVerifyInputWhenFocusTarget(false);
        CrudPanel_Title.add(lblTitle, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout CrudPanelLayout = new javax.swing.GroupLayout(CrudPanel);
        CrudPanel.setLayout(CrudPanelLayout);
        CrudPanelLayout.setHorizontalGroup(
            CrudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CrudPanel_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
            .addComponent(CrudPanel_CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
        );
        CrudPanelLayout.setVerticalGroup(
            CrudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudPanelLayout.createSequentialGroup()
                .addComponent(CrudPanel_Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrudPanel_CRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        add(CrudPanel, java.awt.BorderLayout.NORTH);

        DataPanel.setPreferredSize(new java.awt.Dimension(452, 300));
        DataPanel.setLayout(new javax.swing.BoxLayout(DataPanel, javax.swing.BoxLayout.LINE_AXIS));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        DataPanel.add(jScrollPane1);

        add(DataPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CrudPanel;
    private javax.swing.JPanel CrudPanel_CRUD;
    private javax.swing.JPanel CrudPanel_Title;
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddCandidate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemoveCandidate;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSetElection;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbSelectAll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}

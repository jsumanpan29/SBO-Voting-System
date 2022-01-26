
import javax.swing.*;


public class ContentPanelForm extends javax.swing.JPanel {

    public ContentPanelForm() {
        initComponents();
    }
    
    
//    public ContentPanelForm(JTextField txtfldSearch, JButton btnAdd, JButton btnUpdate, JButton btnRemove, JTable tblData, JLabel lblTitle) {
////        this.txtfldSearch = txtfldSearch;
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
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrudPanel = new javax.swing.JPanel();
        CrudPanel_CRUD = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        cbSelectAll = new javax.swing.JCheckBox();
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
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbSelectAll))
                .addContainerGap(830, Short.MAX_VALUE))
        );
        CrudPanel_CRUDLayout.setVerticalGroup(
            CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrudPanel_CRUDLayout.createSequentialGroup()
                .addComponent(cbSelectAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CrudPanel_CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
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
                .addComponent(CrudPanel_CRUD, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox cbSelectAll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}

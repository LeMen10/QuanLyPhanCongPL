/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import BLL.CourseinstructorBLL;
import javax.swing.table.DefaultTableModel;
import GUI.GiaoDienSua;
import DTO.CourseinstructorDTO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author menvo
 */
public final class GiaoDienDsPC extends javax.swing.JFrame {
    private CourseinstructorBLL courseinstructorBLL;
    private List list;
    /**
     * Creates new form GiaoDienDSPhanCong
     */
    public GiaoDienDsPC() {
        initComponents();
        this.setLocationRelativeTo(null);
        courseinstructorBLL = new CourseinstructorBLL();
        loadData();
        
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int selectedRow = jTable1.getSelectedRow();
                    Object CourseID = jTable1.getValueAt(selectedRow, 0);
                    Object PersonID = jTable1.getValueAt(selectedRow, 2);
                    if (selectedRow != -1) {
                        showEditDeleteDialog(CourseID, PersonID);
                    }
                }
            }
        });
    }
    
    private void loadData(){
        list = courseinstructorBLL.getAllCourseinstructor();
        DefaultTableModel model = loadDataToTable(list);
        jTable1.setModel(model);
    }
    
    private void showEditDeleteDialog(Object CourseID, Object PersonID) {
        JFrame parentFrame = new JFrame();
        Object[] options = {"Sửa", "Xóa", "Xem"};
        int result = JOptionPane.showOptionDialog(parentFrame,
                "Chọn tác vụ:",
                "Tác vụ",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        // Xử lý kết quả từ dialog
        switch (result) {
            case 0:
                editRow(CourseID, PersonID);
                break;
            case 1:
                deleteRow(CourseID, PersonID);
                break;
            case 2:
                detailRow(CourseID, PersonID);
                break;
        }
    }
    
    private void editRow(Object CourseID, Object PersonID) {
        GiaoDienSua giaoDienSua = new GiaoDienSua();
        giaoDienSua.ValuePrev(CourseID, PersonID);
        giaoDienSua.setVisible(true);
        this.dispose();
    }

    private void deleteRow(Object CourseID, Object PersonID) {
        courseinstructorBLL.deleteCourseIntructorItem(CourseID, PersonID);
        loadData();
    }
    
    private void detailRow(Object CourseID, Object PersonID) {
        GiaoDienChiTietPC giaoDienChiTietPC = new GiaoDienChiTietPC();
        giaoDienChiTietPC.ValuePrev(CourseID, PersonID);
        giaoDienChiTietPC.setVisible(true);
        this.dispose();
    }
    
    private DefaultTableModel loadDataToTable(List list) {
        String[] columnNames= {"CourseID", "Title", "PersonID", "DepartmentID"};
        Object[][] data = new Object[list.size()][4];
        for(int i = 0; i < list.size(); i++){
            CourseinstructorDTO s = (CourseinstructorDTO) list.get(i);
            data[i][0] = s.getCourseID();
            data[i][1] = s.getTitle();
            data[i][2] = s.getPersonID();
            data[i][3] = s.getDepartmentID();
        }
        DefaultTableModel model = new DefaultTableModel(data,columnNames);
        return model;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh sách phân công công việc");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tìm kiếm");
        jButton2.setMinimumSize(new java.awt.Dimension(79, 22));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CourseID", "Title", "PersonID", "Department"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String text = jTextField1.getText();
        courseinstructorBLL = new CourseinstructorBLL();
        list = courseinstructorBLL.searchByCourseTitle(text);
        DefaultTableModel model = loadDataToTable(list);
        jTable1.setModel(model);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        GiaoDienThem giaoDienThem = new GiaoDienThem();
        giaoDienThem.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

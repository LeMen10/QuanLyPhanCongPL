/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BLL.CourseinstructorBLL;
import DAO.CourseIntructorDAO;
import DTO.CourseDTO;
import DTO.DepartmentDTO;
import DTO.DetailDTO;
import DTO.PersonDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author menvo
 */
public final class GiaoDienSua extends javax.swing.JFrame {
    private Object CourseIdRepair; 
    private Object PersonIdRepair;
    private JButton btnOK;
    private JComboBox<CourseDTO> comboBox1;
    private JComboBox<PersonDTO> comboBox2;
    private JComboBox<DepartmentDTO> comboBox3;
    private CourseinstructorBLL courseinstructorBLL;

    public GiaoDienSua() {
        initComponents();
        courseinstructorBLL = new CourseinstructorBLL();
        this.setLayout(null);
        this.setTitle("Thêm");

        JLabel label1 = new JLabel("Course");
        label1.setBounds(35, 40, 80, 30);

        comboBox1 = new JComboBox<>();
        comboBox1.setBounds(200, 48, 150, 30);
        comboBox1.setRenderer(new CourseDTORenderer());

        JLabel label2 = new JLabel("Person");
        label2.setBounds(35, 98, 80, 40);

        comboBox2 = new JComboBox<>();
        comboBox2.setBounds(200, 110, 150, 30);
        comboBox2.setRenderer(new PersonDTORenderer());

        JLabel label3 = new JLabel("Department");
        label3.setBounds(35, 156, 80, 40);

        comboBox3 = new JComboBox<>();
        comboBox3.setBounds(200, 172, 150, 30);
        comboBox3.setRenderer(new DepartmentDTORenderer());

        btnOK = new JButton("OK");
        btnOK.setBounds(290, 250, 60, 25);

        btnOK.addActionListener((ActionEvent e) -> {
            CourseDTO selectedCourse = (CourseDTO) comboBox1.getSelectedItem();
            PersonDTO selectedPerson = (PersonDTO) comboBox2.getSelectedItem();
            DepartmentDTO selectedDepartment = (DepartmentDTO) comboBox3.getSelectedItem();

            if (selectedCourse != null && selectedPerson != null) {
                int courseID = selectedCourse.getCourseID();
                int personID = selectedPerson.getPersonID();
                int departmentID = selectedDepartment.getDepartmentID();
                System.out.println(courseID + " hi " + personID+ " "+ departmentID+ " "+CourseIdRepair+" "+PersonIdRepair);
                editCourseInTructor(courseID, personID, departmentID, CourseIdRepair, PersonIdRepair);
//                GiaoDienDsPC giaoDienDsPC = new GiaoDienDsPC();
//                giaoDienDsPC.setVisible(true);
            } else {
                System.out.println("Please select both Course and Person");
            }
        });

        this.add(label1);
        this.add(comboBox1);
        this.add(label2);
        this.add(comboBox2);
        this.add(label3);
        this.add(comboBox3);
        this.add(btnOK);

        this.getContentPane().setBackground(new Color(220, 220, 220));
        this.setSize(new Dimension(400, 350));
        this.setLocationRelativeTo(null);

        setComBoxMonHoc();
        setComBoxPerson();
        setComBoxDepartment();
    }

    public void ValuePrev(Object CourseID, Object PersonID){
        this.CourseIdRepair = CourseID;
        this.PersonIdRepair = PersonID;
        courseinstructorBLL = new CourseinstructorBLL();

    }
    
    public void editCourseInTructor(int CourseID, int PersonID, int DepartmentID, 
            Object CourseIdRepair, Object PersonIdRepair) {
        courseinstructorBLL.editCourseIntructor(CourseID, PersonID, DepartmentID, CourseIdRepair, PersonIdRepair);
    }

    public void setComBoxMonHoc() {
        DefaultComboBoxModel<CourseDTO> list = new DefaultComboBoxModel<>();
        ArrayList<CourseDTO> arr_course = courseinstructorBLL.getAllCourse();
        for (CourseDTO courseDTO : arr_course) {
            list.addElement(courseDTO);
        }
        comboBox1.setModel(list);
    }

    public void setComBoxPerson() {
        DefaultComboBoxModel<PersonDTO> list = new DefaultComboBoxModel<>();
        ArrayList<PersonDTO> arr_person = courseinstructorBLL.getAllPerson();
        for (PersonDTO personDTO : arr_person) {
            list.addElement(personDTO);
        }
        comboBox2.setModel(list);
    }

    public void setComBoxDepartment() {
        DefaultComboBoxModel<DepartmentDTO> list = new DefaultComboBoxModel<>();
        ArrayList<DepartmentDTO> arr_department = courseinstructorBLL.getAllDepartment();
        System.out.println(arr_department);
        for (DepartmentDTO departmentDTO : arr_department) {
            list.addElement(departmentDTO);
        }
        comboBox3.setModel(list);
    }

    private class CourseDTORenderer extends JLabel implements ListCellRenderer<CourseDTO> {

        public CourseDTORenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends CourseDTO> list, CourseDTO value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.getTitle());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    private class PersonDTORenderer extends JLabel implements ListCellRenderer<PersonDTO> {

        public PersonDTORenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends PersonDTO> list, PersonDTO value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.getFirstName()+ " " + value.getLastname());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    private class DepartmentDTORenderer extends JLabel implements ListCellRenderer<DepartmentDTO> {

        public DepartmentDTORenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends DepartmentDTO> list, DepartmentDTO value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.getName());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sửa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GiaoDienSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienSua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienSua().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

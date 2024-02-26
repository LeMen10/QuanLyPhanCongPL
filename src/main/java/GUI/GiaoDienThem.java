/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import BLL.CourseinstructorBLL;
import DTO.CourseDTO;
import DTO.PersonDTO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author menvo
 */
public final class GiaoDienThem extends JFrame {

    private JButton btnOK;
    private JComboBox<CourseDTO> comboBox1;
    private JComboBox<PersonDTO> comboBox2;
    private CourseinstructorBLL courseinstructorBLL;

    public GiaoDienThem() {
        initComponents();
        courseinstructorBLL = new CourseinstructorBLL();
        this.setLayout(null);
        this.setTitle("Thêm");

        JLabel label1 = new JLabel("Course");
        label1.setBounds(50, 40, 60, 30);

        comboBox1 = new JComboBox<>();
        comboBox1.setBounds(200, 48, 150, 30);
        comboBox1.setRenderer(new CourseDTORenderer());

        JLabel label2 = new JLabel("Person");
        label2.setBounds(50, 98, 60, 40);

        comboBox2 = new JComboBox<>();
        comboBox2.setBounds(200, 110, 150, 30);
        comboBox2.setRenderer(new PersonDTORenderer());

        btnOK = new JButton("OK");
        btnOK.setBounds(290, 200, 60, 25);

        btnOK.addActionListener((ActionEvent e) -> {
            CourseDTO selectedCourse = (CourseDTO) comboBox1.getSelectedItem();
            PersonDTO selectedPerson = (PersonDTO) comboBox2.getSelectedItem();

            if (selectedCourse != null && selectedPerson != null) {
                int courseID = selectedCourse.getCourseID();
                int personID = selectedPerson.getPersonID();
                addCourseInTructor(courseID, personID);
            } else {
                System.out.println("Please select both Course and Person");
            }
        });

        this.add(label1);
        this.add(comboBox1);
        this.add(label2);
        this.add(comboBox2);
        this.add(btnOK);

        this.getContentPane().setBackground(new Color(220, 220, 220));
        this.setSize(new Dimension(400, 350));
        this.setLocationRelativeTo(null);

        setComBoxMonHoc();
        setComBoxPerson();
    }
    
    public void addCourseInTructor(int CourseID, int PersonID){
        courseinstructorBLL.addCourseIntructor(CourseID, PersonID);
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
            setText(value.getFirstName() + value.getLastname());
            setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
            setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
            return this;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm");
        setPreferredSize(new java.awt.Dimension(500, 300));

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
            java.util.logging.Logger.getLogger(GiaoDienThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienThem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

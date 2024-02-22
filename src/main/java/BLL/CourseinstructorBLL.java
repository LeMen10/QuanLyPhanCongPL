/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import java.util.ArrayList;
import DAO.CourseIntructorDAO;
import DTO.CourseinstructorDTO;
import DTO.CourseDTO;
import DTO.DepartmentDTO;
import DTO.PersonDTO;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author menvo
 */
public class CourseinstructorBLL {
    private CourseIntructorDAO courseIntructorDAO;

    public CourseinstructorBLL(){
        courseIntructorDAO = new CourseIntructorDAO();
    }
    public CourseinstructorBLL(CourseIntructorDAO courseIntructorDAO) {
        this.courseIntructorDAO = courseIntructorDAO;
    }
    
    public ArrayList<CourseinstructorDTO> getAllCourseinstructor() {
        return courseIntructorDAO.getAllCourseinstructor();
    }
    
    public DefaultComboBoxModel<CourseDTO> getAllCourse() {
        ArrayList<CourseDTO> list = courseIntructorDAO.getAllCourse();
        DefaultComboBoxModel<CourseDTO> df = new DefaultComboBoxModel<>();
        for(CourseDTO course: list){
            df.addElement(course);
        }
        return df;
    }
    
    public DefaultComboBoxModel<PersonDTO> getAllPerson() {
        ArrayList<PersonDTO> list = courseIntructorDAO.getAllPerson();
        DefaultComboBoxModel<PersonDTO> df = new DefaultComboBoxModel<>();
        for(PersonDTO person: list){
            df.addElement(person);
        }
        return df;
    }
    
    public DefaultComboBoxModel<DepartmentDTO> getAllDepartment() {
        ArrayList<DepartmentDTO> list = courseIntructorDAO.getAllDepartment();
        DefaultComboBoxModel<DepartmentDTO> df = new DefaultComboBoxModel<>();
        for(DepartmentDTO department: list){
            df.addElement(department);
        }
        return df;
    }

    public void addCourseIntructor(CourseinstructorDTO courseIntructor) {
        // Các kiểm tra hợp lệ và logic kinh doanh khác trước khi thêm sinh viên
        courseIntructorDAO.addCourseinstructor(courseIntructor);
    }
    
    public void editCourseIntructor(CourseinstructorDTO courseIntructor) {
        // Các kiểm tra hợp lệ và logic kinh doanh khác trước khi thêm sinh viên
        courseIntructorDAO.editCourseinstructor(courseIntructor);
    }
    
    public void deleteCourseIntructorItem(CourseinstructorDTO courseIntructor) {
        courseIntructorDAO.editCourseinstructor(courseIntructor);
    }
    
    public ArrayList<CourseinstructorDTO> searchByCourseTitle(String text){
        return courseIntructorDAO.searchByCourseTitle(text);
    }
}

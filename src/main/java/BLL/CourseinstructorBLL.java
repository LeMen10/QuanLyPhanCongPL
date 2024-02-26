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
import DTO.DetailDTO;
import DTO.PersonDTO;
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
    
    public ArrayList<DetailDTO> getDetail(Object CourseID, Object PersonID) {
        return courseIntructorDAO.getDetail(CourseID, PersonID);
    }
    
    public ArrayList<CourseDTO> getAllCourse(){
        return courseIntructorDAO.getAllCourse();
    }
    
//    public DefaultComboBoxModel<CourseDTO> getAllCourse() {
//        ArrayList<CourseDTO> list = courseIntructorDAO.getAllCourse();
//        DefaultComboBoxModel<CourseDTO> df = new DefaultComboBoxModel<>();
//        for(CourseDTO course: list){
//            df.addElement(course);
//        }
//        return df;
//    }
    
    public ArrayList<PersonDTO> getAllPerson() {
        return courseIntructorDAO.getAllPerson();
    }
    
    public ArrayList<DepartmentDTO> getAllDepartment() {
        return courseIntructorDAO.getAllDepartment();
    }

    public void addCourseIntructor(int CourseID, int PersonID) {
        courseIntructorDAO.addCourseinstructor(CourseID, PersonID);
    }
    
    public void editCourseIntructor(int CourseID, int PersonID, int DepartmentID, 
            Object CourseIdRepair, Object PersonIdRepair) {
        courseIntructorDAO.editCourseinstructor(CourseID, PersonID, DepartmentID, CourseIdRepair, PersonIdRepair);
    }
    
    public void deleteCourseIntructorItem(Object CourseID, Object PersonID) {
        courseIntructorDAO.deleteCourseIntructorItem(CourseID, PersonID);
    }
    
    public ArrayList<CourseinstructorDTO> searchByCourseTitle(String text){
        return courseIntructorDAO.searchByCourseTitle(text);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import java.util.List;
import DAO.CourseIntructorDAO;
import DTO.CourseinstructorDTO;
/**
 *
 * @author menvo
 */
public class CourseinstructorBLL {
    private CourseIntructorDAO courseIntructorDAO;

    public CourseinstructorBLL(CourseIntructorDAO courseIntructorDAO) {
        this.courseIntructorDAO = courseIntructorDAO;
    }
    
    public List<CourseinstructorDTO> getAllCourseinstructor() {
        return courseIntructorDAO.getAllCourseinstructor();
    }

    public void addStudent(CourseinstructorDTO courseIntructor) {
        // Các kiểm tra hợp lệ và logic kinh doanh khác trước khi thêm sinh viên
        courseIntructorDAO.addCourseinstructor(courseIntructor);
    }
}

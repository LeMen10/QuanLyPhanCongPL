/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import DTO.CourseinstructorDTO;
import DTO.CourseDTO;
import DTO.DepartmentDTO;
import DTO.DetailDTO;
import DTO.PersonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author menvo
 */
public class CourseIntructorDAO {

    private Connection connection;

    public CourseIntructorDAO() {
        try {
            this.connection = ConnectionManager.getConnection();
        } catch (SQLException e) {
            // Xử lý lỗi kết nối
        }
    }

    public ArrayList<CourseinstructorDTO> getAllCourseinstructor() {
        ArrayList<CourseinstructorDTO> courseinstructorLIST = new ArrayList<>();
        try {
            String query = "SELECT c.PersonID, c.CourseID, cs.DepartmentID, cs.Title FROM courseinstructor c "
                    + "INNER JOIN course cs WHERE cs.CourseID = c.CourseID";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                CourseinstructorDTO c = new CourseinstructorDTO();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                c.setTitle(rs.getString("Title"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                courseinstructorLIST.add(c);
            }
        } catch (SQLException e) {
        }

        return courseinstructorLIST;
    }

    public void addCourseinstructor(CourseinstructorDTO courseinstructor) {
//        try {
//            String query = "INSERT INTO courseinstructor (PersionID, CourseID) VALUES (?, ?)";
//            try (Statement statement = connection.createStatement(query)) {
//                preparedStatement.setInt(1, courseinstructor.getPersonID());
//                preparedStatement.setInt(2, courseinstructor.getCourseID());
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    
    public ArrayList<CourseDTO> getAllCourse() {
        ArrayList<CourseDTO> courseLIST = new ArrayList<>();
        try {
            String query = "SELECT * FROM course";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                CourseDTO c = new CourseDTO();
                c.setCourseID(rs.getInt("CourseID"));
                c.setTitle(rs.getString("Title"));
                c.setCredits(rs.getInt("Credits"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                courseLIST.add(c);
            }
        } catch (SQLException e) {}

        return courseLIST;
    }
    
    public ArrayList<PersonDTO> getAllPerson() {
        ArrayList<PersonDTO> personLIST = new ArrayList<>();
        try {
            String query = "SELECT * FROM person";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                PersonDTO p = new PersonDTO();
                p.setPersonID(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("Firstname"));
                p.setLastname(rs.getString("Lastname"));
                personLIST.add(p);
            }
        } catch (SQLException e) {}

        return personLIST;
    }
    
    public ArrayList<DepartmentDTO> getAllDepartment() {
        ArrayList<DepartmentDTO> departmentLIST = new ArrayList<>();
        try {
            String query = "SELECT * FROM person";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                DepartmentDTO d = new DepartmentDTO();
                d.setDepartmentID(rs.getInt("DepartmentID"));
                d.setName(rs.getString("Name"));
                departmentLIST.add(d);
            }
        } catch (SQLException e) {}

        return departmentLIST;
    }

    public void editCourseinstructor(CourseinstructorDTO courseinstructor) {
//        try {
//            String query = "UPDATE courseinstructor c SET PersonID = ?, CourseID = ? Where PersonID ? AND CourseID = ?";
//            
//            PreparedStatement preparedstatement = connection.prepareStatement(query);
//            rs.setInt(1, courseinstructor.getPersonID()));
//            rs.setInt(2, courseinstructor.getCourseID());
//            rs.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    
    public ArrayList<CourseinstructorDTO> searchByCourseTitle(String text) {
        ArrayList<CourseinstructorDTO> courseinstructorLIST = new ArrayList<>();
        try {
            String query = "SELECT c.PersonID, c.CourseID, cs.DepartmentID, cs.Title "
                    + "FROM courseinstructor c INNER JOIN course cs "
                    + "WHERE cs.CourseID = c.CourseID AND Title LIKE '%"+ text +"%'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                CourseinstructorDTO c = new CourseinstructorDTO();
                c.setPersonID(rs.getInt("PersonID"));
                c.setCourseID(rs.getInt("CourseID"));
                c.setTitle(rs.getString("Title"));
                c.setDepartmentID(rs.getInt("DepartmentID"));
                courseinstructorLIST.add(c);
            }
        } catch (SQLException e) {}

        return courseinstructorLIST;
    } 
    
    public void deleteCourseIntructorItem(int PersonID, int CourseID){
        try {
            String query = "UPDATE courseinstructor SET IsDeleted = 1"
                    + "WHERE CourseID = "+ PersonID +" AND PersonID = " + CourseID;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {}
        } catch (SQLException e) {}
    }
}

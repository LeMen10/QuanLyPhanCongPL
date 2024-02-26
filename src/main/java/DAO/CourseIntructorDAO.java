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
                    + "JOIN course cs ON cs.CourseID = c.CourseID "
                    + "Where c.IsDelete = 0";
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

    public ArrayList<DetailDTO> getDetail(Object CourseID, Object PersonID) {
        ArrayList<DetailDTO> detail = new ArrayList<>();
        System.out.println("dao" + CourseID + PersonID);
        try {
            String query = "SELECT p.FirstName, p.LastName, d.Name, cs.Title, cs.Credits FROM courseinstructor c "
                    + "JOIN course cs ON cs.CourseID = c.CourseID "
                    + "JOIN person p ON p.PersonID = c.PersonID "
                    + "JOIN department d ON d.DepartmentID = cs.DepartmentID "
                    + "Where c.PersonID = " + PersonID + " AND c.CourseID = " + CourseID;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                DetailDTO d = new DetailDTO();
                d.setTitle(rs.getString("Title"));
                d.setFirstName(rs.getString("FirstName"));
                d.setLastname(rs.getString("LastName"));
                d.setDepartmentName(rs.getString("Name"));
                d.setCredits(rs.getInt("Credits"));
                detail.add(d);
            }
        } catch (SQLException e) {
        }

        return detail;
    }

    public void addCourseinstructor(int CourseID, int PersonID) {
        String query = "INSERT INTO courseinstructor (CourseID, PersonID) VALUES (" + CourseID + ", " + PersonID + ")";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public ArrayList<CourseDTO> getAllCourse() {
        ArrayList<CourseDTO> courseLIST = new ArrayList<>();
        try {
            String query = "SELECT c.CourseID, c.Title, c.Credits, c.DepartmentID FROM course c";
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
        } catch (SQLException e) {
        }
        return courseLIST;
    }

    public ArrayList<PersonDTO> getAllPerson() {
        ArrayList<PersonDTO> personLIST = new ArrayList<>();
        try {
            String query = "SELECT p.PersonID, p.Firstname, p.Lastname FROM person p";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println(rs);
            while (rs.next()) {
                PersonDTO p = new PersonDTO();
                p.setPersonID(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("Firstname"));
                p.setLastname(rs.getString("Lastname"));
                personLIST.add(p);
            }
        } catch (SQLException e) {
        }

        return personLIST;
    }

    public ArrayList<DepartmentDTO> getAllDepartment() {
        ArrayList<DepartmentDTO> departmentLIST = new ArrayList<>();
        try {
            String query = "SELECT d.DepartmentID, d.Name FROM department d";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                DepartmentDTO d = new DepartmentDTO();
                d.setDepartmentID(rs.getInt("DepartmentID"));
                d.setName(rs.getString("Name"));
                departmentLIST.add(d);
            }
        } catch (SQLException e) {
        }

        return departmentLIST;
    }

    public void editCourseinstructor(int CourseID, int PersonID, int DepartmentID, 
            Object CourseIdRepair, Object PersonIdRepair ) {
        try {
            String query = "UPDATE courseinstructor SET CourseID = "+ CourseID +", PersonID = "+ PersonID
                    + " Where PersonID = " + PersonIdRepair +" AND CourseID = "+ CourseIdRepair;
            System.out.println(query);
            String updateDepartment = "UPDATE course SET DepartmentID = "+ DepartmentID
                    + " Where CourseID = "+ CourseIdRepair;
            System.out.println(updateDepartment);
//            PreparedStatement statement1 = connection.prepareStatement(updateDepartment);
            PreparedStatement statement2 = connection.prepareStatement(query);
            
//            statement1.executeUpdate();
            statement2.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public ArrayList<CourseinstructorDTO> searchByCourseTitle(String text) {
        ArrayList<CourseinstructorDTO> courseinstructorLIST = new ArrayList<>();
        try {
            String query = "SELECT c.PersonID, c.CourseID, cs.DepartmentID, cs.Title "
                    + "FROM courseinstructor c INNER JOIN course cs "
                    + "WHERE cs.CourseID = c.CourseID AND Title LIKE '%" + text + "%'";
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

    public void deleteCourseIntructorItem(Object CourseID, Object PersonID) {
        String query = "UPDATE courseinstructor SET IsDelete = 1 "
                + "WHERE CourseID = " + CourseID + " AND PersonID = " + PersonID;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}

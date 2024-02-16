/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import DTO.CourseinstructorDTO;
import DTO.CourseDTO;
import DTO.PersionDTO;
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

    public List<CourseinstructorDTO> getAllCourseinstructor() {
        List<CourseinstructorDTO> courseinstructorLIST = new ArrayList<>();
        try {
            String query = "SELECT * FROM `courseinstructor` WHERE 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int CourseID = resultSet.getInt("CourseID");
                int PersonID = resultSet.getInt("PersonID");
                
                CourseinstructorDTO courseinstructor = new CourseinstructorDTO(CourseID, PersonID);
                courseinstructorLIST.add(courseinstructor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL Exception: " + e.getMessage());
        }
        return  courseinstructorLIST;
    }

    public void addCourseinstructor(CourseinstructorDTO courseinstructor) {
        try {
            String query = "INSERT INTO courseinstructor (PersionID, CourseID) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseinstructor.getPersonID());
                preparedStatement.setInt(2, courseinstructor.getCourseID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editCourseinstructor(CourseinstructorDTO courseinstructor) {
        try {
            String query = "UPDATE person p JOIN  SET name=?, address=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseinstructor.getPersonID());
                preparedStatement.setInt(2, courseinstructor.getCourseID());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

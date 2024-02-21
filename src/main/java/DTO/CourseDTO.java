/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author menvo
 */
public class CourseDTO {
    private int CourseID;
    private String Title;
    private int Credits;
    private int DepartmentID;

    /**
     * @return the CourseID
     */
    public int getCourseID() {
        return CourseID;
    }

    /**
     * @param CourseID the CourseID to set
     */
    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the Credits
     */
    public int getCredits() {
        return Credits;
    }

    /**
     * @param Credits the Credits to set
     */
    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    /**
     * @return the DepartmentID
     */
    public int getDepartmentID() {
        return DepartmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }
    
}

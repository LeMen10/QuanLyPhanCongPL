/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author menvo
 */
public class CourseinstructorDTO {
    private int PersonID;
    private int CourseID;
    
    public CourseinstructorDTO(int CourseID, int PersonID ){
        this.PersonID = PersonID;
        this.CourseID = CourseID;
    }

    /**
     * @return the PersonID
     */
    public int getPersonID() {
        return PersonID;
    }

    /**
     * @param PersonID the PersonID to set
     */
    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

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
}

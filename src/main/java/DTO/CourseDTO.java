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
    private String Tite;
    private int DepartmentID;
    private int Creadits;

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
     * @return the Tite
     */
    public String getTite() {
        return Tite;
    }

    /**
     * @param Tite the Tite to set
     */
    public void setTite(String Tite) {
        this.Tite = Tite;
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

    /**
     * @return the Creadits
     */
    public int getCreadits() {
        return Creadits;
    }

    /**
     * @param Creadits the Creadits to set
     */
    public void setCreadits(int Creadits) {
        this.Creadits = Creadits;
    }
}

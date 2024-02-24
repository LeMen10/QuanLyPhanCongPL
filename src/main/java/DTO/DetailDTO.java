/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author menvo
 */
public class DetailDTO {
    private String FirstName;
    private String Lastname;
    private String Title;
    private String DepartmentName;
    private int Credits;


    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastname() {
        return Lastname;
    }


    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    /**
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the DepartmentName
     */
    public String getDepartmentName() {
        return DepartmentName;
    }

    /**
     * @param DepartmentName the DepartmentName to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
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
    
}

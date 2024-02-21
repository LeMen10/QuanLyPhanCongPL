/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author menvo
 */
public class PersonDTO {
    private int PersonID;
    private String Lastname;
    private String FirstName;

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
     * @return the Lastname
     */
    public String getLastname() {
        return Lastname;
    }

    /**
     * @param Lastname the Lastname to set
     */
    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    /**
     * @return the FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName the FirstName to set
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
}

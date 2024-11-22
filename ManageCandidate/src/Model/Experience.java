/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class Experience extends Candidate {

    public int ExpInYear;
    public String ProSkill;

    public Experience() {
        super();
    }

    public Experience(int ExpInYear, String ProSkill, String id, String firstName, String lastName, int birthDate, String address, String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int ExpInYear) {
        this.ExpInYear = ExpInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String ProSkill) {
        this.ProSkill = ProSkill;
    }
    
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " | " + getBirthDate() + " | " + getAddress() + " | " + getPhone() + " | " + getEmail() + " | " + getTypeCandidate();
    }

}

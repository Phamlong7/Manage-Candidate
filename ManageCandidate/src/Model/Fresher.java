/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class Fresher extends Candidate {

    public String Graduation_date;
    public String graduationRank;
    public String Education;

    public Fresher() {
        super();
    }

    public Fresher(String Graduation_date, String graduationRank, String Education, String id,String firstName, String lastName, int birthDate, String address,String phone, String email, int typeCandidate) {
        super(id, firstName, lastName, birthDate, address, phone, email, typeCandidate);
        this.Graduation_date = Graduation_date;
        this.graduationRank = graduationRank;
        this.Education = Education;
    }

    public String getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(String Graduation_date) {
        this.Graduation_date = Graduation_date;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

   @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " | " + getBirthDate() + " | " + getAddress() + " | " + getPhone() + " | " + getEmail() + " | " + getTypeCandidate();
    }

}

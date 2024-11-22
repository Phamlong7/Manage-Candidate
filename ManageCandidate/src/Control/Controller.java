/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Validation;
import Model.Internship;
import Model.Fresher;
import Model.Experience;
import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ACER
 */
public class Controller {

    // Allow user input common information of candidate
    public static void CreateCandidate(ArrayList<Candidate> candidates, int type) {
        while (true) {
            System.out.print("Input id: ");
            String id = Validation.checkInputString();
            System.out.print("Input first name: ");
            String firstName = Validation.checkInputString();
            System.out.print("Input last name: ");
            String lastName = Validation.checkInputString();
            System.out.print("Input birth date: ");
            int birthDate = Validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));
            System.out.print("Input address: ");
            String address = Validation.checkInputString();
            System.out.print("Input phone: ");
            String phone = Validation.checkInputPhone();
            System.out.print("Input email: ");
            String email = Validation.checkInputEmail();

            Candidate candidate = new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);

            // Check if the candidate ID already exists
            if (Validation.checkIdExist(candidates, id)) {
                // If ID does not exist, create a candidate of the specified type
                createCandidateOfType(candidates, candidate, type);
            } else {
                // If ID exists, return to the main menu
                return;
            }

            // Ask user if they want to continue creating candidates
            System.out.print("Do you want to continue (Y/N): ");
            if (!Validation.checkInputYN()) {
                // If user chooses not to continue, return to the main menu
                PrintListCandidate(candidates);
                return ;
            }
        }
    }

    private static void createCandidateOfType(ArrayList<Candidate> candidates, Candidate candidate, int type) {
        switch (type) {
            case 0:
                CreateExperience(candidates, candidate);
                break;
            case 1:
                CreateFresher(candidates, candidate);
                break;
            case 2:
                CreateInternship(candidates, candidate);
                break;
        }
    }

    // Allow user create experience candidate
    public static void CreateExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Input year of experience: ");
        int ExpInYear = Validation.checkInputExperience(candidate.getBirthDate());
        System.out.print("Input professional skill: ");
        String ProSkill = Validation.checkInputString();
        candidates.add(new Experience(ExpInYear, ProSkill, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
        
    }

    // Allow user create fresher candidate
    public static void CreateFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Input graduation date: ");
        String Graduation_date = Validation.checkInputString();
        System.out.print("Input graduation rank: ");
        String Graduation_rank = Validation.checkInputGraduationRank();
        System.out.print("Input university where student graduated: ");
        String Education = Validation.checkInputString();
        candidates.add(new Fresher(Graduation_date, Graduation_rank, Education , candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    // Allow user create internship candidate
    public static void CreateInternship(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Input major: ");
        String major = Validation.checkInputString();
        System.out.print("Input semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Input university: ");
        String university = Validation.checkInputString();
        candidates.add(new Internship(major, semester, university, candidate.getId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate()));
        System.err.println("Create success.");
    }

    // Allow user search candidate by name
    public static void SearchCandidate(ArrayList<Candidate> candidates) {
        PrintListCandidate(candidates);
        System.out.print("Input Candidate name (First name or Last name):  ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Input type of candidate:  ");
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        // Iterate through the list of candidates
        // for (Candidate : candidates): This line declares a for-each loop to traverse the list of candidates.
        // Each element in the list will be assigned to a variable candidate, the candidate's data type is Candidate, this is the class that the candidate array contains.
        for (Candidate candidate : candidates) {
            // Check if the candidate's type and name match the input criteria
            if (candidate.getTypeCandidate() == typeCandidate && (candidate.getFirstName().contains(nameSearch) || candidate.getLastName().contains(nameSearch))) {
                // Print the details of the matching candidate
                System.out.println("The candidates found: ");
                System.out.println(candidate.toString());
            }
        }
    }

    // Display list of candidate names
    public static void PrintListCandidate(ArrayList<Candidate> candidates) {
        System.out.println("List of candidates:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        // Iterate through the list of candidates
        for (Candidate candidate : candidates) {
            // Check if the candidate is of type Experience (type 0)
            if (candidate.getTypeCandidate() == 0) {
                // Print the first name and last name of the Experience candidate
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        // Iterate through the list of candidates again
        for (Candidate candidate : candidates) {
            // Check if the candidate is of type Fresher (type 1)
            if (candidate.getTypeCandidate() == 1) {
                // Print the first name and last name of the Fresher candidate
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("===========INTERN CANDIDATE==============");
        // Iterate through the list of candidates once more
        for (Candidate candidate : candidates) {
            // Check if the candidate is of type Intern (type 2)
            if (candidate.getTypeCandidate() == 2) {
                // Print the first name and last name of the Intern candidate
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

}

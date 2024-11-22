/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Validation {

    private final static Scanner in = new Scanner(System.in);
    private static final String PHONE_VALID = "^\\d{10}\\d*$";
    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    // Check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        // Loop until user input is correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                // Prompt user to input a number within the specified range
                System.err.println("Input a number in the range [" + min + ", " + max + "]");
                System.out.print("Input again: ");
            }
        }
    }

    // Check user input string
    public static String checkInputString() {
        // Loop until user input is correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                // Prompt user to input a non-empty string
                System.err.println("Input cannot be empty");
                System.out.print("Input again: ");
            } else {
                return result;
            }
        }
    }

    // Check user input for y/Y or n/N
    public static boolean checkInputYN() {
        // Loop until user input is correct
        while (true) {
            String result = checkInputString();
            // Check if user input is either "y/Y" or "n/N"
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            // Prompt user to input "y/Y" or "n/N"
            System.err.println("Input y/Y or n/N.");
            System.out.print("Input again: ");
        }
    }

    // Check if phone number is in valid format (number with minimum 10 characters)
    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            // Check if user input for phone number is valid
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                // Prompt user to input a valid phone number format
                System.err.println("Phone number must be numeric with at least 10 digits");
                System.out.print("Input again: ");
            }
        }
    }

    // Check if email is in valid format
    public static String checkInputEmail() {
        // Loop until user input is correct
        while (true) {
            String result = checkInputString();
            // Check if user input for email is valid
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                // Prompt user to input a valid email format
                System.err.println("Email must be in the format <account name>@<domain>");
                System.out.print("Input again: ");
            }
        }
    }

    // Check user input for graduation rank
    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            // Check if user input for graduation rank is valid
            // equalsIgnoreCase() is used to compare two strings without regard to case difference.
            if (result.equalsIgnoreCase("Excellence") || result.equalsIgnoreCase("Good") || result.equalsIgnoreCase("Fair") || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                // Prompt user to input one of the specified graduation ranks
                System.err.println("Input one of the following: Excellence, Good, Fair, Poor");
                System.out.print("Input again: ");
            }
        }
    }

    // Check if ID exists
    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        // for (Candidate : candidates): This line declares a for-each loop to traverse the list of candidates.
        // Each element in the list will be assigned to a variable candidate, the candidate's data type is Candidate, this is the class that the candidate array contains.
        // If there are any candidates in the list whose id is the same as the id passed in, this condition will return true, and the statement in the if block will be executed.
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                // Prompt user that the ID already exists
                System.err.println("ID already exists.");
                return false;
            }
        }
        return true;
    }

    // Check if experience is less than age
    public static int checkInputExperience(int birthDate) {
        // Used to obtain the current year for comparison or calculation purposes within the program
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                // Prompt user to input experience less than the candidate's age
                System.err.println("Experience must be less than age");
            } else {
                return yearExperience;
            }
        }
    }
}

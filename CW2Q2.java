package cw2.q2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CW2Q2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean validInput = false;
        int studentID = 0;
        String studentName = "";
        int level = 0;
        
        do{
            System.out.println("Enter student ID: ");
            
            if(s.hasNextInt()){
                studentID = s.nextInt();
                s.nextLine(); // Consume newline character left in buffer
                
                System.out.println("Enter student name: ");
                
                if(s.hasNextLine()){
                    studentName = s.nextLine();
                    
                    do {
                        System.out.println("Enter level:\n1. Year 1\n2. Year 2\n3. Year 3\nPick one: ");
                        try {
                            level = s.nextInt();

                            if (level >= 1 && level <= 3) {
                                validInput = true; // Valid input, exit loop
                            } else {
                                System.out.println("Invalid input, please try again!");
                                s.nextLine(); // Consume invalid input
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input, please try again!");
                            s.nextLine(); // Consume invalid input
                        }
                    } while (!validInput);
                }
                else{
                    System.out.println("Invalid input, please try again!");
                    validInput = false;
                }   
            }
            else{
                System.out.println("Invalid input, please try again!");
                s.nextLine(); // Consume invalid input
            }
        }while(!validInput);  
        
        Exam exam = new Exam(studentID,studentName,level);
        // Receive input for scores
        exam.scoresInput();
        // Display exam information
        System.out.println();
        System.out.println(exam.toString());
        System.out.println("Total Scores: " + exam.calcTotalScore());
        System.out.printf("Average Scores: %.2f",exam.calcAverageScore());
        System.out.println("\nMaximum Score: " + exam.maxScore());
    }
}

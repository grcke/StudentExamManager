package cw2.q2;

import java.util.Scanner;

public class Exam{
    private int studentID;
    private String studentName;
    private int level;
    private double[] scores = new double[6];
    
    public Exam(int studentID, String studentName, int level){
        this.studentID=studentID;
        this.studentName=studentName;
        this.level=level;
    }
   
    //getter & setter
    public void setStudentID(int studentID){
        this.studentID=studentID;
    }
    public int getStudentID(){
        return studentID;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setLevel(int level){
        this.level=level;
    }
    public int getLevel(){
        return level;
    }

    public void scoresInput() {
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < scores.length; i++) {
            do {
                System.out.print("Enter score #" + (i + 1) + ": ");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid numeric score.");
                    s.next(); // Consume invalid input
                    System.out.print("Enter score #" + (i + 1) + ": ");
                }

                double score = s.nextDouble();

                if (score >= 0 && score <= 100) {
                    scores[i] = score;
                    break; // Valid input, exit the loop
                } 
                else {
                    System.out.println("Invalid input. Please enter a score between 0 and 100.");
                }
            } while (true);
        }
    }
    
    public double calcTotalScore(){
        double sum = 0;
        for(double score:scores){
            sum += score;
        }
        return sum;
    }
    
    public double calcAverageScore(){
        return calcTotalScore() / 6;
    }
    
    public double maxScore(){
        double max = scores[0];
        for(double score:scores){
            if(score>max)
                max = score;
        }
        return max;
    }
    
    @Override
    public String toString(){
        return "== Exam Information ==\n" + "Student ID: " + getStudentID() + "\nStudent Name: "+ getStudentName()+ "\nLevel: Year " + getLevel() + "\nScores: " + java.util.Arrays.toString(scores);
    }
}

/*
 * Author: Jamie
 * Date: September 17, 2020
 * Version: v1.0
 * Description: This program will take a data set of student scores and will 
 * calculate the number of students who passed, the lowest average, and the 
 * highest average per class.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/**
 *
 * @author revit
 */
public class PassFail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        printSplash();
        //ONLY ONE METHOD IS USED HERE TO AVOID PASSING LARGE AMOUNTS OF VARIABLES
        //BETWEEN METHODS (FOR LITTLE GAIN)
        calculateAverages();
    }

    public static void printSplash() {
        System.out.println("This program will take a data set of student scores");
        System.out.println("and calculate them into weighted averages to determine");
        System.out.println("whether or not the student passed. There will be 3");
        System.out.println("numbers per output line. the number of students who");
        System.out.println("passed the class, the lowest average rounded to 1");
        System.out.println("decimal point, and the hightest average rounded to 1");
        System.out.println("decimal point.\n");
    }

    public static void calculateAverages() throws FileNotFoundException {
        //VARIABLES
        int classSize, studentTest, studentAssignment, studentProject, studentQuiz;
        int passedStudents = 0;
        double testWeight, assignmentWeight, projectWeight, quizWeight, average;
        double lowAverage = 100;
        double highAverage = 0;

        //OBJECTS
        File dataFile = new File("PassFailA103.txt");
        Scanner input = new Scanner(dataFile);
        StringTokenizer st;
        DecimalFormat decimal = new DecimalFormat("0.0");

        //PROCESSING
        do {
            //GETTING THE WEIGHTS AND CLASS SIZE
            st = new StringTokenizer(input.nextLine(), " ");
            testWeight = Double.parseDouble(st.nextToken()) / 100;
            assignmentWeight = Double.parseDouble(st.nextToken()) / 100;
            projectWeight = Double.parseDouble(st.nextToken()) / 100;
            quizWeight = Double.parseDouble(st.nextToken()) / 100;
            classSize = Integer.parseInt(input.nextLine());

            //CALCULATES THE AVERAGE PER STUDENT IN THE CLASS
            for (int i = classSize; i > 0; i--) {
                st = new StringTokenizer(input.nextLine(), " ");
                studentTest = Integer.parseInt(st.nextToken());
                studentAssignment = Integer.parseInt(st.nextToken());
                studentProject = Integer.parseInt(st.nextToken());
                studentQuiz = Integer.parseInt(st.nextToken());

                average = studentTest * testWeight + studentAssignment * assignmentWeight
                        + studentProject * projectWeight + studentQuiz * quizWeight;

                //SEES IF THE AVERAGE IS A NEW HIGH OR LOW
                if (average > highAverage) {
                    highAverage = average;
                }
                if (average < lowAverage) {
                    lowAverage = average;
                }
                
                //TALLIES THE NUMBER OF STUDENTS WHO PASSED
                if (average >= 50) {
                    passedStudents++;
                }

            }
            
            //PRINTS THE RESULTS
            System.out.println(passedStudents + " " + decimal.format(lowAverage)
                    + " " + decimal.format(highAverage));
            
            //RESETS STATS FOR THE NEXT CLASS
            passedStudents = 0;
            highAverage = 0;
            lowAverage = 100;
            
            //AS LONG AS THERE IS MORE DATA TO PROCESS, THE LOOP WILL KEEP GOING
        } while (input.hasNextLine());
    }

}

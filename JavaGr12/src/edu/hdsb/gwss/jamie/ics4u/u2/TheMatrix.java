/*
 * Author: Jamie
 * Date: September 28, 2020
 * Version: v1.1
 * Description: This program uses 2D arrays and manipulates them 4 ways:
 * 1: creating a random array
 * 2: transposing an array
 * 3: multiplying all elements in an array by an integer
 * 4: taking two arrays and multiplying them by each other
 */
package edu.hdsb.gwss.jamie.ics4u.u2;

import java.util.Scanner;

/**
 *
 * @author 4U-Jamie
 */
public class TheMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ALL NEEDED VARIABLES AND OBJECTS ARE INITIALIZED HERE SO THEY WON'T BE 
        //REPEATEDLY INITIALLIZED LATER ON
        int[][] matrix = null;
        int[][] plArray1 = null;
        int[][] plArray2 = null;
        int chosenInt = 0;
        Scanner input = new Scanner (System.in);
        System.out.println("Welcome to the Matrix Program!");
        modeChoice(matrix, input, plArray1, plArray2, chosenInt);
    }
    
    //NO SPLASH PAGE SINCE THE SELECTION MENU IS PRETTY SELF-EXPLANATORY
    /*public static void printSplash() {
        System.out.println("this code does something");
    }*/
    
    public static void modeChoice(int[][] matrix, Scanner input, int[][] plArray1, int[][] plArray2, int chosenInt) {
        System.out.println("Please select one of the following options:");
        System.out.println("1: The Random Matrix");
        System.out.println("2: The Transpose Matrix");
        System.out.println("3: Multiplying a Matrix by a Constant");
        System.out.println("4: Multiplying Two Matrices");
        System.out.println("0: Exit");
        System.out.println("");
        int choice = input.nextInt();
        System.out.println("");
        //ALL THE METHODS CAN RETURN THE OUTPUT ARRAY BUT ONLY THE OUTPUT FROM 
        //THE FIRST METHOD IS STORED TO BE USED FOR METHODS 2 AND 3
        switch(choice) {
            case 1:
                matrix = generateMatrix(input);
                System.out.println("");
                break;
            case 2:
                transposeMatrix(matrix);
                System.out.println("");
                break;
            case 3:
                chosenInt = getInteger(input);
                multiplyMatrixByConstant(matrix, chosenInt);
                System.out.println("");
                break;
            case 4:
                System.out.println("Create the first array");
                plArray1 = generateMatrix(input);
                System.out.println("Create the second array");
                plArray2 = generateMatrix(input);
                multiplyMatrix(matrix, plArray1, plArray2);
                System.out.println("");
                break;
            case 0:
                break;
            default:
                System.out.println("That wasn't a valid option, try again");
                System.out.println("");
                break;
        }
        //KEEPS LOOPING THE METHOD AS LONG AS THE USER CHOOSES NOT TO EXIT
        if (choice != 0) {
            modeChoice(matrix, input, plArray1, plArray2, chosenInt);
        }
        else {
            System.out.println("See you later!");
        }
    }
    
    //GETS THE NUMBER OF ROWS TO GENERATE A RANDOM ARRAY
    public static int getRows(Scanner input) {
        int rows = 0;
        do {
            System.out.print("How many rows should the matrix have?(0-9): ");
            rows = input.nextInt();
            if (rows < 1 || rows > 10) {
                System.out.println("Invalid, try again.");
            }
        } while (rows <= 0 || rows > 10);
        return rows;
    }
    
    //GETS THE NUMBER OF COLUMNS TO GENERATE A RANDOM ARRAY
    public static int getColumns(Scanner input) {
        int columns = 0;
        do {
            System.out.print("How many columns should the matrix have?(0-9): ");
            columns = input.nextInt();
            if (columns < 1 || columns > 10) {
                System.out.println("Invalid, try again.");
            }
        } while (columns <= 0 || columns > 10); 
        return columns;
    }
    
    //GETS AN INTEGER TO MULTIPLY THE WHOLE ARRAY BY
    public static int getInteger(Scanner input) {
        int chosenInt;
        System.out.print("Choose an integer to multiple the array by: ");
        chosenInt = input.nextInt();
        return chosenInt;
    }
    
    //RETURNS THE MAXIMUM VALUE IN AN INTEGER
    public static String maxValue(int[][] array) {
        int maxValue = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }
            }
        }
        return  maxValue + "";
    }
    
    //RETURNS THE MINIMUM VALUE IN AN INTEGER
    public static String minValue(int[][] array) {
        int minValue = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minValue) {
                    minValue = array[i][j];
                }
            }
        }
        return minValue + "";
    }
    
    //PRINTS THE PASSED ARRAY AND DOESN'T RETURN ANYTHING
    public static void displayArray(int[][] array) {
        //ENHANCED FOR LOOPS CAN'T MANIPULATE DATA
        String pl1, pl2;
        int formatLength;
        pl1 = minValue(array);
        pl2 = maxValue(array);
        if (pl1.length() > pl2.length()) {
            formatLength = pl1.length() + 1;
        }
        else {
            formatLength = pl2.length() + 1;
        }
        System.out.println("");
        //USES ENHANCED FOR LOOP
        for (int[] a : array) {
            System.out.print("[ ");
            for (int b : a) {
                System.out.format("%"+formatLength+"s", b + " ");
            }
            System.out.print("]");
            System.out.println("");
        }
        System.out.println("");
    }
    
    //GENERATES A RANDOM MATRIX OF CONTAINING INTEGERS 0-9
    public static int[][] generateMatrix(Scanner input) {
        int rows = getRows(input);
        int columns = getColumns(input);
        int[][] matrix = new int [rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random()*10);
            }
        }
        displayArray(matrix);
        return matrix;
    }
    
    //TRANSPOSES(FLIPS) THE MATRIX SO ITS ROWS BECOME COLUMNS AND VICE VERSA
    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix == null){
            System.out.println("ERROR_2");
            return null;
        }
        
        int[][] transposedMatrix = new int [matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        displayArray(matrix);
        return transposedMatrix;
    }
    
    //MULTIPLIES ALL THE ITEMS IN A MATRIX BY A CHOSEN INTEGER
    public static int[][] multiplyMatrixByConstant(int[][] matrix, int chosenInt) {
        if (matrix == null){
            System.out.println("ERROR_3");
            return null;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] * chosenInt;
            }
        }
        displayArray(matrix);
        return matrix;
    }
    
    //MULTIPLIES TWO RANDOMLY GENERATED MATRIXES IF THEY'RE VALID TO MULTIPLY
    public static int[][] multiplyMatrix(int[][] matrix, int[][] plArray1, int[][] plArray2) {
        //CHECKS IF THE # OF ROWS OF ONE ARRAY AND THE # OF COLUMNS IN ANOTHER
        //SO THAT THEY'RE COMPATABLE TO MULTIPLY
        if (plArray1 == null ||plArray2 == null) {
            System.out.println("ERROR_4");
            return null;
        }
        //CHECKS IF AxB IS VALID
        else if (plArray1[0].length == plArray2.length) {
            matrix = new int[plArray1.length][plArray2[0].length];
            for (int i = 0; i < plArray1.length; i++) {
                for (int j = 0; j < plArray2[0].length; j++) {
                    for (int k = 0; k < plArray2.length; k++) {
                        matrix[i][j] = matrix[i][j] + (plArray1[i][k]*plArray2[k][j]);
                    }
                }
            }
            displayArray(matrix);
            return matrix;
        }
        //IF AxB ISN'T VALID, CHECKS IF BxA IS
        else if (plArray2[0].length == plArray1.length) {
            matrix = new int[plArray2.length][plArray1[0].length];
            System.out.println(matrix.length);
            System.out.println(matrix[0].length);
            for (int i = 0; i < plArray2.length; i++) {
                for (int j = 0; j < plArray1[0].length; j++) {
                    for (int k = 0; k < plArray2[0].length; k++) {
                        matrix[i][j] = matrix[i][j] + (plArray2[i][k]*plArray1[k][j]);
                    }
                }
            }
            displayArray(matrix);
            return matrix;
        }
        else {
            System.out.println("ERROR_4");
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u2;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author revit
 */
public class GameOfLife {
    
    static final boolean ALIVE = true;
    static final boolean DEAD = false;
    static final int ARRAYSIZE = 20;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        boolean [][] oldGen = new boolean [ARRAYSIZE][ARRAYSIZE];
        boolean [][] newGen = new boolean [ARRAYSIZE][ARRAYSIZE];
        int startCells;
        boolean alive = false;
        int neighborCount = 0;
        
        startCells = getInput(input);
        createGenZero(oldGen, startCells);
        printGeneration(oldGen);
        continuousLoop(oldGen, newGen, alive, neighborCount, input);
    }
    
    public static void printSplash() {
        System.out.println("This code does something");
    }

    public static int getInput(Scanner input) {
        int startCells;
        System.out.println("Welcome to the Game of Life!");
        System.out.println("There are 400 cells in a 20x20 grid.");
        System.out.println("Please enter how many live cells you wish to start with:");
        startCells = Integer.parseInt(input.nextLine());
        return startCells;
    }
    
    public static boolean[][] createGenZero(boolean [][] oldGen, int startCells) {
        //TRUE IS ALIVE
        if (startCells > (oldGen.length * oldGen[0].length) / 2) {
            for (int i = 0; i < oldGen.length; i++) {
                Arrays.fill(oldGen[i], true);
            }
            for (int i = 0; i < ((oldGen.length*oldGen[0].length) - startCells); i++) {
                oldGen [(int)(Math.random()*oldGen.length)][(int)(Math.random()*oldGen[0].length)] = false;
            }
        }
        else {
            for (int i = 0; i < startCells; i++) {
                oldGen [(int)(Math.random()*oldGen.length)][(int)(Math.random()*oldGen[0].length)] = true;
            }
        }
        return oldGen;
    }
    
    public static void printGeneration(boolean[][] oldGen) {
        for (int i = 0; i < oldGen.length; i++) {
                for (int j = 0; j < oldGen.length; j++) {
                    if (oldGen [i][j] == true) {
                        System.out.print(" 0");
                    }
                    else {
                        System.out.print(" .");
                    }
                }
                System.out.println("");
            }
        System.out.println("\n");
    }
    
    public static void continuousLoop(boolean[][] oldGen, boolean[][] newGen, boolean alive, 
                                        int neighborCount, Scanner input) {
        String exitWord = "";
        System.out.println("type exit to exit the game");
        System.out.println("otherwise, press enter");
        exitWord = input.nextLine();
        while (!exitWord.equalsIgnoreCase("exit")) {
            newGen = advanceGeneration(oldGen, newGen, alive, neighborCount);
            printGeneration(newGen);
            oldGen = newGen;
            newGen = new boolean [ARRAYSIZE][ARRAYSIZE];
            System.out.println("type exit to exit the game");
            System.out.println("otherwise, press enter");
            exitWord = input.nextLine();
        }
    }
    
    public static boolean[][] advanceGeneration(boolean[][] oldGen, boolean[][] newGen, boolean alive, int neighborCount ) {
        //I IS THE CURRENT ROW
        //J IS THE CURRENT COLUMN
        for (int i = 0; i < oldGen.length; i++) {
            for (int j = 0; j < oldGen[i].length; j++) {
                neighborCount = checkNeighbors(i, j, oldGen, 0);
                //System.out.print(neighborCount);
                newGen[i][j] = updateStatus(neighborCount, oldGen[i][j]);
            }
        }
        return newGen;
    }
    
    public static int checkNeighbors (int row, int column, boolean[][] oldGen, int neighborCount) {
        neighborCount = 0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = column-1; j <= column+1; j++) {
                if (validIndex(i, j, oldGen) && !(i == row && j == column)) {
                    if (oldGen[i][j]) {
                        neighborCount++;
                    }
                }
            }
        }
        return neighborCount;
    }
    
    public static boolean updateStatus(int neighborCount, boolean cell) {
        if (cell == true) {
            if ((neighborCount == 2) || (neighborCount == 3)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (neighborCount == 3){
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public static boolean validIndex(int row, int column, boolean[][] oldGen) {
        if (0 <= row && row < oldGen[0].length) {
            if (0 <= column && column < oldGen.length) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    public static void oldMethod() {
        /*if (i == 0) {
            //IF YOU'RE IN THE TOP ROW...
            if (j == 0){
                //CHECK BOTTOM, BOTTOM RIGHT, AND RIGHT
                //CHECKS THE 3 CELLS TO THE BOTTOM, BOTTOM RIGHT, AND RIGHT
                neighborCount = checkCell(i+1, j, oldGen, neighborCount);
                neighborCount = checkCell(i+1, j+1, oldGen, neighborCount);
                neighborCount = checkCell(i, j+1, oldGen, neighborCount);
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;
            }
            else if (j == (oldGen[i].length - 1)) {
                //CHECK BOTTOM, BOTTOM LEFT, AND LEFT
                //CHECKS THE 3 CELLS TO THE BOTTOM, BOTTOM LEFT, AND LEFT
                neighborCount = checkCell(i+1, j, oldGen, neighborCount);
                neighborCount = checkCell(i+1, j-1, oldGen, neighborCount);
                neighborCount = checkCell(i, j-1, oldGen, neighborCount);
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;
            }
            else {
                //CHECK BOTTOM, BOTTOM LEFT, BOTTOM RIGHT, LEFT, AND RIGHT
                //CHECKS THE 3 CELLS TO THE BOTTOM, BOTTOM RIGHT, AND BOTTOM LEFT
                for (int k = j-1; k < j+2; k++) {
                    neighborCount = checkCell(i+1, k, oldGen, neighborCount);
                }
                //CHECKS THE 2 CELLS TO THE LEFT AND RIGHT
                for (int k = j-1; k < j+2; k += 2) {
                    neighborCount = checkCell(i, k, oldGen, neighborCount);
                }
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;

            }
        }
        else if (i == (oldGen[i].length - 1)) {
            //IF YOU'RE IN THE BOTTOM ROW...
            if (j == 0){
                //CHECK TOP, TOP RIGHT, AND RIGHT
                //CHECKS THE 3 CELLS TO THE TOP, TOP RIGHT, AND RIGHT
                neighborCount = checkCell(i-1, j, oldGen, neighborCount);
                neighborCount = checkCell(i-1, j+1, oldGen, neighborCount);
                neighborCount = checkCell(i, j+1, oldGen, neighborCount);
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;

            }
            else if (j == (oldGen[i].length - 1)) {
                //CHECK TOP, TOP LEFT, AND LEFT
                //CHECKS THE 3 CELLS TO THE TOP, TOP LEFT, AND LEFT
                neighborCount = checkCell(i-1, j, oldGen, neighborCount);
                neighborCount = checkCell(i-1, j-1, oldGen, neighborCount);
                neighborCount = checkCell(i, j-1, oldGen, neighborCount);
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;

            }
            else {
                //CHECK TOP, TOP LEFT, TOP RIGHT, LEFT, AND RIGHT
                //CHECKS THE 3 CELLS TO THE TOP, TOP RIGHT, AND TOP LEFT
                for (int k = j-1; k < j+2; k++) {
                    neighborCount = checkCell(i-1, k, oldGen, neighborCount);
                }
                //CHECKS THE 2 CELLS TO THE LEFT AND RIGHT
                for (int k = j-1; k < j+2; k += 2) {
                    neighborCount = checkCell(i, k, oldGen, neighborCount);
                }
                alive = updateStatus(neighborCount, oldGen[i][j]);
                newGen[i][j] = alive;
            }
        }
        else if (j == 0) {
            //IF YOU'RE IN THE LEFTMOST COLUMN...
            //CHECK TOP, TOP RIGHT, RIGHT, BOTTOM RIGHT, AND BOTTOM
            //CHECKS THE 3 CELLS TO THE TOP RIGHT, RIGHT, AND BOTTOM RIGHT
            for (int k = i-1; k < i+2; k++) {
                neighborCount = checkCell(k, j+1, oldGen, neighborCount);
            }
            //CHECKS THE 2 CELLS TO THE TOP AND BOTTOM
            for (int k = i-1; k < i+2; k += 2) {
                neighborCount = checkCell(k, j, oldGen, neighborCount);
            }
            alive = updateStatus(neighborCount, oldGen[i][j]);
            newGen[i][j] = alive;
        }
        else if (j == (oldGen.length - 1)) {
            //IF YOU'RE IN THE RIGHTMOST COLUMN...
            //CHECK TOP, TOP LEFT, LEFT, BOTTOM LEFT, AND BOTTOM
            //CHECKS THE 3 CELLS TO THE TOP LEFT, LEFT, AND BOTTOM LEFT
            for (int k = i-1; k < i+2; k++) {
                neighborCount = checkCell(k, j-1, oldGen, neighborCount);
            }
            //CHECKS THE 2 CELLS TO THE TOP AND BOTTOM
            for (int k = i-1; k < i+2; k += 2) {
                neighborCount = checkCell(k, j, oldGen, neighborCount);
            }
            alive = updateStatus(neighborCount, oldGen[i][j]);
            newGen[i][j] = alive;
        }
        else {
            //IF YOU'RE ANYWHERE IN THE MIDDLE...
            //CHECKS THE 6 CELLS ABOVE AND BELOW
            for (int k = i-1; k < i+2; k += 2) {
                for (int l = j-1; l < j+2; l++) {
                    neighborCount = checkCell(k, l, oldGen, neighborCount);
                }
            }
            //CHECKS THE 2 CELLS TO THE LEFT AND RIGHT
            for (int k = j-1; k < j+2; k += 2) {
                neighborCount = checkCell(i, k, oldGen, neighborCount);
            }
            alive = updateStatus(neighborCount, oldGen[i][j]);
            newGen[i][j] = alive;
        }*/
    }

}

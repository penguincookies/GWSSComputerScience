/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u4;

/**
 *
 * @author revit
 */
public class CodeHSCombinationLock {
    
    private String code;
    
    public CodeHSCombinationLock() {
        code = "";
        for (int i = 0; i < 4; i++) {
            code += ((char)((Math.random()*26)+97));
        }
    }
    
    public String getClue(String guess) {
        String clue = "";
        int counter = 0;
        if (guess.length() != 4) {
            return "Bad Guess";
        }
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == code.charAt(i)) {
                clue += guess.charAt(i);
            }
            else {
                for (int j = 0; j < code.length(); j++) {
                    if (guess.charAt(i) == code.charAt(j)) {
                        clue += "+";
                        break;
                    }
                    else {
                        counter++;
                    }
                }
                if (counter == code.length()) {
                    clue += "*";
                }
            }
        }
        return clue;
    }
    
    public boolean checkGuess(String guess) {
        return guess.equals(code);
    }
    
    public String printCode() {
        return code;
    }
}

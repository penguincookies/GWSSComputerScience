/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.jamie.ics4u.u1;
import java.util.Scanner;
/**
 *
 * @author revit
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        splashPage();
        String phrase = getPhrase();
        int rotation = getRotation();
        int mode = getMode();
        if (mode == 1){
            encryptPhrase (phrase, rotation);
        }
        else {
            decryptPhrase (phrase, rotation);
        }
    }

    public static void splashPage() {
        System.out.println("This program will encrypt or decrypt a phrase using");
        System.out.println("the simple encrytion method of rotating letters.\n");
    }
    
    public static String getPhrase() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phrase: ");
        String phrase = input.nextLine();
        return phrase;
    }
    
    public static int getRotation() {
        int rotation = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the rotation amount(1-25): ");
        rotation = Integer.parseInt(input.nextLine());
        while (rotation < 0 && rotation > 25) {
            rotation = Integer.parseInt(input.nextLine());
        }
        return rotation;
    }
    
    public static int getMode() {
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Encryption");
        System.out.println("2 - Decryption");
        System.out.print(":");
        int mode = Integer.parseInt(input.nextLine());
        return mode;
    }
    
    public static String encryptPhrase(String phrase, int rotation) {
        phrase = phrase.toUpperCase();
        String newPhrase = "";
        for (int i = phrase.length() - 1; i >= 0; i--) {
            char charPlaceholder = phrase.charAt(i);
            if (charPlaceholder > 64 && charPlaceholder < 91) {
                charPlaceholder = (char)(charPlaceholder + rotation);
                if (charPlaceholder > 90) {
                    charPlaceholder = (char) (charPlaceholder - 26);
                }
            }
            newPhrase = charPlaceholder + newPhrase;
        }
        System.out.println(newPhrase);
        return newPhrase;
    }
    
    public static String decryptPhrase(String phrase, int rotation) {
        phrase = phrase.toUpperCase();
        String newPhrase = "";
        for (int i = phrase.length() - 1; i >= 0; i--) {
            char charPlaceholder = phrase.charAt(i);
            if (charPlaceholder > 64 && charPlaceholder < 91) {
                charPlaceholder = (char)(charPlaceholder - rotation);
                if (charPlaceholder < 65) {
                    charPlaceholder = (char) (charPlaceholder + 26);
                }
            }
            newPhrase = charPlaceholder + newPhrase;
        }
        System.out.println(newPhrase);
        return newPhrase;
    }
    
}

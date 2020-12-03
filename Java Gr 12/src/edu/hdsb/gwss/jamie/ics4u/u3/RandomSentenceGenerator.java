/*
 * Author: Jamie
 * Date: October 6 , 2020
 * Version: v1.1
 * Description: This program will read a text file with grammar and tags to generate
 * a random sentence. The syntax of these files is very specific and the program
 * will not work with improperly formatted files.
 * IMPORTANT: This file does not work with Bionic-Woman-episode.g. It reads 3 lines
 * as one at 115-117, 184-186, and 217-219. I don't know why this happens but it 
 * only occurs with that file in particular and only those 3 lines. It has no
 * problems with the other lines in the file.
 */
package edu.hdsb.gwss.jamie.ics4u.u3;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 */
public class RandomSentenceGenerator {

    public static void main( String[] args ) throws Exception, NullPointerException {

        // FILE LIST
        ArrayList<String> fileList = listFilesInFolder( FILE_PATH );

        // GRAMMAR FILE - 6th - Extension Request
        File grammarFile = new File( FILE_PATH + fileList.get( 11 ) );

        // DATA TYPE FOR ASSIGNMENT
        HashMap<String, ArrayList<String>> grammar = new HashMap<>();

        // SCANNER for the GRAMMER FILE
        Scanner input = new Scanner( grammarFile );
        
        // STRING to store the output
        String sentence = "";
        
        //SPLASH PAGE
        printSplash();
        
        //Adds the tags and their respective sentence fragments to a HashMap
        grammar = addGrammar(grammar, input);
        
        //Generates the output. <start> is passed since it is always the first
        //tag in any file
        sentence = formSentence(grammar, "<start>" );
        
        //Formats output so there will only be 80 or less characters per line
        formatOutput(sentence);
    }
    
    public static void printSplash() {
        System.out.println("-----------Random Sentence Generator-----------");
        System.out.println("This program will take a file of grammar and");
        System.out.println("generate a completely random sentence using it.");
        System.out.println("");
    }
    
    
    public static HashMap<String, ArrayList<String>> addGrammar(HashMap<String, ArrayList<String>> HM, Scanner input) {
        //pl is for Placeholder
        String pl, followingLine;
        StringTokenizer st;
        while (input.hasNextLine()) {
            //Breaks if there is no next line since(only relevant at the end of
            //the file
            pl = nextLine(input);
            if (pl == null) {
                break;
            }
            //Checks if pl is a '{' sinc eonly tags within curley brackets will 
            //be added to the HashMap
            if ("{".equals(pl)) {
                pl = nextLine(input).trim();
                //Checks if pl is a tag
                if ("<".equals(pl.substring(0,1))) {
                    //Initialize a new array list to store all the tag's grammar
                    ArrayList<String> AL = new ArrayList();
                    followingLine = nextLine(input);
                    //Keeps adding grammar as long as the line is not a '}'
                    while (!"}".equals(followingLine)) {
                        AL.add(parseLine(input, followingLine));
                        followingLine = nextLine(input);
                    }
                    //Adds the tag and its corresponding grammar into the HashMap dictionary
                    HM.put(pl.trim(), AL);
                }
            }
        }
        return HM;
    }
    
    public static String parseLine(Scanner input, String followingLine) {
        String str = "";
        String pl;
        //Tokenize the line to find the semicolon
        //Keep the spaces so that multi word lines aren't smushed together and the
        //semicolon is findable
        StringTokenizer st = new StringTokenizer(followingLine, " \t\n", true);
        while (st.hasMoreTokens()) {
            pl = st.nextToken();
            //If the token is a semicolon, you're at the end of the sentence fragment
            //and it's time to return it
            if (";".equals(pl)) {
                break;
            }
            //If the sentence fragment extends for more than 1 line, keeps adding
            //more lines together until a semicolon is found
            else if (!";".equals(pl) && !st.hasMoreTokens()) {
                str = str.concat(pl);
                st = new StringTokenizer(input.nextLine(), " \t\n", true);
                str = str + " ";
            }
            //If you still have tokens left, concat and move on to the next token
            else if (!";".equals(pl)) {
                str = str.concat(pl);
            }
        }
        return str.trim();
    }
    
    public static String formSentence(HashMap<String, ArrayList<String>> grammar, String tag) throws NullPointerException{
        //Gets a random index for the tag
        int randomIndex = (int) (Math.random() * grammar.get(tag).size());
        //placeholderTag, used to check if there are any tags hiding in the sentence
        //fragment(if there are, recursion happens for that tag)
        String plTag;
        String sentenceFragment = "";
        //Tokenizes one random sentence fragment corresponding to the passed tag
        StringTokenizer st = new StringTokenizer(grammar.get(tag).get(randomIndex), " \t.,", true);
        while (st.hasMoreTokens()) {
            plTag = st.nextToken();
            //If one of the words is a tag, recurses to that tag's sentence fragments
            //Then concat the sentence fragments together
            if (grammar.get(plTag.trim()) != null) {
                sentenceFragment = sentenceFragment + formSentence(grammar, plTag);
            }
            //Otherwise just concat the word to the final output
            else {
                 sentenceFragment = sentenceFragment + plTag;
            }
        }
        //Although I'm returning 'sentenceFragment', this is the final String
        //that will be printed
        return sentenceFragment;
    }
    
    //No return since it prints directly to the console
    public static void formatOutput (String sentence) {
        //Tokenize the words to determine their length
        StringTokenizer st = new StringTokenizer(sentence, " \t");
        String word;
        final int MAX_LINE_LENGTH = 80;
        //A counter to keep track of how long the line is getting
        int lengthCount = 80;
        while (st.hasMoreTokens()) {
            word = st.nextToken();
            //Checks the final length of he line first before conating the word
            //to the line
            lengthCount += word.length();
            if (lengthCount <= MAX_LINE_LENGTH) {
                if (word.equals(".") || word.equals(",")) {
                    System.out.print(word);
                }
                else {
                    System.out.print(" " + word);
                }
            }
            //If the line will become too long, moves the word to a new line
            //and resets the counter
            else {
                System.out.print("\n" + word);
                lengthCount = word.length();
            }
        }
        System.out.println("");
    }

    /**
     * RETURN THE NEXT LINE that has useful data.
     *
     * @return the next line, or NULL if there is no useful data.
     */
    public static String nextLine( Scanner input ) {

        String s = null;
        boolean complete = false;

        while( !complete ) {
            if( input.hasNextLine() ) {
                s = input.nextLine();
                if( s.trim().length() > 0 ) {
                    complete = true;
                }
            } else {
                complete = true;
            }
        }

        if( s != null && s.length() == 0 ) {
            s = null;
        }

        return s;

    }

    /**
     * NO NEED TO UNDERSTAND BELOW
     */
    public static ArrayList<String> listFilesInFolder( String path ) {

        // DATA FOLDER
        File folder = new File( path );

        // FILE LISTING
        ArrayList<String> fileList = new ArrayList<>();

        // LOAD GRAMMAR FILES
        for( final File fileEntry : folder.listFiles() ) {
            fileList.add( fileEntry.getName() );
        }

        // SORT
        Collections.sort( fileList );

        return fileList;

    }

    // CLASS CONSTANTS
    private static final String FS = File.separator;
    private static final String FILE_PATH = "." + FS + "data" + FS + "random.sentence.generator" + FS;

}

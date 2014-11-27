
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *  Joseph Zhong
 *  ASSIGNMENT_NUMBER
 *  PROGRAM_DESCRIPTION
 *  PROGRAM_TITLE
 *  DATE
 *
 **/

public class Main
{


    public static void main(String[] args)
    {
        intro();
        startPrompt();
    }

    public static void intro()
    {
        System.out.println("Welcome to the game of Mad Libs. "
                + "\nI will ask you to provide various words"
                + "\nand phrases to fill in a story."
                + "\nThe result will be written to an output file."
                + "\n");
    }

    public static void startPrompt()
    {
        Scanner scn = new Scanner(System.in);
        //char userChoice = 'a';
        while(true)
        {
            System.out.print("(C)reate mad-lib, (V(iew mad0lib, (Q)uit? ");
            String temp = scn.next().toLowerCase();
            scn.nextLine();
            if(temp.startsWith("c"))
            {
                //scn.close();
                createInput(scn);
                createOutput(scn);
                break;
            }
            else if(temp.startsWith("v"))
            {
                scn.close();
                viewMadLib();
                break;
            }
            else if(temp.startsWith("q"))
            {
                scn.close(); // necessary?
                //System.exit(0);
                break;
            }
            else // bad input
            {
                System.out.println("I don't understand.");
            }
        }

    }

    public static void createInput(Scanner _scn)
    {
        String inputFileName;
        System.out.print("Input file name: ");
        while(true)
        {
            inputFileName = _scn.nextLine(); // takes input file name
            //_scn.close();
            File inputFile = new File(inputFileName);
            try
            {
                _scn = new Scanner(inputFile);
                // if success, break and continue
                return;
            }
            catch(FileNotFoundException e)
            {
                System.out.print("File not found. Try again: ");
                _scn = new Scanner(System.in);
            }
        }
    }

    public static void createOutput(Scanner _scn)
    {
        PrintStream output;
        System.out.print("Output file name: "); // test if worked with scanner
        while(true)
        {
            _scn = new Scanner(System.in);
            String outputFileName = _scn.nextLine();
            File outputFile = new File(outputFileName);
            try
            {
                //System.out.println(outputFileName);
                _scn = new Scanner(outputFile);
                return;
            }
            catch(FileNotFoundException e)
            {
                System.out.print("File not found. Try again: ");
            }
        }
    }

    public static void viewMadLib()
    {

    }


}

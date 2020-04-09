/*
Andrew Tong
Mr. Tomczak
September 13, 2019
MP1

This program reads in up to 25 unique strings, delimited by a comma, from MP1.txt and inputs it into an array. 
It also creates a new array that keeps track of the occurences of each string.
Then, it prints the unique string and its count both to the console and to MP1.out.txt.
The delimiter can be changed in the code.

 */
package mp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Mp1 {

    public static void main(String[] args) throws FileNotFoundException
    {
        //Construct File Object to create file pointer, Scanner object to read, and PrintWriter object to write
       File inFile=new File("MP1.txt");
       Scanner in=new Scanner(inFile).useDelimiter("\\s*,\\s*");//allows programmer to set the delimiter inside //s*
       PrintWriter out=new PrintWriter("MP1.out.txt");

       String[] unique= new String[25];//creates an array that includes up to 25 unique strings
       
       //description message
       System.out.println("This program reads in up to 25 unique strings, delimited by a comma, from MP1.txt and inputs it into an array. \n" +
       "It also creates a new array that keeps track of the occurences of each string.\n" +
       "Then, it prints the unique string and its count both to the console and to MP1.out.txt.\n" +
       "The delimiter can be changed in the code to anything you want.");
       
       int[] counts= new int[25];
       for (int i=0; i<counts.length; i++)
       {
           counts[i]=1;//initializes all of the unique string counts to be 1 
       }
       boolean found=false;
       
       int pos=0;//starts the array size to be 0
       while (in.hasNext())
       {
           String input=in.next();//reads in each phrase individually separated by delimiter set forth in 

           for (int i=0; i<pos; i++)
           {
               if (input.equals(unique[i]))
               {
                   counts[i]++;//increases the count if found
                   found=true;
               }
               
           }
           
           if (!found)
           {
               unique[pos]=input;//adds the phrase into the array
               pos++;//increases size of unique array for testing next phrase
           }
        
           found=false;//resets so that after a duplicate, loop can continue to run normally
       }
       
       for (int i=0; i<pos; i++)//only goes up to pos so that it skips the nulls in the array
       {
           System.out.println(unique[i]+": " +counts[i]);//prints unique words and counts of the word into console
           out.println(unique[i]+": " +counts[i]);//prints into mp1.out.txt
       }
 
       in.close();
       out.close();//to fully save the file
    }
    
}

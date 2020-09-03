import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class Listing //Java feels a lot like C++, the difference is the structs are missing.
{
    //private String name = " "; //Declaring and Setting values
    private int age = 0; //Declaring and Setting values
    private String name = " ";
    public Listing(int agePass,String namePass)
    {
        age = agePass;
        name = namePass;
    }
    public String toString()
    {
        //return ("INT:\n" + x + "String:\n" + name);
        //return (x + name);
        return ("Listing Age: " + age +" Listing Name: "+ name);
    }
    public int getAge()
    {
        return age;
    }
    public String getName()
    {
        return name;
    }
    public void setAge(int setageV)
    {
        age = setageV;
    }
    public void setName(String setnameV)
    {
        name = setnameV;
    }
    public void input()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String nameI = myObj.nextLine();
        System.out.println("Please enter your age:");
        int ageI = myObj.nextInt();
        // Output input by user
        age = ageI; //ageInput
        name = nameI; //agename
    }
    public static void JB007()
    {
        Listing modern007 = new Listing(90,"Sean Connery");
        Listing older007 = new Listing(90,"Sean Connery");
        int current007Age = modern007.getAge();
        String current007Name = modern007.getName();
        System.out.println("Printing the first James Bond:\n" + older007);
        System.out.println("Printing the current James Bond:\n" + modern007);
        System.out.println("Seems like we have a bug...");
        //Implement bug fix
        modern007.setAge(52);
        modern007.setName("Daniel Craig");
        System.out.println("Bug fixed, printing the current James Bond:\n" + modern007);
        
    }
    public static void inputExample()
    {
        Listing inputTest = new Listing(0,"Default");
        inputTest.input(); 
        System.out.println(inputTest);
    }
    public static void inputPrompt()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("If you'd like to test input functionality please press 1.\nElse press 2 to exit.");
        int trigger = myObj.nextInt();
        switch (trigger) {
            case 1: inputExample();
            break;
            case 2:
            System.out.println("Closing program");
            break;
        }
    }
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        JB007();
        inputPrompt();
    }
}
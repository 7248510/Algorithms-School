import java.io.*;
import java.lang.*;
//Java classes can't start with a number
class Listing //Java feels a lot like C++, the difference is the structs are missing.
{
    private String name = " "; //Declaring and Setting values
    private int age = 0; //Declaring and Setting values
    //public Listing()
    String public Listing() //The no-parameter constructor
    {
        return "Cyber command?";
    }
    String Listing(String name)
    {
        return "Wanna work for the DOD?";
    }
    void input()
    {      
        //Use the scanner to get the users input
    }
    public String getName(String nameInput)
    {
        name = nameInput;
        return "NSA'S THE DREAM";
    }
    public String toString()
    {

    }
    public int getAge(int ageInput)
    {
        age = ageInput;
        return 0;
    }   
}

public class ex41
{
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        //Listing madeup;
        //madeup = new Listing(getName, getAge);
        System.out.println("Hello friend");
    }
}
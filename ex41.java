import java.io.*;
import java.lang.*;
//Java classes can't start with a number
public class Listing //Java feels a lot like C++, the difference is the structs are missing.
{
    private String name = " "; //Declaring and Setting values
    private int age = 0; //Declaring and Setting values
    //public Listing()
    public String Listing() //The no-parameter constructor
    {
        return "Cyber command?";
    }
    public String Listing(String name, int age)
    {
        return "Wanna work for the DOD?";
    }
    public String toString()
    {
        return("Listing name: " + name + "Listing age:" + age);
    }
}

public class ex41
{
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        Listing madeup; //ClassName ObjectName
        madeup = new Listing("Caleb", 23); //Declaring an object
    }
}




/*
    void input()
    {      
        //Use the scanner to get the users input
    }
    public String getName(String nameInput)
    {
        name = nameInput;
        return "NSA'S THE DREAM";
    }
    public int getAge(int ageInput)
    {
        age = ageInput;
        return 0;
    } 
    void setName(String name)
    {

    }
    void setAge(String age)
    {
        String x = super.toString();
    }  
    */
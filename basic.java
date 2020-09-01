import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class basic //Java feels a lot like C++, the difference is the structs are missing.
{
    //private String name = " "; //Declaring and Setting values
    private int x = 0; //Declaring and Setting values
    private String z = " ";
    public basic(int y,String w)
    {
        x = y;
        z = w;
    }
    public String toString()
    {
        //return ("INT:\n" + x + "String:\n" + z);
        //return (x + z);
        return ("Listing Age: " + x +" Listing Name: "+ z);
    }
    public int getAge()
    {
        return x;
    }
    public String getName()
    {
        return z;
    }
    public void setAge(int setageV)
    {
        x = setageV;
    }
    public void setName(String setnameV)
    {
        z = setnameV;
    }
    public void input()
    {
        Scanner myObj = new Scanner(System.in);
        // String input
        String name = myObj.nextLine();
        // Numerical input
        int age = myObj.nextInt();
        // Output input by user
        x = age;
        z = name;
    }
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        System.out.println("Enter a user name");
        basic madeup = new basic(78,"DOD is the dream"); //ClassName ObjectName
        //System.out.println(madeup);
        basic tao = new basic(007,"GCHQ much?");
        //System.out.println(tao);
        basic tom = new basic(700,"James bond?");
        basic inputTest = new basic(0,"Default");
        inputTest.input(); 
        int tomsAge = tom.getAge();
        String tomsName = tom.getName();
        //int tomsAge = tom.setAge(500);
        tom.setAge(20);
        tom.setName("Working at the agency would be really cool");
        System.out.println(tom.toString());
        System.out.println(tao);
        System.out.println(madeup);
        System.out.println(inputTest);
    }
}
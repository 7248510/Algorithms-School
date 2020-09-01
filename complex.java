import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class complex //Java feels a lot like C++, the difference is the structs are missing.
{
    //private String name = " "; //Declaring and Setting values
    private int x = 0; //Declaring and Setting values
    private String z = " ";
    public complex(int y,String w)
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
        System.out.println("Please enter your name: ");
        String name = myObj.nextLine();
        System.out.println("Please enter your age:");
        int age = myObj.nextInt();
        // Output input by user
        x = age;
        z = name;
    }
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        //Person[] employee;
        //employee = new Person[3];
        complex[] test;
        test = new complex[3];
        test[0] = new complex(0,"default");
        test[1] = new complex(1,"default");
        test[2] = new complex(2,"default");
        test[0].input();
        test[1].input();
        test[2].input();
        for (int i = 2; i >= 0; --i) //When setting your loops make sure to start at the actual value, 3 wouldn't work...
        {
            //System.out.println(i); //Testing
            System.out.println(test[i]);
        }
        /*
        threeListings[] complex = new complex[3]; //3 spaces of memory for complex, starting at 0
        threeListings[0] = "Alpha" + 80;
        threeListings[1] = "NSA" + 49;
        threeListings[2] = "CIA" + 50;
        */
    }
}
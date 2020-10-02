import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class listingArray
{
    private int age = 0; //Declaring and Setting values
    private String name = " "; //Declaring and Setting values
    public listingArray(int agePass,String namePass)
    {
        age = agePass;
        name = namePass;
    }
    public String toString()
    {
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
        // String input
        System.out.println("Please enter your name: ");
        String nameI = myObj.nextLine();
        System.out.println("Please enter your age:");
        int ageI = myObj.nextInt();
        // Output input by user
        age = ageI;
        name = nameI;
    }
    public static void arrayOut()
    {
        listingArray[] listArray;
        listArray = new listingArray[3]; //Allocating three instances
        listArray[0] = new listingArray(0,"default");
        listArray[1] = new listingArray(1,"default");
        listArray[2] = new listingArray(2,"default");
        listArray[0].input();
        listArray[1].input();
        listArray[2].input();
        for (int i = 2; i >= 0; --i) //When setting your loops make sure to start at the actual value, 3 wouldn't work... 0,1,2
        {
            System.out.println(listArray[i]); //Outputting i, initializing I to 2, condition = i less than or equal to 0, if valid decrement the loop
        }
    }
    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        arrayOut();
    }
}
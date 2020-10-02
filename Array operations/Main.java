import java.io.*;
import java.lang.*;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Please input the maximum size of the data set.");
        Scanner myObj = new Scanner(System.in);
        int catalyst = myObj.nextInt();
        System.out.println("Please enter the initial number of students.");
        int askStudent = myObj.nextInt();
        System.out.println("Please enter the inital dataset.");
        String dataSet = myObj.next();
        StudentListings information = new StudentListings(catalyst);
        information.choice();
    }
}
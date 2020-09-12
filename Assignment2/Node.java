//This represents one student
import java.util.Scanner;
public class Node
{
    private String name;
    private String uid;
    private String gpa;
    public Node(String nameiD, String suiD, String sgpA)
    {
        name = nameiD;
        uid = suiD;
        gpa = sgpA;
    }
    public String toString() //Same as the AS1, granted Java automatically makes a string if you have an int + String
    {
        return "Name: " + name + " Unique Idenification: " + uid + " Grade point average: "+ gpa;
    }
    public Node deepCopy() //Same as the AS1
    {
        Node clone = new Node(name, uid, gpa);
        return clone;
    }
    public int compareTo(String targetKey)
    {
        return(name.compareTo(targetKey));
    }
    public void setuid(String suiD)
    {
        uid = suiD;
    }
    public Node input()
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String nameI = myObj.nextLine();
        System.out.println("Please enter your GPA:");
        String gpaI = myObj.nextLine();
        System.out.println("Please enter your age:");
        String uidI = myObj.nextLine();
        // Output input by user
        uid = uidI; //Getting the passed values
        name = nameI; //Getting the passed values
        gpa = gpaI; // Getting the passed values
        Node inputData = new Node(nameI, uidI, gpaI);
        return inputData;
    }
}
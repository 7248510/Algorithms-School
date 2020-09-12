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
    public String toString()
    {
        return name + uid + gpa;
    }
    public Node deepCopy()
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
        System.out.println("Please enter your age:");
        String gpaI = myObj.nextLine();
        System.out.println("Please enter your age:");
        String uidI = myObj.nextLine();
        // Output input by user
        uid = uidI; //ageInput
        name = nameI; //agename
        gpa = gpaI;
        Node inputData = new Node(nameI, uidI, gpaI);
        return inputData;
    }
}
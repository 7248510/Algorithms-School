//Exercise 30 and 31
//javac *.java && java Main
/*
References
https://www.youtube.com/watch?v=9Jry5-82I68
https://www.geeksforgeeks.org/binary-tree-data-structure/
https://www.youtube.com/watch?v=vvey2QCs98o
https://www.tutorialspoint.com/data_structures_algorithms/tree_data_structure.htm
https://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.htm
https://www.tutorialspoint.com/data_structures_algorithms/binary_search_tree.htm
https://www.youtube.com/watch?v=PAA2mKGNf6Q
https://en.wikipedia.org/wiki/Binary_tree
Data Structures and Algorithms Using Java
*/
import java.io.*; 
class Listing //Exact same class as previous problems. The only method I added is the getKey method
{
    private String name;
    private String uid;
    private String gpa;
    public Listing(String nameiD, String suiD, String sgpA)
    {
        name = nameiD;
        uid = suiD;
        gpa = sgpA;
    }
    public String toString() //Same as the AS1, granted Java automatically makes a string if you have an int + String
    {
        return "Name: " + name + " Unique Idenification: " + uid + " Grade point average: "+ gpa;
    }
    public Listing deepCopy() //Same as previous assignments
    {
        Listing clone = new Listing(name, uid, gpa);
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
    public String getKey() {
        return name;
    }
}
public class Main {
    public static void main(String[] args)
        {  
            BinaryTree test = new BinaryTree();
            Listing l9 = new Listing("Zane", "000000", "1.50"); //Zane
            Listing l0 = new Listing("Austin", "000000", "1.50"); //Powers
            Listing l1 = new Listing("Caleb", "000001", "3.89"); //Me
            Listing l2 = new Listing("Johnny", "000002", "4.00");
            Listing l3 = new Listing("Victoria", "000003", "2.68");
            Listing l4 = new Listing("Scully", "000004", "4.5"); //The truth is out there
            Listing l5 = new Listing("Mulder", "000005", "3.64"); //The truth is out there
            Listing l6 = new Listing("James Bond", "REDACTED", "REDACTED"); //007
            Listing l7 = new Listing("Smoking man", "REDACTED", "REDACTED"); //No comment necessary
            Listing l8 = new Listing("Chuck", "000008", "4.00"); //Nerd herd
            test.insert(l0);
            test.insert(l1);
            test.insert(l2);
            test.insert(l3);
            test.insert(l4);
            test.insert(l5);
            test.insert(l6);
            test.insert(l7);
            test.insert(l8);
            test.insert(l9);
            System.out.println("Fetching operations");
            System.out.println(test.fetch("Caleb"));
            System.out.println(test.fetch("Scully"));
            System.out.println(test.fetch("Austin"));
            System.out.println("\n");
            System.out.println("Outputting ascending order");
            test.showAll();
            System.out.println("\n");
            System.out.println("Outputting everyone in descending order");
            test.descending();
            System.out.println("\n");
            System.out.println("Demonstrating delete operations");
            System.out.println("Fetching Zane");
            System.out.println(test.fetch("Zane"));
            System.out.println("Deleting Zane");
            test.delete("Zane");
            System.out.println("Fetching Zane");
            System.out.println(test.fetch("Zane"));
            System.out.println("\n");
            System.out.println("Demonstrating update operations\nUpdating Chuck to James Bond. Guess the nerd herd position worked out!");
            test.update("Chuck", l8);
            test.showAll();
            System.out.println("\n");
            System.out.println("Starting the menu functionality");
            test.choice();
    }
}
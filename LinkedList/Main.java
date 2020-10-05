//This represents one student
//I've picked 25 and 27 to complete in the book, I'm using my code from chapter 2(for the Listing class/input)
//I've used the book for reference
import java.util.Scanner;
//This is from the assignment 2
class Listing
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
    public Listing deepCopy() //Same as the AS1
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
    public Listing input()
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
        Listing inputData = new Listing(nameI, uidI, gpaI);
        return inputData;
    }
}
//Implementing Linked List
//The methods are the same from previous assignements, the only difference is the logic/flow of the program.
class SinglyLinkedList
{
    private Node host; //Getting the host node
    public SinglyLinkedList() {
    host = new Node(); //Getting the inital Node
    host.list = null; //Setting the list to null and the next host node
    host.next = null;
    }
    public boolean insert(Listing newListing) //Getting your class as well as the new node values
    { 
        Node nextNode = new Node(); //Spawning your new node
        if (nextNode == null) { //If the next node is null, return false. Because it wouldn't be valuid
            return false;
        }
        else {
            nextNode.next = host.next; //Set your nextNode to the current host
            host.next = nextNode; //Setting the current not to your next node/adding to the list
            nextNode.list = newListing.deepCopy(); //Deep copy the node and clone it
            return true; //If all goes well using a boolean value
        }
    }
    public Listing fetch(String targetKey)
    {
        Node pastNode = host.next; //Setting the current target
        while (pastNode != null && !(pastNode.list.compareTo(targetKey) == 0)) //Loop through until the targetKey matches
        {
            pastNode = pastNode.next; //Keep setting until your conditions are satisfied
        }
        if (pastNode != null) {
            return pastNode.list.deepCopy(); //Return the desired node
        }
        else {
            return null; //Something went wrong, it shouldn't be null(I Haven't encountered this while testing.)
        }
    }
    public boolean delete(String targetKey) { //Passing the target value
        Node deleteMe = host;
        Node pastNode = host.next;
        while (pastNode != null && !(pastNode.list.compareTo(targetKey) == 0)) { //same logic as fetching except we delete the desired node
            deleteMe = pastNode;
            pastNode = pastNode.next; //Setting the past node to the next instance
        }
        if (pastNode != null) {
            deleteMe.next = pastNode.next; //Succesfully deleted
            return true;
        }
        else {
            return false; //Unfortunately your node didn't get dropped from the list
        }
    }
    public boolean update(String targetKey, Listing newListing) //Getting the target and assigning it a newlisting instance
    {
        if (delete(targetKey) == false) { //Checking if the node has been delted
            return false;
        }
        else if (insert(newListing) == false) { //Checking if you can update the new node aka insert it.
            return false;
        }
        return true; //Else return true!
    }
    public void showAll()
    {
        Node pastNode = host.next;
        while(pastNode != null) //At first it seemed like an infinite loop, that wasn't the case.
        {
            System.out.println(pastNode.list.toString());
            pastNode = pastNode.next; //Looping through
        }
    }
    public class Node
    {
        private Listing list;
        private Node next;        
    }
}


public class Main
{
    public static void demo(){
        System.out.println("DEMO STARTS:\n");
        SinglyLinkedList linkeddemonoInput = new SinglyLinkedList();
        Listing l3 = new Listing("Bob", "Third ave", "243-206-5255");
        Listing l4 = new Listing("Douglas", "Fourth ave", "123-896-5555");
        Listing l5 = new Listing("Suzan", "Fifth ave", "125-394-2049");
        System.out.println("Inserting Bob and Douglas");
        linkeddemonoInput.insert(l3);
        linkeddemonoInput.insert(l4);
        System.out.println("Showing Bob and Douglas");
        linkeddemonoInput.showAll();
        System.out.println("Fetching Bob:");
        System.out.println(linkeddemonoInput.fetch("Bob"));
        System.out.println("Deleting Bob:");
        linkeddemonoInput.delete("Bob");
        System.out.println("Showing the current list:");
        linkeddemonoInput.showAll();
        System.out.println("Updating Douglas to Suzan.");
        linkeddemonoInput.update("Douglas", l5);
        System.out.println("Showing the current list:");
        linkeddemonoInput.showAll();
    }
    public static void choice()
    {
        Listing x6 = new Listing("Peter", "sixth lane", "246-879-9683");
        Listing x7 = new Listing("Justin", "seventh lane", "263-829-9683");
        Listing x3 = new Listing("Caleb", "third lane", "123-896-5555");
        Listing x8 = new Listing("Bill", "eigth lane", "528-931-3678");
        Listing x9 = new Listing("William", "ninth lane", "285-341-1249");
        SinglyLinkedList linkedDemo = new SinglyLinkedList();
        linkedDemo.insert(x6);
        linkedDemo.insert(x7);
        linkedDemo.insert(x8);
        linkedDemo.insert(x9);
        System.out.println("MENU FUNCTIONALITY:\n");
        String message = "Press 1 to insert a new students information:\nPress 2 to fetch and output a students information\nPress 3 to delete a students information\nPress 4 to update a students information\nPress 5 to output all the students information\npress 6 to exit";
        System.out.println(message);
        Scanner myObj = new Scanner(System.in);
        int catalyst = myObj.nextInt();
        if  (catalyst == 1) {
            Listing x1 = new Listing("Tyler", "1st input ave", "123-896-5555");
            Listing x2 = new Listing("John", "2nd input ave", "124-596-5555");
            System.out.println("You've input Tyler and John");
            linkedDemo.delete("Peter");
            linkedDemo.delete("Justin");
            linkedDemo.delete("Caleb");
            linkedDemo.delete("Bill");
            linkedDemo.delete("William");
            linkedDemo.insert(x1);
            linkedDemo.insert(x2);
            System.out.println("Outputting Tyler and John");
            linkedDemo.showAll();
            choice();
        }
        if (catalyst == 2) {
            linkedDemo.showAll();
            System.out.println("Please select a students information to fetch.\nUse the first name in the operation.");
            String choice = myObj.next();
            System.out.println(linkedDemo.fetch(choice));
            choice();
        }
        if  (catalyst == 3) {
            linkedDemo.showAll();
            System.out.println("Please enter a name to delete");
            String choice = myObj.next();
            linkedDemo.delete(choice);
            System.out.println("Deleted" + " "+ choice);
            System.out.println("Showing current list:\n");
            linkedDemo.showAll();
            choice();
        }
        if  (catalyst == 4) {
            System.out.println("Fixing a mistake, updating Bill to William");
            linkedDemo.showAll();
            linkedDemo.update("Bill", x9);
            System.out.println("\n");
            linkedDemo.showAll();
            choice();
        }
        if  (catalyst == 5) {
            linkedDemo.showAll();
            choice();
        }
        if  (catalyst == 6) {
            System.out.println("Exiting the program.");
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        demo();
        System.out.println("\n");
        choice();
    }
}
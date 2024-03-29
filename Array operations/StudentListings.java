//insert, fetch, update, delete

import java.util.Scanner;
public class StudentListings
{
    private int next;
    private int size;
    private Node[] data;

    public StudentListings(int sizeofArray)
    {
        next = 0;
        size = sizeofArray;
        data = new Node[size]; //Allocating our array
    }
    public boolean insert(Node newNode)
    {
        if (next >= size) //Error, cannot insert
        {
            return false;
        }
        data[next] = newNode.deepCopy();
        if (data[next] == null) {
            return false;
        }
        next = next + 1; //Adding the node
        return true; //Evaluating the action to true!
    }
    public Node fetch(String targetKey)
    {
        Node node;
        Node temp;
        //Using a sequential search, the book helped/guided with this
        int i = 0;
        while (i < next && !(data[i].compareTo(targetKey) == 0)) //
        {
            i++; //Itterating i to find the correct node.
        }
        if (i==next) {
            return null; //This is for if the node hasn't been found
        }
        node = data[i].deepCopy(); //Setting a deep copy of the node's information
        //Moving the node up one unless the first node.
        if(i != 0) {
            temp = data[i - 1];
            data[i - 1] = data[i];
            data[i] = temp;
        }
        return node; //returning the fetched node
    }
    public boolean delete(String targetKey) //Uses the students name as the key.
    { //Using the sequential search
        int i = 0;
        while(i < next && !(data[i].compareTo(targetKey) == 0))
        {
            i++;
        }
        if (i == next) { //If node isn't found
            return false;
        }
        //Moving the last node 
        data[i] = data[next - 1];
        data[next - 1] = null;
        next = next - 1;
        return true; //If the nodes found and deleted
    }
    public void showAll()
        {
            for (int i = 0; i < next; i++) {
                System.out.println(data[i].toString());
            }   
        }  
    public boolean update(String targetKey, Node newNode) //Ussing the name, and passing the new Node's position
    {
        if (delete(targetKey) == false){
            return false;
        }
        else if (insert(newNode) == false) {
            return false;
        }
        else {
            return true;
        }
    }
    public void createnewLine() {
        System.out.println("");
    }
    public void choice()
    {
        StudentListings information = new StudentListings(100);
        String message = "Press 1 to insert a new students information:\nPress 2 to fetch and output a students information\nPress 3 to delete a students information\nPress 4 to update a students information\nPress 5 to output all the students information\npress 6 to exit";
        System.out.println(message);
        Scanner myObj = new Scanner(System.in);
        int catalyst = myObj.nextInt();
        Node julia = new Node("Julia", "234", "4.00");
        Node johnny = new Node("Johnny", "857", "3.00");
        Node chuck = new Node("Chuck", "007", "4.01");
        Node Suzan = new Node("Suzan", "344", "4.00");
        information.insert(johnny);
        information.insert(chuck);
        information.insert(julia);
        if  (catalyst == 1) {
            Node inputStudent = new Node(" ", " ", " ");
            inputStudent.input();
            information.insert(inputStudent);
            System.out.println("You've input a student would you like to return to the menu?\n1 for yes, 2 for no.");
            information.showAll();
            this.choice();
        }
        if (catalyst == 2) {
            System.out.println("Please select a students information to fetch.\nUse the first name in the operation.");
            information.showAll();
            String choice = myObj.next();
            System.out.println("Fetched\n"+ information.fetch(choice).toString());
            information.createnewLine();
            this.choice();
        }
        if  (catalyst == 3) {
            information.showAll();
            String choice = myObj.next();
            System.out.println("Deleted:\n"+ information.delete(choice));
            information.createnewLine();
            information.showAll();
            information.createnewLine();
            this.choice();
        }
        if  (catalyst == 4) {
            information.showAll();
            System.out.println("Fixing a mistake, updating John to Suzan");
            information.update("Johnny", Suzan);
            information.showAll();
            information.createnewLine();
            this.choice();
        }
        if  (catalyst == 5) {
            information.showAll();
            this.choice();
        }
        if  (catalyst == 6) {
        System.exit(0);
        }
    }
}
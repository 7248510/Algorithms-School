import java.lang.*;
import java.io.*;
//LIFO
class Stack
{
    private Listing[] data;
    private int top;
    private int size;
    private int stackCount;
    public Stack()
    {
        stackCount = 3; 
        top = -1; //The top of the stack is -1(If it returns a negative value)
        size = 3; //Initalizing the stack to 100
        data = new Listing[stackCount]; //If data doesn't have enough it will cause an index out of bounds aka overflow, allocating 10 spaces
    }
    public Stack(int n)
    {
        top = -1;
        size = n;
        data = new Listing[n];
    }
    public boolean push(Listing newNode) {
        if(top == size - 1) { 
        return false;
    }  
        else {
            top = top + 1;
            data[top] = newNode.deepCopy();
            return true;
        }
    }
    public Listing pop(Listing newNode)
    {
        int topLocation;
        if(top == -1) {
            return null; //Underflow, not an overflow
        }
        else {
            topLocation = top;
            top = top - 1;
            return data[topLocation];
        }
    }
    public void showAll()
    {
        for(int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
    public String emptyStack() //Emptying the current stack
    {
        int topLocation;
        topLocation = top;
        //Implementing a loop until we get to -1, therfore emptying the stack
        //System.out.println(data[topLocation]);
        //System.out.println(topLocation);
        for (topLocation = topLocation; topLocation > 0; --topLocation) {
            top = 0-1;
        }
        System.out.println("Stack empty");
        return "Reinitalized the stack to 0";
    }
    public boolean empty() //Testing if the stack is empty
    {
        String condition;
        int topLocation;
        topLocation = top;
        if (top < 0) {
            condition = "The stack is empty";
            System.out.println(condition);
        }
        else if (top >= 0) {
            condition = "The stack is not empty";
            System.out.println(condition);
            
        } 
        return true;
    }
    public int bufferoflowDetect() {
        int topLocation = top;
        //Size cannot be greater than data[top], if it is then we have a buffer overflow, Java also won't allow the program to run.
        if (topLocation > size) {
            System.out.println("Buffer overflow detected\nAllocating more spaces");
        }
        if (topLocation == size) {
            System.out.println("No bufferoverflow");
            return 0;
        }
        if (topLocation < size) {
            System.out.println("No bufferoverflow");
            return 0;
        }
        return 0;
    }
}
//Listing begins
class Listing
{
    private String name;
    private String address;
    private String number;
    public Listing()
    {
        name = " ";
        address = " ";
        number = " "; 
    }
    public Listing(String nameSpec, String addressSpec, String numberSpec)
    {
        name = nameSpec;
        address = addressSpec;
        number = numberSpec;
    }
    public String toString()
    {
        return ("Name: " + name + "Address: " + address + "Number: " + number);
    }
    public Listing deepCopy()
    {
        Listing clone = new Listing(name,address,number);
        return clone;
    }
}
class Queue
{
    private Listing[] data;
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;
    public Queue() //Same constructor as the one below, the only differences is a passed value.
    {
        size = 100;
        numOfNodes = 0;
        front = 0;
        rear= 0;
        data = new Listing[100];
    }
    public Queue(int n) 
    {
        size = n;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        data = new Listing[n];
    }
    public boolean enqueue(Listing newNode)
    {
        if(numOfNodes == size)
        {
            return false; //Bufferoverflow (Soon to join the CVE table) [If it returns false its an overflow]
        }
        else {
            numOfNodes = numOfNodes + 1;
            data[rear] = newNode.deepCopy();
            rear = (rear + 1) % size;
            return true;
        }
    }
    public Listing dequeue(Listing newNode)
    {
        int frontLocation;
        if (numOfNodes ==0) {
            return null;
        }
        else {
            frontLocation = front;
            front = (front + 1) & size; 
            numOfNodes = numOfNodes -1;
            return data[frontLocation];
        }
    }
    public void showAll()
    {
        int i = front;
        for (int c = 1; c <= numOfNodes; c++) //Gotta love C++ :)
        {
            System.out.println(data[i].toString());
            i = (i + 1) % size;
        }
    }
    public String peek(Listing newNode)
    {
        if (newNode == null) {
            return("Cannot find node");
        }
    else {
        return("Retrieving: " + newNode);
        }
    }
}

public class Main {
    public static void main(String[] args)
    {
        Queue queueDemo = new Queue(3);
        Stack stackDemo = new Stack(); //Getting the constructor of stack
        Listing lewis = new Listing("Lewis ", "Louisiana ", "123-888-1655");
        Listing clark = new Listing("Clark ", "Missouri ", "877-200-9865");
        Listing napoleonDynamite = new Listing("Napoleon Dynamite  ", "Idaho ", "277-200-9865");
        Listing alpha = new Listing ("Alpha ", "Alpha Ave ", "123-456-7890");
        Listing beta = new Listing ("Beta ", "Beta Ave ", "123-456-7890");
        //Queue demo
        System.out.println("Queueing Lewis and Clark:");
        queueDemo.enqueue(lewis);
        queueDemo.enqueue(clark);
        queueDemo.showAll();
        System.out.println(queueDemo.peek(lewis));
        System.out.println("dequeueing Lewis and Clark:");
        queueDemo.dequeue(lewis);
        queueDemo.dequeue(clark);
        System.out.println("The current queue:\n");
        queueDemo.showAll();
        //Stack demo
        System.out.println("Testing for a buffer overflow:");
        stackDemo.bufferoflowDetect();
        System.out.println("Showing current stack:\n");
        stackDemo.showAll();
        stackDemo.emptyStack();
        System.out.println("Testing if the stack is empty");
        stackDemo.empty();
        System.out.println("Pushing Alpha\nPushing Beta");
        stackDemo.push(alpha);
        stackDemo.push(beta);
        stackDemo.showAll();
        System.out.println("Popping Beta");
        stackDemo.pop(beta);
        System.out.println("Pushing Napoleon Dynamite");
        stackDemo.push(napoleonDynamite);
        System.out.println("Showing the current stack:");
        stackDemo.showAll();
        stackDemo.emptyStack();
        System.exit(0);
    }
}
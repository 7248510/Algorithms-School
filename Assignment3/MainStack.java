//This is where many students are impemented, insert, fetch, update, delete
//Demonstrate your code/run the program, sorting isn't necessasary
/*
The most important thing to take from this chapter is how a 
Stack and a Queue work as opposed to an unrestricted Array. 
I have no problem if you re-use your code from Assignment 2 and modify it to implement a Stack and/or a Queue. 
Even though the assignment specifies to complete #19 and #20 specifically in the textbook, 
I'll accept any code that demonstrates the understanding and implementation of Push/Pop behaviors with dynamic memory allocation for a Stack and/or Queue. 
I realize this portion of the course dealing with simple data structures 
might be a little less fun that what we will get to do with 
algorithms in the 2nd half of the class, so I'll give you whatever latitude you need to work.
*/
class Stack
{
    private Listing[] data;
    private int top;
    private int size;
    public Stack()
    {
        top = -1; //The top of the stack is -1(If it returns a negative value)
        size = 100; //initalizing the stack to 100
        data = new Listing[100]; //Getting an array of 100
    }
    public Stack(int n)
    {
        top = -1;
        size = n;
        data = new Listing[n];
    }
    public boolean push(Listing newNode) {
        if(top == size - 1) { //-1 == n - 1
            return false; //False = overflow
        }
        else {
            top = top + 1;
            data[top] = newNode.deepCopy();
            return true;
        }
    }
    public Listing pop()
    {
        int topLocation;
        if(top == -1) {
            return null; //Underflow, not an overflow
        }
        else {
            topLocation = top;
            top = top -1;
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
        //Implementing a loop until we get to 0, therfore emptying the stack
        //System.out.println(data[topLocation]);
        //System.out.println(topLocation);
        for (topLocation = topLocation; topLocation > 0; --topLocation) {
            top = 0-1;
            System.out.println("Stack empty");
        }
        
        return "Reinitalized the stack to 0";
    }
    public boolean empty() //Emptying the current stack
    {
        String condition;
        int topLocation;
        topLocation = top;
        System.out.println(topLocation);
        System.out.println(top);
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
    public Queue()
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
    public boolean enque(Listing newNode)
    {
        if(numOfNodes == size)
        {
            return false; //Bufferoverflow(Soon to join the CVE table lol)
        }
        else {
            numOfNodes = numOfNodes + 1;
            data[rear] = newNode.deepCopy();
            rear = (rear + 1) % size;
            return true;
        }
    }
    public Listing deque()
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
            return "Peek operation failed, cannot find node";
        }
    else {
        return "Retrieving Node: " + newNode;
        }
    }
}

public class MainStack {
    public static void main(String[] args)
    {
        Queue q = new Queue(3);
        Stack s = new Stack(3);
        Stack z = new Stack(); //Getting the constructor of stack
        Listing y;
        Listing l;
        Listing x;
        Listing l1 = new Listing("Bill", "1st ave", "123-888-1655");
        Listing l2 = new Listing("Ted", "2nd ave", "877-200-9865");
        Listing l3 = new Listing("Will", "3nd ave", "277-200-9865");
        Listing l4 = new Listing("John", "4th ave", "216-888-6943");
        //System.out.println(s.pop());//Nothing on the stack
        //System.out.println(z.push(l1));  //Will print true if valid
        //s.showAll();//Prints everything in the stack
        
        z.push(l4);
        z.push(l1);
        z.showAll();
        z.emptyStack();
        z.empty();
        z.showAll(); //Testing if the stack is empty.
        //z.pop();
        z.push(l4);
        z.push(l1);
        z.showAll();
        
        z.empty();
        //l = s.pop();
        //System.out.println(q.deque());
        //System.out.println(q.enque(l2));
        //System.out.println(q.enque(l3));
        q.enque(l2);
        q.enque(l3);
        //System.out.println(q.peek(l3));
        //q.showAll();
        x = q.deque();
        //System.out.println(x.toString());
        x = q.deque();
        //System.out.println(x);
        System.exit(0);
    }
}
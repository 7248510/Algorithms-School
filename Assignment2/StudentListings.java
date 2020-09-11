//This is where many students are impemented, insert, fetch, update, delete
//Demonstrate your code/run the program, sorting isn't necessasary
/*
Read Chapter 2 in the McAllister text.

Complete and Submit Programming Exercises #19, #20 and #21 on pages 121-122 of The McAllister text.

Note: The book makes this sound a little harder than it is. Your goal here is to create a Node  class (#19) which represents one student,
and then create another class which contains an array of Node objects (#20) and supports insertions, deletions, etc.  
The important part to learn is knowing how to manually write the dynamic memory allocation of the array as it changes size due to the insertions and deletions. 
You must use a plain array ( Node[] ) and not one of Java's pre-built classes that handles resizing automatically. 
The final exercise (#21) is just a demonstration that your array operations work. 
You do not need to implement a sorting algorithm! (We're doing that much later in the course)

*/
public class StudentListings
{
    private int next;
    private int size;
    private Node[] data;

    public StudentListings(int sizeofArray)
    {
        next = 0;
        size = sizeofArray;
        data = new Node[size]; //Allocating our array for 100 nodes
    }
    public boolean insert(Node newNode)
    {
        if (next>= size)
        {
            return false;
        }
        data[next] = newNode.deepCopy();
        if (data[next] == null) {
            return false;
        }
        next = next + 1;
        return true;
    }
    public Node fetch(String targetKey)
    {
        Node node;
        Node temp;
        int i = 0;
        while (i < next && !(data[i].compareTo(targetKey) == 0))
        {
            i++;
        }
        if (i==next) {
            return null;
        }
        node = data[i].deepCopy();
        if(i != 0) {
            temp = data[i - 1];
            data[i - 1] = data[i];
            data[i] = temp;
        }
        return node;
    }
    public boolean delete(String targetKey)
    {
        int i = 0;
        while(i < next && !(data[i].compareTo(targetKey) == 0))
        {
            i++;
        }
        if (i == next) {
            return false;
        }
        data[i] = data[next - 1];
        data[next - 1] = null;
        next = next - 1;
        return true;
    }

    public boolean update(String targetKey, Node newNode)
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
    public void showAll()
    {
        for (int i = 0; i < next; i++) {
            System.out.println(data[i].toString());
        }   
        //System.out.println(next);
    }
}
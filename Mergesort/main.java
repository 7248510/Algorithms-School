import java.io.*;
import java.util.*;
import java.lang.*; //Used for the array to string method(This is optional, the demo function doesn't use the toString method)
import java.util.Random; //Used for random number generation
//Step 1 generate a sequence/generate an array with some nodes
//step 2 Understand recurssion
//Step 3 Demo an array list/work on manipulating arrays
//Step 4 Code a merge sort algorithm with the help of multiple sources/references
//Step 5 combine steps 3 and 4
//Step 6 Code clean up/debugging
//References/Tools that helped me to complete the assignment & understand the merge sort/recurssion
/*
Array list API
Data structures and algorithms using Java(William McAllister)
https://www.javatpoint.com/recursion-in-java
https://www.w3schools.com/java/java_recursion.asp
https://www.geeksforgeeks.org/recursion-in-java/
https://www.geeksforgeeks.org/merge-sort/
https://www.javatpoint.com/merge-sort
https://www.baeldung.com/java-merge-sort
https://www.geeksforgeeks.org/merge-two-sorted-arrays/
https://www.youtube.com/watch?v=Kg4bqzAqRBM
https://www.youtube.com/watch?v=qdv3i6X0PiQ
https://www.youtube.com/watch?v=Kg4bqzAqRBM [25:01]
https://www.youtube.com/watch?v=_erSWo0dHII
https://www.youtube.com/watch?v=COx98hdwj30
Java documentation(for testing the array list)
*/
public class main {
    /*
    //Youtube example
    public static void recursive(int i, String text) {
        if (i==0) return;
        System.out.println(text);
        recursive(i-1,text);
    }
    */
    public static void sortArray(int[] list, int index) {
        //System.out.println(list); //Testing the passed array
        if (index < 2) { //Base case, you must implement one or else you might get a stack overflow
            return;
        }
        int halfArray = list.length / 2; //Dividing your arrays to get your left & right point
        int [] leftArray = new int[halfArray]; //Getting the left half
        int [] rightArray = new int[index - halfArray]; //Current index minus your half array value to form the right half
        int loopController = 0; //Initializing 
        for (loopController = 0; loopController < halfArray; loopController++) {
            leftArray[loopController] = list[loopController]; //The left array is equal to your current lists loop controler
        }
        for (loopController = halfArray; loopController < index; loopController++) {
            rightArray[loopController - halfArray] = list[loopController]; //Implementing the sorting by setting the right array[currentloopVal - halfArray value] to your current list
        }
        //Implement recursion/starting recursion
        sortArray(leftArray, halfArray); //Sorting the left array
        sortArray(rightArray, index - halfArray); //Sorting the right array, subtracting the current index minus the half array
        merge(list, leftArray, rightArray,halfArray,index-halfArray);
        //System.out.println(leftArray[0]);
    }
    public static void merge(int list[], int leftArray[], int rightArray[], int leftV, int rightV) {
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        //Divide and conquer begins
        while (index < leftV && num1 < rightV) { //the current index must be less than your passed left value and the place holder variables(like the fibonacci sequence) must be less than the right value[Noticing patterns when writing data structures/algorithms]
            if(leftArray[index] <= rightArray[num1]) {
                list[num2++] = leftArray[index++]; //Accessing the list and incrementing num2 to equal the left arrays current index, if the left index is less than or equal to the right arrays num/placeholder
            }
            else {
                list[num2 ++] = rightArray[num1++]; //If the first condition isn't valid then the right array is the bigger element
            }
        }
        //Comparing values
        while (index < leftV) { //While the index is greater than the left value
            list[num2++] = leftArray[index++]; //Set the list's second varible to equal the leftArray and increment the index value
        }
        while(num1 < rightV) {
            list[num2++] = rightArray[num1++]; //Set the list's second varible to equal the rightArray and increment the first placeholder/varible(num1)
        }
    }
    public static void demoJavaAPI() {
        int[] sortMe = new int[100];
        Random random = new Random();
        for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                sortMe[z] = x; //Setting the random values to their allocated slot in the array.
            }
            System.out.println("Before merge sort:");
            System.out.println(Arrays.toString(sortMe));
            sortArray(sortMe, sortMe.length);
            System.out.println("\nAfter merge sort:");
            System.out.println(Arrays.toString(sortMe));
            System.out.println("\nOutput without the JavaAPI(Using the toString):");
    }
    public static void demo() {
        int[] sortMe = new int[100];
        Random random = new Random();
        for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                sortMe[z] = x; //Setting the random values to their spot in the array.
            }
            System.out.print("Before merge sort:\n");
            System.out.print("[");
            for (int z=0; z < sortMe.length; z++) {
                System.out.print(sortMe[z] + ",");
            }
            System.out.print("]");
            System.out.println("\n");
            sortArray(sortMe, sortMe.length);
            System.out.print("After merge sort:\n");
            System.out.print("[");
            for (int z=0; z < sortMe.length; z++) {
                System.out.print(sortMe[z] + ",");
            }
            System.out.print("]");
            
    }
    public static void main(String[] args)
        {  
            demoJavaAPI(); //Using the arrays tostring method
            demo(); //Outputting the arrays seperated by a comma
    }
}
/*  
//Arraylist using the Java API. This was in the testing phrase. I'd plan on using an array list. Before implementing a manually written one 
I decided it would take less code/testing to use Java's. Fortunately I figured out that it is not necessary to use a linked list.
//ArrayList<Integer> sortME2 = new ArrayList<Integer>();
//System.out.println("Init Test");
//int[] sortMe = new int[100];
//Random random = new Random();
            for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                //System.out.println(x);
                sortMe[z] = x;
                sortME2.add(x);
                //push to form z
            }
            */
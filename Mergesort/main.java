import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.ArrayList;
//References/Tools that helped me to complete the assignement & understand the merge sort algorithm
/*
https://www.baeldung.com/java-merge-sort
https://www.geeksforgeeks.org/merge-two-sorted-arrays/
https://www.youtube.com/watch?v=Kg4bqzAqRBM []
https://www.youtube.com/watch?v=qdv3i6X0PiQ
https://www.youtube.com/watch?v=Kg4bqzAqRBM [25:01]
https://www.youtube.com/watch?v=_erSWo0dHII
https://www.youtube.com/watch?v=COx98hdwj30
Array list API
Data structures and algorithms using Java
*/
public class main {
    /*
    public static void recursive(int i, String text) {
        if (i==0) return;
        System.out.println(text);
        recursive(i-1,text);
    }
    */
    public static void sortArray(int[] list, int index) {
        //System.out.println(list);
        if (index < 2) {
            return;
        }
        //System.out.println(list[0]);
        int halfArray = list.length / 2;
        int [] leftArray = new int[halfArray];
        int [] rightArray = new int[index - halfArray];
        int loopController = 0;
        for (loopController = 0; loopController < halfArray; loopController++) {
            leftArray[loopController] = list[loopController];
        }
        for (loopController = halfArray; loopController < index; loopController++) {
            rightArray[loopController - halfArray] = list[loopController];
        }
        //Start recurssion
        sortArray(leftArray, halfArray);
        sortArray(rightArray, index - halfArray);
        merge(list, leftArray, rightArray,halfArray,index-halfArray);
        //System.out.println(leftArray[0]);
    }
    public static void merge(int list[], int leftArray[], int rightArray[], int leftV, int rightV) {
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        while (index < leftV && num1 < rightV) {
            if(leftArray[index] <= rightArray[num1]) {
                list[num2++] = leftArray[index++]; //Setting the current value place to match the index of the loop
            }
            else {
                list[num2++] = rightArray[num1++];
            }
        }
        while (index < leftV) {
            list[num2++] = leftArray[index++];
        }
        while(num1 < rightV) {
            list[num2++] = rightArray[num1++];
        }
    }
    public static void demo() {
        int[] sortMe = new int[100];
        Random random = new Random();
        for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                sortMe[z] = x; //Setting the random values to their spot in the array.
            }
            System.out.println("Before merge sort:");
            System.out.println(Arrays.toString(sortMe));
            sortArray(sortMe, sortMe.length);
            System.out.println("After merge sort:");
            System.out.println(Arrays.toString(sortMe));
    }
    public static void main(String[] args)
        {
            //Step 1 generate a sequence/generate an array with some nodes
            //step 2 figure out work on my understanding of recurssion
            //Step 3 Demo an array list and work on manipulating arrays
            //Step 4 Code a merge sort algorithm with the help of multiple sources/references[see the top comment]
            //Step 5 combine step 3 and 4
            //Step 6 Code clean up
            //ArrayList<Integer> sortME2 = new ArrayList<Integer>();
            //System.out.println("Init Test");
            //int[] sortMe = new int[100];
            //Random random = new Random();
            demo(); 
            /*  
            for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                //System.out.println(x);
                sortMe[z] = x;
                sortME2.add(x);
                //push to form z
            }
            */
    }
}
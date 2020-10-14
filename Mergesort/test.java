import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
public class test {
    //Generate 100 nodes with random values
    public static void main(String[] args) {
        arrayManip();
        System.out.println("Linked list begin");
        linkedList();
    }
    public static void arrayManip() {

        int[] sortMe = new int[100];
        Random random = new Random();
        for (int z=0; z < 100; z++) { //Generating a sequence
                int x = random.nextInt(100); //Calling a random function to get integers for 100 values
                sortMe[z] = x; //Setting the random values to their spot in the array.
            }
        System.out.println(Arrays.toString(sortMe));
    }
    public static void linkedList() {
            ArrayList<Integer> sortME2 = new ArrayList<Integer>();
            System.out.println("Init Test");
            int[] sortMe = new int[100];
            Random random = new Random();
            for (int z=0; z < 100; z++) {
                int x = random.nextInt(100); 
                sortMe[z] = x;
                sortME2.add(x);
                //push to form z
        }
        System.out.println(sortME2);
    }
}
import java.util.Scanner;
public class Main
{
public static void choice()
    {
        StudentListings information = new StudentListings(100);
        Node johnny = new Node("Johnny", "857", "3.00");
        Scanner myObj = new Scanner(System.in);
        String message = "Press 0 to set the array size, the default is 100\nPress 1 to insert a new students information:\nPress 2 to fetch and output a students information\nPress 3 to delete a students information\nPress 4 to update a students information\nPress 5 to output all the students information\npress 6 to exit";
        int catalyst = myObj.nextInt();
        System.out.println(message);
        switch (catalyst) {
            case 1: information.insert(johnny);
            break;
            case 2:
            System.out.println("Closing program");
            break;
        }
    }


    public static void main(String[] args)
    {
        StudentListings information = new StudentListings(100);
        choice();
        Node julia = new Node("Julia", "234", "4.00");
        Node johnny = new Node("Johnny", "857", "3.00");
        Node chuck = new Node("Chuck", "007", "4.01");
        information.insert(johnny);
        information.insert(chuck);
        information.insert(julia);
        information.showAll();
        information.showAll();
    }








}
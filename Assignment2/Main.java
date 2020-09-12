import java.util.Scanner;
public class Main
{
public static void choice()
    {
        String message = "Press 0 to set the array size, the default is 100\nPress 1 to insert a new students information:\nPress 2 to fetch and output a students information\nPress 3 to delete a students information\nPress 4 to update a students information\nPress 5 to output all the students information\npress 6 to exit";
        System.out.println(message);
        Scanner myObj = new Scanner(System.in);
        int catalyst = myObj.nextInt();
        StudentListings information = new StudentListings(100);
        Node julia = new Node("Julia", "234", "4.00");
        Node johnny = new Node("Johnny", "857", "3.00");
        Node chuck = new Node("Chuck", "007", "4.01");
        information.insert(johnny);
        information.insert(chuck);
        information.insert(julia);
        if  (catalyst == 1) {
            chuck.input();
        }
        if  (catalyst == 2) {
            julia.fetch();
        }
        if  (catalyst == 3) {
            johnny.delete();
        }
        if  (catalyst == 4) {
            johnny.update("Update", johnny);
        }
        if  (catalyst == 5) {
            System.exit(0);
        }
        if  (catalyst == 6) {
            information.showAll();
        }
        else {
            System.out.println("You didn't enter a valid option.\nExiting now");
        }
    }

    public static void main(String[] args)
    {
        choice();
        /*
        Node julia = new Node("Julia", "234", "4.00");
        Node johnny = new Node("Johnny", "857", "3.00");
        Node chuck = new Node("Chuck", "007", "4.01");
        information.insert(johnny);
        information.insert(chuck);
        information.insert(julia);
        information.showAll();
        information.showAll();
        */
    }








}
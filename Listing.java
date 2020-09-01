import java.io.*;
import java.lang.*;
public class Listing //Java feels a lot like C++, the difference is the structs are missing.
{
    //private String name = " "; //Declaring and Setting values
    private int x = 0; //Declaring and Setting values
    private String z = "NSA is the dream";
    public Listing(int y,String w)
    {
        x = y;
        z = w;
    }
    public String toString()
    {
        //return ("INT:\n" + x + "String:\n" + z);
        return (x + z);
    }
    public int getAge()
    {
        return x;
    }

    public static void main(String args[]) //Not passing any arguments on the command line.
    {
        
        Listing madeup = new Listing(78,"DOD is the dream"); //ClassName ObjectName
        System.out.println(madeup);
        Listing tao = new Listing(007,"GCHQ much?");
        System.out.println(tao);
    }
}
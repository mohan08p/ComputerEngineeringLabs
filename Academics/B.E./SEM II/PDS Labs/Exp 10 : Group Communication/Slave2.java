import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Slave2
{
     public static void main(String[] args) throws IOException
     {
          Scanner input = new Scanner(System.in);
          Socket socket = new Socket("localhost", 9001);
          BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
          System.out.println("Enter your name : ");
          String name = input.nextLine();
          while(true)
          {
               String line = br.readLine();
               if(line.startsWith("SUBMITNAME"))
                    pw.println(name);
               else if(line.startsWith("MESSAGE"))
                    System.out.println(line.substring(8));
               if(name.startsWith("Master"))
               {
                    System.out.println("Enter a message : ");
                    pw.println(input.nextLine());
               }
          }
     }
}
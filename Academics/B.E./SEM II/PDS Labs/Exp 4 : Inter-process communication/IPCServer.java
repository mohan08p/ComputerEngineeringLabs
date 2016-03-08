import java.io.*;
import java.net.*;

public class IPCServer
{
     public static void main(String[] args)
     {
          System.out.println("\n **** INTERPROCESS COMMUNICATION ****\n");
          System.out.println("\n *** SERVER PROCCESS STARTED ***\n");
          System.out.println("\n SERVER IS READY AND WAITING TO RECEIVE DATA FROM CLIENT PROCESS ON PORT "+1200);
          try
          {
               ServerSocket ss = new ServerSocket(1200); // on port number 1200
               Socket clientSocket = ss.accept();
               System.out.println("\n Client is connected with IP address"+clientSocket.getInetAddress() + " nd port number "+clientSocket.getPort());
               DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
               DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
               int a = dis.readInt();
               System.out.println("\n SERVER RECEIVED");
               System.out.println("\n Number 1 -> "+a);
               int b = dis.readInt();
               System.out.println("\n Number 2 -> "+b);
               int c = a + b;
               dos.writeInt(c);
               System.out.println("\n SERVER PROCESS HAS EXECUTED REQUESTED PROCESS AND SENT RESULT "+c+" TO THE CLIENT \n");
               clientSocket.close();
               System.out.println("\n SERVER PROCESS EXITING....");
               ss.close();
          }
          catch(Exception e)
          {
               System.out.println("Exception : "+e);
          }
     }
}
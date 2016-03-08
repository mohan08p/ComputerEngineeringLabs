import java.io.*;
import java.net.*;
import java.util.Vector;

public class Server
{
     private static Vector<PrintWriter> writers = new Vector<PrintWriter>();
     
     public static void main(String[] args) throws IOException
     {
          ServerSocket ss = new ServerSocket(9001);
          System.out.println("The server is runnin at port 9001.");
          while(true)
          {
               new Handler(ss.accept()).start();
          }
     }
     private static class Handler extends Thread
     {
          private Socket socket;
          public Handler(Socket socket)
          {
               this.socket = socket;
          }
          public void run()
          {
               try
               {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                    pw.println("SUBMITNAME");
                    String name = br.readLine();
                    System.out.println(name + " joined.");
                    writers.add(pw);
                    while(true)
                    {
                         String input = br.readLine();
                         for(PrintWriter writer : writers)
                              writer.println("MESSAGE "+name+" : "+input);
                    }
               } catch(Exception e)
               {
                    System.out.println("Exception is : "+e);
               }
          }
     }
}
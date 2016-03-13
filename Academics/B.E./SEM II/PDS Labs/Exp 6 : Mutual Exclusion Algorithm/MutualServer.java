//MutualServer.java 
 
import java.io.*; 
import java.net.*; 
 
public class MutualServer implements Runnable 
{ 
     Socket socket=null; 
     static ServerSocket ss; 
     MutualServer(Socket newSocket) 
     { 
          this.socket=newSocket; 
     } 

     public static void main(String args[]) throws IOException 
     { 
          ss=new ServerSocket(7000); 
          System.out.println("Server Started"); 
          while(true) 
          { 
               Socket s=ss.accept(); 
               MutualServer es=new MutualServer(s); 
               Thread t=new Thread(es); 
               t.start(); 
          } 
     }//end main 

     public void run() 
     { 
          try 
          { 
               BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream())); 
               while(true) 
               { 
                    System.out.println(br.readLine()); 
               } 
          } 
          catch(Exception e){} 
     } 
}//end class 
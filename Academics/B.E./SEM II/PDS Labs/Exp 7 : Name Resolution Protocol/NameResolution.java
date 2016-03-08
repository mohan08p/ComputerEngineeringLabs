import java.io.*;
import java.net.*;

public class NameResolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n Enter the website url (like google.com) to resolve its name to Address :");
        String name=br.readLine();
        try{
            InetAddress ia=InetAddress.getByName(name);
            System.out.println("\n IP Address : "+ia.getHostAddress());
        } catch(UnknownHostException uhe) {;
            System.out.println("\n No such Host present...");
            System.out.println("\n Try Again...");
        }
    }
}
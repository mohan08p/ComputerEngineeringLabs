import java.rmi.Naming;

public class AddClient
{
    public static void main(String[] args)
    {
        try
        {
            AddInterface ai=(AddInterface)Naming.lookup("//localhost/Add");
            System.out.println("The sum of 2 numbers is : "+ai.sum(10,2));
        }
        catch(Exception e)
        {
            System.out.println("Client Exception : "+e);
        }
    }
}
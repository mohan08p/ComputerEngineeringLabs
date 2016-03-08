import java.rmi.*;

public interface AddInterface extends Remote
{
    public int sum(int n1, int n2) throws RemoteException;
}

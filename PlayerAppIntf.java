import java.rmi.*;

interface PlayerAppIntf extends Remote {
     public Player get(int p) throws RemoteException;
}

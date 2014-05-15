import java.rmi.*;
import java.util.Vector;

interface PlayerDBIntf extends Remote {
    public Vector query(String query) throws RemoteException;
}

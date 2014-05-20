import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

class PlayerApp extends UnicastRemoteObject implements PlayerAppIntf {

    public PlayerApp() throws RemoteException {
	super();
    }

    public Player get(int p) throws RemoteException {
	try {
	    Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerDB");
	    PlayerDBIntf playerApp = (PlayerDBIntf) remote;
	    Vector result = playerApp.query("select name, town from players where playerno=" + p);
	    if (result.size() > 0) {
		Vector row = (Vector) result.elementAt(0);
		Player player = new Player(p, (String) row.elementAt(0), (String) row.elementAt(1));
		return player;
	    }
	    
	}
	catch (Exception ex) {
	    System.out.println(ex);
	}
	return new Player();
    }

}

import java.rmi.*;
import java.rmi.server.*;

class PlayerApp extends UnicastRemoteObject implements PlayerAppIntf {

    public PlayerApp() throws RemoteException {
	super();
    }

    public void get(int p) throws RemoteException {
	try {
	    Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerDB");
	    PlayerDBIntf playerApp = (PlayerDBIntf) remote;
	    playerApp.query("");
	    
	    Player p = new Player();
	}
	catch (Exception ex) {
	    System.out.println(ex);
	}
    }

}

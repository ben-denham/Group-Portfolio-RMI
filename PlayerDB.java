import java.sql.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;

class PlayerDB extends UnicastRemoteObject implements PlayerDBIntf {

    public PlayerDB() throws RemoteException {
	super();
    }

    public Vector query(String query) throws RemoteException {
	try {
	    Connection connection = DriverManager.getConnection("jdbc:odbc:tennis_access","","");
	    Statement statement = connection.createStatement();
	    ResultSet result = statement.executeQuery(query);

	    Vector resultVector = new Vector();
	    ResultSetMetaData rsmd = result.getMetaData();
	    int columnCount = rsmd.getColumnCount();
	    while (result.next()) {
		Vector row = new Vector();
		for (int i = 1; i <= columnCount; i++) {
		    row.add(result.getString(i));
		}
		resultVector.add(row);
	    }
	    return resultVector;
	}
	catch (SQLException e) {
	    System.out.println(e);
	}
	return null;
    }

}

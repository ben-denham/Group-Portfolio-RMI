import java.io.*;

class Player implements Serializable
{
    private int id;
    private String name;
    private String town;

    public Player(int id, String name,String town)
    {
    }

    public int getID()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getTown()
    {
        return town;
    }
}

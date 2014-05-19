import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Client extends JFrame
{
    private JTextField txtPlayerNo;
    private JTextField txtName;
    private JTextField txtInitials;
    private JTextField txtBirthDate;
    private JTextField txtSex;
    private JTextField txtJoined;
    private JTextField txtStreet;
    private JTextField txtHouseNo;
    private JTextField txtPostCode;
    private JTextField txtTown;
    private JTextField txtPhoneNo;
    private JTextField txtLeague;
    public static void main(String[] args)
    {
        try
        {
            Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerApp");
            PlayerAppIntf playerApp = (PlayerAppIntf) remote;
            playerApp.hello();
            Client frame = new Client();
            frame.setVisible(true);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    Client()
    {
        setTitle("ClientGui");
        setBounds(100, 100, 248, 215);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lblPlayerNo = new JLabel("Player No");
        lblPlayerNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPlayerNo.setBounds(10, 18, 76, 14);
        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(10, 55, 76, 14);
        JLabel lblTown = new JLabel("Town");
        lblTown.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTown.setBounds(10, 97, 76, 14);
        txtPlayerNo = new JTextField();
        txtPlayerNo.setBounds(96, 15, 126, 20);
        txtPlayerNo.setColumns(10);
        txtName = new JTextField();
        txtName.setBounds(96, 52, 126, 20);
        txtName.setColumns(10);
        txtTown = new JTextField();
        txtTown.setBounds(96, 94, 126, 20);
        txtTown.setColumns(10);
        JButton btnGet = new JButton("Get");
        btnGet.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnGet.setBounds(133, 140, 89, 23);
        btnGet.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                try
                {
                    Remote remote = Naming.lookup("rmi://127.0.0.1/PlayerApp");
                    PlayerAppIntf playerApp = (PlayerAppIntf) remote;
                    playerApp.hello();
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
            }
        }
        );
        getContentPane().setLayout(null);
        getContentPane().add(lblPlayerNo);
        getContentPane().add(txtPlayerNo);
        getContentPane().add(lblName);
        getContentPane().add(txtName);
        getContentPane().add(lblTown);
        getContentPane().add(txtTown);
        getContentPane().add(btnGet);
    }
}

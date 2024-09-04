package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    String pinno;
    JButton chnge, bck;
    JTextField p, r;

    PinChange(String pinno) {
        setLayout(null);
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon("icons/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 770, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 700);
        add(img);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 220, 300, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.white);
        img.add(text);

        JLabel ptext = new JLabel("New PIN:");
        ptext.setBounds(180, 250, 300, 35);
        ptext.setFont(new Font("Raleway", Font.BOLD, 16));
        ptext.setForeground(Color.white);
        img.add(ptext);

        p = new JPasswordField();
        p.setBounds(330, 260, 180, 25);
        p.setFont(new Font("Ariel", Font.BOLD, 16));
        img.add(p);

        JLabel rtext = new JLabel("Re-Enter New PIN:");
        rtext.setBounds(180, 290, 300, 35);
        rtext.setFont(new Font("Raleway", Font.BOLD, 16));
        rtext.setForeground(Color.white);
        img.add(rtext);

        r = new JPasswordField();
        r.setBounds(330, 295, 180, 25);
        r.setFont(new Font("Ariel", Font.BOLD, 16));
        img.add(r);

        chnge = new JButton("CHANGE");
        chnge.setBounds(360, 370, 150, 25);
        chnge.addActionListener(this);
        img.add(chnge);

        bck = new JButton("BACK");
        bck.setBounds(360, 400, 150, 25);
        bck.addActionListener(this);
        img.add(bck);

        setSize(900, 900);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == chnge) {
            try {
                String npin = p.getText();
                String rpin = r.getText();
                if (npin.equals("") || rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter both the pin");
                } else if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                } else {
                    Conn conn = new Conn();
                    String query = "update bank set pin = '" + rpin + "' where pin= '" + pinno + "'";
                    String query1 = "update login set pin = '" + rpin + "' where pin= '" + pinno + "'";
                    String query2 = "update signup3 set pin = '" + rpin + "' where pin = '" + pinno + "'";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "PIN changed succesfully");

                    setVisible(false);
                    new Transaction(rpin).setVisible(true);
                }
            }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        else {
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("");
    }
}

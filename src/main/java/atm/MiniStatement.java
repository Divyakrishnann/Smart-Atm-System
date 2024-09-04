package atm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinno;
    MiniStatement(String pinno){
        setTitle("Mini Statement");
        this.pinno = pinno;
        setLayout(null);
        
        JLabel mini = new JLabel ();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,150,40);
        add(bank);
        
        JLabel card = new JLabel ();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try {
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin ='"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number is :"+rs.getString("cardno").substring(0,4)+"XXXXXXXX"+rs.getString("cardno").substring(12));
                
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
         try {
            Conn c = new Conn();
            int bal=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinno+"'");
            while(rs.next()){
              //gettext is if the data is aldready present then it will append to it neither then overwriting on it
              //nbsp - it is used giving spaces in betweeen in html
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                            bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is: "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}

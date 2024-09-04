package  atm;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
//import java.io.IOException;
import javax.swing.*;

public class Login  extends JFrame implements ActionListener{
    JTextField card;
    JButton sign,clear,signup;
    JPasswordField pin;
    Login(){
    setLayout(null);
    setTitle("Automated Teller Machine");
    setSize(800,480);
    setLocation(250,50);
    
    ImageIcon i = new ImageIcon("icons/logo.jpg");    
    Image i1 = i.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i1);
    JLabel label = new JLabel(i3);
    label.setBounds(70,30,100,100);
    add(label);
    
    JLabel text = new JLabel("Welcome to ATM");
    text.setBounds(200,40,400,40);
    text.setFont(new Font("Osward",Font.BOLD,38));
    add(text);
    
    JLabel cardno = new JLabel("Card No. :");
    cardno.setBounds(120,150,250,30);
    cardno.setFont(new Font("Raleway",Font.BOLD,28));
    add(cardno);
    
    card =new JTextField();
    card.setBounds(300,150,250,30);
    card.setFont(new Font("Arial",Font.BOLD,14));
    add(card);
    
    JLabel pinno = new JLabel("Pin :");
    pinno.setBounds(120,220,250,30);
    pinno.setFont(new Font("Raleway",Font.BOLD,28));
    add(pinno);
    
     
    pin =new JPasswordField();
    pin.setBounds(300,220,250,30);
    pin.setFont(new Font("Arial",Font.BOLD,14));
    add(pin); 
    
    sign = new JButton("SIGN IN");
    sign.setBounds(300,300,120,30);
    add(sign);
    sign.setForeground(Color.WHITE);
    sign.setBackground(Color.BLACK);
    sign.addActionListener(this);
    
    clear = new JButton("CLEAR");
    clear.setBounds(430,300,120,30);
    add(clear);
    clear.setForeground(Color.WHITE);
    clear.setBackground(Color.BLACK);
    clear.addActionListener( this);
    
    signup = new JButton("SIGN UP");
    signup.setBounds(300,350,250,30);
    add(signup);
    signup.setForeground(Color.WHITE);
    signup.setBackground(Color.BLACK);
    signup.addActionListener(this);
    
    
    getContentPane().setBackground(Color.lightGray);
    setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == sign){
            Conn conn = new Conn();
            String cardno=card.getText();
            String pinno=pin.getText();
            String query ="select * from login where cardno ='"+cardno+"' and pin='"+pinno+"'";
            try{
                if(cardno.equals("")){
                    JOptionPane.showMessageDialog(null,"Card No. is required");
                }
                else if(pinno.equals("")){
                    JOptionPane.showMessageDialog(null,"Pin No. is required");
                }else{
                 ResultSet rs=conn.s.executeQuery(query);
                 if(rs.next()){
                    setVisible(false);
                    new curr(pinno).setVisible(true);  
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Incorrect password or pin");
                 }   
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        if (ae.getSource() == clear){
            card.setText("");
            pin.setText("");
        }
        if (ae.getSource() == signup){
            setVisible(false);
            new signup().setVisible(true);
        }
    }
    
    public static void main(String[] args){  
         new Login();
    }
}

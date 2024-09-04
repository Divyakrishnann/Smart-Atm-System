package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amnt;
    String pinno;
    Withdrawl(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon("icons/atm.jpg");
        Image i=i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,900,700);
        add(img);
        
        JLabel text =new JLabel("Please Enter The Amount To Be Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170, 220,700, 35);
        img.add(text);
        
        amnt=new JTextField();
        amnt.setBounds(170,260,340, 30);
        amnt.setFont(new Font("Raleway",Font.BOLD,20));
        img.add(amnt);
        
        withdraw=new JButton("Withdrawl");
        withdraw.setBounds(380,385,120,25);
        img.add(withdraw);
        withdraw.addActionListener(this);

        back=new JButton("Back");
        back.setBounds(380,415,120,25);
        img.add(back);
        back.addActionListener(this);
        
        
        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()==back){
             setVisible(false);
             new Transaction(pinno).setVisible(true);
        }
        else if(ae.getSource()==withdraw ){
           String number =amnt.getText();
           Date date= new Date();
           if(number.equals("")){
               JOptionPane.showMessageDialog(null,"Enter the amount");
           }
//           else if (number>)
           else{
               try{           
                Conn conn=new Conn();
                String query="insert into bank values('"+pinno+"', '"+date+"', 'Withdrawl', '"+number+"')";  
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawn Successfully!");
                }
                catch(Exception e){
                    System.out.println(e);
                }
           }
        }
    }
    public static void main(String[] args) {
        new Withdrawl("");
    }
}

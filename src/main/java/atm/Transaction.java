package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transaction extends JFrame implements ActionListener{
    JButton exit,deposit,fastcash,withdrawl,mini,pin,bal,voice;
    String pinno;
    Transaction(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon("icons/atm.jpg");
        Image i=i1.getImage().getScaledInstance(900,770,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel img=new JLabel(i2);
        img.setBounds(0,0,900,700);
        add(img);
        
        JLabel text =new JLabel("Please Select Your Transaction");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(220, 220,700, 35);
        img.add(text);
        
        deposit =new JButton("Deposit");
        deposit.setBounds(155,325,150,25);
        img.add(deposit);
        deposit.addActionListener(this);
        
        fastcash =new JButton("Fast Cash");
        fastcash.setBounds(155,355,150,25);
        img.add(fastcash);
        fastcash.addActionListener(this);
        
        withdrawl =new JButton("Withdrawl");
        withdrawl.setBounds(365,325,150,25);
        img.add(withdrawl);
        withdrawl.addActionListener(this);
        
        mini =new JButton("Mini Statement");
        mini.setBounds(365,355,150,25);
        img.add(mini);
        mini.addActionListener(this);
        
        pin  =new JButton("Pin Change");
        pin.setBounds(155,385,150,25);
        img.add(pin);
        pin.addActionListener(this);
        
        bal  =new JButton("Balance Enquiry");
        bal.setBounds(365,385,150,25);
        img.add(bal);
        bal.addActionListener(this);
        
        voice =new JButton("Choose via voice");
        voice.setBounds(155,415,150,20);
        img.add(voice);
        voice.addActionListener(this);
        
        exit  =new JButton("Exit");
        exit.setBounds(365,415,150,20);
        img.add(exit);
        exit.addActionListener(this);
//        
        
        setSize(900,900);
        setLocation(200,0);
        setUndecorated(true);
         setVisible(true);
    }
       
    public void actionPerformed(ActionEvent ae){
            if (ae.getSource()==exit){
                System.exit(0);
            }
            else if (ae.getSource()==deposit){
                setVisible(false);
                new Deposit(pinno).setVisible(true);
            }
            else if (ae.getSource()==fastcash){
                setVisible(false);
                new Fastcash(pinno).setVisible(true);
            }
            else if (ae.getSource()==withdrawl){
                setVisible(false);
                new Withdrawl(pinno).setVisible(true);
            }
            else if (ae.getSource()==mini){
                new MiniStatement(pinno).setVisible(true);
            }
            else if (ae.getSource()==pin){
                setVisible(false);
                new PinChange(pinno).setVisible(true);
            }
            else if (ae.getSource()==bal){
                setVisible(false);
                new BalanceEnquiry(pinno).setVisible(true);
            }
            else if (ae.getSource()==voice){
                setVisible(true);
                new VoiceRec(pinno).setVisible(true);
            }
            
        }
    public static void main(String[] args) {
        new Transaction("");
    }
    
    
}

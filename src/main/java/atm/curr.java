package atm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class curr extends JFrame implements ActionListener {

    JTextField card;
    JButton verify, clear,genotp;
    String pinno;

    public curr(String pinno) {
        this.pinno = pinno;
        setLayout(null);
        setTitle("Email Verification");
        setSize(800, 480);
        setLocation(250, 50);

        JLabel text = new JLabel("Enter OTP");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        JLabel cardno = new JLabel("OTP:");
        cardno.setBounds(120, 150, 250, 30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        card = new JTextField();
        card.setBounds(300, 150, 250, 30);
        card.setFont(new Font("Arial", Font.BOLD, 14));
        add(card);

        verify = new JButton("Verify");
        verify.setBounds(300, 300, 120, 30);
        add(verify);
        verify.setForeground(Color.WHITE);
        verify.setBackground(Color.BLACK);
        verify.addActionListener(this);

        genotp = new JButton("Genrate Otp");
        genotp.setBounds(300, 200, 120, 30);
        add(genotp);
        genotp.setForeground(Color.WHITE);
        genotp.setBackground(Color.BLACK);
        genotp.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 120, 30);
        add(clear);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.addActionListener(this);

        getContentPane().setBackground(Color.lightGray);
        setVisible(true);
    }

    public String sendOtp(int length) {
        String numbers = "0123456789";
        // Random object to generate random numbers
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        
        // Generate OTP by randomly selecting characters from the numbers string
        for (int i = 0; i < length; i++) {
            // Get a random index to select a character from the numbers string
            int index = random.nextInt(numbers.length());
            // Append the randomly selected character to the OTP
            otp.append(numbers.charAt(index));
        }
        
        // Return the generated OTP as a string
        return otp.toString();
    }
    String text = sendOtp(4);

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == genotp) {
            Conn conn = new Conn();
            try {
                String query = "select s.email from signup s left join login l on s.formno = l.formno where l.pin ='" + pinno + "'";
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    String email = rs.getString("email");               
                    GEmailSender gEmailSender = new GEmailSender();
                    String to = email;
                    String from = "larajean344@gmail.com";
                    String subject = "Second: Sending email using GMail";
                    boolean b = gEmailSender.sendEmail(to, from, subject, text);
                    if (b) {
                        System.out.println("Email is sent successfully");
                    } else {
                        System.out.println("There is problem in sending email");
                    }
                } else {
                    System.out.println("No email found for the provided PIN.");
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Proper error handling should be implemented
            }
        }
        if(ae.getSource() == verify){
            String cardno = card.getText();
            if (text.equals(cardno)) {
                        JOptionPane.showMessageDialog(null, "Successfully verified otp");
                        setVisible(false);
                        new Transaction(pinno).setVisible(true);
            }
            else {
                        JOptionPane.showMessageDialog(null, "Wrong otp");
            }
        }
        if (ae.getSource() == clear) {
            card.setText("");
        }

    }

    public static void main(String[] args) {
        new curr("");
    }

}

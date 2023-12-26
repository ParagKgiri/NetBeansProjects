package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        
        
        setLayout(null);
        getContentPane().setBackground(Color.black);
        setSize(900, 870);
        setLocation(350,0);
        setVisible(true);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setForeground(Color.RED);
        l1.setBounds(280, 40, 400, 40);
        add(l1);
              
        JLabel type = new JLabel("Account Type");
        l1.setForeground(Color.RED);
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBounds(100, 180, 160, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBounds(350, 180, 200, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBounds(100, 220, 160, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway", Font.BOLD,16));
        r4.setBounds(350, 220, 170, 20);
        add(r4);
        
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
                   
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100, 300, 200, 30);
        card.setBackground(Color.red);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-2124");
        number.setFont(new Font("Raleway", Font.BOLD,22));
        number.setBounds(330, 300, 300, 30);
        number.setBackground(Color.RED);
        add(number);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD,22));
        pnumber.setBounds(330, 370, 300, 30);
        pnumber.setBackground(Color.red);
        add(pnumber);
      
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD,22));
        services.setBounds(100, 450, 200, 30);
        add(services);
       
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Bnking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);
        
        
        
        submit= new JButton("Submit");
        submit.setBackground(Color.RED);
        submit.setForeground(Color.YELLOW);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(150,650,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.YELLOW);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(400,650,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Reccuring Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504093600000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(c1.isSelected()){
                facility = facility + " ATM Card";
            } else if(c2.isSelected()){
                facility = facility + " Internet Banking";
            }else if(c3.isSelected()){
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility + " EMAIL & SMS Alert";
            } else if(c5.isSelected()){
                facility = facility + " Cheque Book";
            } else if(c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                     String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    
                    JOptionPane.showMessageDialog(null, "card number:" + cardnumber + "\n Pin: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch (Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == cancel){
            
        }
        
    }
    
    
    public static void main(String args[]) {
         new SignupThree("");
    }
}

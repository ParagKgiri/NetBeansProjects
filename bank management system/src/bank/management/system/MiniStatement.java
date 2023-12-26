package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    MiniStatement(String pinnumber){
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel bank = new JLabel("PARAG NATIONAL BANK");
        bank.setForeground(Color.RED);
        bank.setBounds(130,20,150,30);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,80,190,20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "xxxxxxxx" + rs.getString("cardnumber").substring(12 ));
                card.setForeground(Color.yellow);
            }
        } catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c  = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                mini.setForeground(Color.yellow);
            
                 if(rs.getString("type").equals("Deposit")){
                            bal += Integer.parseInt(rs.getString("amount"));
                        } else{
                            bal -= Integer.parseInt(rs.getString("amount"));
                        }

            }
            
            balance.setText("Your current account balance is Rs " + bal);
            balance.setForeground(Color.yellow);
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        mini.setBounds(20,140,400,200);
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
    
    public static void main(String args[]) {

        new MiniStatement("");
    }

}

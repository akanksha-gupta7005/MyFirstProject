package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pinnumber;
    JButton back;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(330, 400, 150, 30);
        back.addActionListener(this);
        add(back);

        conn c = new conn();
        long balance = 0;
        try {
            ResultSet re = c.stmt.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (re.next()) {
                if (re.getString("type").equals("withdraw")) {
                    balance -= Integer.parseInt(re.getString("amount"));
                } else {
                    balance += Integer.parseInt(re.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        JLabel text = new JLabel("Your current balance is Rs :" + balance);
        text.setForeground(Color.BLACK);
        text.setBounds(200,300,400,100);
        text.setFont(new Font("Raleway", Font.BOLD,25));
        add(text);



        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }

        public static void main (String[]args){
            new BalanceEnquiry("");
        }
}


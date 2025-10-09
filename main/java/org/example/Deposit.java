package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit,back;
    JTextField amount;
    String pinnumber;

    Deposit(String pinnumber){

    this.pinnumber = pinnumber;
        setLayout(null);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.CENTER_BASELINE,20));
        text.setBounds(280,130,400,20);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(300,200,320,25);
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(300,270,320,30);
        deposit.addActionListener(this);
        add(deposit);


        back = new JButton("Back");
        back.setBounds(300,310,320,30);
        back.addActionListener(this);
        add(back);




        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public  void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String paisa  = amount.getText();
            Date date = new Date();


            try {
                if (paisa.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                } else {


                    conn c = new conn();
                    String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', ' deposit ','" + paisa + "')";
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+paisa+" Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);


                }
            }catch(Exception ex){
                System.out.println(ex);
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

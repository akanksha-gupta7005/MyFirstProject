package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit,withdraw,ministatement,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    Transaction(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(250,90,700,35);
        text.setFont(new Font("Raleway", Font.BOLD,25));
        add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(250,250,150,30);
        deposit.addActionListener(this);
        add(deposit);


        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(500,250,150,30);
        withdraw.addActionListener(this);
        add(withdraw);



        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(250,300,150,30);
        fastcash.addActionListener(this);
        add(fastcash);


        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(500,300,150,30);
        ministatement.addActionListener(this);
        add(ministatement);


        pinchange = new JButton("Pin Change");
        pinchange.setBounds(250,350,150,30);
        pinchange.addActionListener(this);
        add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(500,350,150,30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);


        exit = new JButton("Exit");
        exit.setBounds(250,400,400,30);
        exit.addActionListener(this);
        add(exit);








        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == exit){
            System.exit(0);
        }else if(e.getSource() == deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(e.getSource() == withdraw){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(e.getSource() == fastcash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(e.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(e.getSource() == ministatement){
//            setVisible(false);
            new Ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }

}

package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,withdraw,ministatement,fastcash,pinchange,balanceenquiry,exit;
    String pinnumber;
    Date date = new Date();
    Fastcash(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        JLabel text = new JLabel("SELECT WITHDRAW AMOUNT");
        text.setBounds(250,90,700,35);
        text.setFont(new Font("Raleway", Font.BOLD,25));
        add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(250,250,150,30);
        deposit.addActionListener(this);
        add(deposit);


        withdraw = new JButton("Rs 500");
        withdraw.setBounds(500,250,150,30);
        withdraw.addActionListener(this);
        add(withdraw);



        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(250,300,150,30);
        fastcash.addActionListener(this);
        add(fastcash);


        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(500,300,150,30);
        ministatement.addActionListener(this);
        add(ministatement);


        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(250,350,150,30);
        pinchange.addActionListener(this);
        add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(500,350,150,30);
        balanceenquiry.addActionListener(this);
        add(balanceenquiry);


        exit = new JButton("Back");
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
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)e.getSource()).getText().substring(3);
            try{
                conn c = new conn();
                ResultSet re = c.stmt.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(re.next()){
                    if(re.getString("type").equals("deposit")){
                        balance += Integer.parseInt(re.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(re.getString("amount"));
                    }
                }

                if(e.getSource() != exit && balance > Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }

                    String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', 'withdraw', '" + amount + "')";
                    c.stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs :" + amount + "Debited successfully");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);



            }catch (Exception ex){
                System.out.println(ex);
            }

        }
    }
    public static void main(String[] args) {
        new Fastcash("");
    }

}

package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class Ministatement extends JFrame {

    String pinnumber;
    Ministatement(String pinnumber){

        this.pinnumber = pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel balance = new JLabel();
        balance.setBounds(50,50,400,20);
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,250);
        add(mini);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,50,400,150);
        add(card);

        try{
            conn c = new conn();
            ResultSet re = c.stmt.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(re.next()){
                card.setText("Card Number : "  + re.getString("cardnumber").substring(0,4) + "XXXXXXXX" + re.getString("cardnumber").substring(12));
            }

        }catch(Exception e){
            System.out.println(e);
        }


        try{
            conn c = new conn();
            int bal =  0;
            ResultSet re = c.stmt.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while(re.next()){
                mini.setText(mini.getText() + "<html>" + re.getString("data") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + re.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + re.getString("amount") + "<br><br><html>");
                if(re.getString("type").equals("deposit")){
                    bal += Integer.parseInt(re.getString("amount"));
                }else{
                    bal -= Integer.parseInt(re.getString("amount"));
                }
            }
            balance.setText("Your current account balance Rs :" + bal);
        }catch(Exception e){
            System.out.println(e);
        }





        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);


    }


    public static void main(String[] args) {
  new Ministatement("");
    }
}

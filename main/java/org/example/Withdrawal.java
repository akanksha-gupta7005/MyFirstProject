package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;

    Withdrawal(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.CENTER_BASELINE,20));
        text.setBounds(280,130,400,20);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(300,200,320,25);
        add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(300,270,320,30);
        withdraw.addActionListener(this);
        add(withdraw);


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
        if (e.getSource() == withdraw) {
            String paisa  = amount.getText();
            Date date = new Date();


            try {
                if (paisa.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                } else {
                    conn c = new conn();

                    ResultSet re = c.stmt.executeQuery ("select amount from bank where pin = '"+pinnumber+"'");
                    while(re.next()) {
                        if((re.getDouble("amount")) > Integer.parseInt(paisa)) {
                            String query = "INSERT INTO bank VALUES('" + pinnumber + "', '" + date + "', ' withdraw ','" + paisa + "')";
                            c.stmt.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Rs. " + paisa + " Withdraw Successfully");
                            setVisible(false);
                            new Transaction(pinnumber).setVisible(true);
                            break;
                        }
                    }
                    re.close();
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
        new Withdrawal("");
    }
}

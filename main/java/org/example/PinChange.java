package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD,25));
        text.setBounds(360,100,500,35);
        add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System",Font.BOLD,20));
        pintext.setBounds(290,200,180,20);
        add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(480,200,200,25);
        add(pin);

        JLabel repintext = new JLabel("Re-Enter NEW PIN:");
        repintext.setForeground(Color.BLACK);
        repintext.setFont(new Font("System",Font.BOLD,20));
        repintext.setBounds(290,260,180,25);
        add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,20));
        repin.setBounds(480,260,200,25);
        add(repin);

        change = new JButton("Change");
        change.setBounds(480,320,200,30);
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(480,360,200,30);
        back.addActionListener(this);
        add(back);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new pin");
                    return;
                }

                conn c = new conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);
                c.stmt.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN change successfully");

                setVisible(false);
                new Transaction(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }



    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);

    }
}

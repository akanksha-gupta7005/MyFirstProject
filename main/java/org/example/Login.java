package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardtextfield;
    JPasswordField pintextfield;


    Login() {
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(""));
//        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel lable = new JLabel(i3);
//        lable.setBounds(70,10,100,100);
//        add(lable);
//
//        getContentPane().setBackground(Color.white);
//

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward", Font.BOLD, 25));
        text.setBounds(250, 40, 400, 40);
        add(text);


        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(150, 150, 150, 30);
        add(cardNo);

        cardtextfield = new JTextField();
        cardtextfield.setBounds(300, 150, 230, 30);
        cardtextfield.setFont((new Font("Arial", Font.BOLD, 15)));
        add(cardtextfield);


        JLabel pinNo = new JLabel("Pin No:");
        pinNo.setFont(new Font("Raleway", Font.BOLD, 20));
        pinNo.setBounds(150, 220, 150, 30);
        add(pinNo);


        pintextfield = new JPasswordField();
        pintextfield.setBounds(300, 220, 230, 30);
        pintextfield.setFont((new Font("Arial", Font.BOLD, 15)));
        add(pintextfield);


        login = new JButton("SING IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);


        clear = new JButton("Clear");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


        signup = new JButton("SING UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardtextfield.setText((""));
            pintextfield.setText((""));

        } else if (e.getSource() == login) {
            conn c = new conn();
            String cardnumber = cardtextfield.getText();
            String pinnumber =  pintextfield.getText();
            String query = "SELECT * FROM login WHERE cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
             try{
               ResultSet reset =  c.stmt.executeQuery(query);
               if(reset.next()){
                   setVisible(false);
                   new Transaction(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Incorrect cardnumber and pin");
               }
             }catch (Exception ex){
                 System.out.println(ex);

             }

        } else if (e.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        Login log = new Login();
    }
}

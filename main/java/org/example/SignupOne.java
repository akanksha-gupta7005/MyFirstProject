package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import java.sql.*;


public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nametext, fnametext, dobtext, emailtext, addtext, citytext, statetext, pintext;
    JButton next;
    JRadioButton male, female, marit, unmarit, other;

    SignupOne() {

        setLayout(null);
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formno = new JLabel("Application Form No." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(230, 20, 600, 40);
        add(formno);


        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 25));
        personalDetail.setBounds(270, 75, 400, 30);
        add(personalDetail);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        nametext = new JTextField();
        nametext.setBounds(290, 140, 400, 25);
        nametext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(nametext);


        JLabel fname = new JLabel("Father's name:");
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        fname.setBounds(100, 190, 190, 30);
        add(fname);
        fnametext = new JTextField();
        fnametext.setBounds(290, 190, 400, 25);
        fnametext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(fnametext);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        dobtext = new JTextField();
        dobtext.setBounds(290, 240, 400, 25);
        dobtext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(dobtext);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 25);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 80, 25);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        emailtext = new JTextField();
        emailtext.setBounds(290, 340, 400, 25);
        emailtext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(emailtext);


        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Arial", Font.BOLD, 20));
        marital.setBounds(100, 390, 190, 30);
        add(marital);
        marit = new JRadioButton("Married");
        marit.setBounds(300, 390, 100, 25);
        marit.setBackground(Color.WHITE);
        add(marit);
        unmarit = new JRadioButton("Unmarried");
        unmarit.setBounds(450, 390, 100, 25);
        unmarit.setBackground(Color.WHITE);
        add(unmarit);
        other = new JRadioButton("Other");
        other.setBounds(630, 390, 80, 25);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup setmarit = new ButtonGroup();
        setmarit.add(marit);
        setmarit.add(unmarit);
        setmarit.add(other);


        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(100, 440, 190, 30);
        add(address);
        addtext = new JTextField();
        addtext.setBounds(290, 440, 400, 25);
        addtext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(addtext);


        JLabel city = new JLabel("City:");
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(100, 490, 190, 30);
        add(city);
        citytext = new JTextField();
        citytext.setBounds(290, 490, 400, 25);
        citytext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(citytext);


        JLabel state = new JLabel("State:");
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(100, 540, 190, 30);
        add(state);
        statetext = new JTextField();
        statetext.setBounds(290, 540, 400, 25);
        statetext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(statetext);


        JLabel pin = new JLabel("Pin No.:");
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        pin.setBounds(100, 590, 190, 30);
        add(pin);
        pintext = new JTextField();
        pintext.setBounds(290, 590, 400, 25);
        pintext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(pintext);


        JButton next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String formno = "" + random;
        String name = nametext.getText();
        String fname = fnametext.getText();
        String dob = dobtext.getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailtext.getText();
        String marital = null;
        if (marit.isSelected()) {
            marital = "Married";
        } else if (unmarit.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addtext.getText();
        String city = citytext.getText();
        String state = statetext.getText();
        String pin = pintext.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is require");
            } else {
                conn c = new conn();
                String query = "INSERT INTO signup VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + state + "', '" + pin + "')";
                c.stmt.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);

            }
            if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is require");
            }
            if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is require");
            }
            if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pin is require");
            }
            if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is require");
            }
            if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is require");
            }
            if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is require");
            }
            if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Date of Birth is require");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }


    }


    public static void main(String[] args) {
        new SignupOne();
    }
}

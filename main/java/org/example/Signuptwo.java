
package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;


public class Signuptwo extends JFrame implements ActionListener {


    JTextField addtext, citytext;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, education, occupation;
    String formno;

    Signuptwo(String formno) {
        this.formno = formno;

        setLayout(null);
        setTitle("New Account Application Form -- Page2");


        JLabel personalDetail = new JLabel("Page 2: Additional Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD, 25));
        personalDetail.setBounds(270, 75, 400, 30);
        add(personalDetail);


        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valreligion);
        religion.setBounds(290, 140, 400, 25);
        religion.setBackground(Color.WHITE);
        add(religion);


        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        fname.setBounds(100, 190, 190, 30);
        add(fname);
        String valcat[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcat);
        category.setBounds(290, 190, 400, 25);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        String valincome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(290, 240, 400, 25);
        income.setBackground(Color.WHITE);
        add(income);


        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(100, 315, 200, 30);
        add(email);

        String valedu[] = {"Non Graduation", "Graduation", "Post Graduation", "Doctrate", "Other"};
        education = new JComboBox(valedu);
        education.setBounds(290, 315, 400, 25);
        education.setBackground(Color.WHITE);
        add(education);


        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("Arial", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        String valocc[] = {"Salaried", "Self Employed", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(valocc);
        occupation.setBounds(290, 390, 400, 25);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address = new JLabel("Pan Number:");
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(100, 440, 190, 30);
        add(address);
        addtext = new JTextField();
        addtext.setBounds(290, 440, 400, 25);
        addtext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(addtext);


        JLabel city = new JLabel("Aadhar Number:");
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(100, 490, 190, 30);
        add(city);
        citytext = new JTextField();
        citytext.setBounds(290, 490, 400, 25);
        citytext.setFont((new Font("Arial", Font.BOLD, 15)));
        add(citytext);

        JLabel marita = new JLabel("Senior Citizen:");
        marita.setFont(new Font("Arial", Font.BOLD, 20));
        marita.setBounds(100, 540, 150, 30);
        add(marita);
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 25);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 25);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup setmarit = new ButtonGroup();
        setmarit.add(syes);
        setmarit.add(sno);


        JLabel state = new JLabel("Existing Account:");
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(100, 590, 190, 30);
        add(state);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 25);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 25);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup setmar = new ButtonGroup();
        setmar.add(eyes);
        setmar.add(eno);


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

        String name = (String) religion.getSelectedItem();
        String fname = (String) category.getSelectedItem();
        String dob = (String) income.getSelectedItem();
        String gender = (String) education.getSelectedItem();
        String marital = (String) occupation.getSelectedItem();

        String state = null;
        if (eyes.isSelected()) {
            state = "Yes";
        } else if (eno.isSelected()) {
            state = "No";
        }

        String marita = null;
        if (syes.isSelected()) {
            marital = "Yes";
        } else if (sno.isSelected()) {
            marital = "No";
        }

        String address = addtext.getText();
        String city = citytext.getText();


        try {

            conn c = new conn();
            String query = "INSERT INTO signuptwo (formno,religion ,category ,income ,education ,occupation ,existing_account ,pan_number ,aadhar_number ,senior_citizen ) VALUES ( '"+formno+"','" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + marital + "', '" + state + "','" + address + "','" + city + "','" + marita + "')";
//            c.stmt = c.connection.createStatement();
            c.stmt.executeUpdate(query);

            setVisible(false);
            new Signupthree(formno).setVisible(true);


        } catch (Exception ex) {
            System.out.println(ex);
        }


    }


    public static void main(String[] args) {
        new Signuptwo("");
    }
}

package Projet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;


public class client extends JFrame implements ActionListener {
    JLabel l1=new JLabel("Nom:");
    JLabel l2=new JLabel("Prenom:");
    JLabel l3=new JLabel("Specialité:");
    JLabel l4=new JLabel("Club:");
    JTextField t1=new JTextField(10);
    JTextField t2=new JTextField(10);
    JComboBox t3=new JComboBox();
    JComboBox t4=new JComboBox();
    JButton b1=new JButton("OK");
    JButton b2=new JButton("Annuler");
    public client(){
        setTitle("client");
        setSize(200,150);
        b1.addActionListener(this);
        b2.addActionListener(this);
        Container c=getContentPane();
        t3.addItem("");
        t3.addItem("BD");
        t3.addItem("IM");
        t3.addItem("MIME");
        t4.addItem("");
        t4.addItem("Orenda");
        t4.addItem("IMC");
        t4.addItem("J2I");
        c.setLayout(new GridLayout(5,2,4,4));
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
        c.add(l3);
        c.add(t3);
        c.add(l4);
        c.add(t4);
        c.add(b1);
        c.add(b2);
        show();
    }
    public void actionPerformed(ActionEvent e){
        String i1=t1.getText().toString();
        String i2=t2.getText().toString();
        String i3=t3.getSelectedItem().toString();
        String i4=t4.getSelectedItem().toString();
        if(i1==""||i2==""||i3==""||i4==""){
            JOptionPane.showMessageDialog(null,"inserez tous les valeurs!");
        }
        else{
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:sqlite:C:\\Users\\alaak\\OneDrive\\Bureau\\sqlite\\projet.db";
            Connection conn=DriverManager.getConnection(url);
            try{
                Statement r1=conn.createStatement();
                r1.executeUpdate("insert into ETUDIANT  values ('"+i1 +"','" + i2 +"','"+i3+"','"+i4+"')");
                JOptionPane.showMessageDialog(null,"insertion reussite");
                }
            catch(Exception error){
                JOptionPane.showMessageDialog(null,"erreur lors de l'insertion");
            }
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }

        }
    }
}

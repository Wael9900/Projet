package Projet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;


public class Acceuil extends JFrame implements ActionListener {
        JButton b1=new JButton("Admin");
        JButton b2=new JButton("Client");
    public Acceuil(){
        setTitle("Acceuil");
        setSize(150,170);
        Container c=getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
        c.add(b1);
        c.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource()==b1) {
            admin f1=new admin();
        }
        if (e.getSource()==b2){
            client f2=new client();
        }
    }
    public static void main(String[] args) {
        Acceuil f=new Acceuil();
    }
}
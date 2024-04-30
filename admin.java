package Projet;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class admin extends JFrame implements ActionListener  {
    JLabel l1=new JLabel("choix");
    JComboBox n=new JComboBox();
    JTextField t1=new JTextField(10);
    JButton b1=new JButton("valider");
    DefaultTableModel tab1=new DefaultTableModel();
    JTable table=new JTable(tab1);
    public admin(){
        setTitle("Admin");
        setSize(250,300);
        n.addItem("specialité");
        n.addItem("club");
        Container c=getContentPane();
        b1.addActionListener(this);
        c.setLayout(new FlowLayout(FlowLayout.CENTER,15,15));
        c.add(n);
        c.add(t1);
        c.add(b1);
        c.add(table);
        show();
    }
    public void actionPerformed(ActionEvent e){
        String x1=t1.getText().toString();
        if(x1.equals("")){
            JOptionPane.showMessageDialog(null,"ecrire une specialité ou une club d'abord");
        }
        else{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url="jdbc:sqlite:C:\\Users\\alaak\\OneDrive\\Bureau\\sqlite\\projet.db";
                Connection conn=DriverManager.getConnection(url);
                Statement r2=conn.createStatement();
                if (n.getSelectedItem().toString()=="specialité") {
                    try{
                        ResultSet r=r2.executeQuery("select * from ETUDIANT where (specialité='"+x1+"');");
                        ResultSetMetaData m=r.getMetaData();
                        int col=m.getColumnCount();
                        Object[] nom=new Object[col];
                        for(int i=1;i<=col;i++){
                            nom[i-1]=m.getColumnName(i);
                        }
                        DefaultTableModel tab=new DefaultTableModel(nom,0);
                        tab.addRow(nom);
                        while (r.next()) {
                            Object[] o1=new Object[col];
                            for(int j=0;j<col;j++){
                                o1[j]=r.getObject(j+1);
                            }
                            tab.addRow(o1);  
                        }
                        table.setModel(tab);

                    }
                    catch(Exception a){
                        JOptionPane.showMessageDialog(null, a);
                    }    
                }
                else{
                    try{
                        ResultSet r=r2.executeQuery("select * from ETUDIANT where club='"+x1+"';");
                        ResultSetMetaData m=r.getMetaData();
                        int col=m.getColumnCount();
                        Object[] nom=new Object[col];
                        for(int i=1;i<=col;i++){
                            nom[i-1]=m.getColumnName(i);
                        }
                        DefaultTableModel tab=new DefaultTableModel(nom,0);
                        tab.addRow(nom);
                        while (r.next()) {
                            Object[] o1=new Object[col];
                            for(int j=0;j<col;j++){
                                o1[j]=r.getObject(j+1);
                            }
                            tab.addRow(o1);  
                        }
                        table.setModel(tab);
                        System.out.println("5edmt");

                    }
                    catch(Exception a){
                        JOptionPane.showMessageDialog(null, a);
                    }    
                }
                

                
                
            }
            catch(Exception a){
                JOptionPane.showMessageDialog(null, a);
            }
        }

    }
    public static void main(String[] args) {
        admin f=new admin();
    }
}


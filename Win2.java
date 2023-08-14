/*
Win2.java
*/
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win2 extends JFrame{
    //properties
    JButton btnPrev;
    JLabel lblInfo;

    //constructor
    public Win2(){
        super("This is window 2");
        setSize(400,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    //methods
    private void init(){
        lblInfo = new JLabel("This is the second Window"); 
        lblInfo.setBounds(200,50,200,30);
      
        btnPrev = new JButton("Back");
        btnPrev.setBounds(200,100,200,30);

        add(lblInfo);
        add(btnPrev);

        //action  
        btnPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }
    //static main

}
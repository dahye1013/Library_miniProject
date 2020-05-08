package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FindPW extends JFrame implements ActionListener{
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    JButton findB, cancelB;
    JLabel lblNewLabel = new JLabel("");
    
    FindPW(){
        lblNewLabel.setText("Find PW");
        setBounds(700, 200, 300, 250);
        getContentPane().setLayout(null);
        setVisible(true);
        setResizable(false);
        
        lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 19));
        lblNewLabel.setBounds(105, 10, 64, 21);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(48, 62, 57, 15);
        getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(127, 60, 116, 21);
        getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        lblEmail.setBounds(48, 98, 57, 15);
        getContentPane().add(lblEmail);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(127, 96, 116, 21);
        getContentPane().add(textField_1);

        JButton findB = new JButton("Find");
        findB.setBounds(37, 140, 97, 39);
        getContentPane().add(findB);

        JButton canelB = new JButton("Cancel");
        canelB.setBounds(146, 140, 97, 39);
        getContentPane().add(canelB);
        
        findB.addActionListener(this);
        canelB.addActionListener(this);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==findB) {
            
        }else if(e.getSource()==cancelB) {
            this.setVisible(false);
        }
        
    }
    
    
}

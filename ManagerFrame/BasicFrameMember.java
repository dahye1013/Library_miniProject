package ManagerFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class BasicFrameMember extends JFrame {
    public BookManagement p1;
    public LendBookManage p2;
    public BookReport p3;
    
    public BasicFrameMember() {
        super("Library");

        
        JTabbedPane t = new JTabbedPane(); // JTabbedPane생성

        p1 = new BookManagement();
        p2 = new LendBookManage();
        p3 = new BookReport();
         
        JTabbedPane tab = new JTabbedPane();
        tab.add(p1,"BookManage");
        tab.add(p2,"LendManage");
        tab.add(p3,"BookReport");
        
        add(tab);
        
        setBounds(700, 100, 1100, 800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int result=  JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
                if(result == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
            
    }

    public static void main(String[] args) {
        new BasicFrameMember();
    }

}


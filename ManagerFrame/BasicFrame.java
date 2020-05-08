package ManagerFrame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BasicFrame extends JFrame {
    public BookManagement p1;
    public LendBookManage p2;
    public Panel03 p3;
    
    BasicFrame() {
        super("Library");

        
        JTabbedPane t = new JTabbedPane(); // JTabbedPane생성

        p1 = new BookManagement();
        p2 = new LendBookManage();
        p3 = new Panel03();
         
        JTabbedPane tab = new JTabbedPane();
        tab.add(p1,"BookManage");
        tab.add(p2,"LendManage");
        tab.add(p3,"p3");
        
        add(tab);
        
        setBounds(700, 100, 1100, 800);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new BasicFrame();
    }

}


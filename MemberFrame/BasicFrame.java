package MemberFrame;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class BasicFrame extends JFrame {
    public BookSearch p1;
    public Panel02 p2;
    public Panel03 p3;
    
    BasicFrame() {
        super("Library");

        
        JTabbedPane t = new JTabbedPane(); // JTabbedPane생성

        p1 = new BookSearch();
        p2 = new Panel02();
        p3 = new Panel03();
        
        JTabbedPane tab = new JTabbedPane();
        tab.add(p1,"BookManage");
        tab.add(p2,"p2");
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


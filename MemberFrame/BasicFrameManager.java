package MemberFrame;

import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class BasicFrameManager extends JFrame {
    public BookSearch p1;
    public Panel02 p2;
    public Panel03 p3;
    Panel p4;
    Panel p5;
    
    public BasicFrameManager() {
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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int result=  JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
                if(result == JOptionPane.NO_OPTION)//저장하지않고 종료
                  return;
            }
        });
    }

    public static void main(String[] args) {
        new BasicFrameManager();
    }

}


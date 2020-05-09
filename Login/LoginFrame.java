package Login;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{
    static LoginFrame login ;
	public LoginManager manager;
	public LoginMember member;
	

    LoginFrame(){
        super("Login");
        
        Container c = this.getContentPane();
        
        manager = new LoginManager();
        member = new LoginMember();
        
		JTabbedPane tab = new JTabbedPane(JTabbedPane.NORTH);
		tab.add(member, "일반회원" );
		tab.add(manager, "관리자");	
		
		c.add(tab);
		
        setBounds(700, 100, 300, 450);
        setVisible(true);
		setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        repaint();
        
    }
    

    
    
    public static void main(String[] args) {
        new LoginFrame();
    }
    
}

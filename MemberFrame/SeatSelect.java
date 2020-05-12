package MemberFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class SeatSelect extends JPanel implements ActionListener{
	
	private JLabel titleL;
	private JToggleButton[] seatBtn;
	private ButtonGroup group;
	private int indexOfButton = -1;
	private boolean sameSeatChecked = true;
	
	
	
	public SeatSelect() {
		

		
		JPanel seatP = new JPanel(new GridLayout(6,4,5,40));
		seatP.setBackground(new Color(0,0,0,0));
		seatP.setBounds(150,150,500,500);
		
		seatBtn = new JToggleButton[24];
		group = new ButtonGroup();
		
		for(int i=0; i<24; i++) {
			
			seatBtn[i] = new JToggleButton(i+1+"",new ImageIcon("images/Btn1.png"),false);
			seatBtn[i].setHorizontalTextPosition(JToggleButton.CENTER);
			seatBtn[i].setFont(new Font("맑은고딕", Font.BOLD, 22));
			seatBtn[i].setForeground(new Color(203,225,152));
			seatBtn[i].setBorderPainted(false);
			seatP.add(seatBtn[i]);
			group.add(seatBtn[i]);
		}
		
		

		
	//----------------------------------------------------	
		JPanel panel01 = new JPanel();
		panel01.setLayout(null);
		panel01.setBounds(830,120,250,600); //수정
		panel01.setBackground(new Color(0,0,0,0));
			
        
        JLabel lblNewLabel_1 = new JLabel("00/24명 입실 중입니다.");
        lblNewLabel_1.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(20, 101, 221, 49);
        panel01.add(lblNewLabel_1);
        
        
        JPanel btnP = new JPanel(new GridLayout(1,2,0,0));
        
        JButton btnNewButton = new JButton("입실");
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("맑은고딕", Font.BOLD, 30));
        btnNewButton.setForeground(Color.BLACK);
        btnP.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("퇴실");
        btnNewButton_1.setBackground(Color.BLUE);
        btnNewButton_1.setFont(new Font("맑은고딕", Font.BOLD, 30));
        btnP.add(btnNewButton_1);
        
        btnP.setBounds(0,250,235,200);
        
        panel01.add(btnP);
        
//        JButton btnNewButton_2 = new JButton("문의");
//        btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 20));
//        btnNewButton_2.setBounds(167, 603, 97, 54);
//        panel01.add(btnNewButton_2);
        
        
		
	//---------------------------------------------------------	


		setLayout(null);		
		add("East", panel01);
		add("Center", seatP);
		//add("North",titleL);
		
		
		for(int i=0; i<seatBtn.length; i++) {
			seatBtn[i].addActionListener(this);
		}
		
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JToggleButton btn = (JToggleButton) e.getSource();
		
		if(btn.isSelected()) { // 버튼이 눌렸을때, true
			btn.setIcon(new ImageIcon("images/btn4.png"));				
			btn.setForeground(Color.white);
		}
		
		if(indexOfButton != -1) {
			if(indexOfButton == Integer.parseInt(btn.getText())-1) {
				if(sameSeatChecked == true) {
					btn.setIcon(new ImageIcon("images/btn1.png"));
					btn.setForeground(new Color(203,225,152));	
					sameSeatChecked = false;
				}else {
					btn.setIcon(new ImageIcon("images/btn4.png"));				
					btn.setForeground(Color.white);
					sameSeatChecked = true;

				}
							
			}else {
				sameSeatChecked = true;
				seatBtn[indexOfButton].setSelected(false);
				seatBtn[indexOfButton].setIcon(new ImageIcon("btn1.png"));
				seatBtn[indexOfButton].setForeground(new Color(203,225,152));	
			}
			
		}
		
		
		indexOfButton = Integer.parseInt(btn.getText())-1;
		//System.out.println(indexOfButton);
				
	}
	
	public void paintComponent(Graphics g) {
	       Dimension d = getSize();
	       ImageIcon img = new ImageIcon("images/seatSelect.jpg");
	       g.drawImage(img.getImage(),0,0,d.width,d.height, null);
	}
	
	

}

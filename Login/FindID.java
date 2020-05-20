package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import manager.dao.MemberDAO;
import manager.dto.MemberDTO;


public class FindID extends JFrame implements ActionListener {
	JFrame frame;
	JTextField nameT;
	JLabel nameL;
	JLabel emailL;
	JTextField emailT;
	JButton findB, cancelB;
	JLabel title = new JLabel("");
	private MemberDAO memberDAO = new MemberDAO();// 0514추가
	public  List<MemberDTO> list = new ArrayList<MemberDTO>();// 0514추가 수정

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon img = new ImageIcon("Images/login.jpg");
		g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
	}

	FindID() {

		title.setText("ID찾기");
		setBounds(700, 200, 300, 250);
		setVisible(true);
		setResizable(false);
		setBackground(Color.white);

		this.setLayout(null);

		title.setFont(new Font("굴림", Font.PLAIN, 19));
		title.setBounds(105, 10, 64, 21);
		this.add(title);

		nameL = new JLabel("이름");
		nameL.setFont(new Font("굴림", Font.PLAIN, 14));
		nameL.setBounds(48, 62, 57, 15);
		this.add(nameL);

		nameT = new JTextField();
		nameT.setBounds(127, 60, 116, 21);
		getContentPane().add(nameT);
		nameT.setColumns(10);

		emailL = new JLabel("이메일");
		emailL.setFont(new Font("굴림", Font.PLAIN, 14));
		emailL.setBounds(48, 98, 57, 15);
		this.add(emailL);

		emailT = new JTextField();
		emailT.setColumns(10);
		emailT.setBounds(127, 96, 116, 21);
		this.add(emailT);

		findB = new JButton("찾기");
		findB.setBounds(37, 140, 97, 39);
		findB.setBackground(Color.white);
		this.add(findB);

		cancelB = new JButton("취소");
		cancelB.setBounds(146, 140, 97, 39);
		cancelB.setBackground(Color.white);
		this.add(cancelB);

		findB.addActionListener(this);
		cancelB.addActionListener(this);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		list = memberDAO.getMemberList();
		if (e.getSource() == findB) {
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					if (nameT.getText().equals(list.get(i).getName()) && emailT.getText().equals(list.get(i).getEmail())) {
						JOptionPane.showMessageDialog(this, "회원님의 아이디는 [" + list.get(i).getId() + "] 입니다");
						return;
					}
				}//for
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다.");	
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다.");
			}//size 체크(null아닐때)
		} else if (e.getSource() == cancelB) {
			dispose();
		}//버튼 선택 if

	}

}

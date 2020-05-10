package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ManagerFrame.BasicFrameMember;
import MemberFrame.BasicFrameManager;

public class LoginMember extends JPanel implements ActionListener {
	public JPanel bigP, p1, p2, p3, p4;
	private JFrame findF1, findF2;
	private JTextField idT, pwT;
	private JLabel loginL, findL, verifyL, signL;
	private JButton loginB, findID, findPW, signB;

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon img = new ImageIcon("Images/login.jpg");
		g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
	}

	LoginMember() {
		loginL = new JLabel("회원 로그인");

		p1 = new JPanel(new GridLayout(5, 1, 5, 10));
		p2 = new JPanel(new GridLayout(1, 2, 5, 10));
		p3 = new JPanel();
		p4 = new JPanel(new GridLayout(4, 1, 5, 10));

		p1.setBackground(Color.white);
		p2.setBackground(Color.white);
		p4.setBackground(Color.white);

		idT = new JTextField(20);
		pwT = new JTextField(20);

		findL = new JLabel("아이디 혹은 비밀번호를 잃어버렸나요?");
		signL = new JLabel("If you're not member");
		verifyL = new JLabel("");
		JLabel[] blankL = new JLabel[5];
		for (int i = 0; i < blankL.length; i++) {
			blankL[i] = new JLabel("");
		}

		loginB = new JButton("Login");
		findID = new JButton("Find ID");
		findPW = new JButton("Find PW");
		signB = new JButton("Join us");
		findID.setBackground(Color.white);
		findPW.setBackground(Color.white);
		loginB.setBackground(Color.white);
		signB.setBackground(Color.white);

		idT.setText("ID");
		pwT.setText("Password");

		p1.add(loginL);
		p1.add(idT);
		p1.add(pwT);
		p1.add(loginB);
		p1.add(findL);

		p2.add(findID);
		p2.add(findPW);

		p3.setLayout(null);

		p4.add(blankL[1]);
		p4.add(verifyL);
		p4.add(signL);
		p4.add(signB);

		add(p1);
		add(p2);
		add(p3);
		add(p4);

		idT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				idT.setText("");
			}
		});
		pwT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pwT.setText("");
			}
		});

		findID.addActionListener(this);
		findPW.addActionListener(this);
		signB.addActionListener(this);
		loginB.addActionListener(this);
	}

	public void managerSet() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == findID) {
			new FindID();
		} else if (e.getSource() == findPW) {
			new FindPW();
		} else if (e.getSource() == signB) {
			new SignUpMember();
		} else if (e.getSource() == loginB) {

			if (SignUpMember.list.size() != 0) {
				for (int i = 0; i < SignUpMember.list.size(); i++) {
					if (idT.getText().equals(SignUpMember.list.get(i).getId())
							|| pwT.getText().equals(SignUpMember.list.get(i).getPassword())) {
						JOptionPane.showMessageDialog(this, "로그인 성공");
						new BasicFrameManager();
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, "아이디와 비밀번호를 확인하세요");
			}

		}
	}

}

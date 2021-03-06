package login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import manager.dao.MemberDAO;
import manager.dto.MemberDTO;

public class FindPW extends JFrame implements ActionListener {
	private JFrame frame;
	private JTextField idT;
	private JTextField emailT;
	JButton findB, cancelB;
	JLabel title = new JLabel("");
	private MemberDAO memberDAO = new MemberDAO();// 0514추가
	public List<MemberDTO> list = new ArrayList<MemberDTO>();// 0514추가 수정

	FindPW() {
		title.setText("PW찾기");
		setBounds(700, 200, 300, 250);
		getContentPane().setLayout(null);
		setVisible(true);
		setResizable(false);

		title.setFont(new Font("굴림", Font.PLAIN, 19));
		title.setBounds(105, 10, 64, 21);
		getContentPane().add(title);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(48, 62, 57, 15);
		getContentPane().add(lblNewLabel_1);

		idT = new JTextField();
		idT.setBounds(127, 60, 116, 21);
		getContentPane().add(idT);
		idT.setColumns(10);

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
		lblEmail.setBounds(48, 98, 57, 15);
		getContentPane().add(lblEmail);

		emailT = new JTextField();
		emailT.setColumns(10);
		emailT.setBounds(127, 96, 116, 21);
		getContentPane().add(emailT);

		findB = new JButton("찾기");
		findB.setBounds(37, 140, 97, 39);
		getContentPane().add(findB);

		cancelB = new JButton("취소");
		cancelB.setBounds(146, 140, 97, 39);
		getContentPane().add(cancelB);

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
					if (idT.getText().equals(list.get(i).getId()) && emailT.getText().equals(list.get(i).getEmail())) {
						
						new LoginSendMail().findPWMail(list.get(i).getId(),list.get(i).getEmail(),list.get(i).getPassword());
						JOptionPane.showMessageDialog(this, "비밀번호을 해당 이메일로 발송하였습니다.");
						dispose();
						return;
						
					}
				}
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다.");	
			} else {
				JOptionPane.showMessageDialog(this, "등록된 회원정보가 없습니다.");
			}//같은 비밀번호 찾기 if
		} else if (e.getSource() == cancelB) {
			dispose();
		}//버튼 선택 if

	}

}

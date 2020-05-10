package Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SignUpMember extends JFrame implements ActionListener {

	private JTextField idT;
	private JTextField pwT;
	private JTextField nameT;
	private JTextField birthT;
	private JTextField emailT;
	private JRadioButton maleB, femaleB;
	private JButton joinB;
	public static List<MemberDTO> list = new ArrayList<MemberDTO>();
	 ImageIcon icon;
	 JScrollPane scrollPane;
	SignUpMember() {
		
		super("member Join");
		 JPanel panel = new JPanel() {
			 public void paintComponent(Graphics g) {
				Dimension d = getSize();
				ImageIcon img = new ImageIcon("Images/signUp.png");
				g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
			}
		 };
		setBounds(700, 100, 290, 401);

		panel.setLayout(null);
		
		JLabel signupL = new JLabel("회원가입");
		signupL.setFont(new Font("문체부 쓰기 흘림체", Font.BOLD, 20));
		signupL.setBounds(96, 10, 98, 28);
		panel.add(signupL);

		JLabel idL = new JLabel("ID");
		idL.setBounds(42, 53, 18, 15);
		panel.add(idL);

		idT = new JTextField("영문입력");
		idT.setBounds(130, 50, 116, 21);
		panel.add(idT);
		idT.setColumns(10);

		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setBounds(42, 86, 57, 15);
		panel.add(lblPassword);

		pwT = new JTextField("8자리이상");
		pwT.setColumns(10);
		pwT.setBounds(130, 83, 116, 21);
		panel.add(pwT);

		maleB = new JRadioButton("남성");
		maleB.setBounds(42, 139, 62, 23);
		maleB.setBackground(Color.white);
		panel.add(maleB);

		femaleB = new JRadioButton("여성");
		femaleB.setBounds(149, 139, 72, 23);
		femaleB.setBackground(Color.white);
		panel.add(femaleB);

		ButtonGroup group = new ButtonGroup();
		group.add(maleB);
		group.add(femaleB);

		nameT = new JTextField("닉네임을 설정하세요");
		nameT.setColumns(10);
		nameT.setBounds(130, 191, 116, 21);
		panel.add(nameT);

		JLabel lblNicknamel = new JLabel("닉네임");
		lblNicknamel.setBounds(42, 194, 76, 15);
		panel.add(lblNicknamel);

		birthT = new JTextField("생년월일 8자리");
		birthT.setColumns(10);
		birthT.setBounds(130, 222, 116, 21);
		panel.add(birthT);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setBounds(42, 225, 57, 15);
		panel.add(lblBirth);

		emailT = new JTextField("이메일을 입력하세요");
		emailT.setColumns(10);
		emailT.setBounds(130, 253, 116, 21);
		panel.add(emailT);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(42, 256, 57, 15);
		panel.add(lblEmail);

		JButton btnNewButton = new JButton("check");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 7));
		btnNewButton.setBounds(64, 49, 54, 23);
		panel.add(btnNewButton);
		
		
		joinB = new JButton("confirm");
		joinB.setBackground(Color.white);
		joinB.setBounds(42, 305, 204, 37);
		panel.add(joinB);
        setContentPane(panel);
		setVisible(true);
		setResizable(false);

		// ---------이벤트--------------------

		joinB.addActionListener(this);

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
		nameT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				nameT.setText("");
			}
		});
		birthT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				birthT.setText("");
			}
		});
		emailT.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				emailT.setText("");
			}
		});

		// -----------데이터 set--------------

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == joinB) {

			String id = idT.getText();
			String password = pwT.getText();
			String name = nameT.getText();
			String birth = birthT.getText();
			String email = emailT.getText();
			String sex = "남성";
			if (femaleB.isSelected()) {
				sex = "여성";
			}
			MemberDTO memberDTO = new MemberDTO(id, password, name, birth, email, sex);
			list.add(memberDTO);

			JOptionPane.showMessageDialog(this, "아이디가 생성되었습니다.");
			dispose();

		}
	}

}

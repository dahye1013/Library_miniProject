package Login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpManager extends JFrame implements ActionListener {

    private JTextField idT;
    private JPasswordField pwT;
    private JTextField nameT;
    private JTextField birthT;
    private JTextField emailT;
    JRadioButton maleB ,femaleB;
    private JButton joinB, btnNewButton;
    public static List<ManagerDTO> list = new ArrayList<ManagerDTO>();
    private boolean pwdCheck = false; // 추가, 비밀번호조건여부
    private boolean idCheck = false; // 추가, 아이디 중복체크 여부
    private String pwd;

    SignUpManager() {
        super("Manager Join");
        
        //임시데이터 생성------------------------
//        ManagerDTO dto = new ManagerDTO();
//        dto.setId("ykh4933");
//        list.add(dto);
        //---------------------------
        
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

        pwT = new JPasswordField("영문,숫자 8자리이상"); //수정
		pwT.setEchoChar((char) 0);//수정
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

        nameT = new JTextField("이름을 입력하세요.");
		nameT.setColumns(10);
		nameT.setBounds(130, 191, 116, 21);
		panel.add(nameT);

		JLabel lblNamel = new JLabel("이름");
		lblNamel.setBounds(42, 194, 76, 15);
		panel.add(lblNamel);

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

		btnNewButton = new JButton("check");
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
        btnNewButton.addActionListener(this);
        
        idT.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	idCheck = false;
                idT.setText("");
            }
        });
        pwT.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                pwT.setText("");
				pwT.setEchoChar('●'); //추가

            }
        });
        pwT.addKeyListener(new KeyAdapter() { //추가 
        	@Override
        	public void keyReleased(KeyEvent e) {
        		pwd ="";
        		boolean english = false;
        		boolean number = false;
        		char[] secret_pwd = pwT.getPassword();
        		
        		for(int i=0; i<secret_pwd.length; i++) {
        			int tempPwd = (int)secret_pwd[i];
        			if((tempPwd>64 &&  tempPwd<91 )||(tempPwd>96 &&  tempPwd<123) ) {
        				english = true;
        			}else if(tempPwd>47 &&  tempPwd<58 ) {
        				number = true;
        			}
        			pwd+=secret_pwd[i];
        			
        		}
        		
        		if(secret_pwd.length >=8 && english == true && number == true  ) {
        			pwT.setForeground(Color.blue);
        			pwdCheck = true;
        		}else {
        			pwT.setForeground(Color.red);
        		}
        		//System.out.println(pwd);
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
			//String password = pwT.getText();
			String nickName = nameT.getText();
			String birth = birthT.getText();
			String email = emailT.getText();
			String sex = "남성";
			if (femaleB.isSelected()) {
				sex = "여성";
			}
			
			//------------------------------비밀번호 부분 추가
	        if(pwdCheck == false ) {
	            JOptionPane.showMessageDialog(this, "비밀번호는 영문 숫자 혼합 8자리 이상이여야 합니다.");
	        }else if(idCheck == false){
	            JOptionPane.showMessageDialog(this, "아이디 중복확인을 해주세요.");

	        }else {// 회원가입 조건 만족
	        
	        	ManagerDTO managerDTO = new ManagerDTO(id, pwd, nickName, birth, email, sex);
				list.add(managerDTO);

				JOptionPane.showMessageDialog(this, "아이디가 생성되었습니다.");
				dispose();
	        }
	        //------------------------------------------------
	        
			

		}else if(e.getSource() == btnNewButton) { //아이디 중복확인 버튼 
			String id = idT.getText();
        	for(int i=0; i<list.size(); i++) {
        		System.out.println("dd");
        		if(!(id.equals(list.get(i).getId()))) {
        			JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.");
        			idCheck = true;

        		}else {
        			JOptionPane.showMessageDialog(this, "존재하는 아이디입니다.");
        			
        		}
        	}
        	
        }
    }

}

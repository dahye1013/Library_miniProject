package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp extends JFrame implements ActionListener {

    private JTextField idT;
    private JTextField pwT;
    private JTextField nickNameT;
    private JTextField birthT;
    private JTextField emailT;
    JRadioButton maleB ,femaleB;
    private JButton joinB;
    private ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();


    SignUp() {
        
        setBounds(700, 100, 290, 401);
        getContentPane().setLayout(null);

        JLabel signupL = new JLabel("회원가입");
        signupL.setFont(new Font("문체부 쓰기 흘림체", Font.PLAIN, 20));
        signupL.setBounds(96, 10, 98, 28);
        getContentPane().add(signupL);

        JLabel idL = new JLabel("ID");
        idL.setBounds(42, 53, 18, 15);
        getContentPane().add(idL);

        idT = new JTextField("영문입력");
        idT.setBounds(130, 50, 116, 21);
        getContentPane().add(idT);
        idT.setColumns(10);

        JLabel lblPassword = new JLabel("PassWord");
        lblPassword.setBounds(42, 86, 57, 15);
        getContentPane().add(lblPassword);

        pwT = new JTextField("8자리이상");
        pwT.setColumns(10);
        pwT.setBounds(130, 83, 116, 21);
        getContentPane().add(pwT);

         maleB = new JRadioButton("male");
        maleB.setBounds(42, 139, 62, 23);
        getContentPane().add(maleB);

         femaleB = new JRadioButton("female");
        femaleB.setBounds(149, 139, 72, 23);
        getContentPane().add(femaleB);
        
        ButtonGroup group = new ButtonGroup();
        group.add(maleB);
        group.add(femaleB);

        nickNameT = new JTextField("닉네임을 설정하세요");
        nickNameT.setColumns(10);
        nickNameT.setBounds(130, 191, 116, 21);
        getContentPane().add(nickNameT);

        JLabel lblNicknamel = new JLabel("Nickname");
        lblNicknamel.setBounds(42, 194, 76, 15);
        getContentPane().add(lblNicknamel);

        birthT = new JTextField("생년월일 6자리");
        birthT.setColumns(10);
        birthT.setBounds(130, 222, 116, 21);
        getContentPane().add(birthT);

        JLabel lblBirth = new JLabel("Birth");
        lblBirth.setBounds(42, 225, 57, 15);
        getContentPane().add(lblBirth);

        emailT = new JTextField("이메일을 입력하세요");
        emailT.setColumns(10);
        emailT.setBounds(130, 253, 116, 21);
        getContentPane().add(emailT);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(42, 256, 57, 15);
        getContentPane().add(lblEmail);

        JButton btnNewButton = new JButton("check");
        btnNewButton.setFont(new Font("굴림", Font.PLAIN, 7));
        btnNewButton.setBounds(64, 49, 54, 23);
        getContentPane().add(btnNewButton);

         joinB = new JButton("confirm");
        joinB.setBounds(42, 305, 204, 37);
        getContentPane().add(joinB);
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
        nickNameT.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                nickNameT.setText("");
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
        if(e.getSource() == joinB ) {
           
            String name = idT.getText();
            String password = pwT.getText();
            String nickName = nickNameT.getText();
            String birth = birthT.getText();
            String email = emailT.getText();
            
            MemberDTO memberDTO = new  MemberDTO( name,  password,  nickName,  birth,  email);
            if(maleB.isSelected()) {
                memberDTO.setSex(Sex.MALE);
            }else if(maleB.isSelected()) {
                memberDTO.setSex(Sex.FEMALE);
            }
            list.add(memberDTO);
            
            JOptionPane.showMessageDialog(this, "아이디가 생성되었습니다.");
            
            
        }
    }

}

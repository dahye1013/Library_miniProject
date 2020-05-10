package ManagerFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ManagerManagement extends JPanel implements ActionListener{
	
    private JButton searchBtn, inquiryBtn, withdrawBtn;
    
    private JTextField searchT;
    private JLabel labelL;
    
    private JComboBox<String> combo;
    private DefaultTableModel model;
    private JTable table;

    private JPanel p, p1, p2, p3, pp12, p4;

    public ManagerManagement() {    
        
        //라벨 생성
        labelL = new JLabel("Manager Management");
        labelL.setFont(new Font("고딕체", Font.BOLD , 65));
        //labelL.setForeground(new Color(255,0,0,0));
        
        //버튼 생성
        searchBtn = new JButton("검색");
        inquiryBtn = new JButton("조회");
        withdrawBtn = new JButton("탈퇴");
        
        //텍스트필드 생성
        searchT = new JTextField("안녕하세요", 30);
        
        //콤보박스 생성
        String[] comboItem = {"ID", "이름", "닉네임", "생년월일", "나이", "email", "성별", "연체 여부"};
        combo = new JComboBox<String>(comboItem);
        
        //Table 생성
        Vector<String> v = new Vector<String>();
        v.add("ID");
        v.add("이름");
        v.add("닉네임");
        v.add("생년월일");
        v.add("나이");
        v.add("email");
        v.add("성별");
        v.add("연체 여부");
        model = new DefaultTableModel(v,0);
        table = new JTable(model);
        
        //JScrollPanedp table 추가
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1000,430));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        //배치
        p1 = new JPanel();
        p1.add(labelL); //도서관리 title
        p1.setBackground(new Color(255,0,0,0));
        
        //검색창
        p2 = new JPanel();
        p2.add(combo);
        p2.add(searchT);
        p2.add(searchBtn);
        p2.setBackground(new Color(255,0,0,0));
        
        pp12 = new JPanel();
        pp12.setLayout(new BorderLayout());
        pp12.add("North" ,p1);
        pp12.add("South" ,p2);
        pp12.setBackground(new Color(255,0,0,0));
        
        //테이블
        p3 = new JPanel();
        p3.add(scroll);
        p3.setBackground(new Color(255,0,0,0));
        
        //조회, 탈퇴 버튼
        p4 = new JPanel();
        p4.add(inquiryBtn);
        p4.add(withdrawBtn);
        p4.setBackground(new Color(255,0,0,0));
        
        //big Panel
        p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add("North" , pp12);
        p.add("Center" , p3);
        p.add("South" , p4);
        p.setBackground(new Color(255,0,0,0));
        
        add(p);
        
        //이벤트
        searchBtn.addActionListener(this);
        inquiryBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
      
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == searchBtn) {
            // 회원 검색
        }else if(e.getSource() == inquiryBtn) {
        	// 마이페이지
        }else if(e.getSource() == withdrawBtn) {
        	// 회원리스트 삭제
        }
    }//actionPerformed()
}

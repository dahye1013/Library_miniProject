package MemberFrame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;

	public ChatClient(){
		output = new JTextArea();
		output.setFont(new Font("돋움체", Font.BOLD, 16));
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		input = new JTextField();
		sendBtn = new JButton("보내기");

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add("Center", input);
		p.add("East", sendBtn);

		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);
		
		setBounds(700,200,300,300);
		setVisible(true);

		addWindowListener(new WindowAdapter(){
			@Override
			public void	windowClosing(WindowEvent e){
				writer.println("exit");
				writer.flush();
			}
		});
	}

	public void service(){
		//서버IP
		String serverIP = "192.168.0.23";

		//닉네임
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요","닉네임",JOptionPane.INFORMATION_MESSAGE);
		if(nickName==null || nickName.length()==0){
			nickName="guest";
		}
		
		try{
			socket = new Socket(serverIP, 9500);

			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}

		writer.println(nickName);
		writer.flush();

		Thread t = new Thread(this);
		t.start();

		input.addActionListener(this);
		sendBtn.addActionListener(this);
	}

	@Override
	public void run(){
		String line;

		while(true){
			try{
				line = reader.readLine();
				if(line==null || line.equals("exit")) {
					reader.close();
					writer.close();
					socket.close();

					System.exit(0);
				}

				output.append(line+"\n");

				int pos = output.getText().length();
				output.setCaretPosition(pos);

			}catch(IOException e){
				e.printStackTrace();
			}
		}//while
	}

	@Override
	public void actionPerformed(ActionEvent e){
		String data = input.getText();
		writer.println(data);
		writer.flush();
		input.setText("");
	}

}

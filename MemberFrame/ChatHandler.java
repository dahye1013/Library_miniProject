package MemberFrame;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ChatHandler extends Thread {
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private List<ChatHandler> list;

	public ChatHandler(Socket socket, List<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;

		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	public void run(){
		try{
			String nickName = reader.readLine();
			broadcast(nickName+"님 입장하였습니다");
			
			String line;
			while(true){
				line = reader.readLine();
				if(line==null || line.equals("exit")){
					writer.println("exit");
					writer.flush();

					reader.close();
					writer.close();
					socket.close();

					list.remove(this);
					broadcast(nickName+"님 퇴장하였습니다");
					break;
				}//if

				broadcast("["+nickName+"] "+line);
			}//while

		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void broadcast(String msg){
		for(ChatHandler handler : list){
			handler.writer.println(msg);
			handler.writer.flush();
		}//for
	}
}

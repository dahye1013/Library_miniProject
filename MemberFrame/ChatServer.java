package MemberFrame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class ChatServer {
	private ServerSocket serverSocket;
	private List<ChatHandler> list;

	public ChatServer() {
		try {
			serverSocket = new ServerSocket(9500);
			System.out.println("�����غ�Ϸ�..");

			list = new ArrayList<ChatHandler>();

			while (true) {
				Socket socket = serverSocket.accept();

				ChatHandler handler = new ChatHandler(socket, list);
				handler.start();

				list.add(handler);
			} // while
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}
}

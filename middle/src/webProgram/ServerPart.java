package webProgram;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class ServerPart {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("监听端口号：8888");
			Socket socket = server.accept();
			System.out.println("连接：" + socket);
			InputStream stream = socket.getInputStream();
			int msg = stream.read();
			System.out.println(msg);
			socket.close();
			server.close();
		} catch (IOException e) {
		}
	}
}

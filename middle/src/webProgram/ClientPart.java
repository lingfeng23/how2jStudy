package webProgram;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class ClientPart {
	public static void main(String[] args) {
		try {
			//连接到本机的8888端口
			Socket socket = new Socket("127.0.0.1", 8888);
			OutputStream stream = socket.getOutputStream();
			stream.write(1000);
			stream.close();
			System.out.println(socket);
			socket.close();
		} catch (Exception e) {
		}
	}
}

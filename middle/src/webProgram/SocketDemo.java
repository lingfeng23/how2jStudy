package webProgram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/10/23
 */
public class SocketDemo {
	public static void main(String[] args) throws Exception {
		InetAddress host = InetAddress.getLocalHost();
		String IP = host.getHostAddress();
		System.out.println("本机IP地址：" + IP);

		Process process = Runtime.getRuntime().exec("ping " + "192.168.2.106");
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line = null;
		StringBuilder builder = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			if (line.length() != 0) {
				builder.append(line + "\r\n");
			}
		}
		System.out.println("本次指令返回消息：");
		System.out.println(builder.toString());
	}
}

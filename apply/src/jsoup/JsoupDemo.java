package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

/**
 * @author malf
 * @description jsoup示例
 * @project how2jStudy
 * @since 2020/10/23
 */
public class JsoupDemo {
	public static void main(String[] args) throws Exception {
		// 获取文档
		String html1 = "<html><body><p>Hello HTML</p></body></html>";
		Document document1 = Jsoup.parse(html1);
		System.out.println("字符串方式得到的Document:" + document1);

		File file = new File("E:\\malf\\how2jStudy\\apply\\src\\jsoup\\a.html");
		if (file.exists()) {
			Document document2 = Jsoup.parse(file, "utf-8");
			System.out.println("文件方式得到的Document:" + document2);
		}

		//String url = "http://baidu.com";
		//Document document3 = Jsoup.parse(new URL(url), 5000);
		//System.out.println("URL方式得到的Document:" + document3);

		// 获取元素
		file = new File("E:\\malf\\how2jStudy\\apply\\src\\jsoup\\b.html");
		Document document4 = Jsoup.parse(file, "utf-8");
		// 通过ID获取
		Element element = document4.getElementById("productName");
		System.out.println(element);
		System.out.println("----------");
		// 通过标签获取
		Elements elements = document4.getElementsByTag("a");
		for (Element el : elements) {
			System.out.println(el);
		}
		System.out.println("----------");
		// 桶属性获取
		elements = document4.getElementsByAttribute("name");
		for (Element el : elements) {
			System.out.println(el);
		}
	}
}

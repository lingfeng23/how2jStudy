package searchEngine;

import org.apache.lucene.analysis.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * @author malf
 * @description 分词器
 * @project how2jStudy
 * @since 2020/11/9
 */
public class AnalyzerTest {
	public static void main(String[] args) throws IOException {
		IKAnalyzer analyzer = new IKAnalyzer();
		TokenStream stream = analyzer.tokenStream("name", "床前明月光");
		stream.reset();
		while (stream.incrementToken()) {
			System.out.println(stream.reflectAsString(false));
		}

	}
}

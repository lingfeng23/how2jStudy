package searchEngine.lucene;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.print.Doc;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class LuceneTest {
	public static void main(String[] args) throws Exception {
		// 1、准备分词器
		IKAnalyzer analyzer = new IKAnalyzer();
		// 2、索引
		List<String> productNames = new ArrayList<>();
		productNames.add("飞利浦led灯泡e27螺口暖白球泡灯家用照明超亮节能灯泡转色温灯泡");
		productNames.add("飞利浦led灯泡e14螺口蜡烛灯泡3W尖泡拉尾节能灯泡暖黄光源Lamp");
		productNames.add("雷士照明 LED灯泡 e27大螺口节能灯3W球泡灯 Lamp led节能灯泡");
		productNames.add("飞利浦 led灯泡 e27螺口家用3w暖白球泡灯节能灯5W灯泡LED单灯7w");
		productNames.add("飞利浦led小球泡e14螺口4.5w透明款led节能灯泡照明光源lamp单灯");
		productNames.add("飞利浦蒲公英护眼台灯工作学习阅读节能灯具30508带光源");
		productNames.add("欧普照明led灯泡蜡烛节能灯泡e14螺口球泡灯超亮照明单灯光源");
		productNames.add("欧普照明led灯泡节能灯泡超亮光源e14e27螺旋螺口小球泡暖黄家用");
		productNames.add("聚欧普照明led灯泡节能灯泡e27螺口球泡家用led照明单灯超亮光源");
		Directory index = createIndex(analyzer, productNames);
		// 3、查询器
		String keyWord = "护眼带光源";
		Query query = new QueryParser("name", analyzer).parse(keyWord);
		// 4、搜索
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher searcher = new IndexSearcher(reader);
		int numberPerPage = 1000;
		System.out.printf("当前一共有%d条数据%n", productNames.size());
		System.out.printf("查询关键字是：\"%s\"%n", keyWord);
		ScoreDoc[] docs = searcher.search(query, numberPerPage).scoreDocs;
		// 5、显示查询结果
		showSearchResult(searcher, docs, query, analyzer);
		// 6、关闭查询
		reader.close();

	}

	private static void showSearchResult(IndexSearcher searcher, ScoreDoc[] docs, Query query, IKAnalyzer analyzer) throws Exception {
		System.out.println("找到 " + docs.length + " 个命中");
		System.out.println("序号\t匹配度得分\t结果");
		// 高亮显示，将结果复制到 HTML 中显示
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");
		Highlighter highlighter = new Highlighter(formatter, new QueryScorer(query));

		for (int i = 0; i < docs.length; i++) {
			ScoreDoc doc = docs[i];
			int docId = doc.doc;
			Document document = searcher.doc(docId);
			List<IndexableField> fields = document.getFields();
			System.out.print(i + 1);
			System.out.print("\t" + doc.score);
			for (IndexableField field : fields) {
				TokenStream stream = analyzer.tokenStream(field.name(),
						new StringReader(document.get(field.name())));
				String content = highlighter.getBestFragment(stream, document.get(field.name()));
				System.out.print("\t" + content);
				//System.out.print("\t" + document.get(field.name()));
			}
			System.out.println();
		}
	}

	/**
	 * 创建索引
	 *
	 * @param analyzer
	 * @param products
	 * @return
	 * @throws Exception
	 */
	private static Directory createIndex(IKAnalyzer analyzer, List<String> products) throws Exception {
		// 内存索引
		Directory index = new RAMDirectory();
		// 配置对象
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		// 索引
		IndexWriter writer = new IndexWriter(index, config);
		for (String name : products) {
			addDoc(writer, name);
		}
		writer.close();
		return index;
	}

	private static void addDoc(IndexWriter writer, String name) throws Exception {
		Document document = new Document();
		document.add(new TextField("name", name, Field.Store.YES));
		writer.addDocument(document);
	}
}

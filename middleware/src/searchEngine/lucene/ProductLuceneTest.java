package searchEngine.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class ProductLuceneTest {
	public static void main(String[] args) throws Exception {
		// 1、准备分词器
		IKAnalyzer analyzer = new IKAnalyzer();
		// 2、索引
		Directory index = createIndex(analyzer);
		// 3、查询器
		Scanner scanner = new Scanner(System.in);
		// 对索引的删除修改
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter writer = new IndexWriter(index, config);
		// 更新索引
		Document document = new Document();
		document.add(new TextField("id", "51173", Field.Store.YES));
		document.add(new TextField("name", "神鞭，鞭没了，神还在", Field.Store.YES));
		document.add(new TextField("category", "道具", Field.Store.YES));
		document.add(new TextField("price", "998", Field.Store.YES));
		document.add(new TextField("place", "南海群岛", Field.Store.YES));
		document.add(new TextField("code", "888888", Field.Store.YES));
		writer.updateDocument(new Term("id", "51173"), document);
		// 删除索引
		//writer.deleteDocuments(new Term("id", "51173"));

		writer.commit();
		writer.close();

		while (true) {
			System.out.print("请输入查询关键字");
			String keyWord = scanner.nextLine();
			System.out.println("当前关键字为：" + keyWord);
			Query query = new QueryParser("name", analyzer).parse(keyWord);
			// 4、搜索
			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);
			int numberPerPage = 100;
			int pageNow = 1, pageSize = 10;
			//ScoreDoc[] docs = pageSearch1(query, searcher, pageNow, pageSize);
			//ScoreDoc[] docs = pageSearch2(query, searcher, pageNow, pageSize);
			ScoreDoc[] docs = searcher.search(query, numberPerPage).scoreDocs;
			// 5、显示查询结果
			showSearchResult(searcher, docs, query, analyzer);
			// 6、关闭查询
			reader.close();
		}
	}

	private static void showSearchResult(IndexSearcher searcher, ScoreDoc[] docs, Query query, IKAnalyzer analyzer) throws Exception {
		System.out.println("找到 " + docs.length + " 个命中");
		System.out.println("序号\t匹配度得分\t结果");

		for (int i = 0; i < docs.length; i++) {
			ScoreDoc doc = docs[i];
			int docId = doc.doc;
			Document document = searcher.doc(docId);
			List<IndexableField> fields = document.getFields();
			System.out.print(i + 1);
			System.out.print("\t" + doc.score);
			for (IndexableField field : fields) {
				System.out.print("\t" + document.get(field.name()));
			}
			System.out.println();
		}
	}

	/**
	 * 创建索引
	 *
	 * @param analyzer
	 * @return
	 * @throws Exception
	 */
	private static Directory createIndex(IKAnalyzer analyzer) throws Exception {
		// 内存索引
		Directory index = new RAMDirectory();
		// 配置对象
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		// 索引
		IndexWriter writer = new IndexWriter(index, config);
		String fileName = "E:\\malf\\how2jStudy\\middleware\\src\\searchEngine\\lucene\\140k_products.txt";
		List<Product> products = ProductUtil.fileToList(fileName);
		int total = products.size();
		int count = 0, per = 0, oldPer = 0;
		for (Product product : products) {
			addDoc(writer, product);
			count++;
			per = count * 100 / total;
			if (per != oldPer) {
				oldPer = per;
				System.out.printf("索引中，总共要添加%d条记录，当前添加进度为%d%%%n", total, per);
			}
		}
		writer.close();
		return index;
	}

	private static void addDoc(IndexWriter writer, Product product) throws Exception {
		Document document = new Document();
		document.add(new TextField("id", String.valueOf(product.getId()), Field.Store.YES));
		document.add(new TextField("name", product.getName(), Field.Store.YES));
		document.add(new TextField("category", product.getCategory(), Field.Store.YES));
		document.add(new TextField("price", String.valueOf(product.getPrice()), Field.Store.YES));
		document.add(new TextField("place", product.getPlace(), Field.Store.YES));
		document.add(new TextField("code", product.getCode(), Field.Store.YES));
		writer.addDocument(document);
	}

	/**
	 * 分页查询(方式1)
	 *
	 * @param query
	 * @param searcher
	 * @param pageNow
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	private static ScoreDoc[] pageSearch1(Query query, IndexSearcher searcher, int pageNow, int pageSize) throws IOException {
		TopDocs topDocs = searcher.search(query, pageNow * pageSize);
		System.out.printf("查询到总条数：" + topDocs.totalHits);
		ScoreDoc[] docs = topDocs.scoreDocs;
		List<ScoreDoc> scoreDocs = new ArrayList<>();
		int start = (pageNow - 1) * pageSize;
		int end = pageSize * pageNow;
		for (int i = start; i < end; i++) {
			scoreDocs.add(docs[i]);
		}
		return scoreDocs.toArray(new ScoreDoc[]{});
	}

	/**
	 * 分页查询(方式2)
	 * @param query
	 * @param searcher
	 * @param pageNow
	 * @param pageSize
	 * @return
	 * @throws IOException
	 */
	private static ScoreDoc[] pageSearch2(Query query, IndexSearcher searcher, int pageNow, int pageSize) throws IOException {
		int start = (pageNow - 1) * pageSize;
		if (0 == start) {
			TopDocs topDocs = searcher.search(query, pageNow * pageSize);
			return topDocs.scoreDocs;
		}
		// 查询数据，结束页面以前的数据都会查到，但只取本页的数据
		TopDocs topDocs = searcher.search(query, start);
		// 获取到上一页最后一条
		ScoreDoc preScore = topDocs.scoreDocs[start - 1];
		// 查询最后一条后一页的数据
		topDocs = searcher.searchAfter(preScore, query, pageSize);
		return topDocs.scoreDocs;
	}
}

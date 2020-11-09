package searchEngine;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/9
 */
public class ProductUtil {
	public static void main(String[] args) throws IOException {
		String fileName = "E:\\malf\\how2jStudy\\middleware\\src\\searchEngine\\140k_products.txt";
		List<Product> products = fileToList(fileName);
		System.out.println(products.size());
	}

	public static List<Product> fileToList(String fileName) throws IOException {
		File file = new File(fileName);
		List<String> lines = FileUtils.readLines(file, "UTF-8");
		List<Product> products = new ArrayList<>();
		for (String line : lines) {
			Product product = lineToProduct(line);
			products.add(product);
		}
		return products;
	}

	private static Product lineToProduct(String line) {
		Product product = new Product();
		String[] fields = line.split(",");
		product.setId(Integer.parseInt(fields[0]));
		product.setName(fields[1]);
		product.setCategory(fields[2]);
		product.setPrice(Float.parseFloat(fields[3]));
		product.setPlace(fields[4]);
		product.setCode(fields[5]);
		return product;
	}
}

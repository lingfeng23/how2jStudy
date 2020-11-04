package service;

import dao.CategoryDao;
import dao.RecordDao;
import entity.Category;
import entity.Record;

import java.util.Collections;
import java.util.List;

/**
 * @author malf
 * @description 分类业务类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CategoryService {
	CategoryDao categoryDao = new CategoryDao();
	RecordDao recordDao = new RecordDao();

	public List<Category> list() {
		List<Category> categories = categoryDao.list();
		for (Category category : categories) {
			List<Record> rs = recordDao.list(category.id);
			category.recordNumber = rs.size();
		}
		Collections.sort(categories, (c1, c2) -> c2.recordNumber - c1.recordNumber);

		return categories;
	}

	public void add(String name) {
		Category category = new Category();
		category.setName(name);
		categoryDao.add(category);
	}

	public void update(int id, String name) {
		Category category = new Category();
		category.setName(name);
		category.setId(id);
		categoryDao.update(category);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}
}

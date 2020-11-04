package service;

import dao.ConfigDao;
import entity.Config;

/**
 * @author malf
 * @description 设置业务类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class ConfigService {
	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	public static final String default_budget = "500";

	static ConfigDao configDao = new ConfigDao();

	static {
		init();
	}

	public static void init() {
		init(budget, default_budget);
		init(mysqlPath, "");
	}

	private static void init(String key, String value) {
		Config config = configDao.getByKey(key);
		if (null == config) {
			config = new Config();
			config.setKey(key);
			config.setValue(value);
			configDao.add(config);
		}
	}

	public String get(String key) {
		Config config = configDao.getByKey(key);
		return config.getValue();
	}

	public void update(String key, String value){
		Config config = configDao.getByKey(key);
		config.setValue(value);
		configDao.update(config);
	}

	public int getIntBudget() {
		return Integer.parseInt(get(budget));
	}
}

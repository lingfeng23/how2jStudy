package entity;

/**
 * @author malf
 * @description 配置信息类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class Config {
	public int id;
	public String key;
	public String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

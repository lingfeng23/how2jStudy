package entity;

/**
 * @author malf
 * @description 消费分类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class Category {
	public int id;
	public String name;
	public int recordNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	@Override
	public String toString() {
		return name;
	}
}

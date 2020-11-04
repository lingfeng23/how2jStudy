package panel;

import entity.Category;
import listener.RecordListener;
import model.CategoryComboBoxModel;
import org.jdesktop.swingx.JXDatePicker;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @author malf
 * @description 记一笔面板类
 * @project how2jStudy
 * @since 2020/11/2
 */
public class RecordPanel extends WorkingPanel {
	static {
		GUIUtil.useLNF();
	}

	public static RecordPanel instance = new RecordPanel();

	JLabel spend = new JLabel("花费(￥)");
	JLabel category = new JLabel("分类");
	JLabel comment = new JLabel("备注");
	JLabel date = new JLabel("日期");

	public JTextField textSpend = new JTextField("0");
	public CategoryComboBoxModel boxModel = new CategoryComboBoxModel();
	public JComboBox<Category> boxCategory = new JComboBox<>(boxModel);
	public JTextField textComment = new JTextField();
	public JXDatePicker datePicker = new JXDatePicker(new Date());
	JButton submit = new JButton("记一笔");

	public RecordPanel() {
		GUIUtil.setColor(ColorUtil.GRAY, spend, category, comment, date);
		GUIUtil.setColor(ColorUtil.BLUE, submit);
		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 2, gap, gap));

		pInput.add(spend);
		pInput.add(textSpend);
		pInput.add(category);
		pInput.add(boxCategory);
		pInput.add(comment);
		pInput.add(textComment);
		pInput.add(date);
		pInput.add(datePicker);
		pSubmit.add(submit);

		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		this.add(pSubmit, BorderLayout.CENTER);

		addListener();
	}

	public Category getSelectedCategory() {
		return (Category) boxCategory.getSelectedItem();
	}

	@Override
	public void updateData() {
		boxModel.categories = new CategoryService().list();
		boxCategory.updateUI();
		resetInput();
		textSpend.grabFocus();
	}

	public void resetInput() {
		textSpend.setText("0");
		textComment.setText("");
		if (0 != boxModel.categories.size())
			boxCategory.setSelectedIndex(0);
		datePicker.setDate(new Date());
	}

	@Override
	public void addListener() {
		RecordListener listener = new RecordListener();
		submit.addActionListener(listener);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(RecordPanel.instance);
	}
}

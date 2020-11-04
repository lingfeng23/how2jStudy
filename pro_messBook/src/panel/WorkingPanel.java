package panel;

import javax.swing.*;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/11/2
 */
public abstract class WorkingPanel extends JPanel {
	public abstract void updateData();
	public abstract void addListener();
}

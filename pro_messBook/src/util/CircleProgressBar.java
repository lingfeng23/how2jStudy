package util;

import javax.swing.*;
import java.awt.*;

/**
 * @author malf
 * @description 环形进度条
 * @project how2jStudy
 * @since 2020/11/2
 */
public class CircleProgressBar extends JPanel {
	private int minProcess;
	private int maxProcess;
	private int process;

	private String processText;
	private Color backgroundColor;
	private Color foregroundColor;

	public CircleProgressBar() {
		minProcess = 0;
		maxProcess = 100;
		processText = "0%";
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);
		Graphics2D graphics2D = (Graphics2D) graphics;
		// 开启抗锯齿
		graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int x = 0, y = 0;
		int width = 0, height = 0;
		int fontSize = 0;
		if (getWidth() >= getHeight()) {
			x = (getWidth() - getHeight()) / 2 + 25;
			y = 25;
			width = getHeight() - 50;
			height = getHeight() - 50;
			fontSize = getWidth() / 8;
		} else {
			x = 25;
			y = (getHeight() - getWidth()) / 2 + 25;
			width = getWidth() - 50;
			height = getHeight() - 50;
			fontSize = getHeight() / 8;
		}
		graphics2D.setStroke(new BasicStroke(20.0f));
		graphics2D.setColor(backgroundColor);
		graphics2D.drawArc(x, y, width, height, 0, 360);
		graphics2D.setColor(foregroundColor);
		graphics2D.drawArc(x, y, width, height, 90, -(int) (360 * ((process * 1.0) / (maxProcess - minProcess))));
		graphics2D.setFont(new Font("黑体", Font.BOLD, fontSize));
		FontMetrics fontMetrics = graphics2D.getFontMetrics();
		int digitalWidth = fontMetrics.stringWidth(processText);
		int digitalAscent = fontMetrics.getAscent();
		graphics2D.setColor(foregroundColor);
		graphics2D.drawString(processText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		if (process >= minProcess && process <= maxProcess) {
			this.process = process;
		}
		if (process > maxProcess) {
			this.process = maxProcess;
		}
		this.processText = String.valueOf(process + "%");
		this.repaint();
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.repaint();
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
		this.repaint();
	}
}

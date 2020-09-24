package qrcode;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author malf
 * @description TODO
 * @project how2jStudy
 * @since 2020/9/24
 */
public class QRCodeUtil {
	/**
	 * 二维码加密
	 * @param encodeData
	 * @param destFile
	 * @throws IOException
	 */
	public static void qrCodeEncode(String encodeData, File destFile) throws IOException {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M');	// 纠错级别（L 7%、M 15%、Q 25%、H 30%），和版本有关
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(7);    // 设置 Qrcode 包的版本

		byte[] data = encodeData.getBytes("GBK");    // 字符集
		BufferedImage bufferedImage = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = bufferedImage.createGraphics();    // 创建图层

		graphics2D.setBackground(Color.WHITE);    // 设置背景颜色（白色）
		graphics2D.clearRect(0, 0, 139, 139);    // 矩形 x、y、width、height
		graphics2D.setColor(Color.BLACK);    // 设置图像颜色（黑色）

		if (data.length > 0 && data.length < 123) {
			boolean[][] flag = qrcode.calQrcode(data);
			for (int i = 0; i < flag.length; i++) {
				for (int j = 0; j < flag.length; j++) {
					if (flag[j][i]) {
						graphics2D.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
					}
				}
			}
		}
		graphics2D.dispose();    // 释放此图形的上下文以及它使用的所有系统资源。调用 dispose 之后，就不能再使用 Graphics 对象
		bufferedImage.flush();    // 刷新此 Image 对象正在使用的所有可重构的资源
		ImageIO.write(bufferedImage, "png", destFile);
		// System.out.println("Input Encoded data is：" + encodeData);
	}

	/**
	 * 解析二维码，返回解析内容
	 *
	 * @param imageFile
	 * @return
	 */
	public static String qrCodeDecode(File imageFile) {
		String decodeData = null;
		QRCodeDecoder decoder = new QRCodeDecoder();
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		try {
			decodeData = new String(decoder.decode((QRCodeImage) new J2SEImage(image)), "GBK");
			// System.out.println("Output Decoded Data is：" + decodeData);
		} catch (DecodingFailedException dfe) {
			System.out.println("Error: " + dfe.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodeData;
	}

	static class J2SEImage implements QRCodeImage {
		BufferedImage image;
		public J2SEImage(BufferedImage image) {
			this.image = image;
		}
		public int getWidth() {
			return image.getWidth();
		}
		public int getHeight() {
			return image.getHeight();
		}
		public int getPixel(int x, int y) {
			return image.getRGB(x, y);
		}
	}

	public static void main(String[] args) {
		String filePath = "D:/qrcode.png";
		File qrFile = new File(filePath);

		// 二维码内容
		String encodedata = "http://how2j.cn";
		try {
			QRCodeUtil.qrCodeEncode(encodedata, qrFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 解码
		String reText = QRCodeUtil.qrCodeDecode(qrFile);
		System.out.println(reText);
	}
}

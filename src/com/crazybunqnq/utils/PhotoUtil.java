package com.crazybunqnq.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.crazybunqnq.entity.ImgStringSetting;
import com.crazybunqnq.enums.Images;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PhotoUtil {
	public static String exportImg(String oldImgPath, String input, ImgStringSetting strSetting) {
		return exportImg(oldImgPath, input, strSetting, null, 0, 0);
	}

	public static String exportImg(String oldImgPath, String headImg, int imgX, int imgY) {
		return exportImg(oldImgPath, headImg, imgX, imgY);
	}

	public static void exportImg1() {
		int width = 100;
		int height = 100;
		String s = "你好";

		File file = new File("d:/image.jpg");

		Font font = new Font("Serif", Font.BOLD, 10);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(Color.RED);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(s, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;

		g2.drawString(s, (int) x, (int) baseY);

		try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String exportImg(String oldImgPath, String input, ImgStringSetting strSetting, String headImg, int imgX, int imgY) {
		try {
			InputStream is = new FileInputStream(oldImgPath);// "d:/原图.jpg"
			// 通过JPEG图象流创建JPEG数据流解码器
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			// 解码当前JPEG数据流，返回BufferedImage对象
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			// 得到画笔对象
			Graphics g = buffImg.getGraphics();

			if (headImg != null) {
				// 创建你要附加的图象。
				// 小图片的路径
				ImageIcon imgIcon = new ImageIcon(headImg);
				// 得到Image对象。
				Image img = imgIcon.getImage();
				// 将小图片绘到大图片上。
				// 5,300 .表示你的小图片在大图片上的位置。
				g.drawImage(img, 400, 15, null);
			}
			if (strSetting != null) {
				// 设置颜色。
				g.setColor(strSetting.getColor());
				// 最后一个参数用来设置字体的大小
				// Font f = new Font("宋体", Font.PLAIN, 25);
				// Color mycolor = Color.red;// new Color(0, 0, 255);
				g.setFont(strSetting.getF());
				// 10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
				g.drawString(input, strSetting.getX(), strSetting.getY());
			}
			g.dispose();
			OutputStream os;
			String shareFileName = "e:/NR/" + System.currentTimeMillis() + ".jpg";
			os = new FileOutputStream(shareFileName);
			// 创键编码器，用于编码内存中的图象数据。
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			is.close();
			os.close();
			return shareFileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (ImageFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String exportImg(String oldImgPath, String[] userInputs, Images images, boolean hasLogo) {
		try {
			InputStream is = new FileInputStream(oldImgPath);// "d:/原图.jpg"
			JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
			BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
			Graphics g = buffImg.getGraphics();

			if (userInputs == null || images == null) {
				return null;
			}
			for (int i = 0; i < images.getStrCount(); i++) {
				switch (i) {
				case 0:
					g.setColor(images.getFirstSetting().getColor());
					g.setFont(images.getFirstSetting().getF());
					g.drawString(userInputs[i], images.getFirstSetting().getX(), images.getFirstSetting().getY());
					break;
				case 1:
					g.setColor(images.getSecondSetting().getColor());
					g.setFont(images.getSecondSetting().getF());
					g.drawString(userInputs[i], images.getSecondSetting().getX(), images.getSecondSetting().getY());
					break;
				case 2:
					g.setColor(images.getThirdSetting().getColor());
					g.setFont(images.getThirdSetting().getF());
					g.drawString(userInputs[i], images.getThirdSetting().getX(), images.getThirdSetting().getY());
					break;
				default:
					break;
				}
			}
			
			if (hasLogo) {
				// 创建你要附加的图象。
				// 小图片的路径
				ImageIcon imgIcon = new ImageIcon("e:/包包专用图标/微信红包.png");
				// 得到Image对象。
				Image img = imgIcon.getImage();
				// 将小图片绘到大图片上。
				// 5,300 .表示你的小图片在大图片上的位置。
				g.drawImage(img, buffImg.getWidth() - 265, buffImg.getHeight() - 265, null);
			}

			g.dispose();
			OutputStream os;
			
			String shareFileName = images.toString() + System.currentTimeMillis() + ".jpg";
			String shareFilePath = "E:/MyPrograms/Eclipse/AjaxTest/WebContent/MyPages/" + shareFileName;
			os = new FileOutputStream(shareFilePath);
			JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
			en.encode(buffImg);
			is.close();
			os.close();
//			return shareFilePath;
			return shareFileName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (ImageFormatException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		String[] strs = {"包俊杰", "河畔", "何畔", "逗比"};
		String path = "e:/NR/" + Images.Test.getImgName() + ".jpg";
		String[] userInputs = new String[Images.Test.getStrCount()];
		for (int i = 0; i < userInputs.length; i++) {
			userInputs[i] = strs[i];
		}
		System.out.println(exportImg(path, userInputs, Images.Test, true));
	}
}
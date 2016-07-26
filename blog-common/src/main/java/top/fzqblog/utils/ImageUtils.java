package top.fzqblog.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtils {

	public static String createThumbnail(String topicImage, boolean isFullPath) {

		StringBuilder topicImageSmall = new StringBuilder();
		if (!StringUtils.isEmpty(topicImage)) {
			String realPath = ServerUtils.getRealPath();
			String[] topicImaes = topicImage.split("\\|");
			int smallCount = topicImaes.length;
			if (smallCount > Constants.MAX_FILE_NUM) {
				smallCount = Constants.MAX_FILE_NUM;
			}
			for (int i = 0; i < smallCount; i++) {
				String img = topicImaes[i];
				if (isFullPath) {
					img = img.substring(img.indexOf("upload"));
				}
				String sourcePath = realPath + "/upload/" + img;
				String smallSavePath = sourcePath + "_s.jpg";
				String smallPath = img + "_s.jpg";
				try {
					BufferedImage src = ImageIO.read(new File(sourcePath));
					if (src.getWidth() <= Constants.SMALL_IMAGE_WIDTH) {
						continue;
					}
//					Thumbnails
//							.of(sourcePath)
//							.size(Constants.SMALL_IMAGE_WIDTH,
//									Constants.SMALL_IMAGE_HEIGHT)
//							.toFile(smallSavePath); 
					CompressPic compressPic = new CompressPic(sourcePath, smallSavePath, Constants.SMALL_IMAGE_WIDTH, Constants.SMALL_IMAGE_HEIGHT);
					// 缩放图片
					compressPic.compressPic();
				} catch (Exception e) {
					
				}
				topicImageSmall.append(smallPath).append("|");
			}

		}
		return topicImageSmall.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(createThumbnail("201607/1.jpg",
				false));
	}
}

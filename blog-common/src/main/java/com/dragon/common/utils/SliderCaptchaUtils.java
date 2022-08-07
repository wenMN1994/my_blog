package com.dragon.common.utils;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Random;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-06
 * @description：滑块拼图验证码工具类
 * @modifiedBy：
 * @version:
 */
@Slf4j
public class SliderCaptchaUtils {
    /**
     * 小图长
     */
    private static int targetWidth = 55;

    /**
     * 小图宽
     */
    private static int targetHeight = 45;

    /**
     * 半径
     */
    private static int circleR = 8;

    /**
     * 距离点
     */
    private static int r1 = 4;

    /**
     * 读取图片，生成拼图验证码
     * @param file 本地图片
     * @param imgUrl 网络图片
     * @param resultMap 返回生成的抠图和带抠图阴影的大图 base64码及抠图坐标
     * @return
     */
    public static Map<String,Object> createImage(File file, String imgUrl, Map<String,Object> resultMap){
        try {
            BufferedImage bufferedImage = null;
            if(file != null){
                bufferedImage = ImageIO.read(file);
            }else if(StringUtils.isNotEmpty(imgUrl)){
                //通过URL 读取图片
                URL url = new URL(imgUrl);
                bufferedImage = ImageIO.read(url.openStream());
            }else {
                throw new RuntimeException("请输入图片来源");
            }
            Random rand = new Random();
            int widthRandom = rand.nextInt(bufferedImage.getWidth()-  targetWidth - 100 + 1 ) + 100;
            int heightRandom = rand.nextInt(bufferedImage.getHeight()- targetHeight + 1 );
            BufferedImage target= new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR);
            log.info("大图大小{} x {},随机生成的坐标 X,Y 为（{}，{}）",bufferedImage.getWidth(), bufferedImage.getHeight(), widthRandom,heightRandom);
            cutByTemplate(bufferedImage,target,getBlockData(),widthRandom,heightRandom);
            // 大图
            resultMap.put("bigImage", getImageBASE64(bufferedImage));
            // 小图
            resultMap.put("smallImage", getImageBASE64(target));
            // 大图宽度
            resultMap.put("bWidth", bufferedImage.getWidth());
            // 大图高度
            resultMap.put("bHeight", bufferedImage.getHeight());
            resultMap.put("xWidth", widthRandom);
            resultMap.put("yHeight", heightRandom);
        } catch (Exception e) {
            log.info("创建图形验证码异常",e);
        } finally {
            return resultMap;
        }
    }

    /**
     *
     * 有这个轮廓后就可以依据这个二维数组的值来判定抠图并在原图上抠图位置处加阴影,
     * @param oriImage  原图
     * @param targetImage  抠图拼图
     * @param templateImage 颜色
     * @param x
     * @param y
     * @throws
     */
    private static void cutByTemplate(BufferedImage oriImage, BufferedImage targetImage, int[][] templateImage, int x, int y){
        int[][] martrix = new int[3][3];
        int[] values = new int[9];
        //创建shape区域
        for (int i = 0; i < targetWidth; i++) {
            for (int j = 0; j < targetHeight; j++) {
                int rgb = templateImage[i][j];
                // 原图中对应位置变色处理
                int rgb_ori = oriImage.getRGB(x + i, y + j);
                if (rgb == 1) {
                    targetImage.setRGB(i, j, rgb_ori);
                    //抠图区域高斯模糊
                    readPixel(oriImage, x + i, y + j, values);
                    fillMatrix(martrix, values);
                    oriImage.setRGB(x + i, y + j, avgMatrix(martrix));
                }else{
                    //这里把背景设为透明
                    targetImage.setRGB(i, j, rgb_ori & 0x00ffffff);
                }
            }
        }
    }

    private static void readPixel(BufferedImage img, int x, int y, int[] pixels) {
        int xStart = x - 1;
        int yStart = y - 1;
        int current = 0;
        for (int i = xStart; i < 3 + xStart; i++) {
            for (int j = yStart; j < 3 + yStart; j++) {
                int tx = i;
                if (tx < 0) {
                    tx = -tx;
                } else if (tx >= img.getWidth()) {
                    tx = x;
                }
                int ty = j;
                if (ty < 0) {
                    ty = -ty;
                } else if (ty >= img.getHeight()) {
                    ty = y;
                }
                pixels[current++] = img.getRGB(tx, ty);
            }
        }
    }

    private static void fillMatrix(int[][] matrix, int[] values) {
        int filled = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] x = matrix[i];
            for (int j = 0; j < x.length; j++) {
                x[j] = values[filled++];
            }
        }
    }

    private static int avgMatrix(int[][] matrix) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] x = matrix[i];
            for (int j = 0; j < x.length; j++) {
                if (j == 1) {
                    continue;
                }
                Color c = new Color(x[j]);
                r += c.getRed();
                g += c.getGreen();
                b += c.getBlue();
            }
        }
        return new Color(r / 8, g / 8, b / 8).getRGB();
    }

    /**
     * 生成小图轮廓
     * @return int[][]
     * @throws
     */
    private static int[][] getBlockData() {
        int[][] data = new int[targetWidth][targetHeight];
        double x2 = targetWidth -circleR;
        //随机生成圆的位置
        double h1 = circleR + Math.random() * (targetWidth-3*circleR-r1);
        double po = Math.pow(circleR,2);
        double xBegin = targetWidth - circleR - r1;
        double yBegin = targetHeight- circleR - r1;
        //圆的标准方程 (x-a)²+(y-b)²=r²,标识圆心（a,b）,半径为r的圆
        //计算需要的小图轮廓，用二维数组来表示，二维数组有两张值，0和1，其中0表示没有颜色，1有颜色
        for (int i = 0; i < targetWidth; i++) {
            for (int j = 0; j < targetHeight; j++) {
                double d2 = Math.pow(j - 2,2) + Math.pow(i - h1,2);
                double d3 = Math.pow(i - x2,2) + Math.pow(j - h1,2);
                if ((j <= yBegin && d2 < po) || (i >= xBegin && d3 > po)) {
                    data[i][j] = 0;
                }  else {
                    data[i][j] = 1;
                }
            }
        }
        return data;
    }

    /**
     * 图片转BASE64
     * @param image
     * @return
     * @throws IOException String
     */
    public static String getImageBASE64(BufferedImage image) throws IOException {
        byte[] imageData = null;
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(image,"png", bao);
        imageData = bao.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        String BASE64IMAGE = encoder.encodeBuffer(imageData).trim();
        // 删除 \r\n
        BASE64IMAGE = BASE64IMAGE.replaceAll("\r|\n", "");
        return "data:image/png;base64," + BASE64IMAGE;
    }
}

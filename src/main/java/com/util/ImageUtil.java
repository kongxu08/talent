package com.util;

import com.cjwsjy.talents.controller.Sm_userController;
import net.coobird.thumbnailator.Thumbnails;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUtil {
    /**
     * 将网络图片进行Base64位编码
     *
     * @param imageUrl
     *            图片的url路径，如http://.....xx.jpg
     * @return
     */
    public static String encodeImgageToBase64(URL imageUrl) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageUrl);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
    }

    /**
     * 将本地图片进行Base64位编码
     *
     * @param imageFile
     *            图片的url路径，如http://.....xx.jpg
     * @return
     */
    public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        ByteArrayOutputStream outputStream = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", outputStream);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串
    }

    /**
     * 将Base64位编码的图片进行解码，并保存到指定目录
     *
     * @param base64
     *            base64编码的图片信息
     * @return
     */
    public static void decodeBase64ToImage(String base64, String path, String imgName) {
        if (base64.indexOf("data:image/png;base64,") != -1) {
            base64 = base64.substring("data:image/png;base64,".length());
        }
        if (base64.indexOf("data:image/jpg;base64,") != -1) {
            base64 = base64.substring("data:image/jpg;base64,".length());
        }
        if (base64.indexOf("data:image/jpeg;base64,") != -1) {
            base64 = base64.substring("data:image/jpeg;base64,".length());
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            FileOutputStream write = new FileOutputStream(new File(path
                    + imgName));
            byte[] decoderBytes = decoder.decodeBuffer(base64);
            write.write(decoderBytes);
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //localhost:
    public static void compressionByWidth(String inUrl,String outPath,int maxWidth ){
        URL url = null;
        try {
            url = new URL(inUrl);
            BufferedImage read = ImageIO.read(url);
            int outWidth = 80;
            if(read.getWidth()>outWidth){
                double scale = (double)outWidth/read.getWidth();
                Thumbnails.of(url).scale(scale).toFile(outPath);
            }else{
                Thumbnails.of(url).scale(1).toFile(outPath);
            }
        } catch (IOException e) {
            LogUtil.printLog(e, Sm_userController.class);
        }
    }


}

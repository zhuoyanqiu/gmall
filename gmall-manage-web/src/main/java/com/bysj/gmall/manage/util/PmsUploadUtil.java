package com.bysj.gmall.manage.util;

import com.bysj.gmall.bean.Constant;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 卓炎秋
 */
public class PmsUploadUtil {


    public static String uploadImage(MultipartFile multipartFile) {

        String imgUrl =  Constant.REMOTE_SERVER_IP;

        //上传图片到服务器
        //配置fdfs的全局连接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();

        //获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //通过tracker获取一个storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);

        try {
            byte[] bytes = multipartFile.getBytes();
            //获得文件名称
            String originalFilename = multipartFile.getOriginalFilename();

            //获取文件后缀名
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);

            //上传图片到服务器，获取图片存储路径
            String[] uploadInfos = storageClient.upload_file(bytes,extName,null);

            for (String uploadInfo : uploadInfos) {
                imgUrl +="/"+uploadInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}

package com.control;

import com.service.Goods_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class File_control {

    @Autowired
    private Goods_service goods_service;

    private static String UPLOADED_FOLDER = "C:\\Users\\小酸\\Desktop\\图书图片\\";
    private static String VIEW_IMAGE_FOLDER1 = "D:\\MyFile\\FANFAN\\资料\\Server\\src\\main\\resources\\static\\images\\goods\\";
    private static String VIEW_IMAGE_FOLDER2 = "D:\\MyFile\\FANFAN\\资料\\Client\\src\\main\\resources\\static\\images\\goods\\";
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
        System.out.println("###############################");
        String goods_id=request.getParameter("goods_id");
        System.out.println("goods_id : "+goods_id);

        String file_type=request.getParameter("file_type");
        System.out.println("file_type : "+file_type);
        System.out.println("###############################");
        if (true){
            return "收到";
        }
        if (file.isEmpty())
        {
            return "请选择文件后再上传";
        }

        try
        {
            byte[] bytes = file.getBytes();
            Path dir = Paths.get(UPLOADED_FOLDER);
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            if (!Files.exists(dir))
            {
                Files.createDirectories(dir);
            }
            Files.write(path, bytes);
            return "上传成功";
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "服务器异常";
        }
    }

    @PostMapping("/upload_view_image")
    public String upload_view_image(@RequestParam("file") MultipartFile file, HttpServletRequest request)
    {
//        String UPLOADED_FOLDER="D:\\Data\\IDEA\\Server\\src\\main\\resources\\static\\images\\goods";
        String goods_id=request.getParameter("goods_id");
        System.out.println("goods_id : "+goods_id);
        System.out.println("上传首页图片 goods_id = "+goods_id);
        if (file.isEmpty())
        {
            return "请选择文件后再上传";
        }
        try
        {
            String OriginalFilename = file.getOriginalFilename();//获取原文件名
            String file_suffix = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
            String file_name="book"+goods_id+file_suffix;
            byte[] bytes = file.getBytes();
            Path dir = Paths.get(VIEW_IMAGE_FOLDER1);
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            String file_path="./images/goods/" + file_name;
            Path path = Paths.get(VIEW_IMAGE_FOLDER1 + file_name);
            if (!Files.exists(dir))
            {
                Files.createDirectories(dir);
            }
            Files.write(path, bytes);

            dir = Paths.get(VIEW_IMAGE_FOLDER2);
//            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//            String file_path="./images/goods/" + file_name;
            path = Paths.get(VIEW_IMAGE_FOLDER2 + file_name);
            if (!Files.exists(dir))
            {
                Files.createDirectories(dir);
            }
            Files.write(path, bytes);

            //将信息写入数据库
            goods_service.set_goods_view(goods_id,file_path);
            return "上传成功";
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "服务器异常";
        }
    }
}

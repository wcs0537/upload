package com.asong;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
public class FileUpload {
    @RequestMapping("/upload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");
        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(realPath);
        if (!file.exists()) {
            //不存在创建文件夹
            file.mkdirs();
        }

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        //解析request对象，获取上传文件项，
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                //普通表单
            } else {
                String fileItemName= fileItem.getName();
                int index=fileItemName.lastIndexOf("\\");
                if(index!=-1) {
                    fileItemName=fileItemName.substring(index+1);
                }
                fileItem.write(new File(realPath,fileItemName));
                fileItem.delete();
                System.out.println(11111);
            }

        }
        return "success";
    }
}

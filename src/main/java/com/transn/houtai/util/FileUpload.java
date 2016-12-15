package com.transn.houtai.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by xuxiaohe on 2016/12/15.
 */
public class FileUpload {

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String path=request.getSession().getServletContext().getRealPath("images/");
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return "images/" + tempFile.getName();
    }

}

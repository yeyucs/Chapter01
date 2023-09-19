package cn.lzy.web.file;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author:韦盛彪
 * @creat: 2023-09-19  09:30
 */

@Controller
public class FileController {
    @GetMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        boolean statue = true;
        String message = null;

        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename();

            fileName = UUID.randomUUID() + "_" + fileName;

            String dirPath = "D:/temp/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                statue = false;
                message = e.getMessage() + "";
            }
        }
        if (statue) {
            model.addAttribute("uploadStatus", "上传成功!");
        } else {
            model.addAttribute("uploadStatus", "上传成功:" + message);
        }
        return "upload";
    }
}
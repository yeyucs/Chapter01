package cn.lzy.web.file;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.UUID;

import static com.alibaba.druid.wall.spi.WallVisitorUtils.getFirst;

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
    @GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }
   /* @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(String filename) {
        String dirPath = "D:/temp/";
        File file = new File(dirPath + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment","filename");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),HttpStatus.EXPECTATION_FAILED);
        }
    }*/

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename) throws Exception {
        String dirPath = "D:/temp/";
        File file = new File(dirPath + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        filename = getFilename(request, filename);
        headers.setContentDispositionFormData("attachment", "filename");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {

            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }
    }
        private String getFilename (HttpServletRequest request, String filename) throws Exception {
            String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
            String userAgent = request.getHeader("User-Agent");
            for (String keyWord : IEBrowserKeyWords) {
                if (userAgent.contains(keyWord)) {
                    return URLEncoder.encode(filename, "UTF-8").replace("+", "");
                }
            }
            return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        }
}
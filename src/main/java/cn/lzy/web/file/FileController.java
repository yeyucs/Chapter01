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
    public String toDownload() { return "download"; }

    /*@GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(String filename){
        //指定要下载的文件根目录
        String dirPath = "D:/temp/";
        //创建该文件对象
        File file = new File(dirPath + File.separator + filename);

        //设置响应头
        HttpHeaders headers = new HttpHeaders();

        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),HttpStatus.EXPECTATION_FAILED);
        }*/

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
        //指定要下载的文件根目录
        String dirPath = "D:/file/";
        //创建该文件对象
        File file = new File(dirPath + File.separator + filename);

        //设置响应头
        HttpHeaders headers = new HttpHeaders();
        filename=getFilename(request,filename);
        //通知游览器以下载方式打开
        headers.setContentDispositionFormData("attachment",filename);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),HttpStatus.EXPECTATION_FAILED);
        }
    }
    private String getFilename(HttpServletRequest request, String filename) throws Exception {
        //IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        //获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                //IE内核游览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename,"UTF-8").replace("+","");
            }
        }
        //火狐等其他游览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }
}

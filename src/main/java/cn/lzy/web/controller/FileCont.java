package cn.lzy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:韦盛彪
 * @creat: 2023-10-09  10:51
 */
@Controller
public class FileCont {
    //影片详情页
    @GetMapping("/detail/{type}/{path}")
    public String toDetail(@PathVariable("type")String type,
                           @PathVariable("path")String path) {
        return "detail/"+type+"/"+path;
    }
}

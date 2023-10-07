package cn.lzy.JpaCache;

import cn.lzy.mybatiscatalog.domainjpa.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:韦盛彪
 * @creat: 2023-09-25  17:01
 */
/*
@RestController
public class ArticleController {
    @Autowired
    private  ArticleService articleService;
    @GetMapping("/get/{id}")
    @Cacheable(cacheNames = "article")
    public Article findById(@PathVariable("id") int article_id) {
        Article article = articleService.findById(article_id);
        return article;
    }

}
*/

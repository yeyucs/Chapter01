package cn.lzy.Cache.jpacontroller;

/**
 * @author:韦盛彪
 * @creat: 2023-09-25  16:36
 **/

/*@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Cacheable(cacheNames = "article")
    public Article findById(int article_id){
        Optional <Article> optional = articleRepository.findById(article_id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
   *//* public Article updateArticle(Article article){
        articleRepository.updateArticle(article.getContent(),article.getId());
        return article;
    }
    public void deleteArticle(int article_id){
        articleRepository.deleteById(article_id);
    }*//*
}*/

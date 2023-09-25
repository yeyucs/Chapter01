package cn.lzy.mybatiscatalog.domainjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author:韦盛彪
 * @creat: 2023-09-25  16:28
 */
public interface ArticleRepository extends JpaRepository<Article,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE t_article c SET c.content= ?1 WHERE c.title = ?2 ")
    public int updateArticle(String author,Integer id);

}

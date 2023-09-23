package cn.lzy.mybatiscatalog;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    public Articele selectArticle(Integer id);
    public int updateArticle(Articele article);
}

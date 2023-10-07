package cn.lzy.mybatiscatalog.domainjpa;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author:韦盛彪
 * @creat: 2023-09-25  16:13
 */
@Entity(name = "t_article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private String title;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

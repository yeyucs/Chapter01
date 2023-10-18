package cn.lzy.RabbitMQ;

/**
 * @author:韦盛彪
 * @creat: 2023-10-18  12:16
 */
public class WeUser {
    public Integer id;

    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

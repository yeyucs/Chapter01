package cn.lzy.Security.Redis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author:韦盛彪
 * @creat: 2023-10-09  18:07
 */
@Entity(name = "t_customer_authority")
public class t_Customer_Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer customer_id;

    Integer authority_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getAuthority_id() {
        return authority_id;
    }

    public void setAuthority_id(Integer authority_id) {
        this.authority_id = authority_id;
    }

    @Override
    public String toString() {
        return "t_Customer_Authority{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", authority_id=" + authority_id +
                '}';
    }
}

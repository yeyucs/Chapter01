package cn.lzy.Security.Redis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author:韦盛彪
 * @creat: 2023-10-09  18:02
 */
public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
//    @Query(value = "select a.* from t_customer c,t_authority a,t_customer_authority ca where ca.customer_id=c.id and ca.authority_id=a.id and c.username=?");
}
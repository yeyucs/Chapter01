package cn.lzy.Security.Redis;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:韦盛彪
 * @creat: 2023-10-09  17:52
 */
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByUsername(String username);

    Customer findByPassword(String password);
}

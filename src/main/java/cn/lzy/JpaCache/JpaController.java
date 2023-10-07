package cn.lzy.JpaCache;

import cn.lzy.mybatiscatalog.jpa.Discuss;
import cn.lzy.mybatiscatalog.jpa.DiscussRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author:韦盛彪
 * @creat: 2023-09-26  10:58
 */
@RestController
public class JpaController {


        @Autowired
        private DiscussRepository repository;

        @Cacheable(cacheNames = "discuss",unless = "#result==null")
        public Discuss findById(@PathVariable("id") int comment_id) {
            Optional<Discuss> discuss = repository.findById(comment_id);
            if (discuss.isPresent()){
                return discuss.get();
            }
            return null;
        }
        @GetMapping("/update/{id}/{author}")
        @CachePut(cacheNames = "discuss",key = "#result.id")
        public Discuss updateDiscuss( Discuss discuss){
            repository.updateDiscuss(discuss.getAuthor(),discuss.getaId());
            return discuss;
        }
        @GetMapping("/delete/{id}")
        @CacheEvict(cacheNames = "discuss")
        public void deleteDiscuss(@PathVariable("id") int comment_id){
            repository.deleteDiscuss(comment_id);
        }
    }

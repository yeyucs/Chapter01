package cn.lzy.MyAsyncWeb;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author:韦盛彪
 * @creat: 2023-10-19  16:56
 */
@Service
public class MyAsyncService {
    @Async
    public Future<Integer> processA() throws Exception {
        System.out.println("开始计算从1-1000值的总和");
        Long startTimeA = System.currentTimeMillis();
        Thread.sleep(5000);
        int total=0;
        for (int i = 0;i <= 1000;i++){
            total=total+i;
        }
        System.out.println("从1-1000计算的值为:"+total);
        Long endTimeA = System.currentTimeMillis();
        System.out.println("从1-1000计算时长为"+(endTimeA - startTimeA));
        return new AsyncResult<Integer>(total);
    }
    @Async
    public Future<Integer> processB() throws Exception {
        System.out.println("开始计算从1000-2000值的总和");
        Long startTimeB = System.currentTimeMillis();
        Thread.sleep(5000);
        int total1=1000;
        for (int i = 0;i <= 2000;i++){
            total1=total1+i;
        }
        System.out.println("从1000-2000计算的值为:"+total1);
        Long endTimeB = System.currentTimeMillis();
        System.out.println("从1000-2000计算时长为"+(endTimeB - startTimeB));
        return new AsyncResult<Integer>(total1);
 }
}

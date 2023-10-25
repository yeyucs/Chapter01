package cn.lzy.taskmanagement.AsyncNotResult;

import cn.lzy.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author:韦盛彪
 * @creat: 2023-10-19  17:09
 */
@RestController
public class MyAsyncController {
    @Autowired
    public MyAsyncService myAsyncService;
    @GetMapping("/sendSMS")
    public String sendSMS() throws Exception {

        System.out.println("sendSMS方法开始的时间:"+DataUtils.getData(DataUtils.data1));
        Long startTimeA = System.currentTimeMillis();
        Future<Integer> futureA = myAsyncService.processA();
        Future<Integer> futureB = myAsyncService.processB();
//        Long endTimeA = System.currentTimeMillis();
//        System.out.println("主流程耗时:"+(endTimeA - startTimeA));
        int to = futureA.get() + futureB.get();
        Long startTime = System.currentTimeMillis();
        System.out.println("1-1000和1000-2000一起相加开始的时间:"+DataUtils.getData(DataUtils.data1));
        Long endTime = System.currentTimeMillis();
        System.out.println("数据统计汇总结果:" + to );
        System.out.println("1-1000和1000-2000一起相加结束的时间:"+DataUtils.getData(DataUtils.data1));
        System.out.println("异步主流程耗时:"+(endTime - startTime));


        /*Long startTime = System.currentTimeMillis();
        Future<Integer> futureA = myAsyncService.processA();
        Future<Integer> futureB = myAsyncService.processB();
        int to = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果:" + to);
        Long endTime = System.currentTimeMillis();
        System.out.println("主流程耗时:"+(endTime - startTime));*/
        return "success";

    }
}

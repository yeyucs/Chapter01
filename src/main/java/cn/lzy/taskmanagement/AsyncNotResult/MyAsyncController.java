package cn.lzy.taskmanagement.AsyncNotResult;

import cn.lzy.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        Long startTimeA = System.currentTimeMillis();
        Future<Integer> futureA = myAsyncService.processA();
        Future<Integer> futureB = myAsyncService.processB();
        Long endTimeA = System.currentTimeMillis();
        System.out.println("主流程耗时:"+(endTimeA - startTimeA));

        /*Long startTime = System.currentTimeMillis();*/
        int to = futureA.get() + futureB.get();
        System.out.println("异步任务数据统计汇总结果:" + to +"====="+ DataUtils.getData(DataUtils.data1));
        Long endTime = System.currentTimeMillis();
        System.out.println("异步主流程耗时:"+(endTime - startTimeA));


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

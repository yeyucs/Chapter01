package cn.lzy.taskmanagement.Scheduled;

import cn.lzy.utils.DataUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author:韦盛彪
 * @creat: 2023-10-21  16:18
 */
@Service
public class ScheduledService {

    /*@Scheduled(fixedRate = 10*1000)
    public void scheduledServiceRate1() throws  InterruptedException {
        System.out.println("scheduledServiceRate1====="+ DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);
    }
    @Scheduled(fixedRate = 1000)
    public void scheduledServiceRate2() throws InterruptedException {
        System.out.println("scheduledServiceRate2=====" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(15 * 1000);
    }*/
    /*@Scheduled(fixedDelay = 5*1000)
    public void scheduledServiceDelay1() throws InterruptedException {
        System.out.println("scheduledServiceDelay1=====" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);
    }*/
   /* @Scheduled(fixedDelay = 1)
    public void scheduledServiceDelay2() throws InterruptedException {
        System.out.println("scheduledServiceDelay2=====" + DataUtils.getData(DataUtils.data1));
        Thread.sleep(5000);
    }*/

    /*@Scheduled(initialDelay =10*1000 ,fixedRate = 10*1000)
    public void scheduledServiceinitialDelay1() throws  InterruptedException {
        System.out.println("scheduledServiceinitialDelay1====="+ DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);
    }
    @Scheduled(initialDelay =0 ,fixedRate = 1000)
    public void scheduledServiceinitialDelay2() throws  InterruptedException {
        System.out.println("scheduledServiceinitialDelay2====="+ DataUtils.getData(DataUtils.data1));
        Thread.sleep(5*1000);
    }*/
}



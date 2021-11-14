package x.x.xxlJobDemo;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 * 测试Handler
 *
 * @author LeDao
 * @company
 * @create 2021-11-03 10:18
 */
@Component
public class Test {

    /**
     * Bean模式，一个方法为一个任务
     * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
     * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
     * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
     */
    @XxlJob("demoJobHandler1")
    public ReturnT<String> demoJobHandler1(String param) throws Exception {
        System.out.println("java, Hello World~~~");
        XxlJobLogger.log("java, Hello World~~~");
        XxlJobLogger.log("param:" + param);
        return ReturnT.SUCCESS;
    }
}
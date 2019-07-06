package cn.wbw.httpbootrest.restart;

import cn.wbw.httpbootrest.ExampleRestartApplication;
import cn.wbw.httpbootrest.util.PropUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试重新启动项目
 *
 * @author wbw
 * @date 2019/7/6 10:57
 */
@RestController
public class RestartController {
    @Value("${spring.application.name}")
    String name;

    private static Logger logger = LoggerFactory.getLogger(RestartController.class);

    @RequestMapping("/refresh")
    public String restart() {
        logger.info("spring.application.name:\t{}", name);
        try {
            PropUtil instance = PropUtil.getProp("application.properties");
            instance.setProperty("spring.application.name", "SPRING-DYNAMIC-SERVER");
            logger.info("props:\t{}", instance.getValue("spring.application.name"));
        } catch (Exception e) {
            logger.error("error", e);
        }
        ExecutorService threadPool = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.DiscardOldestPolicy());
        threadPool.execute(() -> {
            ExampleRestartApplication.context.close();
            ExampleRestartApplication.context = SpringApplication.run(ExampleRestartApplication.class,
                    ExampleRestartApplication.args);
        });
        threadPool.shutdown();
        return "spring.application.name:" + name;
    }

    @RequestMapping("/info")
    public String info() {
        logger.info("spring.application.name:" + name);
        return name;
    }
}

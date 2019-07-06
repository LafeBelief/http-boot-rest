package cn.wbw.httpbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 启动程序
 *
 * @author wbw
 * @date 2019/7/6 12:55
 */
@SpringBootApplication
public class ExampleRestartApplication {


    public static String[] args;
    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        ExampleRestartApplication.args = args;
        ExampleRestartApplication.context = SpringApplication.run(ExampleRestartApplication.class, args);
    }

}

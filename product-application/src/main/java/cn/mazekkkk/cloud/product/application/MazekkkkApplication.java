package cn.mazekkkk.cloud.product.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author maze
 * @createTime 18/10/12
 */
@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@EnableJms
@ComponentScan(basePackages = {"cn.mazekkkk.cloud.product"})
public class MazekkkkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MazekkkkApplication.class,args);
    }

}

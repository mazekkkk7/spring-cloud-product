package cn.mazekkkk.cloud.product.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 *
 * @author maze
 * @createTime 18/10/12
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@EnableJms
@RefreshScope
@ComponentScan(basePackages = {"cn.mazekkkk.cloud.product"})
@MapperScan("cn.mazekkkk.cloud.product.dao.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.mazekkkk.cloud")
@EnableTransactionManagement
public class MazekkkkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MazekkkkApplication.class,args);
    }

}

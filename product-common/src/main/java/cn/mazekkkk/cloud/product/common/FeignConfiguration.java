package cn.mazekkkk.cloud.product.common;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 配置
 *
 * @author maze
 * @createTime 18/10/19
 */
@Configuration
public class FeignConfiguration {

    @Value("${security.user.name}")
    private String userName;

    @Value("${security.user.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(userName,password);
    }

}

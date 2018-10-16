package cn.mazekkkk.cloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest接口测试Controller
 *
 * @author maze
 * @createTime 18/10/15
 */
@RestController
@RefreshScope
@ResponseBody
public class RestTestController {

    @Value("${spring.datasource.username}")
    private String userName;

    /**
     * 测试配置用
     *
     * @return
     */
    @GetMapping("/userName")
    public String userName() {
        return this.userName;
    }
}

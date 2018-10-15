package cn.mazekkkk.cloud.product.controller;

import cn.mazekkkk.cloud.product.dao.common.SUser;
import cn.mazekkkk.cloud.product.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private UserService userService;

    /**
     * 测试配置用
     *
     * @return
     */
    @GetMapping("/userName")
    public String userName() {
        return this.userName;
    }

    @GetMapping("/user/{id}")
    public SUser getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}

package cn.mazekkkk.cloud.product.controller;

import cn.mazekkkk.cloud.product.dao.common.Product;
import cn.mazekkkk.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品接口
 *
 * @author maze
 * @createTime 18/10/16
 */
@RestController
@ResponseBody
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product/{id}")
    public Product selectByprimaryKey(@PathVariable("id") Integer id) throws Exception {
        return productService.selectByPrimaryKey(id);
    }

}

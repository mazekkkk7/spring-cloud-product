package cn.mazekkkk.cloud.product.controller;

import cn.mazekkkk.cloud.product.dao.common.Product;
import cn.mazekkkk.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

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

    /**
     * 根据主键获取产品
     *
     * @param id 产品主键
     * @return
     * @throws Exception
     */
    @PostMapping("/product/{id}")
    public Product selectByprimaryKey(@PathVariable("id") Integer id) throws Exception {
        return productService.selectByPrimaryKey(id);
    }

    /**
     * 根据会员id创建订单
     *
     * @param memberId 会员id
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/product/create_order/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean createOrderByMemberId(@PathVariable("id") @NotNull Integer memberId) throws RuntimeException {
        return productService.createOrder(memberId);
    }
}

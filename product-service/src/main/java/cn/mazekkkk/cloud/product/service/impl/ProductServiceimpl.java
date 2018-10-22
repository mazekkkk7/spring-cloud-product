package cn.mazekkkk.cloud.product.service.impl;

import cn.mazekkkk.cloud.order.feign.OrderFeignClient;
import cn.mazekkkk.cloud.order.service.command.CreateOrderCommand;
import cn.mazekkkk.cloud.product.dao.common.Product;
import cn.mazekkkk.cloud.product.dao.mapper.ProductMapper;
import cn.mazekkkk.cloud.product.service.ProductService;
import com.codingapi.tx.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品实现类
 *
 * @author maze
 * @createTime 18/10/16
 */
@Transactional
@Service("productService")
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderFeignClient orderFeignClient;

    /**
     * 根据主键查找产品
     *
     * @param id 产品id
     * @return
     */
    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * 创建订单 根据用户id
     *
     * @param memberId 用户id
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    @TxTransaction(isStart = true)
    @Override
    public Boolean createOrder(Integer memberId) {
        List<Product> productList = new ArrayList<>();
        Product product = productMapper.selectByPrimaryKey(1);
        product.setStatus(product.getStatus() + 1);
        productMapper.updateByPrimaryKeySelective(product);
        productList.add(product);
        CreateOrderCommand createOrderCommand = new CreateOrderCommand();
        createOrderCommand.setMemberId(memberId);
        createOrderCommand.setProductList(productList);
        Boolean result = orderFeignClient.createOrder(createOrderCommand);
        int x = 1 / 0;

        return result;
    }
}

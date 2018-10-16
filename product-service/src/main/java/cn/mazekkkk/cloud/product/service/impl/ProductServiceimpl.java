package cn.mazekkkk.cloud.product.service.impl;

import cn.mazekkkk.cloud.product.dao.common.Product;
import cn.mazekkkk.cloud.product.dao.mapper.ProductMapper;
import cn.mazekkkk.cloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 产品实现类
 *
 * @author maze
 * @createTime 18/10/16
 */
@Service("productService")
public class ProductServiceimpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

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
}

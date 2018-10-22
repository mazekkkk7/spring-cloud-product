package cn.mazekkkk.cloud.product.service;

import cn.mazekkkk.cloud.product.dao.common.Product;

/**
 * 产品服务
 *
 * @author maze
 * @createTime 18/10/16
 */
public interface ProductService {
    /**
     * 根据主键查找产品
     *
     * @param id 产品id
     * @return
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * 创建订单 根据用户id
     *
     * @param memberId 用户id
     * @return
     * @throws Exception
     */
    Boolean createOrder(Integer memberId);
}

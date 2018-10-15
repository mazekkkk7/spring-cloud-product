package cn.mazekkkk.cloud.product.service.feign;

import cn.mazekkkk.cloud.product.dao.common.SUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 订单接口
 *
 * @author maze
 * @createTime 18/10/15
 */
@FeignClient("spring-cloud-order")
public interface OrderFeign {

    /**
     * 新建订单数据
     *
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SUser insertOrder(@PathVariable("id") Long id);

}

package cn.mazekkkk.cloud.product.service;

import cn.mazekkkk.cloud.product.dao.common.SUser;

/**
 * 用户服务
 *
 * @author maze
 * @createTime 18/10/15
 */
public interface UserService {

    /**
     * 获取用户信息
     *
     * @param id 用户主键
     * @return
     */
    SUser getUser(Long id);

}

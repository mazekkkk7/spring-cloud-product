package cn.mazekkkk.cloud.product.service.impl;

import cn.mazekkkk.cloud.product.dao.common.SUser;
import cn.mazekkkk.cloud.product.dao.mapper.SUserMapper;
import cn.mazekkkk.cloud.product.service.UserService;
import com.codingapi.tx.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户服务实现类
 *
 * @author maze
 * @createTime 18/10/15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SUserMapper sUserMapper;

    /**
     * 获取用户信息
     *
     * @param id 用户主键
     * @return
     */
    @Transactional
    @TxTransaction(isStart=true)
    @Override
    public SUser getUser(Long id) {
        return sUserMapper.selectByPrimaryKey(id.intValue());
    }
}

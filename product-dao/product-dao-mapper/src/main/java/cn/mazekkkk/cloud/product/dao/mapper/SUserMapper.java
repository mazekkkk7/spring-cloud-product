package cn.mazekkkk.cloud.product.dao.mapper;

import cn.mazekkkk.cloud.product.dao.common.SUser;
import cn.mazekkkk.cloud.product.dao.common.SUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SUserMapper {
    long countByExample(SUserExample example);

    int deleteByExample(SUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SUser record);

    int insertSelective(SUser record);

    List<SUser> selectByExample(SUserExample example);

    SUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SUser record, @Param("example") SUserExample example);

    int updateByExample(@Param("record") SUser record, @Param("example") SUserExample example);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);
}
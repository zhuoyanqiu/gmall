package com.bysj.gmall.user.mapper;

import com.bysj.gmall.bean.UmsMember;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 卓炎秋
 */
@Service
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}

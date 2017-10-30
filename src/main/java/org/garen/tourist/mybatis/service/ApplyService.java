package org.garen.tourist.mybatis.service;

import org.garen.tourist.mybatis.mapper.ApplyMapper;
import org.garen.tourist.mybatis.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 类
 *
 * @author yanglimou
 * @create 2017/10/30 21:24
 * @since v1.0
 */
@Service
public class ApplyService<T,Q,PK extends Serializable> extends CommonsService<T, Q,PK>  {
    @Autowired
    private ApplyMapper<T, Q, PK> applyMapper;
    @Override
    public ApplyMapper<T, Q, PK> getMapper() {
        return applyMapper;
    }
}

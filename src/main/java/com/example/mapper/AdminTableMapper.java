package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.AdminTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jdbc.repository.query.Query;

@Mapper
public interface AdminTableMapper extends BaseMapper<AdminTable> {
  AdminTable adminTest();
}


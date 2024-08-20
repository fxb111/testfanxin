package com.example.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.AdminTable;
import com.example.mapper.AdminTableMapper;
import com.example.query.LoginQuery;
import com.example.service.AdminTableService;
import com.example.service.TokenService;
import com.example.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class AdminTableServiceImpl extends ServiceImpl<AdminTableMapper, AdminTable> implements AdminTableService {

  @Resource
  public TokenService tokenService;

  @Resource
  public AdminTableMapper adminTableMapper;

  @Override
  public R<String> adminTest() {
    adminTableMapper.adminTest();
    return new R<>(200, "test", null);
  }

  @Override
  public R<String> adminLogin(LoginQuery loginQuery) {
    AdminTable admin = adminTableMapper.selectOne(new QueryWrapper<AdminTable>()
      .eq("username", loginQuery.getUsername())
      .eq("password", loginQuery.getPassword()));
    if (ObjectUtils.isEmpty(admin)) {
      return new R(400, "用户不存在", null);
    }
    String token = tokenService.generateToken(loginQuery.getUsername());
    return new R(200, "认证成功", token);
  }


}

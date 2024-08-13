package com.example.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.AdminTable;
import com.example.mapper.AdminMapper;
import com.example.query.LoginQuery;
import com.example.service.AdminService;
import com.example.service.TokenService;
import com.example.utils.R;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class IAdminServiceImpl extends ServiceImpl<AdminMapper, AdminTable> implements AdminService {

  @Resource
  public TokenService tokenService;

  @Resource
  public AdminMapper adminMapper;

  @Override
  public R<String> adminLogin(LoginQuery loginQuery) {
    AdminTable admin = adminMapper.selectOne(new QueryWrapper<AdminTable>()
      .eq("username", loginQuery.getUsername())
      .eq("password", loginQuery.getPassword()));
    if (ObjectUtils.isEmpty(admin)) {
      return new R(400, "用户不存在", null);
    }
    String token = tokenService.generateToken(loginQuery.getUsername());
    return new R(200, "认证成功", token);
  }
}

package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.AdminTable;
import com.example.query.LoginQuery;
import com.example.utils.R;

public interface AdminTableService extends IService<AdminTable> {
  R<String> adminLogin(LoginQuery loginQuery);

  R<String> adminTest();

}

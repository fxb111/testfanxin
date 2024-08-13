package com.example.controller;

import com.example.query.LoginQuery;
import com.example.service.AdminService;
import com.example.service.TokenService;
import com.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

  public AdminService adminService;

  @Autowired
  public LoginController(AdminService adminService) {
    this.adminService = adminService;
  }

  @PostMapping("/admin")
  public R<String> adminLogin(@RequestBody LoginQuery loginQuery) {
    return adminService.adminLogin(loginQuery);
  }

}

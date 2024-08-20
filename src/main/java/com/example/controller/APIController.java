package com.example.controller;

import com.example.utils.R;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class APIController {

  @GetMapping("/test")
  public R<String> getData() {
    return new R<>(200, "成功访问接口", null);
  }

}

package com.example.config;

import com.example.service.TokenService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfig {

  @Bean
  public FilterRegistrationBean<TokenAuthenticationFilter> tokenFilter(TokenService tokenService) {
    FilterRegistrationBean<TokenAuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean<>();
    filterRegistrationBean.setFilter(new TokenAuthenticationFilter(tokenService));
    filterRegistrationBean.addUrlPatterns("/api/*");
    return filterRegistrationBean;
  }
}

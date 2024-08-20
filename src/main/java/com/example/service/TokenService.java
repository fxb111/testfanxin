package com.example.service;

import jakarta.annotation.Resource;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;

@Service
public class TokenService {

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  public String generateToken(String username) {
    SecureRandom secureRandom = new SecureRandom();
    byte[] token = new byte[24];
    secureRandom.nextBytes(token);
    String tokenStr = Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    redisTemplate.opsForValue().set(tokenStr, username, Duration.ofMinutes(60));
    return tokenStr;
  }

  public String getUsernameFromToken(String tokenStr) {
    return (String)redisTemplate.opsForValue().get(tokenStr);
  }

  public void deleteToken(String tokenStr) {
    redisTemplate.delete(tokenStr);
  }

}

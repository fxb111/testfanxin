package com.example.config;

import com.example.service.TokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class TokenAuthenticationFilter implements Filter {

  private final TokenService tokenService;

  private final Set<String> whiteList = new HashSet<>();

  public TokenAuthenticationFilter(TokenService tokenService) {
    this.tokenService = tokenService;
    whiteList.add("/login/admin");
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)servletRequest;
    HttpServletResponse response = (HttpServletResponse)servletResponse;

    String requestUrl = request.getRequestURI();
    if (isWhiteListed(requestUrl)) {
      chain.doFilter(request, response);
      return;
    }

    String token = request.getHeader("Authorization");
    if (token != null && tokenService.getUsernameFromToken(token) != null){
      chain.doFilter(request, response);
    } else {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      response.getWriter().write("Unauthorized");
    }
  }

  private boolean isWhiteListed(String requestURI) {
    return whiteList.contains(requestURI);
  }

  @Override
  public void destroy() {
  }
}

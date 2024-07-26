package com.socialapp.postservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class RequestFilter extends OncePerRequestFilter {
    private final Environment environment;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String password = request.getHeader("username");
        String correctPassword = environment.getProperty("serviceUsername");
        if (!Objects.equals(password,correctPassword))
            response.sendError(304,"{anyJson}");

        filterChain.doFilter(request,response);
    }
}

package com.niezhiliang.dubbo.tracking.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import com.niezhiliang.dubbo.tracking.constant.Constant;

/**
 * @author niezhiliang
 * @version v
 * @date 2022/7/15 17:42
 */
@Component
@WebFilter(urlPatterns = "/**", filterName = "traceIdFilter")
public class WebRequestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        try {
            MDC.put(Constant.TRACE_ID, UUID.randomUUID().toString());
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}

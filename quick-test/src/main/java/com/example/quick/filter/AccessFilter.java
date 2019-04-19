package com.example.quick.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AccessFilter extends OncePerRequestFilter {

    private ObjectMapper mapper;

    public AccessFilter() {
        mapper = new ObjectMapper();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        try {
            long start = System.currentTimeMillis();
            filterChain.doFilter(requestWrapper, responseWrapper);
            long end = System.currentTimeMillis();

            String ipAddress = request.getHeader("X-FORWARDED-FOR");
            // Means client was not behind any proxy
            if (ipAddress == null) {
                // Then we can use getRemoteAddress to get the client ip address
                ipAddress = request.getRemoteAddr();
            }

        } catch (Exception e) {
            // do monitoring logs

            throw e;
        }
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>(5);

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            map.put(headerName, headerValue);
        }

        return map;
    }

    private Map<String, String> getQueryParameters(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap<>(5);

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
        }

        return map;
    }

    private Map<String, String> getBodyParameters(ContentCachingRequestWrapper requestWrapper) throws IOException {
        Map<String, String> map = null;

        String contentType = requestWrapper.getContentType();
        if (MediaType.APPLICATION_JSON_VALUE.equals(contentType) ||
                MediaType.APPLICATION_JSON_UTF8_VALUE.equals(contentType)) {

            String jsonStr = new String(requestWrapper.getContentAsByteArray());
            map = mapper.readValue(jsonStr, new TypeReference<Map<String, String>>() {
            });

        }

        return map;
    }
}

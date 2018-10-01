package com.daou.session.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

@Slf4j
@Service
public class LoginService {
//    @Autowired
//    private RedisOperationsSessionRepository redisOperationsSessionRepository;

    @Autowired
    private FindByIndexNameSessionRepository findByIndexNameSessionRepository;

//    @Autowired
//    private SessionRepository sessionRepository;


    public void clearSession(String id) {
//        RedisOperationsSessionRepository.RedisSession redisSession = redisOperationsSessionRepository.findById(id);
//        System.out.println(id);
        String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
        Session session = findByIndexNameSessionRepository.findById(sessionId);
        findByIndexNameSessionRepository.deleteById(sessionId);

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    }
}

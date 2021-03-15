package com.chan.service.jwt;

import java.util.Map;

public interface JwtService {

    /**
     * @package : com.chan.service
     * @name : .java
     * @date : 2021-03-15 오후 2:55
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public String createMember(Map<String, Object> userMap) throws Exception;
}

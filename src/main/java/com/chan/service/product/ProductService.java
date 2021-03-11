package com.chan.service.product;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public interface ProductService {

    /**
     * @package : com.chan.controller
     * @method : getProductList
     * @comment : 상품목록
     * @date : 2021-03-11 오후 3:36
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception;
}

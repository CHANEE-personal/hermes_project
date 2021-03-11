package com.chan.service.product.impl;

import com.chan.mapper.product.ProductMapper;
import com.chan.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("ProductService")
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    /**
     * @package : com.chan.controller
     * @method : getProductList
     * @comment : 상품목록
     * @date : 2021-03-11 오후 3:36
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception {
        return productMapper.getProductList();
    }
}

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
     * @modifyed : 상품리스트 조회
     **/
    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception {
        return productMapper.getProductList(request);
    }

    /**
    * @package : com.chan.service.product.impl
    * @method : insertProduct
    * @date : 17/03/2021 2:19 오후
    * @author : chanee
    * @version : 1.0.0
    * @modifyed : 상품 등록
    **/
    public String insertProduct(HttpServletRequest request) throws Exception {
        return productMapper.insertProduct(request);
    }

    /**
    * @package : com.chan.service.product.impl
    * @method : updateProduct
    * @date : 17/03/2021 5:17 오후
    * @author : chanee
    * @version : 1.0.0
    * @modifyed : 상품 수정
    **/
    public String updateProduct(HttpServletRequest request) throws Exception {
        return productMapper.updateProduct(request);
    }
}

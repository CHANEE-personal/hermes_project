package com.chan.mapper.product;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ProductMapper {

    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception;

    /**
    * @package : com.chan.mapper.product
    * @method : insertProduct
    * @date : 17/03/2021 2:20 오후
    * @author : chanee
    * @version : 1.0.0
    * @modifyed :
    **/
    public String insertProduct(HttpServletRequest request) throws Exception;
}

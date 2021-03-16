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
}

package com.chan.mapper.product;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ProductMapper {

    public List<Map<String, Object>> getProductList() throws Exception;
}

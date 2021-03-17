package com.chan.controller.api;

import com.chan.dto.UserInfoDto;
import com.chan.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/product", method = {RequestMethod.POST, RequestMethod.GET})
@RestController
@RequiredArgsConstructor
@Api(tags="상품관련 API")
public class ProductApiController {

    private final ProductService productService;

    @ApiOperation(value="상품리스트 조회", notes="상품리스트를 조회한다.")
    @GetMapping(value="/productList")
    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception{
        return productService.getProductList(request);
    }

    @ApiOperation(value="상품등록", notes="상품을 등록한다.")
    @GetMapping(value="/insertProduct")
    public JSON insertProduct(HttpServletRequest request) throws Exception {
        JSONObject json = new JSONObject();

        productService.insertProduct(request);

        return json;
    }
}

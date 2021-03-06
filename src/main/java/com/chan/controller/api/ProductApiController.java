package com.chan.controller.api;

import com.chan.dto.UserInfoDto;
import com.chan.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/api/product")
@RestController
@RequiredArgsConstructor
@Api(tags="상품관련 API")
public class ProductApiController {

    private final ProductService productService;

    @ApiOperation(value="상품리스트 조회", notes="상품리스트를 조회한다.")
    @GetMapping(value="/list/{path}")
    public List<Map<String, Object>> getProductList(HttpServletRequest request) throws Exception{
        return productService.getProductList(request);
    }

    @ApiOperation(value="상품등록", notes="상품을 등록한다.")
    @PostMapping(value="/{item}")
    public String insertProduct(HttpServletRequest request) throws Exception {

        productService.insertProduct(request);

        return "1";
    }

    @ApiOperation(value="상품수정", notes="상품을 수정한다.")
    @PatchMapping(value="/{item}")
    public JSON updateProduct(HttpServletRequest request, @PathVariable("item") String item) throws Exception {
        JSONObject json = new JSONObject();

        productService.updateProduct(request);

        return json;
    }

    @ApiOperation(value="상품삭제", notes="상품을 삭제한다.")
    @DeleteMapping(value="/{item}")
    public JSON deleteProduct(HttpServletRequest request, @PathVariable("item") String item) throws Exception {
        JSONObject json = new JSONObject();

        return json;
    }
}

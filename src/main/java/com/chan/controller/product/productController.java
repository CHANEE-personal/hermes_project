package com.chan.controller.product;

import com.chan.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/product")
public class productController {

    private final ProductService productService;

    /**
     * @package : com.chan.controller
     * @method : list
     * @comment : 상품목록
     * @date : 2021-03-11 오후 3:36
     * @author : chanee
     * @version : 1.0.0
     * @modifyed :
     **/
    @GetMapping(value="/list")
    public ModelAndView list (HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();

        // 상품목록
        List<Map<String, Object>> productList = this.productService.getProductList(request);

        mv.addObject("productList", productList);

        mv.setViewName("/product/productList");

        return mv;
    }
}

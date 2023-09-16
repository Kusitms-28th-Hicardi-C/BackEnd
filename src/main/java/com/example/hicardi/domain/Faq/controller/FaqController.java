package com.example.hicardi.domain.Faq.controller;

import com.example.hicardi.domain.Faq.dto.FaqDto;
import com.example.hicardi.domain.Faq.entity.Faq;
import com.example.hicardi.domain.Faq.service.FaqService;
import com.example.hicardi.domain.product.dto.ProductDto;
import com.example.hicardi.domain.product.entity.Product;
import com.example.hicardi.global.exception.base.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faq")
@RequiredArgsConstructor
public class FaqController {

    private final FaqService faqService;

    private final ModelMapper modelMapper;
    @GetMapping("/list")
    public BaseResponse<List<FaqDto.Response>> postList(){
        List<Faq> faq = faqService.findByAll();
        List<FaqDto.Response> resultDto = faq.stream()
                .map(data-> modelMapper.map(data, FaqDto.Response.class))
                .collect(Collectors.toList());
        return BaseResponse.onSuccess(resultDto);
    }

    @GetMapping("/list/{category}")
    public BaseResponse<List<FaqDto.Response>> categoryList(@PathVariable("category") String category){
        List<Faq> faq = faqService.findByCategoryList(category);
        List<FaqDto.Response> resultDto = faq.stream()
                .map(data-> modelMapper.map(data, FaqDto.Response.class))
                .collect(Collectors.toList());
        return BaseResponse.onSuccess(resultDto);
    }
    @GetMapping("/list/{category}/{faqId}")
    public BaseResponse<FaqDto.Response> categorydetailList(@PathVariable("category") String category ,@PathVariable("faqId") Long id){
        Faq faq = faqService.findByCategoryAndMemberId(category, id);

        return BaseResponse.onSuccess(new FaqDto.Response(faq));
    }


}

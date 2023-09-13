package com.example.hicardi.domain.cart.controller;

import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.dto.cartResponseDTO;
import com.example.hicardi.domain.cart.service.CartService;
import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.service.UserService;
import com.example.hicardi.global.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {

    private final CartService cartService;

    //장바구니에 추가
    @PostMapping("/add")
    public ResponseEntity<?> addCart(@Validated @RequestBody CartRequestDTO dto, HttpServletRequest request
    ) {
        log.info("/api/v1/cart/add POST! --{}", dto);
//        String userId = (String)request.getAttribute(LoginUtil.LOGIN_KEY);
        String userId = "kusitms1";

        try {
            cartResponseDTO cartResponseDTO = cartService.cartAdd(userId, dto);
            return ResponseEntity.ok().body(cartResponseDTO);
        } catch (Exception e) {
            log.warn("기타 예외가 발생했습니다");
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    //장바구니 수정
//    @PutMapping("/{cartNo}")
//    public ResponseEntity<?> modifyCart(){ //+버튼인지/-버튼인지
//        
//    }

    //장바구니 제품 삭제
    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId, HttpServletRequest request
    ) {
        //값 들어오는지 확인
        log.info("/user/modify DELETE! --{}", cartId);

//        String userId = (String)request.getAttribute(LoginUtil.LOGIN_KEY);
        String userId = "kusitms1";

        try {
            boolean deleteResult = cartService.deleteCart(cartId,userId);
            return ResponseEntity.ok().body(deleteResult);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

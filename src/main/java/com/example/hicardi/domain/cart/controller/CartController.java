package com.example.hicardi.domain.cart.controller;

import com.example.hicardi.domain.cart.dto.CartListResponseDTO;
import com.example.hicardi.domain.cart.dto.CartModifyRequesDTO;
import com.example.hicardi.domain.cart.dto.CartRequestDTO;
import com.example.hicardi.domain.cart.dto.cartResponseDTO;
import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.cart.service.CartService;
import com.example.hicardi.domain.user.dto.SignUpRequestDTO;
import com.example.hicardi.domain.user.entity.User;
import com.example.hicardi.domain.user.service.UserService;
import com.example.hicardi.global.util.LoginUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    //장바구니 전체 조회
//    @GetMapping
//    public ResponseEntity<?> cartMainPage(HttpServletRequest request
//    ) {
////            Long memberId = (Long)request.getAttribute(LoginUtil.LOGIN_KEY);
//        Long memberId = 1L;
//
//        if(memberId==null) throw new RuntimeException("로그인 먼저 진행하세유~~");
//
//        // 장바구니에 들어있는 아이템 모두 가져오기 : list
//        CartListResponseDTO allUserCart = cartService.getAllUserCart(memberId);
//
//        return ResponseEntity
//                .ok()
//                .body(allUserCart);
//
//    }



    //장바구니에 추가
    @PostMapping("/add")
    public ResponseEntity<?> addCart(@Validated @RequestBody CartRequestDTO dto, HttpServletRequest request
    ) {
        log.info("/api/v1/cart/add POST! --{}", dto);
//            Long memberId = (Long)request.getAttribute(LoginUtil.LOGIN_KEY);
        Long memberId = 1L;

        User user = userService.findUserByMemberId(memberId);



        try {
            cartResponseDTO cartResponseDTO = cartService.cartAdd(memberId, dto);
            return ResponseEntity.ok().body(cartResponseDTO);
        } catch (Exception e) {
            log.warn("기타 예외가 발생했습니다");
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    //장바구니 수정
    @PutMapping
    public ResponseEntity<?> modifyCart(@Validated @RequestBody CartModifyRequesDTO dto){
        cartResponseDTO cartResponseDTO = cartService.modifyCart(dto);

        return ResponseEntity.ok().body(cartResponseDTO);
    }

    //장바구니 제품 삭제
    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable Long cartId, HttpServletRequest request
    ) {
        //값 들어오는지 확인
        log.info("/user/modify DELETE! --{}", cartId);

        boolean cartExists = cartService.isCartExists(cartId);
        if(cartExists==true){
//            Long memberId = (Long)request.getAttribute(LoginUtil.LOGIN_KEY);
            Long memberId = 1L;
            try {
                boolean deleteResult = cartService.deleteCart(cartId,memberId);
                return ResponseEntity.ok().body(deleteResult);
            }catch (Exception e) {
                return ResponseEntity.badRequest().body("삭제 실패");
            }
        }

        throw new RuntimeException("존재하지 않는 카트 번호입니다");
    }
}

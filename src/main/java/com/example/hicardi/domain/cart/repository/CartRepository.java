package com.example.hicardi.domain.cart.repository;

import com.example.hicardi.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUserMemberId(long memberId);

    boolean existsByUserMemberIdAndProductProductId(long memberId, long productId);

    void deleteByCartIdAndUserMemberId(Long cartId, Long memberId);

    boolean existsByCartIdAndUserMemberId(long l, long l1);

    Cart findByCartIdAndUserMemberId(long l, long l1);

    boolean existsByCartId(Long cartId);

    List<Cart> findByUserMemberId(Long memberId);

    Cart findByProductProductIdAndUserMemberId(Long productId,Long memberId);

    Cart findByCartId(Long cartId);
}

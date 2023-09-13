package com.example.hicardi.domain.cart.repository;

import com.example.hicardi.domain.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUserMemberId(long memberId);

    boolean existsByUserMemberIdAndProductProductId(long memberId, int productId);

    boolean deleteByCartIdAndUserMemberId(Long cartId, Long memberId);

    boolean existsByCartIdAndUserMemberId(long l, long l1);

    Cart findByCartIdAndUserMemberId(long l, long l1);
}

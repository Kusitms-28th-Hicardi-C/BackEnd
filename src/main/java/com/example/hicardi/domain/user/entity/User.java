package com.example.hicardi.domain.user.entity;

import com.example.hicardi.domain.cart.entity.Cart;
import com.example.hicardi.domain.user.dto.BUSINESS;
import com.example.hicardi.domain.user.dto.GENDER;
import com.example.hicardi.domain.user.dto.MEMBERSHIP;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "member")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "membership_verification", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MEMBERSHIP membershipVerification = MEMBERSHIP.BUSINESSMEMEBER;

    @Column(name = "business_classification", nullable = false)
    @Enumerated(EnumType.STRING)
    private BUSINESS businessClassification;

    @Column(name = "login_id", nullable = false, unique = true)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "business_number", nullable = false, unique = true)
    private String businessNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "land_line", nullable = true)
    private String landLine;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GENDER gender;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "ykiho")
    private String ykiho;

    @CreationTimestamp //insert할 떄 시간 자동으로 들어== DEFAULT CURRENT_TIMESTAMP
    @Column(name="created_at",updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp //update문 돌아갈 때 자동으로 시간 저장
    @Column(name="updated_at")
    private LocalDateTime updateAt;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Cart> carts = new ArrayList<>();
}

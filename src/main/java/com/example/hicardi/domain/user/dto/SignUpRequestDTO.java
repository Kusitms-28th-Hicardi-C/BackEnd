package com.example.hicardi.domain.user.dto;

import com.example.hicardi.domain.user.entity.User;
import lombok.*;
import java.util.Date;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpRequestDTO {

    private MEMBERSHIP membershipVerification;
    private BUSINESS businessClassification;
    private String loginId;
    private String password;
    private String name;
    private String businessName;
    private String businessNumber;
    private String address;
    private String landLine;
    private String phoneNumber;
    private String email;
    private GENDER gender;
    private String birthDate;
    private String ykiho;

    public User toEntity() {
        return User.builder()
                .membershipVerification(this.membershipVerification)
                .businessClassification(this.businessClassification)
                .loginId(this.loginId)
                .password(this.password)
                .name(this.name)
                .businessName(this.businessName)
                .businessNumber(this.businessNumber)
                .address(this.address)
                .landLine(this.landLine)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .gender(this.gender)
                .birthDate(this.birthDate)
                .ykiho(this.ykiho)
                .build();
    }



}

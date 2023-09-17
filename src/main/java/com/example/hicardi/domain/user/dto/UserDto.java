package com.example.hicardi.domain.user.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long memberId;

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
}

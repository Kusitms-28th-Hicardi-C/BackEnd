package com.example.hicardi.domain.user.dto;

import com.example.hicardi.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class LoginResponseDTO {

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

    public LoginResponseDTO(User user) {
        this.membershipVerification = user.getMembershipVerification();
        this.businessClassification = user.getBusinessClassification();
        this.loginId = user.getLoginId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.businessName = user.getBusinessName();
        this.businessNumber = user.getBusinessNumber();
        this.address = user.getAddress();
        this.landLine = user.getLandLine();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.gender = user.getGender();
        this.birthDate = user.getBirthDate();
        this.ykiho = user.getYkiho();
    }
}

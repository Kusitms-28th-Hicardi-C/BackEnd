package com.example.hicardi.domain.user.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class LoginRequestDTO {
    private String loginId;
    private String password;
}

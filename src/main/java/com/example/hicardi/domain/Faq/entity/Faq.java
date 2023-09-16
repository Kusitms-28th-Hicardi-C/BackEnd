package com.example.hicardi.domain.Faq.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="faq")
@EntityListeners(AuditingEntityListener.class)
public class Faq {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "faq_id")
    private Long faqId;

    @Column
    private String question;
    @Column
    private String answer;
    @Column
    private String category;

}

package com.example.hicardi.domain.Faq.dto;

import com.example.hicardi.domain.Faq.entity.Faq;
import com.example.hicardi.domain.product.entity.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
public class FaqDto {
    @NoArgsConstructor
    @Data
    public static class Request{
        private Long faqId;

        private String question;

        private String answer;

        private String category;

        public Faq toEntity() {
            return Faq.builder()
                    .faqId(faqId)
                    .question(question)
                    .answer(answer)
                    .category(category)
                    .build();
        }

        public Request(Faq faq) {
            this.faqId=getFaqId();
            this.question=getQuestion();
            this.answer=getAnswer();
            this.category=getCategory();
        }
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response{

        private Long faqId;

        private String question;

        private String answer;

        private String category;

        @Builder
        public Response(Faq faq) {
            this.faqId=getFaqId();
            this.question=getQuestion();
            this.answer=getAnswer();
            this.category=getCategory();
        }

    }
}

package com.example.hicardi.domain.product.dto;

import com.example.hicardi.domain.product.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Builder
public class ProductDto {
    @NoArgsConstructor
    @Data
    public static class Request{
        private Long productId;
        private String name;
        private String price;
        private String description;

        private LocalDateTime createdDate;

        private String productInfo;

        private String option;

        public Product toEntity() {
            return Product.builder()
                    .productId(productId)
                    .name(name)
                    .price(price)
                    .description(description)
                    .createdDate(createdDate)
                    .productInfo(productInfo)
                    .option(option)
                    .build();
        }

        public Request(Product product) {
            this.productId= product.getProductId();
            this.name=product.getName();
            this.price=product.getPrice();
            this.description=product.getDescription();
            this.createdDate=product.getCreatedDate();
            this.productInfo=product.getProductInfo();
            this.option=product.getOption();
        }
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Response{

        private Long productId;
        private String name;
        private String price;
        private String description;

        private LocalDateTime createdDate;

        private String productInfo;

        private String option;

        @Builder
        public Response(Product product) {
            this.productId= product.getProductId();
            this.name=product.getName();
            this.price=product.getPrice();
            this.description=product.getDescription();
            this.createdDate=product.getCreatedDate();
            this.productInfo=product.getProductInfo();
            this.option=product.getOption();
        }

    }
}

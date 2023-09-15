package com.example.hicardi.domain.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BlogSearch {
    private String category;
    private String keyword;

    public BlogSearch() {
        this.category = "";
        this.keyword = "";
    }
}

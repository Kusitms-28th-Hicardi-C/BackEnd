package com.example.hicardi.domain.Faq.repository;


import com.example.hicardi.domain.Faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq,Long> {

    Faq findFaqByCategoryAndFaqId(String category, Long faqid);

    List<Faq> findFaqByCategory(String category);


}

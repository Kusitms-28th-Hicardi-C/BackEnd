package com.example.hicardi.domain.Faq.service;

import com.example.hicardi.domain.Faq.entity.Faq;
import com.example.hicardi.domain.Faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public Faq findByCategoryAndMemberId(String category, Long id){
        return faqRepository.findFaqByCategoryAndFaqId(category,id);
    }

    public List<Faq> findByCategoryList(String category){
        return faqRepository.findFaqByCategory(category);

    }
    public List<Faq> findByAll (){
        return faqRepository.findAll();

    }

    public List<Faq> findByKeyword(String keyword){
        String sql = "%"+keyword+"%";
        return faqRepository.findFaqByQuestionLikeAndAnswerLike(sql);
    }

}

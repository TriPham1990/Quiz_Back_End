package com.sm.ms.service;

import tri.lo.model.KindOfQuestion;

import java.util.List;
import java.util.Optional;

public interface KindOfQuestionService {

    List<KindOfQuestion> findAll();

    Optional<KindOfQuestion> findById(Long id);

    void save(KindOfQuestion kindOfQuestion);

    void remove(Long id);
}

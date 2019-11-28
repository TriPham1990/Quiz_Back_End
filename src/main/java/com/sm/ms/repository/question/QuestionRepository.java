package com.sm.ms.repository.question;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sm.ms.model.question.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}

package com.sm.ms.repository.question;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sm.ms.model.question.KindOfQuestion;

public interface KindOfQuestionRepository extends JpaRepository<KindOfQuestion, Long> {
}

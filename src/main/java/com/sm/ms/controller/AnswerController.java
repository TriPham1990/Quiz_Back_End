package com.sm.ms.controller;

import com.sm.ms.model.question.Answer;
import com.sm.ms.model.question.Question;
import com.sm.ms.service.AnswerService;
import com.sm.ms.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/auth/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @ModelAttribute("questions")
    public List<Question> questions() {
        return questionService.findAll();
    }

    @GetMapping
    private ResponseEntity<List<Answer>> listAllAnswer() {
        List<Answer> answers = answerService.findAll();
        if (answers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> createAnswer(@RequestBody Answer answer, UriComponentsBuilder ucBuilder) {
        answerService.save(answer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/auth/answers/{id}").buildAndExpand(answer.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}

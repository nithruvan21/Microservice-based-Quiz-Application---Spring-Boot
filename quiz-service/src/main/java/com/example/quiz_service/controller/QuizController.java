package com.example.quiz_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.QuizDto;
import com.example.quiz_service.model.Response;
import com.example.quiz_service.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){ // string ->  integer
		return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumOfQuestions(),quizDto.getTitle());
	}
	
	@GetMapping("getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> fetchQuiz(@PathVariable Integer id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizService.calculate(id,responses);
	}
}

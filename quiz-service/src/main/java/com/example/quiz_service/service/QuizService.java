package com.example.quiz_service.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz_service.Feign.QuizInterface;
import com.example.quiz_service.dao.QuizDao;
import com.example.quiz_service.model.QuestionWrapper;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuizInterface quizInterface;
	

	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category,numQ).getBody();
		Quiz quiz = new Quiz();

		quiz.setTitle(title);
		quiz.setQuestionIds(questions);

		quizDao.save(quiz);

		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Integer> questionIds = quiz.get().getQuestions();

		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsById(questionIds);
		
		return questions;
	}

	public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {
		
		ResponseEntity<Integer> score = quizInterface.getScore(responses);

		return score;
	}
}

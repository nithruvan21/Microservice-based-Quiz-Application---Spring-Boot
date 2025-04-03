package com.example.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.question_service.dao.QuestionDao;
import com.example.question_service.model.Question;
import com.example.question_service.model.QuestionWrapper;
import com.example.question_service.model.Response;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<List<Question>> getAllQuestions() {
		List<Question> questions =  questionDao.findAll();
		try {
			return new ResponseEntity<>(questions,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed to add",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteById(Integer id) {
		try {
			questionDao.deleteById(id);
			return new ResponseEntity<>("Deleted",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed to delete",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQ) {
		return new ResponseEntity<>(questionDao.findRandomQuestionsByCategory(categoryName, numQ),HttpStatus.OK);
	}

    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionIds) {
		// Processing the questions from the DB and returning them as QuestionWrappers(without answers)

        List<QuestionWrapper> wrappers = new ArrayList<>();
		List<Question> questions = new ArrayList<>();

		for(Integer id : questionIds){
			questions.add(questionDao.findById(id).get()); // findById returns OptionalEntity, so use get()
		}

		for(Question question : questions){
			QuestionWrapper qw = new QuestionWrapper();

			qw.setId(question.getId());
			qw.setQuestionTitle(question.getQuestionTitle());
			qw.setOption1(question.getOption1());
			qw.setOption2(question.getOption2());
			qw.setOption3(question.getOption3());
			qw.setOption4(question.getOption4());

			wrappers.add(qw);

		}


		return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		Integer mark = 0;

		for(Response response : responses){
			Question ques = questionDao.findById(response.getId()).get();

			if(ques.getRightAnswer().equals(response.getResponse())){
				mark++;
			}
		}

		return new ResponseEntity<>(mark,HttpStatus.OK);
	}
}

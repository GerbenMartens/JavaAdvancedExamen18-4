package edu.ap.spring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

import java.awt.event.ActionEvent;

@Service
public class EventHandler {
	private UI ui;
    private QuestionRepository repository;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent) {
    		EightBall eight = new EightBall();
    		String question = ui.getQuestion().getText();
    		Question user = new Question(question);
    		String answer = eight.getRandomAnswer(question);
    		
    		if(user.getAnswer() == "") {
    			user.setAnswer(answer);
    		}    		
    		
        repository.save(user);
    }
}

package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	@Id
	   @GeneratedValue
	   private Long id;

	    private String name, answer = "";

	    public Question() {}

	    public Question(String name) {
	        this.name = name;
	    }

	    public Question(String name, String answer) {
	        this.name = name;
	        this.answer = answer;
	    }
	    
	    public String getQuestion() {
	        return this.name;
	    }
	    
	    public String getAnswer() {
	    		return this.answer;
	    }
	    
	    public void setAnswer(String answer) {
	    	this.answer = answer;
	    }

	    @Override
	    public String toString() {
	        return "User {" +
	                "name = " + name +
	                ", password = '" + answer + '\'' +
	                '}';
	    }
}

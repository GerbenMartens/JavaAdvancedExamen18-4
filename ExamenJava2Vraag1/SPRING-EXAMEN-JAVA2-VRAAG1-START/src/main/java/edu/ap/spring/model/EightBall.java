package edu.ap.spring.model;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;


@Component
public class EightBall {
	
	private int[] count = {
			0,0,0,0,0,0,0,0
	};
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {
		Random rand = new Random();
		int max = Arrays.stream(count).max().getAsInt();
		int  n = rand.nextInt(8);
		String answer = null;
		

        if(max > count[n]) {
        	answer = answers[n];
        }

		
		count[n]++;
		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}

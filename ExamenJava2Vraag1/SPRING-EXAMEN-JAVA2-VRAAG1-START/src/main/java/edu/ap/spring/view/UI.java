package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
	
	@Autowired
	EventHandler eventHandler;
	
	private JFrame jFrame;
	private JLabel label1, label2;
	private JTextField questionAsked, answerGiven;
	private JPanel controlPanel;
    private JButton btnAskQuestion;
    
    public UI() {}
	
	public void setupUI() {
    	jFrame = new JFrame("Spring JFrame");
    	jFrame.setLayout(new FlowLayout());
    	
    	controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(2, 2));

	label1 = new JLabel("Question : ");
	questionAsked = new JTextField(15);
	questionAsked.setDragEnabled(true);
	
	label2 = new JLabel("Answer : ");
	answerGiven = new JTextField(15);
	answerGiven.setEnabled(false);

	btnAskQuestion = new JButton();
	btnAskQuestion.setText("Ask");
	btnAskQuestion.setTransferHandler(new TransferHandler("text"));
	btnAskQuestion.addActionListener(eventHandler::whenButtonClicked);

	controlPanel.add(label1);
	controlPanel.add(questionAsked);
	controlPanel.add(label2);
	controlPanel.add(answerGiven);
	controlPanel.add(btnAskQuestion);

	jFrame.add(controlPanel);
	        
	jFrame.setSize(400, 400);
	jFrame.setLocationRelativeTo(null);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.pack();
	jFrame.setVisible(true);
}
    public JFrame getjFrame() {
        return this.jFrame;
    }
    
    public JTextField getQuestion() {
    		return this.questionAsked;
    } 
    
    public JTextField getAnswer() {
		return this.answerGiven;
} 

    public JButton getButton() {
        return btnAskQuestion;
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizUI {
    private JFrame frame;
    private JLabel questionLabel;
    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    private JButton submitButton;
    private JLabel scoreLabel;
    private int currentQuestion;
    private int score;
    private QuizLogic quizLogic;

    public QuizUI() {
        frame = new JFrame("Java Quiz Game");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        questionLabel = new JLabel("Question goes here");
        topPanel.add(questionLabel, BorderLayout.NORTH);
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(4, 1));
        answer1 = new JRadioButton("Answer 1");
        answer2 = new JRadioButton("Answer 2");
        answer3 = new JRadioButton("Answer 3");
        answer4 = new JRadioButton("Answer 4");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer1);
        buttonGroup.add(answer2);
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);
        answerPanel.add(answer1);
        answerPanel.add(answer2);
        answerPanel.add(answer3);
        answerPanel.add(answer4);
        topPanel.add(answerPanel, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitListener());
        bottomPanel.add(submitButton);
        scoreLabel = new JLabel("Score: 0");
        bottomPanel.add(scoreLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        currentQuestion = 0;
        score = 0;
        quizLogic = new QuizLogic();
        displayQuestion();
        frame.setVisible(true);
    }

    public int getAnswer() {
        if (answer1.isSelected()) {
            return 1;
        } else if (answer2.isSelected()) {
            return 2;
        } else if (answer3.isSelected()) {
            return 3;
        } else if (answer4.isSelected()) {
            return 4;
        } else {
            return 0;
        }
    }

    public void displayQuestion() {
        
    }

    public void displayScore() {
        questionLabel.setText("Quiz finished. Final score: " + score);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
        submitButton.setEnabled(false);
    }

    private class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}


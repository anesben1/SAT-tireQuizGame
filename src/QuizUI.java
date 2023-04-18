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
    private Quiz quiz;
    private JPanel answerPanel;

    public QuizUI() {
        frame = new JFrame("Java Quiz Game");
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        questionLabel = new JLabel("Question goes here");
        topPanel.add(questionLabel, BorderLayout.NORTH);
        answerPanel = new JPanel();
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
        submitButton.addActionListener(new SubmitListener(quiz,answerPanel));

        bottomPanel.add(submitButton);
        scoreLabel = new JLabel("Score: 0");
        bottomPanel.add(scoreLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        currentQuestion = 0;
        score = 0;
        quizLogic = new QuizLogic();
        quiz = quizLogic.loadQuiz();
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
        Question question = quiz.getQuestion();
        questionLabel.setText(question.getQuestionText());
        
        String[] answerChoices = question.getAnswerChoices();
        answer1.setText(answerChoices[0]);
        answer2.setText(answerChoices[1]);
        answer3.setText(answerChoices[2]);
        answer4.setText(answerChoices[3]);
        
        // clear the selected answer
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer1);
        buttonGroup.add(answer2);
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);
        answer1.setSelected(false);
        answer2.setSelected(false);
        answer3.setSelected(false);
        answer4.setSelected(false);
        
        // add the answer choices to the answer panel
        answerPanel.removeAll();
        answerPanel.setLayout(new GridLayout(2, 2));
        answerPanel.add(answer1);
        answerPanel.add(answer2);
        answerPanel.add(answer3);
        answerPanel.add(answer4);
        answerPanel.revalidate();
        answerPanel.repaint();
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


        private Quiz quiz;
        private QuizLogic quizLogic;
        private JPanel answerPanel;

        public SubmitListener(Quiz quiz, JPanel answerPanel) {
            this.quiz = quiz;
            this.answerPanel=answerPanel;
        }

        public void actionPerformed(ActionEvent e) {
            int answer = getAnswer();
        quiz.submitAnswer(answer);
        if (quiz.isFinished()) {
            displayScore();
        } else {
            currentQuestion++;
            displayQuestion();
            answerPanel.removeAll();
            answerPanel.setLayout(new GridLayout(2, 2));
            answerPanel.add(answer1);
            answerPanel.add(answer2);
            answerPanel.add(answer3);
            answerPanel.add(answer4);
            answerPanel.revalidate();
            answerPanel.repaint();
        }
    }


        
    }
}


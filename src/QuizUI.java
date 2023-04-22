import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizUI extends JFrame {
    private Quiz quiz;
    private JPanel questionPanel;
    private JButton submitButton;
    private ButtonGroup answerGroup;
    private JLabel questionLabel;
    private JRadioButton[] answerButtons;

    public QuizUI(Quiz quiz) {
        this.quiz = quiz;
        setTitle("Quiz Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));
        add(questionPanel, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedAnswer = getSelectedAnswerIndex();
                quiz.submitAnswer(selectedAnswer);
                displayNextQuestion();
            }
        });
        add(submitButton, BorderLayout.SOUTH);

        questionLabel = new JLabel();
        questionPanel.add(questionLabel);

        answerButtons = new JRadioButton[4];
        answerGroup = new ButtonGroup();
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JRadioButton();
            answerGroup.add(answerButtons[i]);
            questionPanel.add(answerButtons[i]);
        }
    }

    public void displayNextQuestion() {
        if (quiz.isFinished()) {
            int score = quiz.getScore();
            int totalQuestions = quiz.getNumQuestions();
            double percentage = ((double) score / (double) totalQuestions) * 100;
            JOptionPane.showMessageDialog(this, "Quiz Completed! You have answered " + score + " out of " + totalQuestions + ". Your score: " + percentage + "%");
            System.exit(0);
        } else {
            Question question = quiz.getCurrentQuestion();
            System.out.println("Displaying questions: " + question.getQuestionText()); // Debug Question 
            questionLabel.setText(question.getQuestionText());
            String[] choices = question.getAnswerChoices();
            for (int i = 0; i < choices.length; i++) {
                answerButtons[i].setText(choices[i]);
            }
        }
    }

    private int getSelectedAnswerIndex() {
        for (int i = 0; i < answerButtons.length; i++) {
            if (answerButtons[i].isSelected()) {
                return i;
            }
        }
        return -1;
    }
}

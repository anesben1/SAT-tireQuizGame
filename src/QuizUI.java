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
        initComponents();
        displayNextQuestion();
    }

    private void initComponents() {
        setTitle("SAT-tire, get ready!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create separate panels for the question and answers sections
        questionPanel = new JPanel(new BorderLayout());
        JPanel answersPanel = new JPanel(new GridLayout(2, 2));

        // Set the preferred size for questionPanel and answersPanel
        questionPanel.setPreferredSize(new Dimension(600, 100));
        answersPanel.setPreferredSize(new Dimension(600, 200));

        add(questionPanel, BorderLayout.NORTH);
        add(answersPanel, BorderLayout.CENTER);

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

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionPanel.add(questionLabel, BorderLayout.NORTH);

        answerButtons = new JRadioButton[4];
        answerGroup = new ButtonGroup();
        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i] = new JRadioButton();
            answerGroup.add(answerButtons[i]);
            answersPanel.add(answerButtons[i]);
        }

        pack();
        setLocationRelativeTo(null);
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
            System.out.println("Displaying questions: " + question.getQuestionText());
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

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) throws Exception {
        // create a new QuestionDatabase object by passing in the file name
        QuestionDatabase questionDB = new QuestionDatabase("data/questions.txt");

        // get the list of questions from the QuestionDatabase object
        ArrayList<Question> questions = questionDB.getQuestions();

        // get user preferences for quiz customization
        JDialog quizCustomizationDialog = new JDialog();
        quizCustomizationDialog.setLayout(new GridLayout(3, 2));
        JLabel numQuestionsLabel = new JLabel("Number of questions:");
        JTextField numQuestionsField = new JTextField();
        JLabel timeLimitLabel = new JLabel("Time limit (minutes):");
        JTextField timeLimitField = new JTextField();

        // create the submit button and listener
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numQuestions = Integer.parseInt(numQuestionsField.getText());
                int timeLimit = Integer.parseInt(timeLimitField.getText());
                QuizCustomization quizCustomization = new QuizCustomization(numQuestions, timeLimit);

                // create a new QuizLogic object
                QuizLogic quizLogic = new QuizLogic();

                // create and start the quiz
                Quiz quiz = quizLogic.loadQuiz(quizCustomization, questionDB);

                quizCustomizationDialog.dispose();

                QuizUI quizUI = new QuizUI(quiz);
                quizUI.displayNextQuestion();
                quizUI.setVisible(true);
                System.out.println("Quiz started"); // debug line 
            }
        });

        // add components to the dialog
        quizCustomizationDialog.add(numQuestionsLabel);
        quizCustomizationDialog.add(numQuestionsField);
        quizCustomizationDialog.add(timeLimitLabel);
        quizCustomizationDialog.add(timeLimitField);
        quizCustomizationDialog.add(submitButton);

        // set dialog properties
        quizCustomizationDialog.setTitle("Quiz Customization");
        quizCustomizationDialog.setModal(true);
        quizCustomizationDialog.setSize(300, 150);
        quizCustomizationDialog.setResizable(false);
        quizCustomizationDialog.setLocationRelativeTo(null);
        quizCustomizationDialog.setVisible(true);
    }
}

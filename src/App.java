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

        // get the list of questions from the QuestionDatabase objectclear 
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
                // do something when the button is clicked
            }
        });

        QuizLogic quizLogic = new QuizLogic();
       // Quiz quiz = quizLogic.loadQuiz(quizCustomization,questionDB);
        //QuizUI quizUI = new QuizUI(quiz);
        //quizUI.displayNextQuestion();

        // close the dialog
        quizCustomizationDialog.dispose();
        
    }
}

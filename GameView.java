import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private CardLayout cardLayout;

    private JPanel menuPanel;
    private JPanel additionPanel;
    private JPanel resultPanel;

    private JButton additionButton;
    private JButton subtractionButton;

    private JLabel questionLabel;
    private JTextField answerField;

    private JLabel resultLabel;
    private JLabel statsLabel;
    private JButton nextButton;
    private JButton homeButton;

    public GameView() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        createMenuPanel();
        createAdditionPanel();
        createResultPanel();

        add(menuPanel, "MENU");
        add(additionPanel, "GAME");
        add(resultPanel, "RESULT");

        cardLayout.show(this, "MENU");
    }

    private void createMenuPanel() {
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel(
                "Welcome to your Math Tutor! What can I help you with?",
                SwingConstants.CENTER
        );
        title.setForeground(Color.GREEN);

        menuPanel.add(title, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(5, 1, 10, 10));
        buttons.setBackground(Color.BLACK);

        additionButton = makeButton("Addition");
        subtractionButton = makeButton("Subtraction");

        buttons.add(additionButton);
        buttons.add(subtractionButton);
        buttons.add(makeButton("Multiplication"));
        buttons.add(makeButton("Division"));
        buttons.add(makeButton("Exponents"));

        menuPanel.add(buttons);
    }

    private void createAdditionPanel() {
        additionPanel = new JPanel(new GridLayout(3, 1));
        additionPanel.setBackground(Color.BLACK);

        questionLabel = new JLabel("0 + 0", SwingConstants.CENTER);
        questionLabel.setForeground(Color.GREEN);

        answerField = new JTextField();
        answerField.setBackground(Color.BLACK);
        answerField.setForeground(Color.GREEN);

        additionPanel.add(questionLabel);
        additionPanel.add(answerField);
    }

    private void createResultPanel() {
        resultPanel = new JPanel(new GridLayout(5, 1));
        resultPanel.setBackground(Color.BLACK);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(Color.GREEN);

        statsLabel = new JLabel("", SwingConstants.CENTER);
        statsLabel.setForeground(Color.GREEN);

        nextButton = makeButton("Next Question");
        homeButton = makeButton("Back to Home");

        resultPanel.add(resultLabel);
        resultPanel.add(statsLabel);
        resultPanel.add(nextButton);
        resultPanel.add(homeButton);
    }

    private JButton makeButton(String text) {
        JButton b = new JButton(text);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.GREEN);
        return b;
    }

    // ------------------------
    // SCREEN CONTROL
    // ------------------------
    public void showMenu() {
        cardLayout.show(this, "MENU");
    }

    public void showGame() {
        cardLayout.show(this, "GAME");
    }

    public void showResult() {
        cardLayout.show(this, "RESULT");
    }

    // ------------------------
    // UI UPDATE
    // ------------------------
    public void setQuestionText(String text) {
        questionLabel.setText(text);
    }

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void clearAnswer() {
        answerField.setText("");
    }

    public void setResult(boolean correct) {
        resultLabel.setText(correct ? "Correct!" : "Wrong!");
    }

    public void setStats(int correct, int streak, int wrong) {
        statsLabel.setText("<html>Total Answers Right: " + correct +
                "<br>Correct Answer Streak: " + streak +
                "<br>Total Wrong Answers: " + wrong + "</html>");
    }

    // ------------------------
    // GETTERS
    // ------------------------
    public JButton getAdditionButton() { return additionButton; }
    public JButton getSubtractionButton() { return subtractionButton; }
    public JTextField getAnswerField() { return answerField; }
    public JButton getNextButton() { return nextButton; }
    public JButton getHomeButton() { return homeButton; }
}
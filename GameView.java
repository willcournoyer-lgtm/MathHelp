import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private CardLayout cardLayout;

    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel resultPanel;

    private JButton additionButton;
    private JButton subtractionButton;
    private JButton multiplicationButton;
    private JButton divisionButton;

    private JLabel questionLabel;
    private JTextField answerField;

    private JLabel resultLabel;
    private JLabel statsLabel;
    private JButton nextButton;
    private JButton homeButton;

    private final Color NEON_GREEN = new Color(0, 255, 0);

    public GameView() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        createMenuPanel();
        createGamePanel();
        createResultPanel();

        add(menuPanel, "MENU");
        add(gamePanel, "GAME");
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
        title.setForeground(NEON_GREEN);

        menuPanel.add(title, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(5, 1, 10, 10));
        buttons.setBackground(Color.BLACK);

        additionButton = createButton("Addition");
        subtractionButton = createButton("Subtraction");
        multiplicationButton = createButton("Multiplication");
        divisionButton = createButton("Division");

        buttons.add(additionButton);
        buttons.add(subtractionButton);
        buttons.add(multiplicationButton);
        buttons.add(divisionButton);
        buttons.add(createButton("Exponents"));

        menuPanel.add(buttons);
    }

    private void createGamePanel() {
        gamePanel = new JPanel(new GridLayout(3, 1));
        gamePanel.setBackground(Color.BLACK);

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setForeground(NEON_GREEN);
        questionLabel.setFont(new Font("Monospaced", Font.BOLD, 24));

        answerField = new JTextField();
        answerField.setBackground(Color.BLACK);
        answerField.setForeground(NEON_GREEN);
        answerField.setCaretColor(NEON_GREEN);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setBorder(BorderFactory.createLineBorder(NEON_GREEN, 2));

        gamePanel.add(questionLabel);
        gamePanel.add(answerField);
    }

    private void createResultPanel() {
        resultPanel = new JPanel(new GridLayout(5, 1));
        resultPanel.setBackground(Color.BLACK);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(NEON_GREEN);

        statsLabel = new JLabel("", SwingConstants.CENTER);
        statsLabel.setForeground(NEON_GREEN);

        nextButton = createButton("Next Question");
        homeButton = createButton("Back to Home");

        resultPanel.add(resultLabel);
        resultPanel.add(statsLabel);
        resultPanel.add(nextButton);
        resultPanel.add(homeButton);
    }

    private JButton createButton(String text) {
        JButton b = new JButton(text);
        b.setBackground(Color.BLACK);
        b.setForeground(NEON_GREEN);
        b.setBorder(BorderFactory.createLineBorder(NEON_GREEN, 2));
        return b;
    }

    public void showMenu() { cardLayout.show(this, "MENU"); }
    public void showGame() { cardLayout.show(this, "GAME"); }
    public void showResult() { cardLayout.show(this, "RESULT"); }

    public void setQuestionText(String text) { questionLabel.setText(text); }
    public String getUserAnswer() { return answerField.getText(); }
    public void clearAnswer() { answerField.setText(""); }

    public void setResult(boolean correct) {
        resultLabel.setText(correct ? "Correct!" : "Wrong!");
    }

    public void setStats(int correct, int streak, int wrong) {
        statsLabel.setText("<html>Total Answers Right: " + correct +
                "<br>Correct Answer Streak: " + streak +
                "<br>Total Wrong Answers: " + wrong + "</html>");
    }

    public JButton getAdditionButton() { return additionButton; }
    public JButton getSubtractionButton() { return subtractionButton; }
    public JButton getMultiplicationButton() { return multiplicationButton; }
    public JButton getDivisionButton() { return divisionButton; }
    public JTextField getAnswerField() { return answerField; }
    public JButton getNextButton() { return nextButton; }
    public JButton getHomeButton() { return homeButton; }
}
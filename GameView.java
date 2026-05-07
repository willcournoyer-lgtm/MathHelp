import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private CardLayout cardLayout;

    private JPanel menuPanel;
    private JPanel gamePanel;
    private JPanel resultPanel;

    private JButton additionButton;
    private JButton subtractionButton;

    private JLabel questionLabel;
    private JTextField answerField;

    private JLabel resultLabel;
    private JLabel statsLabel;
    private JButton nextButton;
    private JButton homeButton;

    // Neon green color
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

    // ========================
    // MENU PANEL
    // ========================
    private void createMenuPanel() {
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.BLACK);

        JLabel title = new JLabel(
                "Welcome to your Math Tutor! What can I help you with?",
                SwingConstants.CENTER
        );
        title.setForeground(NEON_GREEN);
        title.setFont(new Font("Monospaced", Font.BOLD, 16));

        menuPanel.add(title, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(5, 1, 10, 10));
        buttons.setBackground(Color.BLACK);

        additionButton = createNeonButton("Addition");
        subtractionButton = createNeonButton("Subtraction");

        buttons.add(additionButton);
        buttons.add(subtractionButton);
        buttons.add(createNeonButton("Multiplication"));
        buttons.add(createNeonButton("Division"));
        buttons.add(createNeonButton("Exponents"));

        menuPanel.add(buttons, BorderLayout.CENTER);
    }

    // ========================
    // GAME PANEL
    // ========================
    private void createGamePanel() {
        gamePanel = new JPanel(new GridLayout(3, 1, 10, 10));
        gamePanel.setBackground(Color.BLACK);

        questionLabel = new JLabel("0 + 0", SwingConstants.CENTER);
        questionLabel.setForeground(NEON_GREEN);
        questionLabel.setFont(new Font("Monospaced", Font.BOLD, 24));

        answerField = new JTextField();
        answerField.setBackground(Color.BLACK);
        answerField.setForeground(NEON_GREEN);
        answerField.setCaretColor(NEON_GREEN);
        answerField.setHorizontalAlignment(JTextField.CENTER); // ✅ CENTER TEXT
        answerField.setFont(new Font("Monospaced", Font.BOLD, 18));
        answerField.setBorder(BorderFactory.createLineBorder(NEON_GREEN, 2)); // ✅ NEON BOX

        gamePanel.add(questionLabel);
        gamePanel.add(answerField);
    }

    // ========================
    // RESULT PANEL
    // ========================
    private void createResultPanel() {
        resultPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        resultPanel.setBackground(Color.BLACK);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(NEON_GREEN);
        resultLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        statsLabel = new JLabel("", SwingConstants.CENTER);
        statsLabel.setForeground(NEON_GREEN);
        statsLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));

        nextButton = createNeonButton("Next Question");
        homeButton = createNeonButton("Back to Home");

        resultPanel.add(resultLabel);
        resultPanel.add(statsLabel);
        resultPanel.add(nextButton);
        resultPanel.add(homeButton);
    }

    // ========================
    // BUTTON STYLE
    // ========================
    private JButton createNeonButton(String text) {
        JButton button = new JButton(text);

        button.setBackground(Color.BLACK);
        button.setForeground(NEON_GREEN);
        button.setFont(new Font("Monospaced", Font.BOLD, 14));
        button.setFocusPainted(false);

        // ✅ Neon border
        button.setBorder(BorderFactory.createLineBorder(NEON_GREEN, 2));

        return button;
    }

    // ========================
    // SCREEN CONTROL
    // ========================
    public void showMenu() {
        cardLayout.show(this, "MENU");
    }

    public void showGame() {
        cardLayout.show(this, "GAME");
    }

    public void showResult() {
        cardLayout.show(this, "RESULT");
    }

    // ========================
    // UI UPDATE
    // ========================
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
        statsLabel.setText(
                "<html>Total Answers Right: " + correct +
                "<br>Correct Answer Streak: " + streak +
                "<br>Total Wrong Answers: " + wrong + "</html>"
        );
    }

    // ========================
    // GETTERS
    // ========================
    public JButton getAdditionButton() { return additionButton; }
    public JButton getSubtractionButton() { return subtractionButton; }
    public JTextField getAnswerField() { return answerField; }
    public JButton getNextButton() { return nextButton; }
    public JButton getHomeButton() { return homeButton; }
}
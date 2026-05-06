import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private CardLayout cardLayout;

    // Panels
    private JPanel menuPanel;
    private JPanel additionPanel;
    private JPanel resultPanel;

    // Menu components
    private JButton additionButton;

    // Addition components
    private JLabel questionLabel;
    private JTextField answerField;

    // Result components
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
        add(additionPanel, "ADDITION");
        add(resultPanel, "RESULT");

        cardLayout.show(this, "MENU");
    }

    // ========================
    // MENU
    // ========================
    private void createMenuPanel() {
        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBackground(Color.BLACK);

        JLabel titleLabel = new JLabel(
                "Welcome to your Math Tutor! What can I help you with?",
                SwingConstants.CENTER
        );
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 16));

        menuPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttons = new JPanel(new GridLayout(5, 1, 10, 10));
        buttons.setBackground(Color.BLACK);

        additionButton = createButton("Addition");
        buttons.add(additionButton);
        buttons.add(createButton("Subtraction"));
        buttons.add(createButton("Multiplication"));
        buttons.add(createButton("Division"));
        buttons.add(createButton("Exponents"));

        menuPanel.add(buttons, BorderLayout.CENTER);
    }

    // ========================
    // ADDITION SCREEN
    // ========================
    private void createAdditionPanel() {
        additionPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        additionPanel.setBackground(Color.BLACK);

        questionLabel = new JLabel("0 + 0", SwingConstants.CENTER);
        questionLabel.setForeground(Color.GREEN);
        questionLabel.setFont(new Font("Monospaced", Font.BOLD, 22));

        answerField = new JTextField();
        answerField.setBackground(Color.BLACK);
        answerField.setForeground(Color.GREEN);
        answerField.setCaretColor(Color.GREEN);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setFont(new Font("Monospaced", Font.BOLD, 18));

        additionPanel.add(questionLabel);
        additionPanel.add(answerField);
    }

    // ========================
    // RESULT SCREEN
    // ========================
    private void createResultPanel() {
        resultPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        resultPanel.setBackground(Color.BLACK);

        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setForeground(Color.GREEN);
        resultLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        statsLabel = new JLabel("", SwingConstants.CENTER);
        statsLabel.setForeground(Color.GREEN);
        statsLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));

        nextButton = createButton("Next Question");
        homeButton = createButton("Back to Home");

        resultPanel.add(resultLabel);
        resultPanel.add(statsLabel);
        resultPanel.add(nextButton);
        resultPanel.add(homeButton);
    }

    // ========================
    // HELPERS
    // ========================
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GREEN);
        button.setFont(new Font("Monospaced", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        return button;
    }

    // ========================
    // SCREEN CONTROL
    // ========================
    public void showMenu() {
        cardLayout.show(this, "MENU");
    }

    public void showAdditionScreen() {
        cardLayout.show(this, "ADDITION");
    }

    public void showResultScreen() {
        cardLayout.show(this, "RESULT");
    }

    // ========================
    // UPDATE UI
    // ========================
    public void setQuestionText(String text) {
        questionLabel.setText(text);
    }

    public String getUserAnswer() {
        return answerField.getText();
    }

    public void clearAnswerField() {
        answerField.setText("");
    }

    public void setResultText(boolean correct) {
        resultLabel.setText(correct ? "Correct!" : "Wrong!");
    }

    public void setStatsText(int totalCorrect, int streak, int totalWrong) {
        statsLabel.setText(
                "<html>" +
                        "Total Answers Right: " + totalCorrect + "<br>" +
                        "Correct Answer Streak: " + streak + "<br>" +
                        "Total Wrong Answers: " + totalWrong +
                        "</html>"
        );
    }

    // ========================
    // GETTERS
    // ========================
    public JButton getAdditionButton() {
        return additionButton;
    }

    public JTextField getAnswerField() {
        return answerField;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getHomeButton() {
        return homeButton;
    }
}
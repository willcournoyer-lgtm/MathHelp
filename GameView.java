import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

    private CardLayout cardLayout;

    // Panels
    private JPanel menuPanel;
    private JPanel additionPanel;

    // Menu components
    private JButton additionButton;

    // Addition screen components
    private JLabel questionLabel;
    private JTextField answerField;

    public GameView() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        createMenuPanel();
        createAdditionPanel();

        add(menuPanel, "MENU");
        add(additionPanel, "ADDITION");

        // Start on menu
        cardLayout.show(this, "MENU");
    }

    // ========================
    // MENU SCREEN
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

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(Color.BLACK);

        additionButton = createMenuButton("Addition");
        buttonPanel.add(additionButton);
        buttonPanel.add(createMenuButton("Subtraction"));
        buttonPanel.add(createMenuButton("Multiplication"));
        buttonPanel.add(createMenuButton("Division"));
        buttonPanel.add(createMenuButton("Exponents"));

        menuPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    // ========================
    // ADDITION SCREEN
    // ========================
    private void createAdditionPanel() {
        additionPanel = new JPanel();
        additionPanel.setLayout(new GridLayout(3, 1, 10, 10));
        additionPanel.setBackground(Color.BLACK);

        questionLabel = new JLabel("0 + 0", SwingConstants.CENTER);
        questionLabel.setForeground(Color.GREEN);
        questionLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        answerField = new JTextField();
        answerField.setBackground(Color.BLACK);
        answerField.setForeground(Color.GREEN);
        answerField.setCaretColor(Color.GREEN);
        answerField.setFont(new Font("Monospaced", Font.BOLD, 16));
        answerField.setHorizontalAlignment(JTextField.CENTER);

        additionPanel.add(questionLabel);
        additionPanel.add(answerField);
    }

    // ========================
    // HELPERS
    // ========================
    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.GREEN);
        button.setFont(new Font("Monospaced", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        return button;
    }

    // ========================
    // SCREEN SWITCHING
    // ========================
    public void showAdditionScreen() {
        cardLayout.show(this, "ADDITION");
    }

    // ========================
    // UPDATE QUESTION DISPLAY
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

    // Getter for controller
    public JButton getAdditionButton() {
        return additionButton;
    }

    public JTextField getAnswerField() {
        return answerField;
    }
}
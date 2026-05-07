import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {

    // ========================
    // GENERAL DATA
    // ========================
    private int totalCorrect;
    private int correctInRow;
    private int totalWrong;
    private List<Integer> selectedAnswers;

    private Random random;

    // ========================
    // CURRENT QUESTION
    // ========================
    private int num1;
    private int num2;
    private int correctAnswer;
    private String currentMode;

    public GameModel() {
        totalCorrect = 0;
        correctInRow = 0;
        totalWrong = 0;
        selectedAnswers = new ArrayList<>();
        random = new Random();
    }

    // ========================
    // ADDITION
    // ========================
    public void generateAdditionQuestion() {
        num1 = random.nextInt(999) + 1;
        num2 = random.nextInt(999) + 1;
        correctAnswer = num1 + num2;
        currentMode = "ADDITION";
    }

    // ========================
    // SUBTRACTION
    // ========================
    public void generateSubtractionQuestion() {
        int a = random.nextInt(999) + 1;
        int b = random.nextInt(999) + 1;

        if (a >= b) {
            num1 = a;
            num2 = b;
        } else {
            num1 = b;
            num2 = a;
        }

        correctAnswer = num1 - num2;
        currentMode = "SUBTRACTION";
    }

    // ========================
    // MULTIPLICATION
    // ========================
    public void generateMultiplicationQuestion() {
        num1 = random.nextInt(21);
        num2 = random.nextInt(21);
        correctAnswer = num1 * num2;
        currentMode = "MULTIPLICATION";
    }

    // ========================
    // DIVISION
    // ========================
    public void generateDivisionQuestion() {
        int base = random.nextInt(20) + 1;
        int multiplier = random.nextInt(20) + 1;

        int product = base * multiplier;

        num1 = product;
        num2 = multiplier;

        correctAnswer = base;
        currentMode = "DIVISION";
    }

    // ========================
    // EXPONENTS (Squared)
    // ========================
    public void generateExponentQuestion() {
        num1 = random.nextInt(21); // 0–20
        num2 = 2; // always squared

        correctAnswer = num1 * num1; // square
        currentMode = "EXPONENT";
    }

    // ========================
    // CHECK ANSWER
    // ========================
    public boolean checkAnswer(int userAnswer) {
        selectedAnswers.add(userAnswer);

        if (userAnswer == correctAnswer) {
            totalCorrect++;     // ✅ FIRST
            correctInRow++;     // ✅ SECOND
            return true;
        } else {
            totalWrong++;
            correctInRow = 0;
            return false;
        }
    }

    // ========================
    // GETTERS
    // ========================
    public int getNum1() { return num1; }
    public int getNum2() { return num2; }
    public int getTotalCorrect() { return totalCorrect; }
    public int getCorrectInRow() { return correctInRow; }
    public int getTotalWrong() { return totalWrong; }
    public String getCurrentMode() { return currentMode; }
}
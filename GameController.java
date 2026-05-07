import javax.swing.JFrame;

public class GameController {

    private GameModel model;
    private GameView view;

    public GameController() {
        model = new GameModel();
        view = new GameView();

        JFrame frame = new JFrame("Math Tutor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.add(view);
        frame.setVisible(true);

        // ADDITION
        view.getAdditionButton().addActionListener(e -> {
            model.generateAdditionQuestion();
            view.setQuestionText(model.getNum1() + " + " + model.getNum2());
            view.clearAnswer();
            view.showGame();
        });

        // SUBTRACTION
        view.getSubtractionButton().addActionListener(e -> {
            model.generateSubtractionQuestion();
            view.setQuestionText(model.getNum1() + " - " + model.getNum2());
            view.clearAnswer();
            view.showGame();
        });

        // MULTIPLICATION
        view.getMultiplicationButton().addActionListener(e -> {
            model.generateMultiplicationQuestion();
            view.setQuestionText(model.getNum1() + " × " + model.getNum2());
            view.clearAnswer();
            view.showGame();
        });

        // ✅ DIVISION
        view.getDivisionButton().addActionListener(e -> {
            model.generateDivisionQuestion();
            view.setQuestionText(model.getNum1() + " ÷ " + model.getNum2());
            view.clearAnswer();
            view.showGame();
        });

        // ANSWER INPUT
        view.getAnswerField().addActionListener(e -> {
            try {
                int answer = Integer.parseInt(view.getUserAnswer());

                boolean correct = model.checkAnswer(answer);

                view.setResult(correct);
                view.setStats(
                        model.getTotalCorrect(),
                        model.getCorrectInRow(),
                        model.getTotalWrong()
                );

                view.showResult();

            } catch (Exception ex) {
                view.clearAnswer();
            }
        });

        // NEXT QUESTION
        view.getNextButton().addActionListener(e -> {

            switch (model.getCurrentMode()) {

                case "ADDITION":
                    model.generateAdditionQuestion();
                    view.setQuestionText(model.getNum1() + " + " + model.getNum2());
                    break;

                case "SUBTRACTION":
                    model.generateSubtractionQuestion();
                    view.setQuestionText(model.getNum1() + " - " + model.getNum2());
                    break;

                case "MULTIPLICATION":
                    model.generateMultiplicationQuestion();
                    view.setQuestionText(model.getNum1() + " × " + model.getNum2());
                    break;

                case "DIVISION":
                    model.generateDivisionQuestion();
                    view.setQuestionText(model.getNum1() + " ÷ " + model.getNum2());
                    break;
            }

            view.clearAnswer();
            view.showGame();
        });

        // HOME
        view.getHomeButton().addActionListener(e -> {
            view.showMenu();
        });
    }

    public static void main(String[] args) {
        new GameController();
    }
}
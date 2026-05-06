I'm building this game in Java using Swing, split into three files: GameModel.java, GameView.java, and GameController.java. GameView should extend JPanel and be hosted in a JFrame. GameController should have the main method and wire the three classes together. GameModel must have no Swing imports. For now, just create the three class shells with placeholder comments describing what each class will do. The program should compile and open a blank window.

Fill in GameModel.java. The model should track: the amount of correct answers in total, the amount of correct answers in a row, what answers are selected, and the amount of wrong answers. No Swing imports.

Now, in the game model, add a section of information called "Addition". in this section, for each question, generate a whole number between 1 up to 999, do this for 2 seperate numbers and have them added together. make it so that the user can type in a number, if the entered answer, is the correct answer, add a point to get total correct and getcorrectinrow.

now, i want you to update the Game View so that it has a black background with green text. Green text should say at the top "Welcome to your Math Tutor! What can I help you with?" Then under that, have five boxes, each one saying the following; "Addition", "Subtraction", "Multiplication", "Division", "Exponents". 


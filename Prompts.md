I'm building this game in Java using Swing, split into three files: GameModel.java, GameView.java, and GameController.java. GameView should extend JPanel and be hosted in a JFrame. GameController should have the main method and wire the three classes together. GameModel must have no Swing imports. For now, just create the three class shells with placeholder comments describing what each class will do. The program should compile and open a blank window.

Fill in GameModel.java. The model should track: the amount of correct answers in total, the amount of correct answers in a row, what answers are selected, and the amount of wrong answers. No Swing imports.

Now, in the game model, add a section of information called "Addition". in this section, for each question, generate a whole number between 1 up to 999, do this for 2 seperate numbers and have them added together. make it so that the user can type in a number, if the entered answer, is the correct answer, add a point to get total correct and getcorrectinrow.

now, i want you to update the Game View so that it has a black background with green text. Green text should say at the top "Welcome to your Math Tutor! What can I help you with?" Then under that, have five boxes, each one saying the following; "Addition", "Subtraction", "Multiplication", "Division", "Exponents". 

now make it so that when you click on the addition button, it brings you to a new screen that produces the equation used in the generateAdditionQuestion. it should also give you a small box that can be clicked on where the user can type in the answer.

I am now having the following issues appear, can you explain what these mean and give solutions?
Syntax error on token "getAdditionButton", Identifier expected after this token
Syntax error on token ".", { expected
Syntax error, insert "}" to complete MethodBody

now make it in the Game View, that when you get the answer correct, it says "Correct!" and shows you something that says "Total Answers Right: ", "Correct Answer Streak: ", "Total Wrong Answers", then regardless of wrong or write, asks if you want to go to the next question, which creates the next question, or goes back to the home screen.

Now, in the game model, add a section of information called "Subtraction". in this section, for each question, generate a whole number between 1 up to 999, do this for 2 separate numbers, then organize it so that the larger number is on the left side and have them subtracted from each other. make it so that the user can type in a number, if the entered answer is the correct answer, do the following orders of add to total correct, and correct in a row. Then fully rewrite the game files that you adjust so i can copy and past them.

make it so that in the game view, the boxes are a neon green that matches the header and also make it so that when the user is typing in their answer to a question, it is centered in the box.

Now, in the game model, add a section of information called "Multiplication". in this section, for each question, generate a whole number between 0 and 20, do this for 2 separate numbers, then have them be multiplied. make it so that the user can type in a number, if the entered answer is the correct answer, do the following orders of add to total correct, and correct in a row. Then fully rewrite the game files that you adjust so i can copy and past them with all the previous content we had discussed.
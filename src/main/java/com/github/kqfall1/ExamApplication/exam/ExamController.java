/* Quinn Keenan, 301504914, 19/09/2025
I plan on abstracting the complexities present in the main method by implementing event handling throughout
my codebase. For the time being, this is perfectly functional and well beyond the scope of a simple school lab
assignment. However, I'm in an academic program called "Software Engineering Technology" and I'd like to live
up to the title. */

package com.github.kqfall1.ExamApplication.exam;

import com.github.kqfall1.enums.YesNoInput;
import com.github.kqfall1.handlers.InputHandler;
import com.github.kqfall1.handlers.JOptionPaneHandler;

import javax.swing.JOptionPane;

public class ExamController
{
	public static void main(String[] args)
	{
		boolean answerIsCorrect;
		String answerMessage;
		String correctOptionString;
		Exam exam;
		JOptionPaneHandler jOptionPaneHandler = new JOptionPaneHandler();
		InputHandler handler = new InputHandler(jOptionPaneHandler, jOptionPaneHandler, jOptionPaneHandler);

		while (handler.promptForYesNo("Would you like to be tested (Y/N)?").equals(YesNoInput.YES))
		{
			exam = Exam.createTest((int) handler.promptForNumber(
				String.format("How many questions would you like on your new test (%d - %d)?",
					1,
					ExamQuestionBuilder.NUMBER_OF_UNIQUE_QUESTIONS),
				1,
				10
			));

			while (exam.isActive())
			{
				correctOptionString = exam.getCurrentQuestionCorrectOptionString();
				answerIsCorrect = exam.submitAnswer((int) handler.promptForNumber(
					exam.getCurrentQuestionString(),
					1,
					exam.getCurrentQuestionNumberOfOptions()
				));

				answerMessage = exam.getRandomAnswerMessage(answerIsCorrect);

				if (answerIsCorrect)
				{
					JOptionPane.showMessageDialog(
						null,
						answerMessage,
						"Correct answer!",
						JOptionPane.INFORMATION_MESSAGE
					);
				}
				else
				{
					JOptionPane.showMessageDialog(
						null,
						String.format("%s The correct answer was: \"%s.\"", answerMessage, correctOptionString),
						"Incorrect answer!",
						JOptionPane.INFORMATION_MESSAGE
					);
				}
			}

			JOptionPane.showMessageDialog(
				null,
				exam.getScoreString(),
				"Test completed!",
				JOptionPane.INFORMATION_MESSAGE
			);

			exam.reset();
		}
	}
}
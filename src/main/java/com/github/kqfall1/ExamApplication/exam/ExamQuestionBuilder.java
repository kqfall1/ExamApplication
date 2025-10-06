/* Quinn Keenan, 301504914, 19/09/2025
Ideally, I would have some sort of large question bank (as a file) to deserialize and populate
a list with (or even better, a Java-related, multiple-choice question API I could fetch data
from). However, at the moment, I am not familiar enough with Java to fetch data from APIs at
my current skill level, I am unsure of whether a sufficient API even exists, and I don't have
time to implement serialization for this sprint. Time will tell what improvements I can
realistically make! */

package com.github.kqfall1.ExamApplication.exam;

import java.util.ArrayList;
import java.util.Random;

public class ExamQuestionBuilder
{
	/**
 	* Contains indices of TestQuestionBuilder prompts that have already been added to the
 	* current instance of Test. Is reset when the current instance of Test becomes inactive.
 	*/
	private static final ArrayList<Byte> previouslyAddedPromptIndices = new ArrayList<>();

	private static final String[] prompts =
	{
		"Which of the following typically groups related classes so that they could be imported into programs and reused?",
		"Which of the following statements is false about Java method statements?",
		"Method arguments may be...?",
		"What does Math static method Math.ceil(x) do?",
		"There are variables for which each object of a class does not need its own separate copy. They are called...?",
		"Class variables must be declared as...?",
		"A method’s parameters are...?",
		"Converting an argument’s value, if possible, to the type that the method expects to receive in its corresponding parameter is called...?",
		"If a series of method calls occurs, the successive return addresses are pushed onto the method stack in...?",
		"If a local variable or parameter in a method has the same name as a field of the class, the field is hidden until the block terminates execution. This phenomenon is termed as...?"
	};

	public static final byte NUMBER_OF_UNIQUE_QUESTIONS = (byte) prompts.length;

	private static final byte questionOneCorrectOptionIndex = 0;

	private static final String[] questionOneOptionStrings =
	{
		"Package",
		"Function",
		"Method",
		"IDE"
	};

	private static final byte questionTwoCorrectOptionIndex = 2;

	private static final String[] questionTwoOptionStrings =
	{
		"Statements in a method body use existing classes and methods as building blocks to create new programs",
		"Statements in a method body is written only once",
		"Statements in a method body are not hidden from other methods",
		"Statements in a method body determine the behavior of an object",
	};

	private static final byte questionThreeCorrectOptionIndex = 1;

	private static final String[] questionThreeOptionStrings =
	{
		"only constants",
		"constants, variables, or expressions",
		"only variables",
		"only strings"
	};

	private static final byte questionFourCorrectOptionIndex = 3;

	private static final String[] questionFourOptionStrings =
	{
		"Rounds x to it is absolute value",
		"Rounds x to the largest integer not greater than x",
		"Rounds x to the smallest integer smaller than x",
		"Round x to the smallest integer not less than x"
	};

	private static final byte questionFiveCorrectOptionIndex = 1;

	private static final String[] questionFiveOptionStrings =
	{
		"constants",
		"class variables",
		"local variables",
		"instance variables"
	};

	private static final byte questionSixCorrectOptionIndex = 3;

	private static final String[]  questionSixOptionStrings =
	{
		"final",
		"const",
		"var",
		"static"
	};

	private static final byte  questionSevenCorrectOptionIndex = 0;

	private static final String[] questionSevenOptionStrings =
	{
		"local variables of that method and can be used only in that method’s body",
		"instance variables that are not shared by all objects",
		"global variables and can be used from anywhere inside the application source code",
		"class variables and shared by all the objects"
	};

	private static final byte questionEightCorrectOptionIndex = 2;

	private static final String[] questionEightOptionStrings =
	{
		"argument truncation",
		"argument conversion",
		"argument promotion",
		"type casting"
	};

	private static final byte questionNineCorrectOptionIndex = 1;

	private static final String[] questionNineOptionStrings =
	{
		"random orders",
		"last-in, first-out order",
		"first-in, last-out out order",
		"first-in, first-out order"
	};

	private static final byte questionTenCorrectOptionIndex = 0;

	private static final String[] questionTenOptionStrings =
	{
		"shadowing",
		"clouding",
		"shadowcasting",
		"buffering"
	};

	private static final Random gen = new Random();

	/**
 	* Builds a new testQuestion with a unique prompt (relative to other questions
 	* encapsulated by the current instance of Test) and options in a randomized order.
 	* @return a fully configured testQuestion object that is ready to be encapsulated
 	* by the current instance of Test.
 	* @throws IllegalStateException if there are no more available questions left.
 	*/
	public static ExamQuestion build()
	{
		byte correctOptionIndex;
		int count;
		byte questionIndex = (byte) gen.nextInt(prompts.length);
		String[] optionStrings;
		ExamQuestion question;

		if (previouslyAddedPromptIndices.size() >= prompts.length)
		{
			throw new IllegalStateException("There are no more available questions left.");
		}

		while (previouslyAddedPromptIndices.contains(questionIndex))
		{
			questionIndex = (byte) gen.nextInt(prompts.length);
		}

		previouslyAddedPromptIndices.add(questionIndex);
		question = new ExamQuestion(prompts[questionIndex]);

		switch (questionIndex)
		{
			case 0 ->
			{
				correctOptionIndex = questionOneCorrectOptionIndex;
				optionStrings = questionOneOptionStrings;
			}
			case 1 ->
			{
				correctOptionIndex = questionTwoCorrectOptionIndex;
				optionStrings = questionTwoOptionStrings;
			}
			case 2 ->
			{
				correctOptionIndex = questionThreeCorrectOptionIndex;
				optionStrings = questionThreeOptionStrings;
			}
			case 3 ->
			{
				correctOptionIndex = questionFourCorrectOptionIndex;
				optionStrings = questionFourOptionStrings;
			}
			case 4 ->
			{
				correctOptionIndex = questionFiveCorrectOptionIndex;
				optionStrings = questionFiveOptionStrings;
			}
			case 5 ->
			{
				correctOptionIndex = questionSixCorrectOptionIndex;
				optionStrings = questionSixOptionStrings;
			}
			case 6 ->
			{
				correctOptionIndex = questionSevenCorrectOptionIndex;
				optionStrings = questionSevenOptionStrings;
			}
			case 7 ->
			{
				correctOptionIndex = questionEightCorrectOptionIndex;
				optionStrings = questionEightOptionStrings;
			}
			case 8 ->
			{
				correctOptionIndex = questionNineCorrectOptionIndex;
				optionStrings = questionNineOptionStrings;
			}
			case 9 ->
			{
				correctOptionIndex = questionTenCorrectOptionIndex;
			optionStrings = questionTenOptionStrings;
			}
			default ->
			{
				throw new IllegalArgumentException(String.format("Unexpected value: %d", questionIndex));
			}

			
		}

		for (count = 0; count < optionStrings.length; count++)
		{
			if (count == correctOptionIndex)
			{
				question.addOption(new ExamQuestionOption(true, optionStrings[count]));
			}
			else
			{
				question.addOption(new ExamQuestionOption(false, optionStrings[count]));
			}
		}

		question.shuffleOptions();
		return question;
	}

	public static void reset()
	{
		previouslyAddedPromptIndices.clear();
	}
}
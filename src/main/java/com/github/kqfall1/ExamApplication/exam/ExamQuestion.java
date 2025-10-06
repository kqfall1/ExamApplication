/* Quinn Keenan, 301504914, 19/09/2025
I considered creating a testQuestion superclass, but decided against doing so because
I have two other exercises to complete for this lab and cannot spend too much time
engineering any one of them. It would be best practice to do so though! For now, all
TestQuestions are multiple choice questions in accordance with agile methodologies.
Improvements will be made in future sprints. */

package com.github.kqfall1.ExamApplication.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamQuestion
{
	/**
 	* Used to iterate through or mutate an element of testQuestions.options.
 	*/
	private int currentOptionIndex;

	/**
 	* Used only for the creation of testQuestion objects.
 	* Don't ever use this for iterating through or mutating testQuestions.options.
 	*/
	private static final byte MAX_OPTIONS = 4;
	private ExamQuestionOption[] options;
	private final String prompt;

	ExamQuestion(String prompt)
	{
		options = new ExamQuestionOption[MAX_OPTIONS];
		this.prompt = prompt;
	}

	void addOption(ExamQuestionOption option)
	{
		if (currentOptionIndex >= options.length)
		{
			throw new IllegalStateException(String.format("Cannot add more than %d options to testQuestion \"%s\"", options.length, this));
		}

		options[currentOptionIndex] = option;
		currentOptionIndex++;
	}

	public ExamQuestionOption[] getOptions()
{
return Arrays.copyOf(options, currentOptionIndex);
}

	public String getPrompt()
{
return prompt;
}

	void shuffleOptions()
	{
		ExamQuestionOption[] nonNullOptions = Arrays.copyOf(options, currentOptionIndex);
		List<ExamQuestionOption> optionList = new ArrayList<>(Arrays.asList(nonNullOptions));
		Collections.shuffle(optionList);
		options = optionList.toArray(new ExamQuestionOption[optionList.size()]);
	}

	@Override
	public String toString()
	{
		return prompt;
	}
}
/* Quinn Keenan, 301504914, 19/09/2025
This is not a record class because if it was, the auto-implementation of this.toString() would
return a String containing a boolean value indicating whether each option is correct or not.
Obviously giving the examinee answers to questions on a test before they answer defeats the
entire point of a test! */

package com.github.kqfall1.ExamApplication.exam;

public class ExamQuestionOption
{
	private final boolean isCorrect;
	private final String text;

	ExamQuestionOption(boolean isCorrect, String text)
	{
		this.isCorrect = isCorrect;
		this.text = text;
	}

	public boolean getIsCorrect()
	{
		return isCorrect;
	}

	@Override
	public String toString()
	{
		return text;
	}
}
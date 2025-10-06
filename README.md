A small Java multiple-choice test application demonstrating singleton patterns, object-oriented design,  
random question selection, and much more! Here are some of my design decisions and thoughts: 

I plan on abstracting the complexities present in the main method by implementing event handling throughout
my codebase. For the time being, this is perfectly functional and well beyond the scope of a simple school lab
assignment. However, I'm in an academic program called "Software Engineering Technology" and I'd like to live
up to the title rather than doing trivial, mindless tasks for easy, high grades. Furthermore, I considered
creating an abstraction to combine the logic for the two input-parsing methods, but they are too different
to do so without it being a huge headache. The same applies to the JOptionPane method calls in the entry point.
I may reconsider in the future.

Ideally, I would have some sort of large question bank (as a file) to deserialize and populate
a list with (or even better, a Java-related, multiple-choice question API I could fetch data
from). However, at the moment, I am not familiar enough with Java to fetch data from APIs at
my current skill level, I am unsure of whether a sufficient API even exists, and I don't have
time to implement serialization for this sprint. Time will tell what improvements I can
realistically make!

I considered creating a testQuestion superclass, but decided against doing so because
I have two other exercises to complete for this lab and cannot spend too much time
engineering any one of them. It would be best practice to do so though! For now, all
TestQuestions are multiple choice questions in accordance with agile methodologies.
Improvements will be made in future sprints.

- Quinn Keenan
- 20/09/2025, 5:32PM

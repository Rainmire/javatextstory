A text reader that compiles a text file written in a particular syntax to generate an interactive branching story.
Java version of textstory, with similar input syntax. Use "test.txt" as example input and run. The rest is very straightfoward.

[[paragraph<<choice~num|choice~num>>]]	'|' is optional

Each input paragraph must be enclosed by [[paragraph]], with the <<choice>> inside it. Any text outside the brackets is treated
as comments and will be ignored. Paragraphs must be placed in sequence of directory call.
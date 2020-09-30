# csx42-fall-2019-assign4-mgadi1
Name: Mohit Gadi
Slack days used: 2. (1 pending from my slack days balance, and 1 slack day granted by the instructor as asked on piazza)
Following are the commands and the instructions to run ANT on your project.

Note: build.xml is present in troubleShootSearch/src folder.
Instruction to clean:
####Command: ant -buildfile troubleShootSearch/src/build.xml clean


Instruction to compile:
####Command: ant -buildfile troubleShootSearch/src/build.xml all


Instruction to run:
####Command: ant -buildfile troubleShootSearch/src/build.xml run -Darg0="technicalInfo.txt" -Darg1="userInput.txt" -Darg2="synonyms.txt" -Darg3="output.txt"

Note: Arguments accept the absolute path of the files.

Description:
I have made datastructure classes MyArrayList and MyTree. I have used binary search tree in MyTree so the time complexity is O(n).
I have implemented visitor pattern, and there are 3 visitors, which are the 3 search types.
In the driver code, all the files are processed. technicalInfo.txt is stored in MyArrayList as array and userInput.txt is stored
in MyArrayList as input. The synonyms are stored as Hashmaps. Objects of the visitors are created that takes Result object as argument which prints the output as
well as writes to file. 
In exact search, there is a condition check whether the string contains the following substring and returns the result to Results.
In Naive stemming, I have used binary search tree.
In Semantic search, the synonyms are stored as hashmap. The hashmap is a 2 way(CPU is key and processor is value, and processor 
is key and CPU is value) so that it can act as vice versa. And after that substring is replaced with the corresponding value of hashmap
and then search is repeated similar to exact search.


Academic Honesty statement:
"I have done this assignment completely on my own. I have not copied it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken. "

Date: 11/18/2019

# README #

Created in IntelliJ IDEA 15.0.3

This project was created to process Twitter-like messages that are scanned in 
from user input from the console. A user can enter a tweet using a maximum of 140 characters.
The message is scanned into the Reader class where it checks the length of the message and,
if it is not too long, separates the message into individual words or items separated by a space.
All of the items are added to a string array which is passed into the Parser class. Each item in
the array is parsed through a sorter method. The sorter first checks if an item begins with 
"@" followed by one or more characters. If it does, then the word is added to a particular 
array list for mentions. If not, then the sorter checks if the item begins with "#" followed by 
one or more characters and similarly adds it to a particular array list for topics if it does.
If the word doesn't meet either of those criteria, if the word begins with "http" or "www,"
the sorter adds it to a particular array list for URLs. Once the sorter has finished placing
a word (or not placing one if it doesn't meet the criteria), 3 key-value pairs are added to a 
HashMap: "mentions" and the mentions array list, "topics" and the topics array list, and "URLs"
and the URLs array list. Once all the words from the message are parsed, the HashMap is printed.

## To run using Java [Windows] ##

Navigate to:

    twitter-msg-engine/src/main/java

Compile:

    javac -d "../../../build/classes/main" twitter/*.java

Run:

    java -classpath "../../../build/classes/main" twitter.Main

press Ctrl+D to end scanner input
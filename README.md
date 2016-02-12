# README #

Created in IntelliJ IDEA 15.0.3

Status: Looking pretty good! Always room for improvement though!

This project was created to process sample Twitter-like messages that are strings with a maximum of 140 characters.

A new Reader class is created using a sample tweet where it checks the length of the message and,
if it is not too long or empty, separates the message into individual words or items separated by a space.
All of the items are added to a string array which is passed into the Parser class. 

Each item in the array is parsed through a sorter method in the Parser class. The sorter first checks if an item 
begins with "@" and if it is followed by 1 to 14 valid characters of letters, numbers, or underscores. 
The word may optionally have a 15th character of any kind. If the word meets those requirements, 
all of the invalid characters are removed, particularly the initial @ symbol and an invalid character
at the end (to account for punctuation. Then the word is added to a particular array list for mentions.

If the word does not meet those requirements, the sorter then checks if the item begins with "#" and a valid character
(letters, numbers, or underscores) followed by 0 or more of any character to account for ending punctuation. 
If it meets these requirements, the initial # symbol is removed and the word is cut off when/if it reaches 
the first invalid character. For example, the word "#this.topic" will be shortened to "this". The word is 
similarly added it to a particular array list for topics.

If the word has not been filtered out with a @ or # symbol, the sorter checks if the word contains 
at least one dot that is not at the beginning or end of the word. If it does, the word is sent to a verifyURL
method to check if the syntax represents a URL. If the word passes both of these checks, it is added
to a particular array list for URLs.

Once the sorter has finished placing a word (or not placing one if it doesn't meet the criteria), 3 key-value 
pairs are added to a HashMap: "mentions" and the mentions array list, "topics" and the topics array list, and "URLs"
and the URLs array list.

The functionality of the program can be seen in the ReaderTest, which makes sure the original string is
correctly separated into words, and the ParserTest, which makes sure the parsed HashMap sorts the words correctly.

## Testing ##

Navigate to:

    twitter-msg-engine/

Run:

    gradle test

JUnit tests main method is found in src/test/java/tester/TestRunner


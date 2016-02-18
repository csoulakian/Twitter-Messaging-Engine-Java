package twitter;

import java.util.Scanner;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 2/11/2016
 */
public class Main {

    public static void main(String []args) {
        String input = "";
        System.out.println("Enter the tweet to be analyzed: ");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            input += scanner.nextLine();
        }
        scanner.close();

        Reader r = new Reader(input);
        Parser p = new Parser(r.list);
        System.out.print(p.parsedMap);
    }

}
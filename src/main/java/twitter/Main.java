package twitter;

import java.util.Arrays;

/**
 * Chrissy Soulakian
 * twitter-msg-engine Project
 * Created on 1/31/2016
 */

public class Main {

    public static void main(String []args) {
        Reader r = new Reader();
        if (r.list != null) {
            //Parser p = new Parser(r.list);
            //System.out.print(p.map);
            System.out.print(Arrays.toString(r.list));
        }
    }

}

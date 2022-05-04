//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package helpers;

public class OutputHelper {
    public OutputHelper() {
    }

    public static final String repeat(String character, int times) {
        String theText = "";

        for(int num = 0; num < times; ++num) {
            theText = theText + character;
        }

        return theText;
    }
}

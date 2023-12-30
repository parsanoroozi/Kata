package keta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Kata7 {

    public static boolean validatePin(String pin) {
        String digits = pin.replaceAll("\\D+","");
        if ((digits.length() == 4 || digits.length() == 6) && digits.length() == pin.length()) return true;
        else return false;
    }
    public static String binaryAddition(int a, int b){
        int c = a + b;
        String binary = "";
        while (c > 0) {
            binary += Integer.toString(c%2);
            c /= 2;
        }
        return new StringBuilder(binary).reverse().toString();
    }
    public static String spinWords(String sentence) {
        String words [] = sentence.split(" ");
        String output = "";
        for(String word: words){
            if(word.length() > 4){
                StringBuilder sb =new StringBuilder(word);
                sb.reverse();
                output += sb.toString() + " ";
            }else{
                output += word + " ";
            }
        }
        return output.substring(0, output.length()-1);
    }
    public static int find(int[] integers) {
        int numOfOdds = 0;
        int numOfEvens = 0;
        int even = 0;
        int odd = 1;
        for (int i : integers){
            if (i % 2 == 0) {
                numOfEvens += 1;
                even = i;
            } else {
                numOfOdds += 1;
                odd = i;
            }
            if (numOfOdds > 1 && numOfEvens > 0) return even;
            if (numOfEvens > 1 && numOfOdds > 0) return odd;
        }
        return 0;
    }
    public static int findShort(String s) {
        String words[] = s.split(" ");
        int min = 100;
        for (String word : words){
            if (word.length() < min) min = word.length();
        }
        return min;
    }
}

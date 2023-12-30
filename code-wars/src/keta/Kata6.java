package keta;

import java.util.*;

public class Kata6 {
    public static String[] wave(String str) {
        List<String> list = new ArrayList<>();
        String src = str.toLowerCase();
        for (int i = 0; i< str.length(); i++){
            if (str.charAt(i) != ' '){
                String word = str.substring(0, i) + Character.toString(str.charAt(i)).toUpperCase().charAt(0) + str.substring(i+1);
                list.add(word);
            }
        }
        return list.toArray(new String [list.size()]);
    }
    public static String expandedForm(int num) {
        String output = "";
        String c = "";
        while(num > 0){

            int n = num%10;
            num /= 10;
            if(n!= 0) output = " + " + n + c + output;
            c+= "0";
        }
        return output.substring(3, output.length());
    }
    public static int digital_root(int n) {
        int s = n;
        while (Integer.toString(s).length() > 1){
            s = 0;
            while(n > 0){
                s += n%10;
                n /= 10;
            }
            n = s;
        }
        return s;
    }
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            int formerCount = 0;
            if(dict.get(str.charAt(i)) != null) formerCount = dict.get(str.charAt(i));
            dict.put(str.charAt(i), formerCount + 1);
        }
        return dict;
    }
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < numbers.length; i++){
            dict.put(numbers[i],i);
        }
        for (int i = 0 ; i < numbers.length ; i++){
            int toBeFind = target - numbers[i];
            if (dict.get(toBeFind) != null && dict.get(toBeFind) != i){
                int index = dict.get(toBeFind);
                int output [] = {i, index};
                return output;
            }
        }
        return null;
    }
    public static String order(String words) {
        if (words == "") return "";
        String wordsArr [] = words.split(" ");
        Map<Integer , String> dict = new HashMap<>();
        TreeMap<Integer, String> sorted = new TreeMap<>();
        for (String word : wordsArr){
            int num = Integer.parseInt(word.replaceAll("\\D+",""));
            dict.put(num, word);
        }
        sorted.putAll(dict);
        String output = sorted.values().toString().replaceAll(",","");
        return output.substring(1,output.length()-1);
    }
}

import keta.Kata5;
import keta.Kata6;
import keta.Kata7;
import keta.kata3.ScreenLock;
import keta.kata4.Boggle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        ScreenLock p = new ScreenLock();
        System.out.println(p.calculateCombinations('E',4));
//        final char[][] board = {
//                {'E','A','R','A'},
//                {'N','L','E','C'},
//                {'I','A','I','S'},
//                {'B','Y','O','R'}
//        };
////        expecteds = {         true, true, false, true,    true,               false,    false };
//        final String[] words = {"C", "EAR","EARS","BAILER","RSCAREIOYBAILNEA" ,"CEREAL" ,"ROBES"};
//        Arrays.stream(words).sequential().forEach(word -> {
//            Boggle boggle = new Boggle(board, word);
//            System.out.println(boggle.check());
//        });
    }
}
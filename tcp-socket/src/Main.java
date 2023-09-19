import keta.Kata5;
import keta.Kata6;
import keta.Kata7;
import keta.kata4.Boggle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        final char[][] board = {
                {'E','A','R','A'},
                {'N','L','E','C'},
                {'I','A','I','S'},
                {'B','Y','O','R'}
        };
        final String[] words = {"C", "EAR","EARS","BAILER","RSCAREIOYBAILNEA" ,"CEREAL" ,"ROBES"};
        Arrays.stream(words).sequential().forEach(word -> {
            Boggle boggle = new Boggle(board, word);
            System.out.println(boggle.check());
        });
    }
}
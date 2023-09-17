import keta.Kata5;
import keta.Kata6;
import keta.Kata7;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Im in my personal computer");

        String a = "..WW......W..W.W.\n" +
                "W..W.....W....W..\n" +
                ".....WWW..WW..W.W\n" +
                "...WW.....WW.W.W.\n" +
                "..WW.W..W........\n" +
                "W.WW.WWW...W...WW\n" +
                "...W.WW...WW.W...\n" +
                "W.W..W..W.W....W.\n" +
                "....WW...W....W..\n" +
                "W......W..WW..W..\n" +
                "W..W........W.W.W\n" +
                "...WWW....W..W...\n" +
                ".W....WWWW.WW..W.\n" +
                "...WW.WW.W..W...W\n" +
                ".W......WW..W....\n" +
                "WW...W..W..W...WW\n" +
                ".........W.W.W...";
        boolean res  = Kata5.pathFinder(a);
        System.out.println("res : " + res);
//        for (int i = 0; i < 100; i++){
//            int res = Kata5.dblLinear(14021 + i);
//            System.out.println("n is : " + (14021+i) + " and res("+i+") is : " + res);
//        }


    }
}
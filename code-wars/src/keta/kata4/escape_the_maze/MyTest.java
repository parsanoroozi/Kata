package escape_the_maze;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class MyTest {
    public static void main(String[] args) {

//        int item = 4;
//        List<Character> res = Maze.escape(basicMazes.get(item));
//        System.out.println(res);
//        Walker.walk(basicMazes.get(item), res);


        for (char[][] maze : basicMazes){
            System.out.println();
            List<Character> result = Maze.escape(maze);
            System.out.println(result);
            Walker.walk(maze, result);
        }
    }

    private static final List<char[][]>
            basicMazes = new ArrayList<>(),
            yourTests  = new ArrayList<>();      // You can add your own tests in there, if you want, modifying buildTests(), for example
    static { buildTests(); }

    private static void buildTests() {

        basicMazes.add(new char[][] {
                "# #".toCharArray(),
                " > ".toCharArray(),
                "# #".toCharArray()
        });
        basicMazes.add(new char[][] {
                "###########".toCharArray(),
                "#>        #".toCharArray(),
                "######### #".toCharArray()
        });
        basicMazes.add(new char[][] {
                "# #########".toCharArray(),
                "#        >#".toCharArray(),
                "###########".toCharArray()
        });
        basicMazes.add(new char[][] {
                "####### #".toCharArray(),
                "#>#   # #".toCharArray(),
                "#   #   #".toCharArray(),
                "#########".toCharArray()
        });
        basicMazes.add(new char[][] {
                "##########".toCharArray(),
                "#        #".toCharArray(),
                "#  ##### #".toCharArray(),
                "#  #   # #".toCharArray(),
                "#  #^# # #".toCharArray(),
                "#  ### # #".toCharArray(),
                "#      # #".toCharArray(),
                "######## #".toCharArray()
        });
        basicMazes.add(new char[][] {
                "#########################################".toCharArray(),
                "#<    #       #     #         # #   #   #".toCharArray(),
                "##### # ##### # ### # # ##### # # # ### #".toCharArray(),
                "# #   #   #   #   #   # #     #   #   # #".toCharArray(),
                "# # # ### # ########### # ####### # # # #".toCharArray(),
                "#   #   # # #       #   # #   #   # #   #".toCharArray(),
                "####### # # # ##### # ### # # # #########".toCharArray(),
                "#   #     # #     # #   #   # # #       #".toCharArray(),
                "# # ####### ### ### ##### ### # ####### #".toCharArray(),
                "# #             #   #     #   #   #   # #".toCharArray(),
                "# ############### ### ##### ##### # # # #".toCharArray(),
                "#               #     #   #   #   # #   #".toCharArray(),
                "##### ####### # ######### # # # ### #####".toCharArray(),
                "#   # #   #   # #         # # # #       #".toCharArray(),
                "# # # # # # ### # # ####### # # ### ### #".toCharArray(),
                "# # #   # # #     #   #     # #     #   #".toCharArray(),
                "# # ##### # # ####### # ##### ####### # #".toCharArray(),
                "# #     # # # #   # # #     # #       # #".toCharArray(),
                "# ##### ### # ### # # ##### # # ### ### #".toCharArray(),
                "#     #     #     #   #     #   #   #    ".toCharArray(),
                "#########################################".toCharArray()
        });
    }
}

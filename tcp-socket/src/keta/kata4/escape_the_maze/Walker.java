package escape_the_maze;

import javax.swing.plaf.IconUIResource;
import java.util.List;

public class Walker {
    public static void walk(char[][] maze, List<Character> path) {

        int y = 0;
        int x = 0;
        int rootY = 0;
        int rootX = 0;
        outer:
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
//                System.out.println("maze[" + i + "][" + j + "] :" + maze[i][j]);
                if (maze[i][j] == '<' || maze[i][j] == '>' || maze[i][j] == '^' || maze[i][j] == 'v') {
                    y = i;
                    x = j;
                    rootY = y;
                    rootX = x;
                    break outer;
                }
            }
        }

        char direction = maze[y][x];
        int index = 0;
        for (char move : path) {
//            index++;
//            System.out.println(index);
//            for (char[] row : maze) {
//                for (char c : row) System.out.print(c);
//                System.out.println();
//            }
//            System.out.println("HEAD=====move: " + move + " direction: " + direction + "maze[" + y + "][" + x + "]");
            switch (direction) {
                case '>' -> {
//                    System.out.println("move: " + move + " direction: " + direction + "maze[" + y + "][" + x + "]");
                    switch (move) {
                        case 'F' -> {
                            x = x + 1;
                            maze[y][x] = direction;
                        }
                        case 'B' -> direction = '<';
                        case 'R' -> direction = 'v';
                        case 'L' -> direction = '^';
                        default -> {
                        }
                    }
                }
                case '<' -> {
//                    System.out.println("move: " + move + " direction: " + direction + "maze[" + y + "][" + x + "]");
                    switch (move) {
                        case 'F' -> {
                            x = x - 1;
                            maze[y][x] = direction;
                        }
                        case 'B' -> direction = '>';
                        case 'R' -> direction = '^';
                        case 'L' -> direction = 'v';
                        default -> {
                        }
                    }
                }
                case '^' -> {
//                    System.out.println("move: " + move + " direction: " + direction + "maze[" + y + "][" + x + "]");
                    switch (move) {
                        case 'F' -> {
                            y = y - 1;
                            maze[y][x] = direction;
                        }
                        case 'B' -> direction = 'v';
                        case 'R' -> direction = '>';
                        case 'L' -> direction = '<';
                        default -> {
                        }
                    }
                }
                case 'v' -> {
//                    System.out.println("move: " + move + " direction: " + direction + "maze[" + y + "][" + x + "]");
                    switch (move) {
                        case 'F' -> {
                            y = y + 1;
                            maze[y][x] = direction;
                        }
                        case 'B' -> direction = '^';
                        case 'R' -> direction = '<';
                        case 'L' -> direction = '>';
                        default -> {
                        }
                    }
                }
                default -> {
                }
            }
        }

        maze[rootY][rootX] = 's';
        for (char[] row : maze) {
            for (char c : row) System.out.print(c);
            System.out.println();
        }

    }
}

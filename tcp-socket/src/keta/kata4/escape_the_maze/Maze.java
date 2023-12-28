package escape_the_maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze {

    public static List<Character> escape(char[][] maze) {
        // if the whole array is just a kate:
        if (maze.length == 1 && maze[0].length == 1
                && (maze[0][0] == '<' || maze[0][0] == '>' || maze[0][0] == '^' || maze[0][0] == 'v'))
            return new ArrayList<>();

        // generating graph
        Cell you = null;
        List<Cell> graph = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] != '#') {
                    graph.add(new Cell(
                            j // x position
                            , i // y position
                            , (i == 0
                            || j == 0
                            || i == maze.length - 1
                            || j == maze[i].length - 1)// isEdge
                            , (maze[i][j] == '<' || maze[i][j] == '>' || maze[i][j] == '^' || maze[i][j] == 'v')) // isYou
                    );
                    if (maze[i][j] == '<' || maze[i][j] == '>' || maze[i][j] == '^' || maze[i][j] == 'v') {
                        you = graph.get(graph.size() - 1);
                        you.direction = maze[i][j];
                    }
                    visited.add(false);
                }
            }
        }

//        // there can't be more than one kate:
//        if (graph.stream().filter(c -> c.isYou).count() > 1) throw new RuntimeException();

        // adding neighbours:
        for (Cell c : graph) {
            for (Cell o : graph) {
                if ((c.x == o.x && Math.abs(c.y - o.y) == 1) || (c.y == o.y && Math.abs(c.x - o.x) == 1)) c.adj.add(o);
            }
        }


        //dfs:
        Stack<Cell> stack = new Stack<>();
        stack.push(you);
        while (!stack.isEmpty()) {
            Cell cell = stack.pop();
            if (!visited.get(graph.indexOf(cell))) visited.set(graph.indexOf(cell), true);
            for (Cell n : cell.adj) {
                if (!(visited.get(graph.indexOf(n)))) {
                    n.moves.clear();
                    n.moves.addAll(cell.moves);
                    switch (cell.direction) {
                        case '<' -> {
                            n.direction = '<';
                            if (cell.x - n.x == -1) {
                                n.moves.add('B');
                                n.direction = '>';
                            }
                            if (cell.y - n.y == 1) {
                                n.moves.add('R');
                                n.direction = '^';
                            }
                            if (cell.y - n.y == -1) {
                                n.moves.add('L');
                                n.direction = 'v';
                            }
                            n.moves.add('F');
                        }
                        case '>' -> {
                            n.direction = '>';
                            if (cell.x - n.x == 1) {
                                n.moves.add('B');
                                n.direction = '<';
                            }
                            if (cell.y - n.y == 1) {
                                n.moves.add('L');
                                n.direction = '^';
                            }
                            if (cell.y - n.y == -1) {
                                n.moves.add('R');
                                n.direction = 'v';
                            }
                            n.moves.add('F');
                        }
                        case '^' -> {
                            n.direction = '^';
                            if (cell.x - n.x == 1) {
                                n.moves.add('L');
                                n.direction = '<';
                            }
                            if (cell.x - n.x == -1) {
                                n.moves.add('R');
                                n.direction = '>';
                            }
                            if (cell.y - n.y == -1) {
                                n.moves.add('B');
                                n.direction = 'v';
                            }
                            n.moves.add('F');
                        }
                        case 'v' -> {
                            n.direction = 'v';
                            if (cell.x - n.x == 1) {
                                n.moves.add('R');
                                n.direction = '<';
                            }
                            if (cell.x - n.x == -1) {
                                n.moves.add('L');
                                n.direction = '>';
                            }
                            if (cell.y - n.y == 1) {
                                n.moves.add('B');
                                n.direction = '^';
                            }
                            n.moves.add('F');
                        }
                        default -> {
                        }
                        // nothing
                    }
                    stack.push(n);
                }
                if (n.isEdge) return n.moves;
            }
        }
        return new ArrayList<>();
    }

    private static class Cell {

        public List<Character> moves;
        public final List<Cell> adj;
        private final int x;
        private final int y;
        private final boolean isEdge;
        private final boolean isYou;
        public char direction = ' ';

        public Cell(int x, int y, boolean isEdge, boolean isYou) {
            this.moves = new ArrayList<>();
            this.adj = new ArrayList<>();
            this.x = x;
            this.y = y;
            this.isEdge = isEdge;
            this.isYou = isYou;
        }
    }
}
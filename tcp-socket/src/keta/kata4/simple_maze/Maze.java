package simple_maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Maze {
    public static boolean hasExit(String[] maze) {

        // if the whole array is just a kate:
        if(maze.length==1 && maze[0].length()==1 && maze[0].toCharArray()[0]=='k') return true;

        // generating graph
        Cell kate = null;
        List<Cell> graph = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                if (maze[i].toCharArray()[j] != '#'){
                    graph.add(new Cell(
                            i // x position
                            , j // y position
                            , ( i == 0
                                || j == 0
                                || i == maze.length - 1
                                || j == maze[i].length()-1
                                || j >= maze[i-1].length()
                                || j >= maze[i+1].length()) // isEdge
                            , maze[i].toCharArray()[j] == 'k') // isKate
                    );
                    if(maze[i].toCharArray()[j] == 'k') kate = graph.get(graph.size()-1);
                    visited.add(false);
                }
            }
        }

        // there can't be more than one kate:
        if(graph.stream().filter(c -> c.isKate).count()>1) throw new RuntimeException();

        // adding neighbours:
        for(Cell c: graph){
            for(Cell o: graph){
                if((c.x == o.x && Math.abs(c.y-o.y)==1) || (c.y == o.y && Math.abs(c.x-o.x)==1)) c.adj.add(o);
            }
        }

        //dfs:
        Stack<Cell> stack = new Stack<>();
        stack.push(kate);
        while (!stack.isEmpty()){
            Cell cell = stack.pop();
            if(!visited.get(graph.indexOf(cell))) visited.set(graph.indexOf(cell), true);
            for(Cell n: cell.adj){
                if(n.isEdge) return true;
                if(!(visited.get(graph.indexOf(n)))) stack.push(n);
            }
        }
        return false;
    }

    private static class Cell {
        public final List<Cell> adj;
        private final int x;
        private final int y;
        private final boolean isEdge;
        private final boolean isKate;
        public Cell(int x, int y, boolean isEdge, boolean isKate) {
            this.adj = new ArrayList<>();
            this.x = x;
            this.y = y;
            this.isEdge = isEdge;
            this.isKate = isKate;
        }
    }
}
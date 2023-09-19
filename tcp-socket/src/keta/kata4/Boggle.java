package keta.kata4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boggle {

    private class MapItem{
        private int x;
        private int y;
        private int i;
        public MapItem(int x, int y, int i){
            this.x = x;
            this.y = y;
            this.i = i;
        }
    }

    private final char[][] board;
    private final String word;
    private Queue<MapItem> queue = new LinkedList<>();
    private boolean[][] visited;
    public Boggle(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public boolean check() {
        // empty word
        if (word.isEmpty()) return false;
        // finding first letter
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(word.length() == 1) return true;
                    queue.add(new MapItem(i,j,0));
                }
            }
        }
        // main implementation
        while (!queue.isEmpty()){
            MapItem item = queue.poll();
            visited[item.x][item.y] = true;
            // top-left
            if(item.x - 1 > 0 && item.y -1 > -1){
                if(board[item.x-1][item.y-1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x - 1, item.y - 1, item.i + 1));
                }
            }
            // top
            if(item.x - 1 > 0){
                if(board[item.x-1][item.y] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x - 1, item.y, item.i + 1));
                }
            }
            // top-right
            if(item.x - 1 > 0 && item.y +1 < board.length){
                if(board[item.x-1][item.y+1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x - 1, item.y + 1, item.i + 1));
                }
            }
            // right
            if(item.y +1 < board.length){
                if(board[item.x][item.y+1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x, item.y + 1, item.i + 1));
                }
            }
            // bottom-right
            if(item.x + 1 < board.length && item.y +1 > board.length){
                if(board[item.x+1][item.y+1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x + 1, item.y + 1, item.i + 1));
                }
            }
            // bottom
            if(item.x + 1 < board.length){
                if(board[item.x+1][item.y] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x + 1, item.y, item.i + 1));
                }
            }
            // bottom-left
            if(item.x + 1 < board.length && item.y -1 > -1){
                if(board[item.x+1][item.y-1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x + 1, item.y - 1, item.i + 1));
                }
            }
            // left
            if(item.y -1 > -1){
                if(board[item.x][item.y-1] == word.charAt(item.i+1)){
                    if(item.i+1== board.length-1) return true;
                    queue.add(new MapItem(item.x, item.y - 1, item.i + 1));
                }
            }



        }
        return false;
    }
}

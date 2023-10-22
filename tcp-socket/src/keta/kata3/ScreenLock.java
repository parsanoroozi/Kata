package keta.kata3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScreenLock {
    private int patternsCount = 0;
    private  int patternLength = 0;
    private int[][] adj = new int[][]{
            {0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 1, 1, 0, 1, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 0, 1, 1, 1},
            {0, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 1, 0, 1, 0}};
    private boolean[] visited = new boolean[9];
    private final Map<Character, Integer> nodeNames = new HashMap<>();
    public int calculateCombinations(char startPosition, int patternLength){
        System.out.println("start:"+startPosition+ " and length: "+ patternLength);
        patternsCount = 0;
        visited = new boolean[9];
        adj = new int[][]{
                {0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0, 1, 1, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 0}};
        nodeNames.put('A',0);
        nodeNames.put('B',1);
        nodeNames.put('C',2);
        nodeNames.put('D',3);
        nodeNames.put('E',4);
        nodeNames.put('F',5);
        nodeNames.put('G',6);
        nodeNames.put('H',7);
        nodeNames.put('I',8);
        if(patternLength==0)return 0;
        if(patternLength==1)return 1;
        this.patternLength = patternLength;
        dfs(nodeNames.get(startPosition), visited.clone(),adj.clone(), 1);
        return patternsCount;
    }


    private void dfs(int node, boolean[] dfsVisited, int[][]  dfsAdj , int depth){
        dfsVisited[node] = true;
//        System.out.println("///////////////////////////////////////////////the node is " + node);
//        for(boolean visited :dfsVisited) System.out.print(visited + " ");
//        System.out.println();
        switch (node) {
            case 1 -> {
//                System.out.println("here B");
                dfsAdj[0][2] = 1;
                dfsAdj[2][0] = 1;
            }
            case 3 -> {
//                System.out.println("here D");
                dfsAdj[0][6] = 1;
                dfsAdj[6][0] = 1;
            }
            case 4 -> {
//                System.out.println("here E");
                dfsAdj[0][8] = 1;
                dfsAdj[8][0] = 1;
                dfsAdj[1][7] = 1;
                dfsAdj[7][1] = 1;
                dfsAdj[2][6] = 1;
                dfsAdj[6][2] = 1;
                dfsAdj[3][5] = 1;
                dfsAdj[5][3] = 1;
            }
            case 5 -> {
//                System.out.println("here F");
                dfsAdj[2][8] = 1;
                dfsAdj[8][2] = 1;
            }
            case 7 -> {
//                System.out.println("here H");
                dfsAdj[6][8] = 1;
                dfsAdj[8][6] = 1;
            }
            default -> {
            }
        }
        for(int neighbour=0; neighbour < dfsAdj[node].length; neighbour++){
            if(dfsAdj[node][neighbour]==1){
//                System.out.println("array:");
//                for(int[] list :dfsAdj){
//                    for (int i : list)
//                        System.out.print(i);
//                    System.out.println();
//                }
//                System.out.println();
//                System.out.println("outside if for neighbour " + neighbour);
//                for(boolean visited :dfsVisited) System.out.print(visited + " ");
//                System.out.println();
                if (!dfsVisited[neighbour]){
//                    System.out.println("inside if");
//                    for(boolean visited :dfsVisited) System.out.print(visited + " ");
//                    System.out.println();
//                    System.out.println("the neighbour " + neighbour);
//                    System.out.println("the dfsVisited[neighbour] "+ dfsVisited[neighbour]);
                    if(depth+1 == this.patternLength) {
                        this.patternsCount++;
                    }
                    else dfs(neighbour, dfsVisited.clone(), dfsAdj.clone(),depth+1);
                }
            }
        }
    }
}
/**
 * 012
 * 345
 * 678
 * */

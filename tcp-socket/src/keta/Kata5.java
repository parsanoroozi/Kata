package keta;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Kata5 {
    public static boolean pathFinder(String maze) {
            // initializing map:
            String[] rows = maze.split("\n");
            List<List<Character>> map = new ArrayList<>();
            Arrays.stream(rows).forEach(line -> {
                List<Character> row = new ArrayList<>();
                for (int i = 0; i< line.length(); i++) row.add(line.charAt(i));
                map.add(row);
            });
            if(rows.length==1 && map.get(0).get(0)=='.') return true;
            // visited array
            boolean[][] visited = new boolean[rows.length][rows.length];
            for (int i = 0; i < rows.length; i++) {
                for (int j = 0; j < rows.length; j++) {
                    visited[i][j] = false;
                }
            }
            // applying dfs
            Stack<Integer[]> stack = new Stack<>();
            stack.push(new Integer[]{0,0});
            while (!stack.isEmpty()){
                Integer[] item = stack.pop();
                int x = item[0];
                int y = item[1];
                //EAST
                if(y< rows.length-1 && !visited[x][y+1] && map.get(x).get(y+1) != 'W'){
                    if(x==rows.length-1 && y+1==rows.length-1) return true;
                    visited[x][y+1]=true;
                    stack.push(new Integer[]{x,y+1});
                }
                //WEST
                if(y > 0 && !visited[x][y-1] && map.get(x).get(y-1) != 'W'){
                    if(x==rows.length-1 && y-1==rows.length-1) return true;
                    visited[x][y-1]=true;
                    stack.push(new Integer[]{x,y-1});
                }
                //SOUTH
                if(x< rows.length-1 && !visited[x+1][y] && map.get(x+1).get(y) != 'W'){
                    if(x+1==rows.length-1 && y==rows.length-1) return true;
                    visited[x+1][y]=true;
                    stack.push(new Integer[]{x+1,y});
                }
                //NORTH
                if(x>0 && !visited[x-1][y] && map.get(x-1).get(y) != 'W'){
                    if(x-1==rows.length-1 && y==rows.length-1) return true;
                    visited[x-1][y]=true;
                    stack.push(new Integer[]{x-1,y});
                }
            }
            return false;
        }
    public static List<String> top3(String s) {
        SortedMap<String,Integer> dict = new TreeMap<>();
        String[] list = s.toLowerCase().split("[\\s\\p{P}&&[^']]+");
        Arrays.stream(list)
                .filter(x -> (!Objects.equals(x, "") && !x.replace("'","").isEmpty()))
                .forEach(x -> dict.put(x, dict.get(x)==null? 1 : dict.get(x)+1));

        if(dict.isEmpty()) return new ArrayList<>();

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(dict.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue));
        List<String> output = new ArrayList<>(entryList.stream().map(x->x.toString().split("=")[0]).toList());
        Collections.reverse(output);
        return output.stream().limit(3).toList();
    }
    public static int dblLinear(int n) {
        if (n == 0) return 1;
        SortedSet<Integer> u = new TreeSet<>();
        u.add(1);
        for (int i = 0; i < n; i++) {
            int x = u.first();
            u.add(x * 2 + 1);
            u.add(x * 3 + 1);
            u.remove(x);
        }
        return u.first();
    }
    public static int[] isPerfectPower(int n) {
        if (n == 1 || n ==2 || n == 3) return null;
        int limit = (int)Math.sqrt(n);

        int base = 2;
        int power = 2;
        while (base <= limit){
            power = 2;
            while(Math.pow((double)base,(double)power) <= (double)n){
                if (Math.pow((double)base,(double)power) == (double)n) return new int[]{base, power};
                power++;
            }
            base++;
        }
        return null;
    }
    public static String rot13(String message) {
        String output = "";
        for (int i = 0 ; i< message.length(); i++){
            int assci = message.charAt(i);
            if (assci >= 65 && assci <= 90){
                assci = 65 + (assci-65+13)%26;
            }else if (assci >= 97 && assci <= 122){
                assci = 97 + (assci-97+13)%26;
            }
            output += (char)assci;
        }
        return output;
    }

}

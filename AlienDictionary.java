package DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"abc","ab"};
        System.out.println(findOrder(words));
    }
    public static String findOrder(String[] words) {

        int[] inDegree = new int[26];
        Arrays.fill(inDegree,-1);
        ArrayList<ArrayList<Integer>> edges = getEdges(words , inDegree);
        if(edges==null){
            return "";
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();


        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.size(); i++) {
            adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            inDegree[edges.get(i).get(0)]=0;
            inDegree[edges.get(i).get(1)]=0;
        }

        for (int i = 0; i < edges.size(); i++) {
            inDegree[edges.get(i).get(1)]++;
        }

        int len = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0){
                queue.offer(i);
            }
            if(inDegree[i]!=-1){
                len++;
            }
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            sb.append((char) ('a'+ node));
            for(int e : adjList.get(node)){
                inDegree[e]--;
                if(inDegree[e]==0){
                    queue.offer(e);
                }
            }
        }

        if(len!=sb.length()){
            return "";
        }

        return String.valueOf(sb);
    }

    private static ArrayList<ArrayList<Integer>> getEdges(String[] words, int[] inDegree) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < words.length-1; i++) {
            boolean check = true;
            for (int j = 0; j < words[i].length(); j++) {

                inDegree[words[i].charAt(j) - 'a'] = 0;
                if(j>=words[i+1].length()){
                    for (int k = j; k < words[i].length(); k++) {
                        inDegree[words[i].charAt(k) - 'a'] = 0;
                    }
                    break;
                }
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(words[i].charAt(j) - 'a');
                    list.add(words[i+1].charAt(j)-'a');
                    edges.add(list);
                    for (int k = j+1; k < words[i].length(); k++) {
                        inDegree[words[i].charAt(k) - 'a'] = 0;
                    }
                    check=false;
                    break;
                }
            }
            if (check && words[i].length()>words[i+1].length()){
                return null;
            }
        }
        for (int k = 0; k < words[words.length-1].length(); k++) {
            inDegree[words[words.length-1].charAt(k) - 'a'] = 0;
        }
        return edges;
    }

}

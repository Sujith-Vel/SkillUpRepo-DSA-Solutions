package DSA.Graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] str = {"hot","dot","dog","lot","log","cog"};
        ArrayList<String> wordList = new ArrayList<>(List.of(str));
     //   System.out.println(ladderLength("hit", "cog" , wordList));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(11);
        queue.offer(4);
        queue.offer(7);
        queue.offer(16);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());

        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord + '-' + 1);

        set.remove(beginWord);

        while (!queue.isEmpty()){
            String[] word  = queue.poll().split("-");
            if(word[0].equals(endWord)){
                return Integer.parseInt(word[1]);
            }
            StringBuilder sb = new StringBuilder().append(word[0]);
            for(int i =0;i<word[0].length();i++){
                for (int j = 0; j < 26; j++) {
                    String val = String.valueOf(sb.replace(i,i+1,""+(char) ('a' + j)));

                   if(set.contains(val) && !val.equals(word[0])){
                       int a = Integer.parseInt(word[1])+1;
                       queue.offer(val+'-'+ a);
                       set.remove(val);
                   }
                }
                sb = new StringBuilder().append(word[0]);
            }

        }
        return 0;
    }


    public static int ladderLengthOpt(String beginWord, String endWord, List<String> wordList) {


        HashSet<StringBuilder> set = new HashSet<>();

        for (String str : wordList){
            set.add(new StringBuilder().append(str));
        }

//        if(){
//            return 0;
//        }

        Queue<WordCount> queue = new LinkedList<>();
        queue.offer(new WordCount(new StringBuilder().append(beginWord),1));

        set.remove(new StringBuilder().append(beginWord));

        while (!queue.isEmpty()){
            if(queue.peek().word.compareTo(new StringBuilder().append(endWord)) == 0){
                return queue.peek().count;
            }
            WordCount wc = queue.poll();
            StringBuilder sb = wc.word;

            for(int i =0;i<sb.length();i++){
                for (int j = 0; j < 26; j++) {

                    StringBuilder val = sb.replace(i,i+1,""+(char) ('a' + j));

                    if (set.contains(val) ){
                            int a = wc.count + 1;
                            queue.offer(new WordCount(val, a));
                            set.remove(val);
                        }
                }
                sb = new StringBuilder().append(wc.word);
            }

        }
        return 0;
    }

    public static class WordCount{

        public WordCount(StringBuilder word , int count){
            this.word = word;
            this.count = count;
        }


        StringBuilder word;
        int count;
    }

}



package DSA.Graph;

public class IsGraphBipartite {
    public static void main(String[] args) {

        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};

        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {

        int[] visited = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]==0){
                if(!dfs(i,1,visited,graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int i, int color, int[] visited, int[][] graph) {

        visited[i] = color;
        for (int j = 0; j < graph[i].length; j++) {
            if(visited[graph[i][j]]==color){
                return false;
            }else if(visited[graph[i][j]]==0){
                if(!dfs(graph[i][j],color==1?2:1,visited,graph)){
                    return false;
                }
            }
        }

        return true;
    }

}

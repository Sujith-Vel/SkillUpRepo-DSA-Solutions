package DSA.RecursionAndBT;

public class BackTrackingEx {
    public static void main(String[] args) {

        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
       bck("",maze,0,0);
    }

    public static void bck(String p ,boolean[][] maze , int r , int c){

        // problem : Its  2D array Maze , We can go all the directions. i.e  Right , Left , Up and Down.
        // We need to find all the paths to reach the last box of maze. For example, if its a 3X3 matrix one of the paths -> RRDD


        // back tracking is used in this solution. Why because its going all the direction ,
        // so there is a possibilities that our program might run in infinite loop.

        // How we are implementing backtracking ?
        // 1. Simple add a boolean 2D matrix filled with true based on the given maze size in the method parameter.
        // 2. When you reach a box in the maze , mark the element false in the 2D matrix. So that we can avoid the infinite loop , it won't go to the same place again.
        // 3. After the recursion call we need to mark the element again true (Simply erasing the trace).
        // Why ? Then only it will not affect other recursive calls.

        if(!maze[r][c]){
            return; // If its false , return . (Why? already its went in this element , so infinite loop is avoided)
        }

        if(r== maze.length-1 && c==maze[0].length-1){ // This is the destination , We got the answer return it.
            System.out.println(p);
            return;
        }

        // Conditions to make sure , its not go to out of bound of array.
        if(c<maze[0].length-1){ // Right
            maze[r][c]=false; // Marking the trace.
            bck(p + "R" , maze,r,c+1); // Going towards Right.
            maze[r][c] = true; // Erasing the trace
        }

        if(r<maze.length-1){ // Down
            maze[r][c]=false;
            bck(p + "D" , maze,r+1,c);
            maze[r][c] = true;
        }

        if(c>0){ // Left
            maze[r][c]=false;
            bck(p + "L" , maze,r,c-1);
            maze[r][c] = true;
        }
        if(r>0){ // Up
            maze[r][c]=false;
            bck(p + "U" , maze,r-1,c);
            maze[r][c] = true;
        }
    }
}

package day27;

import java.util.ArrayList;

public class CourseSchedule_I {

    public static void main(String[] args) {
        int[][] dependency={{1,0},{2,0},{3,1},{3,2}};
        new CourseSchedule_I().canComplete(4,dependency);
    }
    public boolean canComplete(int courses, int[][]dependency)
    {
        //array of list to store dependent node on each node
        /* in this case
        * index     value(arraylist)
        * 0
        * 1          0
        * 2          0
        * 3          1,2
        *         */
        ArrayList<Integer>[] adjacents = new ArrayList[courses];
        for (int i=0;i<courses;++i)
            adjacents[i]= new ArrayList<>();

        for (int[] pre:dependency)
            adjacents[pre[0]].add(pre[1]);

        int visited[]=new int[courses];
        for (int i=0;i<courses;++i)
            /*0== unvisited
            1== being visited
            2== visited*/
            if(visited[i]==0 && !dfs(adjacents,visited, i)) return false;

        return true;
    }

    private boolean dfs(ArrayList<Integer>[] adjacents, int[] visited, int i) {
        //when node is being visited, just get off from call with cycle detection
        if (visited[i]==1) return false;
        //Mark as being visited
        visited[i]=1;
        for (int adj: adjacents[i])
           if(!dfs(adjacents,visited,adj)) return false;
        //Mark as visited
        visited[i]=2;
        return true;
    }
}

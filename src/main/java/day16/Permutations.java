package day16;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static List<List<Integer>> performDFS(int[] ip, List<List<Integer>> finalResult,List<Integer> currentResult, boolean[] visited)
    {
        if (currentResult.size()==ip.length)
        {
            finalResult.add(new ArrayList<>(currentResult));
            return finalResult;
        }
        for (int i=0;i<ip.length;i++)
        {
            if(!visited[i])
            {
                currentResult.add(ip[i]);
                visited[i]= true;
                performDFS(ip,finalResult,currentResult,visited);
                currentResult.remove(currentResult.size()-1);
                visited[i]=false;
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {

        List<List<Integer>> result= new ArrayList<>();
        performDFS(new int[]{1,2,3},result,new ArrayList<>(),new boolean[]{false,false,false});
    }

}

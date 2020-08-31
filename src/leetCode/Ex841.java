package leetCode;

import java.util.List;

public class Ex841 {
    private boolean[] visited;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);
        for (boolean i : visited) {
            if(!i){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int i){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        for (Integer j : rooms.get(i)){
            dfs(rooms, j);
        }
    }
}
package course;

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] table = new int[numCourses][numCourses];
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            table[prerequisites[i][0]][prerequisites[i][1]] = 1;
            degree[prerequisites[i][0]] += 1;
        }
        int[] res= new int[numCourses];
        int p = 0;
        int temp = helper(table, degree);
        while(temp!=-1){
            res[p++] = temp;
            degree[temp] = -1;
            for (int i = 0; i < table.length; i++) {
                if(table[i][temp]==1){
                    table[i][temp] = 0;
                    degree[i]--;
                }
            }
            temp = helper(table, degree);
        }

        if(p!=res.length){
            return new int[0];
        }
        return res;
    }

    private int helper(int[][] table, int[] degree){
        for (int i = 0; i < degree.length; i++) {
            if(degree[i]==0){
                return i;
            }
        }
        return -1;
    }
        
}
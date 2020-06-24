package course;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 1) {
            return true;
        }
        var table = new int[numCourses][numCourses];
        var entry = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            table[prerequisites[i][1]][prerequisites[i][0]] = 1;
            entry[prerequisites[i][1]] += 1;
        }
        while (isNotLoop(table, entry)) {
            numCourses--;
            if (numCourses == 1) {
                return true;
            }
        }
        return false;

    }

    private boolean isNotLoop(int[][] table, int[] entry) {
        for (int i = 0; i < table.length; i++) {
            if (entry[i] == -1) {
                continue;
            }
            if (entry[i] == 0) {
                for (int j = 0; j < table.length; j++) {
                    if (table[j][i] == 1) {
                        table[j][i] = 0;
                        entry[j] -= 1;
                    }
                }
                entry[i]=-1;
                return true;
            }
        }
        return false;
    }
}
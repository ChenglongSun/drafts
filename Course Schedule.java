class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0) inDegree[ready]++;
            matrix[pre][ready] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i); //???
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--inDegree[i] == 0) queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
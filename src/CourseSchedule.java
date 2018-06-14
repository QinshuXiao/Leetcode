import java.util.*;

/**
 * Created by qinshuxiao on 2018/6/13.
 */
public class CourseSchedule {

    public static void main(String[] args){
        CourseSchedule scheduler = new CourseSchedule();

        int numCourses = 2;
        int[][] pre = new int[][]{{1,0}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("T/F: "+scheduler.canFinish(numCourses, pre));

        numCourses = 2;
        pre = new int[][]{{1,0}, {0,1}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("T/F: "+scheduler.canFinish(numCourses, pre));

        numCourses = 4;
        pre = new int[][]{{1,0}, {2,1}, {3,2}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("T/F: "+scheduler.canFinish(numCourses, pre));

        numCourses = 4;
        pre = new int[][]{{1,0}, {2,1}, {3,2}, {0,3}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("T/F: "+scheduler.canFinish(numCourses, pre));
    }

    /**
     * Classical TopoLogical Sort.
     *
     * Firstly, transfer courses dependencies to a graph.
     * We always remove the node which has no in-edge.
     * And each time we move node, we move the out-edges attached with it as well.
     *
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; ++i){
            graph[i] = new ArrayList<Integer>();
            indegree[i] = 0;
        }

        for(int[] courses : prerequisites){
            graph[courses[1]].add(courses[0]);
            indegree[courses[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; ++i){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            Integer curCourse = q.poll();

            for(Integer nextCourse : graph[curCourse]){
                --indegree[nextCourse];
                if(indegree[nextCourse] == 0){
                    q.offer(nextCourse);
                }
            }

            --numCourses;
        }

        return numCourses == 0;
    }
}

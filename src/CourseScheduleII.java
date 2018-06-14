import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qinshuxiao on 2018/6/13.
 */
public class CourseScheduleII {

    public static void main(String[] args){
        CourseScheduleII scheduler = new CourseScheduleII();

        int numCourses = 2;
        int[][] pre = new int[][]{{1,0}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("Order: "+Arrays.toString(scheduler.findOrder(numCourses, pre)));

        numCourses = 2;
        pre = new int[][]{{1,0}, {0,1}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("Order: "+Arrays.toString(scheduler.findOrder(numCourses, pre)));

        numCourses = 4;
        pre = new int[][]{{1,0}, {2,1}, {3,2}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("Order: "+Arrays.toString(scheduler.findOrder(numCourses, pre)));

        numCourses = 4;
        pre = new int[][]{{1,0}, {2,1}, {3,2}, {0,3}};
        System.out.println("numCourses: "+numCourses+" pre: "+ Arrays.deepToString(pre));
        System.out.println("Order: "+Arrays.toString(scheduler.findOrder(numCourses, pre)));
    }

    /**
     *
     * Just like Course Schedule, Topo Sort
     *
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; ++i) graph[i] = new ArrayList<>();

        for(int[] pre : prerequisites){
            graph[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        int takenCourses = 0;

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
            res[takenCourses++] = curCourse;
        }

        if(takenCourses < numCourses) return new int[]{};
        else return res;
    }
}

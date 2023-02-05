package bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 1210. 穿过迷宫的最少移动次数
 * https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/
 * 困难
 * bfs,通过三维数组存储x,y,status
 * <p>
 * 把三维坍缩成二维
 */
public class MinimumMoves {


    public static void main(String[] args) {
        int[][] ints = new int[4][4];
        System.out.println(Arrays.deepToString(ints));
        Arrays.fill(ints[0], -1);
        System.out.println(Arrays.deepToString(ints));

        System.out.println();

        int[][][] arr2 = new int[3][3][3];
        System.out.println(Arrays.deepToString(arr2));
        Arrays.fill(arr2[1][1], -1);//arr2[1][1]是[1][1][num]从外向内的一个一维数组，fill要把这个一维数组填满，填的每一元素是一个数
        System.out.println(Arrays.deepToString(arr2));

        System.out.println();

        int[][][] arr3 = new int[4][4][4];
        System.out.println(Arrays.deepToString(arr3));
        Arrays.fill(arr3[0], new int[]{1, 2, 3});//arr3[0]是[0][n][n]从外向内的一个二维数组，fill要把这个二维数组填满，填的每一元素是一个一维数组
        System.out.println(Arrays.deepToString(arr3));
    }

    public int minimumMoves(int[][] grid) {
        int n = grid.length;

        //dist[x][y][status]的值代表到达当前状态(x，y的格子，状态为status)移动的次数
        //dist是类似于状态记录表
        int[][][] dist = new int[n][n][2];

        //给dist初始化赋值，每一个元素都赋值为-1
        //这里进行了降维，x代表行，y代表列
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(dist[x][y], -1);
            }
        }

        //以蛇尾作为移动坐标，初始化蛇尾状态，次数为0
        dist[0][0][0] = 0;

        //建立bfs队列,类型为int[]状态
        Queue<int[]> q = new ArrayDeque<>();
        //放入第一个蛇尾状态
        q.offer(new int[]{0, 0, 0});

        //bfs
        while (!q.isEmpty()) {
            //取出队头元素
            int[] arr = q.poll();
            //当前状态
            int x = arr[0], y = arr[1], status = arr[2];

            //当前状态判断
            if (status == 0) {//状态为水平方向
                //右，满足蛇头不越界，移动后蛇头格子无障碍，移动后的格子蛇尾没来过
                if (y + 2 < n && grid[x][y + 2] == 0 && dist[x][y + 1][0] == -1) {
                    //把移动后的蛇尾状态放入队列
                    q.offer(new int[]{x, y + 1, 0});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x][y + 1][0] = dist[x][y][0] + 1;
                }
                //下
                if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && dist[x + 1][y][0] == -1) {
                    //把移动后蛇尾状态放入队列
                    q.offer(new int[]{x + 1, y, 0});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x + 1][y][0] = dist[x][y][0] + 1;
                }
                //顺时针
                if (x + 1 < n && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0 && dist[x][y][1] == -1) {
                    //把移动后蛇尾状态放入队列
                    q.offer(new int[]{x, y, 1});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x][y][1] = dist[x][y][0] + 1;
                }
            } else {//状态为竖直方向
                //右
                if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && dist[x][y + 1][1] == -1) {
                    //把移动后的蛇尾状态放入队列
                    q.offer(new int[]{x, y + 1, 1});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x][y + 1][1] = dist[x][y][1] + 1;
                }
                //下
                if (x + 2 < n && grid[x + 2][y] == 0 && dist[x + 1][y][1] == -1) {
                    //把移动后的蛇尾状态放入队列
                    q.offer(new int[]{x + 1, y, 1});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x + 1][y][1] = dist[x][y][1] + 1;
                }
                //逆时针
                if (y + 1 < n && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0 && dist[x][y][0] == -1) {
                    //把移动后的蛇尾状态放入队列
                    q.offer(new int[]{x, y, 0});
                    //移动后的蛇尾状态的次数==当前蛇尾转态+1
                    dist[x][y][0] = dist[x][y][1] + 1;
                }
            }
        }
        //返回最终状态，如果到达了此状态，返回次数，没有，则返回-1;
        return dist[n - 1][n - 2][0];
    }
}

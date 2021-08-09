package com.bread.leetcode.notes.datastructures.recursion;

/**
 * @program: leet-code-notes
 * @description: 简易迷宫
 * @author: LiuTuo
 * @create: 2021-08-09 11:11
 **/
public class Maze {
    /**
     * 迷宫地图
     * 1表示墙体 2表示轨迹 3表示此点不通
     */
    public static int[][] map=new int[8][8];

    /**
     * 初始化地图,建造墙体
     */
    public Maze(){
        for (int i=0;i<8;i++){
            map[0][i]=1;
            map[i][0]=1;
            map[7][i]=1;
            map[i][7]=1;
        }
        map[3][1]=1;
        map[3][2]=1;
    }

    /**
     * 打印地图
     */
    public void show(){
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Maze maze=new Maze();
        maze.setWay(map,1,1);
        maze.show();

    }

    /**
     * 设置地图路径方法
     * @param map
     * @param i 横坐标
     * @param j 竖坐标
     * @return
     */
    public Boolean setWay(int[][] map,int i,int j){
        //判断是否已到达终点
        if(map[6][6]==2){
            return true;
        }

        if(map[i][j]==0){
            map[i][j]=2;
            if(setWay(map,i+1,j)){//向右移动
                return true;
            }else if(setWay(map,i,j+1)){//向下移动
                return true;
            }else if(setWay(map,i-1,j)){//向左移动
                return true;
            }else if(setWay(map,i,j+1)){//向上移动
                return true;
            }else{
                map[i][j]=3;
                return false;
            }
        }else{
            return false;
        }
    }
}

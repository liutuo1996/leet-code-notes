package com.bread.leetcode.notes.datastructures;

/**
 * @program: leet-code-notes
 * @description: 稀疏数组
 *               适用场景：当一个数组中大部分元素为0或同一个值时，可以用稀疏数组来保存，节省空间。
 *               原理：
 *               1、记录数组一共有几行几列，有多少不同的值
 *               2、把具有不同值的元素的行列以及值记录在一个小规模的数组中，从而缩小程序的规模，节省空间。
 * @author: LiuTuo
 * @create: 2021-06-29 15:28
 **/
public class SparseArr {
    //以五子棋盘为实例，创建一个表示棋盘（11*11）的二维数组
    //1表示黑子  2表示白子

    //定义棋盘行与列数量
    private final static int ROW=11;
    private final static int COLUMN=11;
    //二维数组
    private static int checkerboard[][]=new int[ROW][COLUMN];

    //稀疏数组
    private static int sparseArr[][];

    //下棋步数，决定稀疏数组length
    private static int sum=0;

    /**
     * 下棋方法
     * @param row
     * @param column
     * @param type 0表示黑子  1表示白子
     */
    private static void playChess(int row,int column,int type){
        //在对应行列赋值
        checkerboard[row][column]=type;
        //步数加一
        sum++;
    }

    /**
     * 二维数组转换为稀疏数组
     */
    private static void initSparseArr(){
        //固定三列，分别保存行、列、值
        sparseArr=new int[sum+1][3];
        int count=0;
        //稀疏数组第一列保存二维数组基本数据，行数、列数、需存放的值数量
        for (int i=0;i<checkerboard.length;i++){
            for (int j=0;j<checkerboard[i].length;j++){
                int chess = checkerboard[i][j];
                if (chess == 0) {
                    continue;
                }
                //第一行是记录二维数组基本信息，所以从下标1开始
                count++;
                sparseArr[count][0] = i;
                sparseArr[count][1] = j;
                sparseArr[count][2] = chess;
            }
        }
        //设置二维数组基本信息
        sparseArr[0][0] = ROW;
        sparseArr[0][1] = COLUMN;
        sparseArr[0][2] = sum;
    }

    /**
     * 稀疏数组转换为二维数组
     * @return
     */
    private static int[][] sparseToChess(){
        //根据稀疏数组第一行数据初始化
        int[][] checkerboard=new int[sparseArr[0][0]][sparseArr[0][1]];
        //注意从第一行开始赋值
        for (int i=1;i<sparseArr.length;i++){
            checkerboard[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        return checkerboard;
    }

    public static void main(String[] args) {
        //下棋，为二维数组赋值
        playChess(2,2,1);
        playChess(2,3,2);
        playChess(2,4,1);

        //打印棋盘
        System.out.println("预览原始数组");
        printChessArray(checkerboard);

        //转稀疏数组
        initSparseArr();
        System.out.println("二维数组转稀疏数组");
        printChessArray(sparseArr);

        //稀疏数组转二维数组
        int[][] sparseToChess = sparseToChess();
        System.out.println("稀疏数组转二维数组");
        printChessArray(sparseToChess);

    }

    /**
     * 打印棋盘上的棋子布局
     *
     * @param chessArr
     */
    public static void printChessArray(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                // 左对齐，使用两个空格补齐 2 位数
                System.out.printf("%-2d\t", data);
            }
            System.out.println("");
        }
    }
}

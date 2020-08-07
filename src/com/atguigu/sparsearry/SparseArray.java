package com.atguigu.sparsearry;

public class SparseArray {

    public static void main(String[] args) {
        int chaessArr1[][] = new int[11][11];
        chaessArr1[1][2] = 1;
        chaessArr1[2][3] = 2;
        for(int[] row:chaessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //稀疏数组
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chaessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        int spareArr[][] = new int[sum+1][3];
        spareArr[0][0] = 11;
        spareArr[0][1] = 11;
        spareArr[0][2] = sum;

        int count=0;//用于记录是第几个非0数据
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chaessArr1[i][j]!=0){
                    count++;
                    spareArr[count][0] = i;
                    spareArr[count][1] = j;
                    spareArr[count][2] = chaessArr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("稀疏数组：");
        for (int i=0;i<spareArr.length;i++){
            System.out.printf("%d\t%d\t%d\t",spareArr[i][0],spareArr[i][1],spareArr[i][2]);
            System.out.println();
        }

        int chessArr2[][] = new int[spareArr[0][0]][spareArr[0][1]];
        for(int i=1;i<spareArr.length;i++){
            chessArr2[spareArr[i][0]][spareArr[i][1]] = spareArr[i][2];
        }
        System.out.println();
        System.out.println("恢复后的二维数组");
        for(int[] row:chessArr2){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }    }

}

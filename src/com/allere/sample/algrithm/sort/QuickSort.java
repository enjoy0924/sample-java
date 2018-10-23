package com.allere.sample.algrithm.sort;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void quickSort(int[] a,int lowIdx,int highIdx){
        int startIdx = lowIdx;
        int endIdx = highIdx;
        int key = a[lowIdx];

        while(endIdx>startIdx){
            //从后往前比较
            while(endIdx>startIdx && a[endIdx]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                endIdx--;

            if(a[endIdx]<=key){
                swap(a, endIdx, startIdx);
            }
            //从前往后比较
            while(endIdx>startIdx && a[startIdx]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                startIdx++;
            if(a[startIdx]>=key){
                swap(a, startIdx, endIdx);
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(startIdx > lowIdx)
            quickSort(a,lowIdx,startIdx-1);//左边序列。第一个索引位置到关键值索引-1

        if(endIdx < highIdx)
            quickSort(a,endIdx+1,highIdx);//右边序列。从关键值索引+1到最后一个
    }
}

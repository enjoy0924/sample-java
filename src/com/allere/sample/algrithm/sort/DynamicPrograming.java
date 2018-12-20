package com.allere.sample.algrithm.sort;

import java.util.HashMap;
import java.util.Map;

public class DynamicPrograming {

    static class Range{
        public int getS() {
            return s;
        }

        public void setS(int s) {
            this.s = s;
        }

        public int getE() {
            return e;
        }

        public void setE(int e) {
            this.e = e;
        }

        private int s;
        private int e;

        Range(int s, int e){
            this.s = s;
            this.e = e;
        }
    }


    public static Integer prev(Map<Integer, Range> rangeDict, Integer idx){
        Range rangeRef = rangeDict.get(idx);
        for(int i=idx-1; i>0; i--){
            Range range = rangeDict.get(i);
            if(rangeRef.getS() >= range.getE())
                return i;
        }

        return 0;
    }

    public static Integer val(Map<Integer, Integer> valueDict, Integer idx){
        return valueDict.get(idx);
    }


    public static Integer recOpt(Map<Integer, Range> rangeDict, Map<Integer, Integer> valueDict, int idx){

        if(idx==0)
            return 0;
        else if(idx==1)
            return valueDict.get(1);
        else {
            Integer prevIdx = prev(rangeDict, idx);
            Integer nextIdx = idx - 1;

            /**这里A B表示选择和不选当前节点的值*/
            Integer A = recOpt(rangeDict, valueDict, prevIdx) + val(valueDict,idx);
            Integer B = recOpt(rangeDict, valueDict, nextIdx);

            return Math.max(A, B);
        }
    }

    public static Integer opt(Map<Integer, Range> rangeDict, Map<Integer, Integer> valueDict){

        int size = valueDict.size();
        int[] opt = new int[size+1];
        for(int i=1; i <= size; i++){
            if(i == 1){
                opt[1] = val(valueDict, 1);
            }else {
                int a = opt[prev(rangeDict, i)] + val(valueDict, i);
                int b = opt[i-1];

                opt[i] = Math.max(a, b);
            }
        }
        return opt[size];
    }



    public static void main(String[] args){
        /**工作时间段*/
        Map<Integer, Range> rangeDict = new HashMap<>();
        rangeDict.put(1, new Range(1,4));
        rangeDict.put(2, new Range(3,5));
        rangeDict.put(3, new Range(0,6));
        rangeDict.put(4, new Range(4,7));
        rangeDict.put(5, new Range(3,8));
        rangeDict.put(6, new Range(5,9));
        rangeDict.put(7, new Range(6,10));
        rangeDict.put(8, new Range(8,11));

        /**每个阶段的价值*/
        Map<Integer, Integer> valueDict = new HashMap<>();
        valueDict.put(1, 5);
        valueDict.put(2, 1);
        valueDict.put(3, 8);
        valueDict.put(4, 4);
        valueDict.put(5, 6);
        valueDict.put(6, 3);
        valueDict.put(7, 2);
        valueDict.put(8, 4);


        Integer opt = recOpt(rangeDict, valueDict, valueDict.size());

        System.out.println(opt);

        opt = opt(rangeDict, valueDict);

        System.out.println(opt);
    }

}

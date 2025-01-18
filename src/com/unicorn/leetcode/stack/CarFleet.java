package com.unicorn.leetcode.stack;

import java.util.*;

public class CarFleet {

    public int carFleet_memory(int target, int[] position, int[] speed) {
        int res = 0;
        double[] timeArr = new double[target];
        for (int i = 0; i < position.length; i++)
        {
            timeArr[position[i]]= (double)(target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = timeArr[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res;

    }

    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Double> map = new HashMap();

        for(int i=0;i<position.length;i++){
            map.put(position[i], (target-position[i])/(double)speed[i]);
        }


        Arrays.sort(position);
        Stack<Double> stack = new Stack();
        for(int i = position.length-1; i>=0;i--){
            int po = position[i];

            if(stack.isEmpty() || map.get(po) > stack.peek() ){
                stack.push(map.get(po));

            }
        }

        return stack.size();



    }

    public int carFleet1(int target, int[] position, int[] speed) {
        // Step 1
        float[] moves = new float[position.length];

        for(int i=0; i<position.length;i++){
            moves[i] = (((float)target - position[i]) / speed[i] );
        }

        // Step 2
        int fleet = 0;
        int counter =0;
        int maxPosition = -1, maxIndex = -1;
        float maxPositionMoves;

        while(counter < position.length){

            // Step 2a
            fleet++;
            maxPosition = -1; maxIndex = -1;

            for(int j=0; j<position.length;j++){

                if(position[j] > maxPosition) {
                    maxPosition = position[j];
                    maxIndex = j;
                }
            }

            // Step 2b
            maxPositionMoves = moves[maxIndex];

            for(int k=0; k<moves.length; k++){

                if(moves[k] !=0 && moves[k] <= maxPositionMoves){
                    moves[k] = 0;
                    position[k] = -1;
                    counter++;
                }
            }
        }
        return fleet;
    }



    public static void main(String[] args) {


        int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };

        // Applying sort() method over to above array
        // by passing the array as an argument
        Arrays.sort(arr);

        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        CarFleet c = new CarFleet();
        System.out.println(c.carFleet(target, position, speed));

    }
}

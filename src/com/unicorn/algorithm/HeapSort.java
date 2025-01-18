package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class HeapSort {

    private int left_child(int index){
        return (index+1)*2-1;
    }

    private int right_child(int index){
        return (index+1)*2;
    }

    private int parent(int index){
        return (index-1)/2;
    }

    public void heapSort(int[] nums){

        for (int i = (nums.length+1) / 2; i >= 0; i--) {
            heapize(nums, i);
        }
        CollectionsUtils.printArray(nums);

        while(nums.length>0){
            int end = nums.length-1;
            swap(nums, 0, end);
            System.out.println(nums[end]);
            int[] nums1 = new int[nums.length-1];
            System.arraycopy(nums,0, nums1,0, nums.length-1 );
//            CollectionsUtils.printArray(nums);
            nums = nums1;
            heapize(nums, 0);



        }

    }



    private void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    private int heapize(int[] nums, int index){
        int left_child = left_child(index);
        int right_child = right_child(index);
        int changed = -1;

        if(left_child < nums.length && nums[index] < nums[left_child]){
            changed = left_child;
        }
        if(right_child < nums.length && nums[index] < nums[right_child]){
            if(changed > 0) {
                changed = nums[left_child] > nums[right_child]? left_child: right_child;
            }else {
                changed = right_child;
            }
        }
        if(changed >0){
            swap(nums, index, changed);
            heapize(nums, changed);
        }
        return changed;
    }


    public static void main(String[] args) {

        int[] arrs = { 38,27,43,3,9,82,10, 8 };
        HeapSort hs = new HeapSort();
        hs.heapSort(arrs);
        CollectionsUtils.printArray(arrs);


    }


}

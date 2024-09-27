
/*

Given an array of integers nums and an integer limit, return the size of the longest non-empty
subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.


Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3

 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContiguousSubArrayWithLimit {



    public static void main(String... args){

        int[] nums={8,2,4,7};
        System.out.println(longestSubArrray(nums,4));
    }

    public static int longestSubArrray(int[] nums,int limit){
        int longest =0;
        Deque<Integer> ascQ=new ArrayDeque<>(nums.length);
        Deque<Integer> descQ=new ArrayDeque<>(nums.length);
        for (int l=0,r=0;r<nums.length;r++){
            int min=offerToAscQ(ascQ,nums,r);
            int max=offerToDesccQ(descQ,nums,r);
            while (l<=r && max-min>limit){
                if (ascQ.peek()<=l){
                    ascQ.poll();
                    min=nums[ascQ.peek()];
                }

                if (descQ.peek()<=l){
                    descQ.poll();
                    max=nums[descQ.peek()];
                }
                l++;
            }
            longest=Math.max(longest,r-l+1);

        }

return longest;
    }

    private static int offerToDesccQ(Deque<Integer> descQ, int[] nums, int r) {
        while (!descQ.isEmpty() && nums[descQ.peekLast()]<nums[r]){
            descQ.pollLast();
        }
        descQ.offer(r);
        return nums[descQ.peek()];
    }

    private static int offerToAscQ(Deque<Integer> ascQ, int[] nums, int r) {
        while (!ascQ.isEmpty() && nums[ascQ.peekLast()]>nums[r]){
            ascQ.pollLast();
        }
        ascQ.offer(r);
        return nums[ascQ.peek()];
    }


}

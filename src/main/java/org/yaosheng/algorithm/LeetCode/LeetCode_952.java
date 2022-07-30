package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2022/7/30.
 */
public class LeetCode_952 {

    public int largestComponentSize(int[] nums) {

        int group[] = new int[100005];
        for(int i = 1;i <= 100000;i ++){
            group[i] = i;
        }

        for(int i = 0;i < nums.length;i ++){
            findUnion(i,group,nums);
        }

        int count[] = new int[100005];
        for(int i = 0;i < nums.length;i ++){
            count[find(group[nums[i]],group)] ++;
        }

        int ans=0;
        for(int i = 1;i <= 100000;i ++){
            ans = Math.max(ans,count[i]);
        }
        return ans;
    }

    void findUnion(int idx,int group[],int nums[]){

        int a = nums[idx];
        nums[idx] = - 1;
        List<Integer> list=new ArrayList<> ();

        for(int i = 2;i * i <= a;i ++){
            if(a%i == 0){
                if(nums[idx] == - 1){
                    nums[idx] = i;
                }
                list.add(i);
                while(a%i == 0){
                    a /= i;
                }
            }
        }

        if(a != 1){
            list.add(a);
        }
        if(nums[idx] == - 1){
            nums[idx] = a;
        }

        for(int i = 0;i < list.size();i ++){
            int b = list.get(i);
            for(int j = i + 1;j < list.size();j ++){
                int c = list.get(j);
                union(b,c,group);
            }
        }
    }

    void union(int a,int b,int group[]){
        a = find(a,group);
        b = find(b,group);
        group[b] = a;
    }

    int find(int a,int group[]){
        if(a!=group[a]){
            group[a] = find(group[a],group);
        }
        return group[a];
    }
}

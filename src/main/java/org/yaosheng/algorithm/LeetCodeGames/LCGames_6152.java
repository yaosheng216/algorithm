package org.yaosheng.algorithm.LeetCodeGames;

/**
 * Created by yaosheng on 2022/8/21.
 */
public class LCGames_6152 {

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int res = 0;
        for(int i = 0;i < energy.length;i ++){
            if(initialEnergy <= energy[i]){
                res += 1 - (initialEnergy - energy[i]);
                initialEnergy += 1 - (initialEnergy - energy[i]);
            }
            initialEnergy -= energy[i];
        }

        for(int i = 0;i < experience.length;i ++){
            if(initialExperience <= experience[i]){
                res += 1 - (initialExperience - experience[i]);
                initialExperience += 1 - (initialExperience - experience[i]);
            }
            initialExperience += experience[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] energy = {1};
        int[] experience= {3};
        System.out.println (minNumberOfHours (2,4,energy,experience));
    }
}

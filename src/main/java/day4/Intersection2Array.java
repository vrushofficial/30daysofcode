package day4;

import java.util.ArrayList;

class Intersection2Array {
    public static int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            if (i == 1 && nums1[i] != nums1[i - 1])
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        resultList.add(nums1[i]);
                    }
                }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 2, 1};
        int[] a2 = {2, 2};
        int[] sd = intersect(a1, a2);
        for (int i = 0; i < sd.length; i++) {
            System.out.println(sd[i]);
        }
    }
}
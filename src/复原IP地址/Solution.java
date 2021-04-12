package 复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i) - '0';
        }
        this.restore(array, 0, 0, new int[4]);
        return this.res;
    }

    private List<String> res = new ArrayList<>();

    private void restore(int[] array, int index, int level, int[] nums) {
        if (index > array.length) {
            return;
        }
        if (index < array.length && level == 4) {
            return;
        }
        if (index == array.length) {
            if (level == 4) {
                StringBuilder sb = new StringBuilder();
                for (int num : nums) {
                    sb.append(num);
                    sb.append('.');
                }
                sb.setLength(sb.length() - 1);
                this.res.add(sb.toString());
            }
            return;
        }
        if (array[index] == 0) {
            nums[level] = 0;
            this.restore(array, index + 1, level + 1, nums);
            return;
        }
        int num = 0;
        for (int i = index; i < array.length; i++) {
            num = num * 10 + array[i];
            if (num > 255) {
                break;
            }
            nums[level] = num;
            this.restore(array, i + 1, level + 1, nums);
        }
    }
}

package 杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> saves = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            for (int j=0;j<=i;j++){
                if (j==0||j==i){
                    if (j==0)
                        saves.add(new ArrayList<Integer>());
                    saves.get(i).add(1);
                    continue;
                }
                if (i>=2){
                    saves.get(i).add(saves.get(i-1).get(j-1)+saves.get(i-1).get(j));
                }
            }
        }
        return saves;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> results = new Permutations_Solution().permute(nums);
        for (List<Integer> result: results){
            for (Integer integer: result){
                System.out.print(" " + integer);
            }
            System.out.print("\n");
        }
    }
}

class Permutations_Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> tempList = new ArrayList<>();
        for (int num : nums){
            tempList.add(num);
        }

        List<List<Integer>> results = new ArrayList<>();
        results.add(tempList);

        int[] lastNums = new int[nums.length];
        for (Integer integer: results.get(results.size() - 1)){
            lastNums[results.get(results.size() - 1).indexOf(integer)] = integer;
        }

        boolean toLeft = true;

        for (int k = 0 ; k < nums.length - 1; k++) {

            for (int i = 0; i < nums.length - 1; i++) {
                int[] temps = new int[lastNums.length];
                for (int j = 0; j < lastNums.length; j++) {
                    temps[j] = lastNums[j];
                }


                int index;
                int temp;
                if (toLeft) {
                    index = temps.length - 2 - i;
                    temp = temps[index];
                    temps[index] = temps[temps.length - 1];
                    temps[temps.length - 1] = temp;
                } else {
                    index = i + 1;
                    temp = nums[index];
                    temps[index] = temps[0];
                    temps[0] = temp;
                }

                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < temps.length; j++) {
                    list.add(temps[j]);
                }

                results.add(list);

            }



            List<Integer> tempLastList = results.get(results.size() - 1);
            if (tempLastList.size() > 2) {
                int[] tempLast = new int[tempLastList.size()];
                for (int j = 0; j < tempLast.length; j++) {
                    tempLast[j] = tempLastList.get(j);
                }

                if (toLeft) {
                    int tempLastNum = tempLast[tempLast.length - 2];
                    tempLast[tempLast.length - 2] = tempLast[tempLast.length - 1];
                    tempLast[tempLast.length - 1] = tempLastNum;
                }else {
                    int tempLastNum = tempLast[0];
                    tempLast[0] = tempLast[1];
                    tempLast[1] = tempLastNum;
                }

                List<Integer> saveLast = new ArrayList<>();

                for (int j = 0 ; j < tempLast.length ; j++){
                    saveLast.add(tempLast[j]);
                }
                results.add(saveLast);
            }

            toLeft = !toLeft;

        }



        return results;
    }



}
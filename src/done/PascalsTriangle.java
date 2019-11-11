import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args){
        List<List<Integer>> result = new PascalsTriangle_Solution().generate(5);
        for (List<Integer> items: result){
            for (Integer item: items){
                System.out.print("" + item + ", ");
            }
            System.out.println("");
        }
    }
}


class PascalsTriangle_Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0){
            return result;
        }
        List<Integer> items = new ArrayList<>();
        items.add(1);
        result.add(items);

        if (numRows == 1){
            return result;
        }

        items = new ArrayList<>();
        items.add(1);
        items.add(1);
        result.add(items);

        if (numRows == 2){
            return result;
        }

        for (int i = 2; i < numRows; i++){
            items = new ArrayList<>();
            items.add(1);

            List<Integer> last = result.get(i - 1);

            for (int j = 1; j < i; j++){
                items.add(last.get(j - 1) + last.get(j));
            }
            items.add(1);
            result.add(items);
        }

        return result;
    }
}
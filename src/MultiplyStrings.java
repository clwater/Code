import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class MultiplyStrings {
    public static void main(String[] args){
//        System.out.println(new MultiplyStrings_Solution().multiply("584" , "18"));
        System.out.println(new MultiplyStrings_Solution().getSum("72" , "1440"));
    }
}


class MultiplyStrings_Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();

        List<String> tempResult = new ArrayList<>();
        String tempZero = "";
        for (int i = num1.length() - 1 ; i >=0 ; i--){
            int next = 0;
            int index = num1.length() - 1 - i;
            tempResult.add(tempZero);
            tempZero += "0";
            for (int j = num2.length() - 1; j >= 0 ; j--){
                int a = Integer.valueOf(nums1[i] - 48);
                int b = Integer.valueOf(nums2[j] - 48);
                int num =  a * b + next;
                next = num / 10;
                String str = num % 10 + tempResult.get(index);
                tempResult.set(index , str);
            }
            if (next != 0){
                String str = next + tempResult.get(index);
                tempResult.set(index , str);
            }

        }

        for (String s : tempResult){
            System.out.println("s: " + s);
        }

        String result = "";
        for (int i = 0 ; i < tempResult.size() ; i++){
            result = getSum(result, tempResult.get(i));
            System.out.println("result    " + result);
        }


        return result;

    }

    public String getSum(String num1, String num2){
        char[] nums1 = new StringBuffer(num1).reverse().toString().toCharArray();
        char[] nums2 = new StringBuffer(num2).reverse().toString().toCharArray();
        int next = 0;
        String result = "";
        for (int i = 0 ; i < Math.max(num1.length() , num2.length()) ; i++){
            int a;
            if (i >= num1.length()){
                a = 0;
            }else {
                 a = Integer.valueOf(nums1[i] - 48);
            }
            int b;
            if (i >= num2.length()){
                b = 0;
            }else {
                b = Integer.valueOf(nums2[i] - 48);
            }

            int num =  a + b + next;
            result = result + num % 10;
            next = num / 10;

        }
        if (next != 0){
            result += String.valueOf(next);
        }


        return new StringBuffer(result).reverse().toString();
    }
}
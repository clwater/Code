/**
 实现 strStr() 函数。
 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 示例 1:
 输入: haystack = "hello", needle = "ll"
 输出: 2
 示例 2:

 输入: haystack = "aaaaa", needle = "bba"
 输出: -1
 说明:
 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
class ImplementStrstr {
    public static void main(String[] args){
//        System.out.println(new ImplementStrstr_Solution().strStr("a", "a"));
        System.out.println(new ImplementStrstr_Solution().strStr("ab abcab abcabcd", "abcabcd"));
    }
}

class ImplementStrstr_Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        if (needle.equals("")){
            return 0;
        }

        char[] cHaystcak = haystack.toCharArray();
        char[] cNeedle = needle.toCharArray();
        for (int i = 0; i <= haystack.length() - needle.length(); i++){
            boolean match = true;
            for (int j = 0 ; j < needle.length() ;j++) {
                System.out.println("cHaystcak[i + j]: " + cHaystcak[i + j] + " cNeedle[j]: " + cNeedle[j]);
                if (cHaystcak[i + j] != cNeedle[j]){
                    match = false;
                    j = needle.length();
                }
            }

            if (match){
                return i;
            }
        }
        return index;

    }
}
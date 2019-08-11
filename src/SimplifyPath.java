import java.util.ArrayList;
import java.util.List;

/**
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *  输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 */



public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath_Solution().simplifyPath("/home/"));
        System.out.println(new SimplifyPath_Solution().simplifyPath("/a/../../b/../c//.//"));
        System.out.println(new SimplifyPath_Solution().simplifyPath("/a//b////c/d//././/.."));
    }
}

class SimplifyPath_Solution {
    public String simplifyPath(String path) {
        List<String> temp = new ArrayList<>();
        path = path.replace("//", "/");
        String[] paths = path.split("/");
        for (String item: paths){
            if (item.equals(".") || "".equals(item)) {
                continue;
            }else if (item.equals("..")){
                if (temp.size() > 0){
                    temp.remove(temp.size() - 1);
                }
            }else {
                temp.add(item);
            }
        }

        if (temp.size() == 0){
            return "/";
        }
        String result = "";
        for (String item: temp){
            result += "/" + item;
        }
        return result;
    }
}
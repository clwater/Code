package undo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(2,6));
//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));


//        intervals.add(new Interval(1,4));
//        intervals.add(new Interval(0,2));
//        intervals.add(new Interval(3,5));


        intervals.add(new Interval(2,3));
        intervals.add(new Interval(4,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,9));
        intervals.add(new Interval(1,10));



        List<Interval> result = new MergeIntervals_Solution().merge(intervals);
        for (Interval interval: result){
            System.out.println("[" + interval.start + ", " + interval.end + "],");
        }

    }
}

class MergeIntervals_Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> last = new ArrayList<>();
        return checkMerge(intervals, last);
    }

    public List<Interval> checkMerge(List<Interval> intervals, List<Interval> last){
        if (intervals.size() == last.size()){
            return intervals;
        }
        List<Interval> result = new ArrayList<>();
        int[] check = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            boolean isCheck = true;
            for (int j = 0 ; j < intervals.size(); j++) {
                Interval int1 = intervals.get(i);
                Interval int2 = intervals.get(j);
                if (int1.start == int2.start && int1.end == int2.end){
                    result.add(new Interval(int1.start, int2.end));

                }
                if (int1.start <= int2.start){
                    if (int1.end >= int2.start && int1.end <= int2.end){
                        isCheck = false;
                        check[j] = 1;
                        result.add(new Interval(int1.start, int2.end));
                    }else if (int1.end >= int2.end){
                        isCheck = false;
                        check[j] = 1;
                        result.add(new Interval(int1.start, int1.end));
                    }
                }else if (int1.start <= int2.end){
                    if (int1.end <= int2.end){
                        isCheck = false;
                        check[j] = 1;
                        result.add(new Interval(int2.start, int2.end));
                    }else {
                        isCheck = false;
                        check[j] = 1;
                        result.add(new Interval(int2.start, int1.end));
                    }
                }
            }

            if (isCheck&& check[i] == 0) {
                result.add(intervals.get(i));
            }
        }
        return checkMerge(result, intervals);
    }
}
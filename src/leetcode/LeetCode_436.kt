package leetcode

class LeetCode_436 {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        var result = IntArray(intervals.size){-1}
        for(i in intervals.indices){
            var min = Int.MAX_VALUE
            for(k in 0 until i){
                if(intervals[k][0] >= intervals[i][1] && intervals[k][0] <= min){
                    min = intervals[k][0]
                    result[i] = k
                }
            }

            if(result[i] == -1){
                var min = Int.MAX_VALUE
                for(j in i+1 until intervals.size){
                    if(intervals[j][0] >= intervals[i][1] && intervals[j][0] <= min){
                        min = intervals[j][0]
                        result[i] = j
                    }
                }
            }
        }
        return result
    }
}
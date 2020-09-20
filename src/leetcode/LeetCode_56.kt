package leetcode

class LeetCode_56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.isEmpty()) return arrayOf()
        intervals.sortBy {
            it[0]
        }
        var output = arrayListOf<IntArray>()

        var i = 0
        while(i < intervals.size){
            var j = i
            var max = intervals[i][1]
            while(j+1 <intervals.size &&
                    intervals[j][1] >= intervals[j+1][0]){
                j += 1
                max = Math.max(max, intervals[j][1])
                intervals[j][1] = max
            }

            output.add(intArrayOf(intervals[i][0], max))
            i = j + 1
        }
        return output.toTypedArray()
    }
}
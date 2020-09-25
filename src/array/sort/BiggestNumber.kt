package array.sort

import java.lang.StringBuilder

class BiggestNumber {

    fun biggestNumber(nums: IntArray): String {
        var out = StringBuilder()
        nums.sortedWith(Comparator{
            o1,o2 -> "$o2$o1".compareTo("$o1$o2")
        }).forEach {
            out.append(it)
        }
        return out.toString()
    }
}
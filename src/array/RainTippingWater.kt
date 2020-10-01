package array

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/
 */
class RainTippingWater {
    fun trap(height: IntArray): Int {
        if(height.isEmpty()) return 0
        val maxArrayR = IntArray(height.size)
        val maxArrayL = IntArray(height.size)

        var maxR = height[height.size - 1]
        for(i in height.size - 1 downTo 0){
            maxR = Math.max(maxR, height[i])
            maxArrayR[i] = maxR
        }

        var maxL = height[0]
        for(i in height.indices) {
            maxL = Math.max(maxL, height[i])
            maxArrayL[i] = maxL
        }

        var trap = 0

        for(i in height.indices){
            val min = Math.min(maxArrayL[i], maxArrayR[i])
            if(height[i] < min){
                trap += min - height[i]
            }
        }

        return trap
    }
}
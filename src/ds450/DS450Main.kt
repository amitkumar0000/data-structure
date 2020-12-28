package ds450

import ds450.arrays.*
import org.omg.PortableInterceptor.SUCCESSFUL

class DS450Main {

    enum class DS450 {
        ReverseArray,
        MinMax,
        KthEle,
        Sort0s1s2s,
        MoveNegative,
        Union,
        Interaction,
        Cycle,
        SubArraySum,
        MaxHeight,
        MinJump,
        ClosestLargest,
        MergeSort,
        PairSum,
        RearrangeNegPos,
        RearrangeNeg,
        RearrangeNegPosO1Space,
    }

    val problem = DS450.RearrangeNegPos
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val mainObj = DS450Main()

            when(mainObj.problem) {
                DS450.ReverseArray -> {
                    mainObj.reverseArray()
                }
                DS450.MinMax -> {
                    mainObj.minMax()
                }
                DS450.KthEle -> {
                    mainObj.kthEle()
                }
                DS450.Sort0s1s2s -> {
                    mainObj.sort0s1s2s()
                }
                DS450.MoveNegative -> {
                    mainObj.moveNegative()
                }
                DS450.Union -> {
                    mainObj.union()
                }
                DS450.Interaction -> {
                    mainObj.interaction()
                }
                DS450.Cycle -> {
                    mainObj.cycle()
                }
                DS450.SubArraySum -> {
                    mainObj.subArraySum()
                }
                DS450.MaxHeight -> {
                    mainObj.maxHeight()
                }
                DS450.MinJump -> {
                    mainObj.minJump()
                }
                DS450.ClosestLargest -> {
                    mainObj.closestLargest()
                }
                DS450.MergeSort -> {
                    mainObj.mergeSort()
                }
                DS450.PairSum -> {
                    mainObj.pairSum()
                }
                DS450.RearrangeNegPos -> {
                    mainObj.rearrangeNegPos()
                }
                DS450.RearrangeNeg -> {
                    mainObj.rearrangeNeg()
                }
                DS450.RearrangeNegPosO1Space -> {
                    mainObj.rearrangeNegPosO1Space()
                }
            }
        }
    }

    fun rearrangeNegPosO1Space() {
        intArrayOf(1, 2, 3, -4, -1, 4).reArrangeNegativePositiveO1Space().forEach {
            print("$it ")
        };println()

        intArrayOf(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8).reArrangeNegativePositiveO1Space().forEach {
            print("$it ")
        };println()
    }

    fun rearrangeNeg() {
        intArrayOf(1, 2, 3, -4, -1, 4).reArrangeNegative().forEach {
            print("$it ")
        };println()

        intArrayOf(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8).reArrangeNegative().forEach {
            print("$it ")
        };println()
    }

    fun rearrangeNegPos() {
        intArrayOf(1, 2, 3, -4, -1, 4).reArrangeNegativePos().forEach {
            print("$it ")
        };println()

        intArrayOf(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8).reArrangeNegativePos().forEach {
            print("$it ")
        };println()
    }

    fun pairSum() {
        val obj = ArraysExt()
        println("Pair sum ${obj.getPairsCount(intArrayOf(48, 24, 99, 51, 33, 39, 29, 83, 74, 72, 22, 
                46, 40, 51, 67, 37, 78, 76, 26, 28, 
                76, 25, 10, 65, 64, 47, 34, 88, 26, 49, 86, 
                73, 73, 36, 75, 5, 26, 4, 39, 99, 27, 12, 97, 67, 63, 15, 3, 92, 90), 49, 50)}")
    }

    fun mergeSort() {
        println("count inversion ${intArrayOf(468, 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323).mergeSort()}")
        println("count inversion ${intArrayOf(8, 4, 2, 1).mergeSort()}")
        println("count inversion ${intArrayOf(2,4,1,3,5).mergeSort()}")

        println("count inversion ${intArrayOf(2, 3, 4, 5, 6).mergeSort()}")
    }

    fun closestLargest() {
        println("closest largest: ${intArrayOf(14,13,11).findClosetLargest(12)}")
    }

    fun minJump() {
        println("--- BackTracking ---")
//        println("min jump: ${intArrayOf(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5).minJump()}")
        println("min jump: ${intArrayOf(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8).minJump()}")
        println("min jump: ${intArrayOf(2,3,1,1,4).minJump()}")
        println("min jump: ${intArrayOf(1, 3, 6, 1, 0, 9 ).minJump()}")
        println("min jump: ${intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).minJump()}")
        println("min jump: ${intArrayOf(1,3,5,8,9,2,6,7,6,8,9).minJump()}")

        println("--- DP ---")
        println("min jump: ${intArrayOf(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5).jumpGamp()}")
        println("min jump: ${intArrayOf(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8).jumpGamp()}")
        println("min jump: ${intArrayOf(2,3,1,1,4).jumpGamp()}")
        println("min jump: ${intArrayOf(1, 3, 6, 1, 0, 9 ).jumpGamp()}")
        println("min jump: ${intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).jumpGamp()}")
        println("min jump: ${intArrayOf(1,3,5,8,9,2,6,7,6,8,9).jumpGamp()}")
    }

    fun maxHeight() {
        println("Max height ${intArrayOf(1,10, 5, 15).maximumHeight(3)}")
    }

    fun subArraySum() {
        print("max subArray sum = ${intArrayOf(1,2,-13,-13,15).maxSubArraySum()}")
    }

    fun cycle() {
        intArrayOf(1,2,3,4,5).cycleByOne().forEach { print("$it ") };println()
    }

    fun interaction() {
        intArrayOf(1,2,3,4,5).intersection(intArrayOf(4,5)).forEach {
            print("$it ")
        }; println()
    }

    fun union() {
        intArrayOf( 85, 25, 1, 32, 54, 6).union(intArrayOf(85, 2)).forEach {
            print("$it ")
        };println()
    }

    fun moveNegative() {
        intArrayOf(-12, 11, -13, -5, 6, -7, 5, -3, -6).moveNeg().forEach {
            print("$it ")
        };println()
        intArrayOf(-1,-2,-3).moveNeg().forEach {
            print("$it ")
        };println()
        intArrayOf(1,2,3).moveNeg().forEach {
            print("$it ")
        };println()
        intArrayOf(1,-2,-3).moveNeg().forEach {
            print("$it ")
        };println()

    }

    fun sort0s1s2s(){
        val obj = Sort0s1s2s()
        obj.sort0s1s2s(intArrayOf(1,2,1,2,0,2,1,0,1)).forEach {
            print("$it ")
        };println()

    }

    fun kthEle() {
        val obj = KthEle()
        println("kth Max ele: ${obj.kMaxEle(intArrayOf(3,4,5,1,2,40), 4)}")
        println("kth Mix ele: ${obj.kMinEle(intArrayOf(3,4,5,1,2,40), 4)}")
    }

    fun minMax() {
        val obj = MinMax()
        val pair = obj.minMax(intArrayOf())
        println("max = ${pair.first}, min = ${pair.second}")
    }

    fun reverseArray() {
        val obj = ReverseArray()
        obj.reverseRecursive(intArrayOf(1,2,3,4,5,6)).forEach{
            print("$it ")
        };println()
    }
}


package array

import array.sort.BiggestNumber
import array.sort.SortByFreq
import array.sort.sortTwoType

class ArrayMain {
    enum class ArrayQuestion {
        Celebrity,
        SortTwoType,
        SortByFreq,
        BiggestNum,
        NextGreaterNum,
        NextGreaterNumLeft,
        NextSmallerNum,
        NextSmallerNumLeft,
        StockSpan,
        MaxRectHistogram,
        MaxRectBinaryMatrix,
        TrapRainWater,
        MinStackSpace,
        MinStack,
    }
    companion object{

        private val question = ArrayQuestion.MinStackSpace
        private val main = ArrayMain()

        @JvmStatic
        fun main(args: Array<String>) {
            println("===== Array Main ====")

            when(question) {
                ArrayQuestion.Celebrity ->
                    main.findCelebrity()
                ArrayQuestion.SortTwoType ->
                    main.sortTwoType()
                ArrayQuestion.SortByFreq ->
                    main.sortByFreq()
                ArrayQuestion.BiggestNum ->
                    main.biggestNum()
                ArrayQuestion.NextGreaterNum ->
                    main.nextGreaterNum()
                ArrayQuestion.NextGreaterNumLeft ->
                    main.nextGreaterNumLeft()
                ArrayQuestion.NextSmallerNum ->
                    main.nextSmallerNum()
                ArrayQuestion.NextSmallerNumLeft ->
                    main.nextSmallerNumLeft()
                ArrayQuestion.StockSpan ->
                    main.stockSpan()
                ArrayQuestion.MaxRectHistogram ->
                    main.maxRectHistogram()
                ArrayQuestion.MaxRectBinaryMatrix ->
                    main.maxAreaBinaryMatrix()
                ArrayQuestion.TrapRainWater ->
                    main.trapWater()
                ArrayQuestion.MinStackSpace ->
                    main.minStackSpace()
                ArrayQuestion.MinStack ->
                    main.minStack()
            }

        }
    }

    private fun minStack() {
        val ms = MinStack()
        ms.minStack(intArrayOf(18,19,29,15,10,16))
        ms.pop()
        println("Min ${ms.getMinV()}")
        ms.pop()
        println("Min ${ms.getMinV()}")
        ms.pop()
        ms.pop()
        println("Min ${ms.getMinV()}")
    }

    private fun minStackSpace() {
        val ms = MinStackSpace()
        ms.minStack(nums = intArrayOf(18,19,29,15,10,16))
        ms.pop()
        println("Min ${ms.getMin()}")
        ms.pop()
        println("Min ${ms.getMin()}")
        ms.pop()
        ms.pop()
        println("Min ${ms.getMin()}")
   }

    private fun trapWater() {
        val rtw = RainTippingWater()
        println("Trap water :- ${rtw.trap(intArrayOf(3,0,0,2,0,4))}")
        println("Trap water :- ${rtw.trap(intArrayOf(0,1,0,2,1,0,1,3,0,1,2,1))}")
        println("Trap water :- ${rtw.trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1))}")
    }
    private fun maxAreaBinaryMatrix() {
        val mrbm = MaxAreaRectangleBinaryMatrix()
        println("Max Rect area Binary Matrix: ${mrbm.maxAreaBinaryMatrix(arrayOf(
                charArrayOf('0','1'),
                charArrayOf('1','0')
        ))}")
        println("Max Rect area Binary Matrix: ${mrbm.maxAreaBinaryMatrix(arrayOf(
                charArrayOf('1','0','1','0','0'),
                charArrayOf('1','0','1','1','1'),
                charArrayOf('1','1','1','1','1'),
                charArrayOf('1','0','1','1','1'),
                charArrayOf('1','0','0','1','0')
        ))}")


    }

    private fun maxRectHistogram() {
        val mrh = MaxRecAreaHistogram()
        println("Max rect are:- ${mrh.maxAreaHistogram(intArrayOf(6,2,5,4,1,6))}")
        println("Max rect are:- ${mrh.maxAreaHistogram(intArrayOf(6,2,5,4,5,1,6))}")
    }

    private fun stockSpan() {
        var ss = StockSpan()
        ss.stockSpanNLE(intArrayOf(100,80,60,70,60,75,85,110)).forEach { print("$it ") };println()
        ss.stockSpanNLE(intArrayOf(100,80,60,60,60,75,85,110)).forEach { print("$it ") };println()
    }

    private fun nextSmallerNum() {
        val nse = NextSmallerEle()
        nse.nextSmallerEle(intArrayOf(4,5,2,25)).forEach { print("$it ") };println()
        nse.nextSmallerEle(intArrayOf(4,5,2,10,8)).forEach { print("$it ") };println()
    }

    private fun nextSmallerNumLeft() {
        val nse = NextSmallerEle()
        nse.nextSmallerEleLeft(intArrayOf(4,5,2,25)).forEach { print("$it ") };println()
        nse.nextSmallerEleLeft(intArrayOf(4,5,2,10,8)).forEach { print("$it ") };println()
    }

    private fun nextGreaterNumLeft() {
        val ngn = NextGreaterEle()
        ngn.nextGreaterEleLeft(intArrayOf(4,5,2,25)).forEach{print("$it ")};println()
        ngn.nextGreaterEleLeft(intArrayOf(13,7,6,12)).forEach{print("$it ")};println()
        ngn.nextGreaterEleLeft(intArrayOf(21,5,20,25)).forEach{print("$it ")};println()
    }

    private fun nextGreaterNum() {
        val ngn = NextGreaterEle()
        ngn.nextGreaterEle(intArrayOf(4,5,2,25)).forEach{print("$it ")};println()
        ngn.nextGreaterEle(intArrayOf(13,7,6,12)).forEach{print("$it ")};println()
        ngn.nextGreaterEle(intArrayOf(21,5,20,25)).forEach{print("$it ")};println()
    }

    private fun biggestNum() {
        var bnum = BiggestNumber()
        println("Biggest number ${bnum.biggestNumber(intArrayOf(9,34,98))}")
        println("Biggest number ${bnum.biggestNumber(intArrayOf(1, 34, 3, 98, 9, 76, 45, 4))}")
        println("Biggest number ${bnum.biggestNumber(intArrayOf(54, 546, 548, 60))}")
    }

    private fun sortByFreq() {
        val sort = SortByFreq()
        sort.sortByFreq(intArrayOf(5, 5, 2, 8, 2, 6, 8, 8)).forEach { print("$it ") };println()
    }

    private fun sortTwoType() {
        val nums = intArrayOf(0,0,1,0,0,1,0,1,0,1)
        nums.sortTwoType().forEach {
            print("$it ")
        };println()
    }

    private fun findCelebrity() {
        val celebrity = Celebrity()

        println("Celebrity: ${celebrity.findCelebrityIn(arrayOf(
                intArrayOf(0,0,1,0),
                intArrayOf(0,0,1,0),
                intArrayOf(0,0,1,0),
                intArrayOf(0,0,1,0)
        ))}")
    }
}
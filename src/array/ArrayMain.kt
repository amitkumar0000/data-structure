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
        MaxRectHistogram
    }
    companion object{

        private val question = ArrayQuestion.MaxRectHistogram
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
            }

        }
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
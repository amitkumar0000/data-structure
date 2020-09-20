package sort

class Sort {

    fun IntArray.selectionSort(): IntArray {
        for (i in this.indices) {
            var min = i
            for (j in i + 1 until this.size) {
                if (this[min] > this[j])
                    min = j
            }
            if (min != i) {
                val t = this[i]
                this[i] = this[min]
                this[min] = t
            }
        }
        return this
    }
}
package array.sort


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

fun IntArray.sortTwoType(): IntArray {
    var left = 0
    var right = this.size - 1
    while (left < right) {
        while (left < this.size && this[left] == 0) {
            left++
        }
        while (right >= 0 && this[right] == 1) {
            right--
        }
        if (left < right) {
            this[left] = 0
            this[right] = 1
        } else {
            break
        }
    }
     return this
}

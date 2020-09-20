package array

class Celebrity {

    fun findCelebrityIn(mat: Array<IntArray>) : Int {
        var candidate = 0

        for(i in 1 until mat.size){
            // If A knows B, B can be celebrity else A can be celebrity
            if(mat[candidate][i] == 1){
                candidate = i
            }
        }

        for(i in mat.indices) {
            // Candidate is  not itself, and candidate knows anyone or anyone does not know candidate, Then return -1
            if (candidate != i && (mat[candidate][i] == 1  || mat[i][candidate] == 0)){
                return -1
            }
        }
        return candidate
    }
}
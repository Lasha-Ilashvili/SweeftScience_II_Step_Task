package com.example.sweeftscience_II_step_task

/*
 * Task 5
 *
 * გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით. დაწერეთ
 * ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.
 *
 * *********************************************************
*/


/* Counts the number of distinct ways to climb a staircase of given stairs count */
fun countVariants(stairsCount: Int): Int {
    return helperCounter(stairsCount).second
}

/*
 * Helper function to compute the number of distinct ways to climb a staircase of given stairs count.
 * This function utilizes dynamic programming to compute the result efficiently.
 */
private fun helperCounter(stairsCount: Int): Pair<Int, Int> {
    if (stairsCount == 0) {
        return Pair(0, 1)
    }

    val pair = helperCounter(stairsCount - 1)

    return Pair(pair.second, pair.second + pair.first)
}
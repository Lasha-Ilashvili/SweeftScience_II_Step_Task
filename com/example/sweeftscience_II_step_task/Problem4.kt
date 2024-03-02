package com.example.sweeftscience_II_step_task

/*
 * Task 4
 *
 * მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.
 * მაგ: a = "1010" b = "1011" , მათი ჯამი იქნება "10101"
 *
 * *********************************************************
*/


/*
 * Adds two binary strings and returns their sum as a binary string.
 */
fun addBinary(a: String, b: String): String {
    var remainder = 0
    val result = StringBuilder()

    var indexA = a.length - 1
    var indexB = b.length - 1

    while (indexA >= 0 || indexB >= 0 || remainder > 0) {
        val digitA = if (indexA >= 0) a[indexA].code - '0'.code else 0
        val digitB = if (indexB >= 0) b[indexB].code - '0'.code else 0

        val sum = digitA + digitB + remainder
        remainder = sum / 2
        val currentDigit = sum % 2

        result.insert(0, currentDigit)

        indexA--
        indexB--
    }

    return result.toString()
}
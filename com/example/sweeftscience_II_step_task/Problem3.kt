package com.example.sweeftscience_II_step_task

/*
 * Task 3
 *
 * მოცემულია მასივი, რომელიც შედგება სიტყვებისგან(string). დაწერეთ ფუნქცია
 * რომელსაც გადაეცემა ეს მასივი და აბრუნებს ყველაზე გრძელ თავსართს(prefix) რომელიც
 * მეორდება ამ სიტყვებში. თუ არცერთი არ მეორდება აბრუნებს ცარიელ
 * სტრინგს.მაგ:[“extract”,”exhale”, “excavate”] , პასუხი იქნება “ex”
 *
 * *********************************************************
 */


/*
 * Finds the longest common prefix among an array of strings.
 * If there's no common prefix, an empty string is returned.
 */
fun longestPrefix(array: Array<String>): String {

    return array.reduceOrNull { prefix, current ->
        prefix.zip(current).takeWhile { (a, b) ->
            a == b
        }.joinToString("") { it.first.toString() }
    } ?: ""
}
package com.example.sweeftscience_II_step_task

/*
 * Task 1
 *
 * გვაქვს მთელი რიცხვების ჩამონათვალი სადაც ერთის გარდა ყველა რიცხვი მეორდება, იპოვეთ ის
 * რიცხვი რომელიც არ მეორდება.
 *
 * *********************************************************
*/


/*
 * Finds the single number in a non-empty array of integers
 * where every element appears twice except for one.
 */
fun singleNumber(nums: IntArray): Int {
    nums.sort()

    var left = 1
    var right = nums.lastIndex

    while (left < right) {
        if (nums[left] != nums[left - 1])
            return nums[left - 1]

        if (nums[right] != nums[right - 1])
            return nums[right]

        left += 2
        right -= 2
    }

    return nums[right]
}
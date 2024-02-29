package com.example.sweeftscience_II_step_task

/*
 * Task 1
 * გვაქვს მთელი რიცხვების ჩამონათვალი სადაც ერთის გარდა ყველა რიცხვი მეორდება, იპოვეთ ის
 * რიცხვი რომელიც არ მეორდება. int singleNumber(int[] nums)
 *
 * *********************************************************
*/



fun singleNumber(nums: IntArray): Int {
    nums.sort()

    for (i in 1..<nums.size step 2) {
        if (nums[i] != nums[i - 1])
            return nums[i - 1]

        if (i + 1 == nums.lastIndex)
            return nums[i + 1]
    }

    return nums[0]
}
package com.example.sweeftscience_II_step_task

/*
 * Task 2
 *
 * გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა თანხა
 * (თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.
 *
 * *********************************************************
 */


/* Enum class representing different coin denominations */
enum class Coins(val value: Int) {
    ONE(1),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50);
}

/* Function to calculate the minimum number of coins needed to make up a given amount */
fun minSplit(amount: Int): Int {

    val coins = Coins.entries.toList()

    return minSplitHelper(coins = coins, amount = amount)
}

/* Helper function to calculate the minimum number of coins recursively */
private fun minSplitHelper(
    coins: List<Coins>,
    amount: Int,
    memo: MutableMap<Int, Int> = mutableMapOf()
): Int {

    if (amount < 0)
        return Int.MAX_VALUE - 1

    if (amount == 0)
        return 0

    if (memo.containsKey(amount))
        return memo[amount]!!

    var minAmount = Int.MAX_VALUE

    for (coin in coins) {
        if (shouldNotUseACoin(coin, amount))
            continue

        minAmount = minAmount.coerceAtMost(
            1 + minSplitHelper(
                coins = coins,
                amount = amount - coin.value,
                memo = memo
            )
        )
    }

    memo[amount] = minAmount
    return minAmount
}

/* Function to determine if a coin should not be used for the given amount */
private fun shouldNotUseACoin(coin: Coins, amount: Int): Boolean {
    if (amount % Coins.FIFTY.value == 0) {
        return coin != Coins.FIFTY
    }

    if (amount % Coins.TWENTY.value == 0) {
        return coin != Coins.TWENTY
    }

    if (amount % Coins.TEN.value == 0) {
        return coin != Coins.TEN
    }

    if (amount % Coins.FIVE.value == 0) {
        return coin != Coins.FIVE
    }

    return coin != Coins.ONE
}
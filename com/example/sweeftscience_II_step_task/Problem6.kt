package com.example.sweeftscience_II_step_task

/*
 * Task 6
 *
 * დაწერეთ საკუთარი მონაცემთა სტრუქტურა, რომელიც საშუალებას მოგვცემს O(1) დროში
 * წავშალოთ ელემენტი.
 *
 * *********************************************************
 */


/*
 * To implement a data structure that allows O(1) time deletion of elements, I have used Dequeue
 * Hope it's a right approach :))))
 */
class Deque<T> {

    /* Data class representing a cell in the deque */
    data class Cell<T>(
        val value: T,
        var next: Cell<T>? = null,
        var prev: Cell<T>? = null
    )

    /* Head and tail pointers of the deque */
    private var head: Cell<T>? = null
    private var tail: Cell<T>? = null

    /* Checks if the deque is empty */
    fun isEmpty() = head == null && tail == null

    /* Adds an element to the front of the deque */
    fun pushFront(value: T) {
        addCell(value)
    }

    /* Adds an element to the back of the deque */
    fun pushBack(value: T) {
        if (tail == null) {
            addCell(value)
        } else {
            val newCell = Cell(value, prev = tail)
            tail!!.next = newCell
            tail = newCell
        }
    }

    /* Removes and returns the element from the front of the deque */
    fun popFront(): T {
        requireNotNull(head) { "Deque is empty: cannot pop from front" }

        val res = head!!.value

        head = head!!.next
        head?.prev = null

        if (head == null) tail = null

        return res
    }

    /* Removes and returns the element from the back of the deque */
    fun popBack(): T {
        requireNotNull(tail) { "Deque is empty: cannot pop from back" }

        val res = tail!!.value

        tail = tail!!.prev
        tail?.next = null

        if (tail == null) head = null

        return res
    }

    /*
     * Private function to add a cell at the front of the deque
     * Reduces repetitive code
     */
    private fun addCell(value: T) {
        val newCell = Cell(value, next = head)

        head?.prev = newCell
        head = newCell

        if (tail == null) tail = newCell
    }
}
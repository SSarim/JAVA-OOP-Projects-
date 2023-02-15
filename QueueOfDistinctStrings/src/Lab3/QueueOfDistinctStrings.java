/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Sariim Shahwar
 */
public class QueueOfDistinctStrings {

// Overview: QueueOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// FIFO (First-In-First-Out) order.
/*
    
    
The abstraction function is:
    a) Write the abstraction function here
ab(z) = an abrtaction queue q (where x is a QueueOfDistinctStrings Java-obejct)
where q.front = x.items.get(0)
where q.end = x.items.get.(x.items.size()-1)
for all the in integers i, (0 <= i <x.items.size()), q.add(x.items.get(i))
   The function represents a set of strings with a certain location (front and end).
     
 The rep invariant is:
b) Write the rep invariant here
    this.items.size() cannot be empty
    this.items.get(0)!= ........ != this.items.get(this.items.size()-1)
    The stack's last string is not null, and the stack must include items. The stings in the list must also be unique/distinct.
     */
//
//the rep
    private ArrayList<String> items;
// constructor

    public QueueOfDistinctStrings() {
// EFFECTS: Creates a new QueueOfDistinctStrings object
        items = new ArrayList<String>();
    }
// MODIFIES: this
// EFFECTS: Appends the element at the end of the queue
// if the element is not in the queue, otherwise
// does nothing.

    public void enqueue(String element) throws Exception {
        if (element == null) {
            throw new Exception();
        }
        if (false == items.contains(element)) {
            items.add(element);
        }
    }

    public String dequeue() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the front of the queue
        if (items.size() == 0) {
            throw new Exception();
        }
        return items.remove(0);
    }

    public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
        if (items.size() == 0) {
            return false;
        }

        Set<String> ordr = new HashSet<String>(this.items);
        return (ordr.size() == this.items.size());
    }

    public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// queue, the front element and the end element.
// Implements the abstraction function.
// d) Write the code for the toString() here

        String Front = items.get(0);
        String End = items.get(items.size() - 1);
        return "Front:" + Front + "\nEnd:" + End + "\nQueue Of Distinct Strings : " + items;

    }

    public static void main(String[] args) throws Exception {
        QueueOfDistinctStrings q = new QueueOfDistinctStrings();
        q.enqueue("ab");
        q.enqueue("cd");
        q.enqueue("ae");
        q.enqueue("bd");
        q.dequeue();
        boolean x = q.repOK();
        System.out.println("repOK Output: " + x);
        String y = q.toString();
        System.out.println(y);
    }

}

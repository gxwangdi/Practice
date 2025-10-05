# 381. Insert Delete GetRandom O(1) - Duplicates allowed

[Original Page](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/)

Design a data structure that supports all following operations in _average_ **O(1)** time.

**Note: Duplicate elements are allowed.**

1.  `insert(val)`: Inserts an item val to the collection.
2.  `remove(val)`: Removes an item val from the collection if present.
3.  `getRandom`: Returns a random element from current collection of elements. The probability of each element being returned is **linearly related** to the number of same value the collection contains.

**Example:**

<pre>// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1\. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
</pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton" style="display: none;">[Yelp](/company/yelp/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Array](/tag/array/) [Hash Table](/tag/hash-table/) [Design](/tag/design/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Insert Delete GetRandom O(1)](/problems/insert-delete-getrandom-o1/)</span></div>
/**
 * Initialize your data structure here.
 */
var MyLinkedList = function() {
    this.dummy = new ListNode(0)
    this.tail = this.dummy

};

var ListNode = function(val) {
    this.val = val
    this.next = null
};

/**
 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * @param {number} index
 * @return {number}
 */
MyLinkedList.prototype.get = function(index) {
    if (index<0) {
        return -1
    }
    var cur = this.dummy.next
    while (cur && index>0) {
        cur=cur.next
        index--
    }
    if (!cur) {
        return -1
    }
    return cur.val
};

MyLinkedList.prototype.createNode = function(val) {
    var temp = new ListNode(val)
    return temp
};

/**
 * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtHead = function(val) {
    var temp = this.createNode(val)
    temp.next = this.dummy.next
    this.dummy.next = temp
    if (this.tail == this.dummy) {
        this.tail = temp
    }
};

/**
 * Append a node of value val to the last element of the linked list.
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtTail = function(val) {
    var t = this.createNode(val)
    this.tail.next = t
    this.tail = t
};

/**
 * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * @param {number} index
 * @param {number} val
 * @return {void}
 */
MyLinkedList.prototype.addAtIndex = function(index, val) {
    if (index<0) {
        this.addAtHead(val)
        return
    }
    var node = this.createNode(val)
    var cur = this.dummy
    while (cur.next && index>0) {
        cur = cur.next
        index--
    }
    if (cur.next == null) {
        if (index==0) {
            cur.next=node
            this.tail =node
        } else {
            return
        }
    } else {
        node.next = cur.next
        cur.next = node
    }
};

MyLinkedList.prototype.getAt = function(index) {
    if (index<0) {
        return null
    }
    var cur = this.dummy
    while (cur.next && index>0) {
        cur = cur.next
        index--
    }
    if (!cur.next) {
        return null
    }
    return cur
};

/**
 * Delete the index-th node in the linked list, if the index is valid.
 * @param {number} index
 * @return {void}
 */
MyLinkedList.prototype.deleteAtIndex = function(index) {
    var prev = this.getAt(index)
    if (!prev) {
        return
    }
    prev.next = prev.next.next
    if (!prev.next) {
        this.tail = prev
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(val)
 * obj.addAtTail(val)
 * obj.addAtIndex(index,val)
 * obj.deleteAtIndex(index)
 */
 

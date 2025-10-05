class MyLinkedList:
    class ListNode:
        def __init__(self, val:int):
            self.val = val
            self.next = None

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dummy = self.ListNode(0)
        self.tail = self.dummy

    def _createNode(self, val:int) -> ListNode:
        temp = self.ListNode(val)
        return temp

    def get(self, index: int) -> int:
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        """
        if index<0:
            return -1
        cur = self.dummy.next
        while cur and index>0:
            cur = cur.next
            index-=1
        if not cur:
            return -1
        return cur.val


    def addAtHead(self, val: int) -> None:
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        """
        temp = self._createNode(val)
        temp.next = self.dummy.next
        self.dummy.next = temp
        if self.tail == self.dummy:
            self.tail = temp


    def addAtTail(self, val: int) -> None:
        """
        Append a node of value val to the last element of the linked list.
        """
        temp = self._createNode(val)
        self.tail.next = temp
        self.tail = temp


    def addAtIndex(self, index: int, val: int) -> None:
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        """
        if index<0:
            self.addAtHead(val)
            return
        node = self._createNode(val)
        cur = self.dummy
        while cur.next and index>0:
            cur=cur.next
            index-=1
        if not cur.next:
            if index==0:
                cur.next=node
                self.tail=node
            else:
                return
        else:
            node.next = cur.next
            cur.next = node


    def deleteAtIndex(self, index: int) -> None:
        """
        Delete the index-th node in the linked list, if the index is valid.
        """
        prev = self._getAt(index)
        if not prev:
            return
        prev.next = prev.next.next
        if not prev.next:
            self.tail = prev

    def _getAt(self, index:int) -> ListNode:
        if index<0:
            return None
        cur = self.dummy
        while cur.next and index>0:
            cur=cur.next
            index-=1
        if not cur.next:
            return None
        return cur



# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)

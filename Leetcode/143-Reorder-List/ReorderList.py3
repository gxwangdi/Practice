# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next:
            return
        result = self._splitList(head)
        b = self._reverseList(result[1])
        head = self._mergeLists(result[0], b)


    def _splitList(self, head: ListNode) -> List[ListNode]:
        fast = head
        slow = head
        while fast and fast.next:
            slow, fast = slow.next, fast.next.next

        middle = slow.next
        slow.next = None
        return [head, middle]


    def _reverseList(self, head: ListNode) -> ListNode:
        last = None
        curNode = head
        while curNode:
            nextNode = curNode.next
            curNode.next = last
            last = curNode
            curNode = nextNode
        return last


    def _mergeLists(self, a, b) -> ListNode:
        tail = a
        head = a
        a = a.next
        while b:
            tail.next = b
            tail = tail.next
            b = b.next
            if a:
                a, b = b, a
        return head

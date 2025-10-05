# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        cur1 = l1
        cur2 = l2
        dummy = ListNode(0);
        cur = dummy
        carry = 0;
        while cur1 != None or cur2 != None :
            if cur1 != None :
                carry += cur1.val
                cur1 = cur1.next
                
            if cur2 != None :
                carry += cur2.val
                cur2 = cur2.next
            
            temp = ListNode(carry%10)
            cur.next = temp
            cur = cur.next
            carry = carry//10
        
        if carry > 0 :
            temp = ListNode(carry)
            cur.next = temp
            cur = cur.next
        
        return dummy.next
        

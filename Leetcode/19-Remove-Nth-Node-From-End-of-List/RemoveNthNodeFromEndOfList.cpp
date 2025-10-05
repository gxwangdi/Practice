/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == NULL || n < 0) {
            return NULL;
        }
        ListNode* dummy = new ListNode(0); // dummy.val does not matter here.
        dummy->next = head;
        ListNode* prev = dummy;
        ListNode* target = head;
        ListNode* tail = head;
        for (int i=0; i<n; i++) {
            tail = tail-> next;
        }
        while (tail != NULL) {
            tail = tail->next;
            target = target->next;
            prev = prev->next;
        }
        prev->next = target->next;
        return dummy->next;
    }
};


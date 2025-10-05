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
    ListNode* oddEvenList(ListNode* head) {
        if (head == NULL) {
            return head;
        }

        ListNode* o = head;
        ListNode* e = head->next;
        ListNode* eHead = head->next;
        while (e != NULL && e->next != NULL) {
            o->next = e->next;
            e->next = e->next->next;
            o = o->next;
            e = e->next;
        }
        o->next = eHead;
        return head;
    }
};

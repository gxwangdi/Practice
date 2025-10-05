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
    ListNode* reverseList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        
        ListNode* n1 = head;
        ListNode* n2 = n1->next;
        n1->next = NULL;
        while (n2 != NULL) {
            ListNode* temp = n2->next;
            n2->next = n1;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }
};


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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (head == NULL || n < m) {
            return head;
        }
        
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* cur = dummy;
        for (int i=0; i+1<m; i++) {
            if (cur != NULL) {
                cur = cur->next;
            }
        }
        ListNode* prev = cur;
        ListNode* n1 = NULL;
        if (prev != NULL) {
            n1 = prev->next;
        }
        ListNode* n2 = NULL;
        if (n1 != NULL) {
            n2 = n1->next;
        }
        int range = n-m;
        while (range > 0 && n2 != NULL) {
            ListNode* temp = n2->next;
            n2->next = n1;
            n1 = n2;
            n2 = temp;
            range--;
        }
        if (prev != NULL && prev->next != NULL) {
            prev->next->next = n2;
            prev->next = n1;
        }
        return dummy->next;
    }
};


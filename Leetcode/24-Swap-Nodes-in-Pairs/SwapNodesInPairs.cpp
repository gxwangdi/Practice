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
    ListNode* swapPairs(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* A = head;
        head = A->next;
        ListNode* B;
        while (A!=NULL) {
            B = A->next;
            if (B == NULL) {
                break;
            }

            A->next = B->next;
            B->next = A;
            dummy->next = B;
            dummy = A;
            A = A->next;
        }
        return head;
    }
};

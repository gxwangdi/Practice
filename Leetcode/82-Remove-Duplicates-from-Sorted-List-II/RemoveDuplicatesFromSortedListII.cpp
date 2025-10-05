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
    ListNode* deleteDuplicates(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* cur = dummy;
        bool isDuplicate = false;
        while (cur!=NULL && cur->next!=NULL) {
            if (cur->next->next!=NULL && cur->next->val == cur->next->next->val) {
                isDuplicate = true;
                cur->next->next = cur->next->next->next;
            } else {
                if (isDuplicate) {
                    isDuplicate = false;
                    cur->next = cur->next->next;
                } else {
                    cur = cur->next;
                }
            }
        }
        return dummy->next;
    }
};

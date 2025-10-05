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
        ListNode* cur = head;
        ListNode* nextVal;
        while (cur!=NULL && cur->next!=NULL) {
            nextVal = cur->next;
            while (nextVal!=NULL && nextVal->val == cur->val) {
                nextVal = nextVal->next;
            }
            cur->next = nextVal;
            cur = cur->next;
        }
        return head;
    }
};


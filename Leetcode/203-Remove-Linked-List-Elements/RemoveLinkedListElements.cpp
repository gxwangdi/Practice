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
    ListNode* removeElements(ListNode* head, int val) {
        if (head == NULL) {
            return head;
        }
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        ListNode* cur = dummy;
        while (cur != NULL) {
            ListNode* ite = cur->next;
            bool exists = false;
            while (ite!=NULL && ite->val == val) {
                exists = true;
                ite=ite->next;
            }
            if (exists) {
                cur->next = ite;
            }
            cur = ite;
        }
        return dummy->next;
    }
};

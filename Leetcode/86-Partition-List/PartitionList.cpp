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
    ListNode* partition(ListNode* head, int x) {
        ListNode* cur = head;

        ListNode* leftDummy = new ListNode(0);
        ListNode* leftCur = leftDummy;

        ListNode* rightDummy = new ListNode(0);
        ListNode* rightCur = rightDummy;
        while (cur != NULL) {
            if (cur->val < x) {
                leftCur->next = cur;
                cur = cur->next;
                leftCur = leftCur->next;
                leftCur->next = NULL;
            } else {
                rightCur->next = cur;
                cur = cur->next;
                rightCur = rightCur->next;
                rightCur->next = NULL;
            }
        }
        leftCur->next = rightDummy->next;
        return leftDummy->next;
    }
};

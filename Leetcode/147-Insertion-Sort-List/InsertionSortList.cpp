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
    ListNode* insertionSortList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* dummy = new ListNode(head->val);
        ListNode* temp;
        while (head!=NULL) {
            temp = head;
            head = head->next;
            temp->next = NULL;
            ListNode* n = dummy;
            while (n->next!=NULL) {
                if (temp->val < n->next->val) {
                    break;
                }
                n = n->next;
            }
            temp->next = n->next;
            n->next = temp;
        }
        return dummy->next;
    }
};

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
    void reorderList(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return;
        }
        ListNode* p1 = head;
        ListNode* p2 = head->next;
        while (p2!=NULL && p2->next!=NULL) {
            p1 = p1->next;
            p2 = p2->next->next;
        }

        ListNode* head2 = p1->next;
        p1->next = NULL;
        p2 = head2->next;
        head2->next = NULL;
        while (p2!=NULL) {
            p1 = p2->next;
            p2->next = head2;
            head2 = p2;
            p2 = p1;
        }
        p1 = head;
        p2 = head2;
        while (p1!=NULL) {
            ListNode* temp = p1->next;
            p1 = p1->next = p2;
            p2 = temp;
        }
    }
};

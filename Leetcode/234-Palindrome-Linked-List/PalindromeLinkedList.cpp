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
    bool isPalindrome(ListNode* head) {
        if (head == NULL || head->next == NULL) {
            return true;
        }
        ListNode* slow = head;
        ListNode* fast = head;
        while (fast->next!=NULL && fast->next->next!=NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* sHead = slow->next;
        slow->next = NULL;

        // reverse sHead list
        ListNode* p1 = sHead;
        ListNode* p2 = p1->next;
        while (p1!=NULL && p2!=NULL) {
            ListNode* temp = p2->next;
            p2->next = p1;
            p1 = p2;
            p2 = temp;
        }
        sHead->next = NULL;

        // compare head and sHead
        ListNode* p = (p2==NULL)?p1:p2;
        ListNode* q = head;
        while (p!=NULL) {
            if (p->val != q->val) {
                return false;
            }
            p = p->next;
            q = q->next;
        }
        return true;
    }
};

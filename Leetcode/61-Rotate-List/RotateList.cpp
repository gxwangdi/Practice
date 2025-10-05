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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        int len = getLength(head);
        k = k%len;
        if (k==0) {
            return head;
        }
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode* fast = dummy;
        while (k>0) {
            fast = fast->next;
            k--;
        }
        ListNode* slow = dummy;
        while (fast->next!=NULL) {
            slow=slow->next;
            fast=fast->next;
        }
        dummy->next = slow->next;
        slow->next = NULL;
        fast->next = head;
        return dummy->next;
    }
private:
    int getLength(ListNode* head) {
        ListNode* cur = head;
        int len = 0;
        while (cur!=NULL) {
            cur = cur->next;
            len++;
        }
        return len;
    }
};

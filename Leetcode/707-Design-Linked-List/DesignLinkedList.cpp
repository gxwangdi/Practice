class MyLinkedList {
public:
    /** Initialize your data structure here. */
    MyLinkedList() {
        dummy = createNode(0);
        tail = dummy;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    int get(int index) {
        if (index < 0) {
            return -1;
        }
        ListNode* cur = dummy->next;
        while (cur!=NULL && index>0) {
            cur = cur->next;
            index--;
        }
        if (cur==NULL) {
            return -1;
        }
        return cur->val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    void addAtHead(int val) {
        ListNode* temp = createNode(val);
        temp->next = dummy->next;
        dummy->next = temp;
        if (tail == dummy) {
            tail = temp;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    void addAtTail(int val) {
        ListNode* temp = createNode(val);
        tail->next = temp;
        tail = temp;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
            return;
        }
        ListNode* node = createNode(val);
        ListNode* cur = dummy;
        while (cur->next!=NULL && index>0) {
            cur = cur->next;
            index--;
        }
        if (cur->next == NULL) {
            if (index == 0) {
                cur->next = node;
                tail = node;
            } else {
                return;
            }
        } else {
            node->next = cur->next;
            cur->next = node;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    void deleteAtIndex(int index) {
        ListNode* prev = getAt(index);
        if (prev == NULL) {
            return;
        }
        prev->next = prev->next->next;
        if (prev->next == NULL) {
            tail = prev;
        }
    }
private:
    class ListNode{
    public:
        ListNode(int v) {
            val = v;
            next = NULL;
        }
        int val;
        ListNode* next;
    };

    ListNode* dummy;
    ListNode* tail;

    ListNode* createNode(int val) {
        ListNode* temp = new ListNode(val);
        return temp;
    }

    ListNode* getAt(int index) {
        if (index <0) {
            return NULL;
        }
        ListNode* cur = dummy;
        while (cur->next!=NULL && index > 0) {
            cur = cur->next;
            index--;
        }
        if (cur->next == NULL) {
            return NULL;
        }
        return cur;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */

 

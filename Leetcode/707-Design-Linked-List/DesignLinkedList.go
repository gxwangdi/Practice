type MyLinkedList struct {
    Dummy, Tail *listNode
}

type listNode struct {
    Val int
    Next *listNode
}

/** Initialize your data structure here. */
func Constructor() MyLinkedList {
    dummy := &listNode{Val:0, Next:nil}
    tail := dummy
    return MyLinkedList{Dummy: dummy, Tail: tail}
}

func (this *MyLinkedList) createNode(val int) *listNode {
    temp := &listNode{Val:val, Next:nil}
    return temp
}

/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (this *MyLinkedList) Get(index int) int {
    if index < 0 {
        return -1
    }
    cur := this.Dummy.Next
    for cur!=nil && index>0 {
        cur = cur.Next
        index--
    }
    if cur == nil {
        return -1
    }
    return cur.Val
}


/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int)  {
    temp := this.createNode(val)
    temp.Next = this.Dummy.Next
    this.Dummy.Next = temp
    if this.Tail == this.Dummy{
        this.Tail = temp
    }
}

/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int)  {
    temp := this.createNode(val)
    this.Tail.Next = temp
    this.Tail = temp
}


/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int)  {
    if index<0 {
        this.AddAtHead(val)
        return
    }
    node := this.createNode(val)
    cur := this.Dummy
    for cur.Next!=nil && index>0 {
        cur = cur.Next
        index--
    }
    if cur.Next==nil {
        if index==0 {
            cur.Next=node
            this.Tail=node
        } else {
            return
        }
    } else {
        node.Next = cur.Next
        cur.Next = node
    }
}


/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int)  {
    prev := this.getAt(index)
    if prev ==nil {
        return
    }
    prev.Next = prev.Next.Next
    if prev.Next == nil {
        this.Tail = prev
    }
}

func (this *MyLinkedList) getAt(index int) *listNode {
    if index<0 {
        return nil
    }
    cur := this.Dummy
    for cur.Next!=nil && index>0 {
        cur=cur.Next
        index--
    }
    if cur.Next==nil {
        return nil
    }
    return cur
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */

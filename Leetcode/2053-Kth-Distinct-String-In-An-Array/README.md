
O(n) Time
O(n) Space solution

Set<String> duplicate;
Map<String, Node> single;
class Node{
  String val;
  Node next, prev;
}

Node Head, Tail;

Scan the whole String array, for each String s:
  If s exists in duplicate, pass;
  If s exists in single, remove Node from Head linkedlist, and remove s from single, add s into duplicate;
  If s does not exist in single, add Node to tail, and add <s, Node> into single;

At the end, start from head, return the kth node.

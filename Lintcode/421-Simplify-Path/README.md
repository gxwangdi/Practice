
Basically uses a stack, and a cur pointer scan the whole string path.

When it is not '/', collect it into a temp stringbuilder;
When it is '/', collect it into temp, and check;
if it is "../", pop up the top item in the stack;
if it is "./", dump it;
if it is other string, push it into stack.

remove space at the beginning at first, and remove space at the end at last.

Append all from the stack at the end.

Well, do not make it too hard, for java just split the path into an array using '/'.

Do not consider space in the beginning or at the end.

"." or "" would be ignored!

This is really all about communication! Talk to verify possible inputs and expected output before coding ! ! !


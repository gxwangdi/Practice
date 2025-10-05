
1. '.' is a special char, when applied in regexp it is supposed to be "\\.". Note that '\' is also a special char so we will need one more '\' to identify it. Or the String.split() will not work.

2. "[.]" will also work. Ignore this if you cannot recall the regexp details.

3. StringBuilder is better from performance perspective, but we will need insert from the beginning. StringBuilder.insert(int, char[]) will have error if int exceeds the current length.

 

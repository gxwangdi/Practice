Assuming that the longer string is always a super set of the shorter one, and there is no duplicate words in any string.

Parse the shorter string into tokens and put into a hashset, and parse the longer string into tokens, check one by one if it exists in the hashset. If not exist in the hashset, put the token into result set.


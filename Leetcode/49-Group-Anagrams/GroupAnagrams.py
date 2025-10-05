class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        temp = defaultdict(list)
        for s in strs :
            temp[str(sorted(s))].append(s)
        res = list(temp.values())
        return res

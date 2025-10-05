class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        temp = defaultdict(list)
        for s in strs :
            temp[str(sorted(s))].append(s)
        res = list(temp.values())
        return res
        

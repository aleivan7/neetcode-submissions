class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sort1 = "".join(sorted(list(s)))
        sort2 = "".join(sorted(list(t)))
        if sort1 == sort2:
            return True
        return False
        
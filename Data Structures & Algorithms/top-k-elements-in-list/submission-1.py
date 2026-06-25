class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        frequency = {}
        for num in nums:
            frequency[num] = frequency.get(num, 0) +1
        
        #Sorting the dictionary
        sort_freq = sorted(frequency, key = frequency.get, reverse=True)
        return sort_freq[:k]
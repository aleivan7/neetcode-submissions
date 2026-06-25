class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
    
        columns = [list(col) for col in zip(*board)]
        all_boxes = []

        for r in range(0, 9, 3):
            for c in range(0, 9, 3):
                box = [board[i][j] for i in range(r, r + 3) for j in range(c, c + 3)]
                all_boxes.append(box)


        for row in board:
            filtered_row = self.filterInvalidValues(row)
            if not self.isValidList(filtered_row):
                return False

        for column in columns:
            filtered_col = self.filterInvalidValues(column)
            if not self.isValidList(filtered_col):
                return False

        for box in all_boxes:
            flattened = [item for row in box for item in row]
            filtered_box = self.filterInvalidValues(flattened)
            if not self.isValidList(filtered_box):
                return False

        return True
    
    def filterInvalidValues(self, digits: List[str]) -> List[str]:
        return [num for num in digits if num != "."]

    def isValidList(self, nums: List[str]) -> bool:
        if(len(nums) != len(set(nums))):
            return False
        return True
       

        
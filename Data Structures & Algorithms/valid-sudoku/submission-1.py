class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        seen = set()
        
        for r in range(9):
            for c in range(9):
                val = board[r][c]
                if val != ".":
                    # Create unique string tags for the row, column, and 3x3 block
                    row_tag = (r, val)
                    col_tag = (val, c)
                    box_tag = (r // 3, c // 3, val)
                    
                    # If any of these unique descriptors are already in our set, it's a duplicate!
                    if row_tag in seen or col_tag in seen or box_tag in seen:
                        return False
                    
                    # Otherwise, track them
                    seen.update([row_tag, col_tag, box_tag])
                    
        return True

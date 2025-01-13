# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        data = []
        
        self.prepare(root, data)

        return data

    def prepare(self, root: Optional[TreeNode], data: List[int]):
        if not root:
            return

        self.prepare(root.left, data)
        self.prepare(root.right, data)

        data.append(root.val)    
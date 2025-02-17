"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque

## Time complexity O(n) and space complexity O(n)
class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return None

        bfs = deque([root])

        while bfs:
            size = len(bfs)
            for i in range(size):
                current = bfs.popleft()
                if i != size - 1:
                    current.next = bfs[0]  # Peek at the next element in the queue

                if current.left:
                    bfs.append(current.left)

                if current.right:
                    bfs.append(current.right)

        return root
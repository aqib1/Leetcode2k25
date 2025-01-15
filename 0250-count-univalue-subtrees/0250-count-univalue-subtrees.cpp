/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    int countUnivalSubtrees(TreeNode* root) {
        int count[1];
        count[0] = 0;
        countUntil(root, count);
        return count[0];
    }

    bool countUntil(TreeNode* root, int count[]) {
        if (root == nullptr) {
            return true;
        }

        bool left = countUntil(root->left, count);
        bool right = countUntil(root->right, count);

        if (left & right) {
            if (root->left != nullptr && root->val != root->left->val) {
                return false;
            }
            if (root->right != nullptr && root->val != root->right->val) {
                return false;
            }

            count[0]++;
            return true;
        } else {
            return false;
        }
    }
};
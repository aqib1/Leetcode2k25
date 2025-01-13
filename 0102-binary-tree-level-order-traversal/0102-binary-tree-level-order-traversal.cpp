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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> response;
        preorder(root, response, 0);
        return response;
    }

    void preorder(TreeNode* root, vector<vector<int>>& response, int height) {
        if (root == nullptr) {
            return;
        }
        if (response.size() == height) {
            response.emplace_back();
        }

        response[height].push_back(root->val);
        preorder(root->left, response, height + 1);
        preorder(root->right, response, height + 1);
    }
};
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

#include "iostream"
#include "map"
using namespace std;

class Solution {
private:    
    int postorderIndex;
    vector<int> postorder;
    map<int, int> inorderIndex;

public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        this->postorder = postorder;
        this->postorderIndex = postorder.size() - 1;
        int inIndex = 0;
        for (int in : inorder) {
            this->inorderIndex[in] = inIndex++;
        }

        return this->helper(0, inorder.size() - 1);
    }

    TreeNode* helper(int left, int right) {
        if (left > right)
            return nullptr;

        TreeNode* root = new TreeNode(this->postorder[postorderIndex--]);
        int rootIndex = this->inorderIndex[root->val];
        root->right = helper(rootIndex + 1, right);
        root->left = helper(left, rootIndex - 1);

        return root;
    }
};
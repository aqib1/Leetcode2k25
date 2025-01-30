/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
  int preorderIndex;
  vector<int> preorder;
  map<int, int> inorderIndex;
    
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        this->preorder = preorder;
        int index = 0;
        for(int in: inorder) inorderIndex[in] = index++;

        return this->helper(0, preorder.size() - 1);    
    }
    
    TreeNode* helper(int left, int right) {
        if(left > right)
            return nullptr;

        TreeNode* root = new TreeNode(this->preorder[preorderIndex++]);
        int rootIndex = this->inorderIndex[root->val];
        root->left = helper(left, rootIndex - 1);
        root->right = helper(rootIndex + 1, right);

        return root;
  }
};
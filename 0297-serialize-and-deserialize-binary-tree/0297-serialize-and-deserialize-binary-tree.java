/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       return serialize(root, "");
    }

    public static String serialize(TreeNode root, String res) {
        if(root == null) {
            res += "null,";
        } else {
            res += root.val + ",";
            res = serialize(root.left, res);
            res = serialize(root.right, res);

        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank()) {
            return null;
        }

        var split = data.split(",");
        Queue<String> fifo = new LinkedList<>(Arrays.asList(split));
        return deserialize(fifo);
    }

    public static TreeNode deserialize(Queue<String> data) {
        if(data.peek().equals("null")) {
            data.poll();
            return null;
        }

        var root = new TreeNode(Integer.parseInt(Objects.requireNonNull(data.poll())));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
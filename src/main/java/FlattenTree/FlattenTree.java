package FlattenTree;

public class FlattenTree {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }


    // Flatten whole left, put it in front of the current right, flatten right subtree.
    public TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
           return null;
        }
        // keep TAIL of left so we can re-connect.
        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);
        // connect flattened left subtree to the right of the current node.
        // if LEFT TAIL IS NON NULL- INSERT
        if (leftTail != null) {
            // attach end of left to right side
            leftTail.right = root.right;
            // attach root to this too.
            root.right = root.left;
            root.left = null; // clear out previous left side - implied that left side is fully flattened.
        }
        // what is the tail of the list going to be?
        // right subtree's tail will be the tail of the entire "flattened" tree.
        // What if the right tail is empty? The tail should be the left tail.
        // if both are empty, the tail will be just the root.
        if (rightTail != null) {
            return rightTail;
        }
        if (leftTail != null) {
            return leftTail;
        }
        return root;
    }
}
package FlattenTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof TreeNode) {
            TreeNode treeObj = (TreeNode) obj;
            boolean isCurrentEqual = this.val == treeObj.val;
            if (!isCurrentEqual) {
                return false;
            }

            boolean leftEqual = (this.left == null && treeObj.left == null) || (this.left != null && this.left.equals(treeObj.left));
            boolean rightEqual = (this.right == null && treeObj.right == null) || (this.right != null && this.right.equals(treeObj.right));
            return isCurrentEqual && leftEqual && rightEqual;
        }
        return false;
    }
}

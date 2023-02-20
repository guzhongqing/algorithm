package tree;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/
 * 简单
 * 二叉搜索树
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return root;
            else if (val < root.val) root = root.left;
            else root = root.right;
        }
        return null;
    }


    //前序遍历
    public void traversal(TreeNode root, int val) {
        if (root == null) return;
        System.out.println(root.val);
        if (root.left != null) searchBST(root.left, val);
        if (root.right != null) searchBST(root.right, val);
    }

    //迭代法
    public void iteration(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) return;
            else if (val < root.val) root = root.left;
            else if (val > root.val) root = root.right;
        }
    }

}

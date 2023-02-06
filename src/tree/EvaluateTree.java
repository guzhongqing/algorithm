package tree;

/**
 * 2331. 计算布尔二叉树的值
 * https://leetcode.cn/problems/evaluate-boolean-binary-tree/
 * 简单
 * 递归
 */
public class EvaluateTree {
    public boolean evaluateTree(TreeNode root) {

        //判断当前节点状态
        if (root.left == null) return root.val == 1;

        //根据当前节点的运算，计算左右孩子节点的值
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);

        }
    }
}

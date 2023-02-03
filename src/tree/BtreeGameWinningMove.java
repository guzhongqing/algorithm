package tree;

/**
 * 1145. 二叉树着色游戏
 * https://leetcode.cn/problems/binary-tree-coloring-game/
 * 中等
 * dfs，二叉树
 */
public class BtreeGameWinningMove {
    //定义全局x所在的节点
    TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //找到x所在节点
        findXNode(root, x);

        //比较三个局域的节点数量
        //x节点左子树的节点数量
        int leftSize = getSubSize(xNode.left);
        if (leftSize >= (n + 1) / 2) return true;

        //x节点右子树的节点数量
        int rightSize = getSubSize(xNode.right);
        if (rightSize >= (n + 1) / 2) return true;

        //剩余节点数量
        int remain = n - 1 - leftSize - rightSize;
        return remain >= (n + 1) / 2;
    }

    //找x所在节点
    public void findXNode(TreeNode node, int x) {
        if (node == null) return;
        if (node.val == x) {
            xNode = node;
            return;
        }
        findXNode(node.left, x);
        findXNode(node.right, x);
    }

    //计算该节点子节点的数量
    public int getSubSize(TreeNode node) {
        if (node == null) return 0;
        return 1 + getSubSize(node.left) + getSubSize(node.right);
    }
}


//二叉树
class TreeNode {
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
}


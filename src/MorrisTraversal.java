/**
 * Created by Wei Shi on 7/17/17.
 */
public class MorrisTraversal {
    public static void inorderTraversal(TreeNode<Integer> root) {
        while (root != null) {
            // 如果左子树为空，那么输出当前节点，并将当前节点移动到右子树
            if (root.left == null) {
                System.out.println(root.val);
                root = root.right;
            } else { // 如果左子树不为空
                TreeNode<Integer> prev = root.left;
                // 找到前驱节点
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                //如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                } else {
                    //如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
                    prev.right = null;
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        TreeNode<Integer> n4 = new TreeNode<>(4);
        TreeNode<Integer> n5 = new TreeNode<>(5);
        TreeNode<Integer> n6 = new TreeNode<>(6);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        inorderTraversal(n4);
    }
}

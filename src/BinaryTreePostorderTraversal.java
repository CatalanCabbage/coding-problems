import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Postorder: Left, right, mid
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //Final order: Left, right, mid
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.left == null && current.right == null) {
                solution.add(current.val);
                continue;
            }

            stack.push(new TreeNode(current.val));
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

        }
        return solution;
    }


    List<Integer> solution = new ArrayList<>();
    public List<Integer> postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return solution;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        solution.add(root.val);
        return solution;
    }
}

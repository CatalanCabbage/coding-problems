import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * Link: https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Times: 1
 * Rating: 0
 */


class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> solution = new LinkedList<>();
        return getRightNodes(root, solution);
    }

    private List<Integer> getRightNodes(TreeNode root, List<Integer> solution) {
        if (root == null) {
            return solution;
        }
        //Get the rightmost in each level.
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            //Pop till we get to the last in this level
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.removeFirst();
                if (currentNode.left != null) {
                    queue.addLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addLast(currentNode.right);
                }
                if (i == queueSize - 1) {
                    solution.add(currentNode.val);
                }
            }
        }
        return solution;
    }
}

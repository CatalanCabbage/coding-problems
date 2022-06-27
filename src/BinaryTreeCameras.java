/**
 * Problem: You are given the root of a binary tree. We install cameras on the tree nodes where each
 * camera at a node can monitor its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * Link: https://leetcode.com/problems/binary-tree-cameras/
 */


class BinaryTreeCameras {

    private int cameras = 0;
    private final int COVERED = 0;
    private final int NOT_COVERED = 1;
    private final int HAS_CAMERA = 2;

    public int minCameraCover(TreeNode root) {
        //For each node in DFS:
        //If it's covered, nothing needs to be done
        //If it's not covered, ask root to cover
        //If it has a camera, root also doesn't need to be covered
        cameras = cover(root) == NOT_COVERED ? cameras + 1 : cameras;
        return cameras;
    }

    private int cover(TreeNode root) {
        //Base case
        if (root == null) {
            return COVERED;
        }

        int isLeftCovered = cover(root.left);
        int isRightCovered = cover(root.right);

        if (isLeftCovered == NOT_COVERED || isRightCovered == NOT_COVERED) {
            cameras++;
            return HAS_CAMERA;
        }

        if (isLeftCovered == HAS_CAMERA || isRightCovered == HAS_CAMERA) {
            return COVERED;
        }
        return NOT_COVERED;
    }

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
    }
}

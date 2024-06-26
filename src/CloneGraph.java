/**
 * @author Davis Jeffrey
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Given a reference of a node in a connected undirected graph return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * For simplicity, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with val == 1, the second node with val == 2, and so on.
 * The graph is represented in the test case using an adjacency list.
 *
 * An adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1.
 * You must return the copy of the given node as a reference to the cloned graph.
 *
 * Link: https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        Node[] visitedNodes = new Node[101];
        addNeighbors(node, clone, visitedNodes);
        return clone;
    }

    private void addNeighbors(Node original, Node clone, Node[] visitedNodes) {
        visitedNodes[clone.val] = clone;
        for (Node neighbor : original.neighbors) {
            if (visitedNodes[neighbor.val] == null) {
                Node tempClone = new Node(neighbor.val);
                visitedNodes[neighbor.val] = tempClone;
                addNeighbors(neighbor, tempClone, visitedNodes);
            }
            clone.neighbors.add(visitedNodes[neighbor.val]);
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

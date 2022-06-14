/**
 * @author Davis Jeffrey
 */

import java.util.Stack;

/**
 * Problem: A trie (pronounced as "try") or prefix tree
 * is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
 * There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 * - Trie() Initializes the trie object.
 * - void insert(String word) Inserts the string word into the trie.
 * - boolean search(String word)
 * Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * - boolean startsWith(String prefix)
 * Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 * Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 */

public class ImplementTriePrefixTree {
    class TrieNode {
        public char val;
        public TrieNode[] children;
        public boolean isTerminated;
        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isTerminated = false;
        }
    }
    private TrieNode root;
    public ImplementTriePrefixTree() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode tempRoot = root;
        for(char ch : word.toCharArray()) {
            if (tempRoot.children[ch - 'a'] == null) {
                tempRoot.children[ch - 'a'] = new TrieNode(ch);
            }
            tempRoot = tempRoot.children[ch - 'a'];
        }
        tempRoot.isTerminated = true;
    }

    public boolean search(String word) {
        TrieNode tempRoot = root;
        for(char ch : word.toCharArray()) {
            if (tempRoot.children[ch - 'a'] == null) {
                return false;
            }
            tempRoot = tempRoot.children[ch - 'a'];
        }
        return tempRoot.isTerminated;
    }

    public boolean startsWith(String prefix) {
        TrieNode tempRoot = root;
        for(char ch : prefix.toCharArray()) {
            if (tempRoot.children[ch - 'a'] == null) {
                return false;
            }
            tempRoot = tempRoot.children[ch - 'a'];
        }
        return true;
    }
}

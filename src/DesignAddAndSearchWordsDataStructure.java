import java.util.Arrays;

/**
 * Problem:
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 *     WordDictionary() Initializes the object.
 *     void addWord(word) Adds word to the data structure, it can be matched later.
 *     bool search(word) Returns true if there is any string in the data structure that
 *     matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 * Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */


class DesignAddAndSearchWordsDataStructure {
    class Node {
        boolean isWord;
        Node[] next;
        Node(boolean isWord) {
            next = new Node[26];
            this.isWord = isWord;
        }
        Node() {
            next = new Node[26];
        }
    }
    Node root;
    public DesignAddAndSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.next[word.charAt(i) - 'a'] == null) {
                current.next[word.charAt(i) - 'a'] = new Node(false);
            }
            current = current.next[word.charAt(i) - 'a'];
        }
        current.isWord = true;
    }

    private boolean search(String word, int index, Node node) {
        Node current = node;
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                //System.out.println("Dot encountered");
                //search all possibilities
                for (int j = 0; j < 26; j++) {
                    if (current.next[j] != null) {
                        //System.out.println("Trying " + (char)('a' + j));
                        boolean isWordFormed = search(word, i + 1, current.next[j]);
                        //System.out.println("Word formed with " + (char)('a' + j) + "? " + isWordFormed);
                        if (isWordFormed) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                current = current.next[word.charAt(i) - 'a'];
                //System.out.println("Looking for " + word.charAt(i));
                if (current == null) {
                    //System.out.println("Not present");
                    return false;
                }
            }
        }
        return current.isWord;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }
}

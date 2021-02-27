package leetCode;

public class Ex211 {
    class WordDictionary {
        class Node {
            Node[] children;
            boolean isWord;

            Node() {
                children = new Node[26];
                isWord = false;
            }
        }

        /**
         * Initialize your data structure here.
         */
        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            add(root, word.toCharArray(), 0);
        }

        private void add(Node root, char[] word, int i) {
            if (i == word.length) {
                root.isWord = true;
            } else {
                if (root.children[word[i] - 'a'] == null) {
                    root.children[word[i] - 'a'] = new Node();
                }
                add(root.children[word[i] - 'a'], word, i + 1);
            }
        }

        private boolean match(Node root, char[] word, int i){
            if (i == word.length) {
                return root.isWord;
            }else{
                if (word[i]=='.'){
                    boolean flag = false;
                    for (int j = 0; j < 26; j++) {
                        if (root.children[j] == null) {
                            continue;
                        }
                        flag |= match(root.children[j], word, i + 1);
                    }
                    return flag;
                }else{
                    if (root.children[word[i]-'a']==null){
                        return false;
                    }else{
                        return match(root.children[word[i]-'a'],word,i+1 );
                    }
                }
            }
        }
        public boolean search(String word) {
            return match(root, word.toCharArray(), 0);
        }
    }
}

package leetCode

class Trie() {

    /** Initialize your data structure here. */
    class TrieNode(val `var` :Char = ' '){
        val children=HashMap<Char,TrieNode>()
        var isWord = false
    }
    val root = TrieNode()
    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var p = root
        for (w in word){
            if (p.children.containsKey(w)){
                p= p.children[w]!!
            }else{
                val tt = TrieNode(w)
                p.children[w] = tt
                p=tt
            }
        }
        p.isWord=true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var p = root
        for (w in word) {
            if (p.children.containsKey(w)){
                p = p.children[w]!!
            }else{
                return false
            }
        }
        return p.isWord
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var p = root
        for (w in prefix) {
            if (p.children.containsKey(w)){
                p = p.children[w]!!
            }else{
                return false
            }
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
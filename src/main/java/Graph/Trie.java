package Graph;

public class Trie {
    public Trie[] root;
    public boolean isEnd;



    public Trie(){
        root = new Trie[26];
    }

    public void insert(String word){
        char[] ch = word.toCharArray();
        Trie node = this;
        for(char c : ch){
            int index = c - 'a';
            if (node.root[index] == null) {
            node.root[index] = new Trie();  // 没路就建路
            }
            node = node.root[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        char[] ch = word.toCharArray();
        Trie node = this;
        for(char c : ch){
            int index = c - 'a';
            if(node.root[index] == null)return false;
            else{
                node = node.root[index];
            }
        }
        if(node.isEnd == true)return true;
        else return false;
    }

    public boolean startWith(String prefix){
        // 寻找
        char[] ch = prefix.toCharArray();
        Trie node = this;
        for(char c : ch){
            int index = c - 'a';
            if(node.root[index] == null)return false;
            else{
                node = node.root[index];
            }
        }
        if(isEnd != true)return true;
        else return false;
    }
}

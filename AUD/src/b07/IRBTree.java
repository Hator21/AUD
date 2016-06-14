package b07;


/**
 * Interface for the red/black tree.
 * @author karl
 *
 */
public interface IRBTree {
    /**
     * Searches for a node with the specific key. If the key is not found the nearest node is returned
     * @param key The key to be searched for
     * @return The Node with the convenient key or the nearest node
     */
    RBNode search(int key);
    
    /**
     * Inserts a new node with a given key, if the tree does'nt contain it.
     * @param key The key to be inserted
     */
    void insert(int key);
    
    /**
     * Deletes a node with the given key, if the tree does contain it.
     * @param key The key to be deleted
     */
    void delete(int key);
    
    /**
     * Changes the node with the first key to newKey 
     * a.k.a deletes the node with the first key 
     * and inserts a node with the newKey.
     * 
     * @param key The original key of the node that will be changed/deleted
     * @param newKey The newKey which gets inserted
     */
    void modify(int key, int newKey);

    
}

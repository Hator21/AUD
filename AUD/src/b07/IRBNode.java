package b07;

/**
 * Interface for a node for the RedBlackTree.
 * @author karl
 *
 */
public interface IRBNode {
    /**
     * Sets the key from the node.
     * @param newKey The key to be set
    */
    void setKey(int newKey);
    /**
     * Gets the key from the node.
     * @return The key
     */
    int getKey();
    
    /**
     * Sets the color of the node.
     * @param newColor The color of the node to be set
     */
    void setColor(NodeColor newColor);
    /**
     * Gets the color from a node.
     * @return The color
     */
    NodeColor getColor();

    /**
     * Sets the parent of the node.
     * @param newParent The parent to be set
     */
    void setParent(RBNode newParent);
    /**
     * Gets the parent of the node.
     * @return The parent
     */
    RBNode getParent();
    
    /**
     * Sets the left child of the node.
     * @param newLeft The left child to be set
     */
    void setLeft(RBNode newLeft);
    /**
     * Gets the left child of the node.
     * @return The left child
     */
    RBNode getLeft();
    
    /**
     * Sets the right child of the node.
     * @param newRight The new right child to be set
     */
    void setRight(RBNode newRight);
    /**
     * Gets the right child of the node.
     * @return The right child
     */
    RBNode getRight();
    
}

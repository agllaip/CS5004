import java.util.function.Predicate;

public interface TreeNode<T> {

    /**
     * Add the given node as a child to a node in this tree identified by the predicate. If no node is ...
     * identified by the predicate the tree remains unchanged.
     * @param identifier a predicate that is used to identify the node
     * @param newNode the node that must be added as a child
     * @return the resulting hierarchy starting at this node
     */
    TreeNode<T> addChild(Predicate<T> identifier, TreeNode<T> newNode);

    // Method to return hierarchy into a list
    // Returns a list of all the data that we are interested in

    /**
     * Convert the tree into a list.
     * @return the resulting list
     */
    List<T> toList();
}

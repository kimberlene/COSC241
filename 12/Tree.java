package week12;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 * 
 * @author Michael Albert
 * @param <T> The type of values stored in the tree.
 */
public class Tree < T > {

    /** stores the root value of the tree. */
    private T rootValue;
    /** stores the children of the tree. */
    private List < Tree < T >> children;
    /** stores the indented tree. */
    private static final String INDENT_STRING = " ";

    /** creates a tree with the given values. 
      * @param rootValue is the root value of the tree.
      * @param children are the children of the tree.
      */
    public Tree(T rootValue, List < Tree < T >> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    /** creates a new tree with the given value. 
      * @param rootValue is the root of the tree.
      */
    public Tree(T rootValue) {
        this(rootValue, new ArrayList < Tree < T >> ());
    }

    /** returns the size of the tree.
     * @return the number of nodes in the tree.
     */
    public int size() {
        int count = 1;
        if (this.rootValue == null) {
            return 0;
        } else {
            if (this.children != null) {
                for (Tree < T > child: children) {
                    count = count + child.size();
                }
            }
            return count;
        }
    }

    /** returns the largest number of children of any node.
     * @return the child with largest nodest.
     */
    
    public int maxDegree() {
        int childrenNum = this.children.size();
        int childMax = 0;
        if (this.rootValue == null) {
            return 0;
        } else {
            for (Tree < T > child: children) {
                childMax = Math.max(child.maxDegree(), childMax);
            }
        }
        return Math.max(childMax, childrenNum);
    }

    /** adds elements to the tree. 
      * @param child is the child of the tree.*/
    public void add(Tree < T > child) {
        this.children.add(child);
    }

    /** finds a given value in a tree.
      * @param value is the target value to be found.
      * @return the value if found else null.
      */
    public Tree < T > find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree < T > child: children) {
            Tree < T > match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    /** return an ArrayList which contains the tree arranged in post
     * order traversal.
     * @return ArrayList with the post order traversal.
     */
    public List < T > postOrder() {
        ArrayList < T > list = new ArrayList < T > ();
        for (Tree < T > child: children) {

            if (child.children == null) {
                list.add(child.rootValue);
            }else{
                child.postOrder(list);
            }
        }
        list.add(rootValue);
        return list;
    }
    /** method which returns an arryList with the contents
     * in post order traversal.
     * @param list is the ArrayList used to perform post order traversal.
     * @return list an ArrayList arrranged in postOrder traversal.
     */
    public List < T > postOrder(ArrayList < T > list) {
        for (Tree < T > child: children) {
            if (child.children == null) {
                list.add(child.rootValue);
            } else {
                child.postOrder(list);
            }
        }
        list.add(rootValue);
        return list;
    }

    /** to conevert the tree to string.
      * @return the tree in String.
      */
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

    /** indents the contents of the tree.
     * @return s which is the indented nodes.
     */
    public String toIndentedString() {
        StringBuilder s = new StringBuilder();
        this.buildIndentedString(s, 0);
        return s.toString();
    }

    /** indents the contents of the tree.
      * @param sb is StringBuilder object.
      * @param indentationLevel stores the value for the indentation.
     */
    private void buildIndentedString(StringBuilder sb, int indentationLevel) {
        for (int i = 0; i < indentationLevel; i++) {
            sb.append(INDENT_STRING);
        }
        sb.append(rootValue != null ? rootValue.toString() : "null");
        sb.append('\n');
        for (Tree < T > child: this.children) {
            child.buildIndentedString(sb, indentationLevel + 2);
        }
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree < String > parent = tree.find(target);
        if (parent != null) {
            for (String child: children.split(" ")) {
                parent.add(new Tree < > (child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree < String > tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree < > ("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}


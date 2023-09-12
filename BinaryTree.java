public class BinaryTree {
    private Node<String> root;

    public BinaryTree() {
        root = null;
    }

    // Getters //
    public Node<String> getRoot() {
        return root;
    }

    // Setters //
    public void setRoot(String data) {
        root = new Node<String>(data);
    }

    public void setRoot(Node<String> n) {
        root = n;
    }

    // Methods //
    public boolean isEmpty() {
        if(root == null) {
            return true;
        }
        return false;
    }
    
    public Node<String> moveLeft(Node<String> parent) {
        if(parent != null) {
            if(parent.getLeft() != null) {
                return parent.getLeft();
            }
            else {
                System.out.println("Can't move left!");
            }
        }
        return null;
    }

    public Node<String> moveRight(Node<String> parent) {
        if(parent != null) {
            if(parent.getRight() != null) {
                return parent.getRight();
            }
            else {
                System.out.println("Can't move right!");
            }
        }
        return null;
    }

    public void addLeft(Node<String> parent, String data) {
        if(parent != null) {
            if(parent.getLeft() == null) {
                System.out.println("Added " + data + " to the left child node of " + parent.getData());
                parent.setLeft(new Node<String>(data));
            }
            else {
                System.out.println("Left of " + parent.getData() + " is already full!");
            }
        }
        else {
            System.out.println("Node provided is null!");
        }
    }

    public void addRight(Node<String> parent, String data) {
        if(parent != null) {
            if(parent.getRight() == null) {
                System.out.println("Added " + data + " to the right child node of " + parent.getData());
                parent.setRight(new Node<String>(data));
            }
            else {
                System.out.println("Right of " + parent.getData() + " is already full!");
            }
        }
        else {
            System.out.println("Node provided is null!");
        }
    }

    public String toStringRecWrapper() {
        return toStringRec(getRoot(), "");
    }

    public String toStringRec(Node<String> currentNode, String treeString) {
        if(currentNode == null) {
            return("");
        }
        else {
            treeString = currentNode.getData() + "";
            if(currentNode.getLeft() != null) {
                treeString += "(" + toStringRec(currentNode.getLeft(), treeString) + ")"; 
            }
            if(currentNode.getRight() != null) {
                treeString += "(" + toStringRec(currentNode.getRight(), treeString) + ")"; 
            }
            return(treeString);
        }
    }
}

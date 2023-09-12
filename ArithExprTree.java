public class ArithExprTree extends BinaryTree {

    public ArithExprTree() {
        super();
    }

    public int evaluate(Node<String> currentNode, int left, int right) {
        if(currentNode.getLeft() == null) {
            return Integer.parseInt(currentNode.getData());
        }
        else {
            if(currentNode.getData().equals("+")) {
                left = evaluate(currentNode.getLeft(), left, right);
                right = evaluate(currentNode.getRight(), left, right);
                return(left + right);
            }
            else if(currentNode.getData().equals("-")) {
                left = evaluate(currentNode.getLeft(), left, right);
                right = evaluate(currentNode.getRight(), left, right);
                return(left - right);
            }
            else if(currentNode.getData().equals("*")) {
                left = evaluate(currentNode.getLeft(), left, right);
                right = evaluate(currentNode.getRight(), left, right);
                return(left * right);
            }
            else if(currentNode.getData().equals("/")) {
                left = evaluate(currentNode.getLeft(), left, right);
                right = evaluate(currentNode.getRight(), left, right);
                return(left / right);
            }
            return(0);
        }
    }

    public int evaluateWrapper() {
        return(evaluate(getRoot(), 0, 0));
    }
    
}

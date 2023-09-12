import java.util.*;
public class ArithExpr {
    private ArrayList<String> equationList = new ArrayList<String>();
    private String equationString;

    public ArithExpr(String equation) {
        equationString = equation;
        String number = "";
        equationList.add(equation.charAt(0) + "");
        Boolean isNegative = false;
        for(int i=1; i < equation.length(); i++) {
            if((!Character.isDigit(equation.charAt(i-1)) && (equation.charAt(i-1)) != ')') && (equation.charAt(i)) == '-') {
                number = number + equation.charAt(i);
                isNegative = true;
            }
            if(!Character.isDigit(equation.charAt(i-1)) && Character.isDigit(equation.charAt(i))) {
                number = number + equation.charAt(i);
            }
            if(Character.isDigit(equation.charAt(i-1)) && Character.isDigit(equation.charAt(i))) {
                number = number + equation.charAt(i);
            }
            if(Character.isDigit(equation.charAt(i-1)) && !Character.isDigit(equation.charAt(i))) {
                equationList.add(number);
                number = "";
            }
            if(!Character.isDigit(equation.charAt(i)) && isNegative == false) {
                equationList.add(equation.charAt(i) + "");
            }
            isNegative = false;
        }
    }

    // Getters //
    public ArrayList<String> getEquationList() {
        return equationList;
    }

    // Methods //
    public int Prec(String str)
    {
        switch (str) {
        case "+":
        case "-":
            return 1;
        case "*":
        case "/":
            return 2;
        }
        return -1;
    }

    public String toPostfix() // GeeksForGeeks code I modified
    {
        String result = new String("");
        Deque<String> stack = new ArrayDeque<String>();
        for(int i = 0; i < equationList.size(); i++) {
            String str = equationList.get(i);
            if ((str.matches("[0-9]+")) || (str.length() > 1 && str.charAt(0) == '-')) {
                result += str + " ";
            }
            else if (str.equals("(")) { 
                stack.push("(");
            }
            else if (str.equals(")")) {
                while (!stack.isEmpty() && stack.peek() != "(") {
                    result += stack.pop() + " ";
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && Prec(str) <= Prec(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.push(str);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == "(") {
                return("ERROR");
            }
            result += stack.pop() + " ";
        }
        return result;
    }

    public ArithExprTree postFixtoArithTree() {
        Stack<Node<String>> stack = new Stack<Node<String>>();
        ArithExprTree expressionTree = new ArithExprTree();
        String postFixParts[] = toPostfix().split(" ");
        for(int i=0; i < postFixParts.length; i++) {
            if(postFixParts[i].matches("[0-9]+")) {
                stack.push(new Node<String>(postFixParts[i]));
            }
            else if (postFixParts[i].length() > 1 && postFixParts[i].charAt(0) == '-') { 
                stack.push(new Node<String>(postFixParts[i]));
            }
            else {
                Node<String> parent = new Node<String>(postFixParts[i]);
                Node<String> rightChild = stack.pop();
                Node<String> leftChild = stack.pop();
                parent.setRight(rightChild);
                parent.setLeft(leftChild);
                stack.push(parent);
            }
        }
        expressionTree.setRoot(stack.pop());
        return expressionTree;
    }

    public String validator() {
        if(matchingParenthesis() && stringChecker()) {
            return("" + postFixtoArithTree().evaluateWrapper());
        }
        else if(isNumeric(equationString.substring(1, equationString.length()-1))) {
            return(equationString.substring(1, equationString.length()-1));
        }
        else if(equationString.equals("()")) {
            return("");
        }
        else {
            return("ERROR");
        }
    }

    public boolean stringChecker() {
        for(int i=1; i < equationString.length(); i++) {
            String charOne = equationString.charAt(i-1) + "";
            String charTwo = equationString.charAt(i) + "";
            if("[+-*/]".contains(charOne) && ("[+-*/]".contains(charTwo) && !charTwo.equals("-"))) {
                return false;
            }
            else if(isNumeric(charOne) && charTwo.equals("(")) {
                return false;
            }
            else if(charOne.equals(")") && isNumeric(charTwo)) {
                return false;
            }
        }
        if(("[+*/]".contains(equationString.charAt(1) + "")) || equationString.contains("---") || equationString.contains("/0") || ("[+-*/]".contains(equationString.charAt(equationString.length()-2) + "")) || (equationString.charAt(1) == '-' && equationString.charAt(2) == '-')) {
            return false;
        }
        return true;
    }

    public boolean isNumeric(String str) { 
        try {  
          Integer.parseInt(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }

    public boolean matchingParenthesis() {
        Stack<String> stack = new Stack<String>();
        for(int i=0; i < equationList.size(); i++) {
            if(equationList.get(i).equals("(")) {
                stack.push(equationList.get(i));
            }
            else if(equationList.get(i).equals(")")) {
                if(stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();
                if(!(pop.equals("("))) {
                    return false;
                }
            }
        }
        if(stack.isEmpty() == false) {
            return false;
        }
        return true;
    }

}

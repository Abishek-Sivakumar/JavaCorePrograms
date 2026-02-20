import java.sql.Statement;
import java.util.Stack;

public class StackProblems {
    public static int evaluateExp(String exp){
        String[] tokens = exp.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens ) {
            if (isOperator(token)) {
                int rOp = stack.pop();
                int lOp = stack.pop();
                if(token.equals("+")){
                    stack.push(lOp+rOp);
                }else if(token.equals("-")){
                    stack.push(lOp - rOp);
                }else if(token.equals("*")){
                    stack.push(lOp * rOp);
                }else{
                    stack.push(lOp / rOp);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static boolean isOperator(String a){
        return a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/");
    }

    public static int precedence(char c){
        if(c=='^'){
            return 3;
        }else if(c=='*' || c=='/'){
            return 2;
        }else if(c=='+' || c=='-'){
            return 1;
        }else{
            return -1;
        }
    }

    public static String convertToPostFix(String exp){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result+=stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
                    result+=stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static String convertToPostFix2(String exp){
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result+=stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
                    result+=stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static boolean isOperator2(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static int evaluateExp2(String exp){
        String[] tokens = exp.split("");
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(isOperator2(token)){
                int rOp = stack.pop();
                int lOp = stack.pop();
                if(token.equals("+")){
                    stack.push(lOp + rOp);
                }else if(token.equals("-")){
                    stack.push(lOp - rOp);
                }else if(token.equals("*")){
                    stack.push(lOp * rOp);
                }else{
                    stack.push(lOp / rOp);
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp  = "3+4*2";
        String exp2 = "342*+";
        String ans = convertToPostFix2(exp);
        int res = evaluateExp2(ans);
        System.out.println(ans);
        System.out.println(res);
    }
}

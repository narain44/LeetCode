package ArraysStringsAtoi;

import java.util.Stack;

public class StackSolution {
    public static void main(String []args){
        StackSolution instance=new StackSolution();
        System.out.println(Integer.MAX_VALUE+",");
        System.out.println(instance.myAtoi("-91283472332"));
        System.out.println(instance.myAtoi("-6147483648"));
    }
    public int myAtoi(String str) {
        if(str == null) return 0;
        str=str.trim();
        if(str.length() == 0) return 0;
        boolean negative=false;

        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<str.length();i++){
            Character c=str.charAt(i);
            if(Character.isDigit(c)) stack.push(c);
            else if(i==0 && (c.equals('-') || c.equals('+'))) {if (c.equals('-')) negative=true;}
            else break;
        }


        int factor=negative?-1:1;
        double answer=0;
        double intMaxVal=(double)Integer.MAX_VALUE;
        double intMinVal=(double)Integer.MIN_VALUE;
        //Convert stack to number
        while(!stack.isEmpty()){
            Character c=stack.pop();
            int cintval=c-48;
            answer +=factor* cintval;
            factor=factor*10;

            if(answer<intMinVal || (!stack.isEmpty() && answer*10<intMinVal )) {
                return Integer.MIN_VALUE;
            }else if(answer>intMaxVal || (!stack.isEmpty() && answer*10>intMaxVal)){
                return Integer.MAX_VALUE;
            }
        }

        return (int) answer;
    }
}

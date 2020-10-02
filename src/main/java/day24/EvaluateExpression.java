package day24;

import java.util.Stack;

public class EvaluateExpression
{

    int evaluate(String exp)
    {
        Stack<Integer> operands= new Stack<>();
        Stack<Character> operator= new Stack<>();
        for (int i=0;i<exp.length();i++)
        {
            Character c=exp.charAt(i);

            if (Character.isDigit(c))
                operands.push(c-'0');
            else if(c=='(')
                   operator.push(c);
            else if(c==')')
            {
                while (operator.peek()!='(')
                {
                    Integer v2=operands.pop();
                    Integer v1=operands.pop();
                    Character actOperands=operator.pop();
                    Integer result=actualOpertion(v1,v2,actOperands );
                    operands.push(result);
                }
                operator.pop();
            }
            else if (c=='+' || c=='-' || c=='*' || c=='/')
            {
                while (operator.size()>0 && getPriority(operator.peek())>= getPriority(c)
                && operator.peek()!='(')
                {
                    Integer v2=operands.pop();
                    Integer v1=operands.pop();
                    Character actOperands=operator.pop();
                    Integer result=actualOpertion(v1,v2,actOperands );
                    operands.push(result);
                }
                operator.push(c);
            }
        }
        while (operator.size()!=0)
        {
            Integer v2=operands.pop();
            Integer v1=operands.pop();
            Character actOperands=operator.pop();
            Integer result=actualOpertion(v1,v2,actOperands );
            operands.push(result);
        }
        return operands.peek();
    }

    int getPriority(Character c)
    {
        if(c=='+' || c=='-') return 1;
        else  return 2;  /*if (c=='*' || c=='/')*/
    }
    int actualOpertion(Integer v1,Integer v2, Character actOperands)
    {
        if (actOperands=='+') return v1+v2;
        else if (actOperands=='-') return v1-v2;
        else if (actOperands=='*') return v1*v2;
        else return v1/v2;
    }

    public static void main(String[] args) {
        System.out.println(new EvaluateExpression().evaluate("2+(5-3*6/2)"));
    }
}

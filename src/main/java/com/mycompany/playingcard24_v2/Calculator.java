

package com.mycompany.playingcard24_v2;

import java.util.Stack;

public class Calculator {

    public static String infix;

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts
    // given infix expression
    // to postfix expression.
    public static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String( "" );

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for ( int i = 0; i < exp.length(); ++i ) {
            char c = exp.charAt( i );

            // If the scanned character is an
            // operand, add it to output.
            if ( Character.isLetterOrDigit( c ) )
                result += c;

                // If the scanned character is an '(',
                // push it to the stack.
            else if ( c == '(' )
                stack.push( c );

                //  If the scanned character is an ')',
                // pop and output from the stack
                // until an '(' is encountered.
            else if ( c == ')' ) {
                while ( !stack.isEmpty() &&
                        stack.peek() != '(' )
                    result += stack.pop();

                stack.pop();
            } else // an operator is encountered
            {
                while ( !stack.isEmpty() && Prec( c )
                        <= Prec( stack.peek() ) ) {

                    result += stack.pop();
                }
                stack.push( c );
            }

        }

        // pop all the operators from the stack
        while ( !stack.isEmpty() ) {
            if ( stack.peek() == '(' )
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    // function to check if character is operator or not
    static boolean isOperator( char x ) {
        switch ( x ) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    static boolean isOperand( char x ) {
        return ( x >= 'a' && x <= 'z' ) ||
                ( x >= 'A' && x <= 'Z' );
    }

    public static double calculate(char[] strArr) {
        Stack<Double> operands = new Stack<Double>();

        for(Character str : strArr) {
            if (str == ' ') {
                continue;
            }

            switch (str) {
                case '+':
                case '-':
                case '*':
                case '/':
                    double right = operands.pop();
                    double left = operands.pop();
                    double value = 0;
                    switch(str) {
                        case '+':
                            value = left + right;
                            break;
                        case '-':
                            value = left - right;
                            break;
                        case '*':
                            value = left * right;
                            break;
                        case '/':
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Double.parseDouble(str.toString()));
                    break;
            }
        }
        return operands.pop();
    }

    // Get Infix for a given postfix expression
    static String getInfix( String exp ) {
        Stack<String> s = new Stack<String>();

        for ( int i = 0; i < exp.length(); i++ ) {
            // Push operands
            if ( isOperand( exp.charAt( i ) ) ) {
                s.push( exp.charAt( i ) + "" );
            }

            // We assume that input is
            // a valid postfix and expect
            // an operator.
            else {
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();
                s.push( "(" + op2 + exp.charAt( i ) +
                                op1 + ")" );
            }
        }

        // There must be a single element
        // in stack now which is the required
        // infix.
        return s.peek();
    }

    static boolean isalpha( char c ) {
        if ( c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' ) {
            return true;
        }
        return false;
    }

    static boolean isdigit( char c ) {
        if ( c >= '0' && c <= '9' ) {
            return true;
        }
        return false;
    }

    static int getPriority( char C ) {
        if ( C == '-' || C == '+' ) {return 1;} else if ( C == '*' || C == '/' ) {return 2;} else if ( C == '^' ) {
            return 3;
        }

        return 0;
    }

    // Reverse the letters of a word given start and end points
    static String reverse( char str[], int start, int end ) {

        // Temporary variable to store character
        char temp;
        while ( start < end ) {

            // Swapping the first and last character
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf( str );
    }

/*    static String infixToPostfix( char[] infix1 ) {
        //System.out.println( infix1 );
        String infix = '(' + String.valueOf( infix1 ) + ')';

        int l = infix.length();
        Stack<Character> char_stack = new Stack<>();
        String output = "";

        for ( int i = 0; i < l; i++ ) {

            // If the scanned character is an
            // operand, add it to output.
            if ( isalpha( infix.charAt( i ) ) || isdigit( infix.charAt( i ) ) ) {output += infix.charAt( i );}

            // If the scanned character is an
            // ‘(‘, push it to the stack.
            else if ( infix.charAt( i ) == '(' ) {char_stack.add( '(' );}

            // If the scanned character is an
            // ‘)’, pop and output from the stack
            // until an ‘(‘ is encountered.
            else if ( infix.charAt( i ) == ')' ) {
                while ( char_stack.peek() != '(' ) {
                    output += char_stack.peek();
                    char_stack.pop();
                }

                // Remove '(' from the stack
                char_stack.pop();
            }

            // Operator found
            else {
                if ( isOperator( char_stack.peek() ) ) {
                    while ( ( getPriority( infix.charAt( i ) ) <
                            getPriority( char_stack.peek() ) )
                            || ( getPriority( infix.charAt( i ) ) <=
                            getPriority( char_stack.peek() )
                            && infix.charAt( i ) == '^' ) ) {
                        output += char_stack.peek();
                        char_stack.pop();
                    }

                    // Push current Operator on stack
                    char_stack.add( infix.charAt( i ) );
                }
            }
        }
        while ( !char_stack.empty() ) {
            output += char_stack.pop();
        }
        System.out.println("Postfix: " + output);
        return output;
    }

    // Use 1st
    static String infixToPrefix( char[] infix ) {
        *//*
         * Reverse String Replace ( with ) and vice versa Get Postfix Reverse Postfix *
         *//*
        int l = infix.length;

        // Reverse infix
        String infix1 = reverse( infix, 0, l - 1 );
        infix = infix1.toCharArray();

        // Replace ( with ) and vice versa
        for ( int i = 0; i < l; i++ ) {

            if ( infix[i] == '(' ) {
                infix[i] = ')';
                i++;
            } else if ( infix[i] == ')' ) {
                infix[i] = '(';
                i++;
            }
        }

        String prefix = infixToPostfix( infix );

        // Reverse postfix
        prefix = reverse( prefix.toCharArray(), 0, l - 1 );

        return prefix;
    }*/

    // Convert prefix to Postfix expression (Use 2nd)
    static String preToPost( String pre ) {

        Stack<String> s = new Stack<String>();

        // length of expression
        int length = pre.length();

        // reading from right to left
        for ( int i = length - 1; i >= 0; i-- ) {
            // check if symbol is operator
            if ( isOperator( pre.charAt( i ) ) ) {
                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp = op1 + op2 + pre.charAt( i );

                // Push String temp back to stack
                s.push( temp );
            }

            // if symbol is an operand
            else {
                // push the operand to the stack
                s.push( pre.charAt( i ) + "" );
            }
        }

        // stack contains only the Postfix expression
        return s.peek();
    }

    static String postToPre( String post ) {
        Stack<String> s = new Stack<String>();

        // length of expression
        int length = post.length();

        // reading from right to left
        for ( int i = 0; i < length; i++ ) {

            // check if symbol is operator
            if ( isOperator( post.charAt( i ) ) ) {

                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp
                        = post.charAt( i ) + op2 + op1;

                // Push String temp back to stack
                s.push( temp );
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                s.push( post.charAt( i ) + "" );
            }
        }

        // concatenate all strings in stack and return the
        // answer
        String ans = "";
        for ( String i : s ) {ans += i;}
        return ans;
    }
}


//Ciaran Daly //V1.0
import javax.swing.*;

//Problem 1, getInfix() method too complex, so created separate boolean method to handle validation of users input. Also makes it easier to ask user to re-enter expression if its not correct length, contains illegal chars or symbols, or illegal input
public class PostfixConverterAndSolver {

    public PostfixConverterAndSolver(){
        //Constructor not needed
    }
    //getter method for user infix expression
    public static String getInfix(){//get infix expression from user
        String userInputStr = JOptionPane.showInputDialog(null, "Please enter a numerical infix expression:");
      //  boolean inputValid = isValid(userInputStr);

            if(!isValid(userInputStr)){//if validation method returns false
                JOptionPane.showMessageDialog(null, "Invalid Input. Please enter only numerical single digits 0-9 and +, -, *, /, ^, (, ) ");
                return getInfix();//recursively call function until users input message is valid
            }

        //old validation code was here
      //  System.out.println("Testing, input is valid");
        return userInputStr;
    }

    public static boolean isValid(String userInputStr){//validation method for user input

        //validate user input size (min 3 char and max 20 chars)
        if(userInputStr != null && userInputStr.length() >= 3 && userInputStr.length() <= 20){
            //convert users input string to an array of chars to loop through and validate
            char[] userInputArray = userInputStr.toCharArray();
            // validate if characters are single digits 0-9 and +, -, *, /, ^, (, )
            for(int i =0; i<userInputArray.length; i++){
                //if each char of the array is either not a digit or +-*/^(,), users input expression is false
                if (!(Character.isDigit(userInputArray[i]) || "+-*/^()".indexOf(userInputArray[i]) != -1)) {
                    return false;
                }
            //adding extra validation checks
                if(userInputArray[0]=='*'|| userInputArray[0]=='+'|| userInputArray[0]=='/'|| userInputArray[0]=='^'||userInputArray[0]==')'){//if the first character of the expression is an invalid operator, return false (eg *8+2 is not a correct postfix expression)
                    JOptionPane.showMessageDialog(null, "Invalid Input. Illegal character found at start of expression");
                    return false;
                }

                if(Character.isDigit(userInputArray[i]) && Character.isDigit(userInputArray[i+1])){//if two consecutive characters in the array are digits, then expression is invalid as only single digits are considered valid
                    JOptionPane.showMessageDialog(null, "Invalid Input. Double digit numbers are invalid. Please only enter single digit numbers");
                    return false;
                }

                //checking correct opening and closing of parentheses intended here, but unable to correctly implement for now...
            }
            return true; // all characters input are valid
        }
        return false; //default
    }

        public static int operatorPrecedence(char operator){
        //function will return value for the operator passed in given its precedence, to allow comparison of operators when calculating postfix expression below
            if (operator =='^') { //Math.pow (power) has the highest precedence, and will be computed first
                return 3;
            }
            if (operator == '*' || operator == '/') { //followed by multiplication and division
                return 2;
            }
            if (operator == '+' || operator == '-') {//finally addition and subtraction, with the lowest precedence
                return 1;
            }
        return 0;//default
        }

    public static String infixToPostfix(String strToConvert){
        StringBuilder outputStrBuilder = new StringBuilder();// string builder used to add to create output string for postfix expression
        ArrayStack stack = new ArrayStack();
        //String outputStr = ""; not needed anymore due to implementation of StringBuilder
        char[] userInputArray = strToConvert.toCharArray();//convert to character array

        for(int i =0; i<userInputArray.length; i++){//loop through character array
             if(Character.isDigit(userInputArray[i])) {//if char found in input array is an operand…
                 outputStrBuilder.append(userInputArray[i]);//…append it to the output string builder
             }
               /*  ERROR:Stack is empty //Fixed by first checking if current character is ( or ), and

               if(operatorPrecedence(userInputArray[i])>=operatorPrecedence((char) stack.top())|| stack.isEmpty()||stack.top == '('){ //ERROR: stack is empty  //Cannot invoke "java.lang.Character.charValue()" because the return value of "Stack.top()" is null. Probably caused as I have not popped any other operators to the stack yet
                      outputStrBuilder.append(stack.pop());
        }*/
             else if(userInputArray[i] == '('){
                stack.push(userInputArray[i]);//if char is a '(', push it to the stack.
            }
            else if(userInputArray[i] == ')') {//else if char is a ')'
                 while (!stack.isEmpty() && (char) stack.top() != '(') {
                     outputStrBuilder.append(stack.pop());//pop operators from stack, append to output string, while the stack is not empty and until a '(' is found.
                 }
                 if (!stack.isEmpty() && (char)stack.top() == '(') {
                     stack.pop(); // Pop '(' from stack
                 }
             }

             else if ("+-*/^".indexOf(userInputArray[i]) != -1) {//else if char is a valid operator
                 while (!stack.isEmpty() && operatorPrecedence(userInputArray[i]) <= operatorPrecedence((char)stack.top())) {//use utility method to compare precedence of operators, if current char is less or equal to precedence of operator at top of the stack..
                     outputStrBuilder.append(stack.pop());////pop operators from stack, append to output string
                 }

                 stack.push(userInputArray[i]);//after operators that have a higher or equal precedence are popped, push curr operator
             }
        }
        while (!stack.isEmpty()) {
            outputStrBuilder.append(stack.pop());//pop remaining operators from stack, append to output string
        }


        String postfixExpression = outputStrBuilder.toString();
        return postfixExpression;
    }

    public static double postfixEvaluation(String postfixExpression){
     //   double ans = 0; Not needed anymore as results of computations should be pushed to stack, as opposed to returning this variable
        ArrayStack stack = new ArrayStack();
        char[] postfixCharArray = postfixExpression.toCharArray();
        for(int i =0; i<postfixCharArray.length; i++){
            if(Character.isDigit(postfixCharArray[i])) {
                //Stack is empty when cast as (double), throws exception when (Object), need to fix
                stack.push(((double) (postfixCharArray[i] - '0')));//fixed by keeping (double) subtracting '0' to the char
            }
            else{
                Double secondDigit = (Double)stack.pop();
                Double firstDigit = (Double)stack.pop(); // java.lang.Character cannot be cast to class java.lang.Double//Fixed by using object wrapper Double instead of primitive double

               // Double secondDigit = (Double)stack.pop(); Order swapped due to incorrect ordering, which was causing issues in relation to addition and subtraction

                //if(postfixCharArray[i]) == '+'){// now using switch statement instead
                switch (postfixCharArray[i]){
                    case '+':
                        stack.push(firstDigit+secondDigit);
                        break;

                    case '-':
                        stack.push(firstDigit-secondDigit);
                        break;

                    case '*':
                        stack.push(firstDigit*secondDigit);
                        break;

                        case '/':
                            if (secondDigit != 0) {//if number user is dividing by is not 0 (x/0 should return an error)
                                stack.push(firstDigit / secondDigit);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Invalid Input. Cannot divide a number by 0");
                            }
                            break;

                        case '^':
                            stack.push(Math.pow(firstDigit,secondDigit));//Math.pow to handle power (^) input
                            break;

                }

            }

        }
        return (double) stack.pop();//pop result
        //return ans;
    }

    public static void main(String[] args) {
        String userInput = getInfix();
        String infixToPostfixTest = infixToPostfix(userInput); //ERROR:  java.lang.Character cannot be cast to class java.lang.Double(fixed by casting to Double instead of primitive double on lines 111 & 112
        double answer = postfixEvaluation(infixToPostfixTest);
        JOptionPane.showMessageDialog(null, "The infix expression you have entered is: " + userInput + "\n" + "Converted to Postfix: "+infixToPostfixTest+"\n"+"Final Result: "+answer);
        }
    }

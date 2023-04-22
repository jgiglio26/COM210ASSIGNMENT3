import java.util.Scanner;

/**
 * This class implements a simple stack data structure using an array of characters.
 */
public class MyStack {

  /**
   * The maximum size of the stack.
   */
  public static int maxSize;

  /**
   * The index of the top element in the stack.
   */
  public static int top;

  /**
   * The array used to store the elements in the stack.
   */
  public static char[] charArray;

  /**
   * The main method reads a line of input from the user and checks if it is balanced.
   *
   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in); // create a new Scanner object to read input from the user

    String input = sc.nextLine(); // read a line of input from the user

    sc.close(); // close the scanner object

    charArray = new char[input.length()]; // initialize the charArray with the length of the input string
    top = -1; // initialize top to -1 to indicate that the stack is empty
    maxSize = input.length(); // set maxSize to the length of the input string

    if(isBalanced(input)){ // check if the input string is balanced
      System.out.print("The parentheses are balanced"); 
    }else{
      System.out.print("The parentheses are Not balanced"); 
    }
  }

  /**
   * Pushes a new character onto the stack.
   *
   * @param newChar the character to be pushed onto the stack
   */
  public static void push(char newChar) {
    top++; // increment top
    charArray[top] = newChar; // add the new character to the top of the stack
  }

  /**
   * Pops a character from the stack.
   */
  public static void pop() {
    top--; // decrement top
  }

  /**
   * Checks if the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  public static boolean isEmpty() {
    return (top == -1); // return true if top is -1, indicating that the stack is empty
  }

  /**
   * Checks if the stack is full.
   *
   * @return true if the stack is full, false otherwise
   */
  public static boolean isFull() {
    return (top == maxSize - 1); // return true if top is equal to maxSize-1, indicating that the stack is full
  }

  /**
   * Checks if a given string is balanced. A string is considered balanced if all pairs of parentheses are matched.
   *
   * @param myString the string to be checked
   * @return true if myString is balanced, false otherwise
   */
  public static boolean isBalanced(String myString) {

    for (int i = 0; i < charArray.length; i++) { // loop through each character in myString
     
        if (myString.charAt(i) == '(') { // if the current character is an opening parenthesis
          push(myString.charAt(i)); // push it onto the stack

        } else if (myString.charAt(i) == ')') { // if the current character is a closing parenthesis
          if (isEmpty()) { // check if the stack is empty
            return false; // if it is empty, return false because there is no matching opening parenthesis
          }
          pop(); // pop an element from the stack because we have found a matching pair of parentheses
        }
    }

    return isEmpty(); // return true if the stack is empty, indicating that all pairs of parentheses have been matched
  }
}
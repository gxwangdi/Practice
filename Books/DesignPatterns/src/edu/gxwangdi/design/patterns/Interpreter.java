package edu.gxwangdi.design.patterns;

/**
 * Whenever you introduce an interpreter into a program, you need to
provide a simple way for the program user to enter commands in that
language. It can be as simple as the Macro record button we noted earlier, or
it can be an editable text field like the one in the program above.
However, introducing a language and its accompanying grammar
also requires fairly extensive error checking for misspelled terms or
misplaced grammatical elements. This can easily consume a great deal of
programming effort unless some template code is available for implementing
this checking. Further, effective methods for notifying the users of these
errors are not easy to design and implement.

You can also consider generating a language automatically from a
user interface of radio and command buttons and list boxes. While it may
seem that having such an interface obviates the necessity for a language at all,
the same requirements of sequence and computation still apply. When you
have to have a way to specify the order of sequential operations, a language is
a good way to do so, even if the language is generated from the user interface.

The Interpreter pattern has the advantage that you can extend or
revise the grammar fairly easily one you have built the general parsing and
reduction tools. You can also add new verbs or variables quite easily once the
foundation is constructed.

Finally, as the syntax of the grammar becomes more complex, you
run the risk of creating a hard to maintain program.
 * */

public class Interpreter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

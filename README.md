# Mendeleev's Cipher
The task was to write a program that will encrypt a given text in such a way that, instead of letters, the program will output the atomic number of the element which chemical symbol corresponds to the encrypted letters, ignoring their case. The space between letters should be replaced with an asterisk (*), and the space between words should be replaced with two asterisks (**).

The program uses the `Scanner` function to get text input from the user, which is then stored in a variable of type `String`.

There are two possible outputs from the program.
- If the program successfully encrypts the text, it will print "Encrypted text:" followed by the encrypted text entered by the user.
- If the program is unable to encrypt the given text, it will print an error message stating "Unsupported characters entered" and "Unable to encrypt the given text".

A `for` loop is used, iterating from index 0 to the length of the text entered by the user. The `if`, `else if`, and `else` statements are used within the loop to analyze the input text and take appropriate steps to encrypt the text or throw an exception if encryption is not possible. Additionally, a function to check if the text can be encrypted is implemented, which uses `try` and `catch` statements to provide corresponding solutions.

The `System` class and its subclass `System.out` are used for printing text to the screen with `println` and `print`.
A custom `Cipher` class is created, containing the `mendeleevCipher` function that takes a `String input` and returns a `String output`, and a `check` function of type `void` that takes a `String text` as an argument. The `mendeleevCipher` function is the main encryption function, while the check function verifies whether the text can be encrypted and prints the encrypted text or an appropriate message. The check function is called in the main method, while the `mendeleevCipher` function is called in the check function.

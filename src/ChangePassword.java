import java.io.Console;
//import java.util.Arrays;
import java.io.PrintWriter;

public class ChangePassword {

	/**
	 * Changes the password.
	 * 
	 * @param password the new password
	 * @return <code>true</code> if the password was changed successfully.
	 */
	static boolean resetPassword(String password) {
		return true;
	}

	/**
	 * Checks if the inputted password is valid. A valid password is at least 6
	 * characters long and contains at least one non letter character.
	 * 
	 * @param pwd the password to be validated
	 * @return <code>true</code> if the password is valid, or <code>false</code> if
	 *         the password is invalid
	 */
	static boolean isValidPassword(String pwd) {
		// Check if the password is not at least 6 characters long.
		if (pwd.length() < 6)
			return false;

		// Check if the password contains the correct characters.
		if (!pwd.matches("^.*[^a-zA-Z].*$"))
			return false;

		// If the password passes both checks, it is valid.
		return true;
	}

	public static void main(String[] args) {
		Console cons = System.console();

		if (cons == null) {
			System.err.println("No console available.");
			System.exit(1);
		}

		PrintWriter consOutput = cons.writer();
		// String username = cons.readLine("Username: ");
		consOutput.println("Update your password:");

		boolean foundError = false;
		do {

			String pwd = new String(cons.readPassword("       Password:  "));
			String pwd2 = new String(cons.readPassword("Verify password:  "));

			foundError = false;

			// In the following section, please fill out code to meet requirements of the
			// lab description

			// Verify that the two passwords match each other.
			if (!pwd.equals(pwd2)) {
				// Inform the user that the passwords do not match.
				consOutput.println("Error: Passwords do not match.");

				// If the passwords do not match, then there is an error found.
				foundError = true;
				continue;
			}

			// Check if the password is valid.
			if (!isValidPassword(pwd)) {
				// Inform the user that the password is not valid.
				consOutput.println(
						"Error: Password must contain at least 6 characters and at least one non letter character.");

				// If the password is not valid, then there is an error found.
				foundError = true;
				continue;
			}

			// Attempt to change the password.
			if(!resetPassword(pwd)) {
				// Inform the user that the password could not be changed.
				consOutput.println("Error: Password could not be changed.");

				// If the password could not be changed, then there is an error found.
				foundError = true;
				continue;
			}

			// Inform the user that the password is valid and has been changed.
			consOutput.println("The password has been changed.");

			// If we make it this far, we have passed all of the tests.
			foundError = false;
		} while (foundError);

	}

}

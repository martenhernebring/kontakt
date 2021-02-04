package se.mns;


/**
 * This is a Contact class, in which contacts can be added with a name, email and a phone number.
 * 
 * @author suzanatrajcevska
 * 
 * 
 */
public class Contact{
	private String name;
	private String email;
	private String phoneNumber;

	public Contact(String name, String email, String phoneNumber) {

		setPhoneNumber(phoneNumber);
		setName(name);
		setEmail(email);
	}
	/**
	 * A name is added in the contact
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name should only be written with letters
	 * @return
	 */

	public void setName(String name) {
		if(!isAlphaOrSpace(name)) {
			throw new IllegalArgumentException("Skriv in namnet endast med bokstäver och mellanslag.");
		}

		this.name = name.trim();
	}
	/**
	 * A email is added 
	 * @return email
	 */
	public String getEmail() {		
		return email;
	}
	/**
	 * 
	 * @param email should contain a @
	 * @return
	 */

	public void setEmail(String email) {
		if(!containsAtmark(email)) 
		{
			throw new IllegalArgumentException("E-post måste innehålla @(snabel-a)");
		}
		this.email = email;
	}
	/**
	 * A phone number is added
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * A phone number should only contain numbers
	 * @param phoneNumber
	 */

	public void setPhoneNumber(String phoneNumber) {

		if(isAlphaOrSpace(phoneNumber.trim())) {
			throw new IllegalArgumentException("Skriv in ditt telefonnummer med enbart siffror.");
		}
		this.phoneNumber = phoneNumber;
	}
	private boolean isAlphaOrSpace(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if(!Character.isLetter(c) && c != ' ') {
				return false;
			}
		}

		return true;
	}
	private boolean containsAtmark(String email) {

		if(!email.contains("@")) {
			return false;
		}

		return true;
	}

}

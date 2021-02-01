package se.mns;

public class Contact{
	private String name;
	private String email;
	private String phoneNumber;

	public Contact(String name, String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
	    if(!isAlphaOrSpace(name)) {
	            throw new IllegalArgumentException("Endast bokstäver och mellanslag är tillåtna");
	    }
		
		this.name = name.trim();
	}

	public String getEmail() {		return email;
	}

	public void setEmail(String email) {
		
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		
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
}

package se.mns;

public class Contact{
	private String name;
	private String email;
	private String phoneNumber;

	public Contact(String name, String email, String phoneNumber) {
        
        setPhoneNumber(phoneNumber);
		setName(name);
		setEmail(email);
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

	public String getEmail() {		
		return email;
	}

	public void setEmail(String email) {
		if(!containsAtmark(email)) 
		{
			throw new IllegalArgumentException("E-post måste innehålla @(snabel-a)");
		}
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if(isAlphaOrSpace(phoneNumber)) {
			throw new IllegalArgumentException("Endast siffor och mellanslag är tillåtna");
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

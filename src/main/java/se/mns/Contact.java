package se.mns;

/**
 * Model class used for saving a contact
 * 
 * @author Suzana Trajcevska
 */
public class Contact {
  private String name;
  private String email;
  private String phoneNumber;

  /**Constructor that calls the setters for member variables
   * @param name A name written with only letter and spaces
   * @param email An email written with at @-sign
   * @param phoneNumber A number written with no letters or internal spaces
   */
  public Contact(String name, String email, String phoneNumber) {

    setPhoneNumber(phoneNumber);
    setName(name);
    setEmail(email);
  }

  /**Simple method
   * @return name
   */
  public String getName() {
    return name;
  }

  /**Simple method with trim
   * @param name A name written with only letter and spaces
   */
  public void setName(String name) {
    if (!isAlphaOrSpace(name)) {
      throw new IllegalArgumentException("Skriv in namnet endast med bokstäver och mellanslag.");
    }

    this.name = name.trim();
  }

  /**Simple method
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**Simple method with trim
   * @param email An email written with an @-sign
   */
  public void setEmail(String email) {
    if (!containsAtmark(email)) {
      throw new IllegalArgumentException("E-post måste innehålla @(snabel-a)");
    }
    this.email = email.trim();
  }

  /**Simple method
   * @return phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**Simle method with trim
   * @param phoneNumber A number written with no letters or internal spaces
   */
  public void setPhoneNumber(String phoneNumber) {

    if (isAlphaOrSpace(phoneNumber.trim())) {
      throw new IllegalArgumentException("Skriv in ditt telefonnummer med enbart siffror.");
    }
    this.phoneNumber = phoneNumber;
  }

  private boolean isAlphaOrSpace(String name) {
    char[] chars = name.toCharArray();

    for (char c : chars) {
      if (!Character.isLetter(c) && c != ' ') {
        return false;
      }
    }

    return true;
  }

  private boolean containsAtmark(String email) {

    if (!email.contains("@")) {
      return false;
    }

    return true;
  }

}

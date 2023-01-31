package org.generation.naomdb.dto;

public class ChangePasswordDTO {

	private String password;
	private String newPassword;
	public ChangePasswordDTO(String password, String newPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
	} // constructor
	
	public ChangePasswordDTO() {} // constructor vacio

	public String getPassword() {
		return password;
	} // getPassword
	
	public void setPassword(String password) {
		this.password = password;
	} // setPassword
	
	public String getNewPassword() {
		return newPassword;
	} // getNewPassword
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	} // setNewPassword
	
	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", newPassword=" + newPassword + "]";
	} // toString
	
} // ChangePassword

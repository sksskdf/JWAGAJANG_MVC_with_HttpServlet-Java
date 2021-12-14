package member.model;

import java.sql.Timestamp;

public class Member {
	private String id;
	private String pwd;
	private String mobile;
	private String email;
	private String address;
	private String address2;
	private String address3;
	private int grade;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	
	public Member() { }
	
	public Member(String id,String pwd,String mobile,String email) {
		this.id = id;
		this.pwd = pwd;
		this.mobile = mobile;
		this.email = email;
	}
	
	public Member(String id, String pwd, String email, String mobile, int grade) {
		this.id = id;
		this.pwd = pwd;
		this.mobile = mobile;
		this.email = email;
		this.grade = grade;
	}

	public Member(String id, String pwd, String mobile, String email, String address, String address2,
			String address3) {
		this.id = id;
		this.pwd = pwd;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.address2 = address2;
		this.address3 = address3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", mobile=" + mobile + ", email=" + email + ", address=" + address
				+ ", address2=" + address2 + ", address3=" + address3 + ", grade=" + grade + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + "]";
	}

	

	
	
	
	
}

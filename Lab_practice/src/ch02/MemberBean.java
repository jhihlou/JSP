package ch02;

import java.io.Serializable;
import java.text.SimpleDateFormat;


public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String memberId;
	private String password;
	private String name;
	private String address;
	private String phone;
	private java.util.Date birthday;
	private java.sql.Timestamp registerDate;
	private double weight;
	//無參數建構子
	public MemberBean(){
	
	}
	public MemberBean(String memberId,String password,String name,
			String address,String phone,java.util.Date birthday,
			java.sql.Timestamp registerDate,double weight){
		this.memberId=memberId;
		this.password=password;
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.birthday=birthday;
		this.registerDate=registerDate;
		this.weight=weight;
	}
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static java.util.Date convertDate(String temp){
		java.util.Date result = new java.util.Date();
		try {
			result = sdf.parse(temp);
		}catch (java.text.ParseException e) {
			result = null;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "[" + memberId + password + name + address + phone + birthday + registerDate + weight + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public java.sql.Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(java.sql.Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}

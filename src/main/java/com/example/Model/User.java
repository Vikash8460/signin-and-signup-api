package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="l_data1")
public class User {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
   // private String pcard;
    private String emailId;
    private String password;
    private String cPassword;
    private String name;
    private String moblieno;
    private String padd;
    private String tadd;
    private String city;
    private String state;
    private String pcode;
	public User() {
		super();
	}
	public User(int id, String emailId, String password, String cPassword, String name, String moblieno, String padd,
			String tadd, String city, String state, String pcode) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.cPassword = cPassword;
		this.name = name;
		this.moblieno = moblieno;
		this.padd = padd;
		this.tadd = tadd;
		this.city = city;
		this.state = state;
		this.pcode = pcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMoblieno() {
		return moblieno;
	}
	public void setMoblieno(String moblieno) {
		this.moblieno = moblieno;
	}
	public String getPadd() {
		return padd;
	}
	public void setPadd(String padd) {
		this.padd = padd;
	}
	public String getTadd() {
		return tadd;
	}
	public void setTadd(String tadd) {
		this.tadd = tadd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + ", cPassword=" + cPassword
				+ ", name=" + name + ", moblieno=" + moblieno + ", padd=" + padd + ", tadd=" + tadd + ", city=" + city
				+ ", state=" + state + ", pcode=" + pcode + "]";
	}
    
	
    
}

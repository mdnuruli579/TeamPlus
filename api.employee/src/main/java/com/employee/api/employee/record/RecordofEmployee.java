package com.employee.api.employee.record;


import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;



import jakarta.persistence.*;

@Entity
@Table(name="Employee_Record")
public class RecordofEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	@Column(name="MOBILE")
	private long mobile;
	
	@Column(name="DOB")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date dob;
	
	@Column(name="salary")
	private String salary;
	
	@Column(name="email")
	private String email;
	
	@Column(name="city")
	private String city;
	
	public RecordofEmployee() {
	}
	public RecordofEmployee(int id, String name, String fatherName, long mobile, Date dob, String salary, String email,
			String city) {
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.mobile = mobile;
		this.dob = dob;
		this.salary = salary;
		this.email = email;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "RecordofEmployee [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", mobile=" + mobile
				+ ", dob=" + dob + ", salary=" + salary + ", email=" + email + ", city=" + city + "]";
	}
}

package fas.ict.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends Person{
    @Id
	private String EmpNo;
	private String name;
	private int age;
	private double salary;
	private String gender;
	@ManyToOne
	private Department department;
	@ManyToMany(mappedBy = "employees")
	private List<Project>projects;
}

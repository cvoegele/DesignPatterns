package patterns.clone.company;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	protected Company(Company source){
		this.name = source.name;
		this.employees = new ArrayList<>();
		for (var employee : source.employees){
			//if we clone each employee it also passes testDeep2
			employees.add(employee.clone());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}
	
	public int getSize() {
		return employees.size();
	}
	
	public void addEmployee(Employee p) {
		this.employees.add(p);
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			Company c = (Company) o;
			return name.equals(c.name) && employees.equals(c.employees);
		} else {
			return false;
		}
	}

	@Override
	public Company clone() {
		return new Company(this);
	}
}

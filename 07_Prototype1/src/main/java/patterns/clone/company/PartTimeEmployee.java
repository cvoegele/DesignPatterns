package patterns.clone.company;

public class PartTimeEmployee extends Employee {
	private int workload;

	public PartTimeEmployee(String name, int yearOfBirth, int workload) {
		super(name, yearOfBirth);
		this.workload = workload;
	}

	protected PartTimeEmployee(PartTimeEmployee source){
		super(source);
		this.workload = source.workload;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			PartTimeEmployee p = (PartTimeEmployee)o;
			return p.workload == workload && super.equals(o);
		} else {
			return false;
		}
	}

	@Override
	public PartTimeEmployee clone() {
		return new PartTimeEmployee(this);
	}
}

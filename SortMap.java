import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

import sortinginJAVA8.forEach2;

//import intervieOct_8.Employee;

public class SortMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		


		Map<String, Integer> hm = new HashMap<>();
		hm.put("eight", 8);
		hm.put("four", 4);
		hm.put("ten", 10);
		hm.put("two", 2);

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(hm.entrySet());
		Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getKey().compareTo(o2.getKey());
			}

		});

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + "-----------------" + entry.getValue());
		}

		// making use of LAMBDA EXPRESSION
		System.out.println("------------------------LAMBDA EXPRESSION-------------------");
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + "-----------------" + entry.getValue());
		}

		// USING stream API
		System.out.println("------------------------STREAM API-------------------");
		hm.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
		//EMPOYEE CLASS SORTING
		Map<Employee,Integer> employeMap=new TreeMap<>(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return (int) (o1.getSalary()-(o2.getSalary()));
			}
		});
		employeMap.put(new Employee(1,"Ritu","cse",25333), 11);
		employeMap.put(new Employee(4,"Mayuri","cse",7441), 125);
		employeMap.put(new Employee(3,"Shreya","ece",5000), 741);
		employeMap.put(new Employee(5,"Ranjita","is",300), 963);
		
		
		System.out.println("**********************Employee Map*************************************");

		System.out.println(employeMap);
		
		
		System.out.println("**********************Employee Map  LAMBDA APPROACH*************************************");
		
		Map<Employee,Integer> employeMap2=new TreeMap<>((o1,o2) -> (int)(o2.getSalary()-o1.getSalary()));
		employeMap2.put(new Employee(1,"Ritu","cse",25333), 11);
		employeMap2.put(new Employee(4,"Mayuri","cse",7441), 125);
		employeMap2.put(new Employee(3,"Shreya","ece",5000), 741);
		employeMap2.put(new Employee(5,"Ranjita","is",300), 963);
		System.out.println(employeMap2);
		
		System.out.println("**********************Employee Map  STREAM API*************************************");
		employeMap2.entrySet().stream().
		sorted(Map.Entry.
				comparingByKey
				(Comparator.comparing
						(Employee::getDept)
						.reversed())).
				forEach(System.out::println);


}
}

class Employee{
	 int id;
	 String name;
	 String dept;
	 long salary;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Employee(int id, String name, String dept, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dept, id, name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dept, other.dept) && id == other.id && Objects.equals(name, other.name)
				&& salary == other.salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
}

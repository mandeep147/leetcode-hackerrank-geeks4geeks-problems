/**
 * Problem 690. Employee Importance
 * 
 */
package mandeep.leetcode.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mandeep
 *
 */
public class EmployeeImportance {

	private static Map<Integer, Employee> map;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, 5, Arrays.asList(2, 3) );
		Employee emp2 = new Employee(2, 3, Arrays.asList() );
		Employee emp3 = new Employee(3, 3, Arrays.asList() );
		int id = 1;
		List<Employee> emp = Arrays.asList(emp1, emp2, emp3);
		
		int importance = getImportance(emp, id);
		System.out.println("importance of employee "+id+" is: "+importance);
	}
	
	/**
	 * Time = Space = O(n)
	 * @param emp
	 * @param id
	 * @return
	 */
	private static int getImportance(List<Employee> emp, int id){
		map = new HashMap<>();
		for(Employee e: emp)
			map.put(e.id, e);
			
		return dfs(id);
	}

	/**
	 * @param id
	 * @return
	 */
	private static int dfs(int id) {
		Employee emp = map.get(id);
		int res = emp.importance;
		for(int sub: emp.subordinates)
			res += dfs(sub);
		return res;
	}

}

class Employee{
	public int id;
	public int importance;
	public List<Integer> subordinates;
	
	public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
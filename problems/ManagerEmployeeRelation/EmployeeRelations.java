package problems.ManagerEmployeeRelation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRelations {
    int employeeId;
    String employeeName;
    int managerId;
    String ManagerName;

   public EmployeeRelations() {
    }
    public EmployeeRelations(int employeeId, String employeeName, int managerId, String ManagerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.ManagerName = ManagerName;
    }
    // Logic to get the manager who has more than 5 employees
    public static List<String> getManagerEmployeeRelation(List<EmployeeRelations> employees){
        Map<String, List<String>> managerEmployeeMap = new HashMap<>();
        for(EmployeeRelations emp : employees){
            managerEmployeeMap
           .computeIfAbsent(emp.ManagerName, k -> new ArrayList<>())
           .add(emp.employeeName);

        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : managerEmployeeMap.entrySet()){
            if(entry.getValue().size() > 5){
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        
        ArrayList<EmployeeRelations> employees = new ArrayList<>();
        employees.add(new EmployeeRelations(1, "Alice", 2, "Bob"));
        employees.add(new EmployeeRelations(2, "Bob", 3, "Charlie"));
        employees.add(new EmployeeRelations(3, "Charlie", 3, "Charlie"));
        employees.add(new EmployeeRelations(4, "David", 3, "Charlie"));
        employees.add(new EmployeeRelations(5, "Eve", 1, "Alice"));
        employees.add(new EmployeeRelations(6, "Frank", 1, "Alice"));
        employees.add(new EmployeeRelations(7, "George", 1, "Alice"));
        employees.add(new EmployeeRelations(8, "Hannah", 1, "Alice"));
        employees.add(new EmployeeRelations(9, "Ivan", 1, "Alice"));
        employees.add(new EmployeeRelations(10, "Jack", 1, "Alice"));
        employees.add(new EmployeeRelations(11, "Kevin", 3, "Charlie"));
        employees.add(new EmployeeRelations(12, "Liam", 3, "Charlie"));
        employees.add(new EmployeeRelations(13, "Mason", 3, "Charlie"));
        System.out.println(getManagerEmployeeRelation(employees));
    }

}

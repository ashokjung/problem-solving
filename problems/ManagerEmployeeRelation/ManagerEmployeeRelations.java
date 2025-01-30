package problems.ManagerEmployeeRelation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerEmployeeRelations {

    int employeeId;
    String employeeName;
    int managerId;
    String ManagerName;

    public ManagerEmployeeRelations(int employeeId, String employeeName, int managerId, String ManagerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.ManagerName = ManagerName;
    }

     public static void main(String[] args){
        List<ManagerEmployeeRelation> employees = new ArrayList<>();
        employees.add(new ManagerEmployeeRelation(1, "Alice", 2, "Bob"));
        employees.add(new ManagerEmployeeRelation(2, "Bob", 3, "Charlie"));
        employees.add(new ManagerEmployeeRelation(3, "Charlie", 3, "Charlie"));
        employees.add(new ManagerEmployeeRelation(4, "David", 3, "Charlie"));   
        employees.add(new ManagerEmployeeRelation(5, "Eve", 1, "Alice"));           
        employees.add(new ManagerEmployeeRelation(6, "Frank", 1, "Alice")); 
        employees.add(new ManagerEmployeeRelation(7, "George", 1, "Alice"));
        employees.add(new ManagerEmployeeRelation(8, "Hannah", 1, "Alice"));    
        employees.add(new ManagerEmployeeRelation(9, "Ivan", 1, "Alice"));
        employees.add(new ManagerEmployeeRelation(10, "Jack", 1, "Alice"));
        employees.add(new ManagerEmployeeRelation(11, "Kevin", 3, "Charlie"));
        employees.add(new ManagerEmployeeRelation(12, "Liam", 3, "Charlie"));
        employees.add(new ManagerEmployeeRelation(13, "Mason", 3, "Charlie"));
        System.out.println(getManagerEmployeeRelation(employees));
    
    }

    public static List<String> getManagerEmployeeRelation(List<ManagerEmployeeRelation> employees){
            Map<String, List<String>> managerEmployeeMap = new HashMap<>();
            for(ManagerEmployeeRelation emp : employees){
                
                managerEmployeeMap
               .computeIfAbsent(emp.ManagerName, k -> new ArrayList<>())
               .add(emp.employeeName);

          /*   if(managerEmployeeMap.containsKey(emp.ManagerName)){
                managerEmployeeMap.get(emp.ManagerName).add(emp.employeeName);
            }else{
                List<String> employeeList = new ArrayList<>();
                employeeList.add(emp.employeeName);
                managerEmployeeMap.put(emp.ManagerName, employeeList);
            } */
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
}
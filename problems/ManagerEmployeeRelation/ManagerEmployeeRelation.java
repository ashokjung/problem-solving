package problems.ManagerEmployeeRelation;
import java.util.ArrayList;
import java.util.*;

public class ManagerEmployeeRelation {
    int employeeId;
    String employeeName;
    int managerId;
    String ManagerName;

    public ManagerEmployeeRelation() {
    }
    
    public ManagerEmployeeRelation(int employeeId, String employeeName, int managerId, String ManagerName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.managerId = managerId;
        this.ManagerName = ManagerName;
    }

    public static void main(String[] args){
        ArrayList<ManagerEmployeeRelation> employees = new ArrayList<>();
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
        employees.add(new ManagerEmployeeRelation(11, "Kevin", 1, "Alice"));
        employees.add(new ManagerEmployeeRelation(12, "Liam", 1, "Alice"));
        employees.add(new ManagerEmployeeRelation(13, "Mason", 1, "Alice"));
        System.out.println(new ManagerEmployeeRelation().getManagerEmployeeRelation(employees));

    }
    public List<String> getManagerEmployeeRelation(ArrayList<ManagerEmployeeRelation> employees){
        Map<String, List<String>> managerEmployeeMap = new HashMap<>();
        for(ManagerEmployeeRelation emp : employees){
            if(managerEmployeeMap.containsKey(emp.ManagerName)){
                managerEmployeeMap.get(emp.ManagerName).add(emp.employeeName);
            }else{
                List<String> employeeList = new ArrayList<>();
                employeeList.add(emp.employeeName);
                managerEmployeeMap.put(emp.ManagerName, employeeList);
            }
        }
        List<String> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : managerEmployeeMap.entrySet()){
            if(entry.getValue().size() > 5){
                result.add(entry.getKey());
            }
        }
        return result;
    }


    
}

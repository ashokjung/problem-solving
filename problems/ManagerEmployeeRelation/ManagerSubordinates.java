package problems.ManagerEmployeeRelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagerSubordinates {


     

    public static void main(String[] args)
    {
        ArrayList<Employee> employees = new ArrayList<>();
        // Add sample employee data
        employees.add(new Employee(1, "Alice", 2));
        employees.add(new Employee(2, "Bob", 3));
        employees.add(new Employee(3, "Charlie", 3));
        employees.add(new Employee(4, "David", 3));
        employees.add(new Employee(5, "Eve", 1));
        employees.add(new Employee(6, "Frank", 1));

        Map<Integer, Integer> managerCount = new HashMap<>();
        for (Employee emp : employees) {
            managerCount.put(emp.managerId, managerCount.getOrDefault(emp.managerId, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : managerCount.entrySet()) {
            if (entry.getValue() > 2) {
                // Find the manager name using the managerId
                for (Employee emp : employees) {
                    if (emp.id == entry.getKey()) {
                        System.out.println("Manager with more than 5 subordinates: " + emp.name);
                        break;
                    }
                }
            }
        }
    }
    }
    

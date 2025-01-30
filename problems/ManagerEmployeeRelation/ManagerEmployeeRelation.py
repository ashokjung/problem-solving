from collections import defaultdict

class ManagerEmployeeRelation:
    def __init__(self, employee_id=None, employee_name=None, manager_id=None, manager_name=None):
        self.employee_id = employee_id
        self.employee_name = employee_name
        self.manager_id = manager_id
        self.manager_name = manager_name

    @staticmethod
    def get_manager_employee_relation(employees):
        manager_employee_map = defaultdict(list)
        
        for emp in employees:
            manager_employee_map[emp.manager_name].append(emp.employee_name)
        
        result = [manager for manager, employees in manager_employee_map.items() if len(employees) > 5]
        return result

if __name__ == "__main__":
    employees = [
        ManagerEmployeeRelation(1, "Alice", 2, "Bob"),
        ManagerEmployeeRelation(2, "Bob", 3, "Charlie"),
        ManagerEmployeeRelation(3, "Charlie", 3, "Charlie"),
        ManagerEmployeeRelation(4, "David", 3, "Charlie"),
        ManagerEmployeeRelation(5, "Eve", 1, "Alice"),
        ManagerEmployeeRelation(6, "Frank", 1, "Alice"),
        ManagerEmployeeRelation(7, "George", 1, "Alice"),
        ManagerEmployeeRelation(8, "Hannah", 1, "Alice"),
        ManagerEmployeeRelation(9, "Ivan", 1, "Alice"),
        ManagerEmployeeRelation(10, "Jack", 1, "Alice"),
        ManagerEmployeeRelation(11, "Kevin", 3, "Charlie"),
        ManagerEmployeeRelation(12, "Liam", 3, "Charlie"),
        ManagerEmployeeRelation(13, "Mason", 3, "Charlie")
    ]
    
    print(ManagerEmployeeRelation.get_manager_employee_relation(employees))


using System;
using System.Collections.Generic;
using System.Linq;

class ManagerEmployeeRelation
{
    public int EmployeeId { get; set; }
    public string EmployeeName { get; set; }
    public int ManagerId { get; set; }
    public string ManagerName { get; set; }

    public ManagerEmployeeRelation(int employeeId, string employeeName, int managerId, string managerName)
    {
        EmployeeId = employeeId;
        EmployeeName = employeeName;
        ManagerId = managerId;
        ManagerName = managerName;
    }

    public static List<string> GetManagerEmployeeRelation(List<ManagerEmployeeRelation> employees)
    {
        Dictionary<string, List<string>> managerEmployeeMap = new Dictionary<string, List<string>>();

        foreach (var emp in employees)
        {
            if (!managerEmployeeMap.ContainsKey(emp.ManagerName))
            {
                managerEmployeeMap[emp.ManagerName] = new List<string>();
            }
            managerEmployeeMap[emp.ManagerName].Add(emp.EmployeeName);
        }

        return managerEmployeeMap.Where(entry => entry.Value.Count > 5)
                                 .Select(entry => entry.Key)
                                 .ToList();
    }

    public static void Main()
    {
        List<ManagerEmployeeRelation> employees = new List<ManagerEmployeeRelation>
        {
            new ManagerEmployeeRelation(1, "Alice", 2, "Bob"),
            new ManagerEmployeeRelation(2, "Bob", 3, "Charlie"),
            new ManagerEmployeeRelation(3, "Charlie", 3, "Charlie"),
            new ManagerEmployeeRelation(4, "David", 3, "Charlie"),
            new ManagerEmployeeRelation(5, "Eve", 1, "Alice"),
            new ManagerEmployeeRelation(6, "Frank", 1, "Alice"),
            new ManagerEmployeeRelation(7, "George", 1, "Alice"),
            new ManagerEmployeeRelation(8, "Hannah", 1, "Alice"),
            new ManagerEmployeeRelation(9, "Ivan", 1, "Alice"),
            new ManagerEmployeeRelation(10, "Jack", 1, "Alice"),
            new ManagerEmployeeRelation(11, "Kevin", 3, "Charlie"),
            new ManagerEmployeeRelation(12, "Liam", 3, "Charlie"),
            new ManagerEmployeeRelation(13, "Mason", 3, "Charlie")
        };

        List<string> result = GetManagerEmployeeRelation(employees);
        Console.WriteLine(string.Join(", ", result));
    }
}

# Write your MySQL query statement below
SELECT e1.name AS Employee
FROM Employee e1
WHERE e1.salary > (SElECT e2.salary FROM employee e2 WHERE e1.managerID = e2.id );
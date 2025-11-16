# Write your MySQL query statement below

SELECT 
    c.name as Customers
FROM
    customers as c
LEFT JOIN
    orders as o
    ON o.customerId=c.id
WHERE
    o.id is NULL
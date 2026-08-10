CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n=n-1;
  RETURN (
      select distinct salary from Employee order by salary desc LIMIT 1 OFFSET N  

  );
END
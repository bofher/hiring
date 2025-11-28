CREATE FUNCTION TopDeptSalaries(@DeptID INT)
    RETURNS TABLE
AS
    RETURN (
    SELECT
        p.id,
        p.title,
        p.salary,
        p.department_id,
        ISNULL(c.NAME, N'Не має робітника') AS UserName
    FROM position p
    LEFT JOIN application a
    ON p.id = a.position_id
    LEFT JOIN candidate c
    ON a.candidate_id = c.id
    WHERE p.department_id = @DeptID
    AND p.SALARY = (
        SELECT MAX(SALARY)
        FROM position
        WHERE p.department_id = @DeptID
    )
);
GO
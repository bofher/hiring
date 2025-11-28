CREATE PROCEDURE mark_salaries
    @dept_id INT
AS
BEGIN
    DECLARE  @max_salary DECIMAL (10,2),
             @limit DECIMAL(10,2);

    SELECT @max_salary = MAX(salary)
    FROm position
    WHERE department_id = @dept_id;

    IF @max_salary IS NULL RETURN;
    SET @limit = @max_salary * 0.75;

    UPDATE position
    SET description = REPLACE(description, N'(Висока заробітна плата)', '')
    WHERE department_id = @dept_id;

    UPDATE position
    SET description =
        CASE
            WHEN description IS NULL
                THEN N'(Висока заробітна плата)'
            ELSE
                description + N'(Висока заробітна плата)'
            END
    WHERE department_id = @dept_id
    AND salary > @limit;
end
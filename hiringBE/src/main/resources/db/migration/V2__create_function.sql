CREATE FUNCTION get_count_by_region(@region VARCHAR(50))
    RETURNS INT
AS
BEGIN
    RETURN (
        SELECT COUNT(*)
        FROM candidate
        WHERE ADDRESS LIKE '%' + @region + '%'
    );
END;
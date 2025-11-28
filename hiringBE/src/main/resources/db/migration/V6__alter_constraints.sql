ALTER TABLE application
    DROP CONSTRAINT FK_application_candidate;

ALTER TABLE application
    DROP CONSTRAINT FK_application_position;

ALTER TABLE position
    DROP CONSTRAINT FK_position_department;

ALTER TABLE position
ADD CONSTRAINT FK_position_department
    FOREIGN KEY (department_id)
    REFERENCES department(id)
    ON DELETE CASCADE;

ALTER TABLE application
ADD CONSTRAINT FK_application_position
    FOREIGN KEY (position_id)
    REFERENCES position(id)
    ON DELETE CASCADE;

ALTER TABLE application
ADD CONSTRAINT FK_application_candidate
    FOREIGN KEY (candidate_id)
    REFERENCES candidate(id)
    ON DELETE NO ACTION;
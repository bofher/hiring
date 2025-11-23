
CREATE TABLE department (
                            id INT IDENTITY(1,1) PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description VARCHAR(500)
);

CREATE TABLE candidate (
                           id INT IDENTITY(1,1) PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           phone VARCHAR(50),
                           address VARCHAR(500),
                           info VARCHAR(MAX)
    );

CREATE TABLE position (
                          id INT IDENTITY(1,1) PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          salary NUMERIC(10, 2),
                          requirements VARCHAR(MAX),
    department_id INT NOT NULL,
    CONSTRAINT FK_position_department FOREIGN KEY (department_id) 
        REFERENCES department(id)
);

CREATE TABLE application (
                             id INT IDENTITY(1,1) PRIMARY KEY,
                             candidate_id INT NOT NULL,
                             position_id INT NOT NULL,
                             status VARCHAR(50) NOT NULL DEFAULT 'NEW',
                             date_apply DATE DEFAULT CAST(GETDATE() AS DATE),
                             CONSTRAINT FK_application_candidate FOREIGN KEY (candidate_id)
                                 REFERENCES candidate(id),
                             CONSTRAINT FK_application_position FOREIGN KEY (position_id)
                                 REFERENCES position(id)
);

-- Индексы
CREATE INDEX IX_position_department ON position(department_id);
CREATE INDEX IX_application_candidate ON application(candidate_id);
CREATE INDEX IX_application_position ON application(position_id);
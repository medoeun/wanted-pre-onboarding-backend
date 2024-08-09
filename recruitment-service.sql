create database recruitment;

create table company (
	company_id int auto_increment primary key,
    company_name varchar(255)
);

create table users (
	user_id int auto_increment primary key,
    user_name varchar(20)
);

CREATE TABLE jobposting (
    posting_id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    position VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    country VARCHAR(50) NOT NULL,
    district VARCHAR(100) NOT NULL,
    reward DECIMAL(10, 2) NOT NULL,
    skills TEXT NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);

create table jobapplication (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    posting_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (posting_id) REFERENCES JobPosting(posting_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

INSERT INTO Company (company_name) VALUES
('원티드코리아'),
('네이버'),
('원티드랩'),
('카카오'),
('인프런');

INSERT INTO Users (user_name) VALUES
('김지은'),
('이동욱'),
('박소연'),
('최재혁'),
('정하나');


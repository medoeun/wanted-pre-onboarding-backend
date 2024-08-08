create database recruitment;

create table company (
	company_id int auto_increment primary key,
    company_name varchar(255)
);

select * from company;
drop table company;

create table users (
	user_id int auto_increment primary key,
    user_name varchar(20)
);

select * from users;
drop table users;

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

select * from jobposting;
drop table jobposting;

create table jobapplication (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    posting_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (posting_id) REFERENCES JobPosting(posting_id),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

select * from jobapplication;
drop table jobapplication;

INSERT INTO Company (company_name) VALUES
('테크 이노베이션'),
('헬스 솔루션즈'),
('그린 에너지'),
('퀀텀 애널리틱스'),
('글로벌 테크 어드밴스먼트');

UPDATE Company SET company_name = "원티드랩" WHERE company_id = 3;
UPDATE Company SET company_name = "원티드코리아" WHERE company_id = 1;
UPDATE Company SET company_name = "네이버" WHERE company_id = 2;
UPDATE Company SET company_name = "카카오" WHERE company_id = 4;
UPDATE Company SET company_name = "인프런" WHERE company_id = 5;

INSERT INTO Users (user_name) VALUES
('김지은'),
('이동욱'),
('박소연'),
('최재혁'),
('정하나');

ALTER USER 'root'@'localhost' IDENTIFIED BY 'abcd123';

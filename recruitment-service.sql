create database recruitment;

create table company (
	company_id int auto_increment primary key,
    company_name varchar(255)
);

select * from company;
drop table company;

create table user (
	user_id int auto_increment primary key,
    user_name varchar(20)
);

select * from user;
drop table user;

CREATE TABLE JobPostings (
    job_posting_id INT AUTO_INCREMENT PRIMARY KEY,
    company_id INT NOT NULL,
    country VARCHAR(50) NOT NULL,
    district VARCHAR(100) NOT NULL,
    position VARCHAR(255) NOT NULL,
    reward DECIMAL(10, 2) NOT NULL,
    skills TEXT NOT NULL,
    description TEXT NOT NULL,
    FOREIGN KEY (company_id) REFERENCES company(company_id)
);

select * from jobpostings;
drop table jobpostings;

create table jobapplications (
    application_id INT AUTO_INCREMENT PRIMARY KEY,
    job_posting_id INT NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (job_posting_id) REFERENCES JobPostings(job_posting_id),
    FOREIGN KEY (user_id) REFERENCES User(user_id)
);

select * from jobapplications;
drop table jobapplications;

INSERT INTO Company (company_name) VALUES
('테크 이노베이션'),
('헬스 솔루션즈'),
('그린 에너지'),
('퀀텀 애널리틱스'),
('글로벌 테크 어드밴스먼트');


INSERT INTO User (user_name) VALUES
('김지은'),
('이동욱'),
('박소연'),
('최재혁'),
('정하나');



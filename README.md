# 기업 채용 웹 서비스 :briefcase:

## 목차

1. [개요](#-개요)
2. [주요 기능](#주요-기능)
3. [설치 및 실행](#설치-및-실행)
4. [디렉토리 구조](#디렉토리-구조)

<br>

## :heavy_check_mark: 개요

- 기업의 채용을 위한 간단한 웹 서비스 api입니다.
- 회사는 채용공고를 생성하고, 사용자는 지원합니다.
<br>

  ### :hammer: 개발 환경 및 기술
  
  - **언어**: Java 17
  - **프레임워크**: Spring Boot 3.3.2
  - **빌드 도구**: Gradle
  - **데이터베이스**: MySQL
  - **ORM**: Spring Data JPA (Hibernate)
  - **테스트**: JUnit 5, Mockito
 <br>
 
  ### :date: 개발 기간
  2024.08.06 ~ 2024.08.09
  
<br>

## :heavy_check_mark: 주요 기능

- **채용공고 관리**  
  - 새로운 채용공고를 등록하고, 기존 공고를 수정하거나 삭제할 수 있습니다.
  
- **채용공고 목록 및 상세조회**  
  - 채용공고 목록을 조회하고, 특정 키워드로 검색할 수 있습니다.
  - 선택한 공고의 상세 정보와 해당 회사의 다른 공고를 확인할 수 있습니다.

- **채용공고 지원**  
  - 사용자가 채용공고에 지원합니다. 각 공고당 1회만 가능합니다.



<br>

## :heavy_check_mark: 설치 및 실행

```bash
git clone https://github.com/medoeun/wanted-pre-onboarding-backend.git
```
<br>

- MySql 설정
```sql
CREATE DATABASE recruitment;
```
- `application.yml`에서 데이터베이스 설정 수정
```yml
spring:
  datasource:
    url: jdbc:mysql://localhost/recruitment
    username: username
    password: password
```
<br>

- `recruitment-service.sql` 파일을 참고하여 초기 테이블과 데이터를 등록
<br>

- Gradle 빌드 및 실행
```bash
./gradlew build
./gradlew bootRun
```
<br>

- 테스트
```bash
./gradlew test
```
## :heavy_check_mark: 디렉토리 구조
```plaintext
src
└── main
    └── java
        └── com.group.recruitment
            ├── controller
            │   └── jobposting
            │       └── JobPostingController.java
            ├── domain
            │   ├── company
            │   │   └── Company.java
            │   ├── job
            │   │   ├── JobApplication.java
            │   │   └── JobPosting.java
            │   └── user
            │       └── User.java
            ├── dto
            │   ├── company
            │   │   └── CompanyDTO.java
            │   └── job
            │       ├── CreateJobPostingDTO.java
            │       ├── JobApplicationDTO.java
            │       ├── JobPostingDetailDTO.java
            │       └── JobPostingDTO.java
            ├── repository
            │   ├── company
            │   │   └── CompanyRepository.java
            │   └── job
            │       ├── JobApplicationRepository.java
            │       └── JobPostingRepository.java
            └── service
                ├── JobApplicationService.java
                └── JobPostingService.java
```






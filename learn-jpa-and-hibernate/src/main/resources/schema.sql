-- 릴레이션의 이름과 초기 제약조건을 명시하여 새로운 릴레이션(테이블) 생성하는 데 사용
-- 각 속성 마다 이름, 도메인 명시하는 데이터 타입, not null 같은 제약조건 기술함

create table course (
	id bigint not null,
	name varchar(255) not null,
	author varchar(255) not null,
	primary key (id)


);
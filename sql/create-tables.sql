DROP TABLE IF EXISTS helpers.helper;
DROP DATABASE IF EXISTS helpers;
DROP TABLE IF EXISTS users.user;

CREATE TABLE users.user (
	id BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	last_name VARCHAR(255) NOT NULL,
	first_name VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	role BIGINT(20) NOT NULL,
	CONSTRAINT users_user_email_unique UNIQUE(email),
	CONSTRAINT users_user_username_unique UNIQUE(username)
);

INSERT INTO users.user (last_name, first_name, email, username, password, role)
VALUES('Hobson', 'David', 'jtcotton63+david@gmail.com', 'david', 'asdfasdf', 1);
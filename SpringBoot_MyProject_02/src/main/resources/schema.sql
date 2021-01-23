DROP TABLE IF EXISTS PACKAGES;

CREATE TABLE IF NOT EXISTS PACKAGES (
title VARCHAR(64),
number_of_pages INT,
number_of_page_elements INT,
ssl BOOLEAN,
message_sending BOOLEAN,
database_type VARCHAR(64),
multi_language BOOLEAN,
site_search BOOLEAN,
blogging BOOLEAN,
animations BOOLEAN,
user_authentication BOOLEAN,
newsletter_service BOOLEAN,
pagination BOOLEAN,
price int
);

DROP TABLE IF EXISTS BLOGS;

CREATE TABLE IF NOT EXISTS BLOGS (
id INT AUTO_INCREMENT PRIMARY KEY,
title  VARCHAR_IGNORECASE  NOT NULL,
blog  CLOB NOT NULL,
posted VARCHAR(64)
);

DROP TABLE IF EXISTS images;

CREATE TABLE IF NOT EXISTS images (
id VARCHAR(64) PRIMARY KEY, 
name VARCHAR(64),
posted VARCHAR(64)
);




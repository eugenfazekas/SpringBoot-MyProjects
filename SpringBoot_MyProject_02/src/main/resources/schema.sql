DROP TABLE IF EXISTS PACKAGES;

CREATE TABLE IF NOT EXISTS PACKAGES (
title VARCHAR(64) NOT NULL  ,
description1 VARCHAR(64),
description2 VARCHAR(64),
description3 VARCHAR(64),
description4 VARCHAR(64),
description5 VARCHAR(64),
description6 VARCHAR(64),
description7 VARCHAR(64),
description8 VARCHAR(64),
description9 VARCHAR(64),
description10 VARCHAR(64),
description11 VARCHAR(64),
description12 VARCHAR(64),
description13 VARCHAR(64),
description14 VARCHAR(64),
description15 VARCHAR(64),
price int NOT NULL
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
id INT AUTO_INCREMENT PRIMARY KEY, 
name VARCHAR(64)
);




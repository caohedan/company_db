CREATE TABLE `oocl_company`(
 `id`        BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `name`                VARCHAR(255) Not NULL ,
   `create_date`          TIMESTAMP DEFAULT NOW()
)

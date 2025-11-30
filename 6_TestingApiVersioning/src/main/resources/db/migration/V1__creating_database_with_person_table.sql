CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birth_day` date DEFAULT NULL,
  `email` varchar(255) NOT NULL UNIQUE,
  `name` varchar(255) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
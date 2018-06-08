-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS `delete_history`;
DROP TABLE IF EXISTS `answer`;
DROP TABLE IF EXISTS `question`;

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `account_expired` tinyint(1) DEFAULT '0',
  `account_locked` tinyint(1) DEFAULT '0',
  `credentials_expired` tinyint(1) DEFAULT '0',
  `disabled` tinyint(1) DEFAULT '0',
  `email` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  KEY `fk_user_role` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `contents` longtext,
  `deleted` bit(1) NOT NULL,
  `title` varchar(100) NOT NULL,
  `writer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_writer` (`writer_id`),
  CONSTRAINT `fk_question_writer` FOREIGN KEY (`writer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `contents` longtext,
  `deleted` bit(1) NOT NULL,
  `question_id` bigint(20) DEFAULT NULL,
  `writer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_answer_to_question` (`question_id`),
  KEY `fk_answer_writer` (`writer_id`),
  CONSTRAINT `fk_answer_to_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`),
  CONSTRAINT `fk_answer_writer` FOREIGN KEY (`writer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `delete_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_id` bigint(20) DEFAULT NULL,
  `content_type` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `deleted_by_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_deletehistory_to_user` (`deleted_by_id`),
  CONSTRAINT `fk_deletehistory_to_user` FOREIGN KEY (`deleted_by_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
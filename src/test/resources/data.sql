-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO `role` (`id`, `create_date`, `modified_date`, `name`)
VALUES
	(1,NULL,NULL,'ROLE_USER'),
	(2,NULL,NULL,'ROLE_PREMIUM_USER');

INSERT INTO `user` (`id`, `create_date`, `modified_date`, `account_expired`, `account_locked`, `credentials_expired`, `disabled`, `email`, `name`, `password`, `role_id`)
VALUES
	(1,NULL,NULL,0,0,0,0,'dmp@widerplanet.com','DMP테스터','$2a$10$pzq1/bannzASstJAyzB2..NRJaYODp1Rfv27P0HRLzSbJa5ltTUCa',2),
	(2,NULL,NULL,0,0,0,0,'jg.jo@widerplanet.com','조종균','$2a$10$pzq1/bannzASstJAyzB2..NRJaYODp1Rfv27P0HRLzSbJa5ltTUCa',1);


INSERT INTO `question` (`id`, `create_date`, `modified_date`, `contents`, `deleted`, `title`, `writer_id`)
VALUES
	(1,NULL,NULL,'질문1',b'0','질문내용1',1),
	(2,NULL,NULL,'질문2',b'0','질문내용2',2),
	(3,NULL,NULL,'질문3',b'0','질문내용3',1),
	(4,NULL,NULL,'질문4',b'0','질문내용4',2),
	(5,NULL,NULL,'질문5',b'0','질문내용5',1),
	(6,NULL,NULL,'질문6',b'0','질문내용6',2),
	(7,NULL,NULL,'질문7',b'0','질문내용7',1),
	(8,NULL,NULL,'질문8',b'1','질문내용8',2),
	(9,NULL,NULL,'질문9',b'0','질문내용9',1),
	(10,NULL,NULL,'질문10',b'0','질문내용10',2),
	(11,NULL,NULL,'질문11',b'0','질문내용11',1),
	(12,NULL,NULL,'질문12',b'0','질문내용12',2),
	(13,NULL,NULL,'질문13',b'0','질문내용13',1),
	(14,NULL,NULL,'질문14',b'0','질문내용14',2),
	(15,NULL,NULL,'질문15',b'0','질문내용15',1),
	(16,NULL,NULL,'질문16',b'0','질문내용16',2),
	(17,NULL,NULL,'질문17',b'0','질문내용17',1),
	(18,NULL,NULL,'질문18',b'1','질문내용18',2),
	(19,NULL,NULL,'질문19',b'0','질문내용19',1),
	(20,NULL,NULL,'질문20',b'0','질문내용20',2),
	(21,NULL,NULL,'질문21',b'0','질문내용21',1),
	(22,NULL,NULL,'질문22',b'0','질문내용22',2),
	(23,NULL,NULL,'질문23',b'0','질문내용23',1),
	(24,NULL,NULL,'질문24',b'0','질문내용24',2),
	(25,NULL,NULL,'질문25',b'0','질문내용25',1),
	(26,NULL,NULL,'질문26',b'0','질문내용26',2),
	(27,NULL,NULL,'질문27',b'0','질문내용27',1),
	(28,NULL,NULL,'질문28',b'1','질문내용28',2),
	(29,NULL,NULL,'질문29',b'0','질문내용29',1),
	(30,NULL,NULL,'질문30',b'0','질문내용30',2),
	(31,NULL,NULL,'질문31',b'0','질문내용31',1);

INSERT INTO `answer` (`id`, `create_date`, `modified_date`, `contents`, `deleted`, `question_id`, `writer_id`)
VALUES
	(1,NULL,NULL,'질문1에 대한 답변 1',b'0',1,1),
	(2,NULL,NULL,'질문1에 대한 답변 2',b'0',1,1);
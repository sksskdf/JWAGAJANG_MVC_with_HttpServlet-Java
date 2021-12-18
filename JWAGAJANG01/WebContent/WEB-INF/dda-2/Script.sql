--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `jwagajang`.`notice` DROP PRIMARY KEY;

DROP TABLE `jwagajang`.`notice`;

CREATE TABLE `jwagajang`.`notice` (
	`notice_code` INT NOT NULL,
	`notice_label` VARCHAR(12) NOT NULL,
	`notice_title` VARCHAR(100) NOT NULL,
	`notice_regdate` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	`notice_editdate` TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP',
	`notice_content` TEXT NOT NULL,
	`notice_count` INT DEFAULT 0,
	PRIMARY KEY (`notice_code`)
);


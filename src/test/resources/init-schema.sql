DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
`Adminid` int(16) NOT NULL AUTO_INCREMENT,
`UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`PassWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`Adminid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
;

DROP TABLE IF EXISTS `optionproject`;
CREATE TABLE `optionproject` (
`Questionid` int(16) NOT NULL AUTO_INCREMENT,
`Optionid` int(16) NOT NULL,
`Option` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`Count` int(16) NULL DEFAULT NULL,
PRIMARY KEY (`Questionid`, `Optionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
;

DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
`Questionid` int(16) NOT NULL,
`Optionid` int(16) NOT NULL,
`UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`Questionid`, `Optionid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`Userid` int(16) NOT NULL AUTO_INCREMENT,
`UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`PassWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
PRIMARY KEY (`Userid`)
);

DROP TABLE IF EXISTS `voteoption`;
CREATE TABLE `voteoption` (
`Questionid` int(16) NOT NULL AUTO_INCREMENT,
`QuestionName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
`Type` int(2) NOT NULL,
PRIMARY KEY (`Questionid`)
);

DROP TABLE IF EXISTS `loginticket`;
CREATE TABLE `loginticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userid` INT NOT NULL,
  `ticket` VARCHAR(45) NOT NULL,
  `expired` DATETIME NOT NULL,
  `status` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`);
);
  DROP TABLE IF EXISTS `adminloginticket`;
  CREATE TABLE `adminloginticket` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adminid` INT NOT NULL,
  `ticket` VARCHAR(45) NOT NULL,
  `expired` DATETIME NOT NULL,
  `status` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`);
);

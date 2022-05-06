CREATE TABLE `author`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `name`  varchar(100) DEFAULT NULL,
    `phone` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into author (`name`, `phone`) values ("erlie", "15810554635");

CREATE TABLE `book`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `authorId` int(11) DEFAULT NULL,
    `name`     varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into book(`authorId`, `name`) values (1, "理想国");



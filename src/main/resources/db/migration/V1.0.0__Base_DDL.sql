CREATE TABLE `user` (
                        `birthday` date DEFAULT NULL,
                        `id` bigint(20) NOT NULL,
                        `city` varchar(255) DEFAULT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `firstname` varchar(255) DEFAULT NULL,
                        `lastname` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `street_name` varchar(255) DEFAULT NULL,
                        `street_nr` varchar(255) DEFAULT NULL,
                        `username` varchar(255) DEFAULT NULL,
                        `zip_code` varchar(10) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


CREATE TABLE `category` (
                            `active` tinyint(4) DEFAULT NULL,
                            `id` int(11) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

CREATE TABLE `product` (
                           `category_id` int(11) DEFAULT NULL,
                           `price` float DEFAULT NULL,
                           `stock` int(11) DEFAULT NULL,
                           `id` bigint(20) NOT NULL,
                           `description` mediumtext DEFAULT NULL,
                           `image` varchar(1000) DEFAULT NULL,
                           `name` varchar(500) DEFAULT NULL,
                           `sku` varchar(100) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
                           CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;


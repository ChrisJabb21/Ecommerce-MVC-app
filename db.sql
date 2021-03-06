

USE `sql9379333`;

--For customers 
 CREATE TABLE `sql9379333`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `password` VARCHAR(68) NOT NULL,
  `enabled` ENUM("true", "false") NOT NULL DEFAULT "true", --Change in db --Not showing up in database
  `fullname` VARCHAR(50) NULL,
  `phone_number` VARCHAR(22) NULL,
  `shipping_address` VARCHAR(100) NULL,
  `billing_address` VARCHAR(100) NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

--Roles and priviledges for User and Admin for login and registration and customizated page views
--Where to put address

--Not used
CREATE TABLE `sql9379333`.`billing_address`(

`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT NOT NULL,
`name` VARCHAR(50) NOT NULL,
`city` VARCHAR(50) NOT NULL,
`state` VARCHAR(50) NOT NULL
`postal_code` VARCHAR(10) NOT NULL
PRIMARY KEY (`id`), 
CONSTRAINT `fk_billing_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,


)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sql9379333`.`shipping_address`(

`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT NOT NULL,
`name` VARCHAR(50) NOT NULL,
`city` VARCHAR(50) NOT NULL,
`state` VARCHAR(50) NOT NULL,
`postal_code` VARCHAR(10) NOT NULL,
PRIMARY KEY (`id`), 
CONSTRAINT `fk_shipping_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- idea Make an Address table
-- user_id is FK, address_id all is varchar
-- addr_id | user_id | street | number | zip | city | address_type (billing or shipping) 


--Tables considered for access
--roles table
-- role_id int | role_name (admin, user)

--privileges (user-role) table 
-- priviledge_id | role_id int | user_id   -- many users can be either user or admin


CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
INSERT INTO `role` VALUES (1,'ROLE_USER');
--INSERT INTO `role` VALUES (2,'ROLE_ADMIN');
UNLOCK TABLES;



CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



 CREATE TABLE `sql9373933`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_thumbnail` BLOB NULL,
  --Description
  --Manufacturer
  `name` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `condition` VARCHAR(45) NOT NULL,
  `price` DECIMAL(15,2) NOT NULL
  PRIMARY KEY (`product_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;


--TODO orders or invoices
-- CREATE TABLE `sql9373933`.`invoices` (
--   );

--TODO 
--ADDRESS


--TODO Cart

 CREATE TABLE `sql9373933`.`cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `cart_item_id` INT NOT NULL,
  `totalprice` DECIMAL(15,2) NOT NULL,
  CONSTRAINT `fk_users_userid` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_cartitem` FOREIGN KEY (`cart_item_id`) REFERENCES `cart` (`cart_item_id`) ON DELETE CASCADE ON UPDATE CASCADE
  PRIMARY KEY (`cart_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;


 CREATE TABLE `sql9373933`.`cartitem` (
   `cart_item_id` INT NOT NULL AUTO_INCREMENT,
   `cart_id` INT NOT NULL,
   `product_id` INT NOT NULL, 
   `quantity` INT NOT NULL,
   `price` DECIMAL(15,2) NOT NULL,
  CONSTRAINT `fk_cartid` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_productid` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
    PRIMARY KEY (`cart_item_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;



--
-- ALTER TABLE `sql9373933`.`cart` 
-- ADD INDEX `fk_user_id_idx` (`user_id` ASC),
-- ADD INDEX `fk_cartitem_id_idx` (`cart_item_id` ASC);
-- ;
-- ALTER TABLE `sql9373933`.`cart` 
-- ADD CONSTRAINT `fk_user_id`
--   FOREIGN KEY (`user_id`)
--   REFERENCES `sql9373933`.`users` (`id`)
--   ON DELETE CASCADE
--   ON UPDATE CASCADE,
-- ADD CONSTRAINT `fk_cartitem_id`
--   FOREIGN KEY (`cart_item_id`)
--   REFERENCES `sql9373933`.`cartitem` (`cart_item_id`)
--   ON DELETE CASCADE
--   ON UPDATE CASCADE;

-- ALTER TABLE `sql9373933`.`cartitem` 
-- ADD INDEX `fk_productid_idx` (`product_id` ASC),
-- ADD INDEX `fk_cartid_idx` (`cart_id` ASC);
-- ;
-- ALTER TABLE `sql9373933`.`cartitem` 
-- ADD CONSTRAINT `fk_productid`
--   FOREIGN KEY (`product_id`)
--   REFERENCES `sql9373933`.`products` (`product_id`)
--   ON DELETE NO ACTION
--   ON UPDATE NO ACTION,
-- ADD CONSTRAINT `fk_cartid`
--   FOREIGN KEY (`cart_id`)
--   REFERENCES `sql9373933`.`cart` (`cart_id`)
--   ON DELETE CASCADE
--   ON UPDATE CASCADE;



--TODO CartItem

--TODO Customers table (FK users)


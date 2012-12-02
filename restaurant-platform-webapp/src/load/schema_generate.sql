USE restaurant_platform;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS TBL_MENU_ITEM_IMAGE;

DROP TABLE IF EXISTS TBL_MENU_ITEM_OPTION_ITEM;
	
DROP TABLE IF EXISTS TBL_MENU_ITEM_OPTION;

DROP TABLE IF EXISTS TBL_MENU_ITEM_SIZE;

DROP TABLE IF EXISTS TBL_MENU_ITEM_TAGS;

DROP TABLE IF EXISTS TBL_MENU_GROUP_ITEM;

DROP TABLE IF EXISTS TBL_MENU_GROUP_OPTION_ITEM;
	
DROP TABLE IF EXISTS TBL_MENU_GROUP_OPTION;

DROP TABLE IF EXISTS TBL_MENU_ITEM;

DROP TABLE IF EXISTS TBL_MENU_GROUP;

DROP TABLE IF EXISTS TBL_MENU;

DROP TABLE IF EXISTS TBL_CUSTOMER_ADDRESS;

DROP TABLE IF EXISTS TBL_CUSTOMER_PHONE;

DROP TABLE IF EXISTS TBL_ORDER_MENU_SELECTION;

DROP TABLE IF EXISTS TBL_ORDER;

DROP TABLE IF EXISTS TBL_ADDRESS;

DROP TABLE IF EXISTS TBL_PHONE;

DROP TABLE IF EXISTS TBL_CUSTOMER;

DROP TABLE IF EXISTS TBL_USER;

--
-- TABLE: Menus
--
CREATE TABLE TBL_MENU (
	-- Columns
	MENU_ID SERIAL,
	MENU_NAME VARCHAR(50) NOT NULL,
	MENU_KEY VARCHAR(50) NOT NULL,
	MENU_DESC VARCHAR(255),
	MENU_NOTE VARCHAR(255),
	MENU_LANGUAGE VARCHAR(2) NOT NULL DEFAULT 'EN',
	MENU_CURRENCY_SYMBOL VARCHAR(3) NOT NULL DEFAULT 'USD',
	MENU_DURATION_NAME VARCHAR(255) NOT NULL,
	MENU_DURATION_END_TIME INTEGER UNSIGNED,
	MENU_DURATION_START_TIME INTEGER UNSIGNED,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Groups
--
CREATE TABLE TBL_MENU_GROUP (
	-- Columns
	MENU_GROUP_ID SERIAL,
	MENU_GROUP_NAME VARCHAR(50),
	MENU_GROUP_DESC VARCHAR(255),
	MENU_GROUP_NOTE VARCHAR(255),
	IS_DISABLED BOOLEAN DEFAULT '0',
	ORDER_BY INTEGER NOT NULL DEFAULT '0',
	-- Foreign Key Columns
	MENU_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_GROUP_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Group Options
--
CREATE TABLE TBL_MENU_GROUP_OPTION (
	-- Columns
	MENU_GROUP_OPTION_ID SERIAL,
	MENU_GROUP_OPTION_NAME VARCHAR(50),
	MENU_GROUP_OPTION_INFO VARCHAR(255),
	MENU_GROUP_OPTION_MAX_SELECTED INTEGER UNSIGNED,
	MENU_GROUP_OPTION_MIN_SELECTED INTEGER UNSIGNED,
	-- Foreign Key Columns
	MENU_GROUP_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_GROUP_OPTION_ID)
) ENGINE=InnoDB;

-- 
-- TABLE: Menu Group Option Item
--
CREATE TABLE TBL_MENU_GROUP_OPTION_ITEM (
	-- Columns
	MENU_GROUP_OPTION_ITEM_ID SERIAL,
	MENU_GROUP_OPTION_ITEM_NAME VARCHAR(50),
	MENU_GROUP_OPTION_ITEM_ADDL_COST DECIMAL(19,4),
	-- Foreign Key Columns
	MENU_GROUP_OPTION_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_GROUP_OPTION_ITEM_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Group Item
--
CREATE TABLE TBL_MENU_GROUP_ITEM (
	-- Columns
	MENU_GROUP_ITEM_ID SERIAL,
	MENU_GROUP_ID BIGINT UNSIGNED NOT NULL, 
	MENU_ITEM_ID BIGINT UNSIGNED NOT NULL, 
	MENU_GROUP_ITEM_PRICE DECIMAL(19,4),
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_GROUP_ITEM_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Items
--
CREATE TABLE TBL_MENU_ITEM (
	-- Columns
	MENU_ITEM_ID SERIAL,
	MENU_ITEM_NAME VARCHAR(75),
	MENU_ITEM_DESC VARCHAR(450),
	MENU_ITEM_ALLERGENS VARCHAR(255),
	MENU_ITEM_ALLERGY_INFORMATION VARCHAR(450),
	MENU_ITEM_CALORIES INTEGER,
	MENU_ITEM_HEAT_INDEX INTEGER,
	IS_DISABLED  BOOLEAN DEFAULT '0',
	IS_SPECIAL  BOOLEAN DEFAULT '0',
	IS_GLUTEN_FREE  BOOLEAN DEFAULT '0',
	IS_HALAL  BOOLEAN DEFAULT '0',
	IS_KOSHER  BOOLEAN DEFAULT '0',
	IS_VEGAN  BOOLEAN DEFAULT '0',
	IS_VEGETARIAN  BOOLEAN DEFAULT '0',
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ITEM_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Item Images
--
CREATE TABLE TBL_MENU_ITEM_IMAGE (
	-- Columns
	MENU_ITEM_IMAGE_ID SERIAL,
	MENU_ITEM_IMAGE_MEDIA VARCHAR(50) NOT NULL,
	MENU_ITEM_IMAGE_TYPE VARCHAR(50) NOT NULL,
	MENU_ITEM_IMAGE_WIDTH INTEGER,
	MENU_ITEM_IMAGE_HEIGHT INTEGER,
	-- Foreign Key Columns
	MENU_GROUP_ITEM_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ITEM_IMAGE_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Item Options
--
CREATE TABLE TBL_MENU_ITEM_OPTION (
	-- Columns
	MENU_ITEM_OPTION_ID SERIAL,
	MENU_ITEM_OPTION_NAME VARCHAR(50) NOT NULL,
	MENU_ITEM_OPTION_INFO VARCHAR(255),
	MENU_ITEM_OPTION_MIN_SELECTED INTEGER,
	MENU_ITEM_OPTION_MAX_SELECTED INTEGER,
	-- Foreign Key Columns
	MENU_GROUP_ITEM_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	PRIMARY KEY (MENU_ITEM_OPTION_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Item Option Items
--
CREATE TABLE TBL_MENU_ITEM_OPTION_ITEM (
	-- Columns
	MENU_ITEM_OPTION_ITEM_ID SERIAL,
	MENU_ITEM_OPTION_ITEM_NAME VARCHAR(255),
	MENU_ITEM_OPTION_ITEM_ADDL_COST DECIMAL(19,4),
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	MENU_ITEM_OPTION_ID BIGINT UNSIGNED NOT NULL,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ITEM_OPTION_ITEM_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Item Option Sizes
--
CREATE TABLE TBL_MENU_ITEM_SIZE (
	-- Columns
	MENU_ITEM_SIZE_ID SERIAL,
	MENU_ITEM_SIZE_NAME VARCHAR(25) NOT NULL,
	MENU_ITEM_SIZE_DESC VARCHAR(120),
	MENU_ITEM_SIZE_CALORIES INTEGER,
	MENU_ITEM_SIZE_PRICE DECIMAL(19,4),
	-- Foreign Key Columns
	MENU_GROUP_ITEM_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ITEM_SIZE_ID)
) ENGINE=InnoDB;

--
-- TABLE: Menu Item Tags
--
CREATE TABLE TBL_MENU_ITEM_TAGS (
	MENU_ITEM_TAG_ID SERIAL,
	MENU_ITEM_ID BIGINT UNSIGNED NOT NULL,
	MENU_ITEM_TAG VARCHAR(64),
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	-- Keys & Indexes
	PRIMARY KEY (MENU_ITEM_TAG_ID)
) ENGINE=InnoDB;

--
-- TABLE: Users
--
CREATE TABLE TBL_USER (
	-- Columns
	USER_ID SERIAL,
	USER_NAME VARCHAR(36) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	FIRST_NAME VARCHAR(128) NOT NULL,
	LAST_NAME VARCHAR(128) NOT NULL,
	EMAIL VARCHAR(256) NOT NULL,
	ACTIVE BOOLEAN NOT NULL DEFAULT TRUE,
	LAST_LOGIN_DATE DATETIME,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (USER_ID)
) ENGINE=InnoDB;

--
-- TABLE: Customers
--
CREATE TABLE TBL_CUSTOMER (
	-- Columns
	CUSTOMER_ID SERIAL,
	USER_ID BIGINT UNSIGNED NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (USER_ID)
) ENGINE=InnoDB;

--
-- TABLE: Customer Addresses
--
CREATE TABLE TBL_CUSTOMER_ADDRESS (
	CUSTOMER_ADDRESS_ID SERIAL,
	CUSTOMER_ID BIGINT UNSIGNED NOT NULL,
	ADDRESS_ID BIGINT UNSIGNED NOT NULL,
	DEFAULT_ADDRESS BOOLEAN DEFAULT '0',
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (CUSTOMER_ADDRESS_ID)
) ENGINE=InnoDB;

--
-- TABLE: Addresses
--
CREATE TABLE TBL_ADDRESS (
	-- Columns
	ADDRESS_ID SERIAL,
	ADDRESS_1 VARCHAR(128) NOT NULL,
	ADDRESS_2 VARCHAR(128) DEFAULT NULL,
	CITY VARCHAR(128) NOT NULL,
	STATE CHAR(2) NOT NULL,
	ZIP_CODE VARCHAR(10) NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (ADDRESS_ID)
) ENGINE=InnoDB;

--
-- TABLE: Customer Phone Numbers
--
CREATE TABLE TBL_CUSTOMER_PHONE (
	CUSTOMER_PHONE_ID SERIAL,
	CUSTOMER_ID BIGINT UNSIGNED NOT NULL,
	PHONE_ID BIGINT UNSIGNED NOT NULL,
	DEFAULT_PHONE BOOLEAN DEFAULT '0',
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (CUSTOMER_PHONE_ID)
) ENGINE=InnoDB;

--
-- TABLE: Phone Numbers
--
CREATE TABLE TBL_PHONE (
	-- Columns
	PHONE_ID SERIAL,
	PHONE_NUMBER VARCHAR(10) NOT NULL,
	PHONE_EXT VARCHAR(5) DEFAULT NULL,
	PHONE_DESC VARCHAR(128) DEFAULT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (PHONE_ID)
) ENGINE=InnoDB;

--
-- TABLE: Orders
--
CREATE TABLE TBL_ORDER (
	-- Columns
	ORDER_ID SERIAL,
	CUSTOMER_ID BIGINT UNSIGNED,
	ORDER_ADDRESS_ID BIGINT UNSIGNED,
	DELIVERY_ADDRESS_ID BIGINT UNSIGNED,
	ORDER_STATUS VARCHAR(32) NOT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (ORDER_ID)
) ENGINE=InnoDB;

--
-- TABLE: Order Menu Selections
--
CREATE TABLE TBL_ORDER_MENU_SELECTION (
	-- Columns
	ORDER_MENU_SELECTION_ID SERIAL,
	ORDER_ID BIGINT UNSIGNED,
	MENU_ITEM_ID BIGINT UNSIGNED,
	MENU_ITEM_SIZE_ID BIGINT UNSIGNED,
	ORDER_MENU_SELECTION_COMMENTS VARCHAR(500) DEFAULT NULL,
	-- Audit Columns & Version
	CREATE_USER_ID BIGINT UNSIGNED NOT NULL,
	CREATE_DATE DATETIME NOT NULL,
	MODIFY_USER_ID BIGINT UNSIGNED,
	MODIFY_DATE DATETIME,
	OPTLOCK INTEGER,
	-- Keys & Indexes
	PRIMARY KEY (ORDER_MENU_SELECTION_ID)
) ENGINE=InnoDB;

ALTER TABLE TBL_MENU 
    ADD INDEX IDX_MENU_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_GROUP
    ADD INDEX IDX_MENU_GROUP (MENU_ID), 
    ADD CONSTRAINT FK_MENU_GROUP 
    FOREIGN KEY (MENU_ID) 
    	REFERENCES TBL_MENU (MENU_ID),
	ADD INDEX IDX_MENU_GRP_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_GRP_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_ITEM
    ADD INDEX IDX_MENU_ITM_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_GROUP_ITEM
	ADD INDEX IDX_MENU_GROUP_ITEM_GRP (MENU_GROUP_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_ITEM_GRP
    FOREIGN KEY (MENU_GROUP_ID) 
		REFERENCES TBL_MENU_GROUP (MENU_GROUP_ID),
    ADD INDEX IDX_MENU_GROUP_ITEM_ITM (MENU_ITEM_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_ITEM_ITM 
    FOREIGN KEY (MENU_ITEM_ID) 
		REFERENCES TBL_MENU_ITEM (MENU_ITEM_ID),
	ADD INDEX IDX_MENU_GRP_ITM_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_ITM_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_GRP_ITM_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_ITM_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_GROUP_OPTION
	ADD INDEX IDX_MENU_GROUP_OPT (MENU_GROUP_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_OPT 
    FOREIGN KEY (MENU_GROUP_ID) 
		REFERENCES TBL_MENU_GROUP (MENU_GROUP_ID),
	ADD INDEX IDX_MENU_GRP_OPT_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_OPT_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_GRP_OPT_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_OPT_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_GROUP_OPTION_ITEM
    ADD INDEX IDX_MENU_GROUP_OPT_ITEM (MENU_GROUP_OPTION_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_OPT_ITEM 
    FOREIGN KEY (MENU_GROUP_OPTION_ID) 
    	REFERENCES TBL_MENU_GROUP_OPTION (MENU_GROUP_OPTION_ID),
	ADD INDEX IDX_MENU_GRP_OPT_ITM_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_OPT_ITM_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_GRP_OPT_ITM_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_GRP_OPT_ITM_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	
ALTER TABLE TBL_MENU_ITEM_OPTION
    ADD INDEX IDX_MENU_GROUP_ITEM_ITM_OPT (MENU_GROUP_ITEM_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_ITEM_ITM_OPT 
    FOREIGN KEY (MENU_GROUP_ITEM_ID) 
    	REFERENCES TBL_MENU_GROUP_ITEM (MENU_GROUP_ITEM_ID),
    ADD INDEX IDX_MENU_ITM_OPT_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_OPT_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_OPT_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_OPT_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_ITEM_OPTION_ITEM
	ADD INDEX IDX_MENU_ITEM_OPT_ITM (MENU_ITEM_OPTION_ID), 
    ADD CONSTRAINT FK_MENU_ITEM_OPT_ITM 
    FOREIGN KEY (MENU_ITEM_OPTION_ID) 
    	REFERENCES TBL_MENU_ITEM_OPTION (MENU_ITEM_OPTION_ID),
    ADD INDEX IDX_MENU_ITM_OPT_ITM_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_OPT_ITM_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_OPT_ITM_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_OPT_ITM_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_ITEM_IMAGE
    ADD INDEX IDX_MENU_GROUP_ITEM_ITM_IMG (MENU_GROUP_ITEM_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_ITEM_ITM_IMG 
    FOREIGN KEY (MENU_GROUP_ITEM_ID) 
    	REFERENCES TBL_MENU_GROUP_ITEM (MENU_GROUP_ITEM_ID),
    ADD INDEX IDX_MENU_ITM_IMG_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_IMG_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_IMG_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_IMG_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	
ALTER TABLE TBL_MENU_ITEM_SIZE
    ADD INDEX IDX_MENU_GROUP_ITEM_ITM_SZ (MENU_GROUP_ITEM_ID), 
    ADD CONSTRAINT FK_MENU_GROUP_ITEM_ITM_SZ 
    FOREIGN KEY (MENU_GROUP_ITEM_ID) 
    	REFERENCES TBL_MENU_GROUP_ITEM (MENU_GROUP_ITEM_ID),
    ADD INDEX IDX_MENU_ITM_SZE_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_SZE_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_SZE_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_SZE_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_MENU_ITEM_TAGS
    ADD INDEX IDX_MENU_ITEM_TAGS (MENU_ITEM_ID), 
    ADD CONSTRAINT FK_MENU_ITEM_TAGS 
    FOREIGN KEY (MENU_ITEM_ID) 
    	REFERENCES TBL_MENU_ITEM (MENU_ITEM_ID),
    ADD INDEX IDX_MENU_ITM_TGS_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_TGS_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_MENU_ITM_TGS_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_MENU_ITM_TGS_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	
ALTER TABLE TBL_USER
	ADD CONSTRAINT UC_USERNAME UNIQUE (USER_NAME),
    ADD INDEX IDX_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    
ALTER TABLE TBL_CUSTOMER
    ADD INDEX IDX_CUSTOMER_USER_ID (USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_USER_ID 
    FOREIGN KEY (USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_CUSTOMER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_CUSTOMER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	
ALTER TABLE TBL_CUSTOMER_ADDRESS
    ADD INDEX IDX_CUSTOMER_ADDRESS_CUST (CUSTOMER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_ADDRESS_CUST 
    FOREIGN KEY (CUSTOMER_ID) 
    	REFERENCES TBL_CUSTOMER (CUSTOMER_ID),
    ADD INDEX IDX_CUSTOMER_ADDRESS_ADDR (ADDRESS_ID), 
    ADD CONSTRAINT FK_CUSTOMER_ADDRESS_ADDR 
    FOREIGN KEY (ADDRESS_ID) 
    	REFERENCES TBL_ADDRESS (ADDRESS_ID),
    ADD INDEX IDX_CUSTOMER_ADDRESS_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_ADDRESS_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_CUSTOMER_ADDRESS_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_ADDRESS_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_ADDRESS
    ADD INDEX IDX_ADDRESS_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_ADDRESS_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_ADDRESS_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_ADDRESS_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_CUSTOMER_PHONE
    ADD INDEX IDX_CUSTOMER_PHONE_CUST (CUSTOMER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_PHONE_CUST 
    FOREIGN KEY (CUSTOMER_ID) 
    	REFERENCES TBL_CUSTOMER (CUSTOMER_ID),
    ADD INDEX IDX_CUSTOMER_PHONE_ADDR (PHONE_ID), 
    ADD CONSTRAINT FK_CUSTOMER_PHONE_ADDR 
    FOREIGN KEY (PHONE_ID) 
    	REFERENCES TBL_PHONE (PHONE_ID),
    ADD INDEX IDX_CUSTOMER_PHONE_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_PHONE_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_CUSTOMER_PHONE_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_CUSTOMER_PHONE_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

ALTER TABLE TBL_PHONE
    ADD INDEX IDX_PHONE_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_PHONE_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_PHONE_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_PHONE_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	
ALTER TABLE TBL_ORDER
	ADD INDEX IDX_ORDER_STATUS (ORDER_STATUS),
    ADD INDEX IDX_ORDER_CUSTOMER (CUSTOMER_ID), 
    ADD CONSTRAINT FK_ORDER_CUSTOMER 
    FOREIGN KEY (CUSTOMER_ID) 
    	REFERENCES TBL_CUSTOMER (CUSTOMER_ID),
    ADD INDEX IDX_ORDER_ADDRESS_ORD (ORDER_ADDRESS_ID), 
    ADD CONSTRAINT FK_ORDER_ADDRESS_ORD 
    FOREIGN KEY (ORDER_ADDRESS_ID) 
    	REFERENCES TBL_ADDRESS (ADDRESS_ID),
    ADD INDEX IDX_ORDER_ADDRESS_DLVRY (DELIVERY_ADDRESS_ID), 
    ADD CONSTRAINT FK_ORDER_ADDRESS_DLVRY 
    FOREIGN KEY (DELIVERY_ADDRESS_ID) 
    	REFERENCES TBL_ADDRESS (ADDRESS_ID),
    ADD INDEX IDX_ORDER_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_ORDER_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_ORDER_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_ORDER_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);
    	    	
ALTER TABLE TBL_ORDER_MENU_SELECTION
    ADD INDEX IDX_ORDER_MENU_SLCT_ORD (ORDER_ID), 
    ADD CONSTRAINT FK_ORDER_MENU_SLCT_ORD
    FOREIGN KEY (ORDER_ID) 
    	REFERENCES TBL_ORDER (ORDER_ID),
	ADD INDEX IDX_ORDER_MENU_SLCT_ITM (MENU_ITEM_ID), 
    ADD CONSTRAINT FK_ORDER_MENU_SLCT_ITM 
    FOREIGN KEY (MENU_ITEM_ID) 
    	REFERENCES TBL_MENU_ITEM (MENU_ITEM_ID),
	ADD INDEX IDX_ORDER_MENU_SLCT_ITM_SZ (MENU_ITEM_SIZE_ID), 
    ADD CONSTRAINT FK_ORDER_MENU_SLCT_ITM_SZ 
    FOREIGN KEY (MENU_ITEM_SIZE_ID) 
    	REFERENCES TBL_MENU_ITEM_SIZE (MENU_ITEM_SIZE_ID),
    ADD INDEX IDX_ORDER_SLCT_USER_CREATE (CREATE_USER_ID), 
    ADD CONSTRAINT FK_ORDER_SLCT_USER_CREATE 
    FOREIGN KEY (CREATE_USER_ID) 
    	REFERENCES TBL_USER (USER_ID),
    ADD INDEX IDX_ORDER_SLCT_USER_MODIFY (MODIFY_USER_ID), 
    ADD CONSTRAINT FK_ORDER_SLCT_USER_MODIFY 
    FOREIGN KEY (MODIFY_USER_ID) 
    	REFERENCES TBL_USER (USER_ID);

SET FOREIGN_KEY_CHECKS = 1;
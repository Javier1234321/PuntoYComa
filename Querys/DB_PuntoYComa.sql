-------------------------------------------------------------------------------------
-- Author: Arzate Angulo Javier Alejandro
-- Created: 2026-06-28
-- Description: Query en el que se guarda la estructura y la creacion a la base de datos necesarias para el proyecto
-------------------------------------------------------------------------------------

USE master;
GO
IF DB_ID('DB_PuntoYComa') IS NOT NULL
BEGIN
    ALTER DATABASE DB_PuntoYComa
    SET SINGLE_USER
    WITH ROLLBACK IMMEDIATE;
	DROP DATABASE DB_PuntoYComa
END

GO
CREATE DATABASE DB_PuntoYComa;
GO
USE DB_PuntoYComa
GO

CREATE TABLE cat_rol(
	i_id_rol INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_name VARCHAR(25) ,
	dt_created_at DATETIME ,
	dt_updated_at DATETIME ,
	b_status BIT 
)
GO

CREATE TABLE tbl_user(
	i_id_user INT IDENTITY(1,1)  PRIMARY KEY,
	i_id_rol INT,
	v_email VARCHAR(MAX) ,
	v_password VARCHAR(MAX) ,
	v_name VARCHAR(MAX) ,
	v_last_name VARCHAR(MAX) ,
	i_coins	INT,
	dt_created_at DATETIME ,
	dt_updated_at DATETIME ,
	b_status BIT ,
	b_notify BIT,
	FOREIGN KEY (i_id_rol) REFERENCES cat_rol(i_id_rol)
)

CREATE TABLE tbl_purchase(
	i_id_purchase INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	i_id_user INT,
	dt_purchase_date DATETIME,
	m_total MONEY,
	b_status BIT,
	FOREIGN KEY (i_id_user) REFERENCES tbl_user(i_id_user)
)

CREATE TABLE tbl_wishlist(
	i_id_wishlist INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	i_id_user INT,
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	FOREIGN KEY (i_id_user) REFERENCES tbl_user(i_id_user)
)

CREATE TABLE cat_nationality(
	i_id_nationality INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_nationality VARCHAR(MAX)
)

CREATE TABLE cat_publisher(
	i_id_publisher INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_publisher VARCHAR(MAX),
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT
)


CREATE TABLE cat_category(
	i_id_category INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
	v_category VARCHAR(MAX),
	t_description TEXT,
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT
)

CREATE TABLE cat_sub_category(
	i_id_sub_category INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	i_id_category INT,
	v_sub_category VARCHAR(MAX),
	t_description TEXT,
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT
	FOREIGN KEY (i_id_category) REFERENCES cat_category(i_id_category)
)

CREATE TABLE cat_language(
	i_id_language INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_language VARCHAR(MAX),
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT
)

CREATE TABLE tbl_image(
	i_id_image INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_direction VARCHAR(MAX),
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT
)

CREATE TABLE tbl_author(
	i_id_author INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_first_name VARCHAR(MAX),
	v_last_name VARCHAR(MAX),
	t_biography TEXT,
	d_birth DATE,
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	i_id_nationality INT,
	FOREIGN KEY (i_id_nationality) REFERENCES cat_nationality(i_id_nationality)
)
CREATE TABLE tbl_book(
	i_id_book INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	v_title	VARCHAR(MAX),
	v_description VARCHAR(MAX),
	i_id_author INT,
	i_id_publisher INT,
	i_id_sub_category INT,
	i_stock INT,
	i_id_pages INT,
	i_id_image	INT,
	i_id_language INT,
	d_publication DATE,
	m_price MONEY,
	dt_created_at DATETIME,
	dt_updated_at DATETIME,
	b_status BIT,
	FOREIGN KEY (i_id_author) REFERENCES tbl_author(i_id_author),
	FOREIGN KEY (i_id_publisher) REFERENCES cat_publisher(i_id_publisher),
	FOREIGN KEY (i_id_sub_category) REFERENCES cat_sub_category(i_id_sub_category),
	FOREIGN KEY (i_id_image) REFERENCES tbl_image(i_id_image),
	FOREIGN KEY (i_id_language) REFERENCES cat_language(i_id_language)
)

CREATE TABLE tbl_purchase_detail(
	i_id_purchase_detail INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	i_id_purchase INT,
	i_id_book INT,
	i_quantity INT,
	m_sub_total MONEY,
	FOREIGN KEY (i_id_purchase) REFERENCES tbl_purchase(i_id_purchase),
	FOREIGN KEY (i_id_book) REFERENCES tbl_book(i_id_book)
)

CREATE TABLE tbl_wishlist_detail(
	i_id_wishlist_detail INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
	i_id_wishlist INT,
	i_id_book INT,
	FOREIGN KEY (i_id_wishlist) REFERENCES tbl_wishlist(i_id_wishlist),
	FOREIGN KEY (i_id_book) REFERENCES tbl_book(i_id_book)
)
use didongxanh;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL primary key ,
  `name` varchar(255) NOT NULL,
  `active_flag` int(1) NOT NULL DEFAULT 1,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `roleName` varchar(50) NOT NULL,
  `description` varchar(100) NOT NULL,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `roleuser` (
  `id` int(11) NOT NULL,
  `user_Id` int(11) NOT NULL,
  `role_Id` int(11) NOT NULL,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `storeId` int(11) DEFAULT NULL,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `parent_Id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `order_Index` int(1) NOT NULL DEFAULT 0,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `icon` varchar(255) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `auth` (
  `id` int(11) NOT NULL,
  `role_Id` int(11) NOT NULL,
  `menu_Id` int(11) NOT NULL,
  `Permission` int(1) NOT NULL DEFAULT 1,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `color` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `activeFlag` int(1) NOT NULL DEFAULT 1,
  `createDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `updateDate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

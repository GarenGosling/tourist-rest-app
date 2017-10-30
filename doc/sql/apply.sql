/*
Navicat MySQL Data Transfer

Source Server         : mc
Source Server Version : 50505
Source Host           : 120.27.22.41:3306
Source Database       : mc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-30 22:19:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_code` varchar(64) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '用户码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `item_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '项目名',
  `name` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `sex` varchar(1) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '性别(男/女)',
  `phone` varchar(11) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号',
  PRIMARY KEY (`id`),
  KEY `item_name` (`item_name`),
  KEY `phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

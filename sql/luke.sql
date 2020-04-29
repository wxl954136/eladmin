/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1-123456
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : eladmin

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-04-27 15:39:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for alipay_config
-- ----------------------------
DROP TABLE IF EXISTS `alipay_config`;
CREATE TABLE `alipay_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `app_id` varchar(255) DEFAULT NULL COMMENT '应用ID',
  `charset` varchar(255) DEFAULT NULL COMMENT '编码',
  `format` varchar(255) DEFAULT NULL COMMENT '类型 固定格式json',
  `gateway_url` varchar(255) DEFAULT NULL COMMENT '网关地址',
  `notify_url` varchar(255) DEFAULT NULL COMMENT '异步回调',
  `private_key` text COMMENT '私钥',
  `public_key` text COMMENT '公钥',
  `return_url` varchar(255) DEFAULT NULL COMMENT '回调地址',
  `sign_type` varchar(255) DEFAULT NULL COMMENT '签名方式',
  `sys_service_provider_id` varchar(255) DEFAULT NULL COMMENT '商户号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='支付宝配置类';

-- ----------------------------
-- Records of alipay_config
-- ----------------------------
INSERT INTO `alipay_config` VALUES ('1', '2016091700532697', 'utf-8', 'JSON', 'https://openapi.alipaydev.com/gateway.do', 'http://api.auauz.net/api/aliPay/notify', 'MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC5js8sInU10AJ0cAQ8UMMyXrQ+oHZEkVt5lBwsStmTJ7YikVYgbskx1YYEXTojRsWCb+SH/kDmDU4pK/u91SJ4KFCRMF2411piYuXU/jF96zKrADznYh/zAraqT6hvAIVtQAlMHN53nx16rLzZ/8jDEkaSwT7+HvHiS+7sxSojnu/3oV7BtgISoUNstmSe8WpWHOaWv19xyS+Mce9MY4BfseFhzTICUymUQdd/8hXA28/H6osUfAgsnxAKv7Wil3aJSgaJczWuflYOve0dJ3InZkhw5Cvr0atwpk8YKBQjy5CdkoHqvkOcIB+cYHXJKzOE5tqU7inSwVbHzOLQ3XbnAgMBAAECggEAVJp5eT0Ixg1eYSqFs9568WdetUNCSUchNxDBu6wxAbhUgfRUGZuJnnAll63OCTGGck+EGkFh48JjRcBpGoeoHLL88QXlZZbC/iLrea6gcDIhuvfzzOffe1RcZtDFEj9hlotg8dQj1tS0gy9pN9g4+EBH7zeu+fyv+qb2e/v1l6FkISXUjpkD7RLQr3ykjiiEw9BpeKb7j5s7Kdx1NNIzhkcQKNqlk8JrTGDNInbDM6inZfwwIO2R1DHinwdfKWkvOTODTYa2MoAvVMFT9Bec9FbLpoWp7ogv1JMV9svgrcF9XLzANZ/OQvkbe9TV9GWYvIbxN6qwQioKCWO4GPnCAQKBgQDgW5MgfhX8yjXqoaUy/d1VjI8dHeIyw8d+OBAYwaxRSlCfyQ+tieWcR2HdTzPca0T0GkWcKZm0ei5xRURgxt4DUDLXNh26HG0qObbtLJdu/AuBUuCqgOiLqJ2f1uIbrz6OZUHns+bT/jGW2Ws8+C13zTCZkZt9CaQsrp3QOGDx5wKBgQDTul39hp3ZPwGNFeZdkGoUoViOSd5Lhowd5wYMGAEXWRLlU8z+smT5v0POz9JnIbCRchIY2FAPKRdVTICzmPk2EPJFxYTcwaNbVqL6lN7J2IlXXMiit5QbiLauo55w7plwV6LQmKm9KV7JsZs5XwqF7CEovI7GevFzyD3w+uizAQKBgC3LY1eRhOlpWOIAhpjG6qOoohmeXOphvdmMlfSHq6WYFqbWwmV4rS5d/6LNpNdL6fItXqIGd8I34jzql49taCmi+A2nlR/E559j0mvM20gjGDIYeZUz5MOE8k+K6/IcrhcgofgqZ2ZED1ksHdB/E8DNWCswZl16V1FrfvjeWSNnAoGAMrBplCrIW5xz+J0Hm9rZKrs+AkK5D4fUv8vxbK/KgxZ2KaUYbNm0xv39c+PZUYuFRCz1HDGdaSPDTE6WeWjkMQd5mS6ikl9hhpqFRkyh0d0fdGToO9yLftQKOGE/q3XUEktI1XvXF0xyPwNgUCnq0QkpHyGVZPtGFxwXiDvpvgECgYA5PoB+nY8iDiRaJNko9w0hL4AeKogwf+4TbCw+KWVEn6jhuJa4LFTdSqp89PktQaoVpwv92el/AhYjWOl/jVCm122f9b7GyoelbjMNolToDwe5pF5RnSpEuDdLy9MfE8LnE3PlbE7E5BipQ3UjSebkgNboLHH/lNZA5qvEtvbfvQ==', 'MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAut9evKRuHJ/2QNfDlLwvN/S8l9hRAgPbb0u61bm4AtzaTGsLeMtScetxTWJnVvAVpMS9luhEJjt+Sbk5TNLArsgzzwARgaTKOLMT1TvWAK5EbHyI+eSrc3s7Awe1VYGwcubRFWDm16eQLv0k7iqiw+4mweHSz/wWyvBJVgwLoQ02btVtAQErCfSJCOmt0Q/oJQjj08YNRV4EKzB19+f5A+HQVAKy72dSybTzAK+3FPtTtNen/+b5wGeat7c32dhYHnGorPkPeXLtsqqUTp1su5fMfd4lElNdZaoCI7osZxWWUo17vBCZnyeXc9fk0qwD9mK6yRAxNbrY72Xx5VqIqwIDAQAB', 'http://api.auauz.net/api/aliPay/return', 'RSA2', '2088102176044281');

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `top_company_code` varchar(10) NOT NULL COMMENT '企业代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='银行信息';

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES ('1', '中国银行', '', '2', '2020-03-29 16:30:49', '10000');
INSERT INTO `bank` VALUES ('3', '赤壁农商', '', '3', '2020-03-29 16:30:53', '10000');
INSERT INTO `bank` VALUES ('7', '678', '', '999', '2020-03-29 16:42:31', '20000');
INSERT INTO `bank` VALUES ('8', '777', '', '999', '2020-03-29 16:30:55', '10000');

-- ----------------------------
-- Table structure for biz_po_in
-- ----------------------------
DROP TABLE IF EXISTS `biz_po_in`;
CREATE TABLE `biz_po_in` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keywords` varchar(50) DEFAULT NULL COMMENT 'uuid生成关联序列',
  `biz_no` varchar(50) NOT NULL COMMENT '单据号',
  `biz_type` varchar(5) NOT NULL COMMENT '单据类型',
  `biz_date` varchar(10) DEFAULT NULL COMMENT '业务单据日期',
  `trader_id` bigint(20) NOT NULL COMMENT '往来单位id',
  `store_id` bigint(20) NOT NULL COMMENT '仓库id',
  `pay_method` smallint(6) DEFAULT NULL COMMENT '付款方式',
  `handler` varchar(255) DEFAULT NULL COMMENT '经办人',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`),
  KEY `FK_BizPoIn-LINK-SysStore` (`store_id`),
  KEY `FK_BizPoin-LINK-SysTrader` (`trader_id`),
  CONSTRAINT `FK_BizPoIn-LINK-SysStore` FOREIGN KEY (`store_id`) REFERENCES `sys_store` (`id`),
  CONSTRAINT `FK_BizPoin-LINK-SysTrader` FOREIGN KEY (`trader_id`) REFERENCES `sys_trader` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='采购单头表';

-- ----------------------------
-- Records of biz_po_in
-- ----------------------------
INSERT INTO `biz_po_in` VALUES ('1', '666', 'PI20200420-0001', 'PI', '2020-04-09', '1', '34', '1', '55544', 'test一下44455556666', '\0', '0', '2020-04-26 15:37:31', '2020-04-17 10:20:04', '10000', '做一组数据');
INSERT INTO `biz_po_in` VALUES ('13', '1c00182108a64e61b493eeaa1e6f884e', 'PI20200427-0001', 'PI', '2020-04-27', '2', '35', '1', '55', '', '\0', '0', '2020-04-27 11:19:13', '2020-04-27 11:17:54', '10000', null);
INSERT INTO `biz_po_in` VALUES ('14', '6d0230f2d20746528406f02c71f91eea', 'PI20200427-0002', 'PI', '2020-04-26', '1', '34', '1', '1111', '', '\0', '0', '2020-04-27 11:41:23', '2020-04-27 11:41:03', '10000', null);
INSERT INTO `biz_po_in` VALUES ('15', '10ecd8ea54644fd3a2514593e69201d3', 'PI20200427-0003', 'PI', '2020-04-17', '2', '30', '1', '99', '', '\0', '0', '2020-04-27 11:42:41', '2020-04-27 11:42:41', '10000', null);

-- ----------------------------
-- Table structure for biz_po_in_detail
-- ----------------------------
DROP TABLE IF EXISTS `biz_po_in_detail`;
CREATE TABLE `biz_po_in_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '采购单明细表',
  `keywords` varchar(50) DEFAULT NULL COMMENT 'uuid生成关联序列',
  `head_id` bigint(20) DEFAULT NULL COMMENT '主表关联',
  `biz_type` varchar(5) DEFAULT NULL COMMENT '单据类型',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'sku主键',
  `qty` decimal(38,7) DEFAULT NULL COMMENT '数量',
  `price` decimal(38,7) DEFAULT NULL COMMENT '采购价',
  `rate` decimal(10,5) DEFAULT NULL COMMENT '税率',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`),
  KEY `head_id` (`head_id`),
  KEY `FK5fn8cqr2rrt85p4ofj2gpxq8l` (`sku_id`),
  CONSTRAINT `FK5fn8cqr2rrt85p4ofj2gpxq8l` FOREIGN KEY (`sku_id`) REFERENCES `sys_sku` (`id`),
  CONSTRAINT `FK_BizPoinDetail-LINK-BizPoin` FOREIGN KEY (`head_id`) REFERENCES `biz_po_in` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='采购明细表';

-- ----------------------------
-- Records of biz_po_in_detail
-- ----------------------------
INSERT INTO `biz_po_in_detail` VALUES ('4', '8f88637c656d4bf9aebb5e34a3d09568', '1', 'PI', '3', '3.0000000', '20.0000000', '0.00000', null, '\0', '0', '2020-04-24 09:23:25', '2020-04-18 09:48:16', '10000', null);
INSERT INTO `biz_po_in_detail` VALUES ('22', '1ec8aa087bca44529d20624010baa792', '13', 'PI', '1', '11.0000000', '12.0000000', '44.00000', null, '\0', '0', '2020-04-27 11:17:54', '2020-04-27 11:17:54', '10000', null);
INSERT INTO `biz_po_in_detail` VALUES ('23', '066d2c392b6c49fbae3faf26d0db2d55', '14', 'PI', '3', '14.0000000', '0.0000000', '0.00000', null, '\0', '0', '2020-04-27 11:41:03', '2020-04-27 11:41:03', '10000', null);
INSERT INTO `biz_po_in_detail` VALUES ('24', 'c8f8037c72c5443aade6a165a7dca7ac', '14', 'PI', '2', '12.0000000', '0.0000000', '0.00000', null, '\0', '0', '2020-04-27 11:41:03', '2020-04-27 11:41:03', '10000', null);
INSERT INTO `biz_po_in_detail` VALUES ('25', '896f8986d1584bcb87acac191a4e41d6', '15', 'PI', '1', '10.0000000', '16.0000000', '0.00000', null, '\0', '0', '2020-04-27 11:42:41', '2020-04-27 11:42:41', '10000', null);

-- ----------------------------
-- Table structure for biz_trade_flow
-- ----------------------------
DROP TABLE IF EXISTS `biz_trade_flow`;
CREATE TABLE `biz_trade_flow` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业务进出为商品表';

-- ----------------------------
-- Records of biz_trade_flow
-- ----------------------------

-- ----------------------------
-- Table structure for column_config
-- ----------------------------
DROP TABLE IF EXISTS `column_config`;
CREATE TABLE `column_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(255) DEFAULT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `column_type` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `form_show` bit(1) DEFAULT NULL,
  `form_type` varchar(255) DEFAULT NULL,
  `key_type` varchar(255) DEFAULT NULL,
  `list_show` bit(1) DEFAULT NULL,
  `not_null` bit(1) DEFAULT NULL,
  `query_type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `date_annotation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=257 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='代码生成字段信息存储';

-- ----------------------------
-- Records of column_config
-- ----------------------------
INSERT INTO `column_config` VALUES ('1', 'gen_test', 'id', 'int', null, 'auto_increment', '\0', null, 'PRI', '\0', '', null, 'ID', null);
INSERT INTO `column_config` VALUES ('2', 'gen_test', 'sex', 'int', null, '', '', null, '', '', '\0', 'NotNull', '性别', null);
INSERT INTO `column_config` VALUES ('3', 'gen_test', 'create_time', 'datetime', null, '', '\0', null, '', '', '\0', 'BetWeen', '', null);
INSERT INTO `column_config` VALUES ('139', 'sys_sku', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('140', 'sys_sku', 'name', 'varchar', null, '', '', null, '', '', '\0', null, '名字', null);
INSERT INTO `column_config` VALUES ('141', 'sys_sku', 'pinyin', 'varchar', null, '', '', null, '', '', '\0', null, '拼音码', null);
INSERT INTO `column_config` VALUES ('142', 'sys_sku', 'assist_code', 'varchar', null, '', '', null, '', '', '\0', null, '助记码', null);
INSERT INTO `column_config` VALUES ('143', 'sys_sku', 'enabled', 'bit', null, '', '', null, '', '', '\0', null, '是否启用', null);
INSERT INTO `column_config` VALUES ('144', 'sys_sku', 'create_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('145', 'dept', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('146', 'dept', 'name', 'varchar', null, '', '', null, '', '', '', null, '名称', null);
INSERT INTO `column_config` VALUES ('147', 'dept', 'pid', 'bigint', null, '', '', null, '', '', '', null, '上级部门', null);
INSERT INTO `column_config` VALUES ('148', 'dept', 'enabled', 'bit', null, '', '', null, '', '', '', null, '状态', null);
INSERT INTO `column_config` VALUES ('149', 'dept', 'create_time', 'datetime', null, '', '', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('150', 'bank', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('151', 'bank', 'name', 'varchar', null, '', '', null, '', '', '', null, '', null);
INSERT INTO `column_config` VALUES ('152', 'bank', 'enabled', 'bit', null, '', '', null, '', '', '', null, '状态', null);
INSERT INTO `column_config` VALUES ('153', 'bank', 'sort', 'bigint', null, '', '', null, '', '', '', null, '排序', null);
INSERT INTO `column_config` VALUES ('154', 'bank', 'create_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('155', 'visits', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('156', 'visits', 'create_time', 'datetime', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('157', 'visits', 'date', 'varchar', null, '', '', null, 'UNI', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('158', 'visits', 'ip_counts', 'bigint', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('159', 'visits', 'pv_counts', 'bigint', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('160', 'visits', 'week_day', 'varchar', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('161', 'users_roles', 'user_id', 'bigint', null, '', '', null, 'PRI', '', '', null, '用户ID', null);
INSERT INTO `column_config` VALUES ('162', 'users_roles', 'role_id', 'bigint', null, '', '', null, 'PRI', '', '', null, '角色ID', null);
INSERT INTO `column_config` VALUES ('163', 'test', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', '=', 'ID', null);
INSERT INTO `column_config` VALUES ('164', 'test', 'name', 'varchar', null, '', '', 'Input', '', '', '', 'Like', '', 'CreationTimestamp');
INSERT INTO `column_config` VALUES ('165', 'test', 'enabled', 'bit', null, '', '', null, '', '', '', null, '状态', null);
INSERT INTO `column_config` VALUES ('166', 'test', 'sort', 'bigint', null, '', '', null, '', '', '\0', null, '排序', null);
INSERT INTO `column_config` VALUES ('167', 'test', 'create_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '\0', null, '', '\0', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('168', 'sys_store', 'id', 'bigint', null, 'auto_increment', '\0', null, 'PRI', '\0', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('169', 'sys_store', 'keywords', 'varchar', null, '', '\0', null, '', '\0', '\0', null, 'uuid相关联', null);
INSERT INTO `column_config` VALUES ('170', 'sys_store', 'name', 'varchar', null, '', '', 'Input', '', '', '', 'Like', '仓库名称', null);
INSERT INTO `column_config` VALUES ('171', 'sys_store', 'enabled', 'bit', null, '', '', 'Radio', '', '', '', '=', '状态', null);
INSERT INTO `column_config` VALUES ('172', 'sys_store', 'remark', 'varchar', null, '', '', 'Input', '', '', '\0', null, '备注', null);
INSERT INTO `column_config` VALUES ('173', 'sys_store', 'is_delete', 'bit', null, '', '\0', null, '', '\0', '\0', null, '删除标记0:未删除；1：已删除', null);
INSERT INTO `column_config` VALUES ('174', 'sys_store', 'version', 'int', null, '', '\0', null, '', '\0', '\0', null, '版本号，否则同步提交', null);
INSERT INTO `column_config` VALUES ('175', 'sys_store', 'update_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '\0', null, '', '\0', '\0', null, '修改日期', null);
INSERT INTO `column_config` VALUES ('176', 'sys_store', 'create_time', 'datetime', null, '', '\0', null, '', '\0', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('177', 'sys_store', 'top_company_code', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '企业代码', null);
INSERT INTO `column_config` VALUES ('178', 'sys_store', 'notes', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '系统注释，不参与程序制作', null);
INSERT INTO `column_config` VALUES ('179', 'user', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('180', 'user', 'avatar_id', 'bigint', null, '', '', null, 'MUL', '', '\0', null, '头像', null);
INSERT INTO `column_config` VALUES ('181', 'user', 'email', 'varchar', null, '', '', null, '', '', '\0', null, '邮箱', null);
INSERT INTO `column_config` VALUES ('182', 'user', 'enabled', 'bigint', null, '', '', null, '', '', '\0', null, '状态：1启用、0禁用', null);
INSERT INTO `column_config` VALUES ('183', 'user', 'password', 'varchar', null, '', '', null, '', '', '\0', null, '密码', null);
INSERT INTO `column_config` VALUES ('184', 'user', 'username', 'varchar', null, '', '', null, '', '', '\0', null, '用户名', null);
INSERT INTO `column_config` VALUES ('185', 'user', 'dept_id', 'bigint', null, '', '', null, 'MUL', '', '\0', null, '部门名称', null);
INSERT INTO `column_config` VALUES ('186', 'user', 'phone', 'varchar', null, '', '', null, '', '', '\0', null, '手机号码', null);
INSERT INTO `column_config` VALUES ('187', 'user', 'job_id', 'bigint', null, '', '', null, 'MUL', '', '\0', null, '岗位名称', null);
INSERT INTO `column_config` VALUES ('188', 'user', 'create_time', 'datetime', null, '', '', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('189', 'user', 'last_password_reset_time', 'datetime', null, '', '', null, '', '', '\0', null, '最后修改密码的日期', null);
INSERT INTO `column_config` VALUES ('190', 'user', 'nick_name', 'varchar', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('191', 'user', 'sex', 'varchar', null, '', '', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('192', 'user', 'top_company_code', 'varchar', null, '', '', null, '', '', '\0', null, '企业帐套公司代码', null);
INSERT INTO `column_config` VALUES ('193', 'sys_trader', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, '主键', null);
INSERT INTO `column_config` VALUES ('194', 'sys_trader', 'name', 'varchar', null, '', '', 'Input', '', '', '', 'Like', '名称', null);
INSERT INTO `column_config` VALUES ('195', 'sys_trader', 'saler_flag', 'bit', null, '', '', 'Radio', '', '', '', '=', '供应商', null);
INSERT INTO `column_config` VALUES ('196', 'sys_trader', 'buyer_flag', 'bit', null, '', '', 'Radio', '', '', '', '=', '客户商', null);
INSERT INTO `column_config` VALUES ('197', 'sys_trader', 'period', 'smallint', null, '', '', null, '', '', '', null, '帐期', null);
INSERT INTO `column_config` VALUES ('198', 'sys_trader', 'credit_amout', 'int', null, '', '', null, '', '', '', null, '信用额度', null);
INSERT INTO `column_config` VALUES ('199', 'sys_trader', 'contacter', 'varchar', null, '', '', null, '', '', '\0', null, '联系人', null);
INSERT INTO `column_config` VALUES ('200', 'sys_trader', 'tel', 'varchar', null, '', '', null, '', '', '\0', null, '电话', null);
INSERT INTO `column_config` VALUES ('201', 'sys_trader', 'address', 'varchar', null, '', '', null, '', '', '\0', null, '地址', null);
INSERT INTO `column_config` VALUES ('202', 'sys_trader', 'bank_name', 'varchar', null, '', '', null, '', '', '\0', null, '银行名称', null);
INSERT INTO `column_config` VALUES ('203', 'sys_trader', 'bank_accout', 'varchar', null, '', '', null, '', '', '\0', null, '银行帐户', null);
INSERT INTO `column_config` VALUES ('204', 'sys_trader', 'remark', 'varchar', null, '', '', null, '', '', '\0', null, '备注', null);
INSERT INTO `column_config` VALUES ('205', 'sys_trader', 'is_delete', 'bit', null, '', '', null, '', '', '\0', null, '删除标记', null);
INSERT INTO `column_config` VALUES ('206', 'sys_trader', 'version', 'int', null, '', '', null, '', '', '\0', null, '版本号', null);
INSERT INTO `column_config` VALUES ('207', 'sys_trader', 'update_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '', null, '', '', '\0', null, '修改日期', null);
INSERT INTO `column_config` VALUES ('208', 'sys_trader', 'create_time', 'datetime', null, '', '', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('209', 'sys_trader', 'top_company_code', 'varchar', null, '', '', null, '', '', '\0', null, '企业代码', null);
INSERT INTO `column_config` VALUES ('210', 'sys_trader', 'notes', 'varchar', null, '', '', null, '', '', '\0', null, '系统注释', null);
INSERT INTO `column_config` VALUES ('211', 'sys_trader', 'enabled', 'bit', 'job_status', '', '', 'Radio', '', '', '', '=', '启用状态', null);
INSERT INTO `column_config` VALUES ('212', 'biz_po_in_detail', 'id', 'bigint', null, '', '\0', null, 'PRI', '\0', '\0', null, '采购单明细表id', null);
INSERT INTO `column_config` VALUES ('213', 'biz_po_in_detail', 'head_id', 'bigint', null, '', '\0', null, '', '\0', '\0', null, '主表关联', null);
INSERT INTO `column_config` VALUES ('214', 'biz_po_in_detail', 'sku_id', 'bigint', null, '', '', 'Input', '', '', '\0', 'Like', 'sku主键', null);
INSERT INTO `column_config` VALUES ('215', 'biz_po_in_detail', 'qty', 'decimal', null, '', '', '', '', '', '\0', null, '数量', null);
INSERT INTO `column_config` VALUES ('216', 'biz_po_in_detail', 'price', 'decimal', null, '', '', null, '', '', '\0', null, '采购价', null);
INSERT INTO `column_config` VALUES ('217', 'biz_po_in_detail', 'rate', 'decimal', null, '', '', null, '', '', '\0', null, '税率', null);
INSERT INTO `column_config` VALUES ('218', 'biz_po_in_detail', 'remark', 'varchar', null, '', '', null, '', '', '\0', null, '备注', null);
INSERT INTO `column_config` VALUES ('219', 'biz_po_in_detail', 'is_delete', 'bit', null, '', '\0', null, '', '\0', '\0', null, '删除标记', null);
INSERT INTO `column_config` VALUES ('220', 'biz_po_in_detail', 'version', 'int', null, '', '\0', null, '', '\0', '\0', null, '版本号', null);
INSERT INTO `column_config` VALUES ('221', 'biz_po_in_detail', 'update_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '\0', null, '', '\0', '\0', null, '修改日期', null);
INSERT INTO `column_config` VALUES ('222', 'biz_po_in_detail', 'create_time', 'datetime', null, '', '\0', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('223', 'biz_po_in_detail', 'top_company_code', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '企业代码', null);
INSERT INTO `column_config` VALUES ('224', 'biz_po_in_detail', 'notes', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '系统注释，不参与程序制作', null);
INSERT INTO `column_config` VALUES ('225', 'biz_po_in', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '\0', '\0', null, '主键', null);
INSERT INTO `column_config` VALUES ('226', 'biz_po_in', 'trader_id', 'bigint', null, '', '', null, '', '', '\0', null, '往来单位id', null);
INSERT INTO `column_config` VALUES ('227', 'biz_po_in', 'store_id', 'bigint', null, '', '', null, '', '', '\0', null, '仓库id', null);
INSERT INTO `column_config` VALUES ('228', 'biz_po_in', 'status', 'tinyint', null, '', '\0', null, '', '', '\0', null, '', null);
INSERT INTO `column_config` VALUES ('229', 'biz_po_in', 'remark', 'varchar', null, '', '', null, '', '', '', null, '备注', null);
INSERT INTO `column_config` VALUES ('230', 'biz_po_in', 'is_delete', 'bit', null, '', '\0', null, '', '\0', '\0', null, '删除标记', null);
INSERT INTO `column_config` VALUES ('231', 'biz_po_in', 'version', 'int', null, '', '\0', null, '', '\0', '\0', null, '版本号', null);
INSERT INTO `column_config` VALUES ('232', 'biz_po_in', 'update_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '\0', null, '', '\0', '\0', null, '修改日期', null);
INSERT INTO `column_config` VALUES ('233', 'biz_po_in', 'create_time', 'datetime', null, '', '\0', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('234', 'biz_po_in', 'top_company_code', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '企业代码', null);
INSERT INTO `column_config` VALUES ('235', 'biz_po_in', 'notes', 'varchar', null, '', '\0', null, '', '\0', '\0', null, '系统注释，不参与程序制作', null);
INSERT INTO `column_config` VALUES ('236', 'biz_trade_flow', 'id', 'bigint', null, '', '', null, 'PRI', '', '', null, 'id', null);
INSERT INTO `column_config` VALUES ('237', 'qiniu_config', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('238', 'qiniu_config', 'access_key', 'text', null, '', '', null, '', '', '\0', null, 'accessKey', null);
INSERT INTO `column_config` VALUES ('239', 'qiniu_config', 'bucket', 'varchar', null, '', '', null, '', '', '\0', null, 'Bucket 识别符', null);
INSERT INTO `column_config` VALUES ('240', 'qiniu_config', 'host', 'varchar', null, '', '', null, '', '', '', null, '外链域名', null);
INSERT INTO `column_config` VALUES ('241', 'qiniu_config', 'secret_key', 'text', null, '', '', null, '', '', '\0', null, 'secretKey', null);
INSERT INTO `column_config` VALUES ('242', 'qiniu_config', 'type', 'varchar', null, '', '', null, '', '', '\0', null, '空间类型', null);
INSERT INTO `column_config` VALUES ('243', 'qiniu_config', 'zone', 'varchar', null, '', '', null, '', '', '\0', null, '机房', null);
INSERT INTO `column_config` VALUES ('244', 'sys_sku_classify', 'id', 'bigint', null, 'auto_increment', '', null, 'PRI', '', '\0', null, 'ID', null);
INSERT INTO `column_config` VALUES ('245', 'sys_sku_classify', 'name', 'varchar', null, '', '', null, '', '', '', null, '名称', null);
INSERT INTO `column_config` VALUES ('246', 'sys_sku_classify', 'full_name', 'varchar', null, '', '', null, '', '', '\0', null, '分类全称', null);
INSERT INTO `column_config` VALUES ('247', 'sys_sku_classify', 'pid', 'bigint', null, '', '', null, '', '', '', null, '上级类目', null);
INSERT INTO `column_config` VALUES ('248', 'sys_sku_classify', 'enabled', 'bit', null, '', '', null, '', '', '', null, '状态', null);
INSERT INTO `column_config` VALUES ('249', 'sys_sku_classify', 'remark', 'varchar', null, '', '', null, '', '', '\0', null, '备注', null);
INSERT INTO `column_config` VALUES ('250', 'sys_sku_classify', 'keywords', 'varchar', null, '', '', null, '', '', '\0', null, 'uuid', null);
INSERT INTO `column_config` VALUES ('251', 'sys_sku_classify', 'is_delete', 'bit', null, '', '', null, '', '', '\0', null, '删除标记', null);
INSERT INTO `column_config` VALUES ('252', 'sys_sku_classify', 'version', 'int', null, '', '', null, '', '', '\0', null, '版本号', null);
INSERT INTO `column_config` VALUES ('253', 'sys_sku_classify', 'update_time', 'datetime', null, 'on update CURRENT_TIMESTAMP', '', null, '', '', '\0', null, '修改日期', null);
INSERT INTO `column_config` VALUES ('254', 'sys_sku_classify', 'create_time', 'datetime', null, '', '', null, '', '', '\0', null, '创建日期', null);
INSERT INTO `column_config` VALUES ('255', 'sys_sku_classify', 'top_company_code', 'varchar', null, '', '', null, '', '', '\0', null, '企业代码', null);
INSERT INTO `column_config` VALUES ('256', 'sys_sku_classify', 'notes', 'varchar', null, '', '', null, '', '', '\0', null, '系统注释', null);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `pid` bigint(20) NOT NULL COMMENT '上级部门',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `keywords` varchar(45) DEFAULT '' COMMENT 'uuid相关联',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记0:未删除；1：已删除',
  `version` int(11) DEFAULT '0' COMMENT '版本号，否则同步提交',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部门';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '总部', '0', '', null, 'abc1', '\0', '0', '2020-04-01 21:25:47', '2019-03-01 12:07:37', '10000', null);
INSERT INTO `dept` VALUES ('2', '研发部', '7', '', null, 'abc2', '\0', '0', '2020-04-01 21:25:46', '2019-03-25 09:15:32', '10000', null);
INSERT INTO `dept` VALUES ('5', '运维部', '7', '', null, 'abc3', '\0', '0', '2020-04-01 21:25:45', '2019-03-25 09:20:44', '10000', null);
INSERT INTO `dept` VALUES ('6', '测试部', '8', '', null, 'abc4', '\0', '0', '2020-04-02 11:49:44', '2019-03-25 09:52:18', '10000', null);
INSERT INTO `dept` VALUES ('7', '华南分部', '1', '', null, 'abc5', '\0', '0', '2020-04-01 21:25:44', '2019-03-25 11:04:50', '10000', null);
INSERT INTO `dept` VALUES ('8', '华北分部', '1', '', null, 'abc6', '\0', '0', '2020-04-02 11:49:46', '2019-03-25 11:04:53', '10000', null);
INSERT INTO `dept` VALUES ('11', '人事部', '8', '', null, 'abc7', '\0', '0', '2020-04-02 11:49:46', '2019-03-25 11:07:58', '10000', null);
INSERT INTO `dept` VALUES ('12', '悠学优-12', '8', '', 'ttttt', '1abc1', '', '0', '2020-04-07 22:56:09', '2020-03-31 15:50:20', '10000', null);
INSERT INTO `dept` VALUES ('13', '111bbbbb', '1', '', null, '1abc8', '', '3', '2020-04-07 22:56:01', '2020-03-31 20:31:41', '10000', null);
INSERT INTO `dept` VALUES ('24', 'ta3', '1', '', null, '9a9090d6b02c4a2c8db39d69b45c2023', '', '7', '2020-04-02 11:52:24', '2020-04-02 09:42:22', '10000', null);
INSERT INTO `dept` VALUES ('26', 'eee', '1', '', null, 'cc6c3c7558024ef9a6a493d4e27291f8', '', '1', '2020-04-07 22:56:04', '2020-04-05 18:08:18', '10000', null);
INSERT INTO `dept` VALUES ('27', 'tttt', '1', '', 'ttt', '69dad9947fe24efdbf90eaef7596e805', '', '3', '2020-04-09 09:38:40', '2020-04-09 09:38:22', '10000', null);
INSERT INTO `dept` VALUES ('28', 'eeerrr', '1', '', null, 'f6439068d9af434eac74aac017fa044b', '', '2', '2020-04-09 11:16:49', '2020-04-09 11:16:41', '10000', null);

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '字典名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典';

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'user_status', '用户状态', '2019-10-27 20:31:36');
INSERT INTO `dict` VALUES ('4', 'dept_status', '部门状态', '2019-10-27 20:31:36');
INSERT INTO `dict` VALUES ('6', 'job_status', '工作状况', '2020-04-07 19:56:46');

-- ----------------------------
-- Table structure for dict_detail
-- ----------------------------
DROP TABLE IF EXISTS `dict_detail`;
CREATE TABLE `dict_detail` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) NOT NULL COMMENT '字典标签',
  `value` varchar(255) NOT NULL COMMENT '字典值',
  `sort` varchar(255) DEFAULT NULL COMMENT '排序',
  `dict_id` bigint(11) DEFAULT NULL COMMENT '字典id',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK5tpkputc6d9nboxojdbgnpmyb` (`dict_id`) USING BTREE,
  CONSTRAINT `FK5tpkputc6d9nboxojdbgnpmyb` FOREIGN KEY (`dict_id`) REFERENCES `dict` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据字典详情';

-- ----------------------------
-- Records of dict_detail
-- ----------------------------
INSERT INTO `dict_detail` VALUES ('1', '激活', 'true', '1', '1', '2019-10-27 20:31:36');
INSERT INTO `dict_detail` VALUES ('2', '禁用', 'false', '2', '1', '2020-03-23 18:24:09');
INSERT INTO `dict_detail` VALUES ('3', '启用', 'true', '1', '4', null);
INSERT INTO `dict_detail` VALUES ('4', '停用', 'false', '2', '4', '2019-10-27 20:31:36');
INSERT INTO `dict_detail` VALUES ('7', '启用', 'true', '1', '6', '2020-04-07 20:00:03');
INSERT INTO `dict_detail` VALUES ('8', '禁用', 'false', '999', '6', '2020-04-07 20:00:20');

-- ----------------------------
-- Table structure for email_config
-- ----------------------------
DROP TABLE IF EXISTS `email_config`;
CREATE TABLE `email_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `from_user` varchar(255) DEFAULT NULL COMMENT '收件人',
  `host` varchar(255) DEFAULT NULL COMMENT '邮件服务器SMTP地址',
  `pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `port` varchar(255) DEFAULT NULL COMMENT '端口',
  `user` varchar(255) DEFAULT NULL COMMENT '发件者用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='邮箱配置';

-- ----------------------------
-- Records of email_config
-- ----------------------------

-- ----------------------------
-- Table structure for gen_config
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `table_name` varchar(255) DEFAULT NULL COMMENT '表名',
  `author` varchar(255) DEFAULT NULL COMMENT '作者',
  `cover` bit(1) DEFAULT NULL COMMENT '是否覆盖',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `pack` varchar(255) DEFAULT NULL COMMENT '至于哪个包下',
  `path` varchar(255) DEFAULT NULL COMMENT '前端代码生成的路径',
  `api_path` varchar(255) DEFAULT NULL COMMENT '前端Api文件路径',
  `prefix` varchar(255) DEFAULT NULL COMMENT '表前缀',
  `api_alias` varchar(255) DEFAULT NULL COMMENT '接口名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='代码生成器配置';

-- ----------------------------
-- Records of gen_config
-- ----------------------------
INSERT INTO `gen_config` VALUES ('3', 'gen_test', 'Zheng Jie', '', 'eladmin-system', 'me.zhengjie.gen', 'E:\\workspace\\me\\front\\eladmin-web\\src\\views\\gen', 'E:\\workspace\\me\\front\\eladmin-web\\src\\api', null, '测试生成');
INSERT INTO `gen_config` VALUES ('5', 'test', 'lukeWang', '\0', 'eladmin-system', 'me.zhengjie.modules.system', 'test', 'test\\', null, 'api/test');
INSERT INTO `gen_config` VALUES ('6', 'sys_store', 'lukeWang', '\0', 'eladmin-system', 'me.zhengjie.modules.system', 'D:\\mycompany\\youyi\\eladmin-web\\system', 'D:\\mycompany\\youyi\\eladmin-web\\system\\', null, '/api/bank');
INSERT INTO `gen_config` VALUES ('7', 'sys_trader', 'lukeWang', '\0', 'eladmin-system', 'me.luke.modules.system', 'D:\\mycompany\\youyi\\eladmin-web\\src\\views\\trader', 'D:\\mycompany\\youyi\\eladmin-web\\src\\api', null, 'trader');
INSERT INTO `gen_config` VALUES ('8', 'biz_po_in', 'lukeWang', '\0', 'eladmin-system', 'me.luke.modules.po', 'D:\\mycompany\\youyi\\eladmin-web\\src\\views\\po', 'D:\\mycompany\\youyi\\eladmin-web\\src\\api', null, 'poin');
INSERT INTO `gen_config` VALUES ('9', 'biz_po_in_detail', 'lukeWang', '\0', 'eladmin-system', 'me.luke.modules.po', 'D:\\mycompany\\youyi\\eladmin-web\\src\\views\\biz', 'D:\\mycompany\\youyi\\eladmin-web\\src\\api', null, '/api/bizPoInDetail');

-- ----------------------------
-- Table structure for gen_test
-- ----------------------------
DROP TABLE IF EXISTS `gen_test`;
CREATE TABLE `gen_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(255) DEFAULT NULL COMMENT '性别',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='代码生成测试';

-- ----------------------------
-- Records of gen_test
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '岗位名称',
  `enabled` bit(1) NOT NULL COMMENT '岗位状态',
  `sort` bigint(20) NOT NULL COMMENT '岗位排序',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKmvhj0rogastlctflsxf1d6k3i` (`dept_id`) USING BTREE,
  CONSTRAINT `FKmvhj0rogastlctflsxf1d6k3i` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='岗位';

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('8', '人事专员', '', '3', '11', '2019-03-29 14:52:28');
INSERT INTO `job` VALUES ('10', '产品经理', '', '4', '2', '2019-03-29 14:55:51');
INSERT INTO `job` VALUES ('11', '全栈开发', '', '2', '2', '2019-03-31 13:39:30');
INSERT INTO `job` VALUES ('12', '软件测试', '', '5', '2', '2019-03-31 13:39:43');
INSERT INTO `job` VALUES ('13', 'test', '', '999', '1', '2020-03-31 18:59:48');

-- ----------------------------
-- Table structure for local_storage
-- ----------------------------
DROP TABLE IF EXISTS `local_storage`;
CREATE TABLE `local_storage` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL COMMENT '文件真实的名称',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(255) DEFAULT NULL COMMENT '后缀',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `size` varchar(100) DEFAULT NULL COMMENT '大小',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='本地存储';

-- ----------------------------
-- Records of local_storage
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `log_type` varchar(255) DEFAULT NULL,
  `method` varchar(255) DEFAULT NULL,
  `params` text,
  `request_ip` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `browser` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=424282 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统日志';

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `pid` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `cache` bit(1) DEFAULT b'0' COMMENT '缓存',
  `hidden` bit(1) DEFAULT b'0' COMMENT '隐藏',
  `component_name` varchar(20) DEFAULT '-' COMMENT '组件名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FKqcf9gem97gqa5qjm4d3elcqt5` (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统菜单';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '\0', '系统管理', null, '0', '1', 'system', 'system', '\0', '\0', null, '2018-12-18 15:11:29', null, '0');
INSERT INTO `menu` VALUES ('2', '\0', '用户管理', 'system/user/index', '1', '2', 'peoples', 'user', '\0', '\0', 'User', '2018-12-18 15:14:44', 'user:list', '1');
INSERT INTO `menu` VALUES ('3', '\0', '角色管理', 'system/role/index', '1', '3', 'role', 'role', '\0', '\0', 'Role', '2018-12-18 15:16:07', 'roles:list', '1');
INSERT INTO `menu` VALUES ('5', '\0', '菜单管理', 'system/menu/index', '1', '5', 'menu', 'menu', '\0', '\0', 'Menu', '2018-12-18 15:17:28', 'menu:list', '1');
INSERT INTO `menu` VALUES ('6', '\0', '系统监控', null, '0', '10', 'monitor', 'monitor', '\0', '\0', null, '2018-12-18 15:17:48', null, '0');
INSERT INTO `menu` VALUES ('7', '\0', '操作日志', 'monitor/log/index', '6', '11', 'log', 'logs', '\0', '\0', 'Log', '2018-12-18 15:18:26', null, '1');
INSERT INTO `menu` VALUES ('9', '\0', 'SQL监控', 'monitor/sql/index', '6', '18', 'sqlMonitor', 'druid', '\0', '\0', 'Sql', '2018-12-18 15:19:34', null, '1');
INSERT INTO `menu` VALUES ('10', '\0', '组件管理', null, '0', '50', 'zujian', 'components', '\0', '\0', null, '2018-12-19 13:38:16', null, '0');
INSERT INTO `menu` VALUES ('11', '\0', '图标库', 'components/icons/index', '10', '51', 'icon', 'icon', '\0', '\0', 'Icons', '2018-12-19 13:38:49', null, '1');
INSERT INTO `menu` VALUES ('14', '\0', '邮件工具', 'tools/email/index', '36', '35', 'email', 'email', '\0', '\0', 'Email', '2018-12-27 10:13:09', null, '1');
INSERT INTO `menu` VALUES ('15', '\0', '富文本', 'components/Editor', '10', '52', 'fwb', 'tinymce', '\0', '\0', 'Editor', '2018-12-27 11:58:25', null, '1');
INSERT INTO `menu` VALUES ('16', '\0', '图床管理', 'tools/picture/index', '36', '33', 'image', 'pictures', '\0', '\0', 'Pictures', '2018-12-28 09:36:53', 'pictures:list', '1');
INSERT INTO `menu` VALUES ('18', '\0', '存储管理', 'tools/storage/index', '36', '34', 'qiniu', 'storage', '\0', '\0', 'Storage', '2018-12-31 11:12:15', 'storage:list', '1');
INSERT INTO `menu` VALUES ('19', '\0', '支付宝工具', 'tools/aliPay/index', '36', '37', 'alipay', 'aliPay', '\0', '\0', 'AliPay', '2018-12-31 14:52:38', null, '1');
INSERT INTO `menu` VALUES ('21', '\0', '多级菜单', '', '0', '900', 'menu', 'nested', '\0', '', null, '2019-01-04 16:22:03', null, '0');
INSERT INTO `menu` VALUES ('22', '\0', '二级菜单1', 'nested/menu1/index', '21', '999', 'menu', 'menu1', '\0', '\0', null, '2019-01-04 16:23:29', null, '1');
INSERT INTO `menu` VALUES ('23', '\0', '二级菜单2', 'nested/menu2/index', '21', '999', 'menu', 'menu2', '\0', '\0', null, '2019-01-04 16:23:57', null, '1');
INSERT INTO `menu` VALUES ('24', '\0', '三级菜单1', 'nested/menu1/menu1-1', '22', '999', 'menu', 'menu1-1', '\0', '\0', null, '2019-01-04 16:24:48', null, '1');
INSERT INTO `menu` VALUES ('27', '\0', '三级菜单2', 'nested/menu1/menu1-2', '22', '999', 'menu', 'menu1-2', '\0', '\0', null, '2019-01-07 17:27:32', null, '1');
INSERT INTO `menu` VALUES ('28', '\0', '定时任务', 'system/timing/index', '36', '31', 'timing', 'timing', '\0', '\0', 'Timing', '2019-01-07 20:34:40', 'timing:list', '1');
INSERT INTO `menu` VALUES ('30', '\0', '代码生成', 'generator/index', '36', '32', 'dev', 'generator', '', '\0', 'GeneratorIndex', '2019-01-11 15:45:55', null, '1');
INSERT INTO `menu` VALUES ('32', '\0', '异常日志', 'monitor/log/errorLog', '6', '12', 'error', 'errorLog', '\0', '\0', 'ErrorLog', '2019-01-13 13:49:03', null, '1');
INSERT INTO `menu` VALUES ('33', '\0', 'Markdown', 'components/MarkDown', '10', '53', 'markdown', 'markdown', '\0', '\0', 'Markdown', '2019-03-08 13:46:44', null, '1');
INSERT INTO `menu` VALUES ('34', '\0', 'Yaml编辑器', 'components/YamlEdit', '10', '54', 'dev', 'yaml', '\0', '\0', 'YamlEdit', '2019-03-08 15:49:40', null, '1');
INSERT INTO `menu` VALUES ('35', '\0', '部门管理', 'system/dept/index', '1', '6', 'dept', 'dept', '\0', '\0', 'Dept', '2019-03-25 09:46:00', 'dept:list', '1');
INSERT INTO `menu` VALUES ('36', '\0', '系统工具', '', '0', '30', 'sys-tools', 'sys-tools', '\0', '\0', null, '2019-03-29 10:57:35', null, '0');
INSERT INTO `menu` VALUES ('37', '\0', '岗位管理', 'system/job/index', '1', '17', 'Steve-Jobs', 'job', '\0', '\0', 'Job', '2019-03-29 13:51:18', 'job:list', '1');
INSERT INTO `menu` VALUES ('38', '\0', '接口文档', 'tools/swagger/index', '36', '36', 'swagger', 'swagger2', '\0', '\0', 'Swagger', '2019-03-29 19:57:53', null, '1');
INSERT INTO `menu` VALUES ('39', '\0', '字典管理', 'system/dict/index', '1', '20', 'dictionary', 'dict', '\0', '\0', 'Dict', '2019-04-10 11:49:04', 'dict:list', '1');
INSERT INTO `menu` VALUES ('41', '\0', '在线用户', 'monitor/online/index', '6', '10', 'Steve-Jobs', 'online', '\0', '\0', 'OnlineUser', '2019-10-26 22:08:43', null, '1');
INSERT INTO `menu` VALUES ('44', '\0', '用户新增', '', '2', '2', '', '', '\0', '\0', '', '2019-10-29 10:59:46', 'user:add', '2');
INSERT INTO `menu` VALUES ('45', '\0', '用户编辑', '', '2', '3', '', '', '\0', '\0', '', '2019-10-29 11:00:08', 'user:edit', '2');
INSERT INTO `menu` VALUES ('46', '\0', '用户删除', '', '2', '4', '', '', '\0', '\0', '', '2019-10-29 11:00:23', 'user:del', '2');
INSERT INTO `menu` VALUES ('48', '\0', '角色创建', '', '3', '2', '', '', '\0', '\0', '', '2019-10-29 12:45:34', 'roles:add', '2');
INSERT INTO `menu` VALUES ('49', '\0', '角色修改', '', '3', '3', '', '', '\0', '\0', '', '2019-10-29 12:46:16', 'roles:edit', '2');
INSERT INTO `menu` VALUES ('50', '\0', '角色删除', '', '3', '4', '', '', '\0', '\0', '', '2019-10-29 12:46:51', 'roles:del', '2');
INSERT INTO `menu` VALUES ('52', '\0', '菜单新增', '', '5', '2', '', '', '\0', '\0', '', '2019-10-29 12:55:07', 'menu:add', '2');
INSERT INTO `menu` VALUES ('53', '\0', '菜单编辑', '', '5', '3', '', '', '\0', '\0', '', '2019-10-29 12:55:40', 'menu:edit', '2');
INSERT INTO `menu` VALUES ('54', '\0', '菜单删除', '', '5', '4', '', '', '\0', '\0', '', '2019-10-29 12:56:00', 'menu:del', '2');
INSERT INTO `menu` VALUES ('56', '\0', '部门新增', '', '35', '2', '', '', '\0', '\0', '', '2019-10-29 12:57:09', 'dept:add', '2');
INSERT INTO `menu` VALUES ('57', '\0', '部门编辑', '', '35', '3', '', '', '\0', '\0', '', '2019-10-29 12:57:27', 'dept:edit', '2');
INSERT INTO `menu` VALUES ('58', '\0', '部门删除', '', '35', '4', '', '', '\0', '\0', '', '2019-10-29 12:57:41', 'dept:del', '2');
INSERT INTO `menu` VALUES ('60', '\0', '岗位新增', '', '37', '2', '', '', '\0', '\0', '', '2019-10-29 12:58:27', 'job:add', '2');
INSERT INTO `menu` VALUES ('61', '\0', '岗位编辑', '', '37', '3', '', '', '\0', '\0', '', '2019-10-29 12:58:45', 'job:edit', '2');
INSERT INTO `menu` VALUES ('62', '\0', '岗位删除', '', '37', '4', '', '', '\0', '\0', '', '2019-10-29 12:59:04', 'job:del', '2');
INSERT INTO `menu` VALUES ('64', '\0', '字典新增', '', '39', '2', '', '', '\0', '\0', '', '2019-10-29 13:00:17', 'dict:add', '2');
INSERT INTO `menu` VALUES ('65', '\0', '字典编辑', '', '39', '3', '', '', '\0', '\0', '', '2019-10-29 13:00:42', 'dict:edit', '2');
INSERT INTO `menu` VALUES ('66', '\0', '字典删除', '', '39', '4', '', '', '\0', '\0', '', '2019-10-29 13:00:59', 'dict:del', '2');
INSERT INTO `menu` VALUES ('70', '\0', '图片上传', '', '16', '2', '', '', '\0', '\0', '', '2019-10-29 13:05:34', 'pictures:add', '2');
INSERT INTO `menu` VALUES ('71', '\0', '图片删除', '', '16', '3', '', '', '\0', '\0', '', '2019-10-29 13:05:52', 'pictures:del', '2');
INSERT INTO `menu` VALUES ('73', '\0', '任务新增', '', '28', '2', '', '', '\0', '\0', '', '2019-10-29 13:07:28', 'timing:add', '2');
INSERT INTO `menu` VALUES ('74', '\0', '任务编辑', '', '28', '3', '', '', '\0', '\0', '', '2019-10-29 13:07:41', 'timing:edit', '2');
INSERT INTO `menu` VALUES ('75', '\0', '任务删除', '', '28', '4', '', '', '\0', '\0', '', '2019-10-29 13:07:54', 'timing:del', '2');
INSERT INTO `menu` VALUES ('77', '\0', '上传文件', '', '18', '2', '', '', '\0', '\0', '', '2019-10-29 13:09:09', 'storage:add', '2');
INSERT INTO `menu` VALUES ('78', '\0', '文件编辑', '', '18', '3', '', '', '\0', '\0', '', '2019-10-29 13:09:22', 'storage:edit', '2');
INSERT INTO `menu` VALUES ('79', '\0', '文件删除', '', '18', '4', '', '', '\0', '\0', '', '2019-10-29 13:09:34', 'storage:del', '2');
INSERT INTO `menu` VALUES ('80', '\0', '服务监控', 'monitor/server/index', '6', '14', 'codeConsole', 'server', '\0', '\0', 'ServerMonitor', '2019-11-07 13:06:39', 'server:list', '1');
INSERT INTO `menu` VALUES ('82', '\0', '生成配置', 'generator/config', '36', '33', 'dev', 'generator/config/:tableName', '', '', 'GeneratorConfig', '2019-11-17 20:08:56', '', '1');
INSERT INTO `menu` VALUES ('83', '\0', '图表库', 'components/Echarts', '10', '50', 'chart', 'echarts', '', '\0', 'Echarts', '2019-11-21 09:04:32', '', '1');
INSERT INTO `menu` VALUES ('90', '\0', '运维管理', '', '0', '20', 'mnt', 'mnt', '\0', '\0', 'Mnt', '2019-11-09 10:31:08', null, '1');
INSERT INTO `menu` VALUES ('92', '\0', '服务器', 'mnt/server/index', '90', '22', 'server', 'mnt/serverDeploy', '\0', '\0', 'ServerDeploy', '2019-11-10 10:29:25', 'serverDeploy:list', '1');
INSERT INTO `menu` VALUES ('93', '\0', '应用管理', 'mnt/app/index', '90', '23', 'app', 'mnt/app', '\0', '\0', 'App', '2019-11-10 11:05:16', 'app:list', '1');
INSERT INTO `menu` VALUES ('94', '\0', '部署管理', 'mnt/deploy/index', '90', '24', 'deploy', 'mnt/deploy', '\0', '\0', 'Deploy', '2019-11-10 15:56:55', 'deploy:list', '1');
INSERT INTO `menu` VALUES ('97', '\0', '部署备份', 'mnt/deployHistory/index', '90', '25', 'backup', 'mnt/deployHistory', '\0', '\0', 'DeployHistory', '2019-11-10 16:49:44', 'deployHistory:list', '1');
INSERT INTO `menu` VALUES ('98', '\0', '数据库管理', 'mnt/database/index', '90', '26', 'database', 'mnt/database', '\0', '\0', 'Database', '2019-11-10 20:40:04', 'database:list', '1');
INSERT INTO `menu` VALUES ('102', '\0', '删除', '', '97', '999', '', '', '\0', '\0', '', '2019-11-17 09:32:48', 'deployHistory:del', '2');
INSERT INTO `menu` VALUES ('103', '\0', '服务器新增', '', '92', '999', '', '', '\0', '\0', '', '2019-11-17 11:08:33', 'serverDeploy:add', '2');
INSERT INTO `menu` VALUES ('104', '\0', '服务器编辑', '', '92', '999', '', '', '\0', '\0', '', '2019-11-17 11:08:57', 'serverDeploy:edit', '2');
INSERT INTO `menu` VALUES ('105', '\0', '服务器删除', '', '92', '999', '', '', '\0', '\0', '', '2019-11-17 11:09:15', 'serverDeploy:del', '2');
INSERT INTO `menu` VALUES ('106', '\0', '应用新增', '', '93', '999', '', '', '\0', '\0', '', '2019-11-17 11:10:03', 'app:add', '2');
INSERT INTO `menu` VALUES ('107', '\0', '应用编辑', '', '93', '999', '', '', '\0', '\0', '', '2019-11-17 11:10:28', 'app:edit', '2');
INSERT INTO `menu` VALUES ('108', '\0', '应用删除', '', '93', '999', '', '', '\0', '\0', '', '2019-11-17 11:10:55', 'app:del', '2');
INSERT INTO `menu` VALUES ('109', '\0', '部署新增', '', '94', '999', '', '', '\0', '\0', '', '2019-11-17 11:11:22', 'deploy:add', '2');
INSERT INTO `menu` VALUES ('110', '\0', '部署编辑', '', '94', '999', '', '', '\0', '\0', '', '2019-11-17 11:11:41', 'deploy:edit', '2');
INSERT INTO `menu` VALUES ('111', '\0', '部署删除', '', '94', '999', '', '', '\0', '\0', '', '2019-11-17 11:12:01', 'deploy:del', '2');
INSERT INTO `menu` VALUES ('112', '\0', '数据库新增', '', '98', '999', '', '', '\0', '\0', '', '2019-11-17 11:12:43', 'database:add', '2');
INSERT INTO `menu` VALUES ('113', '\0', '数据库编辑', '', '98', '999', '', '', '\0', '\0', '', '2019-11-17 11:12:58', 'database:edit', '2');
INSERT INTO `menu` VALUES ('114', '\0', '数据库删除', '', '98', '999', '', '', '\0', '\0', '', '2019-11-17 11:13:14', 'database:del', '2');
INSERT INTO `menu` VALUES ('116', '\0', '生成预览', 'generator/preview', '36', '999', 'java', 'generator/preview/:tableName', '', '', 'Preview', '2019-11-26 14:54:36', null, '1');
INSERT INTO `menu` VALUES ('117', '\0', '银行管理', 'system/bank/index', '1', '25', 'system', 'bank', '\0', '\0', 'Bank', '2020-03-24 12:03:45', 'bank:list', '1');
INSERT INTO `menu` VALUES ('118', '\0', '银行新增', null, '117', '1', null, '', '\0', '\0', null, '2020-03-24 12:07:25', 'bank:add', '2');
INSERT INTO `menu` VALUES ('119', '\0', '银行编辑', null, '117', '2', null, null, '\0', '\0', null, '2020-03-24 12:08:50', 'bank:edit', '2');
INSERT INTO `menu` VALUES ('120', '\0', '银行删除', null, '117', '3', null, null, '\0', '\0', null, '2020-03-24 12:09:20', 'bank:del', '2');
INSERT INTO `menu` VALUES ('121', '\0', '仓库信息', 'system/store/index', '1', '15', 'tab', 'store', '\0', '\0', 'Store', '2020-04-03 22:19:28', 'store:list', '1');
INSERT INTO `menu` VALUES ('122', '\0', '仓库新增', null, '121', '1', null, null, '\0', '\0', null, '2020-04-03 22:24:01', 'store:add', '2');
INSERT INTO `menu` VALUES ('123', '\0', '仓库编辑', null, '121', '2', null, null, '\0', '\0', null, '2020-04-03 22:25:37', 'store:edit', '2');
INSERT INTO `menu` VALUES ('124', '\0', '仓库删除', null, '121', '3', null, null, '\0', '\0', null, '2020-04-03 22:26:08', 'store:del', '2');
INSERT INTO `menu` VALUES ('125', '\0', '商品分类', 'system/skuclassify/index', '1', '10', 'zujian', 'skuclassify', '\0', '\0', 'Skuclassify', '2020-04-09 10:01:08', 'classify:list', '1');
INSERT INTO `menu` VALUES ('126', '\0', '分类新增', null, '125', '1', null, null, '\0', '\0', null, '2020-04-09 10:05:47', 'classify:add', '2');
INSERT INTO `menu` VALUES ('127', '\0', '分类编辑', null, '125', '2', null, null, '\0', '\0', null, '2020-04-09 10:06:42', 'classify:edit', '2');
INSERT INTO `menu` VALUES ('128', '\0', '分类删除', null, '125', '2', null, null, '\0', '\0', null, '2020-04-09 10:07:17', 'classify:del', '2');
INSERT INTO `menu` VALUES ('129', '\0', '商品信息', 'system/sku/index', '1', '13', 'menu', 'sku', '\0', '\0', 'Sku', '2020-04-12 11:08:14', 'sku:list', '1');
INSERT INTO `menu` VALUES ('130', '\0', '商品新增', null, '129', '1', null, null, '\0', '\0', null, '2020-04-12 11:10:59', 'sku:add', '2');
INSERT INTO `menu` VALUES ('131', '\0', '商品编辑', null, '129', '2', null, null, '\0', '\0', null, '2020-04-12 11:11:27', 'sku:edit', '2');
INSERT INTO `menu` VALUES ('132', '\0', '商品删除', null, '129', '3', null, null, '\0', '\0', null, '2020-04-12 11:12:06', 'sku:del', '2');
INSERT INTO `menu` VALUES ('133', '\0', '往来单位', 'system/trader/index', '1', '23', 'peoples', 'trader', '\0', '\0', 'Trader', '2020-04-16 09:38:03', 'trader:list', '1');
INSERT INTO `menu` VALUES ('134', '\0', '往来单位新增', null, '133', '1', null, null, '\0', '\0', null, '2020-04-16 09:40:55', 'trader:add', '2');
INSERT INTO `menu` VALUES ('135', '\0', '往来单位修改', null, '133', '2', null, null, '\0', '\0', null, '2020-04-16 09:41:42', 'trader:edit', '2');
INSERT INTO `menu` VALUES ('136', '\0', '往来单位删除', null, '133', '3', null, null, '\0', '\0', null, '2020-04-16 09:42:07', 'trader:del', '2');
INSERT INTO `menu` VALUES ('137', '\0', '采购管理', null, '0', '5', 'dictionary', 'po', '\0', '\0', null, '2020-04-17 09:38:06', null, '0');
INSERT INTO `menu` VALUES ('138', '\0', '采购入库', 'biz/poin/index', '137', '1', 'skill', 'poin', '\0', '\0', 'PoIn', '2020-04-17 09:39:23', 'poin:list', '1');
INSERT INTO `menu` VALUES ('139', '\0', '采购入库新增', null, '138', '1', null, null, '\0', '\0', null, '2020-04-17 09:41:46', 'poin:add', '2');
INSERT INTO `menu` VALUES ('140', '\0', '采购入库编辑', null, '138', '999', null, null, '\0', '\0', null, '2020-04-17 09:42:54', 'poin:edit', '2');
INSERT INTO `menu` VALUES ('141', '\0', '采购入库删除', null, '138', '3', null, null, '\0', '\0', null, '2020-04-17 09:43:23', 'poin:del', '2');
INSERT INTO `menu` VALUES ('142', '\0', '采购入库-新增', 'biz/poin/config', '137', '1', 'edit', 'poin/config/:poId', '', '', 'BizPoInAdd', '2020-04-18 22:52:09', 'poin:add', '1');

-- ----------------------------
-- Table structure for mnt_app
-- ----------------------------
DROP TABLE IF EXISTS `mnt_app`;
CREATE TABLE `mnt_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '应用ID',
  `name` varchar(255) DEFAULT NULL COMMENT '应用名称',
  `upload_path` varchar(255) DEFAULT NULL COMMENT '上传目录',
  `deploy_path` varchar(255) DEFAULT NULL COMMENT '部署路径',
  `backup_path` varchar(255) DEFAULT NULL COMMENT '备份路径',
  `port` int(255) DEFAULT NULL COMMENT '应用端口',
  `start_script` varchar(4000) DEFAULT NULL COMMENT '启动脚本',
  `deploy_script` varchar(4000) DEFAULT NULL COMMENT '部署脚本',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='应用管理';

-- ----------------------------
-- Records of mnt_app
-- ----------------------------
INSERT INTO `mnt_app` VALUES ('1', 'eladmin-monitor-2.4.jar', '/opt/upload', '/opt/monitor', '/opt/backup', '8777', 'cd /opt/monitor\nnohup java -jar eladmin-monitor-2.4.jar >nohup.out 2>&1 &', 'mv -f /opt/upload/eladmin-monitor-2.4.jar /opt/monitor\ncd /opt/monitor\nnohup java -jar eladmin-monitor-2.4.jar >nohup.out 2>&1 &', '2019-11-24 20:52:59');
INSERT INTO `mnt_app` VALUES ('2', 'eladmin-system-2.3.jar', '/opt/upload', '/opt/eladmin', '/opt/backup/eladmin', '8000', 'cd /opt/eladmin\nnohup java -jar eladmin-system-2.3.jar --spring.profiles.active=prod >nohup.out 2>&1 &', 'mv -f /opt/upload/eladmin-system-2.3.jar /opt/eladmin/\ncd /opt/eladmin\nnohup java -jar eladmin-system-2.3.jar --spring.profiles.active=prod >nohup.out 2>&1 &', '2019-12-21 16:39:57');

-- ----------------------------
-- Table structure for mnt_database
-- ----------------------------
DROP TABLE IF EXISTS `mnt_database`;
CREATE TABLE `mnt_database` (
  `id` varchar(255) NOT NULL COMMENT '编号',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `jdbc_url` varchar(255) NOT NULL COMMENT 'jdbc连接',
  `user_name` varchar(255) NOT NULL COMMENT '账号',
  `pwd` varchar(255) NOT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='数据库管理';

-- ----------------------------
-- Records of mnt_database
-- ----------------------------
INSERT INTO `mnt_database` VALUES ('c4109eefc5724c65857ca9dd2690e0dd', 'eladmin', 'jdbc:mysql://localhost:3306/eladmin?serverTimezone=Asia/Shanghai', 'root', '123456', '2019-12-21 21:11:17');

-- ----------------------------
-- Table structure for mnt_deploy
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy`;
CREATE TABLE `mnt_deploy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `app_id` bigint(20) DEFAULT NULL COMMENT '应用编号',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK6sy157pseoxx4fmcqr1vnvvhy` (`app_id`) USING BTREE,
  CONSTRAINT `FK6sy157pseoxx4fmcqr1vnvvhy` FOREIGN KEY (`app_id`) REFERENCES `mnt_app` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部署管理';

-- ----------------------------
-- Records of mnt_deploy
-- ----------------------------
INSERT INTO `mnt_deploy` VALUES ('3', '1', '2019-12-21 15:53:06');
INSERT INTO `mnt_deploy` VALUES ('6', '2', '2019-12-21 17:09:02');

-- ----------------------------
-- Table structure for mnt_deploy_history
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy_history`;
CREATE TABLE `mnt_deploy_history` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `app_name` varchar(255) NOT NULL COMMENT '应用名称',
  `deploy_date` datetime NOT NULL COMMENT '部署日期',
  `deploy_user` varchar(50) NOT NULL COMMENT '部署用户',
  `ip` varchar(20) NOT NULL COMMENT '服务器IP',
  `deploy_id` bigint(20) DEFAULT NULL COMMENT '部署编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部署历史管理';

-- ----------------------------
-- Records of mnt_deploy_history
-- ----------------------------
INSERT INTO `mnt_deploy_history` VALUES ('4ee0edd1f3b648a396280a542d72c121', 'eladmin-monitor-2.4.jar', '2019-12-22 13:06:07', 'admin', '132.232.129.20', '3');
INSERT INTO `mnt_deploy_history` VALUES ('4fd432a128c947ccae55316b3d5dcd7b', 'eladmin-monitor-2.4.jar', '2019-12-22 13:49:09', 'admin', '132.232.129.20', '3');
INSERT INTO `mnt_deploy_history` VALUES ('cfda21f48da341b396657af94554c890', 'eladmin-monitor-2.4.jar', '2019-12-22 13:08:22', 'admin', '132.232.129.20', '3');

-- ----------------------------
-- Table structure for mnt_deploy_server
-- ----------------------------
DROP TABLE IF EXISTS `mnt_deploy_server`;
CREATE TABLE `mnt_deploy_server` (
  `deploy_id` bigint(20) NOT NULL,
  `server_id` bigint(20) NOT NULL,
  PRIMARY KEY (`deploy_id`,`server_id`) USING BTREE,
  KEY `FKeaaha7jew9a02b3bk9ghols53` (`server_id`) USING BTREE,
  CONSTRAINT `FK3cehr56tedph6nk3gxsmeq0pb` FOREIGN KEY (`deploy_id`) REFERENCES `mnt_deploy` (`id`),
  CONSTRAINT `FKeaaha7jew9a02b3bk9ghols53` FOREIGN KEY (`server_id`) REFERENCES `mnt_server` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='应用与服务器关联';

-- ----------------------------
-- Records of mnt_deploy_server
-- ----------------------------
INSERT INTO `mnt_deploy_server` VALUES ('3', '1');
INSERT INTO `mnt_deploy_server` VALUES ('6', '1');

-- ----------------------------
-- Table structure for mnt_server
-- ----------------------------
DROP TABLE IF EXISTS `mnt_server`;
CREATE TABLE `mnt_server` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'IP地址',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `ip` varchar(255) DEFAULT NULL COMMENT 'IP地址',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `port` int(11) DEFAULT NULL COMMENT '端口',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='服务器管理';

-- ----------------------------
-- Records of mnt_server
-- ----------------------------
INSERT INTO `mnt_server` VALUES ('1', 'root', '132.232.129.20', '腾讯云', 'Dqjdda1996.', '8013', '2019-11-24 20:35:02');

-- ----------------------------
-- Table structure for monitor_server
-- ----------------------------
DROP TABLE IF EXISTS `monitor_server`;
CREATE TABLE `monitor_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpu_core` int(11) DEFAULT NULL COMMENT 'CPU内核数',
  `cpu_rate` double DEFAULT NULL COMMENT 'CPU使用率',
  `disk_total` double DEFAULT NULL COMMENT '磁盘总量',
  `disk_used` double DEFAULT NULL COMMENT '磁盘使用量',
  `mem_total` double DEFAULT NULL COMMENT '内存总数',
  `mem_used` double DEFAULT NULL COMMENT '内存使用量',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `port` int(11) DEFAULT NULL COMMENT '访问端口',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `state` varchar(255) DEFAULT NULL COMMENT '状态',
  `swap_total` double DEFAULT NULL COMMENT '交换区总量',
  `swap_used` double DEFAULT NULL COMMENT '交换区使用量',
  `address` varchar(255) NOT NULL COMMENT '服务地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='服务监控';

-- ----------------------------
-- Records of monitor_server
-- ----------------------------
INSERT INTO `monitor_server` VALUES ('1', '8', '0.05924018', '465.12402', '91.66521', '7.849415', '7.6052284', '本地', '8777', '999', '0', '14.599415', '11.263367', 'localhost');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `create_time` datetime DEFAULT NULL COMMENT '上传日期',
  `delete_url` varchar(255) DEFAULT NULL COMMENT '删除的URL',
  `filename` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `height` varchar(255) DEFAULT NULL COMMENT '图片高度',
  `size` varchar(255) DEFAULT NULL COMMENT '图片大小',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `width` varchar(255) DEFAULT NULL COMMENT '图片宽度',
  `md5code` varchar(255) DEFAULT NULL COMMENT '文件的MD5值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Sm.Ms图床';

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for qiniu_config
-- ----------------------------
DROP TABLE IF EXISTS `qiniu_config`;
CREATE TABLE `qiniu_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `access_key` text COMMENT 'accessKey',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `host` varchar(255) NOT NULL COMMENT '外链域名',
  `secret_key` text COMMENT 'secretKey',
  `type` varchar(255) DEFAULT NULL COMMENT '空间类型',
  `zone` varchar(255) DEFAULT NULL COMMENT '机房',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='七牛云配置';

-- ----------------------------
-- Records of qiniu_config
-- ----------------------------

-- ----------------------------
-- Table structure for qiniu_content
-- ----------------------------
DROP TABLE IF EXISTS `qiniu_content`;
CREATE TABLE `qiniu_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bucket` varchar(255) DEFAULT NULL COMMENT 'Bucket 识别符',
  `name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `size` varchar(255) DEFAULT NULL COMMENT '文件大小',
  `type` varchar(255) DEFAULT NULL COMMENT '文件类型：私有或公开',
  `update_time` datetime DEFAULT NULL COMMENT '上传或同步的时间',
  `url` varchar(255) DEFAULT NULL COMMENT '文件url',
  `suffix` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='七牛云文件存储';

-- ----------------------------
-- Records of qiniu_content
-- ----------------------------

-- ----------------------------
-- Table structure for quartz_job
-- ----------------------------
DROP TABLE IF EXISTS `quartz_job`;
CREATE TABLE `quartz_job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `bean_name` varchar(255) DEFAULT NULL COMMENT 'Spring Bean名称',
  `cron_expression` varchar(255) DEFAULT NULL COMMENT 'cron 表达式',
  `is_pause` bit(1) DEFAULT NULL COMMENT '状态：1暂停、0启用',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名称',
  `method_name` varchar(255) DEFAULT NULL COMMENT '方法名称',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='定时任务';

-- ----------------------------
-- Records of quartz_job
-- ----------------------------
INSERT INTO `quartz_job` VALUES ('1', 'visitsTask', '0 0 0 * * ?', '\0', '更新访客记录', 'run', null, '每日0点创建新的访客记录', '2019-01-08 14:53:31');
INSERT INTO `quartz_job` VALUES ('2', 'testTask', '0/5 * * * * ?', '', '测试1', 'run1', 'test', '带参测试，多参使用json', '2019-08-22 14:08:29');
INSERT INTO `quartz_job` VALUES ('3', 'testTask', '0/5 * * * * ?', '', '测试', 'run', '', '不带参测试', '2019-09-26 16:44:39');

-- ----------------------------
-- Table structure for quartz_log
-- ----------------------------
DROP TABLE IF EXISTS `quartz_log`;
CREATE TABLE `quartz_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baen_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `cron_expression` varchar(255) DEFAULT NULL,
  `exception_detail` text,
  `is_success` bit(1) DEFAULT NULL,
  `job_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `params` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='定时任务日志';

-- ----------------------------
-- Records of quartz_log
-- ----------------------------
INSERT INTO `quartz_log` VALUES ('1', 'visitsTask', '2020-04-15 00:00:00', '0 0 0 * * ?', null, '', '更新访客记录', 'run', null, '122');
INSERT INTO `quartz_log` VALUES ('2', 'testTask', '2020-04-18 19:12:37', '0/5 * * * * ?', null, '', '测试', 'run', '', '11');
INSERT INTO `quartz_log` VALUES ('3', 'visitsTask', '2020-04-20 00:00:00', '0 0 0 * * ?', null, '', '更新访客记录', 'run', null, '53');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `data_scope` varchar(255) DEFAULT NULL COMMENT '数据权限',
  `level` int(255) DEFAULT NULL COMMENT '角色级别',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `permission` varchar(255) DEFAULT NULL COMMENT '功能权限',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '-', '全部', '1', '2018-11-23 11:04:37', 'admin');
INSERT INTO `role` VALUES ('2', '普通用户', '-', '本级', '2', '2018-11-23 13:09:06', 'common');

-- ----------------------------
-- Table structure for roles_depts
-- ----------------------------
DROP TABLE IF EXISTS `roles_depts`;
CREATE TABLE `roles_depts` (
  `role_id` bigint(20) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE,
  KEY `FK7qg6itn5ajdoa9h9o78v9ksur` (`dept_id`) USING BTREE,
  CONSTRAINT `FK7qg6itn5ajdoa9h9o78v9ksur` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `FKrg1ci4cxxfbja0sb0pddju7k` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色部门关联';

-- ----------------------------
-- Records of roles_depts
-- ----------------------------

-- ----------------------------
-- Table structure for roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`menu_id`,`role_id`) USING BTREE,
  KEY `FKcngg2qadojhi3a651a5adkvbq` (`role_id`) USING BTREE,
  CONSTRAINT `FKo7wsmlrrxb2osfaoavp46rv2r` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`),
  CONSTRAINT `FKtag324maketmxffly3pdyh193` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色菜单关联';

-- ----------------------------
-- Records of roles_menus
-- ----------------------------
INSERT INTO `roles_menus` VALUES ('1', '1');
INSERT INTO `roles_menus` VALUES ('2', '1');
INSERT INTO `roles_menus` VALUES ('3', '1');
INSERT INTO `roles_menus` VALUES ('5', '1');
INSERT INTO `roles_menus` VALUES ('6', '1');
INSERT INTO `roles_menus` VALUES ('7', '1');
INSERT INTO `roles_menus` VALUES ('9', '1');
INSERT INTO `roles_menus` VALUES ('10', '1');
INSERT INTO `roles_menus` VALUES ('11', '1');
INSERT INTO `roles_menus` VALUES ('14', '1');
INSERT INTO `roles_menus` VALUES ('15', '1');
INSERT INTO `roles_menus` VALUES ('16', '1');
INSERT INTO `roles_menus` VALUES ('18', '1');
INSERT INTO `roles_menus` VALUES ('19', '1');
INSERT INTO `roles_menus` VALUES ('21', '1');
INSERT INTO `roles_menus` VALUES ('22', '1');
INSERT INTO `roles_menus` VALUES ('23', '1');
INSERT INTO `roles_menus` VALUES ('24', '1');
INSERT INTO `roles_menus` VALUES ('27', '1');
INSERT INTO `roles_menus` VALUES ('28', '1');
INSERT INTO `roles_menus` VALUES ('30', '1');
INSERT INTO `roles_menus` VALUES ('32', '1');
INSERT INTO `roles_menus` VALUES ('33', '1');
INSERT INTO `roles_menus` VALUES ('34', '1');
INSERT INTO `roles_menus` VALUES ('35', '1');
INSERT INTO `roles_menus` VALUES ('36', '1');
INSERT INTO `roles_menus` VALUES ('37', '1');
INSERT INTO `roles_menus` VALUES ('38', '1');
INSERT INTO `roles_menus` VALUES ('39', '1');
INSERT INTO `roles_menus` VALUES ('41', '1');
INSERT INTO `roles_menus` VALUES ('44', '1');
INSERT INTO `roles_menus` VALUES ('45', '1');
INSERT INTO `roles_menus` VALUES ('46', '1');
INSERT INTO `roles_menus` VALUES ('48', '1');
INSERT INTO `roles_menus` VALUES ('49', '1');
INSERT INTO `roles_menus` VALUES ('50', '1');
INSERT INTO `roles_menus` VALUES ('52', '1');
INSERT INTO `roles_menus` VALUES ('53', '1');
INSERT INTO `roles_menus` VALUES ('54', '1');
INSERT INTO `roles_menus` VALUES ('56', '1');
INSERT INTO `roles_menus` VALUES ('57', '1');
INSERT INTO `roles_menus` VALUES ('58', '1');
INSERT INTO `roles_menus` VALUES ('60', '1');
INSERT INTO `roles_menus` VALUES ('61', '1');
INSERT INTO `roles_menus` VALUES ('62', '1');
INSERT INTO `roles_menus` VALUES ('64', '1');
INSERT INTO `roles_menus` VALUES ('65', '1');
INSERT INTO `roles_menus` VALUES ('66', '1');
INSERT INTO `roles_menus` VALUES ('73', '1');
INSERT INTO `roles_menus` VALUES ('74', '1');
INSERT INTO `roles_menus` VALUES ('75', '1');
INSERT INTO `roles_menus` VALUES ('77', '1');
INSERT INTO `roles_menus` VALUES ('78', '1');
INSERT INTO `roles_menus` VALUES ('79', '1');
INSERT INTO `roles_menus` VALUES ('80', '1');
INSERT INTO `roles_menus` VALUES ('82', '1');
INSERT INTO `roles_menus` VALUES ('83', '1');
INSERT INTO `roles_menus` VALUES ('90', '1');
INSERT INTO `roles_menus` VALUES ('92', '1');
INSERT INTO `roles_menus` VALUES ('93', '1');
INSERT INTO `roles_menus` VALUES ('94', '1');
INSERT INTO `roles_menus` VALUES ('97', '1');
INSERT INTO `roles_menus` VALUES ('98', '1');
INSERT INTO `roles_menus` VALUES ('116', '1');
INSERT INTO `roles_menus` VALUES ('117', '1');
INSERT INTO `roles_menus` VALUES ('121', '1');
INSERT INTO `roles_menus` VALUES ('123', '1');
INSERT INTO `roles_menus` VALUES ('124', '1');
INSERT INTO `roles_menus` VALUES ('125', '1');
INSERT INTO `roles_menus` VALUES ('126', '1');
INSERT INTO `roles_menus` VALUES ('127', '1');
INSERT INTO `roles_menus` VALUES ('128', '1');
INSERT INTO `roles_menus` VALUES ('129', '1');
INSERT INTO `roles_menus` VALUES ('133', '1');
INSERT INTO `roles_menus` VALUES ('134', '1');
INSERT INTO `roles_menus` VALUES ('135', '1');
INSERT INTO `roles_menus` VALUES ('136', '1');
INSERT INTO `roles_menus` VALUES ('137', '1');
INSERT INTO `roles_menus` VALUES ('138', '1');
INSERT INTO `roles_menus` VALUES ('140', '1');
INSERT INTO `roles_menus` VALUES ('141', '1');
INSERT INTO `roles_menus` VALUES ('142', '1');
INSERT INTO `roles_menus` VALUES ('1', '2');
INSERT INTO `roles_menus` VALUES ('2', '2');
INSERT INTO `roles_menus` VALUES ('3', '2');
INSERT INTO `roles_menus` VALUES ('5', '2');
INSERT INTO `roles_menus` VALUES ('6', '2');
INSERT INTO `roles_menus` VALUES ('9', '2');
INSERT INTO `roles_menus` VALUES ('10', '2');
INSERT INTO `roles_menus` VALUES ('11', '2');
INSERT INTO `roles_menus` VALUES ('14', '2');
INSERT INTO `roles_menus` VALUES ('15', '2');
INSERT INTO `roles_menus` VALUES ('18', '2');
INSERT INTO `roles_menus` VALUES ('19', '2');
INSERT INTO `roles_menus` VALUES ('21', '2');
INSERT INTO `roles_menus` VALUES ('23', '2');
INSERT INTO `roles_menus` VALUES ('24', '2');
INSERT INTO `roles_menus` VALUES ('27', '2');
INSERT INTO `roles_menus` VALUES ('28', '2');
INSERT INTO `roles_menus` VALUES ('30', '2');
INSERT INTO `roles_menus` VALUES ('33', '2');
INSERT INTO `roles_menus` VALUES ('34', '2');
INSERT INTO `roles_menus` VALUES ('35', '2');
INSERT INTO `roles_menus` VALUES ('36', '2');
INSERT INTO `roles_menus` VALUES ('37', '2');
INSERT INTO `roles_menus` VALUES ('38', '2');
INSERT INTO `roles_menus` VALUES ('39', '2');
INSERT INTO `roles_menus` VALUES ('44', '2');
INSERT INTO `roles_menus` VALUES ('48', '2');
INSERT INTO `roles_menus` VALUES ('49', '2');
INSERT INTO `roles_menus` VALUES ('50', '2');
INSERT INTO `roles_menus` VALUES ('77', '2');
INSERT INTO `roles_menus` VALUES ('78', '2');
INSERT INTO `roles_menus` VALUES ('79', '2');
INSERT INTO `roles_menus` VALUES ('121', '2');

-- ----------------------------
-- Table structure for sys_sku
-- ----------------------------
DROP TABLE IF EXISTS `sys_sku`;
CREATE TABLE `sys_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增长字段',
  `keywords` varchar(50) DEFAULT NULL COMMENT 'uuid生成关联序列',
  `code` varchar(255) DEFAULT NULL COMMENT '商品编号',
  `mnemonic_code` varchar(255) DEFAULT NULL COMMENT '助记码',
  `pinyin` varchar(255) DEFAULT NULL COMMENT '拼音码',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `color` varchar(255) DEFAULT NULL COMMENT '商品颜色',
  `full_name` varchar(255) NOT NULL COMMENT '商品全称',
  `classify_id` bigint(255) DEFAULT NULL COMMENT '商品分类',
  `stock_age` int(11) DEFAULT NULL COMMENT '库龄',
  `cost_flag` bit(1) DEFAULT NULL COMMENT '成本计价方式',
  `serial_info` varchar(255) DEFAULT NULL COMMENT '串号规则',
  `basic_id` bigint(255) DEFAULT NULL,
  `vir_flag` bit(1) DEFAULT NULL COMMENT '虚拟商品',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`),
  KEY `FK_SkuLinkSkuClassify` (`classify_id`) USING BTREE,
  CONSTRAINT `FKm17jqcmj9isalej985cc7lr5o` FOREIGN KEY (`classify_id`) REFERENCES `sys_sku_classify` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='sku商品明细表';

-- ----------------------------
-- Records of sys_sku
-- ----------------------------
INSERT INTO `sys_sku` VALUES ('1', '123-4535', '000001', '12345', 'xm8', '小米', '小米8', '黑色', '小米8黑色', '29', '30', '', '13', null, '\0', '', '1', 'test', '\0', '0', '2020-04-12 22:29:55', '2020-04-12 14:41:15', '10000', null);
INSERT INTO `sys_sku` VALUES ('2', '123-4535', '000002', '12341', 'xm10', '小米', '小米10', '黑色', '小米10黑色', '28', '30', '\0', '13', null, '', '', '1', 'test', '\0', '0', '2020-04-12 22:19:58', '2020-04-12 14:41:15', '10000', null);
INSERT INTO `sys_sku` VALUES ('3', '26ab26e2860047c39de6dbd56c15148f', '11111', '2', null, '华为', '5', '红色', '小米平板电脑 ', '31', '0', '\0', '', null, '\0', '', '999', '7777', '\0', '0', '2020-04-24 23:52:40', '2020-04-13 10:34:23', '10000', null);

-- ----------------------------
-- Table structure for sys_sku_classify
-- ----------------------------
DROP TABLE IF EXISTS `sys_sku_classify`;
CREATE TABLE `sys_sku_classify` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `full_name` varchar(255) DEFAULT NULL COMMENT '分类全称',
  `pid` bigint(20) NOT NULL COMMENT '上级类目',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `keywords` varchar(45) DEFAULT '' COMMENT 'uuid',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) DEFAULT NULL COMMENT '系统注释',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部门';

-- ----------------------------
-- Records of sys_sku_classify
-- ----------------------------
INSERT INTO `sys_sku_classify` VALUES ('1', '商品分类', '商品分类.', '0', '', '分类测试', '1122aksdjfasjkfhsdf', '\0', '9', '2020-04-10 18:00:21', '2020-04-09 20:33:40', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('28', '智能设备', '商品分类.智能设备.', '1', '', null, '3e4020bdc6c9434ab2de7e6b755b64ca', '\0', '20', '2020-04-11 22:26:56', '2020-04-09 20:36:11', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('29', '智能机', '商品分类.智能设备.智能机.', '28', '', null, '37bfdab7e0694df99674ee3b5e00eee4', '\0', '3', '2020-04-13 09:55:23', '2020-04-09 20:41:03', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('30', '老人机', '商品分类.智能设备.老人机.', '28', '', 'tt3', 'd69b131fa32d46269190d07e1925909d', '\0', '7', '2020-04-11 22:26:56', '2020-04-09 21:52:17', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('31', '平板机', '商品分类.智能设备.平板机.', '28', '', null, '6c5e0afb3fee4123953d385b5a0d578c', '\0', '2', '2020-04-11 22:26:56', '2020-04-09 22:09:00', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('32', '二合一', '商品分类.智能设备.二合一.', '28', '', null, 'a51d1c0bd001460e9be8d9eba70ed4a7', '', '1', '2020-04-11 22:26:56', '2020-04-09 22:28:30', '10000', null);
INSERT INTO `sys_sku_classify` VALUES ('33', '智能手表', '商品分类.智能设备..智能手表.', '28', '', null, 'c2b49cf7b35d400fbd8402d81344e157', '', '1', '2020-04-11 22:26:56', '2020-04-10 10:38:06', '10000', null);

-- ----------------------------
-- Table structure for sys_store
-- ----------------------------
DROP TABLE IF EXISTS `sys_store`;
CREATE TABLE `sys_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `keywords` varchar(45) DEFAULT '' COMMENT 'uuid',
  `name` varchar(255) NOT NULL COMMENT '仓库名称',
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `sort` bigint(20) DEFAULT NULL COMMENT '排序',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_keywords` (`keywords`),
  KEY `FK_StoreLinkDeptInfo` (`dept_id`),
  CONSTRAINT `FK_StoreLinkDeptInfo` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='仓库信息';

-- ----------------------------
-- Records of sys_store
-- ----------------------------
INSERT INTO `sys_store` VALUES ('30', 'f247c7573af14906b179d49631906d36', '东津总仓', '', '1', '2', '放原子弹的仓库', '\0', '21', '2020-04-09 09:41:46', '2020-04-06 16:50:33', '10000', null);
INSERT INTO `sys_store` VALUES ('33', '36e7b2b46a424d828401ff4c14503a1f', 'ttt', '\0', '999', '11', 'ee', '', '6', '2020-04-08 22:06:16', '2020-04-07 22:17:37', '10000', null);
INSERT INTO `sys_store` VALUES ('34', '13c7f00d3f294f37b9c2a534d29dc111', '王河二仓', '', '1', '2', '3333', '\0', '7', '2020-04-09 09:41:57', '2020-04-07 23:01:20', '10000', null);
INSERT INTO `sys_store` VALUES ('35', '9e0c7a6fac3c4116a340c73bd0d06e66', '七里湾仓', '', '999', '6', '', '\0', '6', '2020-04-09 09:42:12', '2020-04-08 12:37:36', '10000', null);
INSERT INTO `sys_store` VALUES ('36', 'd1b744e5f2924671b2f482b7708ce952', 'k', '', '999', '11', '', '', '1', '2020-04-08 23:24:14', '2020-04-08 23:22:42', '10000', null);
INSERT INTO `sys_store` VALUES ('37', 'fe940cb2cfd040ebaf73fb76d6552996', '111', '', '999', '1', '', '', '1', '2020-04-09 10:21:29', '2020-04-09 09:43:55', '10000', null);
INSERT INTO `sys_store` VALUES ('38', 'f3794773a2dc48158f2670bc2331f943', '111', '', '999', '2', '', '', '1', '2020-04-09 10:23:03', '2020-04-09 10:22:42', '10000', null);
INSERT INTO `sys_store` VALUES ('39', '8212812fea8b463a9aaa569e083aafec', '测试一下啥1', '', '999', '2', '', '\0', '4', '2020-04-09 11:34:41', '2020-04-09 10:23:53', '10000', null);
INSERT INTO `sys_store` VALUES ('40', 'ae47d06dc6cc434a97dbbbe1d7fe724d', 'tttt', '', '44', '2', '', '\0', '0', '2020-04-24 15:26:30', '2020-04-24 15:26:30', '10000', null);

-- ----------------------------
-- Table structure for sys_trader
-- ----------------------------
DROP TABLE IF EXISTS `sys_trader`;
CREATE TABLE `sys_trader` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `keywords` varchar(45) DEFAULT NULL COMMENT 'uuid',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `saler_flag` bit(1) DEFAULT NULL COMMENT '供应商',
  `buyer_flag` bit(1) DEFAULT NULL COMMENT '客户',
  `period` smallint(6) DEFAULT NULL COMMENT '帐期',
  `credit_amout` int(11) DEFAULT NULL COMMENT '信用额度',
  `contacter` varchar(255) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `bank_name` varchar(255) DEFAULT NULL COMMENT '银行名称',
  `bank_accout` varchar(255) DEFAULT NULL COMMENT '银行帐户',
  `enabled` bit(1) DEFAULT NULL COMMENT '启用状态',
  `remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `is_delete` bit(1) DEFAULT NULL COMMENT '删除标记',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `top_company_code` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '企业代码',
  `notes` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '系统注释，不参与程序制作',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='贸易商-往来单位';

-- ----------------------------
-- Records of sys_trader
-- ----------------------------
INSERT INTO `sys_trader` VALUES ('1', '111111111', '王晓陆', '', '\0', '60', '10000', '王老师', '15272080011', '西湖国际2楼', '中国银行', '4367421541237019503', '', '请及时维护', '\0', '0', '2020-04-16 14:42:45', '2020-04-16 11:54:17', '10000', null);
INSERT INTO `sys_trader` VALUES ('2', 'eb7e3c69608d4c24810628db85f15d0a', '456 测试', '', '', '0', '100', '1', '2', '1', '1', '1', '', '1', '\0', '12', '2020-04-18 19:32:24', '2020-04-16 11:54:17', '10000', null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL COMMENT '状态',
  `sort` bigint(20) NOT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='test';

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '中国银行', '', '2', '2020-02-21 12:17:25');
INSERT INTO `test` VALUES ('3', '赤壁农商', '', '3', '2020-03-24 15:35:47');
INSERT INTO `test` VALUES ('7', '678', '', '999', '2020-03-24 17:18:29');
INSERT INTO `test` VALUES ('8', '777', '', '999', '2020-03-24 17:28:04');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `avatar_id` bigint(20) DEFAULT NULL COMMENT '头像',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `enabled` bigint(20) DEFAULT NULL COMMENT '状态：1启用、0禁用',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门名称',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `job_id` bigint(20) DEFAULT NULL COMMENT '岗位名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `last_password_reset_time` datetime DEFAULT NULL COMMENT '最后修改密码的日期',
  `nick_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `top_company_code` varchar(10) DEFAULT NULL COMMENT '企业帐套公司代码',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK5rwmryny6jthaaxkogownknqp` (`dept_id`) USING BTREE,
  KEY `FKfftoc2abhot8f2wu6cl9a5iky` (`job_id`) USING BTREE,
  KEY `FKpq2dhypk2qgt68nauh2by22jb` (`avatar_id`) USING BTREE,
  CONSTRAINT `FK5rwmryny6jthaaxkogownknqp` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`),
  CONSTRAINT `FKfftoc2abhot8f2wu6cl9a5iky` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKpq2dhypk2qgt68nauh2by22jb` FOREIGN KEY (`avatar_id`) REFERENCES `user_avatar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '56524932@163.com', '1', '$2a$10$fP.426qKaTmix50Oln8L.uav55gELhAd0Eg66Av4oG86u8km7D/Ky', 'admin', '2', '18888888888', '11', '2018-08-23 09:11:56', '2019-05-18 17:34:21', '管理员', '男', '10000');
INSERT INTO `user` VALUES ('3', null, 'test@eladmin.net', '0', '$2a$10$HhxyGZy.ulf3RvAwaHUGb.k.2i9PBpv4YbLMJWp8pES7pPhTyRCF.', 'test', '2', '17777777777', '12', '2018-12-27 20:05:26', '2019-04-01 09:15:24', '测试', '男', '10000');
INSERT INTO `user` VALUES ('4', null, 'wxl_954136@163.com', '1', '$2a$10$BXhXVQ6Ll6ESl7/NvAC3qe/RI/W3m.udr5Gscw8S1ch2n/CVtdv0i', 'luke', '2', '15272080011', '10', '2020-03-23 15:26:24', '2019-04-01 09:15:24', '王晓陆', '男', '10000');

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE,
  KEY `FKq4eq273l04bpu4efj0jd0jb98` (`role_id`) USING BTREE,
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关联';

-- ----------------------------
-- Records of users_roles
-- ----------------------------
INSERT INTO `users_roles` VALUES ('1', '1');
INSERT INTO `users_roles` VALUES ('3', '2');
INSERT INTO `users_roles` VALUES ('4', '2');

-- ----------------------------
-- Table structure for user_avatar
-- ----------------------------
DROP TABLE IF EXISTS `user_avatar`;
CREATE TABLE `user_avatar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(255) DEFAULT NULL COMMENT '真实文件名',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `size` varchar(255) DEFAULT NULL COMMENT '大小',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='系统用户头像';

-- ----------------------------
-- Records of user_avatar
-- ----------------------------

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `code` varchar(255) DEFAULT NULL COMMENT '验证码',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `status` bit(1) DEFAULT NULL COMMENT '状态：1有效、0过期',
  `type` varchar(255) DEFAULT NULL COMMENT '验证码类型：email或者短信',
  `value` varchar(255) DEFAULT NULL COMMENT '接收邮箱或者手机号码',
  `scenes` varchar(255) DEFAULT NULL COMMENT '业务名称：如重置邮箱、重置密码等',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='验证码';

-- ----------------------------
-- Records of verification_code
-- ----------------------------

-- ----------------------------
-- Table structure for visits
-- ----------------------------
DROP TABLE IF EXISTS `visits`;
CREATE TABLE `visits` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `ip_counts` bigint(20) DEFAULT NULL,
  `pv_counts` bigint(20) DEFAULT NULL,
  `week_day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_11aksgq87euk9bcyeesfs4vtp` (`date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='访客记录';

-- ----------------------------
-- Records of visits
-- ----------------------------

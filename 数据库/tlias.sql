/*
Navicat MySQL Data Transfer

Source Server         : ssm
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : tlias

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2024-02-07 16:43:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) NOT NULL COMMENT '部门名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '华山派', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `dept` VALUES ('2', '丐帮', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `dept` VALUES ('3', '少林寺', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `dept` VALUES ('4', '武当派', '2024-02-02 10:28:49', '2024-02-08 10:28:44');
INSERT INTO `dept` VALUES ('5', '日月神教', '2024-02-07 10:29:05', '2024-02-07 10:29:08');
INSERT INTO `dept` VALUES ('6', '恒山派', '2024-02-15 10:29:23', '2024-02-21 10:29:25');
INSERT INTO `dept` VALUES ('7', '衡山派', '2024-02-15 10:29:38', '2024-03-06 10:29:40');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` tinyint(3) unsigned NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) DEFAULT NULL COMMENT '图像',
  `job` tinyint(3) unsigned DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
  `entrydate` date DEFAULT NULL COMMENT '入职时间',
  `deptId` int(10) unsigned DEFAULT NULL COMMENT '部门ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='员工表';

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'jinyong', '123456', '令狐冲', '1', '1.jpg', '4', '2000-01-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('2', 'zhangwuji', '123456', '任盈盈', '1', '2.jpg', '2', '2015-01-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('3', 'yangxiao', '123456', '任我行', '1', '3.jpg', '2', '2008-05-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('4', 'weiyixiao', '123456', '岳不群', '1', '4.jpg', '2', '2007-01-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('5', 'changyuchun', '123456', '林平之', '1', '5.jpg', '2', '2012-12-05', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('6', 'xiaozhao', '123456', '仪琳', '2', '6.jpg', '3', '2013-09-05', '1', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('7', 'jixiaofu', '123456', '东方不败', '2', '7.jpg', '1', '2005-08-01', '1', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('8', 'zhouzhiruo', '123456', '绿竹翁', '2', '8.jpg', '1', '2014-11-09', '1', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('9', 'dingminjun', '123456', '桃谷六仙', '2', '9.jpg', '1', '2011-03-11', '1', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('10', 'zhaomin', '123456', '方证大师', '2', '10.jpg', '1', '2013-09-05', '1', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('11', 'luzhangke', '123456', '冲虚道长', '1', '11.jpg', '5', '2007-02-01', '3', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('12', 'hebiweng', '123456', '蓝凤凰', '1', '12.jpg', '5', '2008-08-18', '3', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('13', 'fangdongbai', '123456', '田伯光', '1', '13.jpg', '5', '2012-11-01', '3', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('14', 'zhangsanfeng', '123456', '左冷禅', '1', '14.jpg', '2', '2002-08-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('15', 'yulianzhou', '123456', '宁中则', '1', '15.jpg', '2', '2011-05-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('16', 'songyuanqiao', '123456', '岳灵珊', '1', '16.jpg', '2', '2007-01-01', '2', '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('17', 'chenyouliang', '123456', '向问天', '1', '17.jpg', null, '2015-03-21', null, '2024-02-06 15:23:54', '2024-02-06 15:23:54');
INSERT INTO `emp` VALUES ('18', '1', '123456', '1', '1', null, '1', null, '1', null, null);
INSERT INTO `emp` VALUES ('20', 'zhangsan', null, '张三', '1', null, '1', null, '1', null, null);
INSERT INTO `emp` VALUES ('22', 'lisi', null, '李四', '1', null, '1', null, '1', null, null);
INSERT INTO `emp` VALUES ('23', 'wangwu', null, '王五', '1', null, '1', null, '1', null, null);

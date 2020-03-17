/*
Navicat MySQL Data Transfer

Source Server         : cloudstack
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : icloud

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-03-17 12:04:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_title` varchar(15) DEFAULT NULL COMMENT '菜单标题',
  `menu_icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `menu_href` varchar(100) DEFAULT NULL COMMENT '跳转链接',
  `menu_seq` int(11) NOT NULL COMMENT '菜单序号',
  PRIMARY KEY (`menu_id`),
  KEY `menu_seq` (`menu_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '模板', 'layui-icon layui-icon-template', '#pages/mb.html', '1');
INSERT INTO `menu` VALUES ('2', '虚拟机', 'layui-icon layui-icon-chart-screen', '#pages/vm.html', '2');
INSERT INTO `menu` VALUES ('3', 'ISO', 'layui-icon layui-icon-flag', '#pages/iso.html', '3');
INSERT INTO `menu` VALUES ('4', '软件中心', 'layui-icon layui-icon-app', '#pages/softcenter.html', '4');
INSERT INTO `menu` VALUES ('5', '控制板', 'layui-icon layui-icon-console', '#pages/control.html', '5');
INSERT INTO `menu` VALUES ('6', '事件', 'layui-icon layui-icon-search', '#pages/events.html', '6');
INSERT INTO `menu` VALUES ('7', 'IP管理', 'layui-icon layui-icon-website', '#pages/ip.html', '7');
INSERT INTO `menu` VALUES ('8', '机房管理', 'layui-icon layui-icon-engine', '#pages/computerRoom.html', '8');
INSERT INTO `menu` VALUES ('9', '定时任务', 'layui-icon layui-icon-log', '#pages/schedules.html', '9');
INSERT INTO `menu` VALUES ('10', '账户管理', 'layui-icon layui-icon-user', '#pages/users.html', '10');
INSERT INTO `menu` VALUES ('11', '资源预约', 'layui-icon layui-icon-senior', '#pages/yy.html', '11');
INSERT INTO `menu` VALUES ('12', '上机安排', 'layui-icon layui-icon-date', '#pages/anpai.html', '12');
INSERT INTO `menu` VALUES ('13', '制作模板', 'layui-icon layui-icon-templeate-1', '#pages/t_mb.html', '13');
INSERT INTO `menu` VALUES ('14', '所有模板', 'layui-icon layui-icon-template-1', '#pages/t_all_mb.html', '14');
INSERT INTO `menu` VALUES ('15', '软件管理', 'layui-icon layui-icon-cols', '#pages/t_softcenter.html', '15');
INSERT INTO `menu` VALUES ('16', '进行实验', 'layui-icon layui-icon-chart-screen', '#pages/users.html', '16');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名',
  `role_num` int(3) DEFAULT NULL COMMENT '角色号码',
  `is_fold` int(1) DEFAULT '0' COMMENT '该角色菜单是否可折叠',
  `permission` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `role_num` (`role_num`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '1', '0', 'root');
INSERT INTO `role` VALUES ('2', '教师', '2', '1', 'teacher');
INSERT INTO `role` VALUES ('3', '学生', '3', '1', 'student');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`),
  KEY `fk_role_id` (`role_id`),
  KEY `fk_menu_id` (`menu_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_seq`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '2', '1');
INSERT INTO `role_menu` VALUES ('3', '3', '1');
INSERT INTO `role_menu` VALUES ('4', '4', '1');
INSERT INTO `role_menu` VALUES ('5', '5', '1');
INSERT INTO `role_menu` VALUES ('6', '6', '1');
INSERT INTO `role_menu` VALUES ('7', '7', '1');
INSERT INTO `role_menu` VALUES ('8', '8', '1');
INSERT INTO `role_menu` VALUES ('9', '9', '1');
INSERT INTO `role_menu` VALUES ('10', '10', '1');
INSERT INTO `role_menu` VALUES ('11', '11', '2');
INSERT INTO `role_menu` VALUES ('12', '12', '2');
INSERT INTO `role_menu` VALUES ('13', '13', '2');
INSERT INTO `role_menu` VALUES ('14', '14', '2');
INSERT INTO `role_menu` VALUES ('15', '15', '2');
INSERT INTO `role_menu` VALUES ('16', '12', '3');
INSERT INTO `role_menu` VALUES ('17', '16', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `role` int(1) DEFAULT '3' COMMENT '1:管理员；2:教师；3:学生。默认3',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(100) DEFAULT NULL COMMENT '微信',
  `enable` int(1) DEFAULT '1' COMMENT '是否可用（1：启用；0：禁用）',
  PRIMARY KEY (`user_id`),
  KEY `fk_role` (`role`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`role_num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '1', null, 'flemmingcoder@outlook.com', null, '1');

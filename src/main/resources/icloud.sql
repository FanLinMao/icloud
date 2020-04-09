/*
Navicat MySQL Data Transfer

Source Server         : cloudstack
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : icloud

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-04-10 02:52:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for arrange
-- ----------------------------
DROP TABLE IF EXISTS `arrange`;
CREATE TABLE `arrange` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` varchar(150) NOT NULL COMMENT '事件id',
  `college` varchar(20) DEFAULT NULL COMMENT '学院',
  `clazz` varchar(20) DEFAULT NULL COMMENT '班级',
  `date` varchar(100) DEFAULT NULL COMMENT '上机时间',
  `address` varchar(150) DEFAULT NULL COMMENT '上机地址',
  `teacher` varchar(10) DEFAULT NULL COMMENT '任课教师',
  `course` varchar(50) DEFAULT NULL COMMENT '课程',
  `template` varchar(50) DEFAULT NULL COMMENT '使用模板',
  PRIMARY KEY (`id`),
  KEY `index_arrange_event_id` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of arrange
-- ----------------------------
INSERT INTO `arrange` VALUES ('1', '73e556cf-57f4-4d3c-a7bc-3d4615d11b27', '软件工程学院', '165', '2020-03-29T14:00:00--17:30:00', 'H510', 'test', 'Java程序设计', 'windows');
INSERT INTO `arrange` VALUES ('3', '06cae5a1-4a99-4c00-a92e-8e21d1880af9', '软件工程学院', '165', '2020-03-29T12:00:00--13:00:00', 'H507', '刘魁', '计算机组成原理', 'windows');

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
  `enable` int(255) DEFAULT '1' COMMENT '菜单是否可用',
  PRIMARY KEY (`role_menu_id`),
  KEY `fk_role_id` (`role_id`),
  KEY `fk_menu_id` (`menu_id`),
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_seq`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '1', '1', '1');
INSERT INTO `role_menu` VALUES ('2', '2', '1', '1');
INSERT INTO `role_menu` VALUES ('3', '3', '1', '1');
INSERT INTO `role_menu` VALUES ('4', '4', '1', '1');
INSERT INTO `role_menu` VALUES ('5', '5', '1', '1');
INSERT INTO `role_menu` VALUES ('6', '6', '1', '1');
INSERT INTO `role_menu` VALUES ('7', '7', '1', '1');
INSERT INTO `role_menu` VALUES ('8', '8', '1', '1');
INSERT INTO `role_menu` VALUES ('9', '9', '1', '1');
INSERT INTO `role_menu` VALUES ('10', '10', '1', '1');
INSERT INTO `role_menu` VALUES ('11', '11', '2', '1');
INSERT INTO `role_menu` VALUES ('12', '12', '2', '1');
INSERT INTO `role_menu` VALUES ('13', '13', '2', '1');
INSERT INTO `role_menu` VALUES ('14', '14', '2', '1');
INSERT INTO `role_menu` VALUES ('15', '15', '2', '1');
INSERT INTO `role_menu` VALUES ('16', '12', '3', '1');
INSERT INTO `role_menu` VALUES ('17', '16', '3', '1');

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
  KEY `index_role` (`role`) USING BTREE,
  CONSTRAINT `fk_role` FOREIGN KEY (`role`) REFERENCES `role` (`role_num`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '1', null, 'flemmingcoder@outlook.com', null, '1');
INSERT INTO `sys_user` VALUES ('8', 'test', 'E10ADC3949BA59ABBE56E057F20F883E', '2', null, null, null, '1');
INSERT INTO `sys_user` VALUES ('9', 'student', 'E10ADC3949BA59ABBE56E057F20F883E', '3', null, null, null, '1');

-- ----------------------------
-- Table structure for t_event
-- ----------------------------
DROP TABLE IF EXISTS `t_event`;
CREATE TABLE `t_event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `event_id` varchar(255) NOT NULL COMMENT '事件ID，UUID类型',
  `groupId` varchar(255) DEFAULT NULL COMMENT '组ID，设置相同的id可以一起做修改、拖动',
  `is_allDay` char(1) DEFAULT NULL COMMENT '是否是全天事件，"Y"和"N" ',
  `startTime` varchar(255) DEFAULT NULL COMMENT '事件开始时间',
  `endTime` varchar(255) DEFAULT NULL COMMENT '事件结束事件',
  `title` varchar(255) NOT NULL COMMENT '事件名称',
  `url` varchar(255) DEFAULT NULL COMMENT '点击事件跳转到该url',
  `classNames` varchar(255) DEFAULT NULL COMMENT '将HTML类附件到此事件上',
  `editable` char(1) DEFAULT NULL COMMENT '该事件是否可以编辑',
  `startEditable` char(1) DEFAULT NULL COMMENT '该值覆盖特定事件的eentStartEditable',
  `durationEditable` char(1) DEFAULT NULL COMMENT '该值覆盖特定事件的eentStartEditable',
  `resourceEditable` char(1) DEFAULT NULL COMMENT '该值覆盖特定事件的eentStartEditable',
  `rendering` varchar(255) DEFAULT NULL COMMENT '事件呈现的类型，"background", or "inverse-background"',
  `overlap` char(1) DEFAULT NULL COMMENT '该值覆盖特定事件的eentStartEditable',
  `constraint` varchar(255) DEFAULT NULL COMMENT 'eventConstraint的重写',
  `backgroundColor` varchar(255) DEFAULT NULL COMMENT 'eventBackgroundColor的重写',
  `borderColor` varchar(255) DEFAULT NULL COMMENT 'eventBorderColor的重写',
  `textColor` varchar(255) DEFAULT NULL COMMENT 'eventTextColor的重写',
  `extendedProps` varchar(255) DEFAULT NULL COMMENT '指定其他杂项属性的普通对象',
  `source` varchar(255) DEFAULT NULL COMMENT '对事件源的引用',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`),
  KEY `fk_event_user_id` (`user_id`),
  CONSTRAINT `fk_event_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_event
-- ----------------------------
INSERT INTO `t_event` VALUES ('1', '73e556cf-57f4-4d3c-a7bc-3d4615d11b27', null, null, '2020-03-27T00:00:00', '2020-03-28T00:00:00', 'conference', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '8');
INSERT INTO `t_event` VALUES ('2', '06cae5a1-4a99-4c00-a92e-8e21d1880af9', null, null, '2020-03-29T12:00:00', '2020-03-29T13:00:00', '上机', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '8');

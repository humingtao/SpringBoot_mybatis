/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 20/04/2020 16:55:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `ID` int(11) NOT NULL COMMENT '编号',
  `UID` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `MONEY` double NULL DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `FK_Reference_8`(`UID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 41, 1000);
INSERT INTO `account` VALUES (2, 45, 1000);
INSERT INTO `account` VALUES (3, 41, 2000);

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `countrycode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '中国', 'CN');
INSERT INTO `country` VALUES (2, '美国', 'US');
INSERT INTO `country` VALUES (3, '俄罗斯', 'RU');
INSERT INTO `country` VALUES (4, '英国', 'GB');
INSERT INTO `country` VALUES (5, '法国', 'FR');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `ID` int(11) NOT NULL COMMENT '编号',
  `ROLE_NAME` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '院长', '管理整个学院');
INSERT INTO `role` VALUES (2, '总裁', '管理整个公司');
INSERT INTO `role` VALUES (3, '校长', '管理整个学校');

-- ----------------------------
-- Table structure for sp_permission
-- ----------------------------
DROP TABLE IF EXISTS `sp_permission`;
CREATE TABLE `sp_permission`  (
  `ps_id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ps_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `ps_pid` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父id',
  `ps_c` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '控制器',
  `ps_a` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '操作方法',
  `ps_level` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '权限等级',
  PRIMARY KEY (`ps_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sp_permission
-- ----------------------------
INSERT INTO `sp_permission` VALUES ('110', '用户列表', '125', 'Manager', 'index', '1');
INSERT INTO `sp_permission` VALUES ('111', '角色列表', '103', 'Role', 'index', '1');
INSERT INTO `sp_permission` VALUES ('112', '权限列表', '103', 'Permission', 'index', '1');
INSERT INTO `sp_permission` VALUES ('125', '用户管理', '0', '', '', '0');
INSERT INTO `sp_permission` VALUES ('129', '添加角色', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('130', '删除角色', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('131', '添加用户', '110', '', '', '2');
INSERT INTO `sp_permission` VALUES ('132', '删除用户', '110', '', '', '2');
INSERT INTO `sp_permission` VALUES ('133', '更新用户', '110', '', '', '2');
INSERT INTO `sp_permission` VALUES ('134', '角色授权', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('135', '取消角色授权', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('136', '获取用户详情', '110', '', '', '2');
INSERT INTO `sp_permission` VALUES ('137', '分配用户角色', '110', '', '', '2');
INSERT INTO `sp_permission` VALUES ('138', '获取角色列表', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('139', '获取角色详情', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('140', '更新角色信息', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('141', '更新角色权限', '111', '', '', '2');
INSERT INTO `sp_permission` VALUES ('147', '查看权限', '112', '', '', '2');
INSERT INTO `sp_permission` VALUES ('148', '查看数据', '146', '', '', '2');
INSERT INTO `sp_permission` VALUES ('149', '获取分类详情', '121', '', '', '2');
INSERT INTO `sp_permission` VALUES ('159', '设置管理状态', '110', '', '', '2');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES (1, '用户管理', '/users');
INSERT INTO `sys_privilege` VALUES (2, '角色管理', '/roles');
INSERT INTO `sys_privilege` VALUES (3, '系统日志', '/logs');
INSERT INTO `sys_privilege` VALUES (4, '人员维护', '/persons');
INSERT INTO `sys_privilege` VALUES (5, '单位维护', '/companies');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `enabled` int(11) NULL DEFAULT NULL COMMENT '有效标志',
  `create_by` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', 1, 1, '2016-04-01 17:02:14');
INSERT INTO `sys_role` VALUES (2, '普通用户', 1, 1, '2016-04-01 17:02:34');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege`  (
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) NULL DEFAULT NULL COMMENT '权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES (1, 1);
INSERT INTO `sys_role_privilege` VALUES (1, 3);
INSERT INTO `sys_role_privilege` VALUES (1, 2);
INSERT INTO `sys_role_privilege` VALUES (2, 4);
INSERT INTO `sys_role_privilege` VALUES (2, 5);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'test@mybatis.tk' COMMENT '邮箱',
  `user_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `head_img` blob NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3d78852073b811ea8522e86a643a3494', 'ceshi1', '111111', '454@qq.com', '测试', NULL, '2020-04-01 09:29:29');
INSERT INTO `sys_user` VALUES ('b6023caf6dd111ea9663e86a643a3494', '胡明涛', '123456', 'hmt@qq.com', 'ada', NULL, '2020-03-15 15:41:21');
INSERT INTO `sys_user` VALUES ('c46d3ae56dd111ea9663e86a643a3454', 'test', '123456', 'test@mybatis.tk', '测试用户', 0x1231231230, '2016-06-07 00:00:00');
INSERT INTO `sys_user` VALUES ('c46d3ae56dd111ea9663e86a643a3492', 'admin', '123456', 'admin@mybatis.tk', '管理员用户', 0x1231231230, '2020-03-15 15:41:21');
INSERT INTO `sys_user` VALUES ('ea838e7b73c411ea8522e86a643a3494', 'ceshi2', 'ceshi2', '454@qq.com', '23', NULL, '2020-04-01 11:00:13');
INSERT INTO `sys_user` VALUES ('feab7bd570ff11ea9663e86a643a3494', 'humingtao', '123456', '454@qq.com', '我爱你', NULL, '2020-03-28 22:25:19');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (1, 2);
INSERT INTO `sys_user_role` VALUES (1001, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `is_active` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '是否激活',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 203 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '老王', '2020-03-26 15:38:56', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (4, '小二王', '2018-03-20 15:09:37', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '0');
INSERT INTO `user` VALUES (5, '小二王', '2018-03-04 11:34:34', '女', '朝阳区小红门乡龙爪树村甲10号', '1');
INSERT INTO `user` VALUES (6, '张三', '2018-03-04 12:04:06', '男', '榆河法庭、刑一庭、刑二庭 办公地址:北京市朝阳区金盏乡楼梓庄村原乡政府办公楼', '0');
INSERT INTO `user` VALUES (7, '老王', '2020-03-25 14:13:43', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (8, '小马宝莉', '2018-03-08 11:44:00', '女', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (12, 'username', '2020-03-15 15:41:00', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (191, 'username', '2020-03-15 15:41:21', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '0');
INSERT INTO `user` VALUES (192, 'username', '2020-03-15 15:42:33', '男', '榆河法庭、刑一庭、刑二庭 办公地址:北京市朝阳区金盏乡楼梓庄村原乡政府办公楼', '1');
INSERT INTO `user` VALUES (194, '胡明涛', '2020-03-15 15:46:21', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (200, '胡明涛1', '2020-03-26 15:51:10', '男', '北京市朝阳区朝阳公园南路甲2号朝阳法院', '1');
INSERT INTO `user` VALUES (202, 'username', '2020-03-29 20:28:47', '男', '北京市', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`UID`, `RID`) USING BTREE,
  INDEX `FK_Reference_10`(`RID`) USING BTREE,
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `role` (`ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (41, 1);
INSERT INTO `user_role` VALUES (45, 1);
INSERT INTO `user_role` VALUES (41, 2);

SET FOREIGN_KEY_CHECKS = 1;

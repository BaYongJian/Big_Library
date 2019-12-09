/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50558
 Source Host           : localhost:3306
 Source Schema         : library_database

 Target Server Type    : MySQL
 Target Server Version : 50558
 File Encoding         : 65001

 Date: 09/12/2019 16:33:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键，书籍名称',
  `book_writer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '未知作者' COMMENT '书籍作者',
  `book_total` int(10) NULL DEFAULT NULL COMMENT '书籍总数',
  `book_remaining` int(10) NULL DEFAULT NULL COMMENT '书籍剩余数',
  PRIMARY KEY (`book_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('ARM嵌入式系统开发：软件设计与优化', 'Andrew Sloss et al', 980, 978);
INSERT INTO `book` VALUES ('C Primer Plus', 'Stephen Prata', 740, 740);
INSERT INTO `book` VALUES ('C语言入门经典', 'vor Horton', 500, 499);
INSERT INTO `book` VALUES ('Effective Java', 'Joshua Bloch', 899, 897);
INSERT INTO `book` VALUES ('Java从入门到精通', '明日科技', 400, 398);
INSERT INTO `book` VALUES ('Java核心技术', 'Cay S. Horstmann', 780, 779);
INSERT INTO `book` VALUES ('Java编程思想', 'Bruce Eckel', 800, 799);
INSERT INTO `book` VALUES ('Linux程序设计', 'Neil Matthew', 770, 769);
INSERT INTO `book` VALUES ('Linux设备驱动程序', 'Cobot', 750, 750);
INSERT INTO `book` VALUES ('Unity3D网络游戏实战', '罗培羽', 300, 299);
INSERT INTO `book` VALUES ('Unity游戏开发入门经典', 'Mike Geig', 678, 678);
INSERT INTO `book` VALUES ('UNIX环境高级编程', 'W.Richard Stevens', 750, 750);
INSERT INTO `book` VALUES ('浪潮之巅', '吴军', 235, 235);
INSERT INTO `book` VALUES ('深入理解Java虚拟机', '周志明', 403, 403);
INSERT INTO `book` VALUES ('游戏编程模式', 'Robert Nystrom', 500, 500);
INSERT INTO `book` VALUES ('游戏设计、原型与开发', 'Jeremy Gibson', 600, 600);
INSERT INTO `book` VALUES ('第一行代码', '郭霖', 123, 123);
INSERT INTO `book` VALUES ('算法', 'Robert Sedgewick', 1500, 1500);
INSERT INTO `book` VALUES ('算法导论', ' Thomas H.Cormen', 1200, 1200);
INSERT INTO `book` VALUES ('编译原理', 'Alfred V. Aho', 980, 980);
INSERT INTO `book` VALUES ('计算机网络-自顶向下方法', 'James E Kurse', 677, 677);
INSERT INTO `book` VALUES ('计算机网络教程', '谢钧', 599, 599);
INSERT INTO `book` VALUES ('高性能MySQL', 'Baron Schwartz', 750, 750);
INSERT INTO `book` VALUES ('鸟哥的Linux私房菜', '鸟哥', 770, 770);

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow`  (
  `borrow_user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '外键(user表)、借书账号',
  `borrow_book_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '外键(book表)、借书名',
  `borrow_book_time` date NULL DEFAULT NULL COMMENT '借书时间',
  `return_book_time` date NULL DEFAULT NULL COMMENT '应还书时间',
  INDEX `borrow_book_name`(`borrow_book_name`) USING BTREE,
  INDEX `borrow_user_name`(`borrow_user_name`) USING BTREE,
  CONSTRAINT `borrow_ibfk_2` FOREIGN KEY (`borrow_book_name`) REFERENCES `book` (`book_name`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `borrow_ibfk_3` FOREIGN KEY (`borrow_user_name`) REFERENCES `user` (`user_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Effective Java', '2019-12-07', '2019-12-22');
INSERT INTO `borrow` VALUES ('user3@vip.com', 'Java从入门到精通', '2019-10-28', '2019-11-12');
INSERT INTO `borrow` VALUES ('user4@vip.com', 'Effective Java', '2019-11-01', '2019-11-15');
INSERT INTO `borrow` VALUES ('user4@vip.com', 'ARM嵌入式系统开发：软件设计与优化', '2019-12-07', '2019-12-22');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Java从入门到精通', '2019-12-01', '2019-12-16');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Java核心技术', '2019-12-01', '2019-12-16');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Java编程思想', '2019-12-09', '2019-12-24');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'C语言入门经典', '2019-12-09', '2019-12-24');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Linux程序设计', '2019-12-09', '2019-12-24');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'Unity3D网络游戏实战', '2019-12-09', '2019-12-24');
INSERT INTO `borrow` VALUES ('user1@vip.com', 'ARM嵌入式系统开发：软件设计与优化', '2019-12-09', '2019-12-24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键、账号',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `permission` tinyint(1) NULL DEFAULT 0 COMMENT '权限，默认为0，代表是普通用户',
  `borrow_book` tinyint(1) NULL DEFAULT 0 COMMENT '是否借书未还，默认是0，代表未借书',
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin@vip.com', '123456', 1, 0);
INSERT INTO `user` VALUES ('root@vip.com', '123456', 1, 0);
INSERT INTO `user` VALUES ('user1@vip.com', '123456', 0, 8);
INSERT INTO `user` VALUES ('user2@vip.com', '123456', 0, 0);
INSERT INTO `user` VALUES ('user3@vip.com', '123456', 0, 1);
INSERT INTO `user` VALUES ('user4@vip.com', '123456', 0, 2);

SET FOREIGN_KEY_CHECKS = 1;

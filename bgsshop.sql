/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50170
 Source Host           : localhost:3306
 Source Schema         : bgsshop

 Target Server Type    : MySQL
 Target Server Version : 50170
 File Encoding         : 65001

 Date: 27/02/2022 18:44:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `productId` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `num` int(11) NULL DEFAULT NULL COMMENT '商品数量',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `prices` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品总价格',
  `remarks` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1, 6, 3, 6, 1000.00, 6000.00, '发顺丰快递');
INSERT INTO `cart` VALUES (3, 3, 1, 100, 5.00, 500.00, '\"\"');
INSERT INTO `cart` VALUES (4, 3, 2, 10, 198.00, 1980.00, '');
INSERT INTO `cart` VALUES (11, 3, 4, 10000, 3.00, 30000.00, '');
INSERT INTO `cart` VALUES (17, 8, 5, 5, 300.00, 1500.00, '');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '种类的id号',
  `code` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类的编码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '种类名称',
  `sortorder` int(10) NULL DEFAULT NULL COMMENT '种类序号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '1022', '饮料', 4);
INSERT INTO `category` VALUES (2, '1002', '玩具', 2);
INSERT INTO `category` VALUES (5, '1006', '鸟', 100);
INSERT INTO `category` VALUES (12, '987', '动物', 168);
INSERT INTO `category` VALUES (13, '123', '矿泉水', 1);
INSERT INTO `category` VALUES (14, '7854', '护肤品', 999);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryId` int(11) NULL DEFAULT NULL COMMENT '商品种类的id',
  `code` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的编码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的名称',
  `subtitle` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的副标题',
  `detail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的详细介绍',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品的价格',
  `stock` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品库存',
  `sales` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品的销量',
  `images` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `isCommend` int(1) NULL DEFAULT NULL COMMENT '是否有推荐标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 1, '1022', '饮料', '百事可乐', '这瓶可乐很带劲', 5.00, '10002', '5000', 'bskl.jpg', 1);
INSERT INTO `product` VALUES (2, 2, '1022', '玩具', '小汽车', '电动遥控小汽车', 198.00, '6000', '600', 'ykqc.webp', 1);
INSERT INTO `product` VALUES (3, 5, '1006', '鸟', '鹦鹉', '会说话的鹦鹉', 1000.00, '550', '80', 'yw.jpg', 0);
INSERT INTO `product` VALUES (4, 13, '123', '矿泉水', '农夫山泉', '农夫山泉有点甜', 3.00, '10000', '1000', 'nfsq.jpg', 1);
INSERT INTO `product` VALUES (5, 14, '7854', '洗面奶', '香奈儿洗面奶', '洗得很干净', 300.00, '500', '100', 'xmn.jpg', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `url` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `role` int(3) NULL DEFAULT NULL COMMENT '值为0的时候是买家，值为1的时候是管理员',
  `createtime` datetime NULL DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin0', '123456', '2210183204@qq.com', '17692779155', '河北省沧州市青县', 0, '2022-01-24 14:19:10');
INSERT INTO `user` VALUES (2, 'admin1', '123456', '2215984357@qq.com', '17958449622', '北京市昌平区', 1, '2022-01-24 14:20:18');
INSERT INTO `user` VALUES (3, 'admin', '123456', '2210183204@qq.com', '17692779155', '北京市', 0, '2022-01-27 14:59:04');
INSERT INTO `user` VALUES (4, 'admin', '123456', '2210183204@qq.com', '17692779155', '北京市', 1, '2022-01-27 15:08:34');
INSERT INTO `user` VALUES (5, 'admin3', '123456', '2210183204@qq.com', '17692779155', '北京市', 1, '2022-01-27 15:09:55');
INSERT INTO `user` VALUES (6, 'admin4', '123456', '2210183204@qq.com', '17692779155', '北京市', 0, '2022-01-27 16:09:39');
INSERT INTO `user` VALUES (7, 'wwc', '654321', '2210183204@qq.com', '18330773520', '青县', 0, '2022-01-28 16:56:46');
INSERT INTO `user` VALUES (8, 'wxz', '654321', '2210183204@qq.com', '13785802164', '青县', 0, '2022-02-23 20:11:04');
INSERT INTO `user` VALUES (9, 'wxz', '123456', '2210183204@qq.com', '13785802164', '青县', 1, '2022-02-23 20:14:56');

SET FOREIGN_KEY_CHECKS = 1;

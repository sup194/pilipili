/*
 Navicat Premium Data Transfer

 Source Server         : pilipili
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : online_pilipili

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/09/2020 10:54:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`     char(8)     NOT NULL DEFAULT '' COMMENT 'id',
    `parent` char(8)     NOT NULL DEFAULT '' COMMENT '父id',
    `name`   varchar(50) NOT NULL COMMENT '名称',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '分类';

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`
(
    `id`         char(8)      NOT NULL DEFAULT '' COMMENT 'id',
    `path`       varchar(100) NOT NULL COMMENT '相对路径',
    `name`       varchar(100) NULL     DEFAULT NULL COMMENT '文件名',
    `suffix`     varchar(10)  NULL     DEFAULT NULL COMMENT '后缀',
    `size`       int          NULL     DEFAULT NULL COMMENT '大小|字节B',
    `use`        char(1)      NULL     DEFAULT NULL COMMENT '用途|枚举[FileUseEnum]：STUDY(\"S\", \"学习\"), ENTERTAINMENT(\"E\", \"娱乐\")',
    `created_at` datetime(3)  NULL     DEFAULT NULL COMMENT '创建时间',
    `updated_at` datetime(3)  NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `path_unique` (`path`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '文件';

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`
(
    `id`      char(6)      NOT NULL DEFAULT '' COMMENT 'id',
    `name`    varchar(100) NOT NULL COMMENT '名称|菜单或按钮',
    `page`    varchar(50)  NULL     DEFAULT NULL COMMENT '页面|路由',
    `request` varchar(200) NULL     DEFAULT NULL COMMENT '请求|接口',
    `parent`  char(6)      NULL     DEFAULT NULL COMMENT '父id',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '资源';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`   char(8)      NOT NULL DEFAULT '' COMMENT 'id',
    `name` varchar(50)  NOT NULL COMMENT '角色',
    `desc` varchar(100) NOT NULL COMMENT '描述',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '角色';

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`
(
    `id`          char(8) NOT NULL DEFAULT '' COMMENT 'id',
    `role_id`     char(8) NOT NULL COMMENT '角色|id',
    `resource_id` char(6) NOT NULL COMMENT '资源|id',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '角色资源关联';

-- ----------------------------
-- Table structure for role_user
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user`
(
    `id`      char(8) NOT NULL DEFAULT '' COMMENT 'id',
    `role_id` char(8) NOT NULL COMMENT '角色|id',
    `user_id` char(8) NOT NULL COMMENT '用户|id',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '角色用户关联';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       char(8)      NOT NULL DEFAULT '' COMMENT 'id',
    `email`    varchar(50)  NOT NULL COMMENT '邮箱',
    `name`     varchar(50)  NULL     DEFAULT NULL COMMENT '用户名',
    `gender`   char(2)      NULL     DEFAULT NULL COMMENT '用途|枚举[GenderEnum]：MAIE(\"M\",\"男\"),FEMALE(\"F\",\"女\"),SECRET(\"S\",\"保密\")',
    `sign`     varchar(255) NULL     DEFAULT NULL COMMENT '我的签名',
    `avatar`   varchar(255) NULL     DEFAULT NULL COMMENT '头像',
    `password` char(32)     NOT NULL COMMENT '密码',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `login_name_unique` (`email`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '用户';

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video`
(
    `id`         char(8)       NOT NULL DEFAULT '' COMMENT 'id',
    `name`       varchar(50)   NOT NULL COMMENT '名称',
    `summary`    varchar(2000) NULL     DEFAULT NULL COMMENT '概述',
    `time`       int           NULL     DEFAULT 0 COMMENT '时长|单位秒',
    `image`      varchar(100)  NULL     DEFAULT NULL COMMENT '封面',
    `status`     char(1)       NULL     DEFAULT NULL COMMENT '状态|枚举[CourseStatusEnum]：REVIEW(\"R\", \"审核中\"),PASS(\"P\", \"通过\"),OVERRULE(\"O\", \"驳回\")',
    `sort`       int           NULL     DEFAULT NULL COMMENT '顺序',
    `created_at` datetime(3)   NULL     DEFAULT NULL COMMENT '创建时间',
    `user_id`    char(8)       NOT NULL DEFAULT '' COMMENT '用户ID',
    `vod`        char(32)      NULL     DEFAULT NULL COMMENT 'vod|阿里云vod',
    `updated_at` datetime(3)   NULL     DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '视频';

-- ----------------------------
-- Table structure for video_category
-- ----------------------------
DROP TABLE IF EXISTS `video_category`;
CREATE TABLE `video_category`
(
    `id`          char(8) NOT NULL DEFAULT '' COMMENT 'id',
    `video_id`    char(8) NULL     DEFAULT NULL COMMENT '视频|video.id',
    `category_id` char(8) NULL     DEFAULT NULL COMMENT '分类|video.id',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '视频分类';

-- ----------------------------
-- Table structure for video_content_file
-- ----------------------------
DROP TABLE IF EXISTS `video_content_file`;
CREATE TABLE `video_content_file`
(
    `id`       char(8)      NOT NULL DEFAULT '' COMMENT 'id',
    `video_id` char(8)      NOT NULL COMMENT '视频id',
    `url`      varchar(100) NULL     DEFAULT NULL COMMENT '地址',
    `name`     varchar(100) NULL     DEFAULT NULL COMMENT '文件名',
    `size`     int          NULL     DEFAULT NULL COMMENT '大小|字节b',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '视频内容文件';


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
    `sort` int comment '顺序',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '分类';

INSERT INTO `category` VALUES ('00000100', '00000000', '娱乐', 100);
INSERT INTO `category` VALUES ('00000101', '00000100', '动画', 101);
INSERT INTO `category` VALUES ('00000102', '00000100', '音乐', 102);
INSERT INTO `category` VALUES ('00000103', '00000100', '生活', 103);
INSERT INTO `category` VALUES ('00000104', '00000100', '时尚', 104);
INSERT INTO `category` VALUES ('00000105', '00000100', '电影', 105);
INSERT INTO `category` VALUES ('00000106', '00000100', '美食', 106);
INSERT INTO `category` VALUES ('00000107', '00000100', '搞笑', 107);
INSERT INTO `category` VALUES ('00000108', '00000100', '游戏', 108);
INSERT INTO `category` VALUES ('00000200', '00000000', '学习', 200);
INSERT INTO `category` VALUES ('00000201', '00000200', '数码', 201);
INSERT INTO `category` VALUES ('00000202', '00000200', '编程', 202);
INSERT INTO `category` VALUES ('00000203', '00000200', '绘画', 203);
INSERT INTO `category` VALUES ('00000204', '00000200', '外语', 204);
INSERT INTO `category` VALUES ('00000205', '00000200', '设计', 205);
INSERT INTO `category` VALUES ('00000206', '00000200', '心理', 206);
INSERT INTO `category` VALUES ('00000207', '00000200', '百科', 207);
INSERT INTO `category` VALUES ('00000208', '00000200', '摄影', 208);

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'id',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '相对路径',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `suffix` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `size` int(11) NULL DEFAULT NULL COMMENT '大小|字节B',
  `use` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用途|枚举[FileUseEnum]：STUDY(\"S\", \"学习\"), ENTERTAINMENT(\"E\", \"娱乐\"),COVER(\"C\",\"封面\")',
  `created_at` datetime(3) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime(3) NULL DEFAULT NULL COMMENT '修改时间',
  `shard_index` int(11) NULL DEFAULT NULL COMMENT '已上传分片',
  `shard_size` int(11) NULL DEFAULT NULL COMMENT '分片大小|B',
  `shard_total` int(11) NULL DEFAULT NULL COMMENT '分片总数',
  `key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件标识',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `path_unique`(`path`) USING BTREE,
  UNIQUE INDEX `key_unique`(`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件' ROW_FORMAT = Dynamic;

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
    `gender`   char(2)      NULL     DEFAULT NULL COMMENT '性别|枚举[GenderEnum]：MAIE(\"M\",\"男\"),FEMALE(\"F\",\"女\"),SECRET(\"S\",\"保密\")',
    `role`   char(2)        NOT NULL DEFAULT 'G' COMMENT '角色|枚举[RoleEnum]：ADMIN(\"A\",\"管理员\"),GENERAL(\"G\",\"普通用户\")',
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

-- 视频播放
DROP TABLE IF EXISTS `video_playback`;
CREATE TABLE `video_playback`
(
    `id`         char(8)      NOT NULL DEFAULT '' COMMENT 'id',
    video_id char(8) NOT NULL COMMENT '视频ID',
    play_volume int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '播放量',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '视频播放';

-- 视频评论
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`
(
    `id`          char(8) NOT NULL DEFAULT '' COMMENT 'id',
    `user_id`    char(8) NULL     DEFAULT NULL COMMENT '用户|user.id',
    `video_id` char(8) NULL     DEFAULT NULL COMMENT '视频|video.id',
    `content` varchar(100) NOT NULL     COMMENT '评论内容',
    PRIMARY KEY (`id`) USING BTREE
) engine = innodb
  default charset = utf8mb4 COMMENT = '视频评论';
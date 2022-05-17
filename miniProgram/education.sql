/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 17/05/2022 15:42:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `c_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '教资', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/a.jpg');
INSERT INTO `category` VALUES (2, '四六级', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/b.jpg');
INSERT INTO `category` VALUES (3, '考研', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/c.jpg');
INSERT INTO `category` VALUES (4, '公考', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/d.jpg');
INSERT INTO `category` VALUES (5, '实用技能', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/e.jpg');
INSERT INTO `category` VALUES (6, '雅思托福', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/f.jpg');
INSERT INTO `category` VALUES (7, '初会注会', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/g.jpg');
INSERT INTO `category` VALUES (8, '计算机', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/h.jpg');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cm_id` int(11) NOT NULL AUTO_INCREMENT,
  `cm_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cm_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cm_date` datetime(0) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 83 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 'Fighting', '老师讲课非常好，常见知识点编成顺口溜非常好记', '2022-01-01 13:00:02', 1, 1);
INSERT INTO `comment` VALUES (2, '我想静静', '老师讲的非常好', '2022-03-07 10:37:01', 2, 2);
INSERT INTO `comment` VALUES (35, 'Fighting', 'xirxir', '2022-03-08 20:11:53', 1, 1);
INSERT INTO `comment` VALUES (36, 'Fighting', 'dgdgdhdhdhdhdgdhdhdj', '2022-03-08 20:12:08', 1, 1);
INSERT INTO `comment` VALUES (37, 'Fighting', '1311', '2022-03-08 20:57:01', 1, 1);
INSERT INTO `comment` VALUES (38, '我想静静', '啊啊啊', '2022-03-08 20:58:14', 26, 2);
INSERT INTO `comment` VALUES (39, 'Fighting', '咕咕咕咕咕咕过', '2022-03-08 20:58:51', 24, 1);
INSERT INTO `comment` VALUES (40, 'Fighting', '999', '2022-03-08 20:59:06', 24, 1);
INSERT INTO `comment` VALUES (41, 'Fighting', '12654564456464', '2022-03-08 20:59:33', 24, 1);
INSERT INTO `comment` VALUES (42, '我想静静', '137976343', '2022-03-09 15:19:36', 2, 2);
INSERT INTO `comment` VALUES (43, 'Fighting', '123456789', '2022-03-09 15:20:38', 2, 1);
INSERT INTO `comment` VALUES (44, '我想静静', '1234567891011121314', '2022-03-09 15:20:50', 2, 2);
INSERT INTO `comment` VALUES (45, 'Fighting', '打啥卡理个发是京东客服合格是地方合格一对方是对方局', '2022-03-09 15:22:13', 1, 1);
INSERT INTO `comment` VALUES (50, 'Fighting', 'aa ', '2022-03-15 16:20:46', 10, 1);
INSERT INTO `comment` VALUES (68, 'Fighting', '老师讲的很好', '2022-03-18 16:40:05', 27, 1);
INSERT INTO `comment` VALUES (69, '我想静静', '老师讲的非常好', '2022-03-18 16:41:45', 36, 2);
INSERT INTO `comment` VALUES (70, '我想静静', '老师讲的很好', '2022-03-18 16:46:23', 7, 2);
INSERT INTO `comment` VALUES (73, 'Fighting', '老师课讲的非常', '2022-04-12 17:35:07', 1, 1);
INSERT INTO `comment` VALUES (74, 'Fighting', '问问', '2022-04-12 17:42:50', 1, 1);
INSERT INTO `comment` VALUES (75, 'Fighting', '搜索', '2022-04-12 17:44:32', 26, 1);
INSERT INTO `comment` VALUES (77, '我想静静', '正在', '2022-04-12 17:50:55', 1, 2);
INSERT INTO `comment` VALUES (78, 'Fighting', '嗷嗷', '2022-04-12 17:52:53', 1, 1);
INSERT INTO `comment` VALUES (79, 'Fighting', '搜索', '2022-04-12 17:53:58', 1, 1);
INSERT INTO `comment` VALUES (80, '我想静静', 'ww', '2022-04-12 17:56:32', 1, 2);
INSERT INTO `comment` VALUES (81, 'Fighting', 'ss', '2022-04-12 18:01:16', 1, 1);
INSERT INTO `comment` VALUES (82, '我想静静', 'dd', '2022-04-12 18:03:31', 26, 2);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cs_id` int(11) NOT NULL AUTO_INCREMENT,
  `cs_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cs_price` decimal(10, 2) NULL DEFAULT NULL,
  `cs_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cs_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cs_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `cat_id` int(11) NULL DEFAULT NULL,
  `te_id` int(11) NULL DEFAULT NULL,
  `cs_hot` int(11) NULL DEFAULT NULL,
  `limit_buy` int(11) NULL DEFAULT NULL,
  `sold` int(11) NULL DEFAULT NULL,
  `order_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `video` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cs_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 91 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (2, '教育知识与能力', 101.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/j2.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加教师资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 1, 4, NULL, 55, 15, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (5, '考研数学', 599.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/y2.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加23年考研的在校或者二战学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 3, 2, 1, 98, 32, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (6, '考研英语', 499.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/y4.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加23年考研的在校或者二战学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 3, 6, 1, 50, 40, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (7, '考研政治', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/y3.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加23年考研的在校或者二战学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 3, 7, NULL, 60, 40, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (8, '国考行测', 899.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/g2.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年公考或国考的的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 4, 8, NULL, 89, 51, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/kg1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (9, '国考申论', 799.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/g1.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年公考或国考的的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 4, 8, NULL, 20, 10, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/kg2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (10, '大学英语四级', 899.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p1.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 2, 10, 1, 79, 31, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (11, '大学英语六级', 999.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p2.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 2, 11, NULL, 99, 71, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (12, '英语口语晨读', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/chendu.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要提升实用技能，对英语口语有着极大兴趣的学员，基础薄弱但有一定自制力的学员。提供给学员课程计划，合理规划时间，明确每堂课学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 5, 12, 1, 99, 51, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (13, '表达能力提升', 499.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/s1.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要提升表达能力，表达能力薄弱有一定自制力的学员。提供给学员课程计划，合理规划时间，明确每堂课学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 5, 12, 1, 200, 100, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (14, '人际关系', 299.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/s2.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要人际交往能力，有社恐不知道如何和别人进行交往但有一定自制力的学员。提供给学员课程计划，合理规划时间，明确每堂课学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 5, 12, 1, 300, 20, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (15, '雅思', 5999.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ys1.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年雅思或托福考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 6, 13, NULL, 400, 200, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/yt1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (16, '托福', 6999.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ys4.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年雅思或托福考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 6, 13, NULL, 500, 120, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/yt2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (17, '初级会计实务', 599.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/k1.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年会计资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 7, 14, NULL, 299, 101, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (18, '初级会计经济法', 899.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/k2.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年会计资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 7, 15, NULL, 600, 400, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (19, 'office', 299.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/js1.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要提升实用技能，对office办公软件有着极大兴趣的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 8, 16, 1, 99, 31, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj1.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (20, 'C语言', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/js2.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要入门编程的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 8, 17, NULL, 199, 61, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj2.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (21, 'C++', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/js3.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要入门编程的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 8, 18, NULL, 300, 20, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (22, 'Java', 499.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/js4.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要入门编程的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 8, 19, 1, 100, 90, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (23, 'Python', 199.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/js5.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要入门编程的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 8, 20, 1, 399, 201, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj5.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (24, '计算机专业课', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/y5.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加23年考研的在校或者二战学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 3, 21, NULL, 299, 21, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky5.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (25, '计算机专业课', 500.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/y6.jpg', '名师授课，该课程50个课时，涉及该学科的所有高频常考知识，该课程适合人群参加23年考研的在校或者二战学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 3, 22, NULL, 500, 250, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky6.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (26, '初中语文', 299.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/j4.jpg', '名师授课，该课程30个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加教师资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '30课时', 1, 26, NULL, 300, 150, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (27, '初中英语', 399.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/j5.jpg', '名师授课，该课程30个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加教师资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '30课时', 1, 27, NULL, 200, 100, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r5.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (28, '四级写作训练营', 99.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p6.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 10, NULL, 100, 70, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (29, '六级写作训练营', 100.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p5.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 11, NULL, 500, 50, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (30, '四级阅读训练营', 88.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p7.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 10, NULL, 300, 150, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs5.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (31, '六级阅读训练营', 89.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p8.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 11, NULL, 400, 20, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs6.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (32, '四级听力训练营', 100.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p3.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 10, NULL, 500, 200, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs7.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (33, '六级听力训练营', 199.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/p4.jpg', '名师授课，该课程10个课时，涉及该学科的所有高频常考知识，该课程适合人群参加22年参加四级或六级考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 2, 11, NULL, 600, 300, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs8.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (34, '省考行测', 899.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/g3.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年公考或国考的的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 4, 9, NULL, 200, 90, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/kg3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (35, '省考申论', 1999.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/g4.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年公考或国考的的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '100课时', 4, 9, NULL, 600, 500, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/kg4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (36, '日语', 899.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/s3.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要提升实用技能，对写作有着极大兴趣的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '100课时', 5, 24, NULL, 99, 81, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (37, '写作', 599.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/s4.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要提升实用技能，对写作有着极大兴趣的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '100课时', 5, 25, NULL, 30, 10, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy5.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (38, '雅思春季1班（A类）', 1999.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ys2.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年雅思或托福考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '100课时', 6, 13, NULL, 40, 10, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/yt3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (39, '雅思春季1班（G类）', 2888.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ys3.jpg', '名师授课，该课程100个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年雅思或托福考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '100课时', 6, 13, NULL, 59, 11, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/yt4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (40, '会计专项急救包（套餐A）', 99.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/k3.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年会计资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '10课时', 7, 23, NULL, 80, 20, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck3.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (41, '会计专项急救包（套餐B）', 299.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/k4.jpg', '名师授课，该课程50个课时，涉及该学科的必备知识，该课程适合人群：想要参加22年会计资格证考试的学员，基础薄弱但有一定自制力的学员。提供给学员复习计划，合理规划时间，明确每个月份每个阶段要学会哪些知识，按部就班的学习。课后老师布置作业，对该堂课的知识进行巩固。', '50课时', 7, 23, NULL, 70, 20, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck4.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (42, '语文诗歌鉴赏', 110.99, NULL, '专注于诗歌鉴赏提升', '10课时', 1, 26, NULL, 100, 90, NULL, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (44, '文言文', 100.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/addCourse.png', '着重文言文的提升', '10课时', 1, 1, NULL, 20, 10, NULL, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (45, '写作训练', 100.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/addCourse.png', '专注文采的提升', '20课时', 1, 26, NULL, 100, 0, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/order.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `course` VALUES (90, '英语听力专项训练', 599.00, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/addCourse.png', '专注与英语听力的学习', '20课时', 1, 6, NULL, 200, 0, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/order.jpg', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `n_detail1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `n_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '习近平回信勉励广大航天青年 弘扬“两弹一星”精神载人航天精神 为航天科技实现高水平自立自强再立新功', '新华社北京5月3日电 在五四青年节到来之际，中共中央总书记、国家主席、中央军委主席习近平5月2日给中国航天科技集团空间站建造青年团队回信，向航天战线全体青年致以节日的祝贺，并向他们提出殷切期望。yuo', '2022-05-01 00:00:00');
INSERT INTO `news` VALUES (2, '习近平将出席庆祝中国共产主义青年团成立100周年并发表重要讲话“学习强国”学习平台将同步直播', '新华社北京5月8日电 庆祝中国共产主义青年团成立100周年大会将于5月10日上午在北京人民大会堂隆重举行。中共中央总书记、国家主席、中央军委主席习近平将出席大会并发表重要讲话。\n\n届时，中央广播电视总台、新华网将对大会进行现场直播，人民网、央视网、中国网等中央重点新闻网站和人民日报客户端、新华社客户端、央视新闻客户端等新媒体平台同步转播。\n\n又讯 5月10日上午，“学习强国”学习平台将同步直播。', '2022-05-10 09:22:17');
INSERT INTO `news` VALUES (15, '农业农村部：全面排查各类毁麦情况 确保夏粮颗粒归仓', '新华社北京5月10日电 针对近日媒体反映个别地方毁麦开工及网上流传的“割青麦作饲料”短视频，记者10日采访了农业农村部相关司局负责人。该负责人表示，农业农村部对此高度重视，“五一”期间就组织相关省份进行核查核实。近日，农业农村部又下发通知要求各地进一步全面排查毁麦开工、青贮小麦等各类毁麦情况，对违法违规行为，发现一起处理一起。', '2022-05-11 00:00:00');
INSERT INTO `news` VALUES (16, '香港特区政府强烈反对个别国家对行政长官选举的无端批评和不实评论', '新华社香港5月10日电 香港特区政府10日强烈驳斥七国集团外长和欧盟外交与安全政策高级代表就香港特区第六任行政长官选举发表的声明。特区政府发言人表示，我们强烈反对声明就行政长官选举作出的无端批评和不实评论。他们公然干预纯属中国内政的香港事务，明显违反了国际关系的基本准则。', '2022-05-11 00:00:00');
INSERT INTO `news` VALUES (17, '俄罗斯批欧盟“劫俄济乌”设想“无法无天”', '新华社香港5月10日电 香港特区政府10日强烈驳斥七国集团外长和欧盟外交与安全政策高级代表就香港特区第六任行政长官选举发表的声明。特区政府发言人表示，我们强烈反对声明就行政长官选举作出的无端批评和不实评论。他们公然干预纯属中国内政的香港事务，明显违反了国际关系的基本准则。', '2022-05-10 00:00:00');
INSERT INTO `news` VALUES (18, '截至2022年5月9日24时新型冠状病毒肺炎疫情最新情况', '2022年5月9日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例357例。其中境外输入病例8例（广西3例，广东2例，北京1例，福建1例，四川1例），含1例由无症状感染者转为确诊病例（在广东）；本土病例349例（上海234例，北京61例，河南25例，广东15例，青海10例，辽宁2例，福建1例，贵州1例），含172例由无症状感染者转为确诊病例（上海156例，河南7例，北京3例，广东3例，辽宁2例，青海1例）。新增死亡病例6例，均为本土病例，均在上海；无新增疑似病例。', '2022-05-10 00:00:00');
INSERT INTO `news` VALUES (19, '东部战区新闻发言人就美“罗亚尔港”号导弹巡洋舰过航台湾海峡发表谈话', '东部战区新闻发言人施毅陆军大校表示，5月10日，美“罗亚尔港”号导弹巡洋舰过航台湾海峡并公开炒作。中国人民解放军东部战区组织兵力全程跟监警戒。美频频上演此类戏码、滋事挑衅，向“台独”势力发出错误信号，蓄意加剧台海紧张局势。战区部队随时保持高度戒备，坚决反制一切威胁挑衅，坚决捍卫国家主权和领土完整。', '2022-05-10 00:00:00');
INSERT INTO `news` VALUES (20, '2022年5月9日新冠病毒疫苗接种情况', '截至2022年5月9日，31个省（自治区、直辖市）和新疆生产建设兵团累计报告接种新冠病毒疫苗335419.6万剂次。', '2022-05-10 00:00:00');
INSERT INTO `news` VALUES (21, '国家发改委：提高重大烈性传染病应对能力', '据国家发改委网站10日消息，国家发改委发布关于印发《“十四五”生物经济发展规划》的通知，通知提出，推动医疗健康产业发展，助力疾病早期预防，加快疫苗研发生产技术迭代升级，开发多联多价疫苗，发展新型基因工程疫苗、治疗性疫苗，提高重大烈性传染病应对能力。', '2022-05-11 00:00:00');
INSERT INTO `news` VALUES (22, '“全球发展倡议之友小组”举行高级别视频会议', '新华社联合国5月9日电 “全球发展倡议之友小组”高级别视频会议9日在纽约联合国总部举行。与会人士认为，会议围绕全球发展倡议展开讨论，将有力推动国际社会重新聚焦发展、加快落实联合国2030年可持续发展议程。', '2022-05-11 00:00:00');
INSERT INTO `news` VALUES (23, '尹锡悦宣誓就任韩国总统', '新华社首尔5月10日电 韩国当选总统尹锡悦10日在韩国国会议事堂前的国会广场正式宣誓就职，成为第20任韩国总统。\n\n当天上午，尹锡悦前往国立显忠院祭拜后，正式宣誓就职。尹锡悦在就职演说中说，当今世界面临新冠大流行、贸易格局剧变、供应链重组、气候变化、粮食能源危机等各种挑战，这些难题不能仅靠一个或几个国家的努力得到解决。', '2022-05-11 00:00:00');

-- ----------------------------
-- Table structure for r_order
-- ----------------------------
DROP TABLE IF EXISTS `r_order`;
CREATE TABLE `r_order`  (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `r_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `r_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `r_price` decimal(10, 2) NULL DEFAULT NULL,
  `r_teacher` int(11) NULL DEFAULT NULL,
  `r_status` int(11) NULL DEFAULT NULL,
  `course_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `r_video` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of r_order
-- ----------------------------
INSERT INTO `r_order` VALUES (6, '202203151939633', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ky1.jpg', '考研数学', 599.00, 2, 0, 5, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (11, '202203192018242', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck3.jpg', '会计专项急救包（套餐A）', 99.00, 23, 1, 40, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (12, '20220328181756', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r2.jpg', '教育知识与能力', 299.00, 4, 1, 2, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (31, '202204071948544', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r2.jpg', '教育知识与能力', 299.00, 4, 1, 2, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (32, '202204121736228', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/rs1.jpg', '大学英语四级', 899.00, 10, 1, 10, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (34, '202204121738251', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r5.jpg', '初中英语', 399.00, 27, 1, 27, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (35, '202204121740676', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/jsj1.jpg', 'office', 299.00, 16, 1, 19, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (36, '202204121740258', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck2.jpg', '初级会计经济法', 899.00, 15, 1, 18, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (39, '202204121815316', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sy1.jpg', '英语口语晨读', 399.00, 12, 0, 12, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (40, '202204121815876', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck2.jpg', '初级会计经济法', 899.00, 15, 1, 18, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (43, '202204171912456', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/ck1.jpg', '初级会计实务', 599.00, 14, 1, 17, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');
INSERT INTO `r_order` VALUES (45, '202205011056364', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/r2.jpg', '教育知识与能力', 299.00, 4, 1, 2, 1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/vedio.mp4');

-- ----------------------------
-- Table structure for swiper
-- ----------------------------
DROP TABLE IF EXISTS `swiper`;
CREATE TABLE `swiper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `carousel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `category_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of swiper
-- ----------------------------
INSERT INTO `swiper` VALUES (1, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sw1.jpg', 2);
INSERT INTO `swiper` VALUES (2, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sw2.jpg', 4);
INSERT INTO `swiper` VALUES (3, 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/sw3.jpg', 1);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `t_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `t_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `t_gender` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `t_age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张宇', '启航考研数学老师，从事高等数学教学和考研辅导多年，在全国核心期刊发表论文多篇，授课方式独特，讲课方式幽默风趣，让你不再觉得数学无趣有着多年的高数教学经验。存储1', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '1', 223);
INSERT INTO `teacher` VALUES (2, '汤家凤', '考研数学老师，南京大学数学系博士，南京工业大学副教授，多年从事考研数学学科，有着丰富的经验', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 22);
INSERT INTO `teacher` VALUES (3, '优优', '综合素质老师，北京师范大学研究生，从事教育行业多年，有着丰富的经验，对综合素质学科有着深入的理解，帮助广大学子综合素质成绩提高，深受广大学子的喜爱', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (4, '糖糖', '教育知识与能力老师，北京师范大学研究生，从事教育行业多年，有着丰富的经验，对教育知识与能力有着深入的理解，帮助广大学子教育知识与能力成绩提高，深受广大学子的喜爱f', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (5, '小雨', '初中数学老师，北京师范大学研究生，从事教育行业多年，有着丰富的经验，对初中数学学科有着深入的理解，帮助广大学子初中数学成绩提高，深受广大学子的喜爱', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (6, '刘晓燕', '考研英语老师，清华大学研究生，本科主修英语专业，从事教育行业多年，有着丰富的经验，教学风格幽默、有趣，让你觉得学英语不再枯燥', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (7, '腿姐', '考研政治老师,全国考研政治青年辅导专家，深受学生喜爱，授课特点鲜明，短时有效，干货满满，从事教育行业多年，有着丰富的经验', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (8, '毛毛', '国考实力老师，从事教育事业多年，对国考科目有着深入的了解，教学经验丰富，学士渊博娓娓道来，善于将考点归纳整理，帮你在愉悦中学会知识', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (9, '楠楠', '省考考实力老师，从事教育事业多年，对国考科目有着深入的了解，教学经验丰富，学士渊博娓娓道来，善于将考点归纳整理，帮你在愉悦中学会知识', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (10, '王菲', '大学英语四级，毕业于北京外国语大学英语系，持国家人事部二级口译笔译证书，教学细致高效，深谙学生痛点，深受广大学生的喜欢', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (11, '周周', '大学英语六级，10+年上万小时教学经验，学生心中的19岁不老男神，擅长帮助学生找到英语听说读写各方面的问题，对症下药，在传授解题技巧的同时，注重学生能力的提升', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '1', 21);
INSERT INTO `teacher` VALUES (12, '思思', '实用技能老师，毕业于清华大学，拥有一口流利地道的美式英文，有很强的表达能力，能处理各种人际关系，有着多年的教学经验，帮助广大学子解决生活中的困扰', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '1', 21);
INSERT INTO `teacher` VALUES (13, '谢老师', '雅思托福老师，毕业于麻省理工大学，拥有博士学位，多年从事与雅思托福教学，有着丰富的经验，帮助广大学子圆了出国留学的梦想，在他的课堂上让你沉浸于英语学习中，有很好的的英语学习氛围', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (14, '三石', '初级会计老师，毕业于上海大学会计专业，拥有研究生学历，多年从事会计专业教学，有着丰富的经验，讲课方式幽默风趣，乐在其中，帮助广大学子成绩提升', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (15, '思宇', '注册会计老师，毕业于江南大学会计专业，拥有研究生学历，多年从事会计专业教学，有着丰富的经验，讲课方式幽默风趣，乐在其中，帮助广大学子成绩提升', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '0', 21);
INSERT INTO `teacher` VALUES (16, '刘伟', 'office老师，中央民族大学研究生，对办公软件有着独到的理解，多年从事office教学，有着丰富的经验，帮助广大学子熟练操作办公软件', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (17, '王俊凯', 'C语言老师，天津大学计算机系研究生，对编程有着独到的理解，多年从事于C语言教学，有着丰富的经验，帮助广大学子踏入编程学习的大门，讲课幽默风趣，擅长使用生活中的实际例子，帮助理解', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (18, '王一博', 'C++老师，西安交通大学计算机系研究生，对编程有着独到的理解，多年从事于C++教学，有着丰富的经验，帮助广大学子踏入编程学习的大门，讲课幽默风趣，擅长使用生活中的实际例子，帮助理解', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (19, '马浩东', 'Java老师，北京大学计算机系研究生，对编程有着独到的理解，多年从事于Java教学，有着丰富的经验，帮助广大学子踏入编程学习的大门，讲课幽默风趣，擅长使用生活中的实际例子，帮助理解', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (20, '张天瑞', 'Python老师，负担大学计算机系研究生，对编程有着独到的理解，多年从事于Python教学，有着丰富的经验，帮助广大学子踏入编程学习的大门，讲课幽默风趣，擅长使用生活中的实际例子，帮助理解', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (21, '王道', '计算机专业课老师，教授计算机专业考研408的所有内容，从事计算机行业多年，同时也从事考研事业多年，有着丰富的经验，在考研界非常出名', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '0', 21);
INSERT INTO `teacher` VALUES (22, '天勤', '计算机专业课老师，教授计算机专业考研408的所有内容，从事计算机行业多年，同时也从事考研事业多年，有着丰富的经验，在考研界非常出名', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t2.jpg', '1', 21);
INSERT INTO `teacher` VALUES (23, '啦啦', '会计专项老师，毕业于长安大学会计专业，拥有研究生学历，多年从事会计专业教学，有着丰富的经验，讲课方式幽默风趣，乐在其中，帮助广大学子成绩提升', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (24, '余周周', '实用技能日语老师，毕业于华中师范大学日语专业，拥有研究生学历，精通日语，曾在日本待过5年，日语表达相当于母语水平，多年从事日语教学，有着丰富的教学经验', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (25, '赵甜甜', '实用技能写作老师，毕业于山东大学汉语言文学专业，拥有研究生学历，擅长写作，富有文采，曾出版过数，让写作丰富你的业余爱好，让生活变得更加有趣', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (26, '刘敏', '教资初中语文老师，天津师范大学研究生，从事教育行业多年，有着丰富的经验，对语文学科有着深入的理解，帮助广大学子初中语文成绩提高，深受广大学子的喜爱', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (27, '刘晶晶', '教资初中英语老师，云南大学研究生，从事教育行业多年，有着丰富的经验，对英语学科有着深入的理解，帮助广大学子初中英语成绩提高，深受广大学子的喜爱', 'https://gulimall-hellomy1.oss-cn-qingdao.aliyuncs.com/picture/t1.jpg', '1', 21);
INSERT INTO `teacher` VALUES (28, '新宇', '经验丰富，资深学历，名校毕业', NULL, '1', 24);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `u_gender` int(11) NULL DEFAULT NULL,
  `u_newLogin` datetime(0) NULL DEFAULT NULL,
  `u_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `u_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Fighting', 1, '2022-05-12 08:58:36', 'https://thirdwx.qlogo.cn/mmopen/vi_32/InPOsKjKA6IBcPG6yKSE5iar1p2WacEicLoMYMhRVvv0ujg2CVib6Anp8hrlDmLiaBpib9XDPicKbCZENyBF5xToP9gA/132', NULL);
INSERT INTO `user` VALUES (2, '我想静静', 0, '2022-03-08 19:54:20', NULL, NULL);
INSERT INTO `user` VALUES (3, 'admin', 1, '2022-04-28 18:55:08', NULL, 'admin');
INSERT INTO `user` VALUES (4, '微笑面对生活', 1, '2022-04-05 18:55:08', NULL, NULL);
INSERT INTO `user` VALUES (5, '金硕源店', 0, '2022-04-05 21:55:08', NULL, NULL);
INSERT INTO `user` VALUES (6, 'pretend', 1, '2022-04-01 16:55:08', NULL, NULL);
INSERT INTO `user` VALUES (7, '爱', 0, '2022-04-11 16:55:08', NULL, NULL);
INSERT INTO `user` VALUES (8, '花花', 1, '2022-05-13 18:55:08', NULL, NULL);
INSERT INTO `user` VALUES (9, '小草', 1, '2022-04-29 18:55:08', NULL, NULL);
INSERT INTO `user` VALUES (10, '百合', 0, '2022-04-28 15:55:08', NULL, NULL);
INSERT INTO `user` VALUES (11, '玫瑰', 0, '2022-04-28 20:55:08', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

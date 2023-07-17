/*
 Navicat Premium Data Transfer

 Source Server         : CloudDB
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : sh-cynosdbmysql-grp-r4gyhpjo.sql.tencentcdb.com:27871
 Source Schema         : education

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 17/07/2023 15:14:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(10) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (236252161, '党委办公室', '四川大学');
INSERT INTO `department` VALUES (236252162, '校长办公室', '四川大学');
INSERT INTO `department` VALUES (236252163, '党委组织部（党校）', '四川大学');
INSERT INTO `department` VALUES (236252164, '党委宣传部（新闻中心）', '四川大学');
INSERT INTO `department` VALUES (236252165, '党委统战部校纪委办公室（监察处）', '四川大学');
INSERT INTO `department` VALUES (236252166, '党委巡察工作办公室', '四川大学');
INSERT INTO `department` VALUES (236252167, '党委学生工作部（处）', '四川大学');
INSERT INTO `department` VALUES (236252168, '党委保卫部（处）', '四川大学');
INSERT INTO `department` VALUES (236252169, '校工会校团委机关党委 ', '四川大学');
INSERT INTO `department` VALUES (236252170, '人事处（党委教师工作部、人才工作办公室）', '四川大学');
INSERT INTO `department` VALUES (236252171, '发展规划处（“双一流”建设与质量评估办公室）', '四川大学');
INSERT INTO `department` VALUES (236252172, '教务处', '四川大学');
INSERT INTO `department` VALUES (236252173, '社会科学研究处', '四川大学');
INSERT INTO `department` VALUES (236252174, '科学技术发展研究院', '四川大学');
INSERT INTO `department` VALUES (236252175, '研究生院', '四川大学');
INSERT INTO `department` VALUES (236252176, '实验室及设备管理处', '四川大学');
INSERT INTO `department` VALUES (236252177, '资产管理处国际合作与交流处', '四川大学');
INSERT INTO `department` VALUES (236252178, '港澳台事务办公室财务处（招投标与采购中心）', '四川大学');
INSERT INTO `department` VALUES (236252179, '审计处老干部党总支', '四川大学');
INSERT INTO `department` VALUES (236252180, '离退休工作处（关心下一代工作委员会办公室）', '四川大学');
INSERT INTO `department` VALUES (236252181, '华西医学中心办公室', '四川大学');
INSERT INTO `department` VALUES (236252182, '基建处信息化建设与管理办公室', '四川大学');
INSERT INTO `department` VALUES (236252183, '经济学院', '四川大学');
INSERT INTO `department` VALUES (236252184, '法学院', '四川大学');
INSERT INTO `department` VALUES (236252185, '文学与新闻学院（新闻学院）', '四川大学');
INSERT INTO `department` VALUES (236252186, '外国语学院艺术学院', '四川大学');
INSERT INTO `department` VALUES (236252187, '历史文化学院(旅游学院)', '四川大学');
INSERT INTO `department` VALUES (236252188, '数学学院', '四川大学');
INSERT INTO `department` VALUES (236252189, '物理学院', '四川大学');
INSERT INTO `department` VALUES (236252190, '化学学院', '四川大学');
INSERT INTO `department` VALUES (236252191, '生命科学学院', '四川大学');
INSERT INTO `department` VALUES (236252192, '电子信息学院', '四川大学');
INSERT INTO `department` VALUES (236252193, '材料科学与工程学院', '四川大学');
INSERT INTO `department` VALUES (236252194, '机械工程学院', '四川大学');
INSERT INTO `department` VALUES (236252195, '电气工程学院 ', '四川大学');
INSERT INTO `department` VALUES (236252196, '计算机学院（软件学院）', '四川大学');
INSERT INTO `department` VALUES (236252197, '建筑与环境学院', '四川大学');
INSERT INTO `department` VALUES (236252198, '水利水电学院', '四川大学');
INSERT INTO `department` VALUES (236252199, '化学工程学院', '四川大学');
INSERT INTO `department` VALUES (236252200, '轻工科学与工程学院', '四川大学');
INSERT INTO `department` VALUES (236252201, '高分子科学与工程学院', '四川大学');
INSERT INTO `department` VALUES (236252202, '华西基础医学与法医学院 ', '四川大学');
INSERT INTO `department` VALUES (236252203, '华西临床医学院(华西医院)', '四川大学');
INSERT INTO `department` VALUES (236252204, '华西第二医院华西口腔医学院（华西口腔医院）', '四川大学');
INSERT INTO `department` VALUES (236252205, '华西公共卫生学院(华西第四医院)', '四川大学');
INSERT INTO `department` VALUES (236252206, '华西药学院', '四川大学');
INSERT INTO `department` VALUES (236252207, '公共管理学院', '四川大学');
INSERT INTO `department` VALUES (236252208, '商学院', '四川大学');
INSERT INTO `department` VALUES (236252209, '马克思主义学院', '四川大学');
INSERT INTO `department` VALUES (236252210, '体育学院', '四川大学');
INSERT INTO `department` VALUES (236252211, '灾后重建与管理学院', '四川大学');
INSERT INTO `department` VALUES (236252212, '空天科学与工程学院', '四川大学');
INSERT INTO `department` VALUES (236252213, '匹兹堡学院国际关系学院', '四川大学');
INSERT INTO `department` VALUES (236252214, '网络空间安全学院', '四川大学');
INSERT INTO `department` VALUES (236252215, '海外教育学院', '四川大学');
INSERT INTO `department` VALUES (236252216, '哲学系', '四川大学');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `purchase_time` date NOT NULL,
  `department_id` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 313292679 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES (39287139, 'rtx 3080 ti', '英伟达rtx 3080 ti显卡', '5000', '显卡', '2021-07-15', '236252196');
INSERT INTO `equipment` VALUES (39287140, '高通量全自动细胞遗传学扫描系统', '用于扫描高通量全自动细胞遗传学', '20000', '扫描仪器', '2018-07-15', '236252191');

-- ----------------------------
-- Table structure for growth_record
-- ----------------------------
DROP TABLE IF EXISTS `growth_record`;
CREATE TABLE `growth_record`  (
  `id` bigint(30) NOT NULL,
  `stu_id` bigint(20) NOT NULL,
  `year` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `learning` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `research` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `social` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of growth_record
-- ----------------------------
INSERT INTO `growth_record` VALUES (1680188741311954944, 2019100458, '2020', '我进入了计算机学院，开始了计算机科学与技术专业的学习。我对人工智能领域很感兴趣，所以我选择了这个方向的课程和实验。我认真学习了基础知识和理论，也动手实践了一些项目。', '我没有参与任何科研项目，因为我还没有找到合适的导师和方向。', '我加入了学生会，参与了一些组织和活动，结识了很多新朋友。');
INSERT INTO `growth_record` VALUES (1680189980024143872, 2019100458, '2021', '我继续深入了人工智能领域的学习，同时也拓展了其他方面的知识。我选修了一些高级和跨学科的课程，如机器学习、数据挖掘、计算机视觉等，提高了我的专业水平和综合能力。', '我有幸加入了导师的科研团队，参与了一个关于自然语言处理的项目。我在项目中负责数据处理和模型训练，经过不懈的努力，我们成功地发表了一篇论文。这是我第一次参与科研，也是我第一次发表论文，我感到非常兴奋和自豪。', '我参加了志愿者服务，去了一些贫困地区和老人院，帮助了一些需要帮助的人。我在服务中感受到了社会的责任和温暖，也锻炼了我的沟通和协作能力。');
INSERT INTO `growth_record` VALUES (1680375513731985408, 2019100458, '2022', '我在计算机科学与技术专业的学习中取得了优异的成绩，获得了学士学位。我在人工智能领域也有了更多的收获和进步，我参加了一些国内外的竞赛和研讨会，与一些优秀的同行交流和合作，拓宽了我的视野和网络。', '我继续参与了导师的科研项目，这次我们的目标是开发一个智能的对话系统，可以与用户进行自然和流畅的交互。我在项目中主要负责对话管理和生成模块，利用了最新的深度学习和强化学习技术，实现了一个高效和灵活的对话系统。我们的项目获得了很好的评价和反馈，我们也准备了一篇论文，打算投稿到一个国际顶级会议。', '我没有参加太多的社会活动，因为我主要把时间和精力放在了学习和科研上。不过，我还是保持了与学生会和志愿者服务的联系，偶尔参与一些活动，如迎新、庆典、捐赠等，为学校和社会做一些贡献。');
INSERT INTO `growth_record` VALUES (1680463862815686656, 2019102839, '2020', '我进入了计算机学院，开始了软件工程专业的学习。我对软件开发和设计有很大的兴趣，所以我选择了这个专业。我努力学习了编程语言、数据结构、算法等基础课程，也尝试了一些个人和团队的项目，锻炼了我的编码能力和团队协作能力。', '我没有参与任何科研项目，因为我觉得科研太枯燥和难懂，不适合我。', '我加入了计算机协会，参与了一些技术分享和交流，学习了一些新的技术和工具，也认识了一些志同道合的人。');
INSERT INTO `growth_record` VALUES (1680815847280635904, 2019102839, '2021', '我继续了软件工程专业的学习，同时也探索了一些其他领域的知识。我选修了一些与软件相关的课程，如软件工程、软件测试、软件架构等，提高了我的软件质量和效率。我还选修了一些与人文社科相关的课程，如心理学、社会学、哲学等，拓展了我的人文素养和思辨能力。', '我仍然没有参与任何科研项目，因为我更喜欢实践和应用，而不是理论和研究。', '我参加了创新创业大赛，与我的队友一起开发了一个基于区块链的智能合约平台，可以实现去中心化的交易和合约执行。我们的项目获得了一等奖，也吸引了一些投资者和媒体的关注。');
INSERT INTO `growth_record` VALUES (1680815847293218816, 2019102839, '2022', '我在软件工程专业的学习中取得了优异的成绩，获得了学士学位。我在软件开发和设计方面也有了很多的经验和成果，我参与了一些大型和复杂的项目，如电商平台、社交网络、游戏开发等，展现了我的软件能力和创造力。', '我还是没有参与任何科研项目，因为我已经决定从事软件行业，而不是继续深造或从事科研。', '我没有参加太多的社会活动，因为我主要把时间和精力放在了学习和创业上。不过，我还是保持了与计算机协会和创新创业大赛的联系，偶尔参与一些活动，如技术沙龙、创业路演、导师指导等，为计算机领域和创新创业领域做一些贡献。');
INSERT INTO `growth_record` VALUES (1680815847297413120, 2019103736, '2020', '我进入了网络安全学院，开始了网络工程专业的学习。我对网络通信和安全有很大的兴趣，所以我选择了这个专业。我努力学习了计算机网络、操作系统、密码学等基础课程，也尝试了一些网络配置和攻防的实验，锻炼了我的网络能力和安全意识。', '我没有参与任何科研项目，因为我还没有找到合适的导师和方向。', '我加入了网络安全协会，参与了一些网络安全的培训和竞赛，学习了一些网络攻击和防御的技巧和方法，也认识了一些网络安全的高手和爱好者。');
INSERT INTO `growth_record` VALUES (1680815847297413121, 2019103736, '2021', '我在网络工程专业的学习中取得了优异的成绩，获得了学士学位。我在网络通信和安全方面也有了很多的经验和成果，我参与了一些重要和敏感的项目，如政府网站、银行系统、电力系统等，保障了这些系统的网络安全和稳定。', '我有幸加入了导师的科研团队，参与了一个关于网络安全的项目。我在项目中负责网络流量的分析和异常检测，利用了一些机器学习和数据挖掘的技术，实现了一个高效和准确的网络安全系统。我们的项目获得了很好的评价和反馈，我们也准备了一篇论文，打算投稿到一个国内优秀期刊。', '我参加了网络安全挑战赛，与我的队友一起完成了一系列的网络攻防任务，展现了我们的网络安全技能和团队协作能力。我们的队伍获得了冠军，也获得了一些奖金和荣誉。');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `department_id` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1680023336563929089 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES (1680023331459461120, '数字图像实验室', '第二基础实验楼A218', '236252196');
INSERT INTO `laboratory` VALUES (1680023336563929088, '网络攻防战实验室', '网络安全综合楼903', '236252214');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` int(11) NOT NULL DEFAULT 0,
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `department_id` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `grade` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `dormitory` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1680383267165065218 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2019100458, '段翘楚', 0, '15824681981', '236252196', '2019', '2019120', '西园19舍');
INSERT INTO `student` VALUES (2019102839, '黄梦君', 1, '18324683322', '236252196', '2019', '2019118', '西园9舍');
INSERT INTO `student` VALUES (2019103736, '陈晓萌', 0, '15024681617', '236252214', '2019', '2019187', '西园17舍');
INSERT INTO `student` VALUES (2019110166, '傅月玥', 0, '15524682318', '236252193', '2019', '2019170', '西园17舍');
INSERT INTO `student` VALUES (2019111507, '蒋天乐', 1, '13824683798', '236252194', '2019', '2019168', '西园9舍');
INSERT INTO `student` VALUES (2019118339, '戴心逸', 1, '15024681830', '236252201', '2019', '2019193', '西园10舍');
INSERT INTO `student` VALUES (2019118916, '葛霖婕', 0, '18824682525', '236252201', '2019', '2019130', '西园9舍');
INSERT INTO `student` VALUES (2019118937, '胡佳婧', 0, '15024683218', '236252201', '2019', '2019157', '西园11舍');
INSERT INTO `student` VALUES (2019119864, '江瑾贤', 0, '19924683578', '236252202', '2019', '2019176', '西园6舍');
INSERT INTO `student` VALUES (2019124374, '管欣雨', 0, '17724682797', '236252207', '2019', '2019128', '西园18舍');
INSERT INTO `student` VALUES (2019125733, '付廷琛', 0, '15224682249', '236252208', '2019', '2019118', '西园9舍');
INSERT INTO `student` VALUES (2019126116, '蒋彦玫', 1, '15524683916', '236252209', '2019', '2019193', '西园14舍');
INSERT INTO `student` VALUES (2019127223, '陈静远', 1, '19924681548', '236252210', '2019', '2019187', '西园14舍');
INSERT INTO `student` VALUES (2020100379, '黄梓灵', 0, '15224683505', '236252183', '2020', '2020163', '西园16舍');
INSERT INTO `student` VALUES (2020104913, '高铭蔚', 1, '13824682395', '236252187', '2020', '2020165', '西园16舍');
INSERT INTO `student` VALUES (2020106825, '陈津君', 0, '19924681522', '236252189', '2020', '2020159', '西园10舍');
INSERT INTO `student` VALUES (2020108350, '何龙江', 1, '15024682999', '236252191', '2020', '2020100', '西园12舍');
INSERT INTO `student` VALUES (2020115598, '陈舒睿', 0, '15524681606', '236252198', '2020', '2020127', '西园5舍');
INSERT INTO `student` VALUES (2020117526, '陈卉', 1, '17824681449', '236252200', '2020', '2020148', '西园3舍');
INSERT INTO `student` VALUES (2020118296, '葛倩', 1, '19924682590', '236252201', '2020', '2020167', '西园17舍');
INSERT INTO `student` VALUES (2020118702, '戴源', 1, '15524681893', '236252201', '2020', '2020177', '西园1舍');
INSERT INTO `student` VALUES (2020127256, '冯嘉诚', 1, '15024682152', '236252210', '2020', '2020184', '西园19舍');
INSERT INTO `student` VALUES (2020127948, '陈苏', 1, '15024681615', '236252210', '2020', '2020103', '西园5舍');
INSERT INTO `student` VALUES (2020129247, '黄露颐', 1, '15824683291', '236252212', '2020', '2020187', '西园16舍');
INSERT INTO `student` VALUES (2020131679, '陈丽金', 0, '15524681567', '236252214', '2020', '2020115', '西园10舍');
INSERT INTO `student` VALUES (2020132476, '姜小艺', 0, '15824683728', '236252215', '2020', '2020194', '西园4舍');
INSERT INTO `student` VALUES (2021103627, '陈慧铷', 0, '17724681517', '236252186', '2021', '2021179', '西园15舍');
INSERT INTO `student` VALUES (2021108301, '黄诗雨', 1, '19924683417', '236252191', '2021', '2021106', '西园15舍');
INSERT INTO `student` VALUES (2021114540, '陈浩邦', 1, '15224681412', '236252197', '2021', '2021140', '西园5舍');
INSERT INTO `student` VALUES (2021115396, '何雨辰', 0, '13824683097', '236252198', '2021', '2021189', '西园14舍');
INSERT INTO `student` VALUES (2021116549, '崔梦莹', 0, '19924681746', '236252199', '2021', '2021170', '西园11舍');
INSERT INTO `student` VALUES (2021121824, '纪昕怡', 1, '15024683543', '236252204', '2021', '2021145', '西园14舍');
INSERT INTO `student` VALUES (2021122269, '蒋文馨', 1, '15524683844', '236252205', '2021', '2021117', '西园1舍');
INSERT INTO `student` VALUES (2021125150, '巩馨泽', 0, '15824682633', '236252208', '2021', '2021187', '西园18舍');
INSERT INTO `student` VALUES (2021130401, '韩金池', 0, '15224682890', '236252213', '2021', '2021189', '西园16舍');
INSERT INTO `student` VALUES (2021130556, '樊舒悦', 0, '15824682031', '236252213', '2021', '2021134', '西园2舍');
INSERT INTO `student` VALUES (2021132799, '靳子慧', 1, '13824684004', '236252215', '2021', '2021171', '西园16舍');
INSERT INTO `student` VALUES (2022100818, '高心莹', 1, '19924682488', '236252183', '2022', '2022142', '西园12舍');
INSERT INTO `student` VALUES (2022101161, '洪浴洋', 1, '13824683135', '236252184', '2022', '2022166', '西园14舍');
INSERT INTO `student` VALUES (2022114952, '郝嘉欣', 0, '15024682924', '236252197', '2022', '2022150', '西园2舍');
INSERT INTO `student` VALUES (2022116826, '崔冠宇', 0, '15024681672', '236252199', '2022', '2022192', '西园4舍');
INSERT INTO `student` VALUES (2022118504, '江晓彤', 1, '19924683650', '236252201', '2022', '2022193', '西园13舍');
INSERT INTO `student` VALUES (2022118994, '方佛送', 1, '15224682111', '236252201', '2022', '2022151', '西园8舍');
INSERT INTO `student` VALUES (2022120328, '蒋湘瑜', 1, '15524683893', '236252203', '2022', '2022139', '西园9舍');
INSERT INTO `student` VALUES (2022123544, '顾洛文', 0, '15824682710', '236252206', '2022', '2022138', '西园6舍');
INSERT INTO `student` VALUES (2022125244, '程杰翰', 1, '15024681638', '236252208', '2022', '2022139', '西园1舍');
INSERT INTO `student` VALUES (2022127303, '顾璐杰', 1, '17724682650', '236252210', '2022', '2022167', '西园19舍');
INSERT INTO `student` VALUES (2022131114, '韩忆茹', 1, '19924682913', '236252214', '2022', '2022112', '西园19舍');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `gender` int(11) NOT NULL DEFAULT 0,
  `department_id` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `job` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `salary` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 315286967 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (39291080, '仇钰', 1, '236252211', '副教授', '17839156239', '12000');
INSERT INTO `teacher` VALUES (39291137, '康杨洁羽', 0, '236252166', '行政主任', '13209195280', '16000');
INSERT INTO `teacher` VALUES (39291168, '陈怡', 0, '236252172', '学院院长', '13244968915', '14000');
INSERT INTO `teacher` VALUES (39291270, '陈诗璐', 1, '236252214', '行政主任', '17330776045', '16000');
INSERT INTO `teacher` VALUES (39291275, '崔梦怡', 0, '236252188', '讲师', '15272202189', '11000');
INSERT INTO `teacher` VALUES (39291324, '韩丹', 1, '236252191', '助教', '18107694572', '10000');
INSERT INTO `teacher` VALUES (39291330, '金今', 1, '236252187', '行政主任', '18172542627', '16000');
INSERT INTO `teacher` VALUES (39291363, '程秋实', 0, '236252181', '教授', '19879853721', '13000');
INSERT INTO `teacher` VALUES (39291402, '陈钰冰', 0, '236252184', '副教授', '18086253166', '12000');
INSERT INTO `teacher` VALUES (39291424, '胡雯', 0, '236252203', '副教授', '18653539424', '12000');
INSERT INTO `teacher` VALUES (39291600, '陈南褰', 0, '236252207', '学院院长', '18832064160', '14000');
INSERT INTO `teacher` VALUES (39291648, '高芳惠子', 0, '236252198', '副教授', '15815929258', '12000');
INSERT INTO `teacher` VALUES (39291655, '多吉措姆', 1, '236252212', '助教', '18369055890', '10000');
INSERT INTO `teacher` VALUES (39291667, '郭建兵', 0, '236252188', '讲师', '14926797219', '11000');
INSERT INTO `teacher` VALUES (39291761, '胡珂', 0, '236252174', '讲师', '16519562785', '11000');
INSERT INTO `teacher` VALUES (39291786, '谷雨佳', 1, '236252179', '行政主任', '14573514019', '16000');
INSERT INTO `teacher` VALUES (39291792, '程可', 0, '236252212', '副教授', '18797313721', '12000');
INSERT INTO `teacher` VALUES (39291832, '胡文睿', 1, '236252190', '学院院长', '18066847208', '14000');
INSERT INTO `teacher` VALUES (39291836, '蒋浩琛', 1, '236252181', '助教', '18022582690', '10000');
INSERT INTO `teacher` VALUES (39291858, '尼古丁真', 0, '236252161', 'rapper', '1145141819', '114514');
INSERT INTO `teacher` VALUES (39291869, '洪一莲', 0, '236252198', '教授', '17316318258', '13000');
INSERT INTO `teacher` VALUES (39291895, '戴悦', 0, '236252187', '学院院长', '17122046615', '14000');
INSERT INTO `teacher` VALUES (39291902, '蒋维扬', 1, '236252184', '讲师', '15271457966', '11000');
INSERT INTO `teacher` VALUES (39291922, '黄学文', 1, '236252214', '党委书记', '13298763623', '15000');
INSERT INTO `teacher` VALUES (39291924, '姜天瑜', 0, '236252184', '教授', '18047492917', '13000');
INSERT INTO `teacher` VALUES (39291931, '何林波', 0, '236252194', '教授', '15951924554', '13000');
INSERT INTO `teacher` VALUES (39291957, '揭祎琳', 0, '236252215', '讲师', '17545936929', '11000');
INSERT INTO `teacher` VALUES (39291991, '江超男', 0, '236252172', '副教授', '18075181469', '12000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键，用户名及登录账号',
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`username`) USING BTREE,
  UNIQUE INDEX `user_username_uindex`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', '123456');
INSERT INTO `user` VALUES ('admin1', '123456');
INSERT INTO `user` VALUES ('admin2', '123456');
INSERT INTO `user` VALUES ('admin3', '123456');
INSERT INTO `user` VALUES ('admin5', '123456');
INSERT INTO `user` VALUES ('zjc', '123456');

SET FOREIGN_KEY_CHECKS = 1;

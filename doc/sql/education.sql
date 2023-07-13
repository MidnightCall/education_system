use education;

drop table if exists equipment;

create table equipment (
   equipment_id char(10) CHARACTER SET utf8mb4 comment '设备id',
   equipment_name varchar(50) CHARACTER SET utf8mb4 default null comment '设备名称',
   equipment_type varchar(20) CHARACTER SET utf8mb4 default null comment '设备类型',
   PRIMARY KEY (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='设备管理配置';

BEGIN;
INSERT INTO `equipment` VALUES ('1000000001', '丁真的小马', '纯真');
INSERT INTO `equipment` VALUES ('1000000002', '华为13 pro max 冷锋蓝', '爱国');
COMMIT;

drop table if exists laboratory;

create table laboratory (
    laboratory_id char(8) CHARACTER SET utf8mb4 comment '实验室',
    laboratory_name varchar(50) CHARACTER SET utf8mb4 default null comment '实验室名称',
    laboratory_type varchar(20) CHARACTER SET utf8mb4 default null comment '实验室地址',
   PRIMARY KEY (`laboratory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='实验室管理配置';

BEGIN;
INSERT INTO `laboratory` VALUES ('10000001', '理塘', '世界最高城');
INSERT INTO `laboratory` VALUES ('10000002', '四川大学男厕所', 'null');
COMMIT;
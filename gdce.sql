DROP TABLE tbl_product_info;
/*商品信息表*/
CREATE TABLE tbl_product_info
( 
      id                  INTEGER(4)    NOT NULL AUTO_INCREMENT PRIMARY KEY,
      productId           INTEGER(6) 	NOT NULL              COMMENT '商品编号（从1开始）',
      productState        INTEGER(1)    NOT NULL              COMMENT '商品状态（0-上架 1-下架 2-锁定）',
      productType         VARCHAR(5) 	NOT NULL              COMMENT '煤种（混煤、褐煤、电煤、烟煤、沫煤、无烟煤）',
      srcAddress          VARCHAR(20)   NOT NULL              COMMENT '产地（山西、内蒙）',
      destAddress         VARCHAR(20)   NOT NULL              COMMENT '交货地（集宁、达州电厂、康平、酒泉、豫园国电、大武口电厂）',
      price 		      FLOAT(5,2)    NOT NULL              COMMENT '价格（元/吨）',
      quantity            FLOAT(5,2)    NOT NULL              COMMENT '数量（万吨）',       
      createDate          VARCHAR(20)   NOT NULL              COMMENT '发布时间', 
      endDate             VARCHAR(20)   NOT NULL              COMMENT '截止时间',
      fullMoisture 	      FLOAT(5,2)    NOT NULL              COMMENT '全水分', 
      fullSulfur          FLOAT(5,2)    NOT NULL              COMMENT '全硫份', 
      volatiles           FLOAT(5,2)    NOT NULL              COMMENT '挥发份',
      transactionMode 	  VARCHAR(20) 	NOT NULL              COMMENT '交货方式',
      lowPower            INTEGER(5)    NOT NULL              COMMENT '低位发热量',
      userName            VARCHAR(20)   NOT NULL              COMMENT '用户名称',          
      reviewState         INTEGER(3)    NOT NULL              COMMENT '0-待审核 1-通过 2-未通过', 
      remark 		      VARCHAR(200)  NOT NULL              COMMENT '备注'
);	

DROP TABLE tbl_contract_info;
/*合同信息表*/
CREATE TABLE tbl_contract_info
(  
   id                  INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   contractId          INTEGER(20)  NOT NULL                  COMMENT '合同编号',
   buyerCompanyId      VARCHAR(30)  NOT NULL                  COMMENT '买方编号（对应企业编号）',
   sellerCompanyId     VARCHAR(30)  NOT NULL                  COMMENT '卖方编号（对应企业编号）',
   productId           INTEGER(10)  NOT NULL                  COMMENT '商品编号',
   buyerContractState  BOOLEAN      NOT NULL                  COMMENT '买方合同状态(true-已签 false-未签)', 
   sellerContractState BOOLEAN      NOT NULL                  COMMENT '卖方合同状态(true-已签 false-未签)',
   createDate          VARCHAR(20)  NOT NULL                  COMMENT '创建时间',
   endDate             VARCHAR(20)  NOT NULL                  COMMENT '结束时间'
);

DROP TABLE tbl_order_info;
/*订单信息*/
CREATE TABLE tbl_order_info 
(
   id                  INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   orderId             VARCHAR(20)  NOT NULL                  COMMENT '订单号(时间戳+卖家企业机构代码编号后四位：2018080110034455)',
   tradePrice          FLOAT(8,2)   NOT NULL                  COMMENT '交易金额', 
   productId           INTEGER(4)   NOT NULL                  COMMENT '商品编号',
   buyerCompanyId      VARCHAR(30)  NOT NULL                  COMMENT '买方编号（对应企业编号）',
   sellerCompanyId     VARCHAR(30)  NOT NULL                  COMMENT '卖方编号（对应企业编号）',   
   orderState          INTEGER(2)   NOT NULL                  COMMENT '订单状态（0-待付款 1-待发货 2-待收货 3-待验收 4-完成）', 
   receiptPath         VARCHAR(45)  NOT NULL                  COMMENT '回执单存放路径（/imgs/order/receipt/买家编号（后四位）+订单编号', 
   createDate          VARCHAR(20)  NOT NULL                  COMMENT '创建时间',
   endDate             VARCHAR(20)  NOT NULL                  COMMENT '结束时间（默认15个工作日）' 
);

DROP TABLE tbl_waybill_info;
/*运单信息表*/
CREATE TABLE tbl_waybill_info
(
   id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   waybillId          VARCHAR(20)  NOT NULL                  COMMENT '运单号（时间戳+物流商企业机构代码编号后四位：2018080110034455）',
   waybillCompanyId   VARCHAR(30)  NOT NULL                  COMMENT '企业机构代码',
   createTime         VARCHAR(20)  NOT NULL                  COMMENT '创建时间',
   endTime            VARCHAR(20)  NOT NULL                  COMMENT '结束时间（用户收货后更新）',
   orderId            VARCHAR(20)  NOT NULL                  COMMENT '订单号(2018080110034455)',
   waybillState       VARCHAR(2)   NOT NULL                  COMMENT '运单状态（0-待发货 1-运输中 2-待签收 3-已签收）'
);

DROP TABLE tbl_logistics_info;
/*物流信息表*/
CREATE TABLE tbl_logistics_info
(
   id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   waybillId          VARCHAR(20)  NOT NULL                  COMMENT '运单号（时间戳+物流商企业机构代码编号后四位：2018080110034455）',
   updateDate         VARCHAR(20)  NOT NULL                  COMMENT '更新时间',
   submitUser         VARCHAR(5)   NOT NULL                  COMMENT '提交人',
   location           VARCHAR(20)  NOT NULL                  COMMENT '地点',
   content            VARCHAR(80)  NOT NULL                  COMMENT '内容'
);

DROP TABLE tbl_news_info;
/*资讯信息表*/
CREATE TABLE tbl_news_info
(
   id                INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name              VARCHAR(20)  NOT NULL                  COMMENT '用户名称',
   title             VARCHAR(50)  NOT NULL                  COMMENT '标题',
   type              VARCHAR(10)  NOT NULL                  COMMENT '类型（电力行业、煤炭价格、市场分析、宏观政策）',
   reviewState       INTEGER(3)   NOT NULL                  COMMENT '0-待审核 1-通过 2-未通过',
   createDate        VARCHAR(20)  NOT NULL                  COMMENT '创建时间',
   content           VARCHAR(1000)  NOT NULL                COMMENT '内容'
);

DROP TABLE tbl_ads;
/*广告信息表*/
CREATE TABLE tbl_ads
(
   id                 INTEGER(4)      AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   companyId          VARCHAR(30)     NOT NULL               COMMENT '企业机构代码',
   position           INTEGER(1) 	  NOT NULL               COMMENT '广告位 1-4',	
   email              VARCHAR(30)     NOT NULL               COMMENT '邮箱',
   adsImgPath         VARCHAR(45)     NOT NULL               COMMENT '广告图片存放路径（/imgs/ads/企业机构代码+时间戳）',
   adsURL             VARCHAR(100)    NOT NULL               COMMENT '广告超链地址',
   note               VARCHAR(200)    NOT NULL               COMMENT '备注',
   releaseDate        VARCHAR(20)     NOT NULL               COMMENT '广告投放时间时间',
   endDate            VARCHAR(20)     NOT NULL               COMMENT '广告截止时间',
   reviewState        INTEGER(3)      NOT NULL               COMMENT '0-待审核 1-通过 2-未通过'
);

DROP TABLE tbl_company_info;
/*企业信息表*/
CREATE TABLE tbl_company_info
(
   id INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   companyId          VARCHAR(30) NOT NULL                COMMENT '企业机构代码',
   companyName        VARCHAR(30) NOT NULL                COMMENT '企业名称',
   legalPerson        VARCHAR(10) NOT NULL                COMMENT '法人',
   phoneNumber        VARCHAR(20) NOT NULL                COMMENT '联系方式',
   bankAccount        VARCHAR(30) NOT NULL                COMMENT '银行账户',
   openLicenseId      VARCHAR(30) NOT NULL                COMMENT '营业执照',
   openLicensePath    VARCHAR(60) NOT NULL                COMMENT '营业执照存放路径（/imgs/openLicense/企业机构代码+时间戳）',
   taxRegisterId      VARCHAR(30) NOT NULL                COMMENT '税务登记号',
   reviewState        INTEGER(3)  NOT NULL                COMMENT '0-待审核 1-通过 2-未通过'
);
INSERT INTO tbl_company_info(companyId,companyName,legalPerson,phoneNumber,bankAccount,openLicenseId,openLicensePath,taxRegisterId,reviewState) VALUES('914403003350295935','深圳市优品尚电子科技有限公司','李根飞','15922554689','','440306112458177','/imgs/company201807311544.jpg','310114580607617','1');

DROP TABLE system_users;
/*系统用户*/
CREATE TABLE system_users
(
   id INTEGER(4) AUTO_INCREMENT   NOT NULL PRIMARY KEY,
   NAME                           VARCHAR(20) NOT NULL                COMMENT '用户名称',
   PASSWORD                       VARCHAR(20) NOT NULL                COMMENT '密码',
   LEVEL                          INTEGER(2) NOT NULL                 COMMENT '0-超管 1-管理员 2-会员',
   permission                     VARCHAR(10) NOT NULL                COMMENT '权限（0-创建管理员 1-信息审核 2-买方 3-卖方 4-物流 5-资讯管理）',
   companyId                      VARCHAR(30) NOT NULL                COMMENT '企业机构代码',
   isRemember                     BOOLEAN NOT NULL                    COMMENT '记住我',
   loginState                     BOOLEAN NOT NULL                    COMMENT '登录状态（true-在线 false-离线）'
);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('admin','123456','0', '0,1,2,3,4','',FALSE,FALSE);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('guest','123456','1', '1,2,3,4','',FALSE,FALSE);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('test','1234','2', '3','914403003350295935',FALSE,FALSE);

DROP TABLE tbl_static_logistics_price;
/*物流价格信息表*/
CREATE TABLE tbl_static_logistics_price
(
    id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    waybillCompanyId   VARCHAR(30)  NOT NULL                  COMMENT '企业机构代码',
    startingPlace      VARCHAR(20)  NOT NULL                  COMMENT '起始地', 
    destination        VARCHAR(20)  NOT NULL                  COMMENT '目的地', 
    weight             VARCHAR(10)  NOT NULL                  COMMENT '重量（>=3000）万吨',
    price              INTEGER(4)   NOT NULL                  COMMENT '价格'
);
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '广州', '<=6', '38'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '广州', '>=6', '36'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '福州', '<=3', '37'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '福州', '>=3', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '宁波', '<=2', '38'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '宁波', '>=2', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '上海', '<=4', '33'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '上海', '>=4', '30'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '张家港', '<=3', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '秦皇岛', '张家港', '>=3', '32'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '天津', '上海', '<=2', '33'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '天津', '上海', '>=2', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '天津', '镇江', '<=2', '44'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '天津', '镇江', '>=2', '40'); 
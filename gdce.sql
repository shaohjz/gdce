DROP TABLE tbl_product_info;
/*��Ʒ��Ϣ��*/
CREATE TABLE tbl_product_info
( 
      id                  INTEGER(4)    NOT NULL AUTO_INCREMENT PRIMARY KEY,
      productId           INTEGER(6) 	NOT NULL              COMMENT '��Ʒ��ţ���1��ʼ��',
      productState        INTEGER(1)    NOT NULL              COMMENT '��Ʒ״̬��0-�ϼ� 1-�¼� 2-������',
      productType         VARCHAR(5) 	NOT NULL              COMMENT 'ú�֣���ú����ú����ú����ú��ĭú������ú��',
      srcAddress          VARCHAR(20)   NOT NULL              COMMENT '���أ�ɽ�������ɣ�',
      destAddress         VARCHAR(20)   NOT NULL              COMMENT '�����أ����������ݵ糧����ƽ����Ȫ��ԥ԰���硢����ڵ糧��',
      price 		      FLOAT(5,2)    NOT NULL              COMMENT '�۸�Ԫ/�֣�',
      quantity            FLOAT(5,2)    NOT NULL              COMMENT '��������֣�',       
      createDate          VARCHAR(20)   NOT NULL              COMMENT '����ʱ��', 
      endDate             VARCHAR(20)   NOT NULL              COMMENT '��ֹʱ��',
      fullMoisture 	      FLOAT(5,2)    NOT NULL              COMMENT 'ȫˮ��', 
      fullSulfur          FLOAT(5,2)    NOT NULL              COMMENT 'ȫ���', 
      volatiles           FLOAT(5,2)    NOT NULL              COMMENT '�ӷ���',
      transactionMode 	  VARCHAR(20) 	NOT NULL              COMMENT '������ʽ',
      lowPower            INTEGER(5)    NOT NULL              COMMENT '��λ������',
      userName            VARCHAR(20)   NOT NULL              COMMENT '�û�����',          
      reviewState         INTEGER(3)    NOT NULL              COMMENT '0-����� 1-ͨ�� 2-δͨ��', 
      remark 		      VARCHAR(200)  NOT NULL              COMMENT '��ע'
);	

DROP TABLE tbl_contract_info;
/*��ͬ��Ϣ��*/
CREATE TABLE tbl_contract_info
(  
   id                  INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   contractId          INTEGER(20)  NOT NULL                  COMMENT '��ͬ���',
   buyerCompanyId      VARCHAR(30)  NOT NULL                  COMMENT '�򷽱�ţ���Ӧ��ҵ��ţ�',
   sellerCompanyId     VARCHAR(30)  NOT NULL                  COMMENT '������ţ���Ӧ��ҵ��ţ�',
   productId           INTEGER(10)  NOT NULL                  COMMENT '��Ʒ���',
   buyerContractState  BOOLEAN      NOT NULL                  COMMENT '�򷽺�ͬ״̬(true-��ǩ false-δǩ)', 
   sellerContractState BOOLEAN      NOT NULL                  COMMENT '������ͬ״̬(true-��ǩ false-δǩ)',
   createDate          VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��',
   endDate             VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��'
);

DROP TABLE tbl_order_info;
/*������Ϣ*/
CREATE TABLE tbl_order_info 
(
   id                  INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   orderId             VARCHAR(20)  NOT NULL                  COMMENT '������(ʱ���+������ҵ���������ź���λ��2018080110034455)',
   tradePrice          FLOAT(8,2)   NOT NULL                  COMMENT '���׽��', 
   productId           INTEGER(4)   NOT NULL                  COMMENT '��Ʒ���',
   buyerCompanyId      VARCHAR(30)  NOT NULL                  COMMENT '�򷽱�ţ���Ӧ��ҵ��ţ�',
   sellerCompanyId     VARCHAR(30)  NOT NULL                  COMMENT '������ţ���Ӧ��ҵ��ţ�',   
   orderState          INTEGER(2)   NOT NULL                  COMMENT '����״̬��0-������ 1-������ 2-���ջ� 3-������ 4-��ɣ�', 
   receiptPath         VARCHAR(45)  NOT NULL                  COMMENT '��ִ�����·����/imgs/order/receipt/��ұ�ţ�����λ��+�������', 
   createDate          VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��',
   endDate             VARCHAR(20)  NOT NULL                  COMMENT '����ʱ�䣨Ĭ��15�������գ�' 
);

DROP TABLE tbl_waybill_info;
/*�˵���Ϣ��*/
CREATE TABLE tbl_waybill_info
(
   id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   waybillId          VARCHAR(20)  NOT NULL                  COMMENT '�˵��ţ�ʱ���+��������ҵ���������ź���λ��2018080110034455��',
   waybillCompanyId   VARCHAR(30)  NOT NULL                  COMMENT '��ҵ��������',
   createTime         VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��',
   endTime            VARCHAR(20)  NOT NULL                  COMMENT '����ʱ�䣨�û��ջ�����£�',
   orderId            VARCHAR(20)  NOT NULL                  COMMENT '������(2018080110034455)',
   waybillState       VARCHAR(2)   NOT NULL                  COMMENT '�˵�״̬��0-������ 1-������ 2-��ǩ�� 3-��ǩ�գ�'
);

DROP TABLE tbl_logistics_info;
/*������Ϣ��*/
CREATE TABLE tbl_logistics_info
(
   id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   waybillId          VARCHAR(20)  NOT NULL                  COMMENT '�˵��ţ�ʱ���+��������ҵ���������ź���λ��2018080110034455��',
   updateDate         VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��',
   submitUser         VARCHAR(5)   NOT NULL                  COMMENT '�ύ��',
   location           VARCHAR(20)  NOT NULL                  COMMENT '�ص�',
   content            VARCHAR(80)  NOT NULL                  COMMENT '����'
);

DROP TABLE tbl_news_info;
/*��Ѷ��Ϣ��*/
CREATE TABLE tbl_news_info
(
   id                INTEGER(4)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name              VARCHAR(20)  NOT NULL                  COMMENT '�û�����',
   title             VARCHAR(50)  NOT NULL                  COMMENT '����',
   type              VARCHAR(10)  NOT NULL                  COMMENT '���ͣ�������ҵ��ú̿�۸��г�������������ߣ�',
   reviewState       INTEGER(3)   NOT NULL                  COMMENT '0-����� 1-ͨ�� 2-δͨ��',
   createDate        VARCHAR(20)  NOT NULL                  COMMENT '����ʱ��',
   content           VARCHAR(1000)  NOT NULL                COMMENT '����'
);

DROP TABLE tbl_ads;
/*�����Ϣ��*/
CREATE TABLE tbl_ads
(
   id                 INTEGER(4)      AUTO_INCREMENT NOT NULL PRIMARY KEY, 
   companyId          VARCHAR(30)     NOT NULL               COMMENT '��ҵ��������',
   position           INTEGER(1) 	  NOT NULL               COMMENT '���λ 1-4',	
   email              VARCHAR(30)     NOT NULL               COMMENT '����',
   adsImgPath         VARCHAR(45)     NOT NULL               COMMENT '���ͼƬ���·����/imgs/ads/��ҵ��������+ʱ�����',
   adsURL             VARCHAR(100)    NOT NULL               COMMENT '��泬����ַ',
   note               VARCHAR(200)    NOT NULL               COMMENT '��ע',
   releaseDate        VARCHAR(20)     NOT NULL               COMMENT '���Ͷ��ʱ��ʱ��',
   endDate            VARCHAR(20)     NOT NULL               COMMENT '����ֹʱ��',
   reviewState        INTEGER(3)      NOT NULL               COMMENT '0-����� 1-ͨ�� 2-δͨ��'
);

DROP TABLE tbl_company_info;
/*��ҵ��Ϣ��*/
CREATE TABLE tbl_company_info
(
   id INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
   companyId          VARCHAR(30) NOT NULL                COMMENT '��ҵ��������',
   companyName        VARCHAR(30) NOT NULL                COMMENT '��ҵ����',
   legalPerson        VARCHAR(10) NOT NULL                COMMENT '����',
   phoneNumber        VARCHAR(20) NOT NULL                COMMENT '��ϵ��ʽ',
   bankAccount        VARCHAR(30) NOT NULL                COMMENT '�����˻�',
   openLicenseId      VARCHAR(30) NOT NULL                COMMENT 'Ӫҵִ��',
   openLicensePath    VARCHAR(60) NOT NULL                COMMENT 'Ӫҵִ�մ��·����/imgs/openLicense/��ҵ��������+ʱ�����',
   taxRegisterId      VARCHAR(30) NOT NULL                COMMENT '˰��ǼǺ�',
   reviewState        INTEGER(3)  NOT NULL                COMMENT '0-����� 1-ͨ�� 2-δͨ��'
);
INSERT INTO tbl_company_info(companyId,companyName,legalPerson,phoneNumber,bankAccount,openLicenseId,openLicensePath,taxRegisterId,reviewState) VALUES('914403003350295935','��������Ʒ�е��ӿƼ����޹�˾','�����','15922554689','','440306112458177','/imgs/company201807311544.jpg','310114580607617','1');

DROP TABLE system_users;
/*ϵͳ�û�*/
CREATE TABLE system_users
(
   id INTEGER(4) AUTO_INCREMENT   NOT NULL PRIMARY KEY,
   NAME                           VARCHAR(20) NOT NULL                COMMENT '�û�����',
   PASSWORD                       VARCHAR(20) NOT NULL                COMMENT '����',
   LEVEL                          INTEGER(2) NOT NULL                 COMMENT '0-���� 1-����Ա 2-��Ա',
   permission                     VARCHAR(10) NOT NULL                COMMENT 'Ȩ�ޣ�0-��������Ա 1-��Ϣ��� 2-�� 3-���� 4-���� 5-��Ѷ����',
   companyId                      VARCHAR(30) NOT NULL                COMMENT '��ҵ��������',
   isRemember                     BOOLEAN NOT NULL                    COMMENT '��ס��',
   loginState                     BOOLEAN NOT NULL                    COMMENT '��¼״̬��true-���� false-���ߣ�'
);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('admin','123456','0', '0,1,2,3,4','',FALSE,FALSE);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('guest','123456','1', '1,2,3,4','',FALSE,FALSE);
INSERT INTO system_users(NAME,PASSWORD,LEVEL,permission,companyId,isRemember,loginState) VALUES('test','1234','2', '3','914403003350295935',FALSE,FALSE);

DROP TABLE tbl_static_logistics_price;
/*�����۸���Ϣ��*/
CREATE TABLE tbl_static_logistics_price
(
    id                 INTEGER(4) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    waybillCompanyId   VARCHAR(30)  NOT NULL                  COMMENT '��ҵ��������',
    startingPlace      VARCHAR(20)  NOT NULL                  COMMENT '��ʼ��', 
    destination        VARCHAR(20)  NOT NULL                  COMMENT 'Ŀ�ĵ�', 
    weight             VARCHAR(10)  NOT NULL                  COMMENT '������>=3000�����',
    price              INTEGER(4)   NOT NULL                  COMMENT '�۸�'
);
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '<=6', '38'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '>=6', '36'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '<=3', '37'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '>=3', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '<=2', '38'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '����', '>=2', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '�Ϻ�', '<=4', '33'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '�Ϻ�', '>=4', '30'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '�żҸ�', '<=3', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91130302MA07RJW223', '�ػʵ�', '�żҸ�', '>=3', '32'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '���', '�Ϻ�', '<=2', '33'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '���', '�Ϻ�', '>=2', '35'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '���', '��', '<=2', '44'); 
INSERT INTO `gdce`.`tbl_static_logistics_price` (`waybillCompanyId`, `startingPlace`, `destination`, `weight`, `price`) VALUES ('91120222MA0699R67U', '���', '��', '>=2', '40'); 

INSERT INTO akapp.`dim_node` VALUES (null, 'CREDIT_LEVEL', '4', 'D', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'CREDIT_LEVEL', '5', 'E', NULL, NULL);

UPDATE  akapp.`dim_node` SET NODE_NAME = 'A' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '1';
UPDATE  akapp.`dim_node` SET NODE_NAME = 'B' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '2';
UPDATE  akapp.`dim_node` SET NODE_NAME = 'C' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '3';


UPDATE  akapp.`dim_node` SET NODE_NAME = '质押股权所属企业征信报告' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '26';
UPDATE  akapp.`dim_node` SET NODE_NAME = '股权出质人本人的征信报告' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '27';
UPDATE  akapp.`dim_node` SET NODE_NAME = '质押股权所属企业公司章程' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '28';
UPDATE  akapp.`dim_node` SET NODE_NAME = '质押股权所属企业验资报告' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '29';
UPDATE  akapp.`dim_node` SET NODE_NAME = '股权出质人本人身份证正反面复印件' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '30';
UPDATE  akapp.`dim_node` SET NODE_NAME = '担保方（质权人）个人征信报告' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '31';
UPDATE  akapp.`dim_node` SET NODE_NAME = '担保方（质权人）个人资产（若个人名下有企业，另提供相关企业资产）' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '32';
UPDATE  akapp.`dim_node` SET NODE_NAME = '担保方（质权人）个人身份证正反面复印件' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '33';
UPDATE  akapp.`dim_node` SET NODE_NAME = '出质方股权质押给质权方的所有资料' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '34';
UPDATE  akapp.`dim_node` SET NODE_NAME = '办理成功后，由工商部门出具的股权出质证明' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '35';
UPDATE  akapp.`dim_node` SET NODE_NAME = '出质人、质权人身份证原件、复印件，本人现场签字' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '36';
UPDATE  akapp.`dim_node` SET NODE_NAME = '《股权出质设立登记申请书》' WHERE TREE_NO = 'FILE_TYPE' AND NODE_NO = '37';

INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '39', '质押合同原件-双方盖章签字后', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '40', '财务报表', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '41', '公司章程', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '42', '验资报告', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '43', '企业征信报告', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '44', '对公流水', NULL, NULL);
INSERT INTO akapp.`dim_node` VALUES (null, 'FILE_TYPE', '45', '个人征信报告（法人/实际控制人）', NULL, NULL);

INSERT INTO akweb.`dim_node` VALUES (null, 'CREDIT_LEVEL', '4', 'D', NULL, NULL);
INSERT INTO akweb.`dim_node` VALUES (null, 'CREDIT_LEVEL', '5', 'E', NULL, NULL);


UPDATE  akweb.`dim_node` SET NODE_NAME = 'A' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '1';
UPDATE  akweb.`dim_node` SET NODE_NAME = 'B' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '2';
UPDATE  akweb.`dim_node` SET NODE_NAME = 'C' WHERE TREE_NO = 'CREDIT_LEVEL' AND NODE_NO = '3';


INSERT INTO `chatmessage`.`pay_mob_chat_message` VALUES ('1', 1,NULL, 'whom you want to transfer ?', 1, NULL, NULL);
INSERT INTO `chatmessage`.`pay_mob_chat_message` VALUES ('2', 1,NULL, 'Enter his/her mobile number ?', 2, NULL, NULL);
INSERT INTO `chatmessage`.`pay_mob_chat_message` VALUES ('3', 1,NULL, 'This mobile number is linked with this \"34856734535\" now enter amount in rs ?', '3', NULL, NULL);
INSERT INTO `chatmessage`.`pay_mob_chat_message` VALUES ('5', 1,NULL, 'You are sending {1}rs to \"34856734535\". Please confirm ?', 4, NULL, NULL);

INSERT INTO `chatmessage`.`pay_mob_chat_category` (`id`, `categoryDiscription`, `categoryName`, `createdBy`) VALUES ('1', 'Do you want to send money?', 'send_money', '1');
INSERT INTO `chatmessage`.`pay_mob_chat_category` (`id`, `categoryDiscription`, `categoryName`, `createdBy`) VALUES ('2', 'Do you want to create or select bucketList?', 'bucket_list', '1');
INSERT INTO `chatmessage`.`pay_mob_chat_category` (`id`, `categoryDiscription`, `categoryName`, `createdBy`) VALUES ('3', 'For loan and Offer', 'loan_offer', '1');
INSERT INTO `chatmessage`.`pay_mob_chat_category` (`id`, `categoryDiscription`, `categoryName`, `createdBy`) VALUES ('4', 'General Banking', 'gen_banking', '1');
update chatmessage.pay_mob_chat_category set categoryId = '1' where id ='1';
update chatmessage.pay_mob_chat_category set categoryId = '2' where id ='2';
update chatmessage.pay_mob_chat_category set categoryId = '3' where id ='3';
update chatmessage.pay_mob_chat_category set categoryId = '4' where id ='4';

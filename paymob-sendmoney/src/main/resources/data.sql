

insert into pay_mob_bank (bank_id, bank_name, bank_code, ifsc_code,currency) values(1001, "HDFC Bank", "HDFCB101", "HDFC3396","INR");
insert into pay_mob_bank (bank_id, bank_name, bank_code, ifsc_code,currency) values(1002, "HDFC Bank", "HDFCB101", "HDFC1397","INR");
insert into pay_mob_bank (bank_id, bank_name, bank_code, ifsc_code,currency) values(1003, "HDFC Bank", "HDFCB101", "HDFC2345","INR");
insert into pay_mob_bank (bank_id, bank_name, bank_code, ifsc_code,currency) values(1004, "HDFC Bank", "HDFCB101", "HDFC2396","INR");
insert into pay_mob_bank (bank_id, bank_name, bank_code, ifsc_code,currency) values(1005,  "HDFC Bank", "HDFCB101", "HDFC1396","INR");

insert into pay_mob_bank_account (account_number, account_balance, first_name, last_name, bank_id) values (56789001, 1054645.10, "Sunil", "Rana", 1001);
insert into pay_mob_bank_account (account_number, account_balance, first_name, last_name, bank_id) values (56789003, 1564345.30, "Rahul", "Bisht", 1005);

insert into pay_mob_mobile_account (mobile_number, name, account_number) values(8010580426, "Sunil Rana",  56789001);
insert into pay_mob_mobile_account (mobile_number, name, account_number) values(7042343918, "Rahul Bisht", 56789003);


select * from pay_mob_mobile_account;

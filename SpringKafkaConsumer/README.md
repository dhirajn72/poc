This application needs mysql tables to run. 

##Create Table:
create table smtpdetails(service_id integer primary key, host varchar(100),port integer,mail_smtp_starttls_enable varchar(50),mail_smtp_auth varchar(50),mail_transport_protocol varchar(50),mail_debug varchar(20),email_template_id integer);


##Insert some values: 

insert into smtpdetails (service_id, host ,port ,mail_smtp_starttls_enable ,mail_smtp_auth ,mail_transport_protocol ,mail_debug ,email_template_id ) values (98, 'smtp.gmail.com',587,'true','true','smtp','true',79);

insert into smtpdetails (service_id, host ,port ,mail_smtp_starttls_enable ,mail_smtp_auth ,mail_transport_protocol ,mail_debug ,email_template_id ) values (97, 'smtp.gmail.com',587,'true','true','smtp','true',78);


##Run the consumer after changing the name of database and table in config file.

##Start Producing from Producer, consumer will consume and send emails to recipients

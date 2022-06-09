create database user_file;
use userfile;
create table user_photo(
                           id int(11) not null auto_increment,
                           firstname varchar(45) default null,
                           lastname varchar(45) default null,
                           photo mediumblob,
                           primary key(id))engine=InnoDB auto_increment=4 default charset=latin1;
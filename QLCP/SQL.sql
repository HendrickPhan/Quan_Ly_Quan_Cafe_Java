use master
use DKy
GO
create table [TKhoan](
[Usename] varchar(20) primary key,
[Password] varchar(20),
)
go
INSERT INTO [TKhoan] ([Usename],[Password]) values ('Loai1','20000')
select *from TKhoan
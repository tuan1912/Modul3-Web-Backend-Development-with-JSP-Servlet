select studentName, subject.subId, subName, mark
from student join mark on mark.studentId = student.studentId
			 join subject on mark.subId = subject.subId
order by studentName asc, mark desc;
select*
from mark
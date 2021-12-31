select student.studentId,studentName, mark, avg(mark)
from student join mark on mark.studentId = student.studentId
group by studentId;
select student.studentId,studentName, mark, avg(mark)
from student join mark on mark.studentId = student.studentId
group by studentId
having avg(mark) = ( 
select max(tableavg.tb)
from (select AVG(Mark)as tb FROM Mark GROUP BY Mark.StudentId) as tableavg);
select student.studentId,studentName, mark, avg(mark)
from student join mark on mark.studentId = student.studentId
group by studentId
having avg(mark) >= all(select avg(mark) from mark group by studentId);



select *
from mark;
select *
from subject where credit >= all(select credit from subject);
select max(credit), subName
from subject;
select  *
from subject
having credit = (select max(credit) from subject);
select mark,mark.subId, subName
from mark join subject on mark.subId= subject.subId
where mark>=all(select mark from mark)
group by subId
order by subId;
select *
from mark;
select avg(mark), student.studentId, studentName
from student join mark on mark.studentId = student.studentId
group by student.studentId
order by avg(mark);
-- TÌm điểm thi cao thứ 3:


package org.choongang.student.mapper;
import org.choongang.student.controllers.SearchSubject;
import org.choongang.student.entities.Subject;

import java.util.List;

public interface SubjectMapper {
    List<Subject> getList(SearchSubject search);
    List<Subject> getListAll();
    Subject get(long subCode);
    long getTotal(SearchSubject search);
    int exist(String userId);
    int register(Subject member);
    int modify(Subject member);
    int delete(String userId);
}
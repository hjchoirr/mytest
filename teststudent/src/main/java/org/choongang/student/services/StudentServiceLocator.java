package org.choongang.student.services;

import org.choongang.global.AbstractServiceLocator;
import org.choongang.global.Menu;
import org.choongang.global.Service;
import org.choongang.global.ServiceLocator;
import org.choongang.global.configs.DBConn;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.mapper.SubjectMapper;

public class StudentServiceLocator extends AbstractServiceLocator {

    private static ServiceLocator instance;

    public static ServiceLocator getInstance() {
        if (instance == null) {
            instance = new StudentServiceLocator();
        }

        return instance;
    }

    public SubjectMapper SubjectMapper() {
        return DBConn.getSession().getMapper(SubjectMapper.class);
    }

    @Override
    public Service find(Menu menu) {
        System.out.println("**StudentServiceLocator-find(" + menu + ")");
        Service service = services.get(menu);
        if (service != null) {
            return service;
        }

        if (menu instanceof StudentMenu) { // 과목, 학생, 성적
            StudentMenu studentMenu = (StudentMenu)menu;
            switch (studentMenu) {
                case SUBJECTS: service = new SubjectService(SubjectMapper()); break;
                case STUDENTS:
                case SCORES: service = new SubjectService(SubjectMapper()); break;
            }

        } else { // 주메뉴

        }

        services.put(menu, service);

        return service;
    }
}
package com.freshfish.telisawebmanagement.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.freshfish.telisawebmanagement.entity.StudentQueryParam;
import com.freshfish.telisawebmanagement.entity.Student;
import java.util.List;
import java.util.Map;


@Mapper
public interface StudentMapper {
    @Select("select count(*) from student")
    Long getTotal();

    List<Student> getList(StudentQueryParam param);

    void deleteByIds(Integer[] ids);

    void insert(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateVoilation(Student student);

    @MapKey("name")
    List<Map<String, Object>> countStudentDegreeData();

    @MapKey("name")
    List<Map<String, Object>> countStudentData();
}

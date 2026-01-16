package com.freshfish.telisawebmanagement.mapper;

import com.freshfish.telisawebmanagement.entity.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import com.freshfish.telisawebmanagement.entity.Emp;
import java.util.Map;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    // 查询员工总数
    @Select("select count(*) from emp e left join dept d on e.dept_id=d.id")
    Long getTotal();

    // 查询员工列表
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id order by e.update_time desc limit #{start},#{pageSize}")
//    List<Emp> getList(Integer start, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    List<Emp> getList(EmpQueryParam empQueryParam);

    void insert(Emp emp);

    void deleteByIds(Integer[] ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    List<Emp> list();
}

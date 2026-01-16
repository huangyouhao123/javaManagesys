package com.freshfish.telisawebmanagement.service.impl;

import com.freshfish.telisawebmanagement.entity.*;
import com.freshfish.telisawebmanagement.mapper.EmpExprMapper;
import com.freshfish.telisawebmanagement.mapper.EmpMapper;
import com.freshfish.telisawebmanagement.service.EmpLogService;
import com.freshfish.telisawebmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpLogService empLogService;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam){
        Long total = empMapper.getTotal();
        Integer start=(empQueryParam.getPage()-1)*empQueryParam.getPageSize();
        empQueryParam.setStart(start);
        List<Emp> rows = empMapper.getList(empQueryParam);
        PageResult<Emp> pageResult=new PageResult<Emp>();
        pageResult.setTotal(total);
        pageResult.setRows(rows);
        return pageResult;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(Emp emp){
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            List<EmpExpr>exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                exprList.forEach(expr->{
                    expr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            EmpLog empLog =new EmpLog(null, LocalDateTime.now(), "保存员工信息："+emp);
            empLogService.insertLog(empLog);
        }


    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteByIds(Integer[] ids){
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByIds(ids);
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        empExprMapper.deleteByIds(new Integer[]{emp.getId()});
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            exprList.forEach(expr->{
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }
    /*
    * 获取员工列表
     */
    @Override
    public List<Emp> list() {
        return empMapper.list();
    }
}

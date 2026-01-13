package com.freshfish.telisawebmanagement.mapper;

import com.freshfish.telisawebmanagement.entity.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 员工工作经历
@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);
}

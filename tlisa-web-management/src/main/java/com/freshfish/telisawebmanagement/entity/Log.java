package com.freshfish.telisawebmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 操作日志实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    /**
     * 日志ID（主键）
     */
    private Integer id;

    /**
     * 操作人ID（关联员工表）
     */
    private Integer operateEmpId;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 班级名称（根据JSON字段，可能是业务关联的班级）
     */
    private String className;

    /**
     * 控制器类名（如"controller.DeptController"）
     */
    private String controllerName;

    /**
     * 方法名（如"add"）
     */
    private String methodName;

    /**
     * 方法参数（JSON格式字符串）
     */
    private String methodParams;

    /**
     * 返回值（JSON格式字符串）
     */
    private String returnValue;

    /**
     * 接口耗时（毫秒）
     */
    private Integer costTime;

    /**
     * 操作人姓名（关联员工表的姓名）
     */
    private String operateEmpName;
}

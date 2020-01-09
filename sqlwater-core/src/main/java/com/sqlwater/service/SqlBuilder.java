package com.sqlwater.service;

import com.sqlwater.context.Column;
import com.sqlwater.context.Table;
import com.sqlwater.context.model.Condition;

import java.util.List;
import java.util.Map;

/**
 * @Date 2020/1/7 11:35
 * @Version 1.0
 */
public class SqlBuilder {
    public String buildQuerySql(Table table, CommonExample commonExample){
        StringBuffer sql = new StringBuffer();
        sql.append(" select");
        if (commonExample.distinct)sql.append(" distinct");
        for (Column column : table.getColumns()) {
            sql.append(" "+ column.getName() + ",");
        }
        sql.append(" from "+table.getTableName());
        sql.append(" where ");
        if(commonExample.oredCriteria!=null && commonExample.oredCriteria.size()>0) {
            //取第一条
            //其余的条件
            for (int i = 1; i < commonExample.oredCriteria.size(); i++) {
                sql.append(" or");
                CommonExample.Criteria criteria = commonExample.oredCriteria.get(i);
                for (CommonExample.Criterion criterion : criteria.criteria) {
                    if (criterion.isNoValue()) {
                        sql.append(" and " + criterion.getCondition());
                    }
                    if (criterion.isSingleValue()) {
                        sql.append(" and " + criterion.getCondition() + criterion.getValue());
                    }
                    if (criterion.isBetweenValue()) {
                        sql.append(" and " + criterion.getCondition() + criterion.getValue() + "and" + criterion.getSecondValue());
                    }
                    if (criterion.isListValue()) {
                        sql.append(" and " + criterion.getCondition());
                        //TODO
                    }
                }
            }
        }
        return sql.toString();
    }

    public static String buildQuerySql(Table table, List<Condition> conditions){
        StringBuffer sql = new StringBuffer("select ");
        for (Column column : table.getColumns()) {
            sql.append(" "+ column.getName() + ",");
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(" from "+table.getTableName());
        if(conditions!=null && conditions.size()>0){
            sql.append(" where ");
            for(int i=0;i<conditions.size();i++){
                if(i!=0)sql.append(" and");
                sql.append(" " + conditions.get(i).columnName +conditions.get(i).getOperation()+"'"+conditions.get(i).getValue()+"'");
            }
        }
        return sql.toString();
    }
}

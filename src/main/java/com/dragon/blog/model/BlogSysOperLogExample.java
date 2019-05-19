package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogSysOperLogExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysOperLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOperIdIsNull() {
            addCriterion("oper_id is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("oper_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(Integer value) {
            addCriterion("oper_id =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(Integer value) {
            addCriterion("oper_id <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(Integer value) {
            addCriterion("oper_id >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oper_id >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(Integer value) {
            addCriterion("oper_id <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(Integer value) {
            addCriterion("oper_id <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<Integer> values) {
            addCriterion("oper_id in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<Integer> values) {
            addCriterion("oper_id not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(Integer value1, Integer value2) {
            addCriterion("oper_id between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oper_id not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Integer value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Integer value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Integer value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Integer value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Integer value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Integer> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Integer> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Integer value1, Integer value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIsNull() {
            addCriterion("operator_type is null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIsNotNull() {
            addCriterion("operator_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeEqualTo(Integer value) {
            addCriterion("operator_type =", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotEqualTo(Integer value) {
            addCriterion("operator_type <>", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThan(Integer value) {
            addCriterion("operator_type >", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operator_type >=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThan(Integer value) {
            addCriterion("operator_type <", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operator_type <=", value, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeIn(List<Integer> values) {
            addCriterion("operator_type in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotIn(List<Integer> values) {
            addCriterion("operator_type not in", values, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeBetween(Integer value1, Integer value2) {
            addCriterion("operator_type between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperatorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operator_type not between", value1, value2, "operatorType");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNull() {
            addCriterion("oper_name is null");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNotNull() {
            addCriterion("oper_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperNameEqualTo(String value) {
            addCriterion("oper_name =", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotEqualTo(String value) {
            addCriterion("oper_name <>", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThan(String value) {
            addCriterion("oper_name >", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThanOrEqualTo(String value) {
            addCriterion("oper_name >=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThan(String value) {
            addCriterion("oper_name <", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThanOrEqualTo(String value) {
            addCriterion("oper_name <=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLike(String value) {
            addCriterion("oper_name like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotLike(String value) {
            addCriterion("oper_name not like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameIn(List<String> values) {
            addCriterion("oper_name in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotIn(List<String> values) {
            addCriterion("oper_name not in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameBetween(String value1, String value2) {
            addCriterion("oper_name between", value1, value2, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotBetween(String value1, String value2) {
            addCriterion("oper_name not between", value1, value2, "operName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andOperUrlIsNull() {
            addCriterion("oper_url is null");
            return (Criteria) this;
        }

        public Criteria andOperUrlIsNotNull() {
            addCriterion("oper_url is not null");
            return (Criteria) this;
        }

        public Criteria andOperUrlEqualTo(String value) {
            addCriterion("oper_url =", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotEqualTo(String value) {
            addCriterion("oper_url <>", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlGreaterThan(String value) {
            addCriterion("oper_url >", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlGreaterThanOrEqualTo(String value) {
            addCriterion("oper_url >=", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLessThan(String value) {
            addCriterion("oper_url <", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLessThanOrEqualTo(String value) {
            addCriterion("oper_url <=", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlLike(String value) {
            addCriterion("oper_url like", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotLike(String value) {
            addCriterion("oper_url not like", value, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlIn(List<String> values) {
            addCriterion("oper_url in", values, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotIn(List<String> values) {
            addCriterion("oper_url not in", values, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlBetween(String value1, String value2) {
            addCriterion("oper_url between", value1, value2, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperUrlNotBetween(String value1, String value2) {
            addCriterion("oper_url not between", value1, value2, "operUrl");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNull() {
            addCriterion("oper_ip is null");
            return (Criteria) this;
        }

        public Criteria andOperIpIsNotNull() {
            addCriterion("oper_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOperIpEqualTo(String value) {
            addCriterion("oper_ip =", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotEqualTo(String value) {
            addCriterion("oper_ip <>", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThan(String value) {
            addCriterion("oper_ip >", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpGreaterThanOrEqualTo(String value) {
            addCriterion("oper_ip >=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThan(String value) {
            addCriterion("oper_ip <", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLessThanOrEqualTo(String value) {
            addCriterion("oper_ip <=", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpLike(String value) {
            addCriterion("oper_ip like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotLike(String value) {
            addCriterion("oper_ip not like", value, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpIn(List<String> values) {
            addCriterion("oper_ip in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotIn(List<String> values) {
            addCriterion("oper_ip not in", values, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpBetween(String value1, String value2) {
            addCriterion("oper_ip between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperIpNotBetween(String value1, String value2) {
            addCriterion("oper_ip not between", value1, value2, "operIp");
            return (Criteria) this;
        }

        public Criteria andOperLocationIsNull() {
            addCriterion("oper_location is null");
            return (Criteria) this;
        }

        public Criteria andOperLocationIsNotNull() {
            addCriterion("oper_location is not null");
            return (Criteria) this;
        }

        public Criteria andOperLocationEqualTo(String value) {
            addCriterion("oper_location =", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotEqualTo(String value) {
            addCriterion("oper_location <>", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationGreaterThan(String value) {
            addCriterion("oper_location >", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationGreaterThanOrEqualTo(String value) {
            addCriterion("oper_location >=", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLessThan(String value) {
            addCriterion("oper_location <", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLessThanOrEqualTo(String value) {
            addCriterion("oper_location <=", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationLike(String value) {
            addCriterion("oper_location like", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotLike(String value) {
            addCriterion("oper_location not like", value, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationIn(List<String> values) {
            addCriterion("oper_location in", values, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotIn(List<String> values) {
            addCriterion("oper_location not in", values, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationBetween(String value1, String value2) {
            addCriterion("oper_location between", value1, value2, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperLocationNotBetween(String value1, String value2) {
            addCriterion("oper_location not between", value1, value2, "operLocation");
            return (Criteria) this;
        }

        public Criteria andOperParamIsNull() {
            addCriterion("oper_param is null");
            return (Criteria) this;
        }

        public Criteria andOperParamIsNotNull() {
            addCriterion("oper_param is not null");
            return (Criteria) this;
        }

        public Criteria andOperParamEqualTo(String value) {
            addCriterion("oper_param =", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamNotEqualTo(String value) {
            addCriterion("oper_param <>", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamGreaterThan(String value) {
            addCriterion("oper_param >", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamGreaterThanOrEqualTo(String value) {
            addCriterion("oper_param >=", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamLessThan(String value) {
            addCriterion("oper_param <", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamLessThanOrEqualTo(String value) {
            addCriterion("oper_param <=", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamLike(String value) {
            addCriterion("oper_param like", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamNotLike(String value) {
            addCriterion("oper_param not like", value, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamIn(List<String> values) {
            addCriterion("oper_param in", values, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamNotIn(List<String> values) {
            addCriterion("oper_param not in", values, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamBetween(String value1, String value2) {
            addCriterion("oper_param between", value1, value2, "operParam");
            return (Criteria) this;
        }

        public Criteria andOperParamNotBetween(String value1, String value2) {
            addCriterion("oper_param not between", value1, value2, "operParam");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNull() {
            addCriterion("error_msg is null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIsNotNull() {
            addCriterion("error_msg is not null");
            return (Criteria) this;
        }

        public Criteria andErrorMsgEqualTo(String value) {
            addCriterion("error_msg =", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotEqualTo(String value) {
            addCriterion("error_msg <>", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThan(String value) {
            addCriterion("error_msg >", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgGreaterThanOrEqualTo(String value) {
            addCriterion("error_msg >=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThan(String value) {
            addCriterion("error_msg <", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLessThanOrEqualTo(String value) {
            addCriterion("error_msg <=", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgLike(String value) {
            addCriterion("error_msg like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotLike(String value) {
            addCriterion("error_msg not like", value, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgIn(List<String> values) {
            addCriterion("error_msg in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotIn(List<String> values) {
            addCriterion("error_msg not in", values, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgBetween(String value1, String value2) {
            addCriterion("error_msg between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andErrorMsgNotBetween(String value1, String value2) {
            addCriterion("error_msg not between", value1, value2, "errorMsg");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
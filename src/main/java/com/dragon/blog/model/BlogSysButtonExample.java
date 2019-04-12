package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogSysButtonExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysButtonExample() {
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

        public Criteria andButtonIdIsNull() {
            addCriterion("button_id is null");
            return (Criteria) this;
        }

        public Criteria andButtonIdIsNotNull() {
            addCriterion("button_id is not null");
            return (Criteria) this;
        }

        public Criteria andButtonIdEqualTo(String value) {
            addCriterion("button_id =", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdNotEqualTo(String value) {
            addCriterion("button_id <>", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdGreaterThan(String value) {
            addCriterion("button_id >", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdGreaterThanOrEqualTo(String value) {
            addCriterion("button_id >=", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdLessThan(String value) {
            addCriterion("button_id <", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdLessThanOrEqualTo(String value) {
            addCriterion("button_id <=", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdLike(String value) {
            addCriterion("button_id like", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdNotLike(String value) {
            addCriterion("button_id not like", value, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdIn(List<String> values) {
            addCriterion("button_id in", values, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdNotIn(List<String> values) {
            addCriterion("button_id not in", values, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdBetween(String value1, String value2) {
            addCriterion("button_id between", value1, value2, "buttonId");
            return (Criteria) this;
        }

        public Criteria andButtonIdNotBetween(String value1, String value2) {
            addCriterion("button_id not between", value1, value2, "buttonId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRightsNameIsNull() {
            addCriterion("rights_name is null");
            return (Criteria) this;
        }

        public Criteria andRightsNameIsNotNull() {
            addCriterion("rights_name is not null");
            return (Criteria) this;
        }

        public Criteria andRightsNameEqualTo(String value) {
            addCriterion("rights_name =", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameNotEqualTo(String value) {
            addCriterion("rights_name <>", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameGreaterThan(String value) {
            addCriterion("rights_name >", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameGreaterThanOrEqualTo(String value) {
            addCriterion("rights_name >=", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameLessThan(String value) {
            addCriterion("rights_name <", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameLessThanOrEqualTo(String value) {
            addCriterion("rights_name <=", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameLike(String value) {
            addCriterion("rights_name like", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameNotLike(String value) {
            addCriterion("rights_name not like", value, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameIn(List<String> values) {
            addCriterion("rights_name in", values, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameNotIn(List<String> values) {
            addCriterion("rights_name not in", values, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameBetween(String value1, String value2) {
            addCriterion("rights_name between", value1, value2, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRightsNameNotBetween(String value1, String value2) {
            addCriterion("rights_name not between", value1, value2, "rightsName");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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
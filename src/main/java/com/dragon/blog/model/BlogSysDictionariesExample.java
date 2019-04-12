package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogSysDictionariesExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysDictionariesExample() {
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

        public Criteria andDictionariesIdIsNull() {
            addCriterion("dictionaries_id is null");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdIsNotNull() {
            addCriterion("dictionaries_id is not null");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdEqualTo(String value) {
            addCriterion("dictionaries_id =", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdNotEqualTo(String value) {
            addCriterion("dictionaries_id <>", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdGreaterThan(String value) {
            addCriterion("dictionaries_id >", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdGreaterThanOrEqualTo(String value) {
            addCriterion("dictionaries_id >=", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdLessThan(String value) {
            addCriterion("dictionaries_id <", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdLessThanOrEqualTo(String value) {
            addCriterion("dictionaries_id <=", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdLike(String value) {
            addCriterion("dictionaries_id like", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdNotLike(String value) {
            addCriterion("dictionaries_id not like", value, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdIn(List<String> values) {
            addCriterion("dictionaries_id in", values, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdNotIn(List<String> values) {
            addCriterion("dictionaries_id not in", values, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdBetween(String value1, String value2) {
            addCriterion("dictionaries_id between", value1, value2, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andDictionariesIdNotBetween(String value1, String value2) {
            addCriterion("dictionaries_id not between", value1, value2, "dictionariesId");
            return (Criteria) this;
        }

        public Criteria andNameChIsNull() {
            addCriterion("name_ch is null");
            return (Criteria) this;
        }

        public Criteria andNameChIsNotNull() {
            addCriterion("name_ch is not null");
            return (Criteria) this;
        }

        public Criteria andNameChEqualTo(String value) {
            addCriterion("name_ch =", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotEqualTo(String value) {
            addCriterion("name_ch <>", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThan(String value) {
            addCriterion("name_ch >", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChGreaterThanOrEqualTo(String value) {
            addCriterion("name_ch >=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThan(String value) {
            addCriterion("name_ch <", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLessThanOrEqualTo(String value) {
            addCriterion("name_ch <=", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChLike(String value) {
            addCriterion("name_ch like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotLike(String value) {
            addCriterion("name_ch not like", value, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChIn(List<String> values) {
            addCriterion("name_ch in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotIn(List<String> values) {
            addCriterion("name_ch not in", values, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChBetween(String value1, String value2) {
            addCriterion("name_ch between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameChNotBetween(String value1, String value2) {
            addCriterion("name_ch not between", value1, value2, "nameCh");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNull() {
            addCriterion("name_en is null");
            return (Criteria) this;
        }

        public Criteria andNameEnIsNotNull() {
            addCriterion("name_en is not null");
            return (Criteria) this;
        }

        public Criteria andNameEnEqualTo(String value) {
            addCriterion("name_en =", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotEqualTo(String value) {
            addCriterion("name_en <>", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThan(String value) {
            addCriterion("name_en >", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("name_en >=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThan(String value) {
            addCriterion("name_en <", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLessThanOrEqualTo(String value) {
            addCriterion("name_en <=", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnLike(String value) {
            addCriterion("name_en like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotLike(String value) {
            addCriterion("name_en not like", value, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnIn(List<String> values) {
            addCriterion("name_en in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotIn(List<String> values) {
            addCriterion("name_en not in", values, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnBetween(String value1, String value2) {
            addCriterion("name_en between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andNameEnNotBetween(String value1, String value2) {
            addCriterion("name_en not between", value1, value2, "nameEn");
            return (Criteria) this;
        }

        public Criteria andEncodingIsNull() {
            addCriterion("encoding is null");
            return (Criteria) this;
        }

        public Criteria andEncodingIsNotNull() {
            addCriterion("encoding is not null");
            return (Criteria) this;
        }

        public Criteria andEncodingEqualTo(String value) {
            addCriterion("encoding =", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotEqualTo(String value) {
            addCriterion("encoding <>", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingGreaterThan(String value) {
            addCriterion("encoding >", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingGreaterThanOrEqualTo(String value) {
            addCriterion("encoding >=", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLessThan(String value) {
            addCriterion("encoding <", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLessThanOrEqualTo(String value) {
            addCriterion("encoding <=", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingLike(String value) {
            addCriterion("encoding like", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotLike(String value) {
            addCriterion("encoding not like", value, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingIn(List<String> values) {
            addCriterion("encoding in", values, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotIn(List<String> values) {
            addCriterion("encoding not in", values, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingBetween(String value1, String value2) {
            addCriterion("encoding between", value1, value2, "encoding");
            return (Criteria) this;
        }

        public Criteria andEncodingNotBetween(String value1, String value2) {
            addCriterion("encoding not between", value1, value2, "encoding");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNull() {
            addCriterion("order_by is null");
            return (Criteria) this;
        }

        public Criteria andOrderByIsNotNull() {
            addCriterion("order_by is not null");
            return (Criteria) this;
        }

        public Criteria andOrderByEqualTo(Integer value) {
            addCriterion("order_by =", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotEqualTo(Integer value) {
            addCriterion("order_by <>", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThan(Integer value) {
            addCriterion("order_by >", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_by >=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThan(Integer value) {
            addCriterion("order_by <", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByLessThanOrEqualTo(Integer value) {
            addCriterion("order_by <=", value, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByIn(List<Integer> values) {
            addCriterion("order_by in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotIn(List<Integer> values) {
            addCriterion("order_by not in", values, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByBetween(Integer value1, Integer value2) {
            addCriterion("order_by between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andOrderByNotBetween(Integer value1, Integer value2) {
            addCriterion("order_by not between", value1, value2, "orderBy");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andTasNameIsNull() {
            addCriterion("tas_name is null");
            return (Criteria) this;
        }

        public Criteria andTasNameIsNotNull() {
            addCriterion("tas_name is not null");
            return (Criteria) this;
        }

        public Criteria andTasNameEqualTo(String value) {
            addCriterion("tas_name =", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameNotEqualTo(String value) {
            addCriterion("tas_name <>", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameGreaterThan(String value) {
            addCriterion("tas_name >", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameGreaterThanOrEqualTo(String value) {
            addCriterion("tas_name >=", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameLessThan(String value) {
            addCriterion("tas_name <", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameLessThanOrEqualTo(String value) {
            addCriterion("tas_name <=", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameLike(String value) {
            addCriterion("tas_name like", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameNotLike(String value) {
            addCriterion("tas_name not like", value, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameIn(List<String> values) {
            addCriterion("tas_name in", values, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameNotIn(List<String> values) {
            addCriterion("tas_name not in", values, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameBetween(String value1, String value2) {
            addCriterion("tas_name between", value1, value2, "tasName");
            return (Criteria) this;
        }

        public Criteria andTasNameNotBetween(String value1, String value2) {
            addCriterion("tas_name not between", value1, value2, "tasName");
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
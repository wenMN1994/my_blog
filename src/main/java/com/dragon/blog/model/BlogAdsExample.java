package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BlogAdsExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogAdsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAdIdIsNull() {
            addCriterion("ad_id is null");
            return (Criteria) this;
        }

        public Criteria andAdIdIsNotNull() {
            addCriterion("ad_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdIdEqualTo(Integer value) {
            addCriterion("ad_id =", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotEqualTo(Integer value) {
            addCriterion("ad_id <>", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThan(Integer value) {
            addCriterion("ad_id >", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_id >=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThan(Integer value) {
            addCriterion("ad_id <", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_id <=", value, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdIn(List<Integer> values) {
            addCriterion("ad_id in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotIn(List<Integer> values) {
            addCriterion("ad_id not in", values, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_id between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_id not between", value1, value2, "adId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdIsNull() {
            addCriterion("ad_position_id is null");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdIsNotNull() {
            addCriterion("ad_position_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdEqualTo(Integer value) {
            addCriterion("ad_position_id =", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdNotEqualTo(Integer value) {
            addCriterion("ad_position_id <>", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdGreaterThan(Integer value) {
            addCriterion("ad_position_id >", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_position_id >=", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdLessThan(Integer value) {
            addCriterion("ad_position_id <", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("ad_position_id <=", value, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdIn(List<Integer> values) {
            addCriterion("ad_position_id in", values, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdNotIn(List<Integer> values) {
            addCriterion("ad_position_id not in", values, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("ad_position_id between", value1, value2, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_position_id not between", value1, value2, "adPositionId");
            return (Criteria) this;
        }

        public Criteria andAdFileIsNull() {
            addCriterion("ad_file is null");
            return (Criteria) this;
        }

        public Criteria andAdFileIsNotNull() {
            addCriterion("ad_file is not null");
            return (Criteria) this;
        }

        public Criteria andAdFileEqualTo(String value) {
            addCriterion("ad_file =", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileNotEqualTo(String value) {
            addCriterion("ad_file <>", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileGreaterThan(String value) {
            addCriterion("ad_file >", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileGreaterThanOrEqualTo(String value) {
            addCriterion("ad_file >=", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileLessThan(String value) {
            addCriterion("ad_file <", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileLessThanOrEqualTo(String value) {
            addCriterion("ad_file <=", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileLike(String value) {
            addCriterion("ad_file like", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileNotLike(String value) {
            addCriterion("ad_file not like", value, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileIn(List<String> values) {
            addCriterion("ad_file in", values, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileNotIn(List<String> values) {
            addCriterion("ad_file not in", values, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileBetween(String value1, String value2) {
            addCriterion("ad_file between", value1, value2, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdFileNotBetween(String value1, String value2) {
            addCriterion("ad_file not between", value1, value2, "adFile");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNull() {
            addCriterion("ad_name is null");
            return (Criteria) this;
        }

        public Criteria andAdNameIsNotNull() {
            addCriterion("ad_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdNameEqualTo(String value) {
            addCriterion("ad_name =", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotEqualTo(String value) {
            addCriterion("ad_name <>", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThan(String value) {
            addCriterion("ad_name >", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameGreaterThanOrEqualTo(String value) {
            addCriterion("ad_name >=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThan(String value) {
            addCriterion("ad_name <", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLessThanOrEqualTo(String value) {
            addCriterion("ad_name <=", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameLike(String value) {
            addCriterion("ad_name like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotLike(String value) {
            addCriterion("ad_name not like", value, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameIn(List<String> values) {
            addCriterion("ad_name in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotIn(List<String> values) {
            addCriterion("ad_name not in", values, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameBetween(String value1, String value2) {
            addCriterion("ad_name between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdNameNotBetween(String value1, String value2) {
            addCriterion("ad_name not between", value1, value2, "adName");
            return (Criteria) this;
        }

        public Criteria andAdUrlIsNull() {
            addCriterion("ad_url is null");
            return (Criteria) this;
        }

        public Criteria andAdUrlIsNotNull() {
            addCriterion("ad_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrlEqualTo(String value) {
            addCriterion("ad_url =", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotEqualTo(String value) {
            addCriterion("ad_url <>", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlGreaterThan(String value) {
            addCriterion("ad_url >", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ad_url >=", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLessThan(String value) {
            addCriterion("ad_url <", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLessThanOrEqualTo(String value) {
            addCriterion("ad_url <=", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLike(String value) {
            addCriterion("ad_url like", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotLike(String value) {
            addCriterion("ad_url not like", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlIn(List<String> values) {
            addCriterion("ad_url in", values, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotIn(List<String> values) {
            addCriterion("ad_url not in", values, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlBetween(String value1, String value2) {
            addCriterion("ad_url between", value1, value2, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotBetween(String value1, String value2) {
            addCriterion("ad_url not between", value1, value2, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdStartDateIsNull() {
            addCriterion("ad_start_date is null");
            return (Criteria) this;
        }

        public Criteria andAdStartDateIsNotNull() {
            addCriterion("ad_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andAdStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("ad_start_date =", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ad_start_date <>", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ad_start_date >", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ad_start_date >=", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateLessThan(Date value) {
            addCriterionForJDBCDate("ad_start_date <", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ad_start_date <=", value, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("ad_start_date in", values, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ad_start_date not in", values, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ad_start_date between", value1, value2, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ad_start_date not between", value1, value2, "adStartDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateIsNull() {
            addCriterion("ad_end_date is null");
            return (Criteria) this;
        }

        public Criteria andAdEndDateIsNotNull() {
            addCriterion("ad_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andAdEndDateEqualTo(Date value) {
            addCriterionForJDBCDate("ad_end_date =", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("ad_end_date <>", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateGreaterThan(Date value) {
            addCriterionForJDBCDate("ad_end_date >", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ad_end_date >=", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateLessThan(Date value) {
            addCriterionForJDBCDate("ad_end_date <", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ad_end_date <=", value, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateIn(List<Date> values) {
            addCriterionForJDBCDate("ad_end_date in", values, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("ad_end_date not in", values, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ad_end_date between", value1, value2, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdEndDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ad_end_date not between", value1, value2, "adEndDate");
            return (Criteria) this;
        }

        public Criteria andAdSortIsNull() {
            addCriterion("ad_sort is null");
            return (Criteria) this;
        }

        public Criteria andAdSortIsNotNull() {
            addCriterion("ad_sort is not null");
            return (Criteria) this;
        }

        public Criteria andAdSortEqualTo(Integer value) {
            addCriterion("ad_sort =", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortNotEqualTo(Integer value) {
            addCriterion("ad_sort <>", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortGreaterThan(Integer value) {
            addCriterion("ad_sort >", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_sort >=", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortLessThan(Integer value) {
            addCriterion("ad_sort <", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortLessThanOrEqualTo(Integer value) {
            addCriterion("ad_sort <=", value, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortIn(List<Integer> values) {
            addCriterion("ad_sort in", values, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortNotIn(List<Integer> values) {
            addCriterion("ad_sort not in", values, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortBetween(Integer value1, Integer value2) {
            addCriterion("ad_sort between", value1, value2, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdSortNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_sort not between", value1, value2, "adSort");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIsNull() {
            addCriterion("ad_click_num is null");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIsNotNull() {
            addCriterion("ad_click_num is not null");
            return (Criteria) this;
        }

        public Criteria andAdClickNumEqualTo(Integer value) {
            addCriterion("ad_click_num =", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotEqualTo(Integer value) {
            addCriterion("ad_click_num <>", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumGreaterThan(Integer value) {
            addCriterion("ad_click_num >", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_click_num >=", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumLessThan(Integer value) {
            addCriterion("ad_click_num <", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("ad_click_num <=", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIn(List<Integer> values) {
            addCriterion("ad_click_num in", values, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotIn(List<Integer> values) {
            addCriterion("ad_click_num not in", values, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumBetween(Integer value1, Integer value2) {
            addCriterion("ad_click_num between", value1, value2, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_click_num not between", value1, value2, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNull() {
            addCriterion("position_type is null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIsNotNull() {
            addCriterion("position_type is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTypeEqualTo(Byte value) {
            addCriterion("position_type =", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotEqualTo(Byte value) {
            addCriterion("position_type <>", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThan(Byte value) {
            addCriterion("position_type >", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("position_type >=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThan(Byte value) {
            addCriterion("position_type <", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeLessThanOrEqualTo(Byte value) {
            addCriterion("position_type <=", value, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeIn(List<Byte> values) {
            addCriterion("position_type in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotIn(List<Byte> values) {
            addCriterion("position_type not in", values, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeBetween(Byte value1, Byte value2) {
            addCriterion("position_type between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andPositionTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("position_type not between", value1, value2, "positionType");
            return (Criteria) this;
        }

        public Criteria andDataFlagIsNull() {
            addCriterion("data_flag is null");
            return (Criteria) this;
        }

        public Criteria andDataFlagIsNotNull() {
            addCriterion("data_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDataFlagEqualTo(Byte value) {
            addCriterion("data_flag =", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagNotEqualTo(Byte value) {
            addCriterion("data_flag <>", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagGreaterThan(Byte value) {
            addCriterion("data_flag >", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("data_flag >=", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagLessThan(Byte value) {
            addCriterion("data_flag <", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagLessThanOrEqualTo(Byte value) {
            addCriterion("data_flag <=", value, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagIn(List<Byte> values) {
            addCriterion("data_flag in", values, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagNotIn(List<Byte> values) {
            addCriterion("data_flag not in", values, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagBetween(Byte value1, Byte value2) {
            addCriterion("data_flag between", value1, value2, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andDataFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("data_flag not between", value1, value2, "dataFlag");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
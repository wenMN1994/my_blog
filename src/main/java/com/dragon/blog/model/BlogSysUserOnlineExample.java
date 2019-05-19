package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogSysUserOnlineExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysUserOnlineExample() {
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

        public Criteria andSessionidIsNull() {
            addCriterion("sessionId is null");
            return (Criteria) this;
        }

        public Criteria andSessionidIsNotNull() {
            addCriterion("sessionId is not null");
            return (Criteria) this;
        }

        public Criteria andSessionidEqualTo(String value) {
            addCriterion("sessionId =", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotEqualTo(String value) {
            addCriterion("sessionId <>", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThan(String value) {
            addCriterion("sessionId >", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("sessionId >=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThan(String value) {
            addCriterion("sessionId <", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLessThanOrEqualTo(String value) {
            addCriterion("sessionId <=", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidLike(String value) {
            addCriterion("sessionId like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotLike(String value) {
            addCriterion("sessionId not like", value, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidIn(List<String> values) {
            addCriterion("sessionId in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotIn(List<String> values) {
            addCriterion("sessionId not in", values, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidBetween(String value1, String value2) {
            addCriterion("sessionId between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andSessionidNotBetween(String value1, String value2) {
            addCriterion("sessionId not between", value1, value2, "sessionid");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNull() {
            addCriterion("login_name is null");
            return (Criteria) this;
        }

        public Criteria andLoginNameIsNotNull() {
            addCriterion("login_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoginNameEqualTo(String value) {
            addCriterion("login_name =", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotEqualTo(String value) {
            addCriterion("login_name <>", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThan(String value) {
            addCriterion("login_name >", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("login_name >=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThan(String value) {
            addCriterion("login_name <", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLessThanOrEqualTo(String value) {
            addCriterion("login_name <=", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameLike(String value) {
            addCriterion("login_name like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotLike(String value) {
            addCriterion("login_name not like", value, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameIn(List<String> values) {
            addCriterion("login_name in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotIn(List<String> values) {
            addCriterion("login_name not in", values, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameBetween(String value1, String value2) {
            addCriterion("login_name between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andLoginNameNotBetween(String value1, String value2) {
            addCriterion("login_name not between", value1, value2, "loginName");
            return (Criteria) this;
        }

        public Criteria andIpaddrIsNull() {
            addCriterion("ipaddr is null");
            return (Criteria) this;
        }

        public Criteria andIpaddrIsNotNull() {
            addCriterion("ipaddr is not null");
            return (Criteria) this;
        }

        public Criteria andIpaddrEqualTo(String value) {
            addCriterion("ipaddr =", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotEqualTo(String value) {
            addCriterion("ipaddr <>", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThan(String value) {
            addCriterion("ipaddr >", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrGreaterThanOrEqualTo(String value) {
            addCriterion("ipaddr >=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThan(String value) {
            addCriterion("ipaddr <", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLessThanOrEqualTo(String value) {
            addCriterion("ipaddr <=", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrLike(String value) {
            addCriterion("ipaddr like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotLike(String value) {
            addCriterion("ipaddr not like", value, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrIn(List<String> values) {
            addCriterion("ipaddr in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotIn(List<String> values) {
            addCriterion("ipaddr not in", values, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrBetween(String value1, String value2) {
            addCriterion("ipaddr between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andIpaddrNotBetween(String value1, String value2) {
            addCriterion("ipaddr not between", value1, value2, "ipaddr");
            return (Criteria) this;
        }

        public Criteria andLoginLocationIsNull() {
            addCriterion("login_location is null");
            return (Criteria) this;
        }

        public Criteria andLoginLocationIsNotNull() {
            addCriterion("login_location is not null");
            return (Criteria) this;
        }

        public Criteria andLoginLocationEqualTo(String value) {
            addCriterion("login_location =", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationNotEqualTo(String value) {
            addCriterion("login_location <>", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationGreaterThan(String value) {
            addCriterion("login_location >", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationGreaterThanOrEqualTo(String value) {
            addCriterion("login_location >=", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationLessThan(String value) {
            addCriterion("login_location <", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationLessThanOrEqualTo(String value) {
            addCriterion("login_location <=", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationLike(String value) {
            addCriterion("login_location like", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationNotLike(String value) {
            addCriterion("login_location not like", value, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationIn(List<String> values) {
            addCriterion("login_location in", values, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationNotIn(List<String> values) {
            addCriterion("login_location not in", values, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationBetween(String value1, String value2) {
            addCriterion("login_location between", value1, value2, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andLoginLocationNotBetween(String value1, String value2) {
            addCriterion("login_location not between", value1, value2, "loginLocation");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNull() {
            addCriterion("browser is null");
            return (Criteria) this;
        }

        public Criteria andBrowserIsNotNull() {
            addCriterion("browser is not null");
            return (Criteria) this;
        }

        public Criteria andBrowserEqualTo(String value) {
            addCriterion("browser =", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotEqualTo(String value) {
            addCriterion("browser <>", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThan(String value) {
            addCriterion("browser >", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("browser >=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThan(String value) {
            addCriterion("browser <", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLessThanOrEqualTo(String value) {
            addCriterion("browser <=", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserLike(String value) {
            addCriterion("browser like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotLike(String value) {
            addCriterion("browser not like", value, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserIn(List<String> values) {
            addCriterion("browser in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotIn(List<String> values) {
            addCriterion("browser not in", values, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserBetween(String value1, String value2) {
            addCriterion("browser between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andBrowserNotBetween(String value1, String value2) {
            addCriterion("browser not between", value1, value2, "browser");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIsNull() {
            addCriterion("start_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIsNotNull() {
            addCriterion("start_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimestampEqualTo(Date value) {
            addCriterion("start_timestamp =", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotEqualTo(Date value) {
            addCriterion("start_timestamp <>", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampGreaterThan(Date value) {
            addCriterion("start_timestamp >", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("start_timestamp >=", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampLessThan(Date value) {
            addCriterion("start_timestamp <", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampLessThanOrEqualTo(Date value) {
            addCriterion("start_timestamp <=", value, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampIn(List<Date> values) {
            addCriterion("start_timestamp in", values, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotIn(List<Date> values) {
            addCriterion("start_timestamp not in", values, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampBetween(Date value1, Date value2) {
            addCriterion("start_timestamp between", value1, value2, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andStartTimestampNotBetween(Date value1, Date value2) {
            addCriterion("start_timestamp not between", value1, value2, "startTimestamp");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNull() {
            addCriterion("last_access_time is null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIsNotNull() {
            addCriterion("last_access_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeEqualTo(Date value) {
            addCriterion("last_access_time =", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotEqualTo(Date value) {
            addCriterion("last_access_time <>", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThan(Date value) {
            addCriterion("last_access_time >", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_access_time >=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThan(Date value) {
            addCriterion("last_access_time <", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_access_time <=", value, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeIn(List<Date> values) {
            addCriterion("last_access_time in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotIn(List<Date> values) {
            addCriterion("last_access_time not in", values, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeBetween(Date value1, Date value2) {
            addCriterion("last_access_time between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andLastAccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_access_time not between", value1, value2, "lastAccessTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Integer value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Integer value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Integer value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Integer value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Integer value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Integer> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Integer> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Integer value1, Integer value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
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
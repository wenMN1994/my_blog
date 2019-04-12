package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogSysUserAvatarExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysUserAvatarExample() {
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

        public Criteria andUserPhotoIdIsNull() {
            addCriterion("user_photo_id is null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdIsNotNull() {
            addCriterion("user_photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdEqualTo(String value) {
            addCriterion("user_photo_id =", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdNotEqualTo(String value) {
            addCriterion("user_photo_id <>", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdGreaterThan(String value) {
            addCriterion("user_photo_id >", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_photo_id >=", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdLessThan(String value) {
            addCriterion("user_photo_id <", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdLessThanOrEqualTo(String value) {
            addCriterion("user_photo_id <=", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdLike(String value) {
            addCriterion("user_photo_id like", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdNotLike(String value) {
            addCriterion("user_photo_id not like", value, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdIn(List<String> values) {
            addCriterion("user_photo_id in", values, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdNotIn(List<String> values) {
            addCriterion("user_photo_id not in", values, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdBetween(String value1, String value2) {
            addCriterion("user_photo_id between", value1, value2, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserPhotoIdNotBetween(String value1, String value2) {
            addCriterion("user_photo_id not between", value1, value2, "userPhotoId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("photo is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("photo is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("photo =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("photo <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("photo >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("photo >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("photo <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("photo <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("photo like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("photo not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("photo in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("photo not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("photo between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("photo not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andAvatarOneIsNull() {
            addCriterion("avatar_one is null");
            return (Criteria) this;
        }

        public Criteria andAvatarOneIsNotNull() {
            addCriterion("avatar_one is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarOneEqualTo(String value) {
            addCriterion("avatar_one =", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneNotEqualTo(String value) {
            addCriterion("avatar_one <>", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneGreaterThan(String value) {
            addCriterion("avatar_one >", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_one >=", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneLessThan(String value) {
            addCriterion("avatar_one <", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneLessThanOrEqualTo(String value) {
            addCriterion("avatar_one <=", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneLike(String value) {
            addCriterion("avatar_one like", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneNotLike(String value) {
            addCriterion("avatar_one not like", value, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneIn(List<String> values) {
            addCriterion("avatar_one in", values, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneNotIn(List<String> values) {
            addCriterion("avatar_one not in", values, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneBetween(String value1, String value2) {
            addCriterion("avatar_one between", value1, value2, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarOneNotBetween(String value1, String value2) {
            addCriterion("avatar_one not between", value1, value2, "avatarOne");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoIsNull() {
            addCriterion("avatar_two is null");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoIsNotNull() {
            addCriterion("avatar_two is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoEqualTo(String value) {
            addCriterion("avatar_two =", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoNotEqualTo(String value) {
            addCriterion("avatar_two <>", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoGreaterThan(String value) {
            addCriterion("avatar_two >", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_two >=", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoLessThan(String value) {
            addCriterion("avatar_two <", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoLessThanOrEqualTo(String value) {
            addCriterion("avatar_two <=", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoLike(String value) {
            addCriterion("avatar_two like", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoNotLike(String value) {
            addCriterion("avatar_two not like", value, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoIn(List<String> values) {
            addCriterion("avatar_two in", values, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoNotIn(List<String> values) {
            addCriterion("avatar_two not in", values, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoBetween(String value1, String value2) {
            addCriterion("avatar_two between", value1, value2, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarTwoNotBetween(String value1, String value2) {
            addCriterion("avatar_two not between", value1, value2, "avatarTwo");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeIsNull() {
            addCriterion("avatar_three is null");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeIsNotNull() {
            addCriterion("avatar_three is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeEqualTo(String value) {
            addCriterion("avatar_three =", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeNotEqualTo(String value) {
            addCriterion("avatar_three <>", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeGreaterThan(String value) {
            addCriterion("avatar_three >", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_three >=", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeLessThan(String value) {
            addCriterion("avatar_three <", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeLessThanOrEqualTo(String value) {
            addCriterion("avatar_three <=", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeLike(String value) {
            addCriterion("avatar_three like", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeNotLike(String value) {
            addCriterion("avatar_three not like", value, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeIn(List<String> values) {
            addCriterion("avatar_three in", values, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeNotIn(List<String> values) {
            addCriterion("avatar_three not in", values, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeBetween(String value1, String value2) {
            addCriterion("avatar_three between", value1, value2, "avatarThree");
            return (Criteria) this;
        }

        public Criteria andAvatarThreeNotBetween(String value1, String value2) {
            addCriterion("avatar_three not between", value1, value2, "avatarThree");
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
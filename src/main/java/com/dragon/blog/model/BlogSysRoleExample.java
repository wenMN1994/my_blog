package com.dragon.blog.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogSysRoleExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BlogSysRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRightsIsNull() {
            addCriterion("rights is null");
            return (Criteria) this;
        }

        public Criteria andRightsIsNotNull() {
            addCriterion("rights is not null");
            return (Criteria) this;
        }

        public Criteria andRightsEqualTo(String value) {
            addCriterion("rights =", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotEqualTo(String value) {
            addCriterion("rights <>", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsGreaterThan(String value) {
            addCriterion("rights >", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsGreaterThanOrEqualTo(String value) {
            addCriterion("rights >=", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLessThan(String value) {
            addCriterion("rights <", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLessThanOrEqualTo(String value) {
            addCriterion("rights <=", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLike(String value) {
            addCriterion("rights like", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotLike(String value) {
            addCriterion("rights not like", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsIn(List<String> values) {
            addCriterion("rights in", values, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotIn(List<String> values) {
            addCriterion("rights not in", values, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsBetween(String value1, String value2) {
            addCriterion("rights between", value1, value2, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotBetween(String value1, String value2) {
            addCriterion("rights not between", value1, value2, "rights");
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

        public Criteria andAddRightsIsNull() {
            addCriterion("add_rights is null");
            return (Criteria) this;
        }

        public Criteria andAddRightsIsNotNull() {
            addCriterion("add_rights is not null");
            return (Criteria) this;
        }

        public Criteria andAddRightsEqualTo(String value) {
            addCriterion("add_rights =", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotEqualTo(String value) {
            addCriterion("add_rights <>", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsGreaterThan(String value) {
            addCriterion("add_rights >", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsGreaterThanOrEqualTo(String value) {
            addCriterion("add_rights >=", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsLessThan(String value) {
            addCriterion("add_rights <", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsLessThanOrEqualTo(String value) {
            addCriterion("add_rights <=", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsLike(String value) {
            addCriterion("add_rights like", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotLike(String value) {
            addCriterion("add_rights not like", value, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsIn(List<String> values) {
            addCriterion("add_rights in", values, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotIn(List<String> values) {
            addCriterion("add_rights not in", values, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsBetween(String value1, String value2) {
            addCriterion("add_rights between", value1, value2, "addRights");
            return (Criteria) this;
        }

        public Criteria andAddRightsNotBetween(String value1, String value2) {
            addCriterion("add_rights not between", value1, value2, "addRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsIsNull() {
            addCriterion("del_rights is null");
            return (Criteria) this;
        }

        public Criteria andDelRightsIsNotNull() {
            addCriterion("del_rights is not null");
            return (Criteria) this;
        }

        public Criteria andDelRightsEqualTo(String value) {
            addCriterion("del_rights =", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsNotEqualTo(String value) {
            addCriterion("del_rights <>", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsGreaterThan(String value) {
            addCriterion("del_rights >", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsGreaterThanOrEqualTo(String value) {
            addCriterion("del_rights >=", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsLessThan(String value) {
            addCriterion("del_rights <", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsLessThanOrEqualTo(String value) {
            addCriterion("del_rights <=", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsLike(String value) {
            addCriterion("del_rights like", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsNotLike(String value) {
            addCriterion("del_rights not like", value, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsIn(List<String> values) {
            addCriterion("del_rights in", values, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsNotIn(List<String> values) {
            addCriterion("del_rights not in", values, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsBetween(String value1, String value2) {
            addCriterion("del_rights between", value1, value2, "delRights");
            return (Criteria) this;
        }

        public Criteria andDelRightsNotBetween(String value1, String value2) {
            addCriterion("del_rights not between", value1, value2, "delRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsIsNull() {
            addCriterion("edit_rights is null");
            return (Criteria) this;
        }

        public Criteria andEditRightsIsNotNull() {
            addCriterion("edit_rights is not null");
            return (Criteria) this;
        }

        public Criteria andEditRightsEqualTo(String value) {
            addCriterion("edit_rights =", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotEqualTo(String value) {
            addCriterion("edit_rights <>", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsGreaterThan(String value) {
            addCriterion("edit_rights >", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsGreaterThanOrEqualTo(String value) {
            addCriterion("edit_rights >=", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsLessThan(String value) {
            addCriterion("edit_rights <", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsLessThanOrEqualTo(String value) {
            addCriterion("edit_rights <=", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsLike(String value) {
            addCriterion("edit_rights like", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotLike(String value) {
            addCriterion("edit_rights not like", value, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsIn(List<String> values) {
            addCriterion("edit_rights in", values, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotIn(List<String> values) {
            addCriterion("edit_rights not in", values, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsBetween(String value1, String value2) {
            addCriterion("edit_rights between", value1, value2, "editRights");
            return (Criteria) this;
        }

        public Criteria andEditRightsNotBetween(String value1, String value2) {
            addCriterion("edit_rights not between", value1, value2, "editRights");
            return (Criteria) this;
        }

        public Criteria andCheckRightIsNull() {
            addCriterion("check_right is null");
            return (Criteria) this;
        }

        public Criteria andCheckRightIsNotNull() {
            addCriterion("check_right is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRightEqualTo(String value) {
            addCriterion("check_right =", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightNotEqualTo(String value) {
            addCriterion("check_right <>", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightGreaterThan(String value) {
            addCriterion("check_right >", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightGreaterThanOrEqualTo(String value) {
            addCriterion("check_right >=", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightLessThan(String value) {
            addCriterion("check_right <", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightLessThanOrEqualTo(String value) {
            addCriterion("check_right <=", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightLike(String value) {
            addCriterion("check_right like", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightNotLike(String value) {
            addCriterion("check_right not like", value, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightIn(List<String> values) {
            addCriterion("check_right in", values, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightNotIn(List<String> values) {
            addCriterion("check_right not in", values, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightBetween(String value1, String value2) {
            addCriterion("check_right between", value1, value2, "checkRight");
            return (Criteria) this;
        }

        public Criteria andCheckRightNotBetween(String value1, String value2) {
            addCriterion("check_right not between", value1, value2, "checkRight");
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
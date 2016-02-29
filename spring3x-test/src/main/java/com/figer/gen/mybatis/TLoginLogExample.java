package com.figer.gen.mybatis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLoginLogExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andLoginLogIdIsNull() {
            addCriterion("login_log_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdIsNotNull() {
            addCriterion("login_log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdEqualTo(Integer value) {
            addCriterion("login_log_id =", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdNotEqualTo(Integer value) {
            addCriterion("login_log_id <>", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdGreaterThan(Integer value) {
            addCriterion("login_log_id >", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_log_id >=", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdLessThan(Integer value) {
            addCriterion("login_log_id <", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("login_log_id <=", value, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdIn(List<Integer> values) {
            addCriterion("login_log_id in", values, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdNotIn(List<Integer> values) {
            addCriterion("login_log_id not in", values, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdBetween(Integer value1, Integer value2) {
            addCriterion("login_log_id between", value1, value2, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andLoginLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("login_log_id not between", value1, value2, "loginLogId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIsNull() {
            addCriterion("login_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIsNotNull() {
            addCriterion("login_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeEqualTo(Date value) {
            addCriterion("login_datetime =", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotEqualTo(Date value) {
            addCriterion("login_datetime <>", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeGreaterThan(Date value) {
            addCriterion("login_datetime >", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_datetime >=", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeLessThan(Date value) {
            addCriterion("login_datetime <", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("login_datetime <=", value, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeIn(List<Date> values) {
            addCriterion("login_datetime in", values, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotIn(List<Date> values) {
            addCriterion("login_datetime not in", values, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeBetween(Date value1, Date value2) {
            addCriterion("login_datetime between", value1, value2, "loginDatetime");
            return (Criteria) this;
        }

        public Criteria andLoginDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("login_datetime not between", value1, value2, "loginDatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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
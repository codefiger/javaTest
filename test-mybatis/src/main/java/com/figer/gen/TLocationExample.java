package com.figer.gen;

import java.util.ArrayList;
import java.util.List;

public class TLocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TLocationExample() {
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

        public Criteria andLocationIdIsNull() {
            addCriterion("location_id is null");
            return (Criteria) this;
        }

        public Criteria andLocationIdIsNotNull() {
            addCriterion("location_id is not null");
            return (Criteria) this;
        }

        public Criteria andLocationIdEqualTo(Long value) {
            addCriterion("location_id =", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotEqualTo(Long value) {
            addCriterion("location_id <>", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThan(Long value) {
            addCriterion("location_id >", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("location_id >=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThan(Long value) {
            addCriterion("location_id <", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdLessThanOrEqualTo(Long value) {
            addCriterion("location_id <=", value, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdIn(List<Long> values) {
            addCriterion("location_id in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotIn(List<Long> values) {
            addCriterion("location_id not in", values, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdBetween(Long value1, Long value2) {
            addCriterion("location_id between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andLocationIdNotBetween(Long value1, Long value2) {
            addCriterion("location_id not between", value1, value2, "locationId");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNull() {
            addCriterion("abbr is null");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNotNull() {
            addCriterion("abbr is not null");
            return (Criteria) this;
        }

        public Criteria andAbbrEqualTo(String value) {
            addCriterion("abbr =", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotEqualTo(String value) {
            addCriterion("abbr <>", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThan(String value) {
            addCriterion("abbr >", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("abbr >=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThan(String value) {
            addCriterion("abbr <", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThanOrEqualTo(String value) {
            addCriterion("abbr <=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLike(String value) {
            addCriterion("abbr like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotLike(String value) {
            addCriterion("abbr not like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrIn(List<String> values) {
            addCriterion("abbr in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotIn(List<String> values) {
            addCriterion("abbr not in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrBetween(String value1, String value2) {
            addCriterion("abbr between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotBetween(String value1, String value2) {
            addCriterion("abbr not between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andNameChsIsNull() {
            addCriterion("name_chs is null");
            return (Criteria) this;
        }

        public Criteria andNameChsIsNotNull() {
            addCriterion("name_chs is not null");
            return (Criteria) this;
        }

        public Criteria andNameChsEqualTo(String value) {
            addCriterion("name_chs =", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsNotEqualTo(String value) {
            addCriterion("name_chs <>", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsGreaterThan(String value) {
            addCriterion("name_chs >", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsGreaterThanOrEqualTo(String value) {
            addCriterion("name_chs >=", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsLessThan(String value) {
            addCriterion("name_chs <", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsLessThanOrEqualTo(String value) {
            addCriterion("name_chs <=", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsLike(String value) {
            addCriterion("name_chs like", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsNotLike(String value) {
            addCriterion("name_chs not like", value, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsIn(List<String> values) {
            addCriterion("name_chs in", values, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsNotIn(List<String> values) {
            addCriterion("name_chs not in", values, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsBetween(String value1, String value2) {
            addCriterion("name_chs between", value1, value2, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChsNotBetween(String value1, String value2) {
            addCriterion("name_chs not between", value1, value2, "nameChs");
            return (Criteria) this;
        }

        public Criteria andNameChtIsNull() {
            addCriterion("name_cht is null");
            return (Criteria) this;
        }

        public Criteria andNameChtIsNotNull() {
            addCriterion("name_cht is not null");
            return (Criteria) this;
        }

        public Criteria andNameChtEqualTo(String value) {
            addCriterion("name_cht =", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtNotEqualTo(String value) {
            addCriterion("name_cht <>", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtGreaterThan(String value) {
            addCriterion("name_cht >", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtGreaterThanOrEqualTo(String value) {
            addCriterion("name_cht >=", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtLessThan(String value) {
            addCriterion("name_cht <", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtLessThanOrEqualTo(String value) {
            addCriterion("name_cht <=", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtLike(String value) {
            addCriterion("name_cht like", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtNotLike(String value) {
            addCriterion("name_cht not like", value, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtIn(List<String> values) {
            addCriterion("name_cht in", values, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtNotIn(List<String> values) {
            addCriterion("name_cht not in", values, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtBetween(String value1, String value2) {
            addCriterion("name_cht between", value1, value2, "nameCht");
            return (Criteria) this;
        }

        public Criteria andNameChtNotBetween(String value1, String value2) {
            addCriterion("name_cht not between", value1, value2, "nameCht");
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

        public Criteria andLocationTypeIsNull() {
            addCriterion("location_type is null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNotNull() {
            addCriterion("location_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeEqualTo(Integer value) {
            addCriterion("location_type =", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotEqualTo(Integer value) {
            addCriterion("location_type <>", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThan(Integer value) {
            addCriterion("location_type >", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_type >=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThan(Integer value) {
            addCriterion("location_type <", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("location_type <=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIn(List<Integer> values) {
            addCriterion("location_type in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotIn(List<Integer> values) {
            addCriterion("location_type not in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeBetween(Integer value1, Integer value2) {
            addCriterion("location_type between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("location_type not between", value1, value2, "locationType");
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

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIsNull() {
            addCriterion("is_visible is null");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIsNotNull() {
            addCriterion("is_visible is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisibleEqualTo(Integer value) {
            addCriterion("is_visible =", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotEqualTo(Integer value) {
            addCriterion("is_visible <>", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleGreaterThan(Integer value) {
            addCriterion("is_visible >", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_visible >=", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleLessThan(Integer value) {
            addCriterion("is_visible <", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleLessThanOrEqualTo(Integer value) {
            addCriterion("is_visible <=", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIn(List<Integer> values) {
            addCriterion("is_visible in", values, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotIn(List<Integer> values) {
            addCriterion("is_visible not in", values, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleBetween(Integer value1, Integer value2) {
            addCriterion("is_visible between", value1, value2, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotBetween(Integer value1, Integer value2) {
            addCriterion("is_visible not between", value1, value2, "isVisible");
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
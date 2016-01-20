package com.figer.gen;

public class TLocation {
    private Long locationId;

    private String abbr;

    private String nameChs;

    private String nameCht;

    private String nameEn;

    private Integer locationType;

    private Long parentId;

    private Integer isVisible;

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr == null ? null : abbr.trim();
    }

    public String getNameChs() {
        return nameChs;
    }

    public void setNameChs(String nameChs) {
        this.nameChs = nameChs == null ? null : nameChs.trim();
    }

    public String getNameCht() {
        return nameCht;
    }

    public void setNameCht(String nameCht) {
        this.nameCht = nameCht == null ? null : nameCht.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Integer getLocationType() {
        return locationType;
    }

    public void setLocationType(Integer locationType) {
        this.locationType = locationType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }
}
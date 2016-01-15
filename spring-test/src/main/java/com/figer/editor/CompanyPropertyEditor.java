package com.figer.editor;

import java.beans.PropertyEditorSupport;

import com.figer.entity.Company;

public class CompanyPropertyEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text == null || text.indexOf(",") == -1){  
            throw new IllegalArgumentException("设置的字符串格式不正确");  
        }  
		
		String[] valuesStr = text.split(",");
		Company company = new Company()
				.setId(Integer.parseInt(valuesStr[0]))
				.setName(valuesStr[1]);
		
		//调用父类的setValue()方法设置转换后的属性对象  
		setValue(company);
	}
}

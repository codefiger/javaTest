package com.figer.cxf;

import javax.jws.WebService;
@WebService
public interface Business{
	String echo(String message);
}
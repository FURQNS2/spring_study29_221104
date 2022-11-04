package com.sycompany.std24.dao;

import java.util.ArrayList;

import com.sycompany.std24.dto.ContentDto;

public interface IDao {

	public ArrayList<ContentDto> listDao() ;
	public void writeDao(String mwriter, String mcontent);
	public void deleteDao(String mid);
	public ContentDto mviewDao(String mid);

	public void modifyDao(String mid, String mwriter, String mcontent);
	
}

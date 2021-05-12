package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BoardService {

	//List
	public List<BoardVO> getList(Pager pager) throws Exception;
	//Select
	public BoardVO getSelect(BoardVO boardVO) throws Exception;
	//Insert
	public int setInsert(BoardVO boardVO) throws Exception;
	//Update
	public int setUpdate(BoardVO boardVO) throws Exception;
	//Delete
	public int setDelete(BoardVO boardVO) throws Exception;
}

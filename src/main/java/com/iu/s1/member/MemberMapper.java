package com.iu.s1.member;


public interface MemberMapper {

	public int Join(MemberVO memberVO) throws Exception;
	
	public MemberVO Login(MemberVO memberVO) throws Exception;
	
	public int UnCheck(MemberVO memberVO) throws Exception;
	
	public int setFileInsert(MemberFileVO memberFileVO) throws Exception;
	
	public MemberFileVO memberLoginFile(MemberVO memberVO) throws Exception;
	
	public MemberFileVO getMemberFile(MemberVO memberVO) throws Exception;
	
	public int delete(MemberVO memberVO) throws Exception;
	
	public int update(MemberVO memberVO) throws Exception;
}


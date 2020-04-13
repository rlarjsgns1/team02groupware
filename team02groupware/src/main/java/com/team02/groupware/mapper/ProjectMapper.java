package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.Project;

@Mapper
public interface ProjectMapper {
	//업무 추가
	public int taskInsert(Project project);
	
	//업무리스트별 업무상세정보 조회
	public List<Project> getTaskdetail(String projectCode);
	
	//업무리스트 최근 코드 조회
	public String selectTasklistcode();
	
	//업무리스트추가
	public int tasklistInsert(Project project);
	
	//업무리스트 조회
	public List<Project> selectTasklist(String projectCode);	

	//프로젝트 삭제
	public int projectDelete(String projectCode);
	
	//프로젝트 한개 조회
	public Project selectForProUpdate(String projectCode);
	
	//프로젝트 수정
	public int projectUpdate(Project project);
	
	//프로젝트 추가
	public int projectInsert(Project project);
	
	//프로젝트리스트 페이지네이션
	public int getProjectRowCount();	

	//프로젝트 리스트
	public List<Project> getProjectlist(Map<String, Object> map);


}

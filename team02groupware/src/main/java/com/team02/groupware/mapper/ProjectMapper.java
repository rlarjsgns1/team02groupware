package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.Project;

@Mapper
public interface ProjectMapper {
	
	//프로젝트 한개 조회
	public Project selectForProUpdate(String projectCode);
	
	//프로젝트 수정
	public int projectUpdate(Project project);
	
	//프로젝트 추가
	public int projectInsert(Project project);
	
	//프로젝트 리스트
	public List<Project> getProjectlist(Map<String, Object> map);

	//프로젝트리스트 페이지네이션
	public int getProjectRowCount();	

	//업무리스트추가
	public int tasklistInsert(Project project);
	
	//업무리스트 조회
	public List<Project> selectTasklist(String projectCode);	
}

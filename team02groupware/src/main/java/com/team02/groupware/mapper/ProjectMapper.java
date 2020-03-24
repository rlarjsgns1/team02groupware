package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.Project;

@Mapper
public interface ProjectMapper {
	public int projectInsert(Project project);
	
	public List<Project> getProjectlist(Map<String, Object> map);

	public int getProjectRowCount();	

	public int taskInsert(Project project);
	
	public List<Project> getTasklist();	
}

package com.team02.groupware.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.Project;
import com.team02.groupware.mapper.ProjectMapper;

@Service
@Transactional
public class ProjectService {
	@Autowired
	private ProjectMapper projectMapper;

	
	//업무리스트별 업무상세정보 조회
	public List<Project> getTaskdetail(String tasklistCode){
		List<Project> taskDetail = new ArrayList<Project>();
		taskDetail = projectMapper.getTaskdetail(tasklistCode);
		return taskDetail;
	}
	
	//업무리스트 추가
	public int tasklistInsert(Project project) {
		return projectMapper.tasklistInsert(project);
	}
	
	//업무리스트조회
	public List<Project> selectTasklist(String projectCode){
		
		List<Project> projectList = new ArrayList<Project>();
		projectList = projectMapper.selectTasklist(projectCode);
		
		return projectList;
		
	}
	
	//프로젝트 수정
	public int projectUpdate(Project project) {
		return projectMapper.projectUpdate(project);
	}
	
	//프로젝트 한개 조회
	public Project selectForProUpdate(String projectCode) {
		return projectMapper.selectForProUpdate(projectCode);
	}
	
	
	//프로젝트 추가
	public int projectInsert(Project project) {
		return projectMapper.projectInsert(project);
	}
	
	//프로젝트 리스트 조회
	public Map<String, Object> getProjectlist(int currentPage) {
		// 몇개의 행을 보여줄지
		final int ROW_PER_PAGE = 10;

		// 보여줄 첫번째 페이지번호
		int startPageNum = 1;

		// 보여줄 페이지 개수
		int endPageNum = 10;

		// 페이지6번째부터 startPageNum 변동
		if (currentPage > (endPageNum / 2)) {
			startPageNum = currentPage - ((endPageNum / 2) - 1);
			endPageNum += (startPageNum - 1);
		}

		// limit적용할 StartRow, 상수ROW_PER_PAGE(몇개행)
		Map<String, Object> map = new HashMap<String, Object>();

	
		// 페이지 알고리즘
		int startRow = (currentPage - 1) * ROW_PER_PAGE;

		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);

		// 전체 카운트
		double count = projectMapper.getProjectRowCount();

		// 라스트페이지 = (카운트)/보여줄 행의 개수 ==> 소수점이 있다면 무조건 반올림
		int lastPage = (int) Math.ceil((count / ROW_PER_PAGE));
		projectMapper.getProjectlist(map);
		
		/*
		if(currentPage>=(lastPage-4)) {
			endPageNum = lastPage;
		}
		*/
		
		
		// controller에 전달할 페이지 관련 객체
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("projectList", projectMapper.getProjectlist(map));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);

		return resultMap;
	}
}

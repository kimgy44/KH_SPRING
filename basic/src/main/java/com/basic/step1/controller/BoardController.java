package com.basic.step1.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.basic.step1.logic.BoardLogic;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired(required=false)
	private BoardLogic boardLogic = null;
	/*
	 * dev_web과 basic 비용 계산 해보기
	 * Map 선언만 함 ﻿→ @RequestParam
	 * HashMapBinder가 필요없어짐
	 * ModelAndView도 필요 없음 ﻿→ Model
	 * 리턴타입 : ModelAndView ﻿→ String으로 바뀜
	 */
	
	@GetMapping("boardDelete.sp4")
	public Object boardDelete(@RequestParam Map<String,Object> pMap) {
		logger.info("boardDelete 호출 성공");
		int result = 0;
		result = boardLogic.boardDelete(pMap);
		return "redirect:boardList.sp4";
	}
	
	@GetMapping("boardUpdate.sp4")
	public String boardUpdate(@RequestParam Map<String,Object> pMap) {
		logger.info("boardUpdate 호출 성공");
		int result = 0;
		result = boardLogic.boardUpdate(pMap);
		// jsp-> action(update) -> action(select) --(forward)--> boardList.jsp
		String path = "redirect:boardList.sp4";
		return path;
	}
	
	@GetMapping("boardDetail.sp4")
	public Object boardDetail(Model model, @RequestParam Map<String,Object> pMap) {
		logger.info("boardDetail 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardLogic.boardDetail(pMap);
		model.addAttribute("boardList",boardList);
		return "forward:read.jsp";
	}
	
	@GetMapping("boardList.sp4")
	public String boardList(Model model, @RequestParam Map<String,Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		// 여기 여기... 필요할 때 인스턴스화 해서 호출한다 ﻿→ 게으른 인스턴스화 ﻿→ 스프링 위치 
		//boardLogic = new Board3Logic(); // 주소번지가 다르다  ﻿→ 게으른 인스턴스화이다.
		boardList = boardLogic.boardList(pMap);
		model.addAttribute("boardList",boardList);
		return "forward:boardList.jsp";
	}
	// localhost:9000/step1/board/boardInsert.sp4
	@GetMapping("boardInsert.sp4")
	public String boardInsert( @RequestParam Map<String,Object> pMap, @RequestParam(value="b_file", required=false) MultipartFile b_file) {
		logger.info("boardInsert 호출 성공 : "+pMap);
		// 여기 여기... 필요할 때 인스턴스화 해서 호출한다 ﻿→ 게으른 인스턴스화 ﻿→ 스프링 위치 
		//boardLogic = new Board3Logic(); // 주소번지가 다르다  ﻿→ 게으른 인스턴스화이다.
		int result = 0;
		result = boardLogic.boardInsert(pMap);
		return "redirect:boardList.sp4";
	}
	
	
}

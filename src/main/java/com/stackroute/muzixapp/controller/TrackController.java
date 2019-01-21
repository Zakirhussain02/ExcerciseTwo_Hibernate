package com.stackroute.muzixapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stackroute.muzixapp.dao.TrackDAO;
import com.stackroute.muzixapp.model.Track;

@Controller
@RequestMapping("/")
public class TrackController {

	@Autowired
	private TrackDAO trackDao;

	private Track track = new Track();

	@GetMapping
	public String indexPage(ModelMap model) {
		//model.addAttribute("tracks", trackDao.getAllTracks());
		return "index";
	}
	@GetMapping("userinfo")
	public String addTrack(ModelMap map, @RequestParam("user") String name,@RequestParam("password") String password){
		track.setName(name);
		track.setPassword(password);
		boolean status = trackDao.saveTrack(track);
		if (status) {
			map.addAttribute("username", trackDao.getTrackById(track.getId()));
			return "update";
		} else {
			return "index";
		}

	}
//	public String addTrack(HttpServletRequest request, HttpServletResponse respose, ModelMap model) {
//
//		else {
//			track.setName(request.getParameter("username"));
//			track.setPassword(request.getParameter("password"));
//				boolean status = trackDao.saveTrack(track);
//			if (status) {
//				model.addAttribute("username", trackDao.getTrackById(track.getId()));
//				return "update";
//			} else {
//				return "index";
//			}

		}

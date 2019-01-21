package com.stackroute.muzixapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.muzixapp.model.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveTrack(Track track) {
		try {

			sessionFactory.getCurrentSession().save(track);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteTrack(int id) {

		try {

			Track track = (Track) sessionFactory.getCurrentSession().load(Track.class, id);
			sessionFactory.getCurrentSession().delete(track);
			sessionFactory.getCurrentSession().flush();
			return true;

		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Track> getAllTracks() {
		List<Track> allTracks = sessionFactory.getCurrentSession().createQuery("from Track order by id desc").list();
		return allTracks;

	}


	//made changes here
	@Override
	public String getTrackById(int id) {
		List<String > username = sessionFactory.getCurrentSession().createQuery("select name from Track where id ='"+id+"'").list();
		return username.get(0);
	}

	@Override
	public boolean UpdateTrack(Track track) {

		sessionFactory.getCurrentSession().update(track);
		return true;
	}

}

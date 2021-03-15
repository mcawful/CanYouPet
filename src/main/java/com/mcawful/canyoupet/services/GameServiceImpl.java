/**
 * 
 */
package com.mcawful.canyoupet.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.mcawful.canyoupet.daos.Game;

/**
 * @author Michael McAuliffe
 *
 */
@Service
public class GameServiceImpl implements GameService {

	@Override
	public Game retrieveGameByTitleURI(String titleURI) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

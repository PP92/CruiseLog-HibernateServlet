package com.pp;

import com.pp.model.Cruise;
import com.pp.model.Yacht;
import com.pp.repository.CruisesRepository;
import com.pp.repository.YachtsRepository;
import com.pp.service.CruiseService;

/*
 * DB data initalizator
*/
public class InitApp {

	public static void main(String[] args) {
		CruiseService cruiseService = CruiseService.getInstance();
		CruisesRepository cruisesRepository = CruisesRepository.getInstance();
		YachtsRepository yachtsRepository = YachtsRepository.getInstance();

		Yacht yacht = new Yacht();
		yacht.setModel("Bavaria 40");
		yacht.setLength(12.25f);
		yacht.setBerths(8);
		yachtsRepository.saveYacht(yacht);

		yacht.setModel("Bavaria 50");
		yacht.setLength(15.40f);
		yacht.setBerths(10);
		yachtsRepository.saveYacht(yacht);

		yacht.setYachtName("Jeanneau");
		yacht.setModel("Sun Oddyssey 349");
		yacht.setLength(10.34f);
		yacht.setBerths(6);
		yachtsRepository.saveYacht(yacht);

		yacht.setModel("Omega");
		yacht.setYachtName("Orlik 2");
		yacht.setLength(6.25f);
		yacht.setBerths(6);
		yachtsRepository.saveYacht(yacht);

		yacht.setYachtName("Black Pearl");
		yacht.setModel("Galeon");
		yacht.setLength(50.29f);
		yacht.setBerths(100);
		yachtsRepository.saveYacht(yacht);

		for (int i = 0; i < 5; i++) {
			Cruise cruise = cruiseService.getRandomCruise();
			yacht = yachtsRepository.getYacht(i + 1);
			cruise.setYacht(yacht);
			cruisesRepository.saveCruise(cruise);
		}

	}

}

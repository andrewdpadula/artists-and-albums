package org.wecancodeit.artistsandalbums;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ArtistPopulator implements CommandLineRunner {
	@Resource
	private ArtistRepository artistRepo;
	@Resource
	private AlbumRepository albumRepo;
	@Resource
	private SongRepository songRepo;
	
	public ArtistPopulator() {
		
	}

	@Override
	public void run(String... args) throws Exception {
		Artist bigStar = artistRepo.save(new Artist("Big Star", "Stax Records"));
		Artist nirvana = artistRepo.save(new Artist("Nirvana", "DGC Records"));
		Artist theZombies = artistRepo.save(new Artist("The Zombies", "Decca Records"));
		Album no1Record = albumRepo.save(new Album("#1 Record", "August 1972", "Pop", "/img/no-1-record.jpg", bigStar));
		Album radioCity = albumRepo.save(new Album("Radio City", "02.01.1974", "Pop", "/img/radio-city.jpg", bigStar));
		Album third = albumRepo.save(new Album("Third", "03.18.1978", "Pop", "/img/third.jpg", bigStar));
		Album bleach = albumRepo.save(new Album("Bleach", "06.15.1989", "Grunge", "/img/bleach.jpg", nirvana));
		Album nevermind = albumRepo.save(new Album("Nevermind", "09.24.1991", "Grunge", "/img/nevermind.jpg", nirvana));
		Album inUtero = albumRepo.save(new Album("In Utero", "09.21.1993", "Grunge", "/img/in-utero.jpg", nirvana));
		Album beginHere = albumRepo.save(new Album("Begin Here", "04.09.1965", "Rock", "/img/begin-here.jpg", theZombies));
		Album odesseyAndOracle = albumRepo.save(new Album("Odessey and Oracle", "04.19.1968", "Rock", "/img/odessey-and-oracle.jpg", theZombies));
		
		Song thirteen = songRepo.save(new Song("Thirteen", "2:34", "Lyrics to song 1", "5 stars", no1Record));
		Song septemberGurls = songRepo.save(new Song("September Gurls", "2:41", "Lyrics to song 2", "5 stars", radioCity));
		Song nighttime = songRepo.save(new Song("Nighttime", "2:53", "Lyrics to song 3", "4 stars", third));
		Song aboutAGirl = songRepo.save(new Song("About A Girl", "2:48", "Lyrics to song 4", "4 stars", bleach));
		Song comeAsYouAre = songRepo.save(new Song("Come As You Are", "3:38", "Lyrics to song 5", "5 stars", nevermind));
		Song heartShapedBox = songRepo.save(new Song("Heart-Shaped Box", "4:39", "Lyrics to song 6", "5 stars", inUtero));
		Song shesNotThere = songRepo.save(new Song("She's Not There", "2:25", "Lyrics to song 7", "4 stars", beginHere));
		Song thisWillBeOurYear = songRepo.save(new Song("This Will Be Our Year", "2:08", "Lyrics to song 8", "5 stars", odesseyAndOracle));
	}
	
}

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
		
		Album no1Record = albumRepo.save(new Album("Number 1 Record", "August 1972", "Rock", "/img/no-1-record.jpg", bigStar));
		Album radioCity = albumRepo.save(new Album("Radio City", "02.01.1974", "Rock", "/img/radio-city.jpg", bigStar));
		Album third = albumRepo.save(new Album("Third", "03.18.1978", "Rock", "/img/third.jpg", bigStar));
		Album bleach = albumRepo.save(new Album("Bleach", "06.15.1989", "Grunge", "/img/bleach.jpg", nirvana));
		Album nevermind = albumRepo.save(new Album("Nevermind", "09.24.1991", "Grunge", "/img/nevermind.jpg", nirvana));
		Album inUtero = albumRepo.save(new Album("In Utero", "09.21.1993", "Grunge", "/img/in-utero.jpg", nirvana));
		Album beginHere = albumRepo.save(new Album("Begin Here", "04.09.1965", "Pop", "/img/begin-here.jpg", theZombies));
		Album odesseyAndOracle = albumRepo.save(new Album("Odessey and Oracle", "04.19.1968", "Pop", "/img/odessey-and-oracle.jpg", theZombies));
		
		Song feel = songRepo.save(new Song("Feel", "3:34", "Lyrics", "Rating", no1Record));
		Song theBalladOfElGoodo = songRepo.save(new Song("The Ballad of El Goodo", "4:21", "Lyrics", "Rating", no1Record));
		Song inTheStreet = songRepo.save(new Song("In the Street", "2:55", "Lyrics", "Rating", no1Record));
		Song thirteen = songRepo.save(new Song("Thirteen", "2:34", "Lyrics", "Rating", no1Record));
		Song dontLieToMe = songRepo.save(new Song("Don't Lie to Me", "3:07", "Lyrics", "Rating", no1Record));
		Song theIndiaSong = songRepo.save(new Song("The India Song", "2:20", "Lyrics", "Rating", no1Record));
		Song whenMyBabysBesideMe = songRepo.save(new Song("When My Baby's Beside Me", "3:22", "Lyrics", "Rating", no1Record));
		Song myLifeIsRight = songRepo.save(new Song("My Life Is Right", "3:07", "Lyrics", "Rating", no1Record));
		Song giveMeAnotherChance = songRepo.save(new Song("Give Me Another Chance", "3:26", "Lyrics", "Rating", no1Record));
		Song tryAgain = songRepo.save(new Song("Try Again", "3:31", "Lyrics", "Rating", no1Record));
		Song watchTheSunrise = songRepo.save(new Song("Watch the Sunrise", "3:45", "Lyrics", "Rating", no1Record));
		Song st1006 = songRepo.save(new Song("ST 100/6", "1:01", "Lyrics", "Rating", no1Record));
		
		Song oMySoul = songRepo.save(new Song("O My Soul", "5:40", "Lyrics", "Rating", radioCity));
		Song lifeIsWhite = songRepo.save(new Song("Life Is White", "3:19", "Lyrics", "Rating", radioCity));
		Song wayOutWest = songRepo.save(new Song("Way Out West", "2:50", "Lyrics", "Rating", radioCity));
		Song whatsGoingAhn = songRepo.save(new Song("What's Going Ahn", "2:40", "Lyrics", "Rating", radioCity));
		Song youGetWhatYouDeserve = songRepo.save(new Song("You Get What You Deserve", "3:08", "Lyrics", "Rating", radioCity));
		Song modLang = songRepo.save(new Song("Mod Lang", "2:45", "Lyrics", "Rating", radioCity));
		Song backOfACar = songRepo.save(new Song("Back of a Car", "2:46", "Lyrics", "Rating", radioCity));
		Song daisyGlaze = songRepo.save(new Song("Daisy Glaze", "3:49", "Lyrics", "Rating", radioCity));
		Song shesAMover = songRepo.save(new Song("She's a Mover", "3:12", "Lyrics", "Rating", radioCity));
		Song septemberGurls = songRepo.save(new Song("September Gurls", "2:49", "Lyrics", "Rating", radioCity));
		Song morphaToo = songRepo.save(new Song("Morpha Too", "1:27", "Lyrics", "Rating", radioCity));
		Song imInLoveWithAGirl = songRepo.save(new Song("I'm in Love with a Girl", "1:48", "Lyrics", "Rating", radioCity));
		
		Song kizzaMe = songRepo.save(new Song("Kizza Me", "2:44", "Lyrics", "Rating", third));
		Song thankYouFriends = songRepo.save(new Song("Thank You Friends", "3:05", "Lyrics", "Rating", third));
		Song bigBlackCar = songRepo.save(new Song("Big Black Car", "3:35", "Lyrics", "Rating", third));
		Song jesusChrist = songRepo.save(new Song("Jesus Christ", "2:37", "Lyrics", "Rating", third));
		Song femmeFatale = songRepo.save(new Song("Femme Fatale", "3:28", "Lyrics", "Rating", third));
		Song oDana = songRepo.save(new Song("O Dana", "2:34", "Lyrics", "Rating", third));
		Song holocaust = songRepo.save(new Song("Holocaust", "3:47", "Lyrics", "Rating", third));
		Song kangaroo = songRepo.save(new Song("Kangaroo", "3:46", "Lyrics", "Rating", third));
		Song strokeItNoel = songRepo.save(new Song("Stroke It Noel", "2:04", "Lyrics", "Rating", third));
		Song forYou = songRepo.save(new Song("For You", "2:41", "Lyrics", "Rating", third));
		Song youCantHaveMe = songRepo.save(new Song("You Can't Have Me", "3:11", "Lyrics", "Rating", third));
		Song nighttime = songRepo.save(new Song("Nighttime", "2:53", "Lyrics", "Rating", third));
		Song blueMoon = songRepo.save(new Song("Blue Moon", "2:06", "Lyrics", "Rating", third));
		Song takeCare = songRepo.save(new Song("Take Care", "2:46", "Lyrics", "Rating", third));
		
		Song blew = songRepo.save(new Song("Blew", "2:55", "Lyrics", "Rating", bleach));
		Song floydTheBarber = songRepo.save(new Song("Floyd the Barber", "2:18", "Lyrics", "Rating", bleach));
		Song aboutAGirl = songRepo.save(new Song("About a Girl", "2:48", "Lyrics", "Rating", bleach));
		Song school = songRepo.save(new Song("School", "2:42", "Lyrics", "Rating", bleach));
		Song loveBuzz = songRepo.save(new Song("Love Buzz", "3:35", "Lyrics", "Rating", bleach));
		Song paperCuts = songRepo.save(new Song("Paper Cuts", "4:06", "Lyrics", "Rating", bleach));
		Song negativeCreep = songRepo.save(new Song("Negative Creep", "2:56", "Lyrics", "Rating", bleach));
		Song scoff = songRepo.save(new Song("Scoff", "4:10", "Lyrics", "Rating", bleach));
		Song swapMeet = songRepo.save(new Song("Swap Meet", "3:03", "Lyrics", "Rating", bleach));
		Song mrMoustache = songRepo.save(new Song("Mr. Moustache", "3:24", "Lyrics", "Rating", bleach));
		Song sifting = songRepo.save(new Song("Sifting", "5:22", "Lyrics", "Rating", bleach));
		Song bigCheese = songRepo.save(new Song("Big Cheese", "3:42", "Lyrics", "Rating", bleach));
		Song downer = songRepo.save(new Song("Downer", "1:44", "Lyrics", "Rating", bleach));
		
		Song smellsLikeTeenSpirit = songRepo.save(new Song("Smells Like Teen Spirit", "5:01", "Lyrics", "Rating", nevermind));
		Song inBloom = songRepo.save(new Song("In Bloom", "4:14", "Lyrics", "Rating", nevermind));
		Song comeAsYouAre = songRepo.save(new Song("Come As You Are", "3:39", "Lyrics", "Rating", nevermind));
		Song breed = songRepo.save(new Song("Breed", "3:03", "Lyrics", "Rating", nevermind));
		Song lithium = songRepo.save(new Song("Lithium", "4:17", "Lyrics", "Rating", nevermind));
		Song polly = songRepo.save(new Song("Polly", "2:57", "Lyrics", "Rating", nevermind));
		Song territorialPissings = songRepo.save(new Song("Territorial Pissings", "2:22", "Lyrics", "Rating", nevermind));
		Song drainYou = songRepo.save(new Song("Drain You", "3:43", "Lyrics", "Rating", nevermind));
		Song loungeAct = songRepo.save(new Song("Lounge Act", "2:36", "Lyrics", "Rating", nevermind));
		Song stayAway = songRepo.save(new Song("Stay Away", "3:32", "Lyrics", "Rating", nevermind));
		Song onAPlain = songRepo.save(new Song("On a Plain", "3:16", "Lyrics", "Rating", nevermind));
		Song somethingInTheWay = songRepo.save(new Song("Something in the Way", "3:52", "Lyrics", "Rating", nevermind));
		
		Song serveTheServants = songRepo.save(new Song("Serve the Servants", "3:36", "Lyrics", "Rating", inUtero));
		Song scentlessApprentice = songRepo.save(new Song("Scentless Apprentice", "3:48", "Lyrics", "Rating", inUtero));
		Song heartShapedBox = songRepo.save(new Song("Heart-Shaped Box", "4:41", "Lyrics", "Rating", inUtero));
		Song rapeMe = songRepo.save(new Song("Rape Me", "2:50", "Lyrics", "Rating", inUtero));
		Song francesFarmerWillHaveHerRevengeOnSeattle = songRepo.save(new Song("Frances Farmer Will Have Her Revenge on Seattle", "4:10", "Lyrics", "Rating", inUtero));
		Song dumb = songRepo.save(new Song("Dumb", "2:32", "Lyrics", "Rating", inUtero));
		Song veryApe = songRepo.save(new Song("Very Ape", "1:56", "Lyrics", "Rating", inUtero));
		Song milkIt = songRepo.save(new Song("Milk It", "3:55", "Lyrics", "Rating", inUtero));
		Song pennyroyalTea = songRepo.save(new Song("Pennyroyal Tea", "3:37", "Lyrics", "Rating", inUtero));
		Song radioFriendlyUnitShifter = songRepo.save(new Song("Radio Friendly Unit Shifter", "4:51", "Lyrics", "Rating", inUtero));
		Song tourettes = songRepo.save(new Song("Tourette's", "1:35", "Lyrics", "Rating", inUtero));
		Song allApologies = songRepo.save(new Song("All Apologies", "3:50", "Lyrics", "Rating", inUtero));
		
		Song roadRunner = songRepo.save(new Song("Road Runner", "2:06", "Lyrics", "Rating", beginHere));
		Song summertime = songRepo.save(new Song("Summertime", "2:17", "Lyrics", "Rating", beginHere));
		Song iCantMakeUpMyMind = songRepo.save(new Song("I Can't Make Up My Mind", "2:37", "Lyrics", "Rating", beginHere));
		Song theWayIFeelInside = songRepo.save(new Song("The Way I Feel Inside", "1:28", "Lyrics", "Rating", beginHere));
		Song workNPlay = songRepo.save(new Song("Work 'n' Play", "2:07", "Lyrics", "Rating", beginHere));
		Song youveReallyGotAHoldOnMe = songRepo.save(new Song("You've Really Got a Hold on Me / Bring It on Home to Me", "3:39", "Lyrics", "Rating", beginHere));
		Song shesNotThere = songRepo.save(new Song("She's Not There", "2:20", "Lyrics", "Rating", beginHere));
		Song sticksAndStones = songRepo.save(new Song("Sticks And Stones", "2:56", "Lyrics", "Rating", beginHere));
		Song cantNobodyLoveYou = songRepo.save(new Song("Can't Nobody Love You", "2:15", "Lyrics", "Rating", beginHere));
		Song woman = songRepo.save(new Song("Woman", "2:25", "Lyrics", "Rating", beginHere));
		Song iDontWantToKnow = songRepo.save(new Song("I Don't Want to Know", "2:07", "Lyrics", "Rating", beginHere));
		Song iRememberWhenILovedHer = songRepo.save(new Song("I Remember When I Loved Her", "2:00", "Lyrics", "Rating", beginHere));
		Song whatMoreCanIDo = songRepo.save(new Song("What More Can I Do", "1:38", "Lyrics", "Rating", beginHere));
		Song iGotMyMojoWorking = songRepo.save(new Song("I Got My Mojo Working", "3:35", "Lyrics", "Rating", beginHere));
		
		Song careOfCell44 = songRepo.save(new Song("Care of Cell 44", "3:57", "Lyrics", "Rating", odesseyAndOracle));
		Song aRoseForEmily = songRepo.save(new Song("A Rose for Emily", "2:19", "Lyrics", "Rating", odesseyAndOracle));
		Song maybeAfterHesGone = songRepo.save(new Song("Maybe After He's Gone", "2:34", "Lyrics", "Rating", odesseyAndOracle));
		Song beechwoodPark = songRepo.save(new Song("Beechwood Park", "2:44", "Lyrics", "Rating", odesseyAndOracle));
		Song briefCandles = songRepo.save(new Song("Brief Candles", "3:30", "Lyrics", "Rating", odesseyAndOracle));
		Song hungUpOnADream = songRepo.save(new Song("Hung Up on a Dream", "3:02", "Lyrics", "Rating", odesseyAndOracle));
		Song changes = songRepo.save(new Song("Changes", "3:20", "Lyrics", "Rating", odesseyAndOracle));
		Song iWantHerSheWantsMe = songRepo.save(new Song("I Want Her, She Wants Me", "2:53", "Lyrics", "Rating", odesseyAndOracle));
		Song thisWillBeOurYear = songRepo.save(new Song("This Will Be Our Year", "2:08", "Lyrics", "Rating", odesseyAndOracle));
		Song butchersTale = songRepo.save(new Song("Butcher's Tale (Western Front 1914)", "2:48", "Lyrics", "Rating", odesseyAndOracle));
		Song friendsOfMine = songRepo.save(new Song("Friends of Mine", "2:18", "Lyrics", "Rating", odesseyAndOracle));
		Song timeOfTheSeason = songRepo.save(new Song("Time of the Season", "3:34", "Lyrics", "Rating", odesseyAndOracle));
		
	}
	
}

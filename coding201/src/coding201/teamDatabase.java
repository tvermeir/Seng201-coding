package coding201;

import java.util.Arrays;
import java.util.List;
/**
 * teamDatabase
 * teamDatabase is the class from which the random team names are generated. A list of these teams can be returned.
 * @version 1.0
 * @author tve21 & bro82
 */
public class teamDatabase {
	/**
	 * teamnames string generated from list of top european clubs, compiled from top clubs from La Liga Santander, Premier Leaguue, Ligue 1, SPFL, Bundesliga, Serie A, and Liga Portugal.
	 */
	String teamnames = """
	Real Madrid
	Barcelona
	Atletico Madrid
	Valencia
	Sevilla
	Villarreal
	Real Sociedad
	Athletic Bilbao
	Real Betis
	Celta Vigo
	Levante
	Granada
	Osasuna
	Espanyol
	Getafe
	Cadiz
	Elche
	Real Valladolid
	Huesca
	Alaves
	Manchester United
	Manchester City
	Liverpool
	Chelsea
	Arsenal
	Tottenham Hotspur
	Leicester City
	West Ham United
	Everton
	Aston Villa
	Newcastle United
	Southampton
	Crystal Palace
	Brighton & Hove Albion
	Wolverhampton Wanderers
	Burnley
	Fulham
	West Bromwich Albion
	Paris Saint-Germain
	Marseille
	Lyon
	Lille
	Monaco
	Bordeaux
	Stade Rennais
	Nantes
	Nice
	Saint-Etienne
	Montpellier
	Strasbourg
	Metz
	Lens
	Angers
	Reims
	Brest
	Nimes
	Dijon
	Rangers
	Celtic
	Aberdeen
	Hibernian
	Motherwell
	St. Johnstone
	Heart of Midlothian
	Livingston
	Kilmarnock
	St. Mirren
	Ross County
	Dundee United
	FC Bayern Munich
	Borussia Dortmund
	RB Leipzig
	Bayer Leverkusen
	Borussia Monchengladbach
	VfL Wolfsburg
	Eintracht Frankfurt
	SC Freiburg
	Union Berlin
	TSG Hoffenheim
	FC Augsburg
	Hertha Berlin
	Arminia Bielefeld
	Mainz 05
	FC Koln
	Schalke 04
	Werder Bremen
	Inter Milan
	AC Milan
	Juventus
	Napoli
	AS Roma
	Atalanta
	Lazio
	Sassuolo
	Sampdoria
	Udinese
	Fiorentina
	Genoa
	Cagliari
	Bologna
	Spezia
	Benevento
	Verona
	Torino
	Parma
	Benfica
	Porto
	Sporting CP
	Braga
	Famalicao
	Boavista
	Vitoria Guimaraes
	Pacos de Ferreira
	Rio Ave
	Santa Clara
	Gil Vicente
	Moreirense
	Maritimo
	Tondela
	Portimonense
	Farense
	""";
	/**
	 * Uses the team name string to return a list of all the names.
	 * @return List of team names
	 */
	public List<String> getList() {
		List<String> items = Arrays. asList(teamnames. split("\n"));
		return items;
	}
	
	public static void main(String[] args) {

	}

}

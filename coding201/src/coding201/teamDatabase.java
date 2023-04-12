package coding201;

import java.util.Arrays;
import java.util.List;

public class teamDatabase {

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
	
	public List<String> getList() {
		List<String> items = Arrays. asList(teamnames. split("\n"));
		return items;
	}
	
	public static void main(String[] args) {
		teamDatabase ting = new teamDatabase();
		System.out.println(ting.getList());

	}

}

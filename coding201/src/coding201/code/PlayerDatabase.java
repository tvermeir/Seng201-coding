package coding201.code;

import java.util.List;
import java.util.Arrays;
/**
 * playerDatabase
 * This class contains a string of all possible default names for players in the game. 
 * A list of these names can be returned.
 * @version 1.0
 * @author tve21
 * @author bro82
 *
 */
public class PlayerDatabase {
	/**
	 * playerString created from the list of Premier League Players from the 2018/2019 season.
	 * retrieved from: https://footystats.org/download-stats-csv
	 */
	String playerString = """
	Aaron Cresswell
	Todd Vermeir
	Ben Ross
	Aaron Lennon
	Aaron Mooy
	Aaron Ramsey
	Aaron Rowe
	Aaron Wan-Bissaka
	Abdelhamid Sabiri
	Abdoulaye Doucouré
	Aboubakar Kamara
	Adalberto Maestre
	Adam David Lallana
	Adam Masina
	Adam Smith
	Adama Diakhaby
	Adama Traoré Diarra
	Ademola Lookman
	Adrian Mariappa
	Adrián  del Castillo
	Adrien Silva
	Ainsley Maitland-Niles
	Alberto Moreno
	Aleksandar Mitrović
	Alex Iwobi
	Alex McCarthy
	Alex Oxlade-Chamberlain
	Alex Pritchard
	Alex Smithies
	Alexander Sørloth
	Alexandre Lacazette
	Alexandre Silva
	Alexis Sanchez
	Alfie Jones
	Alfie Mawson
	Alfie Whiteman
	Ali Koiki
	Alireza Jahanbakhsh
	Alisson Becker
	Alvaro Morata
	Ander Herrera
	André Filipe Tavares Gomes
	Andre Gray
	André Schürrle
	André-Frank Zambo Anguissa
	Andreas Christensen
	Andreas Pereira
	Andrew Robertson
	Andrew Surman
	Andriy Yarmolenko
	Andros Townsend
	Andy Carroll
	Angel Gomes
	Angelo Ogbonna
	Angus Gunn
	Anthony Driscoll-Glennon
	Anthony Knockaert
	Anthony Martial
	Antonio Barreca
	Antonio Rüdiger
	Antonio Valencia
	Arijanet Muric
	Aron Einar Gunnarsson
	Arthur Masuaku
	Artur Boruc
	Ashley Barnes
	Ashley Westwood
	Ashley Young
	Asmir Begović
	Aymeric Laporte
	Ayoze Perez
	Bakary Sako
	Ben Chilwell
	Ben Davies
	Ben Foster
	Ben Gibson
	Ben Hamer
	Ben Mee
	Ben White
	Ben Wilmot
	Benjamin Johnson
	Benjamin Mendy
	Beram Kayal
	Bernard Duarte
	Bernardo
	Bernardo Silva
	Bernd Leno
	Bobby Reid
	Brian Murphy
	Bright Enobakhare
	Bruno Écuélé Manga
	Bruno Saltor Grau
	Caglar Söyüncü
	Callum Hudson-Odoi
	Callum Paterson
	Callum Roberts
	Callum Slattery
	Callum Wilson
	Calum Chambers
	Cameron John
	Carl Jenkinson
	Carlos Sánchez
	Cedric Soares
	Cenk Tosun
	Cesar Azpilicueta
	Cesc Fabregas
	Charlie Austin
	Charlie Daniels
	Charlie Taylor
	Cheikhou Kouyaté
	Chris Löwe
	Chris Mepham
	Chris Smalling
	Chris Wood
	Christian Atsu Twasam
	Christian Benteke
	Christian Eriksen
	Christian Fuchs
	Christian Kabasele
	Christopher Schindler
	Ciaran Clark
	Claudio Muñoz
	Collin Quaner
	Connor Wickham
	Conor Coady
	Conor Coventry
	Craig Cathcart
	Curtis Jones
	Cyrus Christie
	Dale Stephens
	Emiliano Martínez
	Dan Burn
	Dan Gosling
	Daniel Amartey
	Daniel Sturridge
	Daniel Ings
	Daniel Williams
	Danilo
	Danny Drinkwater
	Danny Rose
	Danny Simpson
	Danny Ward
	Danny Ward
	Danny Welbeck
	Daryl Janmaat
	David Brooks
	David Button
	David de Gea
	David Junior Hoilett
	David Luiz
	David Silva
	Davide Zappacosta
	Davinson Mina
	Davy Pröpper
	DeAndre Yedlin
	Declan Rice
	Dejan Lovren
	Dele Alli
	Demarai Gray
	Demeaco Duhaney
	Denis Odoi
	Denis Suárez
	Diego Rico
	Diogo da Silva
	Divock Origi
	Domingos Quina
	Dominic Calvert-Lewin
	Dominic Solanke
	Dwight McNeil
	Eden Hazard
	Ederson
	Edward Nketiah
	Elias Kachunga
	Emerson Hyndman
	Emerson dos Santos
	Emile Smith Rowe
	Eric Bertrand Bailly
	Eric Dier
	Erik Durm
	Erik Lamela
	Ethan Ampadu
	Etienne Capoue
	Fabián González
	Fabian Delph
	Fabian Schär
	Fabinho
	Fabricio Ramírez
	Faustino Rojo
	Federico Fernández
	Felipe Gomes
	Fernando Llorente Torres
	Fernando Luiz Rosa
	Florent Hadergjonaj
	Florian Lejeune
	Florin Andone
	Floyd Ayité
	Fousseni Diabaté
	Francisco Femenía Far
	Fraser Forster
	Freddie Woodman
	Frederico Santos
	Gabriel Jesus
	Gaëtan Bong Songo
	Gary Cahill
	Gary Madine
	George Marsh
	Georges-Kevin Mbida
	Georginio Wijnaldum
	Gerard Deulofeu
	Glenn Murray
	Gonzalo Higuain
	Grady Diangana
	Granit Xhaka
	Greg Cunningham
	Gylfi Sigurdsson
	Hamza Choudhury
	Harry Arter
	Harry Kane
	Harry Maguire
	Harry Winks
	Harvey Lewis Barnes
	Håvard Nordtveit
	Hector Bellerin
	Hélder Costa
	Henrikh Mkhitaryan
	Heung-Min Son
	Heurelho da Silva Gomes
	Hugo Lloris
	Ibrahima Cissé
	Idrissa Gana Gueye
	İlkay Gündoğan
	Isaac Ajayi Success
	Isaac Hayden
	Isaac Mbenza
	Issa Diop
	Ivan Cavaleiro
	Jack Cork
	Jack Simpson
	Jack Stephens
	Jack Wilshere
	Jacob Murphy
	Jaïro Riedewald
	Jamal Lascelles
	James Garner
	James Maddison
	James McArthur
	James McCarthy
	James Milner
	James Tarkowski
	James Tomkins
	James Ward-Prowse
	Jamie Sterry
	Jamie Vardy
	Jan Bednarek
	Jan Vertonghen
	Jannik Vestergaard
	Jason Puncheon
	Jason Steele
	Javier Hernandez
	Javier Manquillo Gaitán
	Jayson Molumby
	Jazz Richards
	Jean Michau00ebl Seri
	Jeff Hendrick
	Jefferson Lerma
	Jeffrey Schlupp
	Jermain Defoe
	Jesse Lingard
	João Moutinho
	Joe Bennett
	Joe Bryan
	Joe Daniel Tupper
	Joe Gomez
	Joe Hart
	Joe Powell
	Joe Ralls
	Joel Coleman
	Joel Matip
	Joel Ward
	Johann Berg Guðmunds­son
	John Ruddy
	John Stones
	Jon Gorenc Stankovic
	Jonas Lössl
	Jonathan Hogg
	Jonathan Walters
	Jonjo Shelvey
	Jonjoe Kenny
	Jonny
	Jonny Evans
	Jordan Ayew
	Jordan Henderson
	Jordan Pickford
	Jordon Ibe
	Jorginho
	Diogo Dalot
	José Holebas
	Jose Izquierdo
	José Mato
	Joseph Willock
	Josh Benson
	Josh Knight
	Josh Murphy
	Joshua King
	Joshua Sims
	Juan Marcos Foyth
	Juan Mata
	Julián Speroni
	Juninho Bacuna
	Junior Stanislas
	Jürgen Locadia
	Kadeem Harris
	Karl Darlow
	Karlan Ahearne-Grant
	Kasper Schmeichel
	Kayne Ramsey
	Kazaiah Sterling
	Kelechi Iheanacho
	Kelland Watts
	Ken Sema
	Kenneth Dahrup Zohorè
	Kepa Arrizabalaga
	Kevin De Bruyne
	Kevin Long
	Kevin McDonald
	Kieran Dowell
	Kieran Trippier
	Konstantinos Mavropanos
	Kortney Hause
	Kurt Zouma
	Kyle Taylor
	Kyle Walker
	Kyle Walker-Peters
	Laurent Depoitre
	Laurent Koscielny
	Lazar Marković
	Leander Dendoncker
	Leandro Bacuna
	Lee Grant
	Lee Peltier
	Leighton Baines
	Leon Balogun
	Leonardo Maia
	Leroy Sané
	Lewis Cass
	Lewis Cook
	Lewis Dunk
	Loïc Damour
	Loris Karius
	Luca de la Torre
	Lucas Digne
	Lucas Perez
	Lucas Moura 
	Lucas Torreira
	Luciano Vietto
	Luka Milivojević
	Luke Amos
	Luke Dreher
	Luke Shaw
	Lys Mousset
	Maarten Stekelenburg
	Mamadou Sakho
	Manolo Gabbiadini
	Manuel Lanzini
	Marc Albrighton
	Marc Guehi
	Marc Navarro Ceciliano
	Marc Pugh
	Marcos Alonso
	Marcus Bettinelli
	Marcus Rashford
	Mario Lemina
	Mark Noble
	Mark Travers
	Marko Arnautović
	Markus Suttner
	Marouane Fellaini
	Martin Dúbravka
	Martin Kelly
	Martín Montoya
	Mason Greenwood
	Mason Holgate
	Matěj Vydra
	Mateo Kovacic
	Mathew Ryan
	Mathias Jørgensen
	Matt Butcher
	Matt Doherty
	Matt Ritchie
	Matt Targett
	Matteo Darmian
	Mattéo Guendouzi Olié
	Matthew Connolly
	Matthew Lowton
	Matty Daly
	Max Harrison Sanders
	Max Kilman
	Max Meyer
	Maxime Le Marchand
	Maya Yoshida
	Mesut Özil
	Michael Keane
	Michael Obafemi
	Michail Antonio
	Michel Vorm
	Michy Batshuayi
	Miguel Rejala
	Miguel Cabrera
	Mohamed Diamé
	Mohamed Elneny
	Mohamed Elyounoussi
	Mohamed Salah
	Morgan Gibbs-White
	Morgan Schneiderlin
	Moussa Dembele
	Moussa Sissoko
	N'Golo Kanté
	Naby Deco Keïta
	Nacho Monreal
	Nampalys Mendy
	Nathan Aké
	Nathan Holland
	Nathan Redmond
	Nathaniel Chalobah
	Nathaniel Clyne
	Nathaniel Mendez-Laing
	Neeskens Kebano
	Neil Etheridge
	Nemanja Matić
	Nicolas Otamendi
	Nikola Tavares
	Nnamdi Ofoborh
	Oleksandr Zinchenko
	Oliver Skipp
	Olivier Giroud
	Onyinye Wilfred Ndidi
	Oriol Romeu
	Oumar Niasse
	Pablo Zabaleta
	Pape N'Diaye Souaré
	Pascal Groß
	Patrick van Aanholt
	Paul Dummett
	Paul Pogba
	Paulo Dino Gazzaniga
	Pedro Obiang
	Pedro Rodriguez
	Peter Crouch
	Petr Čech
	Phil Bardsley
	Phil Jagielka
	Phil Jones
	Philip Billing
	Philip Foden
	Philippe Sandler
	Pierre-Emerick Aubameyang
	Pierre-Emile Højbjerg
	Rachid Ghezzal
	Rafael Euclides Soares Camacho
	Raheem Sterling
	Rajiv van La Parra
	Ramadan Sobhi
	Raúl Alonso Jiménez Rodríguez
	Rhys Healey
	Ricardo Pereira
	Richarlison de Andrade
	Riyad Mahrez
	Rob Holding
	Robbie Brady
	Robert Nascimento
	Robert Snodgrass
	Roberto Firmino
	Roberto Maximiliano Pereyra
	Romain Saïss
	Romelu Lukaku
	Rondon
	Ross Barkley
	Rúben Diogo Da Silva Neves
	Rúben Vinagre
	Ruben Loftus-Cheek
	Rui Pedro dos Santos Patrício
	Ryan Bennett
	Ryan Bertrand
	Ryan Fraser
	Ryan Fredericks
	Ryan Giles
	Ryan Guno Babel
	Ryan Schofield
	Ryan Sessegnon
	Sadio Mané
	Sam Gallagher
	Sam Surridge
	Sam Vokes
	Sam Woods
	Samir Nasri
	Sandro Ramirez
	Scott Dann
	Scott McTominay
	Sead Kolašinac
	Séamus Coleman
	Sean Longstaff
	Sean Morrison
	Sebastian Prödl
	Serge Aurier
	Sergio Aguero
	Sergio Germán Romero
	Sergio Rico
	Shane Duffy
	Shane Long
	Shinji Okazaki
	Shkodran Mustafi
	Simon Francis
	Simon Mignolet
	Sokratis Papastathopoulos
	Solomon March
	Souleymane Bamba
	Stefan Marius Johansen
	Stefano Okaka
	Stephan Lichtsteiner
	Stephen Ward
	Steve Cook
	Steve Mounié
	Steven Davis
	Steven Defour
	Stuart Armstrong
	Sullay Kaikai
	Sung-Yeung Ki
	Tahith Chong
	Terence Kongolo
	Theo Walcott
	Tim Ream
	Timothy Eyoma
	Timothy Fosu-Mensah
	Toby Alderweireld
	Tom Cairney
	Tom Cleverley
	Tom Davies
	Tom Heaton
	Tom Smith
	Trent Alexander-Arnold
	Troy Deeney
	Tyias Browning
	Tyreke Johnson
	Tyrone Mings
	Vicente Guaita
	Vicente Iborra De La Fuente
	Víctor Camarasa
	Victor Moses
	Victor Nilsson Lindelöf
	Victor Wanyama
	Viktor Gyökeres
	Vincent Janssen
	Vincent Kompany
	Virgil van Dijk
	Wayne Hennessey
	Wes Morgan
	Wesley Hoedt
	Wilfredo Daniel Caballero
	Wilfried Zaha
	Will Hughes
	Will Norris
	Willian
	Willy Boly
	Xherdan Shaqiri
	Yann Valery
	Yerry Fernando Mina González
	Yoshinori Muto
	Youri Tielemans
	Yves Bissouma
	Zechariah Medley
	Zeze Steven Sessegnon
	Lukasz Fabianski
	""";
	/**
	 * Uses the playerString string of player names to return a list of the separate names.
	 * @return list of all the player names.
	 */
	public List<String> getList() {
		List<String> items = Arrays. asList(playerString. split("\n"));
		return items;
	}
	




	
	
	
	
	
  
	
	

	
	
	

}

# ohtu-miniprojekti

[![Build Status](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti.svg?branch=master)](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti)

# Dokumentaatio

## Käyttöohjeet

-Käynnistä ohjelma menemällä sovelluksen juureen, kirjoita java -jar HexTex.jar ja    paina ENTER

-Kirjoita help ja paina ENTER saadaksesi ohjeita

-Poistu ohjelmasta kirjoittamalla quit ja painamalla ENTER kun olet Main Menussa

## Product backlog

https://docs.google.com/spreadsheets/d/19EOMSb2dqar0gfmUwl0az7KPGXTaGRU-vQGXSTE0a00/edit?usp=sharing

## Sprint 4

Backlog: https://docs.google.com/spreadsheets/d/16LNaqy8GF3Fzx5SaphqTLuDvG-HgsLa5TB3ui-GIDiQ/edit?usp=sharing
Burndown: https://docs.google.com/spreadsheets/d/1oKbQFujuJDv9CVd9f1UhZF5akWuR2iIMr42Eqj3WMos/edit?usp=sharing

### User storyt ja hyväksymistestit

#### Käyttäjä voi käyttää sovellusta mahdollisimman vaivattomasti

###### Hyväksymistestit
1. Käyttäjä voi antaa komentoja shortcutien avulla.
2. Käyttäjän luoma bibtex tiedosto sisentyy oikein.
3. Käyttäjä voi tarkastella listattuja viitteitä yksinkertaistetussa muodossa.
4. Sovelluksen menurakenne on yksinkertainen.

#### Yhden viitteen tietojen tarkastelu

###### Hyväksymistestit
1. Käyttäjä voi valita vain yhden viitteen tiedot tarkasteltavaksi.
2. Viitteestä näytetään käyttäjälle kaikki viitteen tiedot.

#### Haku sisällön mukaan

###### Hyväksymistestit
1. Käyttäjä voi asettaa filttereitä viitelistaan
2. Listauksessa näytetään vain viitteitä, joiden tiedoissa esiintyy filtterin merkkijono

## Sprint 3

Backlog: https://docs.google.com/spreadsheets/d/16LNaqy8GF3Fzx5SaphqTLuDvG-HgsLa5TB3ui-GIDiQ/edit?usp=sharing
Burndown: https://docs.google.com/spreadsheets/d/1oKbQFujuJDv9CVd9f1UhZF5akWuR2iIMr42Eqj3WMos/edit?usp=sharing

### User storyt ja hyväksymistestit

#### Viitteitä ei unohdeta kun sovellus suljetaan

###### Hyväksymistestit
1. Käyttäjä voi selata edellisillä käyttökerroillaan tekemiään viitteitä

#### Viiteavain on automaattisesti generoitu

* Tapahtuu muodossa sukunimen 3 ensimmäistä kirjainta ja vuosi esim Vih2017.
Mikäli samana vuonna on useampi teos, perään aakoset, esim Vih2017a.
Jos teoksella useampi tekijä, sukunimet peräkkäin ja useamman teoksen tapauksessa
sama käytäntö kuin yllä, esim LuuVih2017a.

###### Hyväksymistestit
1. Uuden viitteen luonti generoi automaattisesti sille oikean avaimen.

#### Teokselle voidaan lisätä useampi kirjailija

###### Hyväksymistestit

1. Käyttäjän syöttäessä 2 kirjailijaa teokselle, näkyvät molemmat teosta selattaessa
2. Molemmat syötetyistä kirjailijoista näkyvät teoksen automaattisesti generoidussa viiteavaimessa

#### Käyttäjä pystyy poistamaan viitteen

###### Hyväksymistestit

1. Käyttäjän valitessa viitteen poisto, viite poistetaan tiedostosta



## Sprint 2


Backlog: https://docs.google.com/spreadsheets/d/16LNaqy8GF3Fzx5SaphqTLuDvG-HgsLa5TB3ui-GIDiQ/edit?usp=sharing
Burndown:https://docs.google.com/spreadsheets/d/1oKbQFujuJDv9CVd9f1UhZF5akWuR2iIMr42Eqj3WMos/edit#gid=0



### User storyt ja hyväksymistestit

#### Käyttäjä pystyy selaamaan viitteitä

###### Hyväksymistestit
1. Käyttäjä voi valita viitteiden näyttämisen tekstikäyttöliittymässä.
2. Olemassa olevat viitteet näytetään tekstikäyttöliittymässä.

#### Käyttäjä pystyy lisäämään inproc-tyylisen viitteen

###### Hyväksymistestit
1. Viitettä ei luoda jos käyttäjän syötteessä on ääkkösiä.(Annetaan virheilmoitus).

2. Lisättävän viitteen oltava inproc-kategorian viite.

3. Jos käyttäjä jättää pakollisen kentän täyttämättä annetaan virhe ilmoitus.

4. Viite luodaan, jos käyttäjä täyttää inproc-kategorian kaikki syötteet (author,title,year,book-title) ilman ääkkösiä.

#### Käyttäjä pystyy lisäämään article-tyyppisen viitteen

###### Hyväksymistestit
1. Viitettä ei luoda jos käyttäjän syötteessä on ääkkösiä.(Annetaan virheilmoitus).

2. Lisättävän viitteen oltava inproc-kategorian viite.

3. Jos käyttäjä jättää pakollisen kentän täyttämättä annetaan virhe ilmoitus.

4. Viite luodaan, jos käyttäjä täyttää inproc-kategorian kaikki syötteet (author,title,journal,year,volume,pages) ilman ääkkösiä.

#### Käyttäjä pystyy käyttää bibtex-tiedostoaan yhdessä latex-dokumentin kanssa

###### Hyväksymistestit
1. Dokumentin kääntämisen jälkeen tiedostossa ei yhtään [?]-merkkejä.


## Sprint 1

Backlog: https://docs.google.com/spreadsheets/d/16LNaqy8GF3Fzx5SaphqTLuDvG-HgsLa5TB3ui-GIDiQ/edit#gid=0

Burndown-käyrä: https://docs.google.com/spreadsheets/d/1oKbQFujuJDv9CVd9f1UhZF5akWuR2iIMr42Eqj3WMos/edit?usp=sharing

### User storyt ja hyväksymistestit

#### Käyttäjä pystyy generoimaan bibTex-tiedoston

###### Hyväksymistestit
1. Viiteistä muodostetaan bibTex-tiedosto
2. Ainakin yksi viite on oltava luotuna, jotta tiedosto voidaan luoda

#### Käyttäjä pystyy lisäämään book-tyyppisen viitteen ilman ääkkösiä ja täyttämällä kaikki kentät(author,title,year,publisher)

###### Hyväksymistestit
1. Viitettä ei luoda jos käyttäjän syötteessä on ääkkösiä.(Annetaan virheilmoitus)

2. Lisättävän viitteen oltava book-kategorian viite.

3. Jos käyttäjä jättää pakollisen kentän täyttämättä annetaan virhe ilmoitus

4. Viite luodaan, jos käyttäjä täyttää book-kategorian kaikki syötteet ja ilman ääkkösiä

# ohtu-miniprojekti

[![Build Status](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti.svg?branch=master)](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti)

## Dokumentaatio

### Product backlog

https://docs.google.com/document/d/1rOSL-ld9ft5-Zw1Se4O46TkJnRsS-eWm1bDstQH1Dlk/edit?ts=58dcf759

### Sprint 1

Backlog: https://docs.google.com/spreadsheets/d/16LNaqy8GF3Fzx5SaphqTLuDvG-HgsLa5TB3ui-GIDiQ/edit#gid=0

### User storyt ja hyväksymistestit

#### Käyttäjä pystyy generoimaan bibTex-tiedoston

##### Hyväksymistestit
1. Viiteistä muodostetaan bibTex-tiedosto
2. Ainakin yksi viite on oltava luotuna, jotta tiedosto voidaan luoda

#### Käyttäjä pystyy lisäämään book-tyyppisen viitteen ilman ääkkösiä ja täyttämällä kaikki kentät(author,title,year,publisher)

##### Hyväksymistestit
1. Viitettä ei luoda jos käyttäjän syötteessä on ääkkösiä.(Annetaan virheilmoitus)

2. Lisättävän viitteen oltava book-kategorian viite.

3. Jos käyttäjä jättää pakollisen kentän täyttämättä annetaan virhe ilmoitus

4. Viite luodaan, jos käyttäjä täyttää book-kategorian kaikki syötteet ja ilman ääkkösiä

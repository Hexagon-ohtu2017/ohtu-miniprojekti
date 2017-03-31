# ohtu-miniprojekti

[![Build Status](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti.svg?branch=master)](https://travis-ci.org/Hexagon-ohtu2017/ohtu-miniprojekti)

## Dokumentaatio

## 1. Sprintin User storyt ja hyväksymistestit

**Käyttäjä pystyy generoimaan bibTex-tiedoston

Hyväksymistestit
*Viiteistä muodostetaan bibTex-tiedosto
*Ainakin yksi viite on oltava luotuna, jotta tiedosto voidaan luoda

**Käyttäjä pystyy lisäämään book-tyyppisen viitteen ilman ääkkösiä ja
täyttämällä kaikki kentät(author,title,year,publisher)

Hyväksymistestit
*Viitettä ei luoda jos käyttäjän syötteessä on ääkkösiä.
(Annetaan virheilmoitus)

*Lisättävän viitteen oltava book-kategorian viite.

*Jos käyttäjä jättää pakollisen kentän täyttämättä annetaan virhe ilmoitus

*Viite luodaan, jos käyttäjä täyttää book-kategorian kaikki syötteet ja ilman ääkkösiä

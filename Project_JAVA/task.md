# Zadaní Samostatného Projektu PC2T-2022

Předpokládejme databázi studentů univerzity, kde každý student má svoje identifikační číslo, jméno, příjmení a datum narození. Každý student může dostat libovolný počet známek (standardní známkování 1 až 5), z nějž je počítán studijní průměr. Existují tři skupiny studentů:
1. Studenti technického oboru, kteří dokážou říci, zda byl rok jejich narození rokem přestupným.
2. Studenti humanitního oboru, kteří dokážou říci, v jakém znamení zvěrokruhu se narodili.
3. Studenti kombinovaného studia, kteří dokážou obojí výše zmíněné.


Při přijetí na univerzitu, je každý student zařazen do jedné z výše uvedených skupin. V průběhu studia není možné studenta přesunout do jiné skupiny.

Vytvořte v programovacím jazyce JAVA ve vývojovém prostředí Eclipse databázový program, který umožní uživateli následující:
1. Přidávat nové studenty - uživatel vždy provede výběr skupiny, do které chce studenta přiřadit, zadá jeho jméno a příjmení a rok narození. Následně je studentovi přiděleno identifikační číslo odvozené dle celkového pořadí přijímaných studentů.
2. Zadat studentovi novou známku – uživatel vybere studenta podle jeho ID a zadá požadovanou známku.
3. Propuštění studenta z univerzity – uživatel zadá ID studenta, který je odstraněn z databáze.
1. Nalezení jednotlivých studentů dle jejich ID a výpis ostatních informací (jméno, příjmení, rok narození, studijní průměr).
1. Pro vybraného studenta (dle ID) spustit jeho dovednost (viz rozdělení studentů dle oborů).
1. Abecedně řazený výpis všech studentů (dle příjmení) v jednotlivých skupinách (ID, jméno, příjmení, narození, studijní průměr).
1. Výpis obecného studijního průměru v technickém a humanitním oboru (společný průměr všechstudentů v daném oboru).
1. Výpis celkového počtu studentů v jednotlivých skupinách.
1. Načtení všech údajů ze souboru.
1. Uložení všech údajů do souboru.
1. Uložení informací o studentech do SQL databáze
1. Načtení informací o studentech z SQL databáze

**Pozn. SQL databáze je pouze doplňková vlastnost programu, tj. program musí být schopen pracovat i bez přítomnosti SQL databáze.**

[//]: <> (<br /> totok je prázdný řádek)
<br /> 



Program musí dále obsahovat následující:
- [ ] Efektivní využití základních vlastností OOP.
- [x] Alespoň jednu abstraktní třídu nebo rozhraní
- [x] Alespoň jednu dynamickou datovou strukturu

<br /> 

<style type="text/css">
    ol { list-style-type: lower-alpha; }
    ol ol {list-style-type: upper-alpha; }
</style>

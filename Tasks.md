# Checklista

## Klasa `sprzęt`

- ~~atrybuty~~
- połączenie z klasą `zlecenie zakupu`
- dziedziczenie po `ObjectPlus`

## Klasa `zlecenie zakupu`

- ~~atrybuty~~
- połączenie z klasą `sprzęt`
- połączenie z klasą `oprogramowanie`
- dziedziczenie po `ObjectPlus`

## Klasa `sprzęt pracowniczy`

- ~~atrybuty~~
- ~~połączenia z klasą `pracownik`~~
- ~~dziedziczenie po `sprzęt`~~

## Klasa `sprzęt serwerowni`

- ~~dziedziczenie po `sprzęt`~~
- ~~atrybuty~~

## Klasa `pracownik`

- ~~atrybuty~~
- ~~połączenie z klasą `sprzęt pracowniczy`~~
- dziedziczenie po `ObjectPlus`

## ~~Klasa `szafa rack`~~

- ~~atrybuty~~
- ~~dziedziczenie po `sprzęt serwerowni`~~
- ~~kompozycja z klasą `serwer`~~
  - ~~kwalifikator~~

## Klasa `serwer`

- ~~atrybuty~~
- ~~dziedziczenie po `sprzęt serwerowni`~~
- kompozycja z klasą 
  - `szafa rack`
  - ~~`maszyna wirtualna`~~
  - `komputer`

## Klasa `maszyna wirtualna`

- ~~atrybuty~~
- ~~kompozycja z klasą `serwer`~~
- dziedziczenie po `ObjectPlus`

## Klasa `laptop`

- ~~atrybuty~~
- ~~dziedziczenie po `sprzęt pracownika`~~
- kompozycja z klasą `komputer`

## ~~Klasa `monitor`~~

- ~~atrybuty~~
- ~~dziedziczenie po `sprzęt pracownika`~~

## Klasa `komputer`

- ~~atrybuty~~
- kompozycja z klasą:
  - `serwer`
  - `laptop`
- dziedziczenie po `ObjectPlus`

## Klasa `oprogramowanie`

- atrybuty
- asocjacja z klasą:
  - `komputer`
  - `zlecenie zakupu`
- dziedziczenie po `ObjectPlus`

## Klasa `licencjonowane`

- atrybuty
- dziedziczenie po `oprogramowanie`

## Klasa `bez licencji`

- dziedziczenie po `oprogramowanie`
Do odpalenia projektu wystarczy zaintsalowana Java, Maven oraz Gradle, oprócz projektu należy dla pełnej funkcjonalności wgrać baze danych.

Dzięki Mavenowi, wszelkie zależności zostaną pobrane automatycznie!
# `/zupki`

## GET

Żądanie zwracania obiekt JSON z zawartością wszystkich obiektów w bazie danych

## POST
Żądanie wstawia nowy rekord do bazy na podstawie danych w formie JSON z Body. Wartość ta to tablica z obiektami w formie `"{nazwa kolumny}": {wartość}`. Wartość to jedna z typów: `null, INT, String` zgodnie ze standartem JSON. Kolumna typu ID z autoinkrementacją może przyjąć wartość `null` co spowoduje automatyczne przydzielenie wartości przez serwer bazy danych. Serwer zwraca id nowego obiektu wraz z kodem 201 (Created) jeśli żądanie zostało pomyślnie wykonane. W przypadku błędnych danych zwraca kod 400 (Bad Request)
Przykładowa zawartość body:
```JSON
    {
        {
            "marka" : "Vifon",
            "smak" : "Ramen",
            "pochodzenie" : "Japonia",
            "waga" : 300,
            "cena_hurtowa" : 2.3
        }
    }
```

# `/zupki/{id}`

## PUT
Żądanie na podstawie id wyszukuje obiekt w bazie danych i aktualizuje dane na podstawie obiektu JSON przesłanego w body, w przypadku braku w bazie danych obiektu o podanym id metoda tworzy nowy obiekt z podanymi danymi i wysyła go do bazy danych i wysyła status CREATED

## PATCH
Żądanie służy tylko do aktualizacji danych konkretego rekordu. Rekord ten jest indentyfikowany za pomocą kolumny ID. Dane są w formie JSON w Body żądanie w postaci tablicy wartości do aktualizacji. Musi zawierać danych do każdej kolumny. Serwer zwraca status OK w przypadku powodzenia, 400 (Bad request) w przypadku błędnych danych. W przypadku podanie nieistniejącego ID. 
Przykładowa zawartość body:
```JSON
    {
        {
            "marka" : "Vifon",
            "smak" : "Ramen",
            "pochodzenie" : "Japonia",
            "waga" : 300,
            "cena_hurtowa" : 2.3
        }
    }
```

## DELETE
Żądanie usuwa wybrany rekord po ID. Wartośc ta jest przesyłana za pomocą parametru URL `id` i jest typu INT. Serwer zwraca status OK w przypadku powodzenia, NOT_FOUND w przypadku błędnych danych.

## GET
Żądanie zwraca obiekt o id podanym w parametrze URL
```


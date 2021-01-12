# BookLib

### O aplikacji

Aplikacja obsługuje bazę danych biblioteki. Dzięki niej możemy z łatwością
zapoznać się z rankingiem literatów, znaleźć książkę po jej numerze ISBN, czy
zapoznać się z książkami z interesującej nas kategorii.

### Opis frameworka (Spring)

Spring - platforma dedykowana do tworzenia w Javie. Framework ułatwia
tworzenie i zarzadzanie obiektami dzięki swojemu kontenerowi IoC, który między innymi
pozwala nam wstrzykiwać zależności. Spring ułatwia również swoim użytkownikom dostęp do baz danych,
udostępniając nam metodyt CRUD (create, read, update, delete). Dzięki CRUDowi możemy za pomocą kilku
interfejsów zarządzanie bazą danych.

### Opis frameworków do testów 

- JUnit 5 jest javowym frameworkiem do towrzenia testów jednostkowych. Za pomocą klas i metod testowych,
które są odzielone głównego kodu aplikacji, możemy przetestować działanie naszych klas i metod wykorzystywanych w kodzie zródłowym.
Dużym plusem stosowania JUnit są bardzo czytelne raporty tworzone podczas testów.

- Mockito - bilbiotek pozwalająca utworzyć zamockowany obiekt, czyli taki któremu narzucamy z góry jego zachoanie bez tworzenia jego prawdziwej instacji.

### Wzorce projektowe

- Builder - znacznie ułatwia tworzenie klas o dużej ilości pól, takich klasy encji.
- Fabryka - ułatwia tworzenie rożnych obiektów o tym samym interfejsie. Fabryki wykorzystuje do tworzenia
odpowiednich korzenie JSONa. Zapobiega to również poniekąd łamaniu zasady DRY - nie powtarzam kilka razy tej samej 
   ścieżki do odpowiedniego korzenia.
   
### Uruchamianie

- Aby stworzyć zasoby w bazie danych należy wejść na "localhost:8080/"
- ENDPOINT do znalezienia książki na podstawie numery znajduję się pod adresem
   "localhost:8080/isbn/{numer książki}"
    
- ENDPOINT do znalezienia książek w danej kategorii pod adresem "localhost:8080/categories/{kategoria}"
- ENDPOINT do rankingu autorów znajduję się pod adresem "localhost:8080/isbn/ranking"

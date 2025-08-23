# Teaminformationen
- **Teamname**: DangerRanger  
- **Challenge**: Transgourmet Prodega – Die perfekte Einkaufsliste  

---

# Technische Informationen für die Jury

## Aktueller Stand des Sourcecodes
👉 [GitHub Repository](https://github.com/jhaldimann/baern-haeckt-2025-choerbli/tree/main)

---

## Ausgangslage
Unsere Anwendung unterstützt eine Gruppe von Personen bei der Planung eines Ausflugs oder eines gemeinsamen Abends.  
Ziel ist es, **die Einkaufsliste kollaborativ zu erstellen**, damit alle Beteiligten ihre Präferenzen einbringen, sich für Beiträge entscheiden und am Ende eine faire Kostenaufteilung stattfindet.  

### Worauf habt ihr euch fokussiert?
- Einfache **User Experience** für das gemeinsame Planen.  
- **Gamification-Elemente** (Punkte, Ranking), um die Motivation zu steigern.  
- Transparente **Abrechnung der Ausgaben** (wer bezahlt wie viel, wer schuldet wem).  
- Saubere **technische Architektur**, damit die Lösung leicht erweiterbar bleibt.  

### Welche technischen Grundsatzentscheide habt ihr gefällt?
- **Backend mit Spring Boot** für Stabilität und schnelles API-Development.  
- **PostgreSQL** als relationale Datenbank für zuverlässige Datenspeicherung.  
- **REST-API** für klare Schnittstellen zwischen Frontend und Backend.  
- Einsatz von **MapStruct** für sauberes Mapping zwischen Entities und DTOs.  
- Fokus auf **Domain-getriebene Struktur** (Events, Votes, Items, Users).  

---

## Technischer Aufwand 

### Welche Komponenten und Frameworks habt ihr verwendet?
- **Java 21 mit Spring Boot** → Kern des Backends  
- **Spring Data JPA** → Datenbankzugriff  
- **PostgreSQL** → Persistenz  
- **MapStruct** → DTO-Mapping  
- **Lombok** → Boilerplate-Reduktion  
- **Maven** → Build- und Dependency-Management  
- **Angular 20** → Frontend  

### Wozu und wie werden diese eingesetzt?
- **Spring Boot** stellt REST-Endpunkte für die gesamte Funktionalität bereit.  
- **Spring Data JPA** vereinfacht das Repository-Layer durch automatisch generierte Queries.  
- **PostgreSQL** speichert Kategorien, Items, Votes, Users und Events.  
- **MapStruct** wandelt zwischen Datenbank-Entities und API-Datenobjekten.  
- **Angular 20** liefert eine moderne und reaktive Benutzeroberfläche.  
- **Gamification-Logik** wird im Backend implementiert (Ranking, Punkte).  

---

## Implementation

### Gibt es etwas Spezielles was ihr zur Implementation erwähnen wollt?
- Die **Vote-Logik** aggregiert Stimmen pro Kategorie und berechnet Summen sowie verbleibende Votes.  
- Ein **Ranking-System** ordnet Benutzer anhand ihrer Punkte und weist jedem einen Platz zu.  
- Für die **Abrechnung** wird der Gesamtbetrag aller Items berechnet, und anschließend die individuellen Beiträge und Restbeträge pro User.  
- Klare Trennung zwischen **Domain-Modellen** und **DTOs**, um API und interne Logik zu entkoppeln.  

### Was ist aus technischer Sicht besonders cool an eurer Lösung?
- Die **automatisierte Kostenaufteilung** inklusive Restbeträge ist robust umgesetzt.  
- Nutzung von **Java Streams** für elegante Aggregationen (z. B. Votes pro Kategorie, Ranking-Berechnung).  
- **Erweiterbarkeit**: Neue Kategorien oder zusätzliche Spielmechaniken (mehr Gamification) können leicht ergänzt werden.  

---

## Abgrenzungen / Offene Punkte

### Welche Abgrenzungen habt ihr bewusst vorgenommen und damit nicht implementiert? Weshalb?
- **Keine Authentifizierung/Autorisierung**: Für den Hackathon nicht notwendig, da Fokus auf Kernfunktionen.  
- **Keine mobile App**: Stattdessen ein responsives Web-Frontend geplant.  
- **Keine Zahlungsintegration**: Berechnung der Beträge ist implementiert, tatsächliche Zahlungsabwicklung (Twint, Kreditkarte etc.) bewusst ausgeklammert.  

---

# Event Registration API (Lab 7)

REST API на Spring Boot для работы со списком мероприятий в памяти.

## Как запустить

1. Откройте проект в IntelliJ IDEA или терминале в папке проекта.
2. Запустите `EventsApplication` или выполните команду:
   `./gradlew bootRun`
   (в Windows PowerShell: `.\gradlew.bat bootRun`).
3. Сервер запустится на `http://localhost:8080`.

## Эндпоинты

- `GET /events` — получить все события
- `GET /events/{id}` — получить событие по ID (`404`, если не найдено)
- `POST /events` — создать новое событие
- `PUT /events/{id}` — обновить событие по ID (`404`, если не найдено)
- `DELETE /events/{id}` — удалить событие по ID (`404`, если не найдено)

## Пример JSON-тела для POST / PUT

```json
{
  "title": "Test Event",
  "location": "Almaty"
}
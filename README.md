Project to introduce kotlin, Spring Boot, and more to build Stey tech stacks, to new comers.

---

For job applicants
 1. Clone the project
 2. Change default serialization of dates (java.util.Date and Instant) to Unix timestamp (in seconds)
 3. Add extra deserialization of dates format "YYYY-MM-DD" to Instant with time set at 00:00. A value of "2020-02-25" should be deserialized to "2020-02-25T00:00:00Z". Should work for request body and query params. Other formats of deserialization to Instant should still work.
 4. Add new serializer and deserializer in JSON for **Pageable** and **Sort** of Spring Data. Default jackson serialization is not appropriate for use. Propose a better format of serialization.
 5. Change global default **Pageable** values (size, page, param name, etc) for RestController methods parameters
 6. Issue a pull request for review


# Default json format of Pageable
```javascript
{
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "offset": 35,
    "pageSize": 5,
    "pageNumber": 7,
    "paged": true,
    "unpaged": false
}
```

# Default json format of Sort
```javascript
{
    "sorted": true,
    "unsorted": false,
    "empty": false
}
```

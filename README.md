Project to introduce kotlin, Spring Boot, and more to build Stey tech stacks, to new comers.

---

For job applicants
 1. Clone the project
 2. Change default serialization of dates (java.util.Date and Instant) to Unix timestamp (in seconds)
 3. Add extra deserialization of dates format "YYYY-MM-DD" to Instant with time set at 00:00. A value of "2020-02-25" should be deserialized to "2020-02-25T00:00:00Z". Should work for request body and query params.
 4. Add new serializer and deserializer in JSON for **Pageable** and **Sort** of Spring Data. Default jackson serialization is not appropriate for use.
 5. Change global default **Pageable** values (size, page, param name, etc) for RestController methods parameters
 6. Issue a pull request for review

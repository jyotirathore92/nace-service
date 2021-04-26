NACE service comes with adding and retrieving of NACE data in the database using RESTAPIs.

Technologies used:

Database: In-memory H2 database
Database scripts: Flyway
Rest Client: Swagger UI
For mapping DTO's to models: Mapstruct

You might run into an issue while starting the application after building in Eclipse IDE due to mapper implementation.
To resolve it, add the target -> generated sources -> annotations folder present in target folder to your build path.

Since, authentication has been implemented using in memory username and password credentials, you might see a pop up while accessing the APIs.
The credentials are present in SecurityConfig file.

Sample request for putNaceDetails api is:

{
  "code": "1",
  "description": "Test",
  "itemsExcluded": "",
  "itemsIncluded1": "item1",
  "itemsIncluded2": "item2",
  "level": 1,
  "orderNumber": 1,
  "parent": "A",
  "referenceIsicRev4": "A",
  "rulings": ""
}

While setting up the project for the first time, you may face compile time issue due to absence of lombok dependency in the IDE.
Attaching the lombok dependency along with the project.

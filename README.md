

## How to Launch

1. Execute ./run-hsqldb-server.sh to start the DB
2. Execute ./show-hsqldb.sh
3. Run RestServer.java in Eclipse
4. Enter desired url into Browser bar

## What Works ?

This git repository is for questions 6 through 8 of TP2 in TAA class.

Because of time constraints I haven't implemented every business class into a resource class for the RESTful WebServices. But I have added a few to demonstrate how I did it.

There are 3 Resources that communicate with the DAOs, they all have basic CRUD methods, with fiche having a few extras:

- FicheResource (The resource used for making Cards) you can make new cards from JSONs and also add users and tags to them through the specific URIs which are availble through http://localhost:8080/api/
- TagResource, just the classic CRUD methods with swagger descriptions
- UserResource, just the classic CRUD methods with swagger descriptions


URI examples: 
- POST: http://localhost:8080/user/add adds the user specified in JSON format in the HTTP request body to the DataBase.
- GET: http://localhost:8080/fiche/1 gets the card with an id of 1
- PUT: http://localhost:8080/fiche/1/addtag/3 adds the tag with id=3 to the card with id=1
- DELETE: http://localhost:8080/user/delete/10 deletes user with id=10

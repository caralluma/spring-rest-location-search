# spring-rest-location-search
Egnyte</br>
Description</br>
You are supposed to create a REST service which will return a place or a list of places at a given</br>
location. You should use Facebook Graph API as your source of data.</br>
The service should have the following endpoint:</br>
GET /{country}/{city}/{string describing what one is looking for}</br>
Every single place should contain the following information:</br>
{ </br>
     “name”: <string>, </br>
     “latitude”: <float>, </br>
     “longitude”: <float> </br>
} </br>
Example</br>
Request: GET /poland/poznan/egnyte</br>
Response:</br>
{ </br>
     “name”: “Egnyte Poland”, </br>
     “latitude”: 52.404167557908, </br>
     “longitude”: 16.940044275923 </br>
} </br>
Deliverables</br>
1.</br>
The service that meets all requirements described above. Moreover, you are expected</br>
to come up with a solution for handling situations where there are at least two cities</br>
with the same name within the same country. Error handling should also be in place.</br>
2.</br>
The project may be delivered via e-mail in a zip attachment or via GitHub, GitLab or</br>
Bitbucket. It must include the entire source code and all relevant dependencies in order</br>
to build it locally. Tests to prove the project and major code flows work.</br>

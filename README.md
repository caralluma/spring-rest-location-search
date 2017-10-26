# spring-rest-location-search
Egnyte
Description
You are supposed to create a REST service which will return a place or a list of places at a given
location. You should use Facebook Graph API as your source of data.
The service should have the following endpoint:
GET /{country}/{city}/{string describing what one is looking for}
Every single place should contain the following information:
{
     “name”: <string>,
     “latitude”: <float>,
     “longitude”: <float>
}
Example
Request: GET /poland/poznan/egnyte
Response:
{
     “name”: “Egnyte Poland”,
     “latitude”: 52.404167557908,
     “longitude”: 16.940044275923
}
Deliverables
1.
The service that meets all requirements described above. Moreover, you are expected
to come up with a solution for handling situations where there are at least two cities
with the same name within the same country. Error handling should also be in place.
2.
The project may be delivered via e-mail in a zip attachment or via GitHub, GitLab or
Bitbucket. It must include the entire source code and all relevant dependencies in order
to build it locally. Tests to prove the project and major code flows work.

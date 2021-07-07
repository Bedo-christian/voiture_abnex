# voiture_abnex
veuillez suivre l'instruction suivante pour faire marcher nos API :

créer un base de données sur mysql : "vente_voiture"

Compiler le projet soit avec IntellIj ou commande mvn compile

#Si tout va bien, vous pouvez utiliser le web service sur postman en respectant toutes les formats et l'endPoint Suivante

# Ajouter un utilisateur avec son mot de passe :
méthode : post
Endpoint : http://localhost:8080/register
Input :
{
	"username":"thierry@me.com",
	"firstname":"Moa",
	"lastname":"Christian",
	"email":"thierry@me.com",
	"password":"1234"
}
ouptut : success si ok


# list des utilisateur sans authentifier
method : get,
endpoint : http://localhost:8080/user/list
output:
 [   {
        "iduser": 1,
        "firstname": "Moa",
        "lastname": "Christian",
        "email": "thierry@me.com",
        "username": "thierry@me.com",
        "password": "$2a$10$swA01MnyRqv36dt/6Wjzk.zxWbU.CGWYlyukWKY1.l9HvxAUpOIFW",
        "roles": []
    }
]

# Login pour avoir le token d'authentification 
méthode : post,
endpoint : http://localhost:8080/login
input :
{
	"email":"thierry@me.com",
	"password":"1234"
}

output si success :
{
    "tokenType": "Bearer",
    "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0aGllcnJ5QG1lLmNvbSIsImlhdCI6MTYyNTY2Nzg0MiwiZXhwIjoxNjI1NjgyMjQyfQ.K3WwbOIJ-56Lo6aNeQl06jmeb196oRS4cWrf0zKrkx_-yMi4Bc9XoYXgvz3Kj6qp2P9Y8XzSHzqOIIX4RIn28Q"
}


#Ajout voiture besoin de token
method : post,
endpoint : http://localhost:8080/ajout-voiture
input :
{
    "name": "Sprinter",
    "description":"mavo2 mena",
    "price":"10.5"
}
ouptut success si ok,

#List de toutes les voitures
method : get
endpoint : http://localhost:8080/voiture/list
output si success :
[
    {
        "id": 2,
        "name": "voit name2",
        "description": "voiture des2",
        "price": 20.0
    }
]

# Ajout commentaire besoin de token
method : post
endpoint: http://localhost:8080/ajout-commment
input :
{
    "description":"comment description",
    "voiture_id":1
}


output success si tout est ok :

# list commentaire par Id voiture
 method : get,
 endpoint : http://localhost:8080/voiture/coms-list/1
 output :
 [
    {
        "id": 1,
        "description": "comment description",
        "user": {
            "iduser": 5,
            "firstname": "Moa",
            "lastname": "Christian",
            "email": "thierry@me.com",
            "username": "thierry@me.com",
            "password": "$2a$10$swA01MnyRqv36dt/6Wjzk.zxWbU.CGWYlyukWKY1.l9HvxAUpOIFW",
            "roles": []
        },
        "createdAt": "2021-07-07T11:47:43.000+00:00",
        "voiture": {
            "id": 1,
            "name": "voit name",
            "description": "voiture des1",
            "price": 10.0
        }
    }
]    



















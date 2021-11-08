# sso
Spring boot oauth2 mysql, swagger/open-api, bearer token


How to use :
1. import database
2. checkout and then clean build... run app and tadaa.... http://localhost:8082/swagger-ui/
Secure open api with token access
![image](https://user-images.githubusercontent.com/50345887/140694150-6934ab2a-fc92-4bab-8599-a713ac582967.png)

How to generate token? cek database import data
here example :
POST /oauth/token HTTP/1.1
Host: localhost:8082
Authorization: Basic dGVzOnRlcw==
Cache-Control: no-cache
Postman-Token: 94601e5a-f28c-8b82-9d25-6441a352fcb3
Content-Type: application/x-www-form-urlencoded

grant_type=refresh_token&client_id=tes&refresh_token=DVtjC8YO4Og49XzzlDyIR9ZI4ac


result :
{
    "access_token": "zIKH_Po91nRA5spFlnCBBylwSn0",
    "token_type": "bearer",
    "refresh_token": "f8zus60DIb8i5d8bmp8BrQFFlw0",
    "expires_in": 3599,
    "scope": "READ WRITE"
}


and then copy access_token into authorization bearer <token>
  ![image](https://user-images.githubusercontent.com/50345887/140694776-5f1a1626-02a9-41fc-b199-f840ada93898.png)

then, happy learning, happy hacking!!


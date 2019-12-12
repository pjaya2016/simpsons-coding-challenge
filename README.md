# simpsons-coding-challenge

## Get JWT Token - POST
### H- Content-Type - appliction/json
``` C#
/* Request */

{
	"username":"simpson",
	"password":"password"
}

/* Response */

{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzaW1wc29uIiwiZXhwIjoxNTc2MTYzMDg0LCJpYXQiOjE1NzYxNDUwODR9.2aUObVhy6RxtpjsIoMf5ynnoKesQSsuufHV9mUXn3W4426GBXICAQfUGK31Bs2v0u0VO2VSCX0m-9f8rzB1K6A"
}

```
## Get all phrases - GET
### H- Content-Type - appliction/json
### H- Authorization - Bearer ${Token}
*http://localhost:8083/api/v1/simpsonsphrases/phrases*
``` C#
{
    "data": [
        {
            "_id": "59edff64d9be8f7aa11e0c44",
            "character": "59edee68706374dfa957842f",
            "phrase": "Wait a minute. Bart’s teacher is named ‘Krabappel’? Oh, I’ve been calling her ‘Crandall.’ Why didn’t anyone tell me? Ohhh, I’ve been making an idiot out of myself!"
        }
    ]
}
```

## Get specifics phrases - GET/ID
### H- Content-Type - appliction/json
### H- Authorization - Bearer ${Token}
*http://localhost:8083/api/v1/simpsonsphrases/phrases/59edff64d9be8f7aa11e0c44*
``` C#
{
    "_id": "59edff64d9be8f7aa11e0c44",
    "character": "59edee68706374dfa957842f",
    "phrase": "Wait a minute. Bart’s teacher is named ‘Krabappel’? Oh, I’ve been calling her ‘Crandall.’ Why didn’t anyone tell me? Ohhh, I’ve been making an idiot out of myself!"
}
```

## Update specifics phrases - PUT/ID
### H- Content-Type - appliction/json
### H- Authorization - Bearer ${Token}
*http://localhost:8083/api/v1/simpsonsphrases/phrases/59edff64d9be8f7aa11e0c44*
``` C#
{
    "_id": "59edff64d9be8f7aa11e0c44",
    "character": "59edee68706374dfa957842f",
    "phrase": "Updated !!!"
}
```

## Create phrases - POST
### H- Content-Type - appliction/json
### H- Authorization - Bearer ${Token}
*http://localhost:8083/api/v1/simpsonsphrases/phrases*
``` C#
{
    "_id": "randomId1",
    "character": "59edee68706374dfa957842f",
    "phrase": "Updated 2 !!!"
}
```

## Delete specifics phrases - DELETE/ID
### H- Content-Type - appliction/json
### H- Authorization - Bearer ${Token}
*http://localhost:8083/api/v1/simpsonsphrases/phrases/randomId1*


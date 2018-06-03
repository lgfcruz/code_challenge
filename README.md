# code_challenge
This project is part of a Coding Challenge from Statflo for VanHack Leap.
<br/>
This is the Java server code repository that implements a simple application which works with two REST APIs.



This project was built over very well known and trusted technologies and frameworks:

 - Java 8;
 - Spring Boot;
 - H2 Database;
 - Data-Rest;
 - JPA;
 - Maven.
 
 If you need to apply any changes in the project, such as server port, you can do so by modifying applications.properties file located at "code_challenge/src/main/resources" directory.
 <br />
 <br />
 Since this project is managed by Maven, you can generate a build of it by entering the following command in terminal (make sure you are in the same directory where project's pom.xml file is):

    mvn clean package

This command will generate a .jar file named "code_challenge.jar" in a folder called "target" inside the project's directory.
<br />
In order to run the build, enter the following command line in terminal (make sure you are in the same directory where code_challenge.jar file is):

    java -jar code_challenge.jar

Once the system is up and running if you haven't made any changes in applications.properties, it is possible to access it by the URI http://localhost:8080

## API REST endpoints

### 1. User

Suppose the user object only has three properties: id, name and role.

##### 1.1. GET all users
	1. URL (GET): http://server_ip:server_port/users

	2. JSON response (example)

```
[
    {
        "id": 1,
        "name": "java beans",
        "role": "foo"
    },
    {
        "id": 2,
        "name": "java beans",
        "role": "foo"
    },
    {
        "id": 3,
        "name": "panda python",
        "role": "bar"
    }
]
```

##### 1.2. GET all users who have the role attribute informed 
	1. URL (GET) (example): http://server_ip:server_port/users/?role=foo

	2. JSON response (example)

```
[
    {
        "id": 1,
        "name": "java beans",
        "role": "foo"
    },
    {
        "id": 2,
        "name": "java beans",
        "role": "foo"
    }
]
```

##### 1.3. POST new user
	1. URL (POST): http://server_ip:server_port/users

	2. request body (example) - optional

```
{
	"name": "java beans", 
	"role": "foo"
}
```

	3. JSON response (example)

```
{
    "id": 2,
    "name": "java beans",
    "role": "foo"
}
```


## License
 
Copyright (c) 2018 Luiz Guilherme Cruz (https://github.com/lgfcruz)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sub-license, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 
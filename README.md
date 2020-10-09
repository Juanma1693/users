¡¡¡¡¡¡IMPORTANTE!!!!!!!
los diagramas se encuentran en \users\Diagram

INSTALACION 

con la cosola ubicarse en la carpeta raiz del proyecto ejecutar "gradle build" al finalizar tendra un archivo "users-0.0.1-SNAPSHOT.war" 
en la carpeta \users\build\libs este archivo debe ser cargado en un tomcat

INSTRUCCIONES DE USO

url
localhost:8090/users 

post (crear usuario): recibe un json con las siguientes caracteristicas  
{
	"name" : "Juan Rodriguez" ,
	"email" : " juan@rodriguez.org " ,
	"password" : "As12" ,                              
	"phones" : [
		{
			"number" : "1234567" ,
			"citycode" : "1" ,
			"contrycode" : "57"
		}
	]
}
* password debe contener Una Mayúscula, letras minúsculas, y dos números.
* email espera un formato correcto ( aaaaaaa@dominio.cl )

get (listar usuarios): no recibe parametros y retorna el total de usuarios registrados

put (actualizar usuario) recibe un json con las siguientes caracteristicas  
{
	"id" : "61bef1d3-c63d-4983-9103-4519dd794301" ,
	"name" : "Juan Rodriguez" ,
	"email" : " juan@rodriguez.org " ,
	"password" : "As12" ,                              
	"phones" : [
		{
			"number" : "1234567" ,
			"citycode" : "1" ,
			"contrycode" : "57"
		}
	]
}
* password debe contener Una Mayúscula, letras minúsculas, y dos números.
* email espera un formato correcto ( aaaaaaa@dominio.cl )

delete (eliminar usuario) recibe un json con las siguientes caracteristicas  
{
	"id" : "61bef1d3-c63d-4983-9103-4519dd794301" ,
}

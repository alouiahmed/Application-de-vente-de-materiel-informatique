# Application-de-vente-de-materiel-informatique
Projet : Application vente de matèriel informatique


### Project architecture

![image](https://user-images.githubusercontent.com/60757235/139142686-251d765e-f4be-401a-9f89-07cc5482f6cc.png)


### 5 microservices:

*user-service (port:8811)

*product-service(port:8010)

*recommandation-service(port:8081)

*order-service(port:8084)

*reclamation-service avec nodejs et monogoDB (port:5000)

### les serveurs:

*eureka-server(port:8761)

*config-server(port:8888)

*gateway-service(port:8762)


******************
### links to test the project:

serveur eureka : http://(localhost ou adresseIP):8761/

****************
### user-service:

http://(localhost ou adresseIP):8811/users

gateway : http://(localhost ou adresseIP):8762/user-service/users

config : http://(localhost ou adresseIP):8888/user-service/default

*************
### product-service:

http://(localhost ou adresseIP):8010/products

gateway :  http://(localhost ou adresseIP):8762/product-service/products

config : http://(localhost ou adresseIP)/product-service/default

***************

### recommandation-service:

http://(localhost ou adresseIP):8081/recommandations

gateway :  http://(localhost ou adresseIP):8762/recommandation-service/recommandations

config : http://(localhost ou adresseIP):8888/recommandation-service/default

******************


### order-service:

http://(localhost ou adresseIP):8084/orders

gateway : http://(localhost ou adresseIP):8762/order-service/orders

config : http://(localhost ou adresseIP):8888/order-service/default

*******************
### reclamation-service:

http://(localhost ou adresseIP):5000

http://(localhost ou adresseIP):5000/api/reclamation

*********************
### gateway-service:

config : http://(localhost ou adresseIP):8888/zuul-service/default
*************
### command to delete all images:

docker rmi recommandation-service user-service config-server gateway-server product-service discovery-service order-service










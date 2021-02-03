# IG2I-LA2-POO-GEOCACHE
*Mathis Haloy - François Dourlens-Monchy*

## Architecture

Notre projet possède l'arborescence suivante : 

```
├───application
├───domain
│   ├───cache
│   ├───utilisateur
│   └───visite
├───infrastructure
│   └───mysql
│       ├───cache
│       ├───utilisateur
│       └───visite
└───services
```
Le package `application` contient les classes de présentation et d'interface console. Celles-ci utilisent des implémentations de `services` contenues dans le package du même nom.
Ces services implémentes des interfaces du `domain`, le quel contient également nos classes métiers et la définition des interfaces de repository. Les `services` utilisent ces repository qui sonbt implémentés dans le package `infrastructure`.
On possède ainsi une découpe 3-tiers entre :
+ La couche de présentation `application`
+ La couche métier qui possède les classes et services métiers `domain` et `services`
+ La couche d'accès aux données `infrastrucutre`

Ainsi les classes métiers sont utilisées dans toutes les couches, la couche d'accès aux données n'a pas connaissance de la couche de présentation et inversement.

![UML](CacheUML.png)

## Lancer l'application

### Maven

Utiliser les commandes Maven `clean` et `install` depuis l'IDE ou depuis un terminal à la racine projet pour télécharger les dépendances du projet

### Base de données

#### MariaDB

Configuration : 
`src/main/resources/application.properties`
```
spring.datasource.url=jdbc:mariadb://localhost:3306/db_name
spring.datasource.username=username
spring.datasource.password=password
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
```

Initialiser la base avec le fichier SQL suivant :
`sql/init.sql`

#### MySQL

TODO

#### MongoDB

TODO

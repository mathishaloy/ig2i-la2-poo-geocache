# IG2I-LA2-POO-GEOCACHE
*Mathis Haloy - François Dourlens-Monchy*

## Lancement

A la racine du projet :

```bash
mvn clean install
```
Pour lancer l'application mocké (Fonctionelle sans base de données)
```bash
java -jar target/*.jar
```
Pour lancer l'application avec un SGBD particulier
```bash
java -Dspring.profiles.active=mariadb -jar target/*.jar
java -Dspring.profiles.active=mongodb -jar target/*.jar
```

## Architecture

### UML et Métier

Notre projet possède l'arborescence suivante : 

```
├───application
├───domain
│   ├───cache
│   ├───utilisateur
│   └───visite
├───infrastructure
│   ├───mock
│   │   └───cache
│   ├───mongodb
│   │   ├───cache
│   │   └───utilisateur
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

### Springboot

Dans ce nos projet nous avons utilisé le framework springboot qui permet de lancer l'application et de manipuler nos classes Java
afin d'injecter les dépendances automatiquements. Globalement, quand on définit l'attribut `cacheService` suivant dans la classe ```GeocacheConsole```
```java
@Component
@RequiredArgsConstructor
public class GeocacheConsole implements CommandLineRunner {

    private final CacheService cacheService;
    
    // ...
}
```
Alors sprinboot va scanner l'ensemble du projet afin de trouver une implémentation de cette interface ```CacheService```
afin de l'y injecter. Rien de si magique puisque Spring va appeler le constructeur définit par l'annotation `@RequiredArgsConstructor` de lombok
qui génère le code du constructeur au moment de la compilation comme suit :

```java
public GeocacheConsole(CacheService cacheService) {
    this.cacheService = cacheService;
}
```
Springboot va donc appeler ce constructeur au moment où il manipulera la classe `GeocacheConsole` en injectant l'implémentation
de l'interface `CacheService`, dans le cas présent `CacheServiceImpl`. Spring reconnait cette implémentation grace à l'annotation
`@Service` qu'elle possède : (`@Service`, `@Repository` et `@Component` servent à marquer une classe comme injectable)
```java
@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final CacheRepository cacheRepository;
    
    // ...
}
```
Etant donc manipulée par Spring, l'attribut `CacheRepository` de cette classe se verra donc injecté avec l'implémentation candidate aqéuate
de la même manière que précedemment etc ...

### Spring data jpa

De la même manière que Sprinboot, Spring data JPA va nous aider et rajouter de l'abstraction dans la couche d'accès aux données.
Dans le cas présent, pas de déclaration d'EntityManager à manipuler à la main. L'ensemble est géré par ce framework.

Simplement en créant une interface, par exemple ici `CacheJpaRepository` qui étend `JpaRepository<T,ID>` :
```java
@Repository
public interface CacheJpaRepository extends JpaRepository<CacheEntity, String> {
}
```
nous avons déjà accès à un ensemble de méthode abstraite définies par le framework qui nous permettent d'accéder à la données, à savoir :

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {
    List<T> findAll();

    List<T> findAll(Sort var1);

    List<T> findAllById(Iterable<ID> var1);

    <S extends T> List<S> saveAll(Iterable<S> var1);

    void flush();

    <S extends T> S saveAndFlush(S var1);

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    T getOne(ID var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);
}
```

Comme pour nos classes, spring injectera la bonne implémentation de l'interface `JpaRepository` en l'occurence la 
suivante définit dans le framework et qui possède bien un `EntityManager` :
```java
public class SimpleJpaRepository<T, ID> implements JpaRepositoryImplementation<T, ID> {
    private static final String ID_MUST_NOT_BE_NULL = "The given id must not be null!";
    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private final PersistenceProvider provider;
    // ...
}
```
> Comme quoi il n'y a vraiment rien de magique !

Ce faisant, on a simplement besoin d'appeler la méthode `findAll();` qui nous retira la liste de `CacheEntity` correspondante
à l'ensemble des caches stockées en base de données par exemple.

Les `JpaRepository` nous permettent aussi de répondre à des besoins plus spécifiques. Si on voulait faire une recherche
de caches plus poussée, avec des conditions et un certain ordre par exemple, alors on a simplement besoin d'écrire notre
méthode dans l'interface comme suit :
```java
List<CacheEntity> getCacheEntityByEtatAndNatureOrderByLatitudeDesc(Etat etat, Nature nature);
```

Ce faisant analyse le nom de cette méthode et comprend qu'on souhaite faire une recherche de cache par Etat et Nature,
de manière Ordonée décroissante par la Latitude.
# Application de Jeu de Cartes

Cette application a été développée pour présenter un jeu de cartes simple où un joueur tire une main de 10 cartes de manière aléatoire, puis les classe par couleur et valeur. La solution a été développée en utilisant Java avec Spring Boot pour le backend et Vue.js 3 pour le frontend, en utilisant un ensemble de dépendances mentionnées ci-dessous.

## Fonctionnalités Principales

- Un joueur peut tirer une main de 10 cartes de manière aléatoire.
- Les cartes sont classées par couleur et valeur.
- Authentification requise pour accéder à l'application : 
  - Login : player
  - Mot de passe : player

## Architecture du Projet

Le projet est organisé de la manière suivante :

- La partie frontend se trouve dans le répertoire `/CardGame/src/frontend`.
- La partie backend est située dans `/CardGame/src/main/java`.
- Les tests sont regroupés dans `/CardGame/src/test/java`.

## Compilation et Exécution

Pour compiler le projet, vous pouvez utiliser Maven. Exécutez la commande suivante :

```bash
mvn clean install -Dspring.profiles.active=dev
```
Pour exécuter le projet, vous avez plusieurs options :

- Utilisation du script Sh (Linux) : Naviguez jusqu'au répertoire du projet et exécutez sh CardGame.sh dev 0.0.1.
- Exécution sans le script Sh : Utilisez la commande suivante :
 
```bash
java -jar -Dspring.profiles.active=dev target/card-game-0.0.1.jar
```
## Dépendances Backend
Les dépendances utilisées dans le backend comprennent :
- Lombok
- JUnit
- Jackson

## Dépendances Frontend
Les dépendances utilisées dans le frontend sont listées ci-dessous :

- Bootstrap 5
- Vee-validate"
- Vue"
- Vue-router"
- Vue-tippy"
- Yup"
- @mdi/font"

##Tests
Les tests sont réalisés à l'aide de JUnit.


## Les screens de l'applications 
![1Screen](/AppGame.png)


![1Screen](/SecondScreenAppGame.png)

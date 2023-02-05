# API_Joueur_Archi_Hexagonale
l'application est basée sur une architecture hexagonale. C'est un modèle architectural utilisé dans la conception de logiciels. Il vise à créer des systèmes basés sur des composants d'application faiblement couplés et pouvant être facilement connectés à leur environnement logiciel via des ports et des adaptateurs.Ces composants sont modulaires et interchangeables, ce qui améliore la cohérence du traitement et facilite l'automatisation des tests.
 > ✨ Le principe de l'architecture hexagonale  ✨
> est d'isoler le domaine de toute dépendance, même d'une dépendance de framework.

![image description](relative/path/in/repository/to/image.svg)
![image description](relative/path/in/repository/to/image.svg)



## Fonctionnalités
- Récupérer un joueur par son identifiant
- Récupérer une liste de joueurs du meilleur classé au moins bon
- Récupérer une liste de statistiques suivantes :
IMC moyen des joueurs,Taille médian des joueurs,Pays avec le plus gros ratio de victoire

## Technologies


-  Java 17
- Spring Boot
- Swagge
- MapStruct
- Eclipse

## Installation

l'exécution de ce projet nécessite d'avoir sur votre poste :  

```sh
Git (pour récupérer le projet)
Maven (Récupérer les dépendances et la construction des jar du projet. )

```
> Note: `--Vérifier que l'api pour récupérer les données en JSON est fonctionnel ` [Joueur.json](https://data.latelier.co/training/tennis_stats/headtohead.json) 

## Plugins
Configurer Eclipse pour qu'il puisse exécuter MapStruct dans un projet java.
- Installer m2e-apt plugin (aller Help > Eclipse Marketplace ... et selectionner m2e-apt)
- ensuite aller dans windows -> preferences -> Maven > Annotation Processing et  Enable Project Specific Settings
- Le site qui résout ce problème [URL](https://manios.org/2017/08/09/configure-eclipse-in-order-to-build-mapstruct-in-java-projects) .


## Development

Diagramme en construction ...

![image description](relative/path/in/repository/to/image.svg)
![image description](relative/path/in/repository/to/image.svg)



## License

## Source
[SITE](https://medium.com/javarevisited/hands-on-hexagonal-architecture-with-spring-boot-ca61f88bed8b) .Pour comprendre plus en détaille comment fonctionne l'architecture hexagonale. 


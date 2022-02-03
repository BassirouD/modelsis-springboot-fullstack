# modelsis-springboot-fullstack
Projet Test Backend

Projet Mobile de gestion de produit

Ce repertoire contient les differentes implémentations sur le projet GED.

1. Le Connecteur situé dans le dossier `connector/` est une application en cours de développement avec le framework Django de python. Il sert essentiellement d'interface entre Alfresco et les autres applications web qui pourront utiliser ses services exposés via API. La raison principale de l'utilisation d'un connecteur est la non disponibilité de certains services clés dans Alfresco, notamment la création d'un document à partir d'un template incluant son remplisage avec de nouvelles données et ceci via API.
2. Le dossier `Templates` contient les différents templates des documents (Word et Excel) à générables dans Alfresco. Nous prévoyons d'implémenter un script qui les tranferéra automatiquement dans Alfresco. Ce script sera intégré au connecteur qui se chargera de le faire automatiquement pendant des intervales de temps réguliers.
3.
4.

## Procédure de déploiement
### 1. Déploiement du connecteur
Dévéloppement en cours

### 2. Déploiement de Alfresco
Se conférer à la documentation de déploiement de Alfresco disponible sur le lien:

### 3. Interconnection entre le connecteur et Alfresco

**Ce contenu sera completé dans les jours à venir**
